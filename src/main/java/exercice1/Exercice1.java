package exercice1;

public class Exercice1 {

    /**
     * parcours de la chaine chiffre par chiffre de manière circulaire, en se disant que le premier chiffre est à la suite du dernier. <br/>
     * on regarde si les chiffres qui sont séparés d'un pas de taille "pas" sont égaux. <br/>
     * on somme tous ces chiffres et retourne le total.
     * @param chaine chaine de chiffres en entrée
     * @param pas
     * @return la somme
     */
    protected int exercice1(String chaine, int pas){
	int somme = 0;
	char[] tabChar = chaine.toCharArray();
	
	for (int i=0;i<chaine.length();i++) {
	    int next = (i+pas)%(chaine.length());
	    if(tabChar[i]==tabChar[next]){
		somme=somme+Character.getNumericValue(tabChar[i]);
	    }
	}
	return somme;
    }
}
