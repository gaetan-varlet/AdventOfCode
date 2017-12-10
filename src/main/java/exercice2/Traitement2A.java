package exercice2;

import java.io.IOException;
import java.util.Arrays;

import utils.LigneListener;

public class Traitement2A implements LigneListener {
	
	private int somme;

	public int getSomme() {
		return somme;
	}

	@Override
	public void ligneLue(String ligne) throws IOException {
		String[] tab = ligne.split("\t");
		int[] tab2 = Arrays.asList(tab).stream().mapToInt(Integer::parseInt).toArray();
		Arrays.sort(tab2);
		somme = somme + tab2[tab2.length-1] - tab2[0];		
	}

}
