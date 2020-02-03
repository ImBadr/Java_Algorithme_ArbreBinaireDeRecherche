package glouton;

import java.util.ArrayList;
import java.util.Collections;

import sac.sacADos;
import objets.objet;
import objets.objetGlouton;

public class glouton {
	private sacADos sac_a_dos;
	private ArrayList<objetGlouton> objsG = new ArrayList<>();

	public glouton(sacADos sac) {
		this.sac_a_dos = sac;
		ArrayList<objet> objetPossible = new ArrayList<>(sac_a_dos.getObjetPossible());
		for (objet objet : objetPossible) {
			objsG.add(new objetGlouton(objet.getNom(), objet.getPoids(), objet.getPrix()));
		}
	}

	public void getRapportObj(int i) {
		System.out.println(objsG.get(i).getRapport());
	}

	
	public void resoudre() {
		Collections.sort(objsG);
		/*for (objetGlouton objetGlouton : objsG) {
			System.out.println("Nom: " + objetGlouton.getNom() + " Rapport: " + objetGlouton.getRapport() + " Poids: " + objetGlouton.getPoids());
		}*/
		float poids_actuelle = 0;
		for (objetGlouton objetGlouton : objsG) {
			if ((poids_actuelle + objetGlouton.getPoids()) <= sac_a_dos.getPoidsMax()) {
				sac_a_dos.addObje(new objet(objetGlouton.getNom(), objetGlouton.getPoids(), objetGlouton.getPrix()));
				poids_actuelle += objetGlouton.getPoids();
			}
		}
	}
}
