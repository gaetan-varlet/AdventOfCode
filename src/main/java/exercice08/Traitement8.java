package exercice08;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import utils.ClotureListener;
import utils.LigneListener;

public class Traitement8 implements LigneListener, ClotureListener{

    private int maximumTemporaire;

    private int maximumFinal;


    public int getMaximumTemporaire() {
	return maximumTemporaire;
    }

    public int getMaximumFinal() {
	return maximumFinal;
    }

    private Map<String, Integer> mapRegister =  new HashMap<String, Integer>();

    public Map<String, Integer> getMapRegister() {
	return mapRegister;
    }


    @Override
    public void ligneLue(String ligne) {

	String[] tab = ligne.split(" ");

	if(mapRegister.containsKey(tab[0])==false){
	    mapRegister.put(tab[0], 0);
	}	
	if(mapRegister.containsKey(tab[4])==false){
	    mapRegister.put(tab[4], 0);
	}

	if("<".equals(tab[5])){
	    if(mapRegister.get(tab[4])<Integer.valueOf(tab[6])){
		ajoutOuRetrait(tab);
	    }
	} else if("<=".equals(tab[5])){
	    if(mapRegister.get(tab[4])<=Integer.valueOf(tab[6])){
		ajoutOuRetrait(tab);
	    }
	} else if(">".equals(tab[5])){
	    if(mapRegister.get(tab[4])>Integer.valueOf(tab[6])){
		ajoutOuRetrait(tab);
	    }    
	} else if(">=".equals(tab[5])){
	    if(mapRegister.get(tab[4])>=Integer.valueOf(tab[6])){
		ajoutOuRetrait(tab);
	    }
	} else if("==".equals(tab[5])){
	    if(mapRegister.get(tab[4]).equals(Integer.valueOf(tab[6]))){
		ajoutOuRetrait(tab);
	    }
	} else if("!=".equals(tab[5])){
	    if(mapRegister.get(tab[4]).equals(Integer.valueOf(tab[6]))==false){
		ajoutOuRetrait(tab);
	    }
	}

	int temp = Collections.max(mapRegister.values());
	if(temp>maximumTemporaire){
	    maximumTemporaire=temp;
	}

    }

    private void ajoutOuRetrait(String[] tab){
	if("inc".equals(tab[1])){
	    mapRegister.put(tab[0], mapRegister.get(tab[0])+Integer.valueOf(tab[2]));
	} else if("dec".equals(tab[1])){
	    mapRegister.put(tab[0], mapRegister.get(tab[0])-Integer.valueOf(tab[2]));
	}
    }

    @Override
    public void fichierFerme() {
	Collection<Integer> liste = mapRegister.values();
	maximumFinal = Collections.max(liste);	
    }

}
