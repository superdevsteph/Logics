package com.steph.logics;

import java.util.ArrayList;

import com.steph.logics.game.Game;

public class Utils {

	public static char[] getProposition(String answer) {

		answer = Game.answer;

		char[] proposition = new char[4];

		for (int i = 0; i < answer.length(); i++) {
			proposition[i] = answer.charAt(i);
		}
		return proposition;

	}

	public static  char[] getResponse(String sCode) {

		sCode = Game.sCode;

		char[] response = new char[4];

		for (int i = 0; i < sCode.length(); i++) {
			response[i] = sCode.charAt(i);
		}
		return response;

	}

	public static char[] generateProp() {

		ArrayList<String> answerTab = new ArrayList<>();
		String answer = "";
		char[] prop = new char[4];
		do {
			int a = 1000 + (int) (Math.random() * ((10000 - 1000) + 1));
			answer = String.valueOf(a);
		} while (answerTab.contains(answer));

		answerTab.add(answer);
		
		for (int i = 0; i < answer.length(); i++) {
			prop[i] = answer.charAt(i);

	}
		return prop;
	}



}
