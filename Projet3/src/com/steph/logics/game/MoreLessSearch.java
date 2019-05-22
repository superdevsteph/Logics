
package com.steph.logics.game;

import com.steph.logics.PropertyLoader;
import com.steph.logics.Utils;
import com.steph.logics.mode.Mode;

public class MoreLessSearch extends Game {

	public MoreLessSearch(Mode mode) {
		super(mode);
	}

	public char[] compare() {
	
		char[] result = new char[PropertyLoader.getCodeSize()];
		char[] proposition = Utils.getProposition(answer);
		char[] response = Utils.getResponse(sCode);

		for (int i = 0; i < proposition.length; i++) {

			if (proposition[i] > response[i]) {
				System.out.print("-");
				result[i] = '-';
			} else if (proposition[i] < response[i]) {
				System.out.print("+");
				result[i] = '+';
			} else if ((proposition[i] == response[i]) && (!proposition.equals(response))) {
				System.out.print("=");
				result[i] = '=';
			}

		}
		return result;
	}

}