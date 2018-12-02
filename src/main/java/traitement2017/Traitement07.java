package traitement2017;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.Noeud;
import utils.ClotureListener;
import utils.LigneListener;

public class Traitement07 implements LigneListener, ClotureListener {

	private String nomSommet;
	private int valeurCorrigee;
	private Map<String, Noeud> mapNoeud = new HashMap<>();

	public String getNomSommet() {
		return nomSommet;
	}
	
	public int getValeurCorigee() {
		return valeurCorrigee;
	}

	@Override
	public void ligneLue(String ligne) {
		String[] tab = ligne.split(" -> ");
		String[] nomEtPoids = tab[0].split(" ");

		Set<String> ensembleEnfants = new HashSet<>();
		if (tab.length > 1) {
			String[] enfants = tab[1].split(",");
			for (String enfant : enfants) {
				ensembleEnfants.add(enfant.trim());
			}
		}

		Noeud noeud = new Noeud();
		noeud.setNom(nomEtPoids[0].trim());
		noeud.setValeur(Integer.parseInt(nomEtPoids[1].trim().substring(1, nomEtPoids[1].trim().length() - 1)));
		noeud.setEnfants(ensembleEnfants);
		mapNoeud.put(noeud.getNom(), noeud);

	}

	@Override
	public void fichierFerme() {
		calculPere();

		// calcul profondeur
		// on met une profondeur à 0 pour le sommet (le seul qui n'a pas de père)
		for (Noeud noeud : mapNoeud.values()) {
			if (noeud.getPere() == null) {
				nomSommet = noeud.getNom();
				noeud.setProfondeur(0);
			}
		}

		// on descend niveau par niveau jusqu'à ce que tous les noeuds aient une profondeur
		int profondeur = 1;
		while (!toutesProfondeursCalculees()) {
			Set<Noeud> noeudsProfondeurs = noeudsProfondeurs(profondeur - 1);
			for (Noeud noeudPere : noeudsProfondeurs) {
				for (Noeud noeudEnfant : mapNoeud.values()) {
					// si noeudPere est père de noeudEnfant
					if (noeudPere.getEnfants().contains(noeudEnfant.getNom())) {
						mapNoeud.get(noeudEnfant.getNom()).setProfondeur(profondeur);
					}
				}
			}
			profondeur++;
		}
		
		// calcul de la somme des valeurs
		int profondeurMax = getProfondeurMax(mapNoeud);
		// si les noeuds sont au plus profond, la somme des valeurs est égale à leur valeur
		for (Noeud noeud : mapNoeud.values()) {
			if(noeud.getProfondeur().intValue() == profondeurMax) {
				noeud.setSommeValeur(noeud.getValeur());
			}
		}
		// calcul de la somme des valeurs en remontant les niveaux jusqu'au sommet
		// on itère donc sur chaque profondeur jusqu'au sommet
		for (int i = profondeurMax - 1 ; i >= 0 ; i--) {
			for (Noeud noeud : mapNoeud.values()) {
				if(noeud.getProfondeur().intValue() == i) {
					noeud.setSommeValeur(noeud.getValeur());
					for (String nomNoeudEnfant : noeud.getEnfants()) {
						noeud.setSommeValeur(noeud.getSommeValeur() +
								mapNoeud.get(nomNoeudEnfant).getSommeValeur());
					}
				}
			}
		}
		
		// parcours des niveaux en partant de l'avant-dernier niveau
		for (int i = getProfondeurMax(mapNoeud) - 1 ; i >= 0 ; i--) {
			Map<Integer, Integer> mapVal = new HashMap<>();
			for (Noeud noeud : mapNoeud.values()) {
				if(noeud.getProfondeur().intValue() == i) {
					if(!isSommeEnfantsEstEgale(noeud)) {
						// si la somme des enfants n'est pas égale, il faut trouver l'enfant en erreur
						for (String nomEnfant : noeud.getEnfants()) {
							Noeud noeudEnfant = mapNoeud.get(nomEnfant);
							// l'enfant en erreur aura sa valeur une seule fois dans la map
							mapVal.put(noeudEnfant.getSommeValeur(), 
									mapVal.getOrDefault(noeudEnfant.getSommeValeur(), 0) + 1);
						}
						int sommeEnErreur = 0;
						int sommeOk = 0;
						// pour chaque somme des valeurs, on regarde combien de fois elle est présente
						// on cherche celle présente une seule fois qui est l'erreur
						for (Integer sommeValeur : mapVal.keySet()) {
							if(mapVal.get(sommeValeur) == 1) {
								sommeEnErreur = sommeValeur;
							} else {
								sommeOk = sommeValeur;
							}
						}
						int aRetrancher = sommeEnErreur - sommeOk;
						
						for (String nomEnfant : noeud.getEnfants()) {
							Noeud noeudEnfant = mapNoeud.get(nomEnfant);
							if(noeudEnfant.getSommeValeur() == sommeEnErreur) {
								valeurCorrigee = noeudEnfant.getValeur() - aRetrancher;
							}
						}
						
						return;
					}
				}
			}
			
		}
		
		
		System.out.println("fin");
	}

	private void calculPere() {
		for (Noeud noeud : mapNoeud.values()) {
			for (Noeud noeud2 : mapNoeud.values()) {
				if (noeud2.getEnfants().contains(noeud.getNom())) {
					noeud.setPere(noeud2.getNom());
					break;
				}
			}
		}
	}

	private Set<Noeud> noeudsProfondeurs(int profondeur) {
		Set<Noeud> retour = new HashSet<>();
		for (Noeud noeud : mapNoeud.values()) {
			if (noeud.getProfondeur() != null && noeud.getProfondeur().intValue() == profondeur) {
				retour.add(noeud);
			}
		}
		return retour;
	};

	private boolean toutesProfondeursCalculees() {
		for (Noeud noeud : mapNoeud.values()) {
			if(noeud.getProfondeur() == null) {
				return false;
			}
		}
		return true;
	}
	
	private int getProfondeurMax(Map<String, Noeud> mapNoeud) {
		int profondeurMax = 0;
		for (Noeud noeud : mapNoeud.values()) {
			if(noeud.getProfondeur() != null && noeud.getProfondeur() > profondeurMax) {
				profondeurMax = noeud.getProfondeur();
			}
		}
		return profondeurMax;
	}
	
	private boolean isSommeEnfantsEstEgale(Noeud noeud) {
		Set<Integer> ensemble = new HashSet<>();
		for (String nomEnfant : noeud.getEnfants()) {
			Noeud noeudEnfant = mapNoeud.get(nomEnfant);
			ensemble.add(noeudEnfant.getSommeValeur());
		}
		if(ensemble.size() > 1) {
			return false;
		} else {
			return true;
		}
	}

}
