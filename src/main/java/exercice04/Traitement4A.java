package exercice04;

import java.util.HashSet;
import java.util.Set;

import utils.LigneListener;

public class Traitement4A implements LigneListener {

    private int total;

    public int getTotal() {
	return total;
    }

    /**
     * On récupère une ligne qui contient des mots et on regarde s'il y a au moins 2 mots identiques. <br/>
     * Si c'est le cas, phraseCorrecte=0, sinon phraseCorrecte=1. <br/>
     * On ajoute ce nombre au total courant pour avoir le total des différentes lignes traités.  
     */
    @Override
    public void ligneLue(String ligne) {
	int phraseCorrecte=0;	
	String[] phrase = ligne.split(" ");
	Set<String> liste = new HashSet<>();
	for (String mot : phrase) {
	    if(liste.add(mot)==false){
		phraseCorrecte=0;
		break;
	    } else{
		phraseCorrecte=1;
	    }
	}
	total = total + phraseCorrecte;
    }

}
