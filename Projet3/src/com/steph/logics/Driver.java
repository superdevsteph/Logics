package com.steph.logics;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.steph.logics.game.Game;
import com.steph.logics.game.GameFactory;
import com.steph.logics.mode.ModeType;

public class Driver {
	private static Logger logger = Logger.getLogger(Driver.class);

	public static void main(String[] args) {
		try {
			
			Properties prop = PropertyLoader.load("dataConfig.properties");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			logger.log(Level.INFO, "Start");
		} catch (Exception e) {

			logger.fatal("Une exception est survenue", e);
		}


		DOMConfigurator.configure(Driver.class.getClassLoader().getResource("log4j.xml"));

		do {

			ModeType modeType = Input.getModeType();
			Game game = GameFactory.gameInitialize(modeType);

			game.play();

		} while (Input.replay());

		try {
			logger.log(Level.INFO, "Bye bye !!!");
		} catch (Exception e) {

			logger.fatal("Une exception est survenue", e);
		}

		long octets = new File("logs.log").length();
		if (octets > 50000l) {
			try {
				FileOutputStream fos = new FileOutputStream("logs.log");
				fos.close();
			} catch (Exception e) {
				logger.fatal("Une exception est survenue", e);
			}
		}

	}
}