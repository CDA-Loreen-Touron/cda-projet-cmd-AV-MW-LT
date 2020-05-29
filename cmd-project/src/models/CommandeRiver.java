package models;

import tools.EntreeClavier;

public class CommandeRiver extends Commande {

	public CommandeRiver(String pNom) {
		super(pNom);

	}

	
	@Override
	public void executer() {
		try {
			System.out.println("****** Saisissez un premier nombre entier sup�rieur � 0. ******");
			int a = EntreeClavier.lireInt();
			if(a<1) {
				System.out.println("Erreur de saisie. Retour au menu principal.");
			}else {
			System.out.println("****** Saisissez un deuxi�me entier pour la rivi�re. ******");
			int b = EntreeClavier.lireInt();
			if(b<0) {
				System.out.println("Erreur de Saisie. Retour au menu principal.");
			}else {
			while (a!=b ) {
				if(a<b) {
					a+=sumDigits(a);

				}else {
					b+=sumDigits(b);
				}
			}
			System.out.println("Les rivi�res se croisent en " + a);
			
			}
		} 
			}catch (Exception e) {
	System.out.println("Saisie incorrecte.");
		}
	}
	
	public static int sumDigits(int pNombre) {
	    return pNombre == 0 ? 0 : pNombre % 10 + sumDigits(pNombre / 10);
	}
}
