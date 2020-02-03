package pse;

import objets.objet;
import sac.sacADos;

public class pse {
	
	private arbre p�re1;
	private sacADos sac;
	
	public pse(sacADos sac) {
		this.sac = sac;
		this.p�re1 = new arbre(sac);
	}
	
	public void resoudre() {
		 for (objet objet : p�re1.getListFinal())
			 sac.addObje(objet);
	}
}
