package traitement2017;

import java.util.Arrays;

import utils.LigneListener;

public class Traitement11 implements LigneListener{

	private int[] nombreDeplacementMinimum;
	private int[] coordXArrivee;
	private int[] coordYArrivee;

	public int getNombreDeplacementMinimumFinal() {
		return nombreDeplacementMinimum[nombreDeplacementMinimum.length-1];
	}
	
	public int getNombreDeplacementMinimumMax() {
		return Arrays.stream(nombreDeplacementMinimum).max().getAsInt();
	}

	@Override
	public void ligneLue(String ligne) {

		String[] tableauDirection = ligne.split(",");
		
		nombreDeplacementMinimum = new int[tableauDirection.length];
		coordXArrivee = new int[tableauDirection.length];
		coordYArrivee = new int[tableauDirection.length];
		
		calculCheminAEffectuer(tableauDirection);

		System.out.println("Coordonées d'arrivée : (" + Arrays.toString(coordXArrivee) + "," + Arrays.toString(coordYArrivee) + ")");
		
		for (int i = 0; i < tableauDirection.length; i++) {
			calculNombreDeplacementsMinimaux(i);
		}

		System.out.println("nombre de déplacements initiaux : " + tableauDirection.length);
		System.out.println("nombre de déplacements minimum : " + Arrays.toString(nombreDeplacementMinimum));
		System.out.println("");
	}

	private void calculCheminAEffectuer(String[] tableauDirection) {
		int i = 0;
		for (String direction : tableauDirection) {
			if("nw".equals(direction)) {
//				System.out.println("Déplacement initial : nw");
				if(i>0) {
					coordXArrivee[i] = coordXArrivee[i-1] - 1;
					coordYArrivee[i] = coordYArrivee[i-1] + 1;
				} else {
					coordXArrivee[i] = - 1;
					coordYArrivee[i] = + 1;
				}
			} else if("n".equals(direction)) {
//				System.out.println("Déplacement initial : n");
				if(i>0) {
					coordXArrivee[i] = coordXArrivee[i-1];
					coordYArrivee[i] = coordYArrivee[i-1] + 2;
				} else {
					coordXArrivee[i] = 0;
					coordYArrivee[i] = + 2;
				}
			} else if("ne".equals(direction)) {
//				System.out.println("Déplacement initial : ne");
				if(i>0) {
					coordXArrivee[i] = coordXArrivee[i-1] + 1;
					coordYArrivee[i] = coordYArrivee[i-1] + 1;
				} else {
					coordXArrivee[i] = + 1;
					coordYArrivee[i] = + 1;
				}
			} else if("se".equals(direction)) {
//				System.out.println("Déplacement initial : se");
				if(i>0) {
					coordXArrivee[i] = coordXArrivee[i-1] + 1;
					coordYArrivee[i] = coordYArrivee[i-1] - 1;
				} else {
					coordXArrivee[i] = + 1;
					coordYArrivee[i] = - 1;
				}
			}  else if("s".equals(direction)) {
//				System.out.println("Déplacement initial : s");
				if(i>0) {
					coordXArrivee[i] = coordXArrivee[i-1];
					coordYArrivee[i] = coordYArrivee[i-1] - 2;
				} else {
					coordXArrivee[i] = 0;
					coordYArrivee[i] = - 2;
				}
			}  else if("sw".equals(direction)) {
//				System.out.println("Déplacement initial : sw");
				if(i>0) {
					coordXArrivee[i] = coordXArrivee[i-1] - 1;
					coordYArrivee[i] = coordYArrivee[i-1] - 1;
				} else {
					coordXArrivee[i] = - 1;
					coordYArrivee[i] = - 1;
				}
			}
			i++;
		}
	}

	private void calculNombreDeplacementsMinimaux(int i) {
		int coordXCourante = 0;
		int coordYCourante = 0;
		int nbDeplacementMin = 0;
		
//		System.out.println("Calcul du nombre de déplacements optimal pour l'occurence "+i);
		
		while (((coordXCourante == coordXArrivee[i]) &&
				(coordYCourante == coordYArrivee[i]))==false) {

			if(coordXCourante > coordXArrivee[i] && coordYCourante > coordYArrivee[i]) {
				coordXCourante -= 1;
				coordYCourante -= 1;
//				System.out.println("Déplacement optimal : sw, "+
//						"nouveaux coordonnées : (" + coordXCourante + "," + coordYCourante + ")");
			} else if(coordXCourante > coordXArrivee[i] && coordYCourante < coordYArrivee[i]) {
//				System.out.println("Déplacement optimal : nw");
				coordXCourante -= 1;
				coordYCourante += 1;
			} else if(coordXCourante < coordXArrivee[i] && coordYCourante < coordYArrivee[i]) {
//				System.out.println("Déplacement optimal : ne");
				coordXCourante += 1;
				coordYCourante += 1;
			} else if(coordXCourante < coordXArrivee[i] && coordYCourante > coordYArrivee[i]) {
//				System.out.println("Déplacement optimal : se");
				coordXCourante += 1;
				coordYCourante -= 1;
			} else if(coordXCourante == coordXArrivee[i] && coordYCourante < coordYArrivee[i]) {
//				System.out.println("Déplacement optimal : n");
				coordXCourante -= 0;
				coordYCourante += 2;
			} else if(coordXCourante == coordXArrivee[i] && coordYCourante > coordYArrivee[i]) {
//				System.out.println("Déplacement optimal : s");
				coordXCourante -= 0;
				coordYCourante -= 2;
			} else if(coordXCourante > coordXArrivee[i] && coordYCourante == coordYArrivee[i]) {
//				System.out.println("Déplacement optimal : sw + nw");
				coordXCourante -= 2;
				coordYCourante -= 0;
				nbDeplacementMin++;
			} else if(coordXCourante < coordXArrivee[i] && coordYCourante == coordYArrivee[i]) {
//				System.out.println("Déplacement optimal : se + ne");
				coordXCourante += 2;
				coordYCourante -= 0;
				nbDeplacementMin++;
			}

			nbDeplacementMin++;
		}
		nombreDeplacementMinimum[i] = nbDeplacementMin;
	}

}
