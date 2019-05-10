
package com.steph.logics;

import java.util.Scanner;

import com.steph.logics.mode.ModeType;

public class Input {

	
	static Scanner sc = new Scanner(System.in);

	/**
	 * A la fin del a partie, on demande à l'utilisateur s'il veut rejouer
	 * 
	 * @return the replayAnswer
	 */
	public static boolean replay() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		char replayAnswer;
		do {
			System.out.println("Voulez-vous rejouer ? (O/N)");
			sc.hasNextLine();
			replayAnswer = sc.nextLine().toLowerCase().charAt(0);
		} while (replayAnswer != 'o' && replayAnswer != 'n');
		return replayAnswer == 'o';
	}

	

	/**
	 * on récupère le choix de Mode et on le fait correspondre à l'index du mode à
	 * lancer dans la liste des modes
	 */
	public static ModeType getModeType() {
		int numMode = 0;
		do {
			System.out.println("Veuillez choisir le Mode : 1 - Attaque, 2 - Défense, 3 - Duel");
			try {
				numMode = sc.nextInt();
			} catch (Exception e) {
				System.err.println("Erreur de saisie");
			}
		} while (numMode < 1 || numMode > 3);

		return ModeType.values()[numMode - 1];
	}


	
}