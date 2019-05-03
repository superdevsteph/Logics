package com.steph.logics.mode;

import java.util.Scanner;

import com.steph.logics.Utils;
import com.steph.logics.game.Game;

public class DefenderMode extends Mode {

	public DefenderMode() {
		super("Defender");
	}

	public String getSCode() {
		String sCode = "";
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez votre code secret");
		try {
			sCode = sc.nextLine();
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		return sCode;
	}

	@Override
	public String getAnswer() {

		char[] prop = Utils.generateProp();
		String answer = "";
		if (Game.getTurn() == 1) {

			int a = 1000 + (int) (Math.random() * ((10000 - 1000) + 1));
			answer = String.valueOf(a);

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
				case '.':
					proposition[i] = prop[i];
					break;
				case 'x':
					proposition[i] = prop[i];
					break;
				default:
					proposition[i] = proposition[i];
				}

			}

			answer = new String(proposition);
		
		}
		System.out.println(answer);
		return answer;
	}
}