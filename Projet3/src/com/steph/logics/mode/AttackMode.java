package com.steph.logics.mode;

import java.util.Scanner;

public class AttackMode extends Mode {

	private static String answer;

	public AttackMode() {
		super("Attack");
	}

	public String getSCode() {
		int secretCode = 1000 + (int) (Math.random() * ((10000 - 1000) + 1));
		String sCode = String.valueOf(secretCode);
		System.out.println(sCode);
		return sCode;
	}
	@Override
	public String getAnswer() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("entrez votre proposition");
		sc.hasNextLine();
		answer = sc.nextLine();
		return answer;
		
	}

}