package com.steph.logics.mode;

public abstract class Mode {

	private String name;
	protected static char [] proposition;

	public Mode(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public abstract String getSCode();

	public abstract String getAnswer();
	

	

}