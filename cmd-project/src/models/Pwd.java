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
ajouter la commande "CD" qui permet de se d�placer dans un r�pertoire qui existe dans le dossier en cours.
le dossier en cours est la racine par d�faut : c:\
pour remonter dans le dossier parent utiliser ".." comme param�tre.
la commande pwd est impact� !!! pwd affiche le dossier courant !!
les commandes dir et dirng sont aussi impact�es
exemple :
> pwd 
C:\
*/


/*si la commande est �gale � "pwd" , afficher le message "Commande pas encore impl�ment�e"
sinon , le message "Commande introuvable" est affich�*/