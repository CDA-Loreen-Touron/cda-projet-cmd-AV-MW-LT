package models;

public class CommandeCD extends Commande {

	
	public CommandeCD(String pNom) {
		super(pNom);
	}

	
	@Override
	public void executer() {
		// TODO Auto-generated method stub
		
	}
	
	//dans le dossier c:\\ qui est le dossier en cours il y a un repertoire affiché par dir, et dirng 
	
	

}

/*
 * ajouter la commande "CD" qui permet de se déplacer dans un répertoire qui existe dans le dossier en cours. : dir : affiche le contenu du repertoire
 * 
    le dossier en cours est la racine par défaut : c:\
    
    pour remonter dans le dossier parent utiliser ".." comme paramètre.
    la commande pwd est impacté !!! pwd affiche le dossier courant !!
    les commandes dir et dirng sont aussi impactées
    exemple :
    > pwd 
    C:\
    > dir
    <DIR> temp
    > cd temp
    > pwd
    c:\temp
    > dir
    <DIR> d1
    <DIR> d2
    > cd ..
    > pwd
    c:\
    > cd blibli
    Le chemin d’accès spécifié est introuvable.
    > cd .
    > pwd
    c:\ 
*/
