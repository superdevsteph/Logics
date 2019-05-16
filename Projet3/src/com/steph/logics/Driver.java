package com.steph.logics;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.steph.logics.game.Game;
import com.steph.logics.game.GameFactory;
import com.steph.logics.mode.ModeType;

public class Driver {

	public static void main(String[] args) {
		

		do {

			ModeType modeType = Input.getModeType();
			Game game = GameFactory.gameInitialize(modeType);

			game.play();

		} while (Input.replay());

		System.out.println("Bye bye !!!");

	}
	public static int getNbDeTours() {
		int NB_DE_TOURS=0;  
		final Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("/Users/stephaniemehraik/git/Logics/Projet3/src/dataConfig.properties");

			prop.load(input);
			
			
			NB_DE_TOURS = Integer.parseInt(prop.getProperty("NB_DE_TOURS"));

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
		return NB_DE_TOURS;
		
	}

	public static String getDevMode() {
		String devMode ="";
		final Properties prop = new Properties();

		InputStream input = null;

		try {

			input = new FileInputStream("/Users/stephaniemehraik/git/Logics/Projet3/src/dataConfig.properties");

			prop.load(input);
			
			devMode = prop.getProperty("devMode");

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
		return devMode;
	}

	public static int getCodeSize() {
		int codeSize =0;
		final Properties prop = new Properties();
		

		InputStream input = null;

		try {

			input = new FileInputStream("/Users/stephaniemehraik/git/Logics/Projet3/src/dataConfig.properties");

			prop.load(input);
			
			codeSize = Integer.parseInt(prop.getProperty("codeSize"));

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
		return codeSize;
	}

}
