package com.steph.logics.game;

import com.steph.logics.mode.Mode;
import com.steph.logics.mode.ModeFactory;
import com.steph.logics.mode.ModeType;

public class GameFactory {
	public static Game gameInitialize(ModeType modeType) { 
		Mode mode = ModeFactory.modeInitialize(modeType);
		
		return new MoreLessSearch(mode);

	}
}