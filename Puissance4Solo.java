import java.util.Scanner;

public class Puissance4Solo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int nbTours = 0 ;
		
		System.out.println("Entrez votre pseudo (O)");
		String pseudo = sc.nextLine();
		
		
		char[][] plateau = new char[6][7]; 
		
		for (int x =0;x<plateau.length; x++){		
			for (int y = 0 ; y<plateau[x].length; y++){				
				plateau[x][y]='_';				//création du plateau et remplissage avec du "vide"			
			}			
		}
		
		Methodes.visuTab(plateau);
		
		do {
			Methodes.placerJetonSolo(plateau, pseudo);
			//Methodes.visuTab(plateau);
			System.out.println();
			nbTours++;
			
			
		}while(/*nbTours<21 && Methodes.verifVictoireHorizontale(plateau)==false && Methodes.verifVictoireVerticale(plateau)==false && */Methodes.placerJetonSolo(plateau, pseudo) == false); //42 cases, 2 actions max par tour donc maximum 42/2=21 tours
		
		if(nbTours>=21) {
			
			System.out.println("Tableau plein, fin de partie. Egalité");
		
		}
	
		
	}

}


