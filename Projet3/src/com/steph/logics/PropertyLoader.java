package com.steph.logics;

import java.util.Properties;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

public class PropertyLoader{
	
	protected static int codeSize;
	protected static int NB_DE_TOURS;

   public static Properties load(String filename) throws IOException, FileNotFoundException{
	   
	   Properties prop = new Properties();
		
		 FileInputStream	input = new FileInputStream("C:/Users/steph/git/Logics/Projet3/src/dataConfig.properties");
		 
      try{

         prop.load(input);
         
         NB_DE_TOURS = Integer.parseInt(prop.getProperty("NB_DE_TOURS"));
         System.out.println(NB_DE_TOURS);
         
         codeSize = Integer.parseInt(prop.getProperty("codeSize"));
         System.out.println(codeSize);

  
      }
              finally{
         input.close();
      }
	return prop;

   }


	public static int getNbDeTours() {
		return NB_DE_TOURS;
	}
	
	public static  int getCodeSize() {
		return codeSize;
	}
	}
