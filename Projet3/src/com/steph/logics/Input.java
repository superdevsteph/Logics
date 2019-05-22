
package com.steph.logics;

import java.util.Scanner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.steph.logics.mode.ModeType;

public class Input {

	 private static Logger logger = Logger.getLogger(Driver.class);
	static Scanner sc = new Scanner(System.in);

	/**
	 * A la fin de la partie, on demande à l'utilisateur s'il veut rejouer
	 * 
	 * @return the replayAnswer
	 */
	public static boolean replay() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		char replayAnswer;
		do {
			logger.log(Level.INFO, "Voulez-vous rejouer ? (O/N)");
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
			logger.log(Level.INFO, "Veuillez choisir le Mode : 1 - Attaque, 2 - Défense, 3 - Duel");
			try {
				numMode = sc.nextInt();
			} catch (Exception e) {
				System.err.println("Erreur de saisie");
			}
		} while (numMode < 1 || numMode > 3);

		return ModeType.values()[numMode - 1];
	}


	
}