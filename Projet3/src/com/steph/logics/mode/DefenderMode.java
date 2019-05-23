package com.steph.logics.mode;

import java.util.Scanner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.steph.logics.Driver;
import com.steph.logics.PropertyLoader;
import com.steph.logics.Utils;
import com.steph.logics.game.Game;

public class DefenderMode extends Mode {
	static	String newLine = System.getProperty("line.separator");
	
	 private static Logger logger = Logger.getLogger(Driver.class);

	public DefenderMode() {
		super("Defender");
	}

	public String getSCode() {
		String sCode = "";
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
try {
		logger.log(Level.INFO, "Entrez votre code secret à "+ PropertyLoader.getCodeSize()+ " chiffres : "+newLine);
} catch(Exception e) {
	
	logger.fatal("Une exception est survenue", e);
}
		try {
			sCode = sc.nextLine();
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		return sCode;
	}

	@Override
	public String getAnswer() {

		String answer = "";
		char[] randNum = Utils.generate();
		if (Game.getTurn() == 1) {

			answer = String.valueOf(randNum);

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