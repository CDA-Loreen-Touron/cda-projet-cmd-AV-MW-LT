package models;

import tools.EntreeClavier;

public class CommandeRiver extends Commande {

	public CommandeRiver(String pNom) {
		super(pNom);

	}

	public void executer() {
		try {
			System.out.println("****** Saisissez un premier nombre entier supérieur à 0. ******");
			int a = EntreeClavier.lireInt();
			if(a<1) {
				System.out.println("Erreur de saisie. Retour au menu principal.");
			}else {
			System.out.println("****** Saisissez un deuxième entier pour la rivière. ******");
			int b = EntreeClavier.lireInt();
			if(b<0) {
				System.out.println("Erreur de Saisie. Retour au menu principal.");
			}else {
				int boucles=0;
			while (a!=b || boucles <20) {
				if(a<b) {
					a+=sumDigits(a);
					boucles++;
				}else {
					b+=sumDigits(b);
					boucles ++;
				}
			}
			if( boucles>19) {
				System.out.println("Désolé. Calcul trop long à réaliser.");
			}else {
			System.out.println("Les rivières se croisent en " + a);
			}
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
