//https://github.com/Turb0Hawk/TP1P1
public class Cv {
	
	String nom, prenom, formation, attentes;
	String[] competences;
	int experience;
	static String[] comps = { "Programation en C#", "Programation en Java", "Programation en C", "Programation en C++",
			"Suite Office", "Ordinateurs", "Jeux vid�os" };
	
	public static void main( String[] args ) {
		System.out.println( "Bienvenue chez Barette!\n" );
		Cv david = new Cv( "David", "Ringuet", "Technique Informatique de Gestion", 2, comps, "Un bon cours" );
		david.affiche();
		Cv jane = new Cv("Jane-Mary", "Menassa", "Technique Informatique de Gestion", 3, comps, "D�velopper de nouvelles connaissances");
		jane.affiche();
		
	}
	
	public Cv( String nomIn, String prenomIn, String formationIn, int expIn, String[] compIn, String attentesIn ) {
		this.nom = nomIn;
		this.prenom = prenomIn;
		this.formation = formationIn;
		this.experience = expIn;
		this.competences = compIn;
		this.attentes = attentesIn;
	}
	
	public void affiche() {

		System.out.println( "Nom: " + this.nom + "\n" );
		System.out.println( "Prenom: " + this.prenom + "\n" );
		System.out.println( "Formation: " + this.formation + "\n" );
		System.out.println( "Exp�rience: " + this.experience + "\n" );
		System.out.println( "Comp�tences: " );
		for ( String item : this.competences ) {
			System.out.println( "\t" + item );
		}
		System.out.println( "\nAttentes: " + this.attentes + "\n" );
		System.out.println( "-------------------------------------------------" );
	}
}
