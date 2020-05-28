package exec;

import models.CommandeRiver;
import tools.Menu;

public class ProgramMain {

	public static void main(String[] args) {
		
		CommandeRiver a= new CommandeRiver(null);
		a.executer();
		
			Menu.menu();
			
	}

}
