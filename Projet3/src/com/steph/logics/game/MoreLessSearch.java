
package com.steph.logics.game;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.steph.logics.Driver;
import com.steph.logics.PropertyLoader;
import com.steph.logics.Utils;
import com.steph.logics.mode.Mode;

public class MoreLessSearch extends Game {
	private static Logger logger = Logger.getLogger(Driver.class);
	public MoreLessSearch(Mode mode) {
		super(mode);
	}

	public char[] compare() {
	
		char[] result = new char[PropertyLoader.getCodeSize()];
		char[] proposition = Utils.getProposition(answer);
		char[] response = Utils.getResponse(sCode);

		for (int i = 0; i < proposition.length; i++) {

			if (proposition[i] > response[i]) {
			//	System.out.print("-");
				result[i] = '-';
			} else if (proposition[i] < response[i]) {
			//	System.out.print("+");
				result[i] = '+';
			} else if ((proposition[i] == response[i]) && (!proposition.equals(response))) {
			//	System.out.print("=");
				result[i] = '=';
			}

		}
		logger.log(Level.INFO, result);
		System.out.println(result);
		return result;
	}

}