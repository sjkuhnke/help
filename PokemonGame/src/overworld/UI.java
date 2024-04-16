package overworld;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import entity.Entity;
import entity.PlayerCharacter;
import pokemon.AbstractUI;
import pokemon.Bag;
import pokemon.Item;
import pokemon.Move;
import pokemon.Moveslot;
import pokemon.Pokemon;

public class UI extends AbstractUI{

	public int menuNum = 0;
	public int subState = 0;
	public Entity npc;
	public int slotCol = 0;
	public int slotRow = 0;
	public int bagNum = 0;
	public int selectedBagNum = -1;
	public int currentPocket = Item.MEDICINE;
	public int bagState;
	public int sellAmt = 1;
	public int rareCandyAmt = 1;
	public Item currentItem;
	public ArrayList<Bag.Entry> currentItems;
	
	public int btX = 0;
	public int btY = 0;
	
	public boolean showMessage;
	public Pokemon currentPokemon;
	public Move currentMove;
	public String currentHeader;
	
	BufferedImage transitionBuffer;
	
	public static final int MAX_SHOP_COL = 10;
	public static final int MAX_SHOP_ROW = 4;
	
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		currentDialogue = "";
		commandNum = 0;
		
		try {
			InputStream is = getClass().getResourceAsStream("/font/marumonica.ttf");
			marumonica = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void showMessage(String text) {
		if (gp.gameState == GamePanel.PLAY_STATE) {
			gp.gameState = GamePanel.DIALOGUE_STATE;
		} else {
			showMessage = true;
		}
		currentDialogue = text;
	}
	
	@Override
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		
		g2.setFont(marumonica);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setColor(Color.WHITE);
		
		if (gp.gameState == GamePanel.DIALOGUE_STATE) {
			drawDialogueScreen(true);
		}
		
		if (gp.gameState == GamePanel.MENU_STATE) {
			drawMenuScreen();
		}
		
		if (gp.gameState == GamePanel.TRANSITION_STATE) {
			drawTransition();
		}
		
		if (gp.gameState == GamePanel.SHOP_STATE) {
			drawShopScreen();
		}
		
		if (gp.gameState == GamePanel.NURSE_STATE) {
			drawNurseScreen();
		}
		
		if (gp.gameState == GamePanel.START_BATTLE_STATE) {
			drawBattleStartTransition();
		}
		
		if (gp.gameState == GamePanel.USE_ITEM_STATE) {
			useItem();
		}
		
		if (gp.gameState == GamePanel.USE_RARE_CANDY_STATE) {
			useRareCandy();
		}
		
		if (gp.gameState == GamePanel.USE_REPEL_STATE) {
			drawRepelScreen();
		}
		
		if (showMoveOptions) {
			showMoveOptions();
		}
		
		if (showMessage) {
			drawDialogueScreen(true);
		}
	}

