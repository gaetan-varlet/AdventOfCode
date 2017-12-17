package exercice03;

public class Exercice3 {

	// nombres de lignes et de colonnes dans le tableau que l'on crée
	// (doit être impair pour placer un chiffre au centre)
	private final int largeurTableau=999;
	private final int nombreTourDeBoucle=(largeurTableau-1)/2;
	// calcul de la position centrale du chiffre 1
	private final int positionInitial = (largeurTableau-1)/2;
	// déclaration du tableau
	private int[][]tab = new int[largeurTableau][largeurTableau];

	private int input;
	private int inputCoordLigne;
	private int inputCoordCol;


	private int ligneCourante = positionInitial;
	private int colonneCourante=positionInitial;

	private int distanceDeManhattan;
	private int valeurSuperieure;

	public void setInput(int input) {
		this.input = input;
	}

	public int getDistanceDeManhattan() {
		return distanceDeManhattan;
	}

	public int getValeurSuperieure() {
		return valeurSuperieure;
	}

	/**
	 * réalise le traitementA (calcul de la distance de Manhattan) ou le traitement B (calcul de la première
	 * valeur supérieure à l'input). L'input doit être renseigné et être un nombre entier compris entre 1 et 9000.
	 * Pour réaliser le traitement B, il faut repartir d'un tableau vide et donc créer un nouvel objet Exercice3.
	 * @param traitementA true pour faire le traitementA, false pour faire le traitementB
	 * @throws IllegalArgumentException si l'input est <= 0
	 * @throws Exception si lors de l'appel au traitementB, le tableau est déjà rempli
	 */
	protected void traitement(boolean traitementA) throws Exception{
		if(input<=0){
			throw new IllegalArgumentException("input doit être un nombre entier compris entre 1 et 9000");
		}
		if(traitementA==false && tab[0][0]!=0){
			throw new Exception("vous devez instancier un nouvel objet pour calculer la première valeur "
					+ "supérieure de l'input");
		}
		
		remplissageTableau(traitementA);
		calculPositionInput();
		calculDistanceDeManhattan();
	}


	private void remplissageTableau(boolean traitementA){
		// positionnement du 1 au milieu du tableau
		tab[positionInitial][positionInitial]=1;
		// on commence à remplir le tableau depuis ces coordonnées de départ.
		ligneCourante = positionInitial;
		colonneCourante = positionInitial;

		// déclaration du chiffre qu'on va inscrire dans le tableau, en commençant par 2 car on a déja écrit 1;
		int k=2;
		// on boucle en remplissant le tableau en escargot
		for (int i = 0; i < nombreTourDeBoucle; i++) {
			for (int j = 1; j < 2+2*i; j++) {
				colonneCourante++;
				if(traitementA){
					tab[ligneCourante][colonneCourante]=k++; //2 au premier tour du boucle i
				} else{
					tab[ligneCourante][colonneCourante]=sommeCarre();
					if(tab[ligneCourante][colonneCourante]>input){
						valeurSuperieure=tab[ligneCourante][colonneCourante];
						return;
					}	
				}
			}
			for (int j = 1; j < 2+2*i; j++) {
				ligneCourante--;
				if(traitementA){
					tab[ligneCourante][colonneCourante]=k++; //3 au premier tour du boucle i
				} else{
					tab[ligneCourante][colonneCourante]=sommeCarre();
					if(tab[ligneCourante][colonneCourante]>input){
						valeurSuperieure=tab[ligneCourante][colonneCourante];
						return;
					}	
				}
			}
			for (int j = 1; j < 3+2*i; j++) {
				colonneCourante--;
				if(traitementA){
					tab[ligneCourante][colonneCourante]=k++; //4 et 5 au premier tour du boucle i
				} else{
					tab[ligneCourante][colonneCourante]=sommeCarre();
					if(tab[ligneCourante][colonneCourante]>input){
						valeurSuperieure=tab[ligneCourante][colonneCourante];
						return;
					}	
				}
			}
			for (int j = 1; j < 3+2*i; j++) {
				ligneCourante++;
				if(traitementA){
					tab[ligneCourante][colonneCourante]=k++; //6 et 7 au premier tour du boucle i
				} else{
					tab[ligneCourante][colonneCourante]=sommeCarre();
					if(tab[ligneCourante][colonneCourante]>input){
						valeurSuperieure=tab[ligneCourante][colonneCourante];
						return;
					}	
				}
			}
		}
		//				System.out.println(Arrays.deepToString(tab));
	}

	/**
	 * calcul la position dans le tableau (numéro de ligne et de colonne) du chiffre en input
	 */
	private void calculPositionInput(){
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				if(tab[i][j]==input){
					inputCoordLigne = i;
					inputCoordCol = j;
					return;
				}
			}	
		}
	}
	
	private void calculDistanceDeManhattan(){
		distanceDeManhattan = Math.abs(inputCoordLigne-positionInitial)+Math.abs(inputCoordCol-positionInitial);
	}

	/**
	 * calcule la somme des chiffres dans le tableau autour du chiffre sur lequel on est positionné
	 * @param ligneCourante ligne sur laquelle on est positionné
	 * @param colonneCourante colonne sur laquelle on est positionné
	 * @return la somme
	 */
	private int sommeCarre(){
		int somme=0;
		if(ligneCourante>0 && colonneCourante>0){
			somme = somme+tab[ligneCourante-1][colonneCourante-1];
		}
		if(ligneCourante>0){
			somme = somme+tab[ligneCourante-1][colonneCourante];
		}
		if(ligneCourante>0 && colonneCourante+1<tab.length){
			somme = somme+tab[ligneCourante-1][colonneCourante+1];
		}
		if(colonneCourante>0){
			somme = somme+tab[ligneCourante][colonneCourante-1];
		}
		if(colonneCourante+1<tab.length){
			somme = somme+tab[ligneCourante][colonneCourante+1];
		}
		if(ligneCourante+1<tab.length && colonneCourante>0){
			somme = somme+tab[ligneCourante+1][colonneCourante-1];
		}
		if(ligneCourante+1<tab.length){
			somme = somme+tab[ligneCourante+1][colonneCourante];
		}
		if(ligneCourante+1<tab.length && colonneCourante+1<tab.length){
			somme = somme+tab[ligneCourante+1][colonneCourante+1];
		}
		return somme;
	}
}
