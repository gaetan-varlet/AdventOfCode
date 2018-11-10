package traitement2017;

public class Traitement05B extends Traitement05 {

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
