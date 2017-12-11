package exercice1;

public class Exercice1 {

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
