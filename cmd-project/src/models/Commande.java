package models;

public abstract class Commande implements IExecutable {
	
private String nom;


public Commande(String pNom) {
	this.nom=pNom;
}

}
