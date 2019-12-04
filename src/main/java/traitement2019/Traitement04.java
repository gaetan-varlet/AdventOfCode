package traitement2019;

import java.util.ArrayList;
import java.util.List;

public class Traitement04 {

	private int nombreSolutionsPart1;

	private int nombreSolutionsPart2;

	public int getNombreSolutionsPart1() {
		return nombreSolutionsPart1;
	}

	public int getNombreSolutionsPart2() {
		return nombreSolutionsPart2;
	}

	public void traitement(String input) {

		String[] debutFin = input.split("-");
		int debut = Integer.parseInt(debutFin[0]);
		int fin = Integer.parseInt(debutFin[1]);

		for (int i = debut; i <= fin; i++) {
			if (twoAdjacentDigits(i) && digitsNeverDecrease(i)) {
				nombreSolutionsPart1++;
			}

			if (twoAdjacentDigits(i) && digitsNeverDecrease(i) && twoAdjacentDigitsExactlyForAtLeastOneDigit(i)) {
				nombreSolutionsPart2++;
			}
		}

	}

	public boolean twoAdjacentDigits(int i) {
		char[] characters = String.valueOf(i).toCharArray();
		for (int c = 1; c < characters.length; c++) {
			if (characters[c] == characters[c - 1]) {
				return true;
			}
		}
		return false;
	}

	public boolean digitsNeverDecrease(int i) {
		char[] characters = String.valueOf(i).toCharArray();
		for (int c = 1; c < characters.length; c++) {
			if (characters[c] < characters[c - 1]) {
				return false;
			}
		}
		return true;
	}

	public boolean twoAdjacentDigitsExactlyForAtLeastOneDigit(int i) {
		char[] characters = String.valueOf(i).toCharArray();
		List<Integer> counts = new ArrayList<>();
		counts.add(1);
		for (int c = 1; c < characters.length; c++) {
			if (characters[c] == characters[c - 1]) {
				Integer nb = counts.get(counts.size() - 1);
				nb++;
				counts.set(counts.size() - 1, nb);
			} else {
				counts.add(1);
			}
		}
		// System.out.println(i + " : " + counts);
		if(counts.contains(2)){
			return true;
		}
		return false;
	}

}
