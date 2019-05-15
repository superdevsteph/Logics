package com.steph.logics.game;

import com.steph.logics.mode.Mode;

public abstract class Game {

	protected Mode mode;
	protected final static int NB_DE_TOURS = 10;
	protected static int Essais;
	protected static boolean success;
	public static String sCode;
	public static String answer;
	public static char[] result;

	public abstract char[] compare();

	public Game(Mode mode) {
		this.mode = mode;
	}

	public void play() {
		success = false;
		System.out.println("On attaque le jeu en mode " + mode);

		sCode = mode.getSCode();

		Essais = 0;

		do {

			Essais++;

			System.out.printf("\nEssai N� : %d/%d \n", Essais, NB_DE_TOURS);

			answer = mode.getAnswer();

			if (answer.equals(sCode) && (Essais == 1)) {

				switch (mode.toString()) {
				
				case "Dual" : 
					
					if (Essais == 1) {
						System.out.println("F�licitations, vous avez gagn� du premier coup!!");
						success = true;
						break;	
					}else if (Essais == 2) {
						System.out.println("L'ordinateur gagn� du premier coup!!");
						success = true;
					}
		
				case "Attack":

					System.out.println("F�licitations, vous avez trouv� la combinaison secr�te du premier coup!!");
					success = true;
					break;
				default:
					System.out.println("L'ordinateur a trouv� la combinaison secr�te du premier coup!!");
					success = true;
					break;
				}
			} else if (answer.equals(sCode) && (Essais > 1)) {

				switch (mode.toString()) {
				
				
				case "Dual" : 
					
					if (Essais % 2 == 1) {
						System.out.println(
								"F�licitations, vous avez gagn� en " + Essais + " essais!!");
						success = true;
						break;
					} else {
						
						System.out.println("L'ordinateur a gagn� en " + Essais + " essais!!");
						success = true;
						break;
					}

				case "Attack":

					System.out.println(
							"F�licitations, vous avez trouv� la combinaison secr�te en " + Essais + " essais!!");
					success = true;
					break;
				default:
					System.out.println("L'ordinateur a trouv� la combinaison secr�te en " + Essais + " essais!!");
					success = true;
					break;
				}

			} else {

				result = compare();
			}

		} while (success == false && Essais < NB_DE_TOURS);

		if (Essais == NB_DE_TOURS && success == false) {

			switch (mode.toString()) {
			
			case "Dual": 
				System.out.println(
						"Personne n'a gagn� !!");
				success = true;
				break;

			case "Attack":

				System.out.println(
						"Vous avez perdu ! La solution �tait " + sCode + ".");
				success = true;
				break;
			default:
				System.out
						.println("L'ordianteur n'a pas trouv� la combinaison secr�te dans le nombre d'essais imparti.");
				success = true;
				break;
			}

		}

	}

	public static int getTurn() {
		return Essais;
	}

}