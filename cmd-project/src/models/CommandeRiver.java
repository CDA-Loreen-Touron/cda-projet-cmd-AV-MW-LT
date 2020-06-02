package models;

public final class CommandeRiver extends Commande {

	private String param;


	public CommandeRiver(String pNom, String pDescription) {
		super(pNom, pDescription);
	}
		


	@Override
	public void executer() {

		try {
			int index = 0;
			String paramB = "";

			for (int i = 0; i < param.length(); i++) {
				if (param.charAt(i) == ' ') {
					index = i;
					break;
				} else if (param.charAt(i) == '-') {
					break;
				}
			}

			int a = Integer.valueOf(param.substring(0, index).trim());

			paramB = param.substring(index + 1, param.length()).trim();

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

	public void setParam(String param) {
		this.param = param.trim();

	}

	@Override
	public void executer(String pParams) {
		// TODO Auto-generated method stub
		
	}
}
