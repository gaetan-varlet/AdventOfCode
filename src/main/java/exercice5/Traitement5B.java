package exercice5;

public class Traitement5B extends Traitement5 {

    @Override
    public void fichierFerme() {
	int position = 0;
	while(position<listeInteger.size()){
	    int valeurCourante = listeInteger.get(position);

	    if(valeurCourante>=3){
		listeInteger.set(position, valeurCourante-1);
	    } else {
		listeInteger.set(position, valeurCourante+1);
	    }
	    position = position + valeurCourante;

	    nombreEtapeSortirListe = nombreEtapeSortirListe+1;
	}
    }

}
