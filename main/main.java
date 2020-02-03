package main;

import sac.sacADos;

public class main {
	public static void main(String[] args) {
		String path = args[0];
		float poids_max = Float.parseFloat(args[1]);
		String methode = args[2];

		sacADos sac_a_dos = new sacADos(path, poids_max);
		sac_a_dos.resoudre(methode);
		System.out.println(sac_a_dos.toString());
	}
}