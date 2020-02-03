package pse;

import java.util.ArrayList;

import objets.objet;
import sac.sacADos;

public class arbre {
	private arbre arbreDroit;
	private arbre arbreGauche;
	private ArrayList<objet> listObjRestant;
	private ArrayList<objet> listObjContenu;
	static float BorneInf;// valeur de la meilleur solution tjr mettre à jour
	static ArrayList<objet> listFinal;
	private boolean fin;
	static float pMax;
	static int nbNoeuds = 0;
	//static int sizeArbre = 4;
	/* Arbre Père */
	public arbre(sacADos sac) {
		this.listObjRestant = new ArrayList<objet>(sac.getObjetPossible());
		this.listObjContenu = new ArrayList<>();
		arbre.pMax = sac.getPoidsMax();
		setBorneInf();
		
		if (resteDesObjets() && YaDeLaPlace() && BorneSupCorrect()) {
			this.fin = false;
			this.arbreDroit = new arbre(this.listObjRestant, this.listObjContenu, true);
			this.arbreGauche = new arbre(this.listObjRestant, this.listObjContenu, false);
		}
		else if (resteDesObjets() && !YaDeLaPlace() && BorneSupCorrect()) {
			this.fin = false;
			this.arbreDroit = null;
			this.arbreGauche = new arbre(this.listObjRestant, this.listObjContenu, false);
		}
		else {
			this.fin = true;
			this.arbreDroit = null;
			this.arbreGauche = null;
		}
	}

	/* Je créee mes sous arbres */
	public arbre(ArrayList<objet> objRestant, ArrayList<objet> objContenu, boolean isDroit) {
		this.listObjRestant = new ArrayList<objet>(objRestant);
		this.listObjContenu = new ArrayList<objet>(objContenu);
		nbNoeuds++;
		if (isDroit) { this.ajouter(); } 
		else { this.transmettre(); }
		setBorneInf();
		createNewArbre();
	}

	public boolean resteDesObjets() {
		return !this.listObjRestant.isEmpty();
	}

	public boolean YaDeLaPlace() {
		float poids = this.listObjRestant.get(0).getPoids();
		if (!this.listObjContenu.isEmpty())
			for (objet objet : listObjContenu)
				poids += objet.getPoids();
		return poids <= pMax;
	}

	public void ajouter() {
		this.listObjContenu.add(this.listObjRestant.get(0));
		this.listObjRestant.remove(this.listObjRestant.get(0));
	}

	public void transmettre() {
		this.listObjRestant.remove(this.listObjRestant.get(0));
		if (this.listObjRestant.isEmpty()) {
			this.fin = true;
		}
	}

	public void createNewArbre() {
		if (resteDesObjets() && YaDeLaPlace() && BorneSupCorrect()) {
			this.fin = false;
			this.arbreDroit = new arbre(this.listObjRestant, this.listObjContenu, true);
			this.arbreGauche = new arbre(this.listObjRestant, this.listObjContenu, false);
		}
		else if (resteDesObjets() && !YaDeLaPlace() && BorneSupCorrect()) {
			this.fin = false;
			this.arbreDroit = null;
			this.arbreGauche = new arbre(this.listObjRestant, this.listObjContenu, false);
		}
		else {
			this.fin = true;
			this.arbreGauche = null;
			this.arbreDroit = null;
		}
	}
	
	public boolean BorneSupCorrect(){
		return this.getBorneSup() > BorneInf; 
	}
	
	public float getBorneSup() {
		float borneSup = 0;
		for (objet objet : this.listObjContenu)			
			borneSup += objet.getPrix();
		for (objet objet : this.listObjRestant)
			borneSup += objet.getPrix();
		return borneSup;
	}
	
	public void setBorneInf() {
		float borneInf = 0;
		for (objet objet : this.listObjContenu)
			borneInf += objet.getPrix();
		if (borneInf > BorneInf) {
			BorneInf = borneInf;
			listFinal = new ArrayList<objet>(this.listObjContenu);
		}
	}
	
	public ArrayList<objet> getListFinal() {
		return listFinal;
	}
	
	public String toString() {
		String chaine = "";
		
		chaine += "Liste : ";
		if (!this.listObjContenu.isEmpty()) {
			for (objet objet : this.listObjContenu) {
				chaine += objet.getNom() + " / ";
			}
		}
		chaine += System.lineSeparator();
		if (this.arbreDroit != null) {
			chaine += "Droit = " + this.arbreDroit.toString();
		}
		if(this.arbreGauche != null) {
			chaine += "Gauche = " + this.arbreGauche.toString();
		}
		
		
		return chaine;
	}
}