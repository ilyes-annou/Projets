import java.util.Scanner;
public class Menu {

	public static void main(String[] args) {
		int choix;
		Scanner sc = new Scanner(System.in);	
		
		int choixRejouer;
		do {
			System.out.println("Bienvenue dans mon Puissance 4, choisissez votre mode de jeu. \n(1)Un joueur \n(2)Deux joueurs");
			choix = Integer.parseInt(sc.nextLine());
			

			while (choix!=1 && choix!=2) {
				
				System.out.println("Veuillez choisir entre 1 et 2");
				
			}
			
			if(choix==1) {
				
				Puissance4Solo.main(args);
				
			}
			
			else /*if (choix==2)*/ {
				
				Puissance4DeuxJoueurs.main(args);
				
			}
			
			System.out.println("Voulez vous rejouer? 1:oui autre:non");
			
			choixRejouer=Integer.parseInt(sc.nextLine());
		
		}while(choixRejouer==1);

		
	}

}
