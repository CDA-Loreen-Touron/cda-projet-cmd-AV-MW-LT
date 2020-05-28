package models;

import tools.EntreeClavier;

public final class CommandeIsPrime extends Commande {

	private static boolean isPrime=true;
	public CommandeIsPrime(String pNom) {
		super(pNom);

	}

	public  void executer() {
		System.out.println("******** Saisissez un nombre entier sup�rieur � z�ro. *******");
		
		try {
			int i=EntreeClavier.lireInt();
			if (i<1) {
				System.out.println("Saisissez un nombre entier sup�rieur � 0.");
			}else {
			
			for (int j=2; j<i;j++) {
				if(i%j==0) {
					isPrime=false;
					break;
				}else {
					isPrime=true;
				}
			}
			if(isPrime==true) {
				System.out.println(i+" est bien un nombre premier.");
			}else {
				System.out.println(i + " n'est pas un nombre premier.");
			}
			}
		} catch (Exception e) {
			this.executer();
			System.out.println("Veuillez entrer un nombre sup�rieur � 0 sans virgule.");
		}
		
		
		
	}

	
	
	
	
	
	
}
