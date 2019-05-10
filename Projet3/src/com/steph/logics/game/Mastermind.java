package com.steph.logics.game;

import com.steph.logics.Utils;
import com.steph.logics.mode.Mode;

public class Mastermind extends Game {

	private final char BIEN_PLACE = 'b';
	private final char MAL_PLACE = 'm';

	public Mastermind(Mode mode) {
		super(mode);
	}

	public char[] copyProposition(char[] proposition) {

		char[] pCopy = new char[4];
		pCopy = proposition;

		return pCopy;

	}

	public char[] copyResponse(char[] response) {

		char[] rCopy = new char[4];
		rCopy = response;

		return rCopy;
	}

	public int getBienPlacé() {

		char[] pCopy = this.copyProposition(Utils.getProposition(answer));

		char[] response = Utils.getResponse(sCode);

		int bienPlacé = 0;

		for (int i = 0; i < pCopy.length; i++) {
			if (pCopy[i] == response[i]) {
				bienPlacé++;
				pCopy[i] = BIEN_PLACE;
			}
		}

		return bienPlacé;
	}

	public char[] getRCopy() {

		char[] rCopy = this.copyResponse(Utils.getResponse(sCode));
		char[] pCopy = this.copyProposition(Utils.getProposition(answer));
		char[] response = Utils.getResponse(sCode);

		for (int i = 0; i < pCopy.length; i++) {
			if (pCopy[i] == response[i]) {

				rCopy[i] = BIEN_PLACE;
			}
		}

		return rCopy;
	}

	public char[] getPCopy() {

		char[] pCopy = this.copyProposition(Utils.getProposition(answer));

		char[] response = Utils.getResponse(sCode);

		for (int i = 0; i < pCopy.length; i++) {
			if (pCopy[i] == response[i]) {

				pCopy[i] = BIEN_PLACE;
			}
		}

		return pCopy;
	}

	public int getMalPlacé() {
		char[] rCopy = this.getRCopy();

		char[] pCopy = this.getPCopy();

		int malPlacé = 0;

		for (int i = 0; i < pCopy.length; i++) {

			for (int j = 0; j < rCopy.length; j++) {

				if ((rCopy[i] != BIEN_PLACE) && (pCopy[i] == rCopy[j])) {
					malPlacé++;
					pCopy[i] = MAL_PLACE;
				}

			}

		}

		return malPlacé;

	}

	public char[] compare() {
		int bienPlacé = getBienPlacé();
		int malPlacé = getMalPlacé();
		char[] rCopy = this.copyResponse(Utils.getResponse(sCode));
		char[] pCopy = this.copyProposition(Utils.getProposition(answer));
		char[] result = new char[4];
		char[] proposition = Utils.getProposition(answer);
		char[] response = Utils.getResponse(sCode);

		for (int i = 0; i < proposition.length; i++) {

			if (proposition[i] == response[i]) {

				result[i] = 'o';

			} else {

				for (int j = 0; j < rCopy.length; j++) {

					if ((rCopy[i] != BIEN_PLACE) && (pCopy[i] == rCopy[j])) {

						result[i] = 'x';

					} else {
						result[i] = '.';
					}

				}

			}

		}
		if (bienPlacé <= 1) {
			System.out.println(bienPlacé + " bien placé");

		} else {
			System.out.println(bienPlacé + " bien placés");
		}
	//	result[1] = (char) bienPlacé;
		if (malPlacé <= 1) {
			System.out.println(malPlacé + " mal placé");

		} else {
			System.out.println(malPlacé + " mal placés");
		}
	//	result[3] = (char) malPlacé;
		return result;
	}
}