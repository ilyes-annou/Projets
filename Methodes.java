import java.util.Scanner;


public class Methodes {
	
	public static boolean placerJeton(char[][] tab, String pseudo1, String pseudo2) {
		
		Scanner sc = new Scanner(System.in);
		
		//Tour J1
		
		int gravite = 5;  //gère à quelle "hauteur" le jeton va être placeé

		System.out.println(pseudo1 + ", dans quelle colonne voulez-vous placer votre jeton?");
		int choixJ1  = Integer.parseInt(sc.nextLine());
		choixJ1=forcerSaisie(choixJ1);
		
		while (verifColonnePleine(tab,choixJ1)) {
			System.out.println("Colonne pleine, choisissez-en une autre");
			choixJ1  = Integer.parseInt(sc.nextLine());
			choixJ1=forcerSaisie(choixJ1);
			
		}
		
		
		if(tab[gravite][choixJ1-1]!='_') {
		
			while(tab[gravite][choixJ1-1]!='_' && gravite>0 ) {  //tant que l'on rencontre un pion dans la colonne choisie à la hauteur la plus basse possible actuellement, on monte
				
				gravite--;
			}
			
			tab[gravite][choixJ1-1]='O';
		
		}
	
		else {
			tab[gravite][choixJ1-1]='O';
		}
				
		visuTab(tab);
	
		
		if( verifVictoire(tab)==true) {
			return true;
		}
		
		//Tour J2
	
		System.out.println(pseudo2 + ", dans quelle colonne voulez-vous placer votre jeton?");
		int choixJ2  = Integer.parseInt(sc.nextLine());
		choixJ2=forcerSaisie(choixJ2);
		
		while (verifColonnePleine(tab,choixJ2)) {
			System.out.println("Colonne pleine, choisissez-en une autre");
			choixJ2  = Integer.parseInt(sc.nextLine());
			choixJ2=forcerSaisie(choixJ2);
			
		}
		
		gravite=5;
		
		
	
		if(tab[gravite][choixJ2-1]!='_') {
		
			while(tab[gravite][choixJ2-1]!='_' && (gravite>0 || gravite>0)) {
				gravite--;
			}
		tab[gravite][choixJ2-1]='X';
		
		}
	
		else {
			tab[gravite][choixJ2-1]='X';
		}
		
		visuTab(tab);
		
		if(verifVictoire(tab)==true) {
			return true;
		}

		return false;
	}
	
	public static boolean placerJetonSolo(char[][] tab, String pseudo1) {
		
		Scanner sc = new Scanner(System.in);
		
		//Tour J1
		
		int gravite = 5;  //gère à quelle "hauteur" le jeton va être placeé

		System.out.println(pseudo1 + ", dans quelle colonne voulez-vous placer votre jeton?");
		int choixJ1  = Integer.parseInt(sc.nextLine());
		choixJ1=forcerSaisie(choixJ1);
		
		while (verifColonnePleine(tab,choixJ1)) {
			System.out.println("Colonne pleine, choisissez-en une autre");
			choixJ1  = Integer.parseInt(sc.nextLine());
			choixJ1=forcerSaisie(choixJ1);
			
		}
		
		
		if(tab[gravite][choixJ1-1]!='_') {
		
			while(tab[gravite][choixJ1-1]!='_' && gravite>0 ) {  //tant que l'on rencontre un pion dans la colonne choisie à la hauteur la plus basse possible actuellement, on monte
				
				gravite--;
			}
			
			tab[gravite][choixJ1-1]='O';
		
		}
	
		else {
			tab[gravite][choixJ1-1]='O';
		}
				
		visuTab(tab);
		
		
		if(verifVictoire(tab)==true) {
			return true;
		}
		
		//Tour COM
		
		int choixCOM  = (int)(Math.random() * 7) + 1;
				
		while (verifColonnePleine(tab,choixCOM)) {			
			choixCOM  = (int)(Math.random() * 7) + 1;
		}
		
		gravite=5;		
	
		if(tab[gravite][choixCOM-1]!='_') {
		
			while(tab[gravite][choixCOM-1]!='_' && (gravite>0 || gravite>0)) {
				gravite--;
			}
		tab[gravite][choixCOM-1]='X';
		
		}
	
		else {
			tab[gravite][choixCOM-1]='X';
		}
		
		if(verifVictoire(tab)==true) {
			return true;
		}
		
		visuTab(tab);
		
		return false;
			
}
/*
 * Cette procédure prend en paramètre le plateau et permet un affichage adapté au jeu de puissance 4
 */
	public static void visuTab(char[][] tab) {
	
		for (int x =0;x<tab.length; x++){		
			for (int y = 0 ; y<tab[x].length; y++){				
				System.out.print("|" + tab[x][y] + "|");

			}
			System.out.println();
		}
	
		System.out.println(" 1  2  3  4  5  6  7");
	
	}


	/*
 	* Cette méthode prend en paramètre le choix de colonne du joueur et force une saisie correcte, puis la retourne
 	*/
	public static int forcerSaisie(int choix) {
		Scanner sc = new Scanner(System.in);
	
		while(choix<1 || choix>7) {
			System.out.println("Choisissez une colonne entre 1 et 7");
			choix=Integer.parseInt(sc.nextLine());
		
		}
		return choix;
	
	}

