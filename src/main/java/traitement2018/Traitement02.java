package traitement2018;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.ClotureListener;
import utils.LigneListener;

public class Traitement02 implements LigneListener, ClotureListener {
	
	private int doublon;
	private int triplon;
	private Map<Character, Integer> map;
	
	private List<char[]> liste = new ArrayList<>();
	private int maxCarEnCommun;
	private StringBuffer lettresEnCommun = new StringBuffer();

	
	public int getChecksum() {
		return doublon * triplon;
	}
	
	public String getLettresEnCommun() {
		return lettresEnCommun.toString();
	}

	@Override
	public void ligneLue(String ligne) {
		/* on regarde pour chaque ligne le nombre d'occurence de chaque caractère
		 * en le stockant dans une map.
		 * On incrèmente ensuite doublon et triplon si la ligne contient des doublons/triplons
		 */
		char[] tableauDeLettres = ligne.toCharArray();
		map = new HashMap<>();
		for (char caractere : tableauDeLettres) {
			if(map.get(caractere) != null) {
				map.put(caractere, map.get(caractere) + 1);
			} else {
				map.put(caractere, 1);
			}
		}
		Collection<Integer> collection = map.values();
		if(collection.contains(2)) {
			doublon++;
		}
		if(collection.contains(3)) {
			triplon++;
		}
		
		// ajout de toutes les lignes sous forme de tableau de char pour la partie 2
		liste.add(ligne.toCharArray());
	}
	
	@Override
	public void fichierFerme() {
		char[] tab1 = null, tab2 = null;
		
		// comparaison de tous les tableaux stockées dans la liste 2 à 2
		for (int i = 0; i < liste.size(); i++) {
			for (int j = i+1; j < liste.size(); j++) {
				int nombreDeCaractereEnCommun = nombreDeCaractereEnCommun(liste.get(i), liste.get(j));
				// si le nombre de caractères en commun est le plus grand rencontré jusque là
				// on stocke ce nombre et les 2 tableaux
				if(nombreDeCaractereEnCommun >= maxCarEnCommun) {
					maxCarEnCommun = nombreDeCaractereEnCommun;
					tab1 = liste.get(i);
					tab2 = liste.get(j);
				}
			}
		}
		
		// on stocke les lettres en commun entre les 2 tableaux dans un string
		for (int i = 0; i < tab1.length; i++) {
			if(tab1[i] == tab2[i]) {
				lettresEnCommun.append(tab1[i]);
			}
		}
	}
	
	/**
	 * méthode qui renvoie le nombre de caractères identiques à la même position dans les tableaux de char
	 * @param tab1
	 * @param tab2
	 * @return
	 */
	private int nombreDeCaractereEnCommun(char[] tab1, char[] tab2) {
		int nb = 0;
		for (int i = 0; i < tab1.length; i++) {
			if(tab1[i] == tab2[i]) {
				nb++;
			}
		}
		return nb;
	}

}
