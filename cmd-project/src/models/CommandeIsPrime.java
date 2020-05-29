package models;

import java.util.Scanner;

import tools.EntreeClavier;

public final class CommandeIsPrime extends Commande {

	Scanner sc = new Scanner(System.in);
	private static boolean isPrime = true;

	public CommandeIsPrime(String pNom) {
		super(pNom);

	}

	@Override

	public void executer() {

		boolean condition = false;

		while (!condition) {
			try {
				String entree= EntreeClavier.lireString();
				
				int i=Integer.parseInt((entree.substring(8, entree.length())));
			
					for (int j = 2; j < i; j++) {
						if (i % j == 0) {
							isPrime = false;
							break;
						} else {
							isPrime = true;
						}
					}
					if (isPrime == true) {
						System.out.println(i + " est bien un nombre premier.");
					} else {
						System.out.println(i + " n'est pas un nombre premier.");
					}
				
				condition = true;
			} catch (Exception e) {
				System.out.println("Erreure de saisie de la commande isprime.");
				System.out.println("Exemple : isprime 11.");
				System.out.println(">");
			}

		} 
	}
}
