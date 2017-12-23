package traitement2017;

import java.util.Arrays;

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

		int positionDansLaListe = 0; // on commence à 0
		// création de la liste à hacher, de longueur longueurListe
		int[] liste = new int[longueurListe];
		for (int i = 0; i < longueurListe; i++) {
			liste[i]=i;
		}

		for (int i = 0; i < tab.length; i++) {
			int pas = 0;
			if(tab[i]%2==0){
				pas = tab[i]/2;
			} else {
				pas = (tab[i]-1)/2;
			}

			for(int j=0;j<pas;j++){
				int positionElementDebut = (positionDansLaListe+j)%liste.length;
				int positionElementFin = (positionDansLaListe+tab[i]-1-j)%liste.length;
				int nombre = liste[positionElementDebut];
				liste[positionElementDebut]=liste[positionElementFin];
				liste[positionElementFin]=nombre;
			}

			// calcul de la position pour laquelle on va commencer à la prochaine itération
			positionDansLaListe=(positionDansLaListe+tab[i]+i)%liste.length;
		}

		resultat=liste[0]*liste[1];
	}


}
