package com.steph.logics;

import java.util.Properties;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

public class PropertyLoader {
	static String newLine = System.getProperty("line.separator");
	private static Logger logger = Logger.getLogger(Driver.class);
	protected static int codeSize;
	protected static int NB_DE_TOURS;
	protected static String devMode;

	public static Properties load(String filename) throws IOException, FileNotFoundException {

		Properties prop = new Properties();

		FileInputStream input = new FileInputStream(
				"/Users/stephaniemehraik/git/Logics/Projet3/src/dataConfig.properties");

		try {

			prop.load(input);
			try {
				NB_DE_TOURS = Integer.parseInt(prop.getProperty("NB_DE_TOURS"));
			} catch (NumberFormatException e) {
				logger.fatal("Erreur de saisie, la valeur par défaut (NB_DE_TOURS = 10) est appliquée."+ newLine);
				NB_DE_TOURS = 10;
			}
			try {
			codeSize = Integer.parseInt(prop.getProperty("codeSize"));
		} catch (NumberFormatException e) {
			logger.fatal("Erreur de saisie, la valeur par défaut (codeSize = 4) est appliquée."+ newLine);
			codeSize = 4;
		}
			devMode = prop.getProperty("devMode");

		} finally {
			input.close();
		}
		return prop;

	}

	public static int getNbDeTours() {
		return NB_DE_TOURS;
	}

	public static int getCodeSize() {
		return codeSize;
	}

	public static String getDevMode() {
		return devMode;
	}
}
