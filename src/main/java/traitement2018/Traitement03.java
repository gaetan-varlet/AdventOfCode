package traitement2018;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import utils.ClotureListener;
import utils.LigneListener;

public class Traitement03 implements LigneListener, ClotureListener {

	private Map<String, Integer> mapCoordNbValeur = new HashMap<>();
	private Map<String, Set<String>> mapIdEnsembleCoord = new HashMap<>();
	private int nombreDeSuperposition;
	private String idRectangleSansSuperposition;

	public int getNombreDeSuperposition() {
		return nombreDeSuperposition;
	}

	public String getIdRectangleSansSuperposition() {
		return idRectangleSansSuperposition;
	}

	@Override
	public void ligneLue(String ligne) {
		String[] idCoord = ligne.split(" @ ");
		String id = idCoord[0].substring(1); // suppression du #
		String[] positionDimension = idCoord[1].split(": ");
		String[] positionXY = positionDimension[0].split(",");
		String [] dimensionXY = positionDimension[1].split("x");

		int positionX = Integer.parseInt(positionXY[0]);
		int positionY = Integer.parseInt(positionXY[1]);
		int dimensionX = Integer.parseInt(dimensionXY[0]);
		int dimensionY = Integer.parseInt(dimensionXY[1]);

		Set<String> coordoonees = new HashSet<>();
		mapIdEnsembleCoord.put(id, coordoonees);
		for(int x =  positionX; x < positionX + dimensionX ; x++) {
			for(int y = positionY ; y < positionY + dimensionY ; y++) {
				mapCoordNbValeur.put(x+"."+y, mapCoordNbValeur.getOrDefault(x+"."+y, 0) + 1);
				coordoonees.add(x+"."+y);
			}
		}
		//		System.out.println();
	}

	@Override
	public void fichierFerme() {		
		for (Integer nombreDeRectangleSuperpose  : mapCoordNbValeur.values()) {
			if(nombreDeRectangleSuperpose > 1) {
				nombreDeSuperposition++;
			}
		}

		/*
		 *  our chaque rectangle identifié par id, on va regarder pour chacun de ses coordonnées
		 *  si ce coordooné est présent dans chaque coordonnée de chacun des autres rectangle.
		 *  Si c'est le cas, estSuperpose passe à true 
		 */
		for (String id : mapIdEnsembleCoord.keySet()) {
			boolean estSuperpose = false;
			outerloop:
			for (String idAutreRectangle : mapIdEnsembleCoord.keySet()) {
				if(!id.equals(idAutreRectangle)) {
					for (String coordonnee : mapIdEnsembleCoord.get(id)) {
						if(mapIdEnsembleCoord.get(idAutreRectangle).contains(coordonnee)) {
							estSuperpose = true;
							break outerloop; // permet de sortir des 2 boucles en cours et passer à l'id suivant
						}
					}
				}
			}
			if (!estSuperpose) {
				idRectangleSansSuperposition = id;
				break;
			}
		}
	}

}
