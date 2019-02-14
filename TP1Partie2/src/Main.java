import java.util.ArrayList;

//----------------------------------------------------------------------------------------------------------------------
//Programmeur: David Ringuet
//Date: 14-02-2019
//Fichier Main.java
//
//Description de la classe: 
//Cette classe permet de faire fonctionner le programme.
//
//----------------------------------------------------------------------------------------------------------------------
public class Main {

	public static void main( String[] args ) {
		ArrayList<Commande> commandes = new ArrayList<Commande>();
		ArrayList<Plats> listePlats = new ArrayList<Plats>();

		// TODO ouvrir fichier à lire

		// TODO lire les plats

		String nomDuPlat = "";
		String prix = "";
		listePlats.add( new Plats( nomDuPlat, Double.parseDouble( prix ) ) );

		// TODO lire les lignes des noms
		{
			String nomLu = "";
			String nomPlat = "";
			String qteLu = "";
			if ( nomCorrect( nomLu ) ) {
				commandes.add( new Commande( nomLu, Integer.parseInt( qteLu ),
						Commande.trouverPlat( listePlats, nomPlat ) ) );
			}
		}

		// TODO into the file to save
		for ( Commande commandeCourante : commandes ) {
			/* the file += ( */commandeCourante.printCommande()/* + "\n") */;
		}

		// TODO Save le fichier
	}
	
	public static boolean nomCorrect(String nomACheck) {
		//TODO ajouter les règles pour la vérif des noms
		return nomACheck.matches( "" )/*et autres r'egles*/;
	}
}
