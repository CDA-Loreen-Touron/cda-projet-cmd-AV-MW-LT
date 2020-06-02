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
			if (i < 1) {

				System.out.println("no");
			}else {

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
			System.out.println("Erreure de saisie de la commande isprime.");
			System.out.println("Exemple : isprime 11");
		}

	}

	public void setParam(String pParam) {
		this.param = pParam.trim();

	}

	@Override
	public void executer(String pParams) {
		// TODO Auto-generated method stub
		
	}
}
