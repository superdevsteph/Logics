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

		final Properties prop = new Properties();
		
		InputStream input = null;
		try {
			
			input = new FileInputStream("C:/Users/steph/git/Logics/Projet3/src/dataConfig.properties");
			
			// load a properties file
			prop.load(input);
			
			// get the property value and print it out
			System.out.println(prop.getProperty("NB_DE_TOURS"));
			
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
		do {

			ModeType modeType = Input.getModeType();
			Game game = GameFactory.gameInitialize(modeType);

			game.play();

		} while (Input.replay());

		System.out.println("Bye bye !!!");



	}

}
