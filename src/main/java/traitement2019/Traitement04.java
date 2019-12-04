package traitement2019;

public class Traitement04 {

	private int nombreSolutions;

	public int getNombreSolutions() {
		return nombreSolutions;
	}

	public void traitement(String input) {

		String[] debutFin = input.split("-");
		int debut = Integer.parseInt(debutFin[0]);
		int fin = Integer.parseInt(debutFin[1]);

		for (int i = debut; i <= fin; i++) {
			if (twoAdjacentDigits(i) && digitsNeverDecrease(i)) {
				nombreSolutions++;
			}
		}

	}

	public boolean twoAdjacentDigits(int i) {
		char[] characters = String.valueOf(i).toCharArray();
		for (int c = 1; c < characters.length; c++) {
			if(characters[c] == characters[c-1]){
				return true;
			}
		}
		return false;
	}

	public boolean digitsNeverDecrease(int i) {
		char[] characters = String.valueOf(i).toCharArray();
		for (int c = 1; c < characters.length; c++) {
			if(characters[c] < characters[c-1]){
				return false;
			}
		}
		return true;
	}

}
