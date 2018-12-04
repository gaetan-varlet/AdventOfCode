package traitement2018;

import utils.ClotureListener;
import utils.LigneListener;

public class Traitement03 implements LigneListener, ClotureListener {
	
	private int[][] tableau = new int[2000][2000];
	private int resultat;
	
	public int getResultat() {
		return resultat;
	}

	@Override
	public void ligneLue(String ligne) {
		
	}

	@Override
	public void fichierFerme() {
		System.out.println(tableau.length);
		for(int i = 0 ; i < tableau.length ; i++) {
			for(int j = 0 ; j < tableau.length ; j++) {
				if(tableau[i][j] > 1) {
					resultat++;
				}
			}		
		}
	}

}
