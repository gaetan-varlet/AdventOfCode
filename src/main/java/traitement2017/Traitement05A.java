package traitement2017;

public class Traitement05A extends Traitement05 {

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
