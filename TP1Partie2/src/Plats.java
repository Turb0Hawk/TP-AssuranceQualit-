//----------------------------------------------------------------------------------------------------------------------
//Programmeur: David Ringuet
//Date: 04-02-2019
//Fichier Plats.java
//
//Description de la classe: Cette classe permet de cr�er un plat qui pourras �tre utiliser plus tard
//
//----------------------------------------------------------------------------------------------------------------------
public class Plats {
	private String nom;
	private double prix;

	public Plats( String nom, double prix ) {
		setNom( nom );
		setPrix( prix );
	}

	public String getNom() {
		return this.nom;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setNom( String nom ) {
		this.nom = nom;
	}

	public void setPrix( double prix ) {
		this.prix = prix;
	}
}
