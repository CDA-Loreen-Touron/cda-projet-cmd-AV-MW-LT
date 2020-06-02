package models;

import java.util.Map;
import java.util.Properties;

public final class CommandeGetVars extends Commande {

	public CommandeGetVars(String pNom, String pDescription) {
		super(pNom, pDescription);

	}

	private String param = "";

	

	@Override
	public void executer() {

		try {
			Map<String, String> env = System.getenv();

			Properties properties = System.getProperties();

			if (param.equals("-env")) {

				for (Map.Entry<String, String> entry : env.entrySet()) {
					System.out.println(entry.getKey() + " 		: " + entry.getValue());
				}
			} else if (param.equals("-prop")) {

				properties.forEach((k, v) -> System.out.println(k + "	:" + v));
			} else {
				System.out.println("============== VARIABLES D'ENVIRONNMEENT ==============");
				System.out.println();
				for (Map.Entry<String, String> entry : env.entrySet()) {
					System.out.println(entry.getKey() + " 		: " + entry.getValue());
				}
				System.out.println();
				System.out.println("=================   PROPRIETES DE LA JVM  =================");
				System.out.println();
				properties.forEach((k, v) -> System.out.println(k + "	:" + v));
			}
		} catch (Exception e) {
			System.out.println("Erreur de saisie de paramètre");
		}

	}

	public String getParam() {
		return param;
	}

	public void setParam(String pParam) {
		if (pParam == null) {
			this.param = pParam;
		} else {
			this.param = pParam.trim();
		}
	}

	@Override
	public void executer(String pParams) {
		// TODO Auto-generated method stub
		
	}


}
