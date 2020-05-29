package models;

import tools.EntreeClavier;

public final class CommandeRiver extends Commande {

	private String param;
	
	public CommandeRiver(String pNom) {
		super(pNom);
		this.param=param;

	}

	
	@Override
	public void executer() {
		try {
		
			int a = EntreeClavier.lireInt();
			int b=0;
			if(a<1) {
			
			
			while (a!=b ) {
				if(a<b) {
					a+=sumDigits(a);

				}else {
					b+=sumDigits(b);
				}
			}
			System.out.println("Les rivières se croisent en " + a);
			
			}
		
			}catch (Exception e) {
	System.out.println("Saisie incorrecte.");
		}
}
	
	public static int sumDigits(int pNombre) {
	    return pNombre == 0 ? 0 : pNombre % 10 + sumDigits(pNombre / 10);
	}


	public void setParam(String param) {
		this.param = param;
	}
}
