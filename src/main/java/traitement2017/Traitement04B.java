package traitement2017;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import utils.LigneListener;

public class Traitement04B implements LigneListener {

    private int total;

    public int getTotal() {
	return total;
    }

    /**
     * On récupère une ligne qui contient des mots et on regarde s'il y a au moins 2 mots qui contiennent 
     * les mêmes lettres quelque soit l'ordre des lettres. <br/>
     * Si c'est le cas, phraseCorrecte=0, sinon phraseCorrecte=1. <br/>
     * On ajoute ce nombre au total courant pour avoir le total des différentes lignes traités.  
     */
    @Override
    public void ligneLue(String ligne) {
	int phraseCorrecte=0;	
	String[] phrase = ligne.split(" ");
	Set<String> liste = new HashSet<>();
	for (String mot : phrase) {
	    mot = trierLettres(mot);
	    if(liste.add(mot)==false){
		phraseCorrecte=0;
		break;
	    } else{
		phraseCorrecte=1;
	    }
	}
	total = total + phraseCorrecte;
    }

    /**
     * trie les lettres du String en entrée dans l'ordre alphabétique et retourne le String trié
     * @param mot le String à trier
     * @return le String trié
     */
    protected String trierLettres(String mot){
	char[] chars = mot.toCharArray();
	Arrays.sort(chars);
	String sorted = new String(chars);
	return sorted;	
    }

}
