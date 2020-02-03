package pse;

import objets.objet;
import sac.sacADos;

public class pse {
	
	private arbre père1;
	private sacADos sac;
	
	public pse(sacADos sac) {
		this.sac = sac;
		this.père1 = new arbre(sac);
	}
	
	public void resoudre() {
		 for (objet objet : père1.getListFinal())
			 sac.addObje(objet);
	}
}
