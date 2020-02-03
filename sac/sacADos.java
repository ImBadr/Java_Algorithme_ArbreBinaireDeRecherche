package sac;

import java.util.ArrayList;

import dynamique.dynamique;
import glouton.glouton;
import objets.objet;
import objets.readObjetsFile;
import pse.pse;

public class sacADos {
	private float POIDS_MAX;
	private ArrayList<objet> objetsPossible;
	private ArrayList<objet> objetsDansLeSac;
	private String path;

	@SuppressWarnings("null")
	public sacADos() {
		this.POIDS_MAX = (Float) null;
		this.objetsDansLeSac = new ArrayList<>();
		this.objetsPossible = new ArrayList<>();
	}

	public sacADos(String path, float poids_max) {
		this.POIDS_MAX = poids_max;
		this.objetsPossible = new readObjetsFile(path).getAllObjets();
		this.objetsDansLeSac = new ArrayList<>();
		this.path = path;
	}

	public float getPoidsMax() {
		return this.POIDS_MAX;
	}

	public void addObje(objet obj) {
		this.objetsDansLeSac.add(obj);
	}
	
	public ArrayList<objet> getListObjDansLeSac() {
		return this.objetsDansLeSac;
	}

	public ArrayList<objet> getObjetPossible() {
		return this.objetsPossible;
	}
	
	public objet getOPindex(int i) {
		return this.objetsPossible.get(i);
	}

	public int getSize() {
		return objetsDansLeSac.size();
	}

	public objet getObj(int i) {
		return objetsDansLeSac.get(i);
	}

	public float getPoidSac() {
		float poids = 0;
		for (objet objet : objetsDansLeSac) {
			poids += objet.getPoids();
		}
		return poids;
	}

	public float getValeurSac() {
		float prix = 0;
		for (objet objet : objetsDansLeSac) {
			prix += objet.getPrix();
		}
		return prix;
	}

	public String toString() {
		String txt = "";
		for (objet objet : objetsDansLeSac) {
			txt += objet.getNom() + "\n";
		}
		txt += "Poids total : " + this.getPoidSac() + "\n";
		txt += "Prix total : " + this.getValeurSac() + "\n";
		return txt;
	}

	public void resoudre(String methode) {
		switch (methode) {
		case "glouton":
			glouton g = new glouton(this);
			g.resoudre();
			break;
		case "dynamique":
			dynamique d = new dynamique(this);
			d.resoudre();
			break;
		case "pse":
			pse p= new pse(this); 
			p.resoudre();
			break;
		default:
			break;
		}
	}
}