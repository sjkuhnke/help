package Overworld;

import Swing.Player;

public class EventHandler {

	
	GamePanel gp;
	Player p;
	EventRect eventRect[][][];
	
	int previousEventX, previousEventY;
	boolean canTouchEvent = true;
	
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		
		eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
		
		int map = 0;
		int col = 0;
		int row = 0;
		while(map < gp.maxMap && col < gp.maxWorldCol && row < gp.maxWorldRow) {
			
			eventRect[map][col][row] = new EventRect();
			eventRect[map][col][row].x = 23;
			eventRect[map][col][row].y = 23;
			eventRect[map][col][row].width = 2;
			eventRect[map][col][row].height = 2;
			eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
			eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;
			
			col++;
			if (col == gp.maxWorldCol) {
				col = 0;
				row++;
				
				if (row == gp.maxWorldRow) {
					row = 0;
					map++;
				}
			}
		}
	}
	
	public void checkEvent() {
//		int xDistance = Math.abs(gp.player.worldX - previousEventX);
//		int yDistance = Math.abs(gp.player.worldY - previousEventY);
//		int distance = Math.max(xDistance, yDistance);
//		if (distance > gp.tileSize) {
//			canTouchEvent = true;
//		}
		
		canTouchEvent = true;
		
		if (canTouchEvent) {
			// Bananaville Town PC
			if (hit(0,35,44,"any")) teleport(1, 31, 45);
			if (hit(1,31,46,"any")) teleport(0, 35, 45);
			
			// Bananaville Town Shop
			if (hit(0,27,53,"any")) teleport(2, 31, 45);
			if (hit(2,31,46,"any")) teleport(0, 27, 54);
			
			// Route 23 <-> Poppy Grove gate
			if (hit(0,20,10,"any")) {
				teleport(3, 31, 45);
				gp.player.p.flags[0] = true;
			}
			if (hit(3,31,46,"any")) teleport(0, 20, 11);
			if (hit(3,31,33,"any")) teleport(4, 74, 84);
			if (hit(4,74,85,"any")) teleport(3, 31, 34);
			
			// Poppy Grove PC
			if (hit(4,69,71,"any")) teleport(5, 31, 45);
			if (hit(5,31,46,"any")) teleport(4, 69, 72);
			
			// Poppy Grove Shop
			if (hit(4,64,71,"any")) teleport(6, 31, 45);
			if (hit(6,31,46,"any")) teleport(4, 64, 72);
			
			// Poppy Grove Warehouse
			if (hit(4,66,79,"any")) teleport(7, 31, 45);
			if (hit(7,31,46,"any")) teleport(4, 66, 80);
			if (hit(7,40,39,"any")) teleport(8, 28, 39);
			if (hit(8,27,39,"any")) teleport(7, 39, 39);
			
			// Poppy Grove Gym
			if (hit(4,81,61,"any")) teleport(9, 31, 45);
			if (hit(9,31,46,"any")) teleport(4, 81, 62);
			
			// Route 24 pt. 1 gate
			if (hit(4,7,68,"any")) teleport(10, 36, 40);
			if (hit(10,37,40,"any")) teleport(4, 8, 68);
			if (hit(10,22,40,"any")) teleport(11, 91, 61);
			if (hit(11,92,61,"any")) teleport(10, 23, 40);
			
			// Route 25 gate
			if (hit(11,24,29,"any")) teleport(12, 31, 45);
			if (hit(12,31,46,"any")) teleport(11, 24, 30);
			if (hit(12,31,33,"any")) teleport(13, 25, 89);
			if (hit(13,25,90,"any")) teleport(12, 31, 34);
			
			// Energy Plant A
			if (hit(13,16,85,"any")) teleport(14, 31, 49);
			if (hit(14,31,50,"any")) teleport(13, 16, 86);
			if (hit(14,21,37,"any")) teleport(15, 50, 40);
			if (hit(15,51,40,"any")) teleport(14, 22, 37);
			
			// Energy Plant B
			if (hit(15,32,9,"any")) teleport(16, 32, 46);
			if (hit(16,31,46,"any")) teleport(15, 31, 9);
			
			// Office
			if (hit(13,45,57,"any")) teleport(17, 53, 56);
			if (hit(17,53,57,"any")) teleport(13, 45, 58);
			
			if (hit(17,52,46,"down")) gp.aSetter.updateNPC();
			if (hit(17,53,46,"down")) gp.aSetter.updateNPC();
			if (hit(17,54,46,"down")) gp.aSetter.updateNPC();
			
			if (hit(17,48,53,"any")) teleport(18, 54, 51);
			if (hit(18,55,51,"any")) teleport(17, 49, 53);
			if (hit(17,58,53,"any")) teleport(18, 42, 51);
			if (hit(18,41,51,"any")) teleport(17, 57, 53);
			
			// Sicab PC
			if (hit(13,35,85,"any")) teleport(19, 31, 45);
			if (hit(19,31,46,"any")) teleport(13, 35, 86);
			
			// Sicab Shop
			if (hit(13,9,85,"any")) teleport(20, 31, 45);
			if (hit(20,31,46,"any")) teleport(13, 9, 86);
			
			// Sicab Fishing House
			if (hit(13,41,75,"any")) teleport(32, 31, 45);
			if (hit(32,31,46,"any")) teleport(13, 41, 76);
			
			// Gym 2
			if (hit(13,12,56,"any")) teleport(21, 63, 62);
			if (hit(21,63,63,"any")) teleport(13, 12, 57);
			
			// Bannana Grove to Route 40 gate
			if (hit(0,17,58,"any")) teleport(23, 31, 34);
			if (hit(23,31,33,"any")) teleport(0, 17, 57);
			if (hit(23,31,46,"any")) teleport(22, 76, 8);
			if (hit(22,76,7,"any")) teleport(23, 31, 45);
			
			// Route 26 to Mt. Splinkty
			if (hit(13,24,5,"any")) teleport(24, 56, 84);
			if (hit(24,56,85,"any")) teleport(13, 24, 6);
		}
	}
	
	public boolean hit(int map, int col, int row, String reqDirection) {
		
		boolean hit = false;
		
		if (map == gp.currentMap) {
			gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
			gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
			eventRect[map][col][row].x = col*gp.tileSize + eventRect[map][col][row].x;
			eventRect[map][col][row].y = row*gp.tileSize + eventRect[map][col][row].y;
			
			if (gp.player.solidArea.intersects(eventRect[map][col][row])) {
				if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
					hit = true;
				}
			}
			
			gp.player.solidArea.x = gp.player.solidAreaDefaultX;
			gp.player.solidArea.y = gp.player.solidAreaDefaultY;
			eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
			eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
		}
		
		
		return hit;
	}
	
	public void teleport(int map, int col, int row) {
		gp.currentMap = map;
		gp.player.worldX = gp.tileSize * col;
		gp.player.worldY = gp.tileSize * row;
		gp.player.worldY -= gp.tileSize / 4;
		p.currentMap = map;
		
		gp.aSetter.updateNPC();
		gp.aSetter.setInteractiveTile();
	}
}
