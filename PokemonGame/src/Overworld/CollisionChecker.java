package Overworld;

import java.awt.Rectangle;

import Entity.Entity;
import Entity.NPC_Clerk;
import Entity.NPC_Nurse;
import Entity.NPC_Rival;
import Entity.NPC_Rival2;
import Entity.NPC_TN;
import Entity.NPC_Trainer;
import tile.BuildingTile;
import tile.CaveTile;
import tile.GrassTile;

public class CollisionChecker {
	
	GamePanel gp;
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX/gp.tileSize;
		int entityRightCol = entityRightWorldX/gp.tileSize;
		int entityTopRow = entityTopWorldY/gp.tileSize;
		int entityBottomRow = entityBottomWorldY/gp.tileSize;
		
		int tileNum1, tileNum2;
		
		tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
	    tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
	    if (gp.tileM.tile[tileNum1] instanceof GrassTile || gp.tileM.tile[tileNum2] instanceof GrassTile
	    	|| gp.tileM.tile[tileNum1] instanceof BuildingTile || gp.tileM.tile[tileNum2] instanceof BuildingTile
	    	|| gp.tileM.tile[tileNum1] instanceof CaveTile || gp.tileM.tile[tileNum2] instanceof CaveTile) {
	        entity.inTallGrass = true;
	    } else {
	        entity.inTallGrass = false;
	    }
		
