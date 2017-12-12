package exercice2;

import java.util.Arrays;

import utils.LigneListener;

public class Traitement2B implements LigneListener {

    private int somme;

    public int getSomme() {
	return somme;
    }

    /**
     * On récupère une ligne qui contient des nombres et on calcule le quotient de 2 nombres qui retourne un entier sans reste.  
     * Il n'existe qu'une solution par ligne <br/>	
     * On ajoute ce nombre à la somme courante pour avoir la somme des différentes lignes traités. 
     */
    @Override
    public void ligneLue(String ligne) {
	String[] tab = ligne.split("\t");
	int[] tab2 = Arrays.asList(tab).stream().mapToInt(Integer::parseInt).toArray();
	for(int i=0;i<tab2.length;i++){
	    for(int j=0;j<tab2.length;j++){
		if(i!=j && tab2[i]>tab2[j] && tab2[i]%tab2[j]==0){
		    somme = somme + tab2[i]/tab2[j];
		}
	    }
	}
    }

}
