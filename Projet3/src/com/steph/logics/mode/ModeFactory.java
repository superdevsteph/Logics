package com.steph.logics.mode;

public class ModeFactory {
	public static Mode modeInitialize(ModeType type) {
		switch (type) {
		case ATTACK:
			return new AttackMode();
		case DEFENDER:
			return new DefenderMode();
		case DUAL:
			return new DualMode();
		}
		
		return null;
	}
}