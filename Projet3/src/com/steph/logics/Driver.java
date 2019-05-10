package com.steph.logics;

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

	}

