package exec;

import models.CommandeIsPrime;
import tools.Menu;

public class ProgramMain {

	public static void main(String[] args) {
		
			CommandeIsPrime a=new CommandeIsPrime(null);
			a.executer();
			Menu.menu();
	}

}
