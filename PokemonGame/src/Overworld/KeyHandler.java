package Overworld;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean upPressed, downPressed, leftPressed, rightPressed, sPressed, wPressed, dPressed, aPressed;
	
	GamePanel gp;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (gp.gameState == GamePanel.PLAY_STATE) {
			playState(code);
		} else if (gp.gameState == GamePanel.DIALOGUE_STATE) {
			dialogueState(code);
		} else if (gp.gameState == GamePanel.MENU_STATE) {
			menuState(code);
		} else if (gp.gameState == GamePanel.SHOP_STATE) {
			shopState(code);
		} else if (gp.gameState == GamePanel.NURSE_STATE) {
			nurseState(code);
		} else if (gp.gameState == GamePanel.BATTLE_STATE) {
			battleState(code);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_UP || code == KeyEvent.VK_I) {
			upPressed = false;
		}
		if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_K) {
			downPressed = false;
		}
		if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_J) {
			leftPressed = false;
		}
		if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_L) {
			rightPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			dPressed = false;
		}
		if (code == KeyEvent.VK_S) {
			sPressed = false;
		}
		if (code == KeyEvent.VK_W) {
			wPressed = false;
		}
		if (code == KeyEvent.VK_A) {
			aPressed = false;
		}
	}
	
	private void playState(int code) {
		if (code == KeyEvent.VK_UP || code == KeyEvent.VK_I) {
			upPressed = true;
		}
		if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_K) {
			downPressed = true;
		}
		if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_J) {
			leftPressed = true;
		}
		if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_L) {
			rightPressed = true;
		}
		if (code == KeyEvent.VK_D) {
			dPressed = true;
		}
		if (code == KeyEvent.VK_S) {
			sPressed = true;
		}
		if (code == KeyEvent.VK_W) {
			wPressed = true;
		}
		if (code == KeyEvent.VK_A) {
			aPressed = true;
		}
	}
	
	private void battleState(int code) {
		if (code == KeyEvent.VK_W) {
			wPressed = true;
		}
		if (gp.battleUI.subState == BattleUI.IDLE_STATE) {
			if (code == KeyEvent.VK_UP || code == KeyEvent.VK_I) {
				if (gp.battleUI.commandNum > 1) {
					gp.battleUI.commandNum -= 2;
				}
			}
			if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_K) {
				if (gp.battleUI.commandNum < 2) {
					gp.battleUI.commandNum += 2;
				}
			}
			if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_J) {
				if (gp.battleUI.commandNum % 2 == 1) {
					gp.battleUI.commandNum--;
				}
			}
			if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_L) {
				if (gp.battleUI.commandNum % 2 == 0) {
					gp.battleUI.commandNum++;
				}
			}
		}
		if (gp.battleUI.subState == BattleUI.MOVE_SELECTION_STATE) {
			if (code == KeyEvent.VK_S) {
				gp.battleUI.subState = BattleUI.IDLE_STATE;
			}
			if (code == KeyEvent.VK_UP || code == KeyEvent.VK_I) {
				if (gp.battleUI.moveNum > 1) {
					gp.battleUI.moveNum -= 2;
				}
			}
			if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_K) {
				if (gp.battleUI.moveNum < 2) {
					gp.battleUI.moveNum += 2;
				}
			}
			if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_J) {
				if (gp.battleUI.moveNum % 2 == 1) {
					gp.battleUI.moveNum--;
				}
			}
			if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_L) {
				if (gp.battleUI.moveNum % 2 == 0) {
					gp.battleUI.moveNum++;
				}
			}
		}
	}
	
	private void dialogueState(int code) {
		if (code == KeyEvent.VK_W || code == KeyEvent.VK_S) {
			gp.gameState = GamePanel.PLAY_STATE;
		}
	}
	
	private void menuState(int code) {
		if (code == KeyEvent.VK_D || code == KeyEvent.VK_S) {
			if (gp.ui.subState == 0) {
				gp.gameState = GamePanel.PLAY_STATE;
			}
			gp.ui.subState = 0;
		}
		if (code == KeyEvent.VK_W) {
			wPressed = true;
		}
		
		int maxCommandNum = 0;
		switch(gp.ui.subState) {
		case 0:
			maxCommandNum = 6;
		}
		
		if (code == KeyEvent.VK_UP || code == KeyEvent.VK_I) {
			gp.ui.menuNum--;
			if (gp.ui.menuNum < 0) {
				gp.ui.menuNum = maxCommandNum;
			}
		}
		if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_K) {
			gp.ui.menuNum++;
			if (gp.ui.menuNum > maxCommandNum) {
				gp.ui.menuNum = 0;
			}
		}
	}
	
	private void shopState(int code) {
		if (code == KeyEvent.VK_W) {
			wPressed = true;
		}
		
		if (gp.ui.subState == 0) {
			if (code == KeyEvent.VK_D || code == KeyEvent.VK_S) {
				gp.gameState = GamePanel.PLAY_STATE;
				gp.ui.subState = 0;
				gp.ui.commandNum = 0;
			}
			if (code == KeyEvent.VK_UP || code == KeyEvent.VK_I) {
				gp.ui.commandNum--;
				if (gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
				}
			}
			if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_K) {
				gp.ui.commandNum++;
				if (gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}
			}
		}
		if (gp.ui.subState > 0) {
			if (code == KeyEvent.VK_D || code == KeyEvent.VK_S) {
				gp.ui.subState = 0;
			}
			if (code == KeyEvent.VK_UP || code == KeyEvent.VK_I) {
				if (gp.ui.slotRow > 0) {
					gp.ui.slotRow--;
				}
			}
			if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_K) {
				if (gp.ui.slotRow < UI.MAX_SHOP_ROW) {
					gp.ui.slotRow++;
				}
			}
			if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_J) {
				if (gp.ui.slotCol > 0) {
					gp.ui.slotCol--;
				}
			}
			if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_L) {
				if (gp.ui.slotCol < UI.MAX_SHOP_COL - 1) {
					gp.ui.slotCol++;
				}
			}
		}
	}
	
	private void nurseState(int code) {
		if (code == KeyEvent.VK_D || code == KeyEvent.VK_S) {
			gp.gameState = GamePanel.PLAY_STATE;
			gp.ui.subState = 0;
			gp.ui.commandNum = 0;
		}
		if (code == KeyEvent.VK_W) {
			wPressed = true;
		}
		
		if (gp.ui.subState == 0) {
			if (code == KeyEvent.VK_UP || code == KeyEvent.VK_I) {
				gp.ui.commandNum--;
				if (gp.ui.commandNum < 0) {
					gp.ui.commandNum = 1;
				}
			}
			if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_K) {
				gp.ui.commandNum++;
				if (gp.ui.commandNum > 1) {
					gp.ui.commandNum = 0;
				}
			}
		}
	}
	
	public void resetKeys() {
		upPressed = false;
		downPressed = false;
		leftPressed = false;
		rightPressed = false;
		sPressed = false;
		wPressed = false;
		dPressed = false;
		aPressed = false;
	}

}
