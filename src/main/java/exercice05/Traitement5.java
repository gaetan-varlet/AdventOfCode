package exercice05;

import java.util.ArrayList;
import java.util.List;

import utils.ClotureListener;
import utils.LigneListener;

public abstract class Traitement5 implements LigneListener, ClotureListener{

    protected int nombreEtapeSortirListe;

    protected List<Integer> listeInteger = new ArrayList<Integer>();


    public int getNombreEtapeSortirListe() {
	return nombreEtapeSortirListe;
    }

    public List<Integer> getListeInteger() {
	return listeInteger;
    }

    public void addIntegerList(Integer integer){
	if(integer==null){
	    throw new IllegalArgumentException("l'integer passé en argument est null");
	}
	listeInteger.add(integer);
    }

    @Override
    public void ligneLue(String ligne) {
	addIntegerList(Integer.valueOf(ligne.trim()));	
    }

}
