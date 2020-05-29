package models;

import java.util.Scanner;

public final class CommandeIsPrime extends Commande {

	Scanner sc = new Scanner(System.in);
	private static boolean isPrime = true;
	private String param = "";

	public CommandeIsPrime(String pNom) {
		super(pNom);
	}

	@Override

	public void executer() {

		try {
			int i = Integer.parseInt(param);
			if(i<1) {
				System.out.println("Paramètre négatif");
			}

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
		} catch (Exception e) {
			System.out.println("Erreure de saisie de la commande isprime.");
			System.out.println("Exemple : isprime 11");	
		}

	}

	public void setParam(String pParam) {
		this.param = pParam.trim();
		
	}
}
