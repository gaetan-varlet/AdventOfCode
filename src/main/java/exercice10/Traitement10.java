package exercice10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.LigneListener;

public class Traitement10 implements LigneListener{

	private int resultat;
	private int longueurListe;

	public int getResultat() {
		return resultat;
	}

	public void setLongueurListe(int longueurListe) {
		this.longueurListe = longueurListe;
	}


	@Override
	public void ligneLue(String ligne) {

		String[] tabString = ligne.split(",");
		int[] tab = Arrays.asList(tabString).stream().mapToInt(Integer::parseInt).toArray();
		System.out.println(Arrays.toString(tab));

		int positionDansLaListe = 0; // on commence à 0
		// création de la liste à hacher, de longueur longueurListe
		List<Integer> liste = new ArrayList<>();
		for (int i = 0; i < longueurListe; i++) {
			liste.add(i);
		}
		System.out.println(liste.size());


		for (int i = 0; i < tab.length; i++) {	
			// Tri dans la liste


			// Calcul du pas
			int pas = tab[i] + i;
			// calcul de la position pour laquelle on va commencer à la prochaine itération
			positionDansLaListe=positionDansLaListe+pas;
		}

		resultat=liste.get(0)*liste.get(1);
	}

}
