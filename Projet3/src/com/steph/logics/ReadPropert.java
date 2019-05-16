package com.steph.logics;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropert {


	public static void main(final String[] args) {
		final Properties prop = new Properties();

		InputStream input = null;

		try {

			input = new FileInputStream("/Users/stephaniemehraik/git/Logics/Projet3/src/dataConfig.properties");

			prop.load(input);
			int NB_DE_TOURS = Integer.parseInt(prop.getProperty("NB_DE_TOURS"));
			int codeSize = Integer.parseInt(prop.getProperty("codeSize"));
			String devMode = prop.getProperty("devMode");
			

		} catch (final IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static int getNbDeTours() {
		int NB_DE_TOURS = Integer.parseInt(new Properties().getProperty("NB_DE_TOURS"));
		return NB_DE_TOURS;
	}

	public static String getDevMode() {
		String devMode = new Properties().getProperty("devMode");
		return devMode;
	}

	public static int getCodeSize() {
		int codeSize = Integer.parseInt(new Properties().getProperty("codeSize"));
		return codeSize;
	}
}