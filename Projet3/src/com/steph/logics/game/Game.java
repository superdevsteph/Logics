package com.steph.logics.game;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.steph.logics.Driver;
import com.steph.logics.PropertyLoader;
import com.steph.logics.mode.Mode;

public abstract class Game {

	protected Mode mode;
	protected static int NB_DE_TOURS;
	protected static int Essais;
	protected static boolean success;
	public static String sCode;
	public static String answer;
	public static char[] result;
	private static Logger logger = Logger.getLogger(Driver.class);
	public abstract char[] compare();

	public Game(Mode mode) {
		this.mode = mode;
	}

	public void play() {
		
		success = false;
		logger.log(Level.INFO, "On attaque le jeu en mode " + mode);

		sCode = mode.getSCode();
		
		Essais = 0;
		
		

		do {
			NB_DE_TOURS = PropertyLoader.getNbDeTours();
			Essais++;
			logger.log(Level.INFO, "Essai " + Essais+"/" + NB_DE_TOURS);
			

			answer = mode.getAnswer();

			if (answer.equals(sCode) && (Essais == 1)) {

				switch (mode.toString()) {

				case "Dual":

					if (Essais == 1) {
						logger.log(Level.INFO, "Félicitations, vous avez gagné du premier coup!!");
						success = true;
						break;
					} else if (Essais == 2) {
						logger.log(Level.INFO, "L'ordinateur gagné du premier coup!!");
						success = true;
					}

				case "Attack":

					logger.log(Level.INFO, "Félicitations, vous avez trouvé la combinaison secrète du premier coup!!");
					success = true;
					break;
				default:
					logger.log(Level.INFO, "L'ordinateur a trouvé la combinaison secrète du premier coup!!");
					success = true;
					break;
				}
			} else if (answer.equals(sCode) && (Essais > 1)) {

				switch (mode.toString()) {

				case "Dual":

					if (Essais % 2 == 1) {
						logger.log(Level.INFO, "Félicitations, vous avez gagné en " + Essais + " essais!!");
						success = true;
						break;
					} else {

						logger.log(Level.INFO, "L'ordinateur a gagné en " + Essais + " essais!!");
						success = true;
						break;
					}

				case "Attack":

					logger.log(Level.INFO, "Félicitations, vous avez trouvé la combinaison secrète en " + Essais + " essais!!");
					success = true;
					break;
				default:
					logger.log(Level.INFO, "L'ordinateur a trouvé la combinaison secrète en " + Essais + " essais!!");
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
				logger.log(Level.INFO, "Personne n'a gagné !!");
				success = true;
				break;

			case "Attack":

				logger.log(Level.INFO, "Vous avez perdu ! La solution était " + sCode + ".");
				success = true;
				break;
			default:
				logger.log(Level.INFO, "L'ordianteur n'a pas trouvé la combinaison secrète dans le nombre d'essais imparti.");
				success = true;
				break;
			}

		}

	}

	public static int getTurn() {
		return Essais;
	}

}