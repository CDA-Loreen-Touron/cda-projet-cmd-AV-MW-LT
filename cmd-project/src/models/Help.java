package models;

import java.util.HashMap;
import java.util.Map;

public class Help extends Commande {

	public Help(String pNom, String pDescription) {
		super(pNom, pDescription);
	}

	@Override
	public void executer() {
		
		System.out.println("Bonjour de la part de la console CDA :)");
		
		Map<String, String> hm = new HashMap<String, String>();//creation liste des commandes
		
		
		//j'y mets les commandes une par une
		hm.put("historique","Cette commande affiche ,en plus de la commande, les param�tres pass�s � la commande et la date de l�ex�cution de la commande avec ce format 11:40:22 03/10/2018.");
		hm.put("cat", "Cette commande prend en param�tre le nom d'un fichier dans le r�pertoire en cours et afficher son contenu � la console.");
		hm.put("crf", "Cette commande prend un param�tre et cr�e un fichier avec ce nom dans le r�pertoire en cours ");
		hm.put("crd", "Cette commande prend un param�tre et cr�e un r�pertoire avec ce nom dans le r�pertoire en cours");
		hm.put("cd", "Cette commande permet de se d�placer dans un r�pertoire qui existe dans le dossier en cours.");
		hm.put("dir", "Cette commande affiche le contenu du r�pertoire");
		hm.put("dirng", "Cette commande affiche le contenu du r�pertoire en cours,exactement comme la commande dir, mais en plus affiche le nombre de r�pertoire et le nombre de fichier.");
		hm.put("CommandeIsPrime","Cette commande prend en param�tre un entier et affiche yes si ce param�tre est un nombre premier non sinon");
		hm.put("CommandeRiver","Cette commande prend 2 param�tres en entr�e et affiche la premi�re intersection des rivi�res obtenues pour ces param�tres");
		
		System.out.println(hm);//j'affiche la liste
		
	}
	
	
	
	
	

}

// si la commande est �gale � "help" afficher le message "Bonjour sur la console cda
//La commande "Help" doit afficher une description pour chaque commande