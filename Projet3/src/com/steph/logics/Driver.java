package com.steph.logics;

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
	
			try{
				
				Properties prop = PropertyLoader.load("dataConfig.properties");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		
		DOMConfigurator.configure(
		          Driver.class.getClassLoader().getResource("log4j.xml"));

    logger.log(Level.INFO, "Start");
   
    try {
  	    // équivaut à logger.info("Message d'information");
  	    logger.log(Level.INFO, "Stop");
  		// Code pouvant soulever une Exception
  		//...
  	} catch(Exception e) {
  	    // équivaut à logger.log(Level.FATAL, "Une exception est survenue", e);
  	    logger.fatal("Une exception est survenue", e);
  	}
		do {

			ModeType modeType = Input.getModeType();
			Game game = GameFactory.gameInitialize(modeType);

			game.play();

		} while (Input.replay());

		System.out.println("Bye bye !!!");
		
		

}
}