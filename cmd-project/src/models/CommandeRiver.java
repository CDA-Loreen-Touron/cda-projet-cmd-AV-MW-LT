package models;

import tools.EntreeClavier;

public class CommandeRiver extends Commande {

	public CommandeRiver(String pNom) {
		super(pNom);

	}

	
	@Override
	public void executer() {
		try {
		
			int a = EntreeClavier.lireInt();
			if(a<1) {
			
			}else {
			System.out.println("****** Saisissez un deuxième entier pour la rivière. ******");
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
			System.out.println("Les rivières se croisent en " + a);
			
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
