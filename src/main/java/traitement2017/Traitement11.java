package traitement2017;

import utils.LigneListener;

public class Traitement11 implements LigneListener{

	private int nombreDeplacementMinimum = 0;
	private int coordXArrivee = 0;
	private int coordYArrivee = 0;
	private int coordXCourante = 0;
	private int coordYCourante = 0;

	public int getNombreDeplacementMinimum() {
		return nombreDeplacementMinimum;
	}

	@Override
	public void ligneLue(String ligne) {

		String[] tableauDirection = ligne.split(",");
		
		for (String direction : tableauDirection) {
			if("nw".equals(direction)) {
				System.out.println("Déplacement initial : nw");
				coordXArrivee -= 1;
				coordYArrivee += 1;
			} else if("n".equals(direction)) {
				System.out.println("Déplacement initial : n");
				coordXArrivee += 0;
				coordYArrivee += 2;
			} else if("ne".equals(direction)) {
				System.out.println("Déplacement initial : ne");
				coordXArrivee += 1;
				coordYArrivee += 1;
			} else if("se".equals(direction)) {
				System.out.println("Déplacement initial : se");
				coordXArrivee += 1;
				coordYArrivee -= 1;
			}  else if("s".equals(direction)) {
				System.out.println("Déplacement initial : s");
				coordXArrivee += 0;
				coordYArrivee -= 2;
			}  else if("sw".equals(direction)) {
				System.out.println("Déplacement initial : sw");
				coordXArrivee -= 1;
				coordYArrivee -= 1;
			}
		}	
		System.out.println("Coordonées d'arrivée : (" + coordXArrivee + "," + coordYArrivee + ")");

		
		while (((coordXCourante == coordXArrivee) &&
				(coordYCourante == coordYArrivee))==false) {
			
			if(coordXCourante > coordXArrivee && coordYCourante > coordYArrivee) {
				coordXCourante -= 1;
				coordYCourante -= 1;
				System.out.println("Déplacement optimal : sw, "+
						"nouveaux coordonnées : (" + coordXCourante + "," + coordYCourante + ")");
			} else if(coordXCourante > coordXArrivee && coordYCourante < coordYArrivee) {
				System.out.println("Déplacement optimal : nw");
				coordXCourante -= 1;
				coordYCourante += 1;
			} else if(coordXCourante < coordXArrivee && coordYCourante < coordYArrivee) {
				System.out.println("Déplacement optimal : ne");
				coordXCourante += 1;
				coordYCourante += 1;
			} else if(coordXCourante < coordXArrivee && coordYCourante > coordYArrivee) {
				System.out.println("Déplacement optimal : se");
				coordXCourante += 1;
				coordYCourante -= 1;
			} else if(coordXCourante == coordXArrivee && coordYCourante < coordYArrivee) {
				System.out.println("Déplacement optimal : n");
				coordXCourante -= 0;
				coordYCourante += 2;
			} else if(coordXCourante == coordXArrivee && coordYCourante > coordYArrivee) {
				System.out.println("Déplacement optimal : s");
				coordXCourante -= 0;
				coordYCourante -= 2;
			} else if(coordXCourante > coordXArrivee && coordYCourante == coordYArrivee) {
				System.out.println("Déplacement optimal : sw + nw");
			} else if(coordXCourante < coordXArrivee && coordYCourante == coordYArrivee) {
				System.out.println("Déplacement optimal : se + ne");
			}
			
			nombreDeplacementMinimum++;
		}
		System.out.println("nombre de déplacements initiaux : " + tableauDirection.length);
		System.out.println("nombre de déplacements minimum : " + nombreDeplacementMinimum);
		System.out.println("");
	}

}
