package Obj;

import Overworld.GamePanel;

public class Vine extends InteractiveTile {

	
	GamePanel gp;
	
	public Vine(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		down1 = setup("/npc/vines");
		destructible = false;
		collision = false;
	}
}