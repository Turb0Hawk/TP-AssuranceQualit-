//----------------------------------------------------
//Programmeur: David Ringuet
//Date: 04-02-2019
//Fichier Plats.java
//
//Description de la classe: 
//Cette classe permet de crééer un objet qui représente un client et les plats qu'il commande. 
//Cette classe assume que l'entrée est vérifié avant et ne contiend pas d'erreur.
//
//----------------------------------------------------
public class Commande {
	String nomClient;
	int qte;
	Plats plat;

	public Commande( String nom ) {
		setClient( nom );
	}

	public void setClient( String nom ) {
		this.nomClient = nom;
	}

	public void setQte( int qte ) {
		this.qte = qte;
	}

	public void setPlat( String nom, double prix ) {
		this.plat = new Plats( nom, prix );
	}

	public void setPlat( Plats plat ) {
		this.plat = plat;
	}
	
	@
	public String toString() {
		return nomClient;
		
	}
}
