package traitement2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.ClotureListener;
import utils.LigneListener;

public class Traitement04 implements LigneListener, ClotureListener {
	
	private int resultat;
	private List<String> listeDonnees = new ArrayList<>();
	
	public int getResultat() {
		return resultat;
	}

	@Override
	public void ligneLue(String ligne) {
		listeDonnees.add(ligne);
	}

	@Override
	public void fichierFerme() {
		Collections.sort(listeDonnees);
		System.out.println(listeDonnees);
	}

}
