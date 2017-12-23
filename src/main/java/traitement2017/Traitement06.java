package traitement2017;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import utils.LigneListener;

public class Traitement06 implements LigneListener{

    private int nombreDeTour;
    private int tailleCycle;

    public int getNombreDeTour() {
	return nombreDeTour;
    }

    public int getTailleCycle() {
	return tailleCycle;
    }


    @Override
    public void ligneLue(String ligne) {
	// séparation des nombres récupérés dans la String dans un tableau
	String[] tab = ligne.split("\t");
	// transformation du tableau de String en tableau d'int
	int[] tab2 = Arrays.asList(tab).stream().mapToInt(Integer::parseInt).toArray();
	// transformation du tableau de int en liste d'Integer
	List<Integer> liste = Arrays.stream(tab2).boxed().collect(Collectors.toList());

	/* Création d'un Set de String où l'on va stocker les listes d'Integer successives sous forme de String 
	 * ce qui permet de voir à quel moment on essaiera d'insérer une liste qu'on a déjà insérer, on aura un false en retour du add */
	Set<String> setDeListInteger = new LinkedHashSet<String>();
	// ajout de la liste initial dans le Set
	setDeListInteger.add(conversionListEnString(liste));

	do {
	    nombreDeTour++;
	    // récupération dans la liste du plus gros chiffre, le 1er s'il y a une égalité
	    int max = Collections.max(liste);
	    // récupération dans la liste de la position du plus gros chiffre, le 1er s'il y a une égalité
	    int position = liste.indexOf(max);
	    int positionCourante = position;
	    // distribution du max 1 par 1 dans les éléments suivants de liste jusqu'à ce que le max vaille 0 
	    while(max>0){
		if(positionCourante<liste.size()-1){ // tant qu'on n'est pas sur le dernier élémennt de la liste
		    liste.set(positionCourante+1, liste.get(positionCourante+1)+1); // on ajoute 1 à l'élément suivant
		    positionCourante++; // on passe à l'élément suivant
		} else { // si on est sur le dernier élément
		    liste.set(0, liste.get(0)+1); // on ajoute 1 au 1er élément
		    positionCourante=0; // on se repositionne sur le 1er élément
		}
		liste.set(position, liste.get(position)-1); // on enlève 1 à l'élément qui a été identifié comme max au début du tour de boucle
		max--; // on on enlève 1 au max a distribuer
	    }
	    // on continue à réorganiser la liste jusqu'à ce qu'on arrive sur une liste qu'on a déjà eu, auquel cas le add du Set va retourner false
	} while(setDeListInteger.add(conversionListEnString(liste)));

	// On veut maintenant savoir combien il y a de tours de boucles entre les 2 listes identiques (tailleCycle)
	// on récupère la dernière qui est celle qu'on n'a pas pu insérer dans le Set et on recherche sa position dans le Set
	String maString = conversionListEnString(liste);
	int i=0;
	for (String stringSet : setDeListInteger) {
	    if(maString.equals(stringSet)){
		break;
	    }
	    i++;
	}
	// calcul de la taille du cycle en faisant la différence entre le nombre de tours de boucle total moins la position de la liste identique dans le Set  
	tailleCycle = nombreDeTour-i;
    }

    /**
     * transforme une liste d'Integer en chaîne de caractères
     * @param liste Liste d'Integer en entrée
     * @return la liste d'Integer sous forme de chaine de caractères
     */
    private static String conversionListEnString(List<Integer> liste){
	StringBuffer maChaine = new StringBuffer();
	for (int i = 0; i < liste.size(); i++) {
	    maChaine.append(liste.get(i));
	}
	return maChaine.toString();
    }

}
