package models;

import tools.EntreeClavier;

public class CommandeRiver extends Commande {

	public CommandeRiver(String pNom) {
		super(pNom);

	}

	public void executer() {
		try {

			System.out.println("****** Saisissez un premier nombre entier. ******");
			int a = EntreeClavier.lireInt();
			System.out.println("****** Saisissez un deuxi�me entier pour la rivi�re. ******");
			int b = EntreeClavier.lireInt();
			while (a!=b) {
				if(a<b) {
					a+=sumDigits(a);
				}else {
					b+=sumDigits(b);
				}
			}
			
			System.out.println("Les rivi�res se croisent en " + a);

		} catch (Exception e) {
			System.out.println();
		}
	}

	public static int sumDigits(int pNombre) {
	    return pNombre == 0 ? 0 : pNombre % 10 + sumDigits(pNombre / 10);
	}
}
