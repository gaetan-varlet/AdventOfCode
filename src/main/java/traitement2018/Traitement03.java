package traitement2018;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.ClotureListener;
import utils.LigneListener;

public class Traitement03 implements LigneListener, ClotureListener {

	private Map<String, Integer> mapCoordNbValeur = new HashMap<>();
	private Map<Integer, Set<String>> mapIdEnsembleCoord = new HashMap<>();
	private int nombreDeSuperposition;
	private Integer idRectangleSansSuperposition;

	public int getNombreDeSuperposition() {
		return nombreDeSuperposition;
	}

	public Integer getIdRectangleSansSuperposition() {
		return idRectangleSansSuperposition;
	}

	@Override
	public void ligneLue(String ligne) {

		Pattern pattern = Pattern.compile("#(.*) @ (.*),(.*): (.*)x(.*)");
		Matcher matcher = pattern.matcher(ligne);
		matcher.matches();
		int id = Integer.parseInt(matcher.group(1));
		int positionX = Integer.parseInt(matcher.group(2));
		int positionY = Integer.parseInt(matcher.group(3));
		int dimensionX = Integer.parseInt(matcher.group(4));
		int dimensionY = Integer.parseInt(matcher.group(5));
		

		Set<String> coordoonees = new HashSet<>();
		mapIdEnsembleCoord.put(id, coordoonees);
		for(int x =  positionX; x < positionX + dimensionX ; x++) {
			for(int y = positionY ; y < positionY + dimensionY ; y++) {
				mapCoordNbValeur.put(x+"."+y, mapCoordNbValeur.getOrDefault(x+"."+y, 0) + 1);
				coordoonees.add(x+"."+y);
			}
		}
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
		for (Integer id : mapIdEnsembleCoord.keySet()) {
			boolean estSuperpose = false;
			outerloop:
			for (Integer idAutreRectangle : mapIdEnsembleCoord.keySet()) {
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
