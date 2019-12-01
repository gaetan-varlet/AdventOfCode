package traitement2019;

import utils.LigneListener;

public class Traitement01 implements LigneListener {

	private int somme;

	public int getSomme() {
		return somme;
	}

	@Override
	public void ligneLue(String ligne) {
		somme += (Integer.parseInt(ligne) / 3) - 2;
	}

}
