package exercice6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import utils.LigneListener;

public class Traitement6 implements LigneListener{

	private int nombreDeTour;

	public int getNombreDeTour() {
		return nombreDeTour;
	}


	@Override
	public void ligneLue(String ligne) {
		String[] tab = ligne.split("\t");
		int[] tab2 = Arrays.asList(tab).stream().mapToInt(Integer::parseInt).toArray();
		List<Integer> liste = Arrays.stream(tab2).boxed().collect(Collectors.toList());
		//		System.out.println(Arrays.toString(tab)); // afficher le contenu d'un tableau


		List<Integer> listeInitial = new ArrayList<Integer>(liste);
		System.out.println("listeInitial");
		for (Integer integer : listeInitial) {
			System.out.println(integer);
		}
		
		List<Object> listeDeTab = new ArrayList<>();
		listeDeTab.add(listeInitial.toArray());

		do {
			// on récupère la position dans la liste du plus gros chiffre, le 1er s'il y en a plusieurs
			int max = Collections.max(liste);
			int position = liste.indexOf(max);
			int positionCourante = position;
			// on dispatche le max 1 par 1 dans les éléments suivants de liste
			while(max!=0){
				if(positionCourante<liste.size()-1){ // tant qu'on n'est pas sur le dernier élémennt de la liste
					liste.set(positionCourante+1, liste.get(positionCourante+1)+1); // on ajoute 1 à l'élément suivant
				} else { // si on est sur le dernier élément, on ajoute 1 au 1er élément
					liste.set(0, liste.get(0)+1);
				}
				liste.set(position, liste.get(position)-1); // on enlève au max
				max--; // on on enlève 1 au chiffre à diminuer
				if(positionCourante<liste.size()-1){
					positionCourante++; // on passe à l'élément suivant
				} else {
					positionCourante=0;
				}
			}
			listeDeTab.add(liste.toArray());
			System.out.println("liste");
			for (Integer integer : liste) {
				System.out.println(integer);
			}
		} while(true);

		
		



	}
	
	private static boolean presentEnDouble(List<Object> liste){
		for (int i = 0; i < liste.size(); i++) {
			
		}
		
		return true;
	}

}
