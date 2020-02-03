package objets;

public class objet {
	private String nom;
	private float poids;
	private float prix;

	public objet(String nom, float poids, float prix) {
		this.nom = nom;
		this.poids = poids;
		this.prix = prix;
	}

	public String getNom() {
		return this.nom;
	}

	public float getPoids() {
		return this.poids;
	}

	public float getPrix() {
		return this.prix;
	}
}
