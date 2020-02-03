package objets;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class readObjetsFile {
	private ArrayList<objet> objets;

	public readObjetsFile(String path) {
		this.objets = new ArrayList<>();
		try {

			File file = new File(path);

			Scanner input = new Scanner(file);

			while (input.hasNextLine()) {
				String line = input.nextLine();
				String[] objet = line.split(" ; ");
				objet obj = new objet(objet[0], Float.parseFloat(objet[1]), Float.parseFloat(objet[2]));
				objets.add(obj);
			}
			input.close();

		} catch (Exception ex) {
			System.out.println("Mauvais chemin d'accès");
		}

	}

	public ArrayList<objet> getAllObjets() {
		return objets;
	}

}
