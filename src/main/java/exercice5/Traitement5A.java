package exercice5;

public class Traitement5A extends Traitement5 {

    @Override
    public void fichierFerme() {
	int position = 0;
	while(position<listeInteger.size()){
	    int valeurCourante = listeInteger.get(position);
	    listeInteger.set(position, valeurCourante+1);
	    position = position + valeurCourante;

	    nombreEtapeSortirListe++;
	}
    }

}
