package dynamique;

import sac.sacADos;

public class dynamique {
	private int O[][]; // tableau 2D d'objets
	private sacADos sac;

	/**
	 * Constructeur de la mthode dynamique
	 **/
	public dynamique(sacADos sac) {
		this.sac = sac;
		this.O = new int[sac.getObjetPossible().size()][(int) (this.sac.getPoidsMax() * 100) + 1]; // Taille tableau :
																									// nbObjetPossible *
																									// poidMaxDuSac
	}

	/**
	 * Permet d'initialiser le tableau 2D
	 **/
	public void initTab() {
		
		//Rempli la premire ligne du tableau 
		for (int i = 0; i <= (int) (this.sac.getPoidsMax() * 100); ++i) {
			//Si le poid de l'objet est > i
			if ((int) (this.sac.getOPindex(0).getPoids() * 100) > i)
				this.O[0][i] = 0;
			else
				this.O[0][i] = (int) (this.sac.getOPindex(0).getPrix() * 100);
		}
		//Rempli les autres lignes
		for (int i = 1; i < this.sac.getObjetPossible().size(); ++i) {
			for (int j = 0; j <= (this.sac.getPoidsMax() * 100); ++j) {
				//Si l'objet actuel  un poids > j alors on prend l'objet au dessus dans le tableau
				if ((int) (this.sac.getOPindex(i).getPoids() * 100) > j) {
					this.O[i][j] = this.O[i - 1][j];
				}
					
				else {
					//Ajoute l'objet avec la meilleure valeur 
					//entre l'objet au-dessus et 
					//l'objet  la ligne actuelle et (la colonne - le poids de l'objet) + son prix
					this.O[i][j] = (int) (Math.max(this.O[i - 1][j],this.O[i - 1][j - ((int) (this.sac.getOPindex(i).getPoids() * 100))]+ ((int) (this.sac.getOPindex(i).getPrix() * 100))));
					//System.out.println(O[i][j]);
				}
			} 
		}
			
	}
	
	/**
	 * Ajoute dans le sac les objets optimales.
	 **/
	public void resoudre() {
		initTab();
		
		int i = this.sac.getObjetPossible().size()-1;
		int j = (int) this.sac.getPoidsMax() * 100;
		
		//Pour la premire ligne on cherche  trouver une valeur diffrentte  la primire
		while (this.O[i][j] == this.O[i][j - 1]) {
			j--;
		}
		while (j > 0) {
			//Tant que lobjet actuelle est gale  l'objet au dessus en remonte
			while (i > 0 && this.O[i][j] == this.O[i - 1][j])
				i--;
			//Dcalage vers la gauche par rapport au poids de l'objet actuelle
			j = j - ((int) this.sac.getOPindex(i).getPoids() * 100);
			if (j >= 0)
				this.sac.addObje(this.sac.getOPindex(i));
			i--;
		}
	}

}
