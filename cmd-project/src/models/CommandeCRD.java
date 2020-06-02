package models;
import java.io.File;
import java.io.IOException;


public class CommandeCRD extends Commande {

	
	public CommandeCRD(String pNom, String pDescription) {
		super(pNom, pDescription);
		
	}
	
	private String params = "";

	@Override
	public void executer() {
		
		File file = new File(params);
		
        if (!file.exists()) {
        	
            if (file.mkdir()) {//mkdir = creation, renvoie � des boolean
            	
                System.out.println("Le repertoire est cr�e!");
                
            } else {
            	
                System.out.println("Erreur lors de la cr�ation!");
            }
        }

        
        //SI ON VEUT CREER PLUSIEURS REPERTOIRES:
        /*File files = new File("C:\\Directory2\\Sub2\\Sub-Sub2");
        //sub sont des sous repertoires
        
        if (!files.exists()) {
        	
            if (files.mkdirs()) {
            	
                System.out.println("Plusieurs repertoires ont �t� cr��s!");
                
            } else {
            	
                System.out.println("erreur!");
            }
        }*/
}
	
	public void setParams(String argument) {
		this.params = argument;
	}
}
	



/*-   ajouter la commande "CRD" qui prend un param�tre, et cr�e un r�pertoire avec ce nom dans le r�pertoire en cours
    (r�pertoire en cours == le chemin qu'affiche la commande pwd)
    
    > dir
     <DIR>  rep1
            f1.txt
    > crf rep2
    > dir
     <DIR>  rep1
     <DIR>  rep2   
            f1.txt  
            */


