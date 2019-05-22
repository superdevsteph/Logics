package com.steph.logics.mode;

import java.util.Scanner;

import com.steph.logics.PropertyLoader;
import com.steph.logics.Utils;
import com.steph.logics.game.Game;

public class DualMode extends Mode {
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
		if (turn %2 == 1)  {

			System.out.println("entrez votre proposition à "+ PropertyLoader.getCodeSize()+ " chiffres.");
			sc.hasNextLine();
			answer = sc.nextLine();

		} else {
char[] proposition = Utils.getProposition(answer);
			

			for (int i = 0; i < proposition.length; i++) {

				switch (Game.result[i]) {

				case '-':
					proposition[i] --;
					break;
				case '+':
					proposition[i] ++;
					break;
				default:
					proposition[i] = proposition[i];
				}
			}
			answer = new String(proposition);
			}
		
		return answer;

	}

}