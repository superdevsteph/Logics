package com.steph.logics.mode;

import java.util.Scanner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.steph.logics.Driver;
import com.steph.logics.PropertyLoader;
import com.steph.logics.Utils;

public class AttackMode extends Mode {
	
	 private static Logger logger = Logger.getLogger(Driver.class);

	private static String answer;

	public AttackMode() {
		super("Attack");
	}

	public String getSCode() {

		char secretCode[] = Utils.generate();
		String sCode = String.valueOf(secretCode);


		return sCode;
	}

	@Override
	public String getAnswer() {
		
		Scanner sc = new Scanner(System.in);
		logger.log(Level.INFO, "entrez votre proposition à "+ PropertyLoader.getCodeSize()+ " chiffres.");
		sc.hasNextLine();
		answer = sc.nextLine();
		return answer;

	}



}