package exercice9;

import java.util.ArrayList;
import java.util.List;

import utils.LigneListener;

public class Traitement9 implements LigneListener{
    
    private int nombreDeGroupe;
    private int score;

    public int getNombreDeGroupe() {
        return nombreDeGroupe;
    }

    public int getScore() {
        return score;
    }

    @Override
    public void ligneLue(String ligne) {

	System.out.println("DEBUT");
	System.out.println(ligne);

	// transformation de la ligne en tableau de char puis en liste de Characters
	char[] tab = ligne.toCharArray();
	List<Character> listeChar = new ArrayList<Character>();
	for (char c : tab) {
	    listeChar.add(c);
	}
	System.out.println("taille de la liste : "+listeChar.size());
	// suppression des points d'exclamation : quand on voit un point d'exclamation, on le supprime ainsi que le caractère d'après (qui prend sa place)
	// on sort alors de la boucle, et on recommence le traitement jusqu'à ce qu'il n'y ait plus de point d'exclamation
	while(listeChar.contains('!')){
	    for (int i = 0; i < listeChar.size(); i++) {
		if(listeChar.get(i)=='!'){
		    listeChar.remove(i);
		    listeChar.remove(i);
		    break;
		}   
	    }
	}
	System.out.println("APRES LA SUPPRESSION DES POINTS D'EXCLAMATIONS ET DU CHARACTERE D'APRES");
	afficher(listeChar);
	System.out.println("taille de la liste : "+listeChar.size());

	
	for (int i = 0; i < listeChar.size(); i++) {
	    if(listeChar.get(i)=='<' && listeChar.get(i+1)!='>'){
		while(listeChar.get(i+1)!='>'){
		    listeChar.remove(i+1);
		    // afficher(listeChar);
		}
	    }
	}
	System.out.println("APRES LA SUPPRESSION DES CHARACTERES ENTRE < et >");
	afficher(listeChar);
	System.out.println("taille de la liste : "+listeChar.size());

	
	while(listeChar.contains('<')){
	    for (int i = 0; i < listeChar.size(); i++) {
		if(listeChar.get(i)=='<' && listeChar.get(i+1)=='>'){
		    listeChar.remove(i);
		    listeChar.remove(i);
		    break;
		}
	    }
	}
	System.out.println("APRES SUPPRESSION DES < et >");
	afficher(listeChar);
	System.out.println("taille de la liste : "+listeChar.size());
	
	
	for (int i = 0; i < listeChar.size(); i++){
	    if(listeChar.get(i)=='{' && listeChar.get(i+1)==','){
		listeChar.remove(i+1);
	    }
	}
	System.out.println("APRES LA SUPPRESSION DES VIRGULES APRES LES { (inutile pour les jeux de test)");
	afficher(listeChar);
	System.out.println("taille de la liste : "+listeChar.size());
	System.out.println("FIN");
	
	
	nombreDeGroupe = 0;	
	score = 0;
	int valeurCourante = 1;
	for (Character character : listeChar) {
	   if(character=='{'){
	       nombreDeGroupe++;
	       score = score + valeurCourante;
	       valeurCourante++;
	   } else if(character==','){
	      	valeurCourante--;
	   }
	}
	System.out.println();
    }

    private void afficher(List<Character> listeChar){
	for (Character character : listeChar) {
	    System.out.print(character);
	}
	System.out.println();
    }

}
