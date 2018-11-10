package traitement2017;

import java.util.Arrays;

import utils.LigneListener;

public class Traitement02A implements LigneListener {

	private int somme;

	public int getSomme() {
		return somme;
	}

	/**
	 * On récupère une ligne qui contient des nombres
	 * et on calcule l'écart entre le nombre le plus grand et le nombre le plus petit. <br>
	 * On ajoute ce nombre à la somme courante pour avoir la somme des différentes lignes traités. 
	 */
	@Override
	public void ligneLue(String ligne) {
		String[] tab = ligne.split("\t");
		int[] tab2 = Arrays.asList(tab).stream().mapToInt(Integer::parseInt).toArray();	
		Arrays.sort(tab2);
		somme = somme + tab2[tab2.length-1] - tab2[0];		
	}

}
