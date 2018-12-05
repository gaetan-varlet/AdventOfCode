package traitement2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.LigneListener;

public class Traitement05 implements LigneListener {
	
	private int nombreLettresRestantesDansLaFormule;
	private int nombreLettresRestantesDansLaFormuleSimplifiee;
	
	private Map<Character, Integer> mapLettresTailleFormule = new HashMap<>();
	
	public int getNombreLettresRestantesDansLaFormule() {
		return nombreLettresRestantesDansLaFormule;
	}
	
	public int getNombreLettresRestantesDansLaFormuleSimplifiee() {
		return nombreLettresRestantesDansLaFormuleSimplifiee;
	}
	
	@Override
	public void ligneLue(String ligne) {
		
		char[] tableauChar = ligne.toCharArray();
		List<Character> liste = new ArrayList<>();
		Set<Character> ensembleDesLettres = new HashSet<>();
		for (char character : tableauChar) {
			liste.add(character);
			ensembleDesLettres.add(Character.toUpperCase(character));
		}
		
		nombreLettresRestantesDansLaFormule = calculLongueurFormule(liste);
		
		for (Character character : ensembleDesLettres) {
			List<Character> listeTronque = new ArrayList<>();
			listeTronque.addAll(liste);
			Set<Character> ensembleCaractereCourant = new HashSet<>();
			ensembleCaractereCourant.add(character);
			ensembleCaractereCourant.add(Character.toLowerCase(character));
			listeTronque.removeAll(ensembleCaractereCourant);
			mapLettresTailleFormule.put(character, calculLongueurFormule(listeTronque));
		}
		
		nombreLettresRestantesDansLaFormuleSimplifiee = nombreLettresRestantesDansLaFormule;
		for (Integer longueurFormule : mapLettresTailleFormule.values()) {
			if(longueurFormule<nombreLettresRestantesDansLaFormuleSimplifiee) {
				nombreLettresRestantesDansLaFormuleSimplifiee = longueurFormule;
			}
		}
		
		
	}
	
	private int calculLongueurFormule(List<Character> listeCaractere) {
		List<Character> liste = new ArrayList<>();
		liste.addAll(listeCaractere);
		boolean fin = false;
		while(!fin) {
			int tailleListe = liste.size();
			for (int i = 0 ; i < liste.size() -1 ; i++) {
				if((Character.toUpperCase(liste.get(i)) == Character.toUpperCase(liste.get(i+1))) && (liste.get(i) != liste.get(i+1))) {
					liste.remove(i+1);
					liste.remove(i);
					i--;
				}		
			}
			if(liste.size() == tailleListe) {
				fin = true;
			}
		}		
		return liste.size();
	}
	
}
