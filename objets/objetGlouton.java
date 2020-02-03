package objets;

public class objetGlouton extends objet implements Comparable<objetGlouton> {
	float rapport;

	public objetGlouton(String nom, float poids, float prix) {
		super(nom, poids, prix);
		this.rapport = prix / poids;
	}

	public float getRapport() {
		return rapport;
	}

	@Override
	public int compareTo(objetGlouton obj1) {
		if (this.rapport > obj1.getRapport()) {
			return -1;
		} else if (this.rapport < obj1.getRapport()) {
			return 1;
		} else {
			return 0;
		}
	}

}
