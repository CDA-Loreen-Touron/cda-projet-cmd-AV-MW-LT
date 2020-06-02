package models;

public class Pwd extends Commande {

	public Pwd(String pNom) {
		super(pNom);
	}

	@Override
	public void executer() {
		if (Commande.getNom().equals("pwd")) {
			System.out.println("");
		} else {
		System.out.println("Commande introuvable");
	}
}
	
	
}

/*
ajouter la commande "CD" qui permet de se déplacer dans un répertoire qui existe dans le dossier en cours.
le dossier en cours est la racine par défaut : c:\
pour remonter dans le dossier parent utiliser ".." comme paramètre.
la commande pwd est impacté !!! pwd affiche le dossier courant !!
les commandes dir et dirng sont aussi impactées
exemple :
> pwd 
C:\
*/


/*si la commande est égale à "pwd" , afficher le message "Commande pas encore implémentée"
sinon , le message "Commande introuvable" est affiché*/