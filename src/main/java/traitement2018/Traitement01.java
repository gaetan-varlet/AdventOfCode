package traitement2018;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.ClotureListener;
import utils.LigneListener;

public class Traitement01 implements LigneListener, ClotureListener {

	private int somme;
	private Integer premierNombreEnDouble = null;
	private List<Integer> listeDesNombres = new ArrayList<>();
	private Set<Integer> listeDesSommes = new HashSet<>();
	private int sommeCourante;

	public int getSomme() {
		return somme;
	}

	public Integer getPremierNombreEnDouble() {
		return premierNombreEnDouble;
	}

	@Override
	public void ligneLue(String ligne) {
		// première partie pour calculer la somme de tous les nombres du fichier
		somme += Integer.parseInt(ligne);

		// stockage des nombres dans une liste pour la deuxième partie
		listeDesNombres.add(Integer.parseInt(ligne));
	}

	/**
	 * stockage de la somme après lecture de chaque chiffre jusqu'à retomber sur une
	 * somme déjà atteinte. Il est possible de relire tous les nombres si aucun
	 * doublon n'a été trouvé
	 */
	@Override
	public void fichierFerme() {
		listeDesSommes.add(0);
		while (premierNombreEnDouble == null) {
			for (Integer nombre : listeDesNombres) {
				sommeCourante = nombre + sommeCourante;
				if (listeDesSommes.contains(sommeCourante)) {
					premierNombreEnDouble = sommeCourante;
					return;
				}
				listeDesSommes.add(sommeCourante);
			}
		}
	}

}