	/*
	 * Cette méthode doit pour chaque case du plateau verifier si le jeton placé a 3 voisins (horizontale,diagonale verticale) et retourne true si c'est le cas, false sinon
	 */
	public static boolean verifVictoire(char[][] tab) {
		
		int compteurAligne;
	
		for (int x =0;x<tab.length; x++){		
			for (int y = 0 ; y<tab[x].length; y++){	
				if(tab[x][y]!='_') {
			
					if(y<4) {
						if(tab[x][y]==tab[x][y+1] && tab[x][y+1]==tab[x][y+2] && tab[x][y+2]==tab[x][y+3]) {//G->D
							System.out.println("Victoire Horizontale des " + tab[x][y]);
							return true;
						}
					}
					
					else/* if(y>=4)*/{
						if(tab[x][y]==tab[x][y-1] && tab[x][y-1]==tab[x][y-2] && tab[x][y-2]==tab[x][y-3]) {//D->G
							System.out.println("Victoire Horizontale des " + tab[x][y]);
							return true;
						}
						
					}
					
					if(x<3) {
						if(tab[x][y]==tab[x+1][y] && tab[x+1][y]==tab[x+2][y] && tab[x+2][y]==tab[x+3][y]) {//B->H
							System.out.println("Victoire Verticale des " + tab[x][y]);
							return true;
						}
					}
					
					else /*if(x>=3)*/ {
						if(tab[x][y]==tab[x-1][y] && tab[x-1][y]==tab[x-2][y] && tab[x-2][y]==tab[x-3][y]) {//H-B
							System.out.println("Victoire Verticale des " + tab[x][y]);
							return true;
						}
					}
					
					if (y>=4 && x>=3) {
						if(tab[x][y]==tab[x-1][y-1] && tab[x-1][y-1]==tab[x-2][y-2] && tab[x-2][y-2]==tab[x-3][y-3]) {
							System.out.println("Victoire Diagonale des " + tab[x][y]);
							return true;
						}
					}
					
					else if (y>=4 && x<3) {
						if(tab[x][y]==tab[x+1][y-1] && tab[x+1][y-1]==tab[x+2][y-2] && tab[x+2][y-2]==tab[x+3][y-3]) {
							System.out.println("Victoire Diagonale des " + tab[x][y]);
							return true;
						}
					}
					
					else if (y<=4 && x>3) {
						if(tab[x][y]==tab[x-1][y+1] && tab[x-1][y+1]==tab[x-2][y+2] && tab[x-2][y+2]==tab[x-3][y+3]) {
							System.out.println("Victoire Diagonale des " + tab[x][y]);
							return true;
						}
					}
					
					else if (y<=4 && x<3) {
						if(tab[x][y]==tab[x+1][y+1] && tab[x+1][y+1]==tab[x+2][y+2] && tab[x+2][y+2]==tab[x+3][y+3]) {
							System.out.println("Victoire Diagonale des " + tab[x][y]);
							return true;
						}
					}
			

				}
			}
		
		}
		return false;
	}
	
	
	/*
	 * Bug, non gardée
	 */
	public static boolean verifVictoireHorizontale(char[][] tab) {
		
		for (int x =0;x<tab.length; x++){		
			for (int y = 0 ; y<tab[x].length; y++){	
				
				if(tab[x][y]!='_') {
			
					if(tab[x][y]==tab[x][y+1] && tab[x][y+1]==tab[x][y+2] && tab[x][y+2]==tab[x][y+3] && y<5) {
						System.out.println("Victoire Horizontale des " + tab[x][y]);
						return true;
					}
				}

			}
		
		}
		return false;

	}
	/*
	 * Bug, non gardée
	 */
	public static boolean verifVictoireVerticale(char[][] tab) {
		
		for (int x =0;x<tab.length; x++){		
			for (int y = 0 ; y<tab[x].length; y++){	
				
				if(tab[x][y]!='_') {
			
					if(tab[x][y]==tab[x-1][y] && tab[x-1][y]==tab[x-2][y] && tab[x-2][y]==tab[x-3][y] && x>2) {
						System.out.println("Victoire Verticale des " + tab[x][y]);
						return true;
					}
				}

			}

		}
		return false;
	}
	/*
	 * Bug, non gardée
	 */
	public static boolean verifVictoireDiagonale(char[][] tab) {
		
		for (int x =0;x<tab.length; x++){		
			for (int y = 0 ; y<tab[x].length; y++){	
				
				if(tab[x][y]!='_') {
			
					if(tab[x][y]==tab[x-1][y-1] && tab[x-1][y-1]==tab[x-2][y-2] && tab[x-2][y-2]==tab[x-3][y-3]) {
						System.out.println("Victoire Diagonale des " + tab[x][y]);
						return true;
					}
				}

			}

		}
		return false;
	}
	
	/*
	 * Cette méthode prend en paramètre le choix du joueur et la plateau (pour verifier l'élément à la derniere ligne à la colonne choisie et retourne true si la place est occupée, false sinon
	 */
	public static boolean verifColonnePleine(char[][] tab, int choix) {
	
		if(tab[0][choix-1]=='_') {
			return false;
		}
	
		return true;
	}
	

}
