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

		String[] tab = ligne.split(",");
		System.out.println(Arrays.toString(tab));
		
		// création de la liste à hacher, de longueur longueurListe
		List<Integer> liste = new ArrayList<>();
		for (int i = 0; i < longueurListe; i++) {
			liste.add(i);
		}
		System.out.println(liste.size());

	}

}
