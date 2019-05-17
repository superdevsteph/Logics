package com.steph.logics;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class App {

   /**
    * Déclaration du logger que nous allons utilisé
    * On utilise la classe App pour générer un nom de logger
    * unique dans notre application ici:
    * com.steph.logics.App
    */
   private static Logger logger = Logger.getLogger(App.class);

   /**
    * Une méthode main où on va juste effectuer un log
    * Un Hello World Log4j en somme
    */
   public static void main(String[] args){
	   
	   DOMConfigurator.configure(
		          App.class.getClassLoader().getResource("log4j.xml"));

      logger.info("Hello World!");
      try {
    	    // équivaut à logger.info("Message d'information");
    	    logger.log(Level.INFO, "Message d'information");
    		// Code pouvant soulever une Exception
    		//...
    	} catch(Exception e) {
    	    // équivaut à logger.log(Level.FATAL, "Une exception est survenue", e);
    	    logger.fatal("Une exception est survenue", e);
    	}
   }

}
