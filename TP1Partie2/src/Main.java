import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
		boolean fichierOk = true;

		BufferedReader fic = new BufferedReader( new InputStreamReader( System.in ) );
		System.out.println( "Entrez le nom du fichier à lire: " );
		
		String nomFichier = "";
		try {
			nomFichier = fic.readLine();
		} catch ( IOException errIO ) {
			System.out.println( "\nUne erreur d'entrée-sortie" +
					" est survenue." );
			errIO.printStackTrace();
		}
		Path cheminFichier = new File( nomFichier ).toPath();
		Files.exists( cheminFichier );

		Charset charset = Charset.defaultCharset();
		List<String> listeLignesFichier = null;
		try {
			listeLignesFichier = Files.readAllLines( cheminFichier, charset );
		} catch ( IOException e ) {
			System.out.println( "Le fichier ne respecte pas le format demandé ! " );
			fichierOk = false;
			e.printStackTrace();
		}
		List<String> listeClients = listeLignesFichier.subList( listeLignesFichier.indexOf( "Clients :" ) + 1,
				listeLignesFichier.indexOf( "Plats :" ) );
		List<String> listeNomPlats = listeLignesFichier.subList( listeLignesFichier.indexOf( "Plats :" ) + 1,
				listeLignesFichier.indexOf( "Commandes :" ) );
		List<String> listeCommandes = listeLignesFichier.subList( listeLignesFichier.indexOf( "Commandes :" ) + 1,
				listeLignesFichier.indexOf( "Fin" ) );

		// lire les plats
		for ( String string : listeNomPlats ) {
			String nomDuPlat = string.substring( 0, string.indexOf( " " ) );
			String prix = string.substring( string.indexOf( " " ) );
			listePlats.add( new Plats( nomDuPlat, Double.parseDouble( prix ) ) );
		}
		for ( String string : listeCommandes ) {
			String nomLu = string.substring( 0, string.indexOf( " " ) );
			String nomPlat = string.substring( string.indexOf( " " ) + 1, string.lastIndexOf( " " ) );
			String qteLu = string.substring( string.lastIndexOf( " " ) + 1 );
			Plats plat = Commande.trouverPlat( listePlats, nomPlat );
			if ( plat != null && listeClients.contains( nomLu ) ) {
				commandes.add( new Commande( nomLu, Integer.parseInt( qteLu ), plat ) );
			} else {
				System.out.println( "Le fichier ne respecte pas le format demandé ! " );
				fichierOk = false;
				break;
			}
		}

		if ( fichierOk ) {
			double[] totalParClient = new double[listeClients.size()];
			for ( Commande commandeCourante : commandes ) {
				totalParClient[listeClients.indexOf( commandeCourante.nomClient )] += ( commandeCourante.plat.getPrix()
						* commandeCourante.qte );
			}
			String allText = "Bienvenue chez Barette!\nFactures:\n";
			for ( String client : listeClients ) {
				allText += client + " :  " + totalParClient[listeClients.indexOf( client )] + " $\n";
			}
			System.out.println( allText );
			try {
				BufferedWriter writer = Files.newBufferedWriter( new File( "Factures.txt" ).toPath() );
				writer.write( allText );
				writer.close();
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		}
	}
}
