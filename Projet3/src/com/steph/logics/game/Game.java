package com.steph.logics.game;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.steph.logics.Driver;
import com.steph.logics.PropertyLoader;
import com.steph.logics.mode.Mode;

public abstract class Game {
	static String newLine = System.getProperty("line.separator");
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
		 String devMode = PropertyLoader.getDevMode();
		success = false;
		logger.log(Level.INFO, "On attaque le jeu en mode " + mode + newLine);

		sCode = mode.getSCode();
		if (devMode.equals("ON")) {
			try {
				logger.log(Level.DEBUG, "mode développeur activé - Le code secret est : " + sCode + newLine);
			} catch (Exception e) {

				logger.fatal("Une exception est survenue", e);
			}
		}

		Essais = 0;

		do {
			NB_DE_TOURS = PropertyLoader.getNbDeTours();
			Essais++;
			try {
				logger.log(Level.INFO, newLine + "Essai " + Essais + "/" + NB_DE_TOURS + newLine);
			} catch (Exception e) {

				logger.fatal("Une exception est survenue", e);
			}
			answer = mode.getAnswer();

			if (answer.equals(sCode) && (Essais == 1)) {

				switch (mode.toString()) {

				case "Dual":

					if (Essais == 1) {
						try {
							logger.log(Level.INFO, "Félicitations, vous avez gagné du premier coup!!" + newLine);
						} catch (Exception e) {

							logger.fatal("Une exception est survenue", e);
						}
						success = true;
						break;
					} else if (Essais == 2) {
						try {
							logger.log(Level.INFO, "L'ordinateur gagné du premier coup!!" + newLine);
						} catch (Exception e) {

							logger.fatal("Une exception est survenue", e);
						}
						success = true;
					}

				case "Attack":
					try {
						logger.log(Level.INFO,
								"Félicitations, vous avez trouvé la combinaison secrète du premier coup!!" + newLine);
					} catch (Exception e) {

						logger.fatal("Une exception est survenue", e);
					}
					success = true;
					break;
				default:
					try {
						logger.log(Level.INFO,
								"L'ordinateur a trouvé la combinaison secrète du premier coup!!" + newLine);
					} catch (Exception e) {

						logger.fatal("Une exception est survenue", e);
					}
					success = true;
					break;
				}
			} else if (answer.equals(sCode) && (Essais > 1)) {

				switch (mode.toString()) {

				case "Dual":

					if (Essais % 2 == 1) {
						try {
							logger.log(Level.INFO,
									"Félicitations, vous avez gagné en " + Essais + " essais!!" + newLine);
						} catch (Exception e) {

							logger.fatal("Une exception est survenue", e);
						}
						success = true;
						break;
					} else {
						try {
							logger.log(Level.INFO, "L'ordinateur a gagné en " + Essais + " essais!!" + newLine);
						} catch (Exception e) {

							logger.fatal("Une exception est survenue", e);
						}
						success = true;
						break;
					}

				case "Attack":
					try {
						logger.log(Level.INFO, "Félicitations, vous avez trouvé la combinaison secrète en " + Essais
								+ " essais!!" + newLine);
					} catch (Exception e) {

						logger.fatal("Une exception est survenue", e);
					}
					success = true;
					break;
				default:
					try {
						logger.log(Level.INFO,
								"L'ordinateur a trouvé la combinaison secrète en " + Essais + " essais!!" + newLine);
					} catch (Exception e) {

						logger.fatal("Une exception est survenue", e);
					}
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
				try {
					logger.log(Level.INFO, "Personne n'a gagné !!" + newLine);
				} catch (Exception e) {

					logger.fatal("Une exception est survenue", e);
				}
				success = true;
				break;

			case "Attack":
				try {
					logger.log(Level.INFO, "Vous avez perdu ! La solution était " + sCode + "." + newLine);
				} catch (Exception e) {

					logger.fatal("Une exception est survenue", e);
				}
				success = true;
				break;
			default:
				try {
					logger.log(Level.INFO,
							"L'ordianteur n'a pas trouvé la combinaison secrète dans le nombre d'essais imparti."
									+ newLine);
				} catch (Exception e) {

					logger.fatal("Une exception est survenue", e);
				}
				success = true;
				break;
			}

		}

	}

	public static int getTurn() {
		return Essais;
	}

}