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
		hm.put("historique","Cette commande affiche ,en plus de la commande, les paramètres passés à la commande et la date de l’exécution de la commande avec ce format 11:40:22 03/10/2018.");
		hm.put("cat", "Cette commande prend en paramètre le nom d'un fichier dans le répertoire en cours et afficher son contenu à la console.");
		hm.put("crf", "Cette commande prend un paramètre et crée un fichier avec ce nom dans le répertoire en cours ");
		hm.put("crd", "Cette commande prend un paramètre et crée un répertoire avec ce nom dans le répertoire en cours");
		hm.put("cd", "Cette commande permet de se déplacer dans un répertoire qui existe dans le dossier en cours.");
		hm.put("dir", "Cette commande affiche le contenu du répertoire");
		hm.put("dirng", "Cette commande affiche le contenu du répertoire en cours,exactement comme la commande dir, mais en plus affiche le nombre de répertoire et le nombre de fichier.");
		hm.put("CommandeIsPrime","Cette commande prend en paramètre un entier et affiche yes si ce paramètre est un nombre premier non sinon");
		hm.put("CommandeRiver","Cette commande prend 2 paramètres en entrée et affiche la première intersection des rivières obtenues pour ces paramètres");
		
		System.out.println(hm);//j'affiche la liste
		
	}
	
	
	
	
	

}

// si la commande est ï¿½gale ï¿½ "help" afficher le message "Bonjour sur la console cda
//La commande "Help" doit afficher une description pour chaque commande