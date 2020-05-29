package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Cat extends Commande {

	public Cat(String pNom) {
		super(pNom);

	}

	private String params;

	@Override
	public void executer() {
		File file = new File(params);
		
		if(!file.exists()) {
			System.out.println(" Le fichier n'existe pas ");
		}else {
			
			try(BufferedReader bf = new BufferedReader(new FileReader(file))) {
				boolean verif = true;
				do {
					String line = bf.readLine();
					if(line!=null) {
						System.out.println(line);
					}else {
						verif=false;
						this.params="";
					}
					
					
				}while(verif);
			} catch (Exception e) {
				System.out.println("Erreur lors de la lecture du fichier");
			}
			
			
		}
		
	}

	public void setParams(String params) {
		this.params = params;
	}
	
	
}
