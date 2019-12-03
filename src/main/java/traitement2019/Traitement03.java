package traitement2019;

import utils.ClotureListener;
import utils.LigneListener;


public class Traitement03 implements LigneListener, ClotureListener {

	private int manhattanDistance;

	public int getManhattanDistance() {
		return manhattanDistance;
	}


	@Override
	public void ligneLue(String ligne) {
		// String[] input = ligne.split(",");
	}

	@Override
	public void fichierFerme() {
	}

}
