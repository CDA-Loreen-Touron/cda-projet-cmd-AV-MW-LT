package models;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Help extends Commande {

	
	public Help(String pNom, String pDescription) {
		super(pNom, pDescription);

	}

	@Override
	public void executer() {

		System.out.println("Bonjour de la part de la console CDA :)");

		Map<String, String> hm = new HashMap<String, String>();// creation liste des commandes

		// j'y mets les commandes une par une
		hm.put("historique",
				"Cette commande affiche ,en plus de la commande, les parametres passes � la commande et la date de l'execution de la commande avec ce format 11:40:22 03/10/2018.");
		hm.put("cat",
				"Cette commande prend en parametre le nom d'un fichier dans le repertoire en cours et afficher son contenu à la console.");
		hm.put("crf", "Cette commande prend un parametre et cree un fichier avec ce nom dans le repertoire en cours ");
		hm.put("crd",
				"Cette commande prend un parametre et cree un repertoire avec ce nom dans le repertoire en cours");
		hm.put("cd", "Cette commande permet de se deplacer dans un repertoire qui existe dans le dossier en cours.");
		hm.put("dir", "Cette commande affiche le contenu du repertoire");
		hm.put("dirng",
				"Cette commande affiche le contenu du repertoire en cours,exactement comme la commande dir, mais en plus affiche le nombre de repertoire et le nombre de fichier.");
		hm.put("CommandeIsPrime",
				"Cette commande prend en parametre un entier et affiche yes si ce parametre est un nombre premier non sinon");
		hm.put("CommandeRiver",
				"Cette commande prend 2 parametres en entree et affiche la premiere intersection des rivieres obtenues pour ces parametres");

		System.out.println(hm);// j'affiche la liste
		
		//si on ajoute une nvelle commande , on entre sa clef et sa valeur:
		Set set = hm.entrySet();
		
		Iterator i = set.iterator();
		 
		while(i.hasNext()) {
	         Map.Entry me = (Map.Entry)i.next();
	         System.out.print(me.getKey() + ": ");
	         System.out.println(me.getValue());
	      }
		
		
		  //Parcours de la map
		  System.out.println("Parcours de la liste des commandes: ");
	      Set<Entry<String, String>> setHm = hm.entrySet();
	      Iterator<Entry<String, String>> it = setHm.iterator();
	      while(it.hasNext()){
	         Entry<String, String> e = it.next();
	         System.out.println(e.getKey() + " : " + e.getValue());
	      }
	      
	      System.out.println("Valeur pour la clé 8 : " + hm.get(8));
		 

}
}

// si la commande est �gale � "help" afficher le message "Bonjour sur la console cda
//La commande "Help" doit afficher une description pour chaque commande