	private void showMoveOptions() {
		if (currentMove == null) {
			drawMoveOptions(null, currentPokemon, currentHeader);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				if (moveOption > 0) {
					if (currentItem == Item.ELIXIR) {
						Moveslot m = currentPokemon.moveset[moveOption - 1];
						if (m.currentPP != m.maxPP) {
			        		m.currentPP = m.maxPP;
				        	showMessage(m.move.toString() + "'s PP was restored!");
				        	gp.player.p.bag.remove(currentItem);
			        		currentItems = gp.player.p.getItems(currentPocket);
			        	} else {
			        		showMessage("It won't have any effect.");
			        	}
					} else if (currentItem == Item.PP_UP || currentItem == Item.PP_MAX) {
						Moveslot m = currentPokemon.moveset[moveOption - 1];
						if (m.maxPP < (m.move.pp * 8 / 5)) {
			    			if (currentItem == Item.PP_UP) { // PP Up
			    				m.maxPP += Math.max((m.move.pp / 5), 1);
			    				showMessage(m.move.toString() + "'s PP was increased!");
			    			} else { // PP Max
			    				m.maxPP = (m.move.pp * 8 / 5);
			    				showMessage(m.move.toString() + "'s PP was maxed!");
			    			}
				        	gp.player.p.bag.remove(currentItem);
			        		currentItems = gp.player.p.getItems(currentPocket);
			    		} else {
			    			showMessage("It won't have any effect.");
			    		}
					}
					showMoveOptions = false;
				}
			}
		} else {
			drawMoveOptions(currentMove, currentPokemon);
		}
	}

	private void useRareCandy() {
		int x = gp.tileSize * 12;
		int y = (int) (gp.tileSize * 1.5);
		int width = gp.tileSize * 3;
		int height = (int) (gp.tileSize * 3.5);
		drawSubWindow(x, y, width, height);
		
		x += gp.tileSize * 1.25;
		y += gp.tileSize * 2;
		g2.drawString(rareCandyAmt + "", x, y);
		
		int y2 = y += gp.tileSize / 4;
		int width2 = gp.tileSize / 2;
		int height2 = gp.tileSize / 2;
		g2.fillPolygon(new int[] {x, (x + width2), (x + width2 / 2)}, new int[] {y2, y2, y2 + height2}, 3);
		
		y2 = y -= gp.tileSize * 1.5;
		g2.fillPolygon(new int[] {x, (x + width2), (x + width2 / 2)}, new int[] {y2 + height2, y2 + height2, y2}, 3);
		
		if (gp.keyH.wPressed) {
			gp.keyH.wPressed = false;
			showMessage("Sold " + sellAmt + " " + currentItems.get(bagNum).getItem().toString() + " for $" + sellAmt * currentItems.get(bagNum).getItem().getSell());
			gp.player.p.sellItem(currentItems.get(bagNum).getItem(), sellAmt);
			currentItems = gp.player.p.getItems(currentPocket);
			bagState = 0;
			commandNum = 0;
			sellAmt = 1;
		}
	}

	private void useItem() {
		drawParty(currentItem);
		if (gp.keyH.wPressed && !showMoveOptions) {
			gp.keyH.wPressed = false;
			gp.player.p.useItem(gp.player.p.team[partyNum], currentItem, gp);
		}
	}

	public void drawMenuScreen() {
		g2.setColor(Color.WHITE);
		g2.setFont(g2.getFont().deriveFont(32F));
		
		int x = gp.tileSize * 10;
		int y = gp.tileSize;
		int width = gp.tileSize * 5;
		int height = gp.tileSize * 10;
		
		if (subState == 0) drawSubWindow(x, y, width, height);
		
		switch(subState) {
		case 0:
			optionsTop(x, y);
			break;
		case 1:
			gp.player.showDex();
			break;
		case 2:
			showParty();
			break;
		case 3:
			showBag();
			break;
		case 4:
			saveGame();
			break;
		case 5:
			gp.gameState = GamePanel.PLAY_STATE;
			subState = 0;
			gp.player.showPlayer();
			break;
		case 6:
			gp.openMap();
			break;
		case 7:
			drawSummary(null);
		}
	}

	private void saveGame() {
		currentDialogue = "Would you like to save the game?";
		drawDialogueScreen(true);
		
		int x = gp.tileSize * 11;
		int y = gp.tileSize * 4;
		int width = gp.tileSize * 3;
		int height = (int) (gp.tileSize * 2.5);
		drawSubWindow(x, y, width, height);
		x += gp.tileSize;
		y += gp.tileSize;
		g2.drawString("Yes", x, y);
		if (commandNum == 0) {
			g2.drawString(">", x-24, y);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				gp.gameState = GamePanel.PLAY_STATE;
				subState = 0;
				commandNum = 0;
				
				Path savesDirectory = Paths.get("./saves/");
	            if (!Files.exists(savesDirectory)) {
	                try {
						Files.createDirectories(savesDirectory);
					} catch (IOException e) {
						showMessage("The /saves/ folder could not be created.\nIf you are playing this game in your downloads,\ntry moving it to another folder.");
					}
	            }
	            
		    	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./saves/" + gp.player.currentSave))) {
	            	gp.player.p.setPosX(gp.player.worldX);
	            	gp.player.p.setPosY(gp.player.worldY);
	            	gp.player.p.currentMap = gp.currentMap;
	                oos.writeObject(gp.player.p);
	                oos.close();
	                showMessage("Game saved sucessfully!");
	            } catch (IOException ex) {
	            	showMessage("Error writing player to file:\n" + ex.getMessage());
	            }
			}
		}
		y += gp.tileSize;
		g2.drawString("No", x, y);
		if (commandNum == 1) {
			g2.drawString(">", x-24, y);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				subState = 0;
				commandNum = 0;
			}
		}
		
		gp.keyH.wPressed = false;
		
	}

	public void optionsTop(int x, int y) {
		String text = "Menu";
		
		int textX = (int) (getTextX(text) + gp.tileSize * 4.5);
		int textY = y + gp.tileSize;
		g2.drawString(text, textX, textY);
		
		g2.setFont(g2.getFont().deriveFont(24F));
		
		// Pokedex
		text = "Pokedex";
		textX = x + gp.tileSize * 2;
		textY += gp.tileSize;
		g2.drawImage(setup("/menu/" + text.toLowerCase(), 2), textX - gp.tileSize, textY - gp.tileSize / 2, null);
		g2.drawString(text, textX, textY);
		if (menuNum == 0) {
			g2.drawString(">", textX- (25 + gp.tileSize), textY);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				subState = 1;
			}
		}
		
		// Party
		text = "Party";
		textY += gp.tileSize;
		g2.drawImage(setup("/menu/" + text.toLowerCase(), 2), textX - gp.tileSize, textY - gp.tileSize / 2, null);
		g2.drawString(text, textX, textY);
		if (menuNum == 1) {
			g2.drawString(">", textX- (25 + gp.tileSize), textY);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				subState = 2;
			}
		}
		
		// Bag
		text = "Bag";
		textY += gp.tileSize;
		g2.drawImage(setup("/menu/" + text.toLowerCase(), 2), textX - gp.tileSize, textY - gp.tileSize / 2, null);
		g2.drawString(text, textX, textY);
		if (menuNum == 2) {
			g2.drawString(">", textX- (25 + gp.tileSize), textY);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				currentItems = gp.player.p.getItems(currentPocket);
				subState = 3;
			}
		}
		
		// Save
		text = "Save";
		textY += gp.tileSize;
		g2.drawImage(setup("/menu/" + text.toLowerCase(), 2), textX - gp.tileSize, textY - gp.tileSize / 2, null);
		g2.drawString(text, textX, textY);
		if (menuNum == 3) {
			g2.drawString(">", textX- (25 + gp.tileSize), textY);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				subState = 4;
			}
		}
		
		// Player
		text = "Player";
		textY += gp.tileSize;
		g2.drawImage(setup("/menu/" + text.toLowerCase(), 2), textX - gp.tileSize, textY - gp.tileSize / 2, null);
		g2.drawString(text, textX, textY);
		if (menuNum == 4) {
			g2.drawString(">", textX- (25 + gp.tileSize), textY);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				subState = 5;
			}
		}
		
		// Map
		text = "Map";
		textY += gp.tileSize;
		g2.drawImage(setup("/menu/" + text.toLowerCase(), 2), textX - gp.tileSize, textY - gp.tileSize / 2, null);
		g2.drawString(text, textX, textY);
		if (menuNum == 5) {
			g2.drawString(">", textX- (25 + gp.tileSize), textY);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				subState = 6;
			}
		}
		
		// Back
		text = "Back";
		textY += gp.tileSize * 2;
		g2.drawImage(setup("/menu/" + text.toLowerCase(), 2), textX - gp.tileSize, textY - gp.tileSize / 2, null);
		g2.drawString(text, textX, textY);
		if (menuNum == 6) {
			g2.drawString(">", textX- (25 + gp.tileSize), textY);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				gp.gameState = GamePanel.PLAY_STATE;
				subState = 0;
			}
		}
	}
	
	private void showParty() {
		drawParty(null);
		if (gp.keyH.aPressed) {
			gp.keyH.aPressed = false;
			if (partySelectedNum == -1) {
				partySelectedNum = partyNum;
			} else {
				if (partySelectedNum != partyNum) {
					gp.player.p.swap(partySelectedNum, partyNum);
				}
				partySelectedNum = -1;
			}
		}
		if (gp.keyH.wPressed) {
			gp.keyH.wPressed = false;
			subState = 7;
		}
	}
	
	private void showBag() {
		int x = gp.tileSize * 6;
		int y = gp.tileSize / 2;
		int width = gp.tileSize * 8;
		int height = gp.tileSize;
		drawSubWindow(x, y, width, height);
		String pocketName = Item.getPocketName(currentPocket);
		g2.drawString(pocketName, this.getCenterAlignedTextX(pocketName, x + (width / 2)), (int) (y + gp.tileSize * 0.75));
		
		y += gp.tileSize;
		height = gp.tileSize * 10;
		
		drawSubWindow(x, y, width, height);
		
		int descX = gp.tileSize / 2;
		int descY = gp.tileSize * 2;
		int descWidth = (int) (gp.tileSize * 5.5);
		int descHeight = gp.tileSize * 8;
		drawSubWindow(descX, descY, descWidth, descHeight);
		int textX = descX + 20;
		int textY = descY + gp.tileSize;
		g2.setFont(g2.getFont().deriveFont(24F));
		if (currentItems.size() > 0) {
			String desc = currentItems.get(bagNum).getItem().getDesc();
			for (String line : Item.breakString(desc, 25).split("\n")) {
				g2.drawString(line, textX, textY);
				textY += 32;
			}
		}
		g2.setFont(g2.getFont().deriveFont(32F));
		
		x += gp.tileSize;
		y += gp.tileSize / 2;
		for (int i = bagNum; i < bagNum + 9; i++) {
			g2.setColor(Color.WHITE);
			if (i == bagNum) {
				g2.drawString(">", (x - gp.tileSize / 2) - 2, y + gp.tileSize / 2);
			}
			if (i == selectedBagNum) {
				g2.setColor(Color.BLUE.brighter());
			}
			if (i < currentItems.size()) {
				Bag.Entry current = currentItems.get(i);
				g2.drawImage(current.getItem().getImage(), x, y, null);
				y += gp.tileSize / 2;
				String itemString = current.getItem().toString();
				if (currentPocket != Item.TMS) itemString += " x " + current.getCount();
				g2.drawString(itemString, x + gp.tileSize / 2, y);
				y += gp.tileSize / 2;
			}
		}
		// Down Arrow
		if (bagNum + 9 < currentItems.size()) {
			int x2 = gp.tileSize * 5 + width;
			int y2 = height + (gp.tileSize / 2);
			int width2 = gp.tileSize / 2;
			int height2 = gp.tileSize / 2;
			g2.fillPolygon(new int[] {x2, (x2 + width2), (x2 + width2 / 2)}, new int[] {y2, y2, y2 + height2}, 3);
		}
		// Up Arrow
		if (bagNum != 0 && bagState != 2) {
			int x2 = gp.tileSize * 5 + width;
			int y2 = gp.tileSize * 2;
			int width2 = gp.tileSize / 2;
			int height2 = gp.tileSize / 2;
			g2.fillPolygon(new int[] {x2, (x2 + width2), (x2 + width2 / 2)}, new int[] {y2 + height2, y2 + height2, y2}, 3);
		}
		// Subwindow for item options
		if (!showMoveOptions) {
			if (gp.keyH.aPressed) {
				gp.keyH.aPressed = false;
				if (selectedBagNum == -1) {
					selectedBagNum = bagNum;
				} else if (selectedBagNum == bagNum) {
					selectedBagNum = -1;
				} else {
					gp.player.p.moveItem(currentItems.get(selectedBagNum).getItem(), currentItems.get(bagNum).getItem());
					currentItems = gp.player.p.getItems(currentPocket);
					selectedBagNum = -1;
					if (bagNum > 0) bagNum--;
				}
			}
			if (bagState == 0 && gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				bagState = 1;
			}
		}
		
		if (bagState == 1) {
			drawItemOptions();
		} else if (bagState == 2) {
			drawSellOptions();
		} else if (bagState == 3) {
			drawMoveSummary(gp.tileSize / 2, gp.tileSize * 6, null, null, null, currentItems.get(bagNum).getItem().getMove());
		}
	}

	private void drawItemOptions() {
		int x = gp.tileSize * 12;
		int y = (int) (gp.tileSize * 1.5);
		int width = gp.tileSize * 3;
		int height = (int) (gp.tileSize * 3.5);
		drawSubWindow(x, y, width, height);
		
		x += gp.tileSize;
		y += gp.tileSize;
		String option1 = currentPocket == Item.BERRY || currentPocket == Item.HELD_ITEM ? "Give" : "Use";
		g2.drawString(option1, x, y);
		if (commandNum == 0) {
			g2.drawString(">", x-24, y);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				currentItem = currentItems.get(bagNum).getItem();
				if (currentItem == Item.REPEL) {
					if (!gp.player.p.repel) {
						useRepel();
				    } else {
				    	gp.ui.showMessage("It won't have any effect.");
				    }
					bagState = 0;
				} else if (currentItem == Item.CALCULATOR) {
					Item.useCalc(gp.player.p, null);
				} else {
					gp.gameState = GamePanel.USE_ITEM_STATE;
				}
			}
		}
		y += gp.tileSize;
		String option2 = currentPocket == Item.TMS ? "Info" : "Sell";
		g2.drawString(option2, x, y);
		if (commandNum == 1) {
			g2.drawString(">", x-24, y);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				bagState = currentPocket == Item.TMS ? 3 : 2;
			}
		}
		y += gp.tileSize;
		g2.drawString("Back", x, y);
		if (commandNum == 2) {
			g2.drawString(">", x-24, y);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				bagState = 0;
				commandNum = 0;
			}
		}
	}
	
	private void drawSellOptions() {
		int x = gp.tileSize * 12;
		int y = (int) (gp.tileSize * 1.5);
		int width = gp.tileSize * 3;
		int height = (int) (gp.tileSize * 3.5);
		drawSubWindow(x, y, width, height);
		
		x += gp.tileSize * 1.25;
		y += gp.tileSize * 2;
		g2.drawString(sellAmt + "", x, y);
		
		int y2 = y += gp.tileSize / 4;
		int width2 = gp.tileSize / 2;
		int height2 = gp.tileSize / 2;
		g2.fillPolygon(new int[] {x, (x + width2), (x + width2 / 2)}, new int[] {y2, y2, y2 + height2}, 3);
		
		y2 = y -= gp.tileSize * 1.5;
		g2.fillPolygon(new int[] {x, (x + width2), (x + width2 / 2)}, new int[] {y2 + height2, y2 + height2, y2}, 3);
		
		x -= gp.tileSize;
		y += gp.tileSize * 2.5;
		g2.setFont(g2.getFont().deriveFont(24F));
		g2.drawString("+$" + currentItems.get(bagNum).getItem().getSell() * sellAmt, x, y);
		
		if (gp.keyH.wPressed) {
			gp.keyH.wPressed = false;
			showMessage("Sold " + sellAmt + " " + currentItems.get(bagNum).getItem().toString() + " for $" + sellAmt * currentItems.get(bagNum).getItem().getSell());
			gp.player.p.sellItem(currentItems.get(bagNum).getItem(), sellAmt);
			currentItems = gp.player.p.getItems(currentPocket);
			bagState = 0;
			commandNum = 0;
			sellAmt = 1;
		}
		
	}
	
	public void drawTransition() {
		counter++;
		g2.setColor(new Color(0,0,0,counter*5));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		if (counter == 50) {
			counter = 0;
			gp.gameState = GamePanel.PLAY_STATE;
			gp.currentMap = gp.eHandler.tempMap;
			gp.player.worldX = gp.tileSize * gp.eHandler.tempCol;
			gp.player.worldY = gp.tileSize * gp.eHandler.tempRow;
			gp.player.worldY -= gp.tileSize / 4;
			gp.eHandler.previousEventX = gp.player.worldX;
			gp.eHandler.previousEventY = gp.player.worldY;
			gp.player.p.currentMap = gp.eHandler.tempMap;
			gp.eHandler.canTouchEvent = !gp.eHandler.tempCooldown;
			gp.player.p.surf = false;
			gp.player.p.lavasurf = false;
			
			PMap.getLoc(gp.currentMap, (int) Math.round(gp.player.worldX * 1.0 / 48), (int) Math.round(gp.player.worldY * 1.0 / 48));
			Main.window.setTitle("Pokemon Game - " + PlayerCharacter.currentMapName);
		}
	}
	
	private void drawBattleStartTransition() {
		int width = gp.tileSize * 2;
		int height = gp.tileSize * 2;
		counter++;
		Graphics2D transitionGraphics = transitionBuffer.createGraphics();
		transitionGraphics.setColor(Color.BLACK);
		transitionGraphics.fillRect(btX, btY, width, height);
	    transitionGraphics.dispose();

	    g2.drawImage(transitionBuffer, 0, 0, null);

		btX += width;
		if (btX >= gp.screenWidth) {
			btX = 0;
			btY += height;
			if (btY >= gp.screenHeight) {
				btY = 0;
				counter = 0;
				gp.battleUI.commandNum = 0;
				if (!gp.battleUI.foe.trainerOwned()) {
					gp.battleUI.ball = gp.player.p.getBall(gp.battleUI.ball);
					gp.battleUI.balls = gp.player.p.getBalls();
				}
				gp.battleUI.subState = BattleUI.STARTING_STATE;
				gp.gameState = GamePanel.BATTLE_STATE;
			}
		}
	}
	
	public void drawNurseScreen() {
		drawDialogueScreen(true);
		
		int x = gp.tileSize * 11;
		int y = gp.tileSize * 4;
		int width = gp.tileSize * 3;
		int height = (int) (gp.tileSize * 2.5);
		drawSubWindow(x, y, width, height);
		x += gp.tileSize;
		y += gp.tileSize;
		g2.drawString("Yes", x, y);
		if (commandNum == 0) {
			g2.drawString(">", x-24, y);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				gp.gameState = GamePanel.PLAY_STATE;
				showMessage("Your Pokemon were restored\nto full health!");
				gp.player.p.heal();
				subState = 0;
				commandNum = 0;
			}
		}
		y += gp.tileSize;
		g2.drawString("No", x, y);
		if (commandNum == 1) {
			g2.drawString(">", x-24, y);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				gp.gameState = GamePanel.PLAY_STATE;
				showMessage("Come again soon!");
				subState = 0;
				commandNum = 0;
			}
		}
		
		gp.keyH.wPressed = false;
	}
	
	public void drawShopScreen() {
		switch(subState) {
		case 0: shopSelect(); break;
		case 1: shopBuy(); break;
		}
		gp.keyH.wPressed = false;
	}
	
	public void shopSelect() {
		drawDialogueScreen(true);
		
		int x = gp.tileSize * 11;
		int y = gp.tileSize * 4;
		int width = gp.tileSize * 3;
		int height = (int) (gp.tileSize * 2.5);
		drawSubWindow(x, y, width, height);
		
		x += gp.tileSize;
		y += gp.tileSize;
		g2.drawString("Buy", x, y);
		if (commandNum == 0) {
			g2.drawString(">", x-24, y);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				subState = 1;
			}
		}
		y += gp.tileSize;
		g2.drawString("Exit", x, y);
		if (commandNum == 1) {
			g2.drawString(">", x-24, y);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				gp.gameState = GamePanel.PLAY_STATE;
				showMessage("Come again soon!");
				subState = 0;
				commandNum = 0;
			}
		}
	}
	
	public void shopBuy() {
		drawInventory(npc);
	}
	
	private void drawInventory(Entity entity) {
		int x = gp.tileSize * 2;
		int y = gp.tileSize;
		int width = gp.tileSize * 12;
		int height = gp.tileSize * 6;
		
		drawSubWindow(x, y, width, height);
		
		final int slotXstart = x + 20;
		final int slotYstart = y + 20;
		int slotX = slotXstart;
		int slotY = slotYstart;
		int slotSize = gp.tileSize + 5;
		
		for (int i = 0; i < entity.inventory.size(); i++) {
			g2.drawImage(npc.inventory.get(i).getImage2(), slotX, slotY, null);
			
			slotX += slotSize;
			
			if ((i + 1) % MAX_SHOP_COL == 0) {
				slotX = slotXstart;
				slotY += slotSize;
			}
		}
		
		int cursorX = slotXstart + (slotSize * slotCol);
		int cursorY = slotYstart + (slotSize * slotRow);
		int cursorWidth = gp.tileSize;
		int cursorHeight = gp.tileSize;
		
		g2.setColor(Color.WHITE);
		g2.setStroke(new BasicStroke(3));
		g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);
		
		int dFrameX = x;
		int dFrameY = y + height;
		int dFrameWidth = width;
		int dFrameHeight = gp.tileSize * 3;
		
		int textX = dFrameX + 20;
		int textY = (int) (dFrameY + gp.tileSize * 0.8);
		g2.setFont(g2.getFont().deriveFont(32F));
		
		int itemIndex = getItemIndexOnSlot();
		
		if (itemIndex < entity.inventory.size()) {
			Item current = entity.inventory.get(itemIndex);
			drawSubWindow(dFrameX,dFrameY,dFrameWidth,dFrameHeight);
			g2.drawString(current.toString(), textX, textY);
			String price = "$" + current.getCost();
			g2.drawString(price, getRightAlignedTextX(price, dFrameX + dFrameWidth - gp.tileSize / 2), textY);
			
			int amtX = dFrameX + dFrameWidth - gp.tileSize * 4;
			int amtY = dFrameY + dFrameHeight;
			int amtWidth = gp.tileSize * 4;
			int amtHeight = gp.tileSize;
			
			drawSubWindow(amtX, amtY, amtWidth, amtHeight);
			int amtTextX = amtX + 20;
			int amtTextY = (int) (amtY + gp.tileSize * 0.75);
			g2.drawString("You have: " + gp.player.p.bag.count[current.getID()], amtTextX, amtTextY);
			
			textY += 38;
			g2.setFont(g2.getFont().deriveFont(24F));
			String desc = current.isTM() ? current.getMove().getDescription() : current.getDesc();
			
			for (String line : Item.breakString(desc, 63).split("\n")) {
				g2.drawString(line, textX, textY);
				textY += 32;
			}
			
			if (gp.keyH.wPressed) {
				if (gp.player.p.buy(current)) {
					if (current.isTM()) {
						entity.inventory.remove(current);
					}
				} else {
					showMessage("Not enough money!");
				}
			}
		}
		
		int moneyX = x + width - gp.tileSize * 3;
		int moneyY = y - gp.tileSize;
		int moneyWidth = gp.tileSize * 3;
		int moneyHeight = gp.tileSize;
		
		drawSubWindow(moneyX, moneyY, moneyWidth, moneyHeight);
		textX = moneyX + 20;
		textY = (int) (moneyY + gp.tileSize * 0.75);
		g2.setFont(g2.getFont().deriveFont(32F));
		g2.drawString("$" + gp.player.p.getMoney(), textX, textY);
	}

	private int getItemIndexOnSlot() {
		int itemIndex = slotCol + (slotRow*MAX_SHOP_COL);
		return itemIndex;
	}
	
	public void drawRepelScreen() {
		currentDialogue = "Repel's effect wore off!\nWould you like to use another?";
		drawDialogueScreen(true);
		
		int x = gp.tileSize * 11;
		int y = gp.tileSize * 4;
		int width = gp.tileSize * 3;
		int height = (int) (gp.tileSize * 2.5);
		drawSubWindow(x, y, width, height);
		x += gp.tileSize;
		y += gp.tileSize;
		g2.drawString("Yes", x, y);
		if (commandNum == 0) {
			g2.drawString(">", x-24, y);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				gp.gameState = GamePanel.PLAY_STATE;
				useRepel();
			}
		}
		y += gp.tileSize;
		g2.drawString("No", x, y);
		if (commandNum == 1) {
			g2.drawString(">", x-24, y);
			if (gp.keyH.wPressed) {
				gp.keyH.wPressed = false;
				gp.gameState = GamePanel.PLAY_STATE;
				commandNum = 0;
			}
		}
	}
	
	private void useRepel() {
		gp.player.p.repel = true;
		gp.player.p.steps = 1;
		gp.player.p.bag.remove(Item.REPEL);
		currentItems = gp.player.p.getItems(currentPocket);
	}
}
