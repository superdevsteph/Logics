package com.steph.logics.mode;

import java.util.Scanner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.steph.logics.Driver;
import com.steph.logics.PropertyLoader;
import com.steph.logics.Utils;
import com.steph.logics.game.Game;

public class DualMode extends Mode {
	static String newLine = System.getProperty("line.separator");
	private static Logger logger = Logger.getLogger(Driver.class);

	private static String answer;

	public DualMode() {
		super("Dual");
	}

	@Override
	public String getSCode() {

		char secretCode[] = Utils.generate();
		String sCode = String.valueOf(secretCode);

		return sCode;
	}

	@Override
	public String getAnswer() {
		Scanner sc = new Scanner(System.in);
		int turn = Game.getTurn();
		if (turn % 2 == 1){
			try {
				logger.log(Level.INFO,
						"entrez votre proposition à " + PropertyLoader.getCodeSize() + " chiffres : " + newLine);
			} catch (Exception e) {

				logger.fatal("Une exception est survenue", e);
			}
			sc.hasNextLine();
			answer = sc.nextLine();
			try {
				logger.log(Level.DEBUG,
						"Votre proposition : " + answer + newLine);
			} catch (Exception e) {

				logger.fatal("Une exception est survenue", e);
			}

		} else {
			char[] proposition = Utils.getProposition(answer);

			for (int i = 0; i < proposition.length; i++) {

				switch (Game.result[i]) {

				case '-':
					proposition[i]--;
					break;
				case '+':
					proposition[i]++;
					break;
				default:
					proposition[i] = proposition[i];
				}
			}
			answer = new String(proposition);
		}
		try {
			logger.log(Level.DEBUG,
					"Proposition de l'ordinateur : " + answer + newLine);
		} catch (Exception e) {

			logger.fatal("Une exception est survenue", e);
		}
		return answer;

	}

}