package model;

import java.util.Set;

public class Noeud {

	private String nom;
	private Set<String> enfants;
	private int valeur;

	private String pere;
	private Integer profondeur;
	private int sommeValeur;
	
	

	@Override
	public String toString() {
		return "Noeud [nom=" + nom + ", enfants=" + enfants + ", valeur=" + valeur + ", pere=" + pere + ", profondeur="
				+ profondeur + ", sommeValeur=" + sommeValeur + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<String> getEnfants() {
		return enfants;
	}

	public void setEnfants(Set<String> enfants) {
		this.enfants = enfants;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public String getPere() {
		return pere;
	}

	public void setPere(String pere) {
		this.pere = pere;
	}

	public Integer getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(Integer profondeur) {
		this.profondeur = profondeur;
	}

	public int getSommeValeur() {
		return sommeValeur;
	}

	public void setSommeValeur(int sommeValeur) {
		this.sommeValeur = sommeValeur;
	}

}
