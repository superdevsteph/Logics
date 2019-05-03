package com.steph.logics.game;

import com.steph.logics.mode.Mode;

public abstract class Game {

	protected Mode mode;
	protected final static  int NB_DE_TOURS = 10;
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
			
			System.out.printf("\nEssai N° : %d/%d \n", Essais, NB_DE_TOURS);

			answer = mode.getAnswer();

			if (answer.equals(sCode) && (Essais == 1)) {

				System.out.println("Félicitations, vous avez trouvé la combinaison secrète du premier coup!!");
				success = true;
				break;

			} else if (answer.equals(sCode) && (Essais > 1)) {
				System.out.println(
						"Félicitations, vous avez trouvé la combinaison secrète en " + "" + Essais + " essais!!");
				success = true;
				break;

			} else {

				result = compare();
			}

		} while (success == false && Essais < NB_DE_TOURS);

		if (Essais == NB_DE_TOURS) {
			System.out.println(
					"Désolée ! Vous n'avez pas trouvé la combinaison secrète dans le nombre d'essais imparti :(");
		}

	}

	public static int getTurn() {
		return Essais;
	}

}