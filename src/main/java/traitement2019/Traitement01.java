package traitement2019;

import utils.LigneListener;

public class Traitement01 implements LigneListener {

	private int somme;

	private int sommeRecurvise;

	public int getSomme() {
		return somme;
	}

	public int getSommeRecursive() {
		return sommeRecurvise;
	}

	@Override
	public void ligneLue(String ligne) {
		int sommeLigne = (Integer.parseInt(ligne) / 3) - 2;
		somme += sommeLigne;
		while (sommeLigne > 0) {
			sommeRecurvise += sommeLigne;
			sommeLigne = sommeLigne / 3 - 2;
		}
	}

}
