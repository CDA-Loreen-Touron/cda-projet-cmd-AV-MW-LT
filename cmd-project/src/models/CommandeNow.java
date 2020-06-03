package models;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
		

		public class CommandeNow extends Commande { //objet a zero ou un ou pl parametres

			
			public CommandeNow(String pNom, String pDescription) {
				super(pNom, pDescription);
			}
			
			
			Date aujourdhui = new Date();
			SimpleDateFormat formater = null;
			
			

			@Override
			public void executer(String pParams) {
				

				LocalDateTime ldt = LocalDateTime.now();//recupere time et date au moment T, methode now 
				
				DateTimeFormatter dtfH = DateTimeFormatter.ofPattern("HH:mm:ss");//instancie et initialise les objets dates et heures 
				DateTimeFormatter dtfD = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
				
			
				pParams=pParams.toLowerCase();
				pParams=pParams.replace(" ", "");
				//gerer : le fait de pouvoir mettre pl fois t ou d ca doit fonctionner, 
				//et le fait qu'une autre lettre + lettre existante indique une erreur = ok
				
				Pattern p =Pattern.compile("t{2,}");
				Matcher m=p.matcher(pParams);
				pParams=m.replaceAll("t");
				
				p=Pattern.compile("d{2,}");
				m=p.matcher(pParams);
				pParams=m.replaceAll("d");
				
				if (pParams.charAt(0)!='-') {
					System.out.println("Les options doivent commencer par -.");
				}else {

				
				
				
				
				p=Pattern.compile("[^dt-]");
				m=p.matcher(pParams);
				if(m.find()) {
					pParams="";
				}
				if(pParams.contains("-dt") || pParams.contains("-td") || pParams.contains("-t-d") || pParams.contains("-d-t")) {
					pParams ="-dt";
				}
				
				switch (pParams) {
				
					case "-t":
						
						System.out.println(ldt.format(dtfH));
					break;

					
					case "-d":
						
						System.out.println(ldt.format(dtfD));
					break;
					
					case "-dt":
						
						executer();
						break;
						
					
						
			
					default:
					System.out.println("option inexistante");
					break;
			
			
				}
				}
				
				}
			
			
			    

			@Override
			public void executer() {
				
				LocalDateTime ldt = LocalDateTime.now();
				DateTimeFormatter dtfHD = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy" );

				System.out.println(ldt.format(dtfHD));
			
				
			}

		}




			//localdatetime
			//objet date 
			
