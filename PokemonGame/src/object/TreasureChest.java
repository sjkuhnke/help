package object;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import overworld.GamePanel;
import pokemon.Item;

public class TreasureChest extends ItemObj {
	public ArrayList<Item> items;
	public boolean open;
	public int map;
	
	private static HashMap<Item, Integer> resourcePool = new HashMap<>();
	private static HashMap<Item, Integer> treasurePool = new HashMap<>();
	private static HashMap<Item, Integer> stonePool = new HashMap<>();
	
	static {
		resourcePool.put(Item.RARE_CANDY, 5);
        resourcePool.put(Item.REVIVE, 10);
        resourcePool.put(Item.MAX_REVIVE, 8);
        resourcePool.put(Item.PP_UP, 12);
        resourcePool.put(Item.PP_MAX, 5);
        resourcePool.put(Item.ABILITY_CAPSULE, 7);
        resourcePool.put(Item.ABILITY_PATCH, 6);
        
        treasurePool.put(Item.BOTTLE_CAP, 10);
        treasurePool.put(Item.GOLD_BOTTLE_CAP, 6);
        treasurePool.put(Item.RUSTY_BOTTLE_CAP, 5);
        treasurePool.put(Item.TINY_MUSHROOM, 10);
        treasurePool.put(Item.BIG_MUSHROOM, 5);
        treasurePool.put(Item.NUGGET, 15);
        treasurePool.put(Item.BIG_NUGGET, 9);
        treasurePool.put(Item.STAR_PIECE, 10);
        treasurePool.put(Item.RELIC_GOLD, 8);
        treasurePool.put(Item.RELIC_SILVER, 14);
        
        stonePool.put(Item.EUPHORIAN_GEM, 6);
        stonePool.put(Item.LEAF_STONE, 3);
        stonePool.put(Item.FIRE_STONE, 2);
        stonePool.put(Item.WATER_STONE, 3);
        stonePool.put(Item.DUSK_STONE, 4);
        stonePool.put(Item.DAWN_STONE, 3);
        stonePool.put(Item.ICE_STONE, 3);
        stonePool.put(Item.VALIANT_GEM, 2);
        stonePool.put(Item.PETTICOAT_GEM, 2);
        stonePool.put(Item.RAZOR_CLAW, 1);
        stonePool.put(Item.THUNDER_SCALES_FOSSIL, 2);
        stonePool.put(Item.DUSK_SCALES_FOSSIL, 2);
	}
	
	public TreasureChest(GamePanel gp, boolean open, int map) {
		super(gp);

		this.open = open;
		this.map = map;
		
		try {
			if (open) {
				image = ImageIO.read(getClass().getResourceAsStream("/interactive/chest_open.png"));
			} else {
				image = ImageIO.read(getClass().getResourceAsStream("/interactive/chest.png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		gp.chests.add(this);
	}
	
	@Override
	public void draw(Graphics2D g2) {
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
			worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			
			int height = image.getHeight() * gp.scale;
			int hOffset = height - gp.tileSize;
			
			g2.drawImage(image, screenX, screenY - hOffset, gp.tileSize, height, null);
		}
	}
	
	@Override
	public void setItems(boolean sort, Item... items) {
		ArrayList<Item> itemList = new ArrayList<>();
		
		for (Item i : items) {
			itemList.add(i);
		}
		
		itemList.addAll(addChestLoot());
		Collections.shuffle(itemList);
		
		this.items = itemList;
	}

	private ArrayList<Item> addChestLoot() {
		ArrayList<Item> loot = new ArrayList<>();
		
		loot.addAll(pickRandomItems(resourcePool, 1, 4));   // Pick 1-5 from resources
        loot.addAll(pickRandomItems(treasurePool, 3, 5));   // Pick 4-8 from treasure
        loot.addAll(pickRandomItems(stonePool, 0, 2));      // Pick 0-2 from stones
		
		return loot;
	}

	private ArrayList<Item> pickRandomItems(HashMap<Item, Integer> pool, int min, int max) {
		ArrayList<Item> result = new ArrayList<>();
		Random random = new Random();
		
		int numItems = random.nextInt((max - min) + 1) + min;
		
		int totalWeight = pool.values().stream().mapToInt(Integer::intValue).sum();
		
		for (int i = 0; i < numItems; i++) {
			int randomWeight = random.nextInt(totalWeight);
			int currentWeight = 0;
			for (Map.Entry<Item, Integer> entry : pool.entrySet()) {
				currentWeight += entry.getValue();
				if (randomWeight < currentWeight) {
					result.add(entry.getKey());
					break;
				}
			}
		}
		return result;
	}

	public void open() {
		this.open = true;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/interactive/chest_open.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
