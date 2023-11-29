package Obj;

import Overworld.GamePanel;

public class Rock_Climb extends InteractiveTile {
	public int deltaX;
	public int deltaY;
	public int amt;

	public Rock_Climb(GamePanel gp, int mode, int amt) {
		super(gp);
		this.amt = amt;
		
		switch (mode) {
		case 0:
			this.direction = "down";
			this.down1 = setup("/npc/rock_climb2");
			this.deltaY = 1;
			break;
		case 1:
			this.direction = "left";
			this.left1 = setup("/npc/rock_climb3");
			this.deltaX = -1;
			break;
		case 2:
			this.direction = "up";
			this.up1 = setup("/npc/rock_climb0");
			this.deltaY = -1;
			break;
		case 3:
			this.direction = "right";
			this.right1 = setup("/npc/rock_climb1");
			this.deltaX = 1;
			break;
		}
	}
}
