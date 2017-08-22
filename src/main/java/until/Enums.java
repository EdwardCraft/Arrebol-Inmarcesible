package until;

public class Enums{

	public enum Facing{
		RIGHT,
		LEFT
	}

	public enum EnemySprite{
		WHEEL,
		COMPUTER
	}

	public enum JumpState{
		JUMPING,
		GROUNDED,
		FALLING
	}
	
	public enum BinState {
		PLASTIC,
		FOOD,
		METAL,
		BIN
	}

	public enum Direction{
		HORIZONTAL,
		VETICAL,
		STATIC
	}

	public enum PlayMode{
		NORMAL,
		LOOP
	}

	public enum ObjectId{
		foodTrash(),
		metalTrash(),
		plasticTrash(),
		foodBin(),
		metalBin(),
		plasticBin(),
		Player(),
		Block(),
		BlockDinamic(),
		LadderMaster(),
		Lines(),
		Spider(),
		Portal(),
		PortalB(),
		PortalRecycle(),
		Wheel(),
		Spyke(),
		FireBall(),
		WorksWheel(),
		PortalA(),
		MiddleBoss(),
		WarningBoss()
	}

	public enum ScreenState{
		MENU,
		LEVEL1,
		PAUSE,
		DEATH,
		LADDERGAME,
		RECYCLE,
		WINER,
		LOADING,
		HIGHSCORE,
		CREDITS
	}

	public enum WalkState{
		NOT_WALKING,
		WALKING,
		WAKEUP,
		FIRE

	}

	public enum Bench{
		BENCH1,
		BENCH2,
		NO_BENCH
	}

	public enum Bin{
		BIN,
		NO_BIN
	}

	public enum RectangleBounds{
		Top,
		Botton,
		Left,
		Right,
		R,
		L,
		M,
		N
	}

	public enum Movement{
		CIRCULAR,
		M180,
		HORIZONTAL,
		VETICAL,
		STATIC
	}

	public enum WorksState{
		ACTVE,
		INACTIVE
	}


}
