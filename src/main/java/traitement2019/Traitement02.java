package traitement2019;

import java.util.Arrays;

import utils.ClotureListener;
import utils.LigneListener;

public class Traitement02 implements LigneListener, ClotureListener {

	private int resultat;
	private int resultat2;
	private int[] nombres;
	private int[] nombresInit;

	public int getResultat() {
		return resultat;
	}

	public int getResultat2() {
		return resultat2;
	}


	@Override
	public void ligneLue(String ligne) {
		String[] input = ligne.split(",");
		nombres = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
		nombresInit = nombres.clone();
	}

	@Override
	public void fichierFerme() {
		nombres = traitement(nombres, 12, 2);
		resultat = nombres[0];

		// partie 2
		if(nombres.length > 12) {
			for(int i = 0 ; i < 100 ; i++){
				for(int j = 0 ; j < 100 ; j++){
					int[] copie = nombresInit.clone();
					copie = traitement(copie, i, j);
					if(copie[0] == 19690720){
						resultat2 = 100 * i + j;
						return;
					}
				}
			}
		}
	}

	public int[] traitement(int[] nombres, int noun, int verb){
		if(nombres.length > 12) {
			nombres[1] = noun;
			nombres[2] = verb;
		}
		// System.out.println(Arrays.toString(nombres));
		int indice = 0;
		boolean continuer = true;
		while(continuer){
			if(nombres[indice] == 99){
				continuer = false;
			} else if(nombres[indice] == 1){
				nombres[nombres[indice + 3]] = nombres[nombres[indice + 1]] + nombres[nombres[indice + 2]];
			} else if(nombres[indice] == 2){
				nombres[nombres[indice + 3]] = nombres[nombres[indice + 1]] * nombres[nombres[indice + 2]];
			}
			indice += 4;
		}
		return nombres;
	}

}
