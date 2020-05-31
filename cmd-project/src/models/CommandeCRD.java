package models;

public class CommandeCRD extends Commande {

	private String nomRepertoire;
	
	public CommandeCRD(String pNom) {
		super(pNom);
	}

	@Override
	public void executer() {
		// TODO Auto-generated method stub
	}
	
	
	
	

}

/*-   ajouter la commande "CRD" qui prend un paramètre, et crée un répertoire avec ce nom dans le répertoire en cours
    (répertoire en cours == le chemin qu'affiche la commande pwd)
    > dir
     <DIR>  rep1
            f1.txt
    > crf rep2
    > dir
     <DIR>  rep1
     <DIR>  rep2   
            f1.txt  
            */
