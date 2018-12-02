package traitement2017;

import java.util.HashSet;
import java.util.Set;

import utils.ClotureListener;
import utils.LigneListener;

public class Traitement07 implements LigneListener, ClotureListener{

	private String nomPere;

	private Set<String> elements = new HashSet<>();
	private Set<String> enfants = new HashSet<>();


	public String getNomPere() {
		return nomPere;
	}

	@Override
	public void ligneLue(String ligne) {
		String[] tab = ligne.split(" -> ");
		String[] pereEtPoids = tab[0].split(" ");
		String[] enfants = null;
		if(tab.length>1) {
			enfants = tab[1].split(",");
		}

		this.elements.add(pereEtPoids[0].trim());

		if(enfants != null) {
			for (String enfant : enfants) {
				this.enfants.add(enfant.trim());
			}	
		}
	}

	@Override
	public void fichierFerme() {
		System.out.println(elements.size());
		System.out.println(enfants.size());
		for (String element : elements) {
			if(!enfants.contains(element)) {
				nomPere = element;
				return;
			}
		}

	}

}
