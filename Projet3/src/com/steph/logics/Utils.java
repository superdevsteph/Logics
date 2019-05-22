package com.steph.logics;

import java.util.ArrayList;
import java.util.Random;

import org.apache.log4j.Logger;

import com.steph.logics.game.Game;

public class Utils {
	
	protected static int codeSize = PropertyLoader.getCodeSize();
	public static char[] getProposition(String answer) {
		
		answer = Game.answer;

		char[] proposition = new char[codeSize];

		for (int i = 0; i < answer.length(); i++) {
			proposition[i] = answer.charAt(i);
		}
		return proposition;

	}

	public static char[] getResponse(String sCode) {

		sCode = Game.sCode;

		char[] response = new char[codeSize];

		for (int i = 0; i < sCode.length(); i++) {
			response[i] = sCode.charAt(i);
		}
		return response;

	}

	public static char[] generate() {
		
		char[] posTab = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		char randNum[] = new char[codeSize];
		int index;
		ArrayList<Integer> indexesAlreadyTaken = new ArrayList<>();

		for (int i = 0; i < randNum.length; i++) {
			do {
				Random random = new Random();
				index = random.nextInt(posTab.length);
			} while (indexesAlreadyTaken.contains(index));

			indexesAlreadyTaken.add(index);

			randNum[i] = posTab[index];

		}

		return randNum;
	}

}