		switch(entity.direction) {
		case "up":
			entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
			if (gp.tileM.tile[tileNum1].collision && 
					(gp.tileM.tile[tileNum1].collisionDirection.equals("all") || !entity.direction.equals(gp.tileM.tile[tileNum1].collisionDirection))) {
                entity.collisionOn = true;
            } else if (gp.tileM.tile[tileNum2].collision &&
                (gp.tileM.tile[tileNum2].collisionDirection.equals("all") || !entity.direction.equals(gp.tileM.tile[tileNum2].collisionDirection))) {
                entity.collisionOn = true;
            }
            break;
		case "down":
	        entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
	        tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];
	        tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];
	        if (gp.tileM.tile[tileNum1].collision &&
	            (gp.tileM.tile[tileNum1].collisionDirection.equals("all") || !entity.direction.equals(gp.tileM.tile[tileNum1].collisionDirection))) {
	            entity.collisionOn = true;
	        } else if (gp.tileM.tile[tileNum2].collision && !gp.tileM.tile[tileNum2].collisionDirection.equals("up") &&
	            (gp.tileM.tile[tileNum2].collisionDirection.equals("all") || !entity.direction.equals(gp.tileM.tile[tileNum2].collisionDirection))) {
	            entity.collisionOn = true;
	        }
	        break;

	    case "left":
	        entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
	        tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
	        tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];
	        if (gp.tileM.tile[tileNum1].collision &&
	            (gp.tileM.tile[tileNum1].collisionDirection.equals("all") || !entity.direction.equals(gp.tileM.tile[tileNum1].collisionDirection))) {
	            entity.collisionOn = true;
	        } else if (gp.tileM.tile[tileNum2].collision && !gp.tileM.tile[tileNum2].collisionDirection.equals("right") &&
	            (gp.tileM.tile[tileNum2].collisionDirection.equals("all") || !entity.direction.equals(gp.tileM.tile[tileNum2].collisionDirection))) {
	            entity.collisionOn = true;
	        }
	        break;

	    case "right":
	        entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
	        tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
	        tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];
	        if (gp.tileM.tile[tileNum1].collision &&
	            (gp.tileM.tile[tileNum1].collisionDirection.equals("all") || !entity.direction.equals(gp.tileM.tile[tileNum1].collisionDirection))) {
	            entity.collisionOn = true;
	        } else if (gp.tileM.tile[tileNum2].collision && !gp.tileM.tile[tileNum2].collisionDirection.equals("left") &&
	            (gp.tileM.tile[tileNum2].collisionDirection.equals("all") || !entity.direction.equals(gp.tileM.tile[tileNum2].collisionDirection))) {
	            entity.collisionOn = true;
	        }
	        break;
		}
	}
	
	public int checkObject(Entity entity) {
		int index = -1;
		
		for (int i = 0; i < gp.obj[1].length; i++) {
			if (gp.obj[gp.currentMap][i] != null) {
				
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].worldX + gp.obj[gp.currentMap][i].solidArea.x;
				gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].worldY + gp.obj[gp.currentMap][i].solidArea.y;
				
				switch(entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					if (entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)) {
						entity.collisionOn = true;
						index = i;
					}
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					if (entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)) {
						entity.collisionOn = true;
						index = i;
					}
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					if (entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)) {
						entity.collisionOn = true;
						index = i;
					}
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					if (entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)) {
						entity.collisionOn = true;
						index = i;
					}
					break;
				}
				
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].solidAreaDefaultX;
				gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].solidAreaDefaultY;
				
			}
		}
		
		return index;
	}
	
	public int checkEntity(Entity entity, Entity[][] target) {
	    int index = 999;

	    for (int i = 0; i < target[1].length; i++) {
	        if (target[gp.currentMap][i] != null) {
	            Rectangle entityRange = new Rectangle(entity.worldX + entity.solidArea.x, entity.worldY + entity.solidArea.y, entity.solidArea.width, entity.solidArea.height);
	            int targetX = target[gp.currentMap][i].worldX;
	            if (target[gp.currentMap][i] instanceof NPC_Clerk) targetX += gp.tileSize;
	            int targetY = target[gp.currentMap][i].worldY;
	            if (target[gp.currentMap][i] instanceof NPC_Nurse) targetY += gp.tileSize;
	            Rectangle targetRange = new Rectangle(targetX + target[gp.currentMap][i].solidArea.x, targetY + target[gp.currentMap][i].solidArea.y, target[gp.currentMap][i].solidArea.width, target[gp.currentMap][i].solidArea.height);

	            switch (entity.direction) {
	                case "up":
	                    entityRange.y -= entity.speed;
	                    break;
	                case "down":
	                    entityRange.y += entity.speed;
	                    break;
	                case "left":
	                    entityRange.x -= entity.speed;
	                    break;
	                case "right":
	                    entityRange.x += entity.speed;
	                    break;
	            }

	            if (entityRange.intersects(targetRange) && target[gp.currentMap][i].collision) {
	                entity.collisionOn = true;
	                index = i;
	            }
	        }
	    }
	    return index;
	}

	public boolean checkTrainer(Entity entity, Entity target, int trainer) {
		if (trainer >= gp.player.p.trainersBeat.length) return false;
		if (gp.player.p.trainersBeat[trainer]) return false;
	    int visionRange = 4 * gp.tileSize;
	    boolean result = false;

	    if ((target instanceof NPC_Trainer || target instanceof NPC_TN || target instanceof NPC_Rival || target instanceof NPC_Rival2) && target != null) {
	        Rectangle entityRange = new Rectangle(entity.worldX + entity.solidArea.x, entity.worldY + entity.solidArea.y, entity.solidArea.width, entity.solidArea.height);
	        Rectangle trainerRange = new Rectangle(target.worldX + target.solidArea.x, target.worldY + target.solidArea.y, target.solidArea.width, target.solidArea.height);

	        switch (target.direction) {
	            case "up": {
	                // Check for collision tiles within the vision range
	                int range = 0;
	                for (int row = trainerRange.y / gp.tileSize; row >= (trainerRange.y - visionRange) / gp.tileSize; row--) {
	                    int tileNum = gp.tileM.mapTileNum[gp.currentMap][trainerRange.x / gp.tileSize][row];
	                    if (gp.tileM.tile[tileNum].collision) {
	                        break;
	                    }
	                    range++;
	                }
	                
	                range *= gp.tileSize;
	                trainerRange.y -= range;
	                trainerRange.height += range;

	                break;
	            }
	            case "down": {
	                // Check for collision tiles within the vision range
	                int range = 0;
	                for (int row = trainerRange.y / gp.tileSize; row <= (trainerRange.y + trainerRange.height + visionRange) / gp.tileSize; row++) {
	                    int tileNum = gp.tileM.mapTileNum[gp.currentMap][trainerRange.x / gp.tileSize][row];
	                    if (gp.tileM.tile[tileNum].collision) {
	                        break;
	                    }
	                    range++;
	                }
	                
	                range *= gp.tileSize;
	                trainerRange.height += range;

	                break;
	            }
	            case "left": {
	                // Check for collision tiles within the vision range
	                int range = 0;
	                for (int col = trainerRange.x / gp.tileSize; col >= (trainerRange.x - visionRange) / gp.tileSize; col--) {
	                    int tileNum = gp.tileM.mapTileNum[gp.currentMap][col][trainerRange.y / gp.tileSize];
	                    if (gp.tileM.tile[tileNum].collision) {
	                        break;
	                    }
	                    range++;
	                }
	                
	                range *= gp.tileSize;
	                trainerRange.x -= range;
	                trainerRange.width += range;

	                break;
	            }
	            case "right": {
	                // Check for collision tiles within the vision range
	                int range = 0;
	                for (int col = trainerRange.x / gp.tileSize; col <= (trainerRange.x + trainerRange.width + visionRange) / gp.tileSize; col++) {
	                    int tileNum = gp.tileM.mapTileNum[gp.currentMap][col][trainerRange.y / gp.tileSize];
	                    if (gp.tileM.tile[tileNum].collision) {
	                        break;
	                    }
	                    range++;
	                }

	                range *= gp.tileSize;
	                trainerRange.width += range;
	                
	                break;
	            }
	        }

	        if (entityRange.intersects(trainerRange)) {
	            result = true;
	        }
	    }
	    return result;
	}
	
	public int checkTileType(Entity entity) {
		int[] coords = new int[2];
				
		switch(entity.direction) {
		case "up":
			coords[0] = entity.worldX;
			coords[1] = entity.worldY - gp.tileSize;
			break;
		case "down":
			coords[0] = entity.worldX;
			coords[1] = entity.worldY + gp.tileSize;
			break;
		case "left":
			coords[0] = entity.worldX - gp.tileSize;
			coords[1] = entity.worldY;
			break;
		case "right":
			coords[0] = entity.worldX + gp.tileSize;
			coords[1] = entity.worldY;
			break;
		}
		
		double xD = coords[0];
		xD /= gp.tileSize;
		int x = (int) Math.round(xD);
		
		double yD = coords[1];
		yD /= gp.tileSize;
		int y = (int) Math.round(yD);
		
		int result = gp.tileM.mapTileNum[gp.currentMap][x][y];
		
		return result;
			
	}




}
