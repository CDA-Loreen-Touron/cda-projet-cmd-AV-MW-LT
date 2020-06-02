package models;

public abstract class Commande implements IExecutable {

	protected String nom;

	public Commande(String pNom) {
		this.nom = pNom;
	}

	public String getNom(String pNom) {
		return nom;
	}

}
