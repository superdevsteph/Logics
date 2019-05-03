package com.steph.logics;

import com.steph.logics.game.Game;
import com.steph.logics.game.GameFactory;
import com.steph.logics.game.GameType;
import com.steph.logics.mode.ModeType;

public class Driver {
	

		public static void main(String[] args) {

			do {
				GameType gameType = Input.getGameType();
				ModeType modeType = Input.getModeType();
				Game game = GameFactory.gameInitialize(gameType, modeType);

				game.play();

			} while (Input.replay());

			System.out.println("Bye bye !!!");
		}

	}

