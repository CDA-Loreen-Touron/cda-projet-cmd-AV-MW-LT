package models;

public final class CommandeRiver extends Commande {


	public CommandeRiver(String pNom) {
		super(pNom);
	}

	@Override
	public void executer(String pParam) {

		try {
			int index = 0;
			String paramB = "";

			for (int i = 0; i < pParam.length(); i++) {
				if (pParam.charAt(i) == ' ') {
					index = i;
					break;
				} else if (pParam.charAt(i) == '-') {
					break;
				}
			}

			int a = Integer.valueOf(pParam.substring(0, index).trim());

			paramB = pParam.substring(index + 1, pParam.length()).trim();

			for (int i = 0; i < paramB.length(); i++) {
				if (paramB.charAt(i) == '-') {
					System.out.println("Erreur de saisie");
					break;
				} else {

					int b = Integer.valueOf(paramB);

					while (a != b) {
						if (a < b) {
							a += sumDigits(a);

						} else {
							b += sumDigits(b);
						}
					}
				}
			}
			System.out.println("Les rivières se croisent en " + a);
		} catch (Exception e) {
			System.out.println("Saisie incorrecte.");
		}
	}

	public static int sumDigits(int pNombre) {
		return pNombre == 0 ? 0 : pNombre % 10 + sumDigits(pNombre / 10);
	}



	@Override
	public void executer() {
		// TODO Auto-generated method stub
		
	}
}
