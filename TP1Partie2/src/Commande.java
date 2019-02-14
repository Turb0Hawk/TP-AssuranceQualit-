import java.util.ArrayList;

//----------------------------------------------------------------------------------------------------------------------
//Programmeur: David Ringuet
//Date: 04-02-2019
//Fichier Plats.java
//
//Description de la classe: 
//Cette classe permet de cr��er un objet qui repr�sente un client et les plats qu'il commande. 
//Cette classe assume que l'entr�e est v�rifi� avant et ne contiens pas d'erreur.
//
//----------------------------------------------------------------------------------------------------------------------
public class Commande {
	String nomClient;
	int qte;
	Plats plat;

	public Commande( String nom ) {
		setClient( nom );
	}

	public Commande( String nom, int qte, Plats plat ) {
		setClient( nom );
		setQte( qte );
		setPlat( plat );
	}

	public Commande( String nom, int qte, String nomPlat, double prix ) {
		setClient( nom );
		setQte( qte );
		setPlat( nomPlat, prix );
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

	/**
	 * La methode printCommande() permet d'imprimer la commande courante dans un
	 * format pr�d�termin�.
	 * 
	 * @return la commande formatt� selon un format pr�d�termin�
	 */

	public String printCommande() {
		return nomClient + " :  " + plat.getPrix() * qte + " $";
		// PLEASE USE THIS
	}

	/**
	 * La methode ajouterBonPlat() permet d'ajouter a la commande courrante le
	 * bon plat qui lui est associe depuis une liste.
	 * 
	 * @param plats
	 *            La liste des plats qui existe.
	 * @param nomPlat
	 *            le nom du plat a ajouter a la commande
	 * 
	 */

	public static Plats trouverPlat( ArrayList<Plats> plats, String nomPlat ) {
		// PLEASE USE THIS
		Plats platTemp = null;
		for ( Plats platCourrant : plats ) {
			if ( platCourrant.getNom() == nomPlat ) {
				platTemp=  platCourrant ;
				break;
			}
		}
		return platTemp;
	}
}
