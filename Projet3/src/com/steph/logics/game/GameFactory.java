package com.steph.logics.game;

import com.steph.logics.mode.Mode;
import com.steph.logics.mode.ModeFactory;
import com.steph.logics.mode.ModeType;

public class GameFactory {
	public static Game gameInitialize(GameType gameType, ModeType modeType) {
		Mode mode = ModeFactory.modeInitialize(modeType);
		
		switch (gameType) {
		case MORE_OR_LESS:
			return new MoreLessSearch(mode);
		case MASTERMIND:
			return new Mastermind(mode);
		}
		
		return null;
	}
}