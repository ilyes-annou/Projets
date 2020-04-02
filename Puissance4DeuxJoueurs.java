import java.util.Scanner;

public class Puissance4DeuxJoueurs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nbTours = 0 ;
		
		System.out.println("Entrez le pseudo du J1 (O)");
		String pseudoJ1 = sc.nextLine();
		System.out.println("Entrez le pseudo du J2 (X)");
		String pseudoJ2 = sc.nextLine();
		
		char[][] plateau = new char[6][7]; 
		
		for (int x =0;x<plateau.length; x++){		
			for (int y = 0 ; y<plateau[x].length; y++){				
				plateau[x][y]='_';				//création du plateau et remplissage avec du "vide"			
			}			
		}
		
		Methodes.visuTab(plateau);
		
		do {
			Methodes.placerJeton(plateau, pseudoJ1, pseudoJ2);
			System.out.println();
			nbTours++;
			
			
		}while(nbTours<21 &&  Methodes.placerJeton(plateau, pseudoJ1, pseudoJ2) == false); //42 cases, 2 actions max par tour donc maximum 42/2=21 tours
		
		if(nbTours>=21) {
		
			System.out.println("Tableau plein, fin de partie. Egalité");
		
		}
	}

	

}
