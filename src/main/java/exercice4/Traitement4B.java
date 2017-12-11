package exercice4;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import utils.LigneListener;

public class Traitement4B implements LigneListener {
    
    private int total;

    public int getTotal() {
	return total;
    }

    @Override
    public void ligneLue(String ligne) throws IOException {
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
    
    protected String trierLettres(String mot){
	char[] chars = mot.toCharArray();
	Arrays.sort(chars);
	String sorted = new String(chars);
	return sorted;	
    }

}
