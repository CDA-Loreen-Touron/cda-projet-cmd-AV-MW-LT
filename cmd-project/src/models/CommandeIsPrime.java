package models;

import java.util.Scanner;

public final class CommandeIsPrime extends Commande {

	Scanner sc = new Scanner(System.in);
	private static boolean isPrime = true;

	public CommandeIsPrime(String pNom, String pDescription) {
		super(pNom, pDescription);
	}

	@Override
	public void executer(String pParams) {
		try {

			int i = Integer.parseInt(pParams);
			if (i < 1) {

				System.out.println("no");
			} else if (i == 0) {

				System.out.println("no");
			} else {

				for (int j = 2; j < i; j++) {
					if (i % j == 0) {
						isPrime = false;
						break;
					} else {
						isPrime = true;
					}
				}
				if (isPrime == true) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
		} catch (Exception e) {
			System.out.println("Erreur de saisie de la commande isprime.");
			System.out.println("Exemple : isprime 11");
		}

	}

	@Override
	public void executer() {

		System.out.println("Cette commande nécessite un argument");
	}

}
