package Overworld;


import java.awt.Color;

import javax.swing.*;

import Entity.PlayerCharacter;
import Swing.Battle.JGradientButton;
import java.awt.Font;

public class PMap extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GamePanel gp;
	
	public PMap(GamePanel gp) {
		this.gp = gp;
		
		boolean[] locations = gp.player.p.locations; // NMT, BVT, PG, SC, KV, PP, SRC, GT, FC, RC, IT, CC
		
		double xD = gp.player.worldX;
		xD /= gp.tileSize;
		int x = (int) Math.round(xD);
		
		double yD = gp.player.worldY;
		yD /= gp.tileSize;
		int y = (int) Math.round(yD);
		
		int loc = getLoc(gp.currentMap, x, y);
		
		//setTitle("Map"); JFrame method
		    
	    // Initializing panel
	    //setResizable(false); JFrame method
	    setBounds(100, 100, 861, 538);
	    
	    JButton NMT = new JButton("");
	    NMT.setBounds(540, 330, 33, 31);
	    NMT.setToolTipText("New Minnow Town");
	    if (locations[0]) {
	    	NMT.setBackground(Color.red);
	    	NMT.addActionListener(e -> {
	    		fly("New Minnow Town", 0, 79, 46);
	    	});
	    }
	    if (loc == 0) NMT.setBackground(Color.yellow);
	    setLayout(null);
	    add(NMT);
	    
	    JButton R22 = new JButton("");
	    R22.setBounds(412, 341, 129, 10);
	    R22.setBackground(new Color(153, 255, 102));
	    R22.setToolTipText("Route 22");
	    if (loc == 1) R22.setBackground(Color.yellow);
	    add(R22);
	    
	    JButton BVT = new JButton("");
	    BVT.setBounds(368, 330, 44, 33);
	    BVT.setToolTipText("Bananaville Town");
	    if (locations[1]) {
	    	BVT.setBackground(Color.red);
	    	BVT.addActionListener(e -> {
	    		fly(BVT.getToolTipText(), 0, 35, 45);
	    	});
	    }
	    if (loc == 2) BVT.setBackground(Color.yellow);
	    add(BVT);
	    
	    JButton R23 = new JButton("");
	    R23.setBounds(382, 281, 12, 49);
	    R23.setBackground(new Color(153, 255, 102));
	    R23.setToolTipText("Route 23");
	    if (loc == 3) R23.setBackground(Color.yellow);
	    add(R23);
	    
	    JButton PG = new JButton("");
	    PG.setBounds(362, 236, 50, 45);
	    PG.setToolTipText("Poppy Grove");
	    if (locations[2]) {
	    	PG.setBackground(Color.red);
	    	PG.addActionListener(e -> {
	    		fly(PG.getToolTipText(), 4, 69, 72);
	    	});
	    }
	    if (loc == 4) PG.setBackground(Color.yellow);
	    add(PG);
	    
	    JButton R24_1 = new JButton("");
	    R24_1.setBounds(148, 242, 68, 13);
	    R24_1.setToolTipText("Route 24 pt. 1");
	    R24_1.setBackground(new Color(153, 255, 102));
	    if (loc == 5) R24_1.setBackground(Color.yellow);
	    add(R24_1);
	    
	    JButton R24_2 = new JButton("");
	    R24_2.setBounds(96, 254, 59, 12);
	    R24_2.setToolTipText("Route 24 pt. 2");
	    R24_2.setBackground(new Color(153, 255, 102));
	    if (loc == 6) R24_2.setBackground(Color.yellow);
	    add(R24_2);
	    
	    JGradientButton GF = new JGradientButton("");
	    GF.setBounds(44, 242, 52, 44);
	    GF.setBackground(new Color(0, 128, 0));
	    GF.setToolTipText("Gelb Forest");
	    if (loc == 7) GF.setBackground(Color.yellow);
	    add(GF);
	    
	    JButton R44 = new JButton("");
	    R44.setBounds(82, 285, 33, 13);
	    R44.setBackground(new Color(153, 255, 102));
	    R44.setToolTipText("Route 44");
	    if (loc == 41) R44.setBackground(Color.yellow);
	    add(R44);
	    
	    JGradientButton DeepChasm = new JGradientButton("");
	    DeepChasm.setBounds(115, 285, 26, 23);
	    DeepChasm.setBackground(Color.DARK_GRAY);
	    DeepChasm.setToolTipText("Deep Chasm");
	    if (loc == 42) DeepChasm.setBackground(Color.yellow);
	    add(DeepChasm);
	    
	    JButton R37 = new JButton("");
	    R37.setBounds(63, 286, 12, 49);
	    R37.setToolTipText("Route 37");
	    R37.setBackground(new Color(153, 255, 102));
	    if (loc == 34) R37.setBackground(Color.yellow);
	    add(R37);
	    
	    JButton RC = new JButton("");
	    RC.setBounds(44, 334, 50, 38);
	    RC.setToolTipText("Rawwar City");
	    if (locations[9]) {
	    	RC.setBackground(Color.red);
	    	RC.addActionListener(e -> {
	    		fly(RC.getToolTipText(), 124, 21, 57);
	    	});
	    }
	    if (loc == 35) RC.setBackground(Color.yellow);
	    add(RC);
	    
	    JButton IT = new JButton("");
	    IT.setBounds(51, 402, 33, 23);
	    IT.setToolTipText("Iron Town");
	    if (locations[10]) {
	    	IT.setBackground(Color.red);
	    	IT.addActionListener(e -> {
	    		fly(IT.getToolTipText(), 0, 35, 45); // TODO
	    	});
	    }
	    if (loc == 39) IT.setBackground(Color.yellow);
	    add(IT);
	    
	    JButton R39 = new JButton("");
	    R39.setBounds(63, 371, 10, 32);
	    R39.setToolTipText("Route 39");
	    R39.setBackground(new Color(153, 255, 102));
	    if (loc == 38) R39.setBackground(Color.yellow);
	    add(R39);
	    
	    JButton R25 = new JButton("");
	    R25.setBounds(63, 166, 12, 76);
	    R25.setBackground(new Color(153, 255, 102));
	    R25.setToolTipText("Route 25");
	    if (loc == 8) R25.setBackground(Color.yellow);
	    add(R25);
	    
	    JButton SC = new JButton("");
	    SC.setBounds(44, 129, 50, 38);
	    SC.setToolTipText("Sicab City");
	    if (locations[3]) {
	    	SC.setBackground(Color.red);
	    	SC.addActionListener(e -> {
	    		fly(SC.getToolTipText(), 13, 38, 86);
	    	});
	    }
	    if (loc == 9) SC.setBackground(Color.yellow);
	    add(SC);
	    
	    JButton R26 = new JButton("");
	    R26.setBounds(61, 64, 16, 66);
	    R26.setBackground(new Color(153, 255, 102));
	    R26.setToolTipText("Route 26");
	    if (loc == 10) R26.setBackground(Color.yellow);
	    add(R26);
	    
	    JGradientButton MtSpl = new JGradientButton("");
	    MtSpl.setBounds(166, 30, 50, 33);
	    MtSpl.setToolTipText("Mt. Splinkty");
	    MtSpl.setBackground(new Color(153, 102, 0));
	    if (loc == 11) MtSpl.setBackground(Color.yellow);
	    add(MtSpl);
	    
	    JButton R27 = new JButton("");
	    R27.setBounds(214, 37, 64, 16);
	    R27.setToolTipText("Route 27");
	    R27.setBackground(new Color(153, 255, 102));
	    if (loc == 12) R27.setBackground(Color.yellow);
	    add(R27);
	    
	    JGradientButton PP = new JGradientButton("");
	    PP.setBounds(240, 87, 110, 118);
	    PP.setBackground(new Color(0, 128, 0));
	    PP.setToolTipText("Peaceful Park");
	    if (loc == 15) PP.setBackground(Color.yellow);
	    if (locations[5]) {
	    	PP.addActionListener(e -> {
	    		fly(PP.getToolTipText(), 33, 32, 90);
	    	});
	    }
	    add(PP);
	    
	    JButton KV = new JButton("");
	    KV.setBounds(278, 30, 32, 30);
	    KV.setToolTipText("Kleine Village");
	    if (locations[4]) {
	    	KV.setBackground(Color.red);
	    	KV.addActionListener(e -> {
	    		fly(KV.getToolTipText(), 28, 76, 52);
	    	});
	    }
	    if (loc == 13) KV.setBackground(Color.yellow);
	    add(KV);
	    
	    JButton R41 = new JButton("");
	    R41.setBounds(286, 60, 12, 27);
	    R41.setToolTipText("Route 41");
	    R41.setBackground(new Color(153, 255, 102));
	    if (loc == 14) R41.setBackground(Color.yellow);
	    add(R41);
	    
	    JGradientButton ET = new JGradientButton("");
	    ET.setBounds(375, 30, 75, 30);
	    ET.setToolTipText("Electric Tunnel");
	    ET.setBackground(new Color(238, 232, 170));
	    if (loc == 18) ET.setBackground(Color.yellow);
	    add(ET);
	    
	    JButton R36_1 = new JButton("");
	    R36_1.setBounds(380, 191, 12, 45);
	    R36_1.setToolTipText("Route 36");
	    R36_1.setBackground(new Color(153, 255, 102));
	    if (loc == 16) R36_1.setBackground(Color.yellow);
	    add(R36_1);
	    
	    JButton R36_2 = new JButton("");
	    R36_2.setBounds(350, 178, 42, 14);
	    R36_2.setToolTipText("Route 36");
	    R36_2.setBackground(new Color(153, 255, 102));
	    if (loc == 16) R36_2.setBackground(Color.yellow);
	    add(R36_2);
	    
	    JButton R28 = new JButton("");
	    R28.setBounds(310, 38, 65, 15);
	    R28.setToolTipText("Route 28");
	    R28.setBackground(new Color(153, 255, 102));
	    if (loc == 17) R28.setBackground(Color.yellow);
	    add(R28);
	    
	    JButton R29 = new JButton("");
	    R29.setBounds(450, 38, 75, 15);
	    R29.setToolTipText("Route 29");
	    R29.setBackground(new Color(153, 255, 102));
	    if (loc == 19) R29.setBackground(Color.yellow);
	    add(R29);
	    
	    JGradientButton ML = new JGradientButton("");
	    ML.setBounds(437, 100, 228, 116);
	    ML.setBackground(new Color(0, 191, 255));
	    ML.setToolTipText("Mindagan Lake");
	    if (loc == 23) ML.setBackground(Color.yellow);
	    add(ML);
	    
	    JGradientButton SR = new JGradientButton("");
	    SR.setBounds(450, 249, 209, 56);
	    SR.setToolTipText("Shadow Ravine");
	    SR.setBackground(Color.DARK_GRAY);
	    if (loc == 25) SR.setBackground(Color.yellow);
	    add(SR);
	    
	    JButton SRC = new JButton("");
	    SRC.setBounds(525, 25, 65, 44);
	    SRC.setToolTipText("Schrice City");
	    if (locations[6]) {
	    	SRC.setBackground(Color.red);
	    	SRC.addActionListener(e -> {
	    		fly(SRC.getToolTipText(), 38, 49, 55);
	    	});
	    }
	    if (loc == 20) SRC.setBackground(Color.yellow);
	    add(SRC);
	    
	    JButton R30 = new JButton("");
	    R30.setBounds(550, 69, 14, 31);
	    R30.setToolTipText("Route 30");
	    R30.setBackground(new Color(153, 255, 102));
	    if (loc == 22) R30.setBackground(Color.yellow);
	    add(R30);
	    
	    JButton R31 = new JButton("");
	    R31.setBounds(550, 216, 14, 33);
	    R31.setToolTipText("Route 31");
	    R31.setBackground(new Color(153, 255, 102));
	    if (loc == 24) R31.setBackground(Color.yellow);
	    add(R31);
	    
	    JButton R42 = new JButton("");
	    R42.setBounds(550, 305, 13, 25);
	    R42.setToolTipText("Route 42");
	    R42.setBackground(new Color(153, 255, 102));
	    if (loc == 26) R42.setBackground(Color.yellow);
	    add(R42);
	    
	    JButton R35 = new JButton("");
	    R35.setBounds(590, 37, 75, 18);
	    R35.setToolTipText("Route 35");
	    R35.setBackground(new Color(153, 255, 102));
	    if (loc == 33) R35.setBackground(Color.yellow);
	    add(R35);
	    
	    JButton GT = new JButton("");
	    GT.setBounds(665, 30, 31, 30);
	    GT.setToolTipText("Glurg Town");
	    if (locations[7]) {
	    	GT.setBackground(Color.red);
	    	GT.addActionListener(e -> {
	    		fly(GT.getToolTipText(), 109, 34, 45);
	    	});
	    }
	    if (loc == 32) GT.setBackground(Color.yellow);
	    add(GT);
	    
	    JButton R34_1 = new JButton("");
	    R34_1.setBounds(696, 41, 54, 10);
	    R34_1.setToolTipText("Route 34");
	    R34_1.setBackground(new Color(153, 255, 102));
	    if (loc == 31) R34_1.setBackground(Color.yellow);
	    add(R34_1);
	    
	    JGradientButton GW = new JGradientButton("");
	    GW.setBounds(700, 107, 85, 75);
	    GW.setToolTipText("Ghostly Woods");
	    GW.setBackground(new Color(0, 128, 0));
	    if (loc == 30) GW.setBackground(Color.yellow);
	    add(GW);
	    
	    JButton R34_2 = new JButton("");
	    R34_2.setBounds(734, 51, 16, 56);
	    R34_2.setToolTipText("Route 34");
	    R34_2.setBackground(new Color(153, 255, 102));
	    if (loc == 31) R34_2.setBackground(Color.yellow);
	    add(R34_2);
	    
	    JButton R32 = new JButton("");
	    R32.setBounds(659, 264, 33, 18);
	    R32.setToolTipText("Route 32");
	    R32.setBackground(new Color(153, 255, 102));
	    if (loc == 27) R32.setBackground(Color.yellow);
	    add(R32);
	    
	    JButton FC = new JButton("");
	    FC.setBounds(692, 248, 68, 50);
	    FC.setToolTipText("Frenco City");
	    if (locations[8]) {
	    	FC.setBackground(Color.red);
	    	FC.addActionListener(e -> {
	    		fly(FC.getToolTipText(), 85, 43, 76);
	    	});
	    }
	    if (loc == 28) FC.setBackground(Color.yellow);
	    add(FC);
	    
	    JButton R33 = new JButton("");
	    R33.setBounds(734, 182, 16, 66);
	    R33.setToolTipText("Route 33");
	    R33.setBackground(new Color(153, 255, 102));
	    if (loc == 29) R33.setBackground(Color.yellow);
	    add(R33);
	    
	    JGradientButton AT = new JGradientButton("");
	    AT.setBounds(787, 64, 26, 23);
	    AT.setToolTipText("Abandoned Tower");
	    AT.setBackground(new Color(153, 102, 0));
	    if (loc == 44) AT.setBackground(Color.yellow);
	    add(AT);
	    
	    JButton ATP_1 = new JButton("");
	    ATP_1.setBounds(785, 129, 20, 10);
	    ATP_1.setBackground(new Color(153, 255, 102));
	    ATP_1.setToolTipText("A.T. Path");
	    if (loc == 43) ATP_1.setBackground(Color.yellow);
	    add(ATP_1);
	    
	    JButton ATP_2 = new JButton("");
	    ATP_2.setBounds(795, 87, 10, 42);
	    ATP_2.setToolTipText("A.T. Path");
	    ATP_2.setBackground(new Color(153, 255, 102));
	    if (loc == 43) ATP_2.setBackground(Color.yellow);
	    add(ATP_2);
	    
	    JButton CC = new JButton("");
	    CC.setBounds(753, 323, 68, 44);
	    CC.setToolTipText("Checkpoint Charlie");
	    if (locations[11]) CC.setBackground(Color.red);
	    if (loc == 46) CC.setBackground(Color.yellow);
	    add(CC);
	    
	    JButton R43 = new JButton("");
	    R43.setBounds(570, 338, 184, 15);
	    R43.setToolTipText("Route 43");
	    R43.setBackground(new Color(153, 255, 102));
	    if (loc == 45) R43.setBackground(Color.yellow);
	    add(R43);
	    
	    JGradientButton MtJ = new JGradientButton("");
	    MtJ.setBounds(204, 371, 81, 87);
	    MtJ.setToolTipText("Mt. St. Joseph");
	    MtJ.setBackground(new Color(153, 102, 0));
	    if (loc == 37) MtJ.setBackground(Color.yellow);
	    add(MtJ);
	    
	    JButton R38 = new JButton("");
	    R38.setBounds(93, 345, 32, 13);
	    R38.setToolTipText("Route 38");
	    R38.setBackground(new Color(153, 255, 102));
	    if (loc == 36) R38.setBackground(Color.yellow);
	    add(R38);
	    
	    JGradientButton LL = new JGradientButton("");
	    LL.setBounds(308, 390, 104, 87);
	    LL.setToolTipText("Lava Lake");
	    LL.setBackground(new Color(196, 39, 0));
	    if (loc == 40) LL.setBackground(Color.yellow);
	    add(LL);
	    
	    JButton R40 = new JButton("");
	    R40.setBounds(378, 363, 20, 27);
	    R40.setToolTipText("Route 40");
	    R40.setBackground(new Color(153, 255, 102));
	    if (loc == 21) R40.setBackground(Color.yellow);
	    add(R40);
	    
	    JButton btnNewButton = new JButton("");
	    btnNewButton.setBounds(514, 428, 75, 49);
	    btnNewButton.setBackground(Color.YELLOW);
	    add(btnNewButton);
	    
	    JLabel lblNewLabel = new JLabel("= YOU ARE HERE");
	    lblNewLabel.setBounds(592, 443, 174, 14);
	    if (loc == -1) lblNewLabel.setText("= YOU ARE ???");
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	    add(lblNewLabel);
	    
	    JButton closeButton = new JButton("Close");
	    closeButton.setBounds(781, 11, 70, 27);
	    closeButton.addActionListener(e -> {
	    	gp.removePanel();
			gp.mapOpen = false;
			gp.addGamePanel();
    	});
	    add(closeButton);
	}

	private void fly(String loc, int map, int x, int y) {
		if (!gp.tileM.canFly[gp.currentMap]) {
			JOptionPane.showMessageDialog(null, "Can't fly right now; you're indoors!");
			return;
		}
		int answer = JOptionPane.showOptionDialog(null,
				"Would you like to fly to " + loc + "?",
	            "Fly?",
	            JOptionPane.YES_NO_OPTION,
	            JOptionPane.QUESTION_MESSAGE,
	            null, null, null);
		if (answer == JOptionPane.YES_OPTION) {
			gp.eHandler.teleport(map, x, y, false);
			gp.player.p.surf = false;
			gp.player.p.lavasurf = false;
			for (Integer i : gp.tileM.getWaterTiles()) {
				gp.tileM.tile[i].collision = true;
			}
			for (Integer i : gp.tileM.getLavaTiles()) {
				gp.tileM.tile[i].collision = true;
			}
			gp.removePanel();
			gp.mapOpen = false;
			gp.addGamePanel();
		}
	}

	public static int getLoc(int map, int x, int y) {
		switch (map) {
		case 0:
			if (x > 73 && y > 37) {
				PlayerCharacter.currentMapName = "New Minnow Town";
				return 0;
			}
			if (x <= 73 && x > 41 && y > 36) {
				PlayerCharacter.currentMapName = "Route 22";
				return 1;
			}
			if (x <= 41 && y > 41) {
				PlayerCharacter.currentMapName = "Bananaville Town";
				return 2;
			}
			if (x <= 40 && y <= 41) {
				PlayerCharacter.currentMapName = "Route 23";
				return 3;
			}
			if (x > 40 && y <= 36) {
				PlayerCharacter.currentMapName = "Route 42";
				return 26;
			}
			break;
		case 1:
			PlayerCharacter.currentMapName = "Bananaville Town";
			return 2;
		case 2:
			PlayerCharacter.currentMapName = "Bananaville Town";
			return 2;
		case 3:
			PlayerCharacter.currentMapName = "Route 23";
			return 3;
		case 4:
			if (y <= 43) {
				PlayerCharacter.currentMapName = "Route 36";
				return 16;
			}
			if (x > 57) {
				PlayerCharacter.currentMapName = "Poppy Grove";
				return 4;
			}
			if (x <= 57) {
				PlayerCharacter.currentMapName = "Route 24 (pt. 1)";
				return 5;
			}
			break;
		case 5:
			PlayerCharacter.currentMapName = "Poppy Grove";
			return 4;
		case 6:
			PlayerCharacter.currentMapName = "Poppy Grove";
			return 4;
		case 7:
			PlayerCharacter.currentMapName = "Poppy Grove";
			return 4;
		case 8:
			PlayerCharacter.currentMapName = "Poppy Grove";
			return 4;
		case 9:
			PlayerCharacter.currentMapName = "Poppy Grove";
			return 4;
		case 10:
			PlayerCharacter.currentMapName = "Route 24 (pt. 2)";
			return 6;
		case 11:
			if (x > 43) {
				PlayerCharacter.currentMapName = "Route 24 (pt. 2)";
				return 6;
			}
			if (x <= 43) {
				if (y <= 52) {
					PlayerCharacter.currentMapName = "Route 25";
					return 8;
				}
				if (y > 52) {
					PlayerCharacter.currentMapName = "Gelb Forest (1A)";
					return 7;
				}
			}
		case 12:
			PlayerCharacter.currentMapName = "Route 25";
			return 8;
		case 13:
			if (y <= 52) {
				PlayerCharacter.currentMapName = "Route 26";
				return 10;
			}
			if (y > 52) {
				PlayerCharacter.currentMapName = "Sicab City";
				return 9;
			}
		case 14:
			PlayerCharacter.currentMapName = "Energy Plant (pt. 1)";
			return 9;
		case 15:
			PlayerCharacter.currentMapName = "Energy Plant (B1F)";
			return 9;
		case 16:
			PlayerCharacter.currentMapName = "Energy Plant (pt. 2)";
			return 9;
		case 17:
			PlayerCharacter.currentMapName = "Sicab Office (1A)";
			return 9;
		case 18:
			PlayerCharacter.currentMapName = "Sicab Office (2A)";
			return 9;
		case 19:
			PlayerCharacter.currentMapName = "Sicab City";
			return 9;
		case 20:
			PlayerCharacter.currentMapName = "Sicab City";
			return 9;
		case 21:
			PlayerCharacter.currentMapName = "Sicab City";
			return 9;
		case 22:
			if (y <= 18) {
				PlayerCharacter.currentMapName = "Route 40";
				return 21;
			}
			if (y > 18) {
				PlayerCharacter.currentMapName = "Lava Lake";
				return 40;
			}
		case 23:
			PlayerCharacter.currentMapName = "Route 40";
			return 21;
		case 24:
			PlayerCharacter.currentMapName = "Mt. Splinkty (1A)";
			return 11;
		case 25:
			PlayerCharacter.currentMapName = "Mt. Splinkty (2B)";
			return 11;
		case 26:
			PlayerCharacter.currentMapName = "Mt. Splinkty (3B)";
			return 11;
		case 27:
			PlayerCharacter.currentMapName = "Mt. Splinkty (3A)";
			return 11;
		case 28:
			if (y > 57) {
				PlayerCharacter.currentMapName = "Route 41";
				return 14;
			}
			if (x <= 61) {
				PlayerCharacter.currentMapName = "Route 27";
				return 12;
			}
			if (x > 61) {
				PlayerCharacter.currentMapName = "Kleine Village";
				return 13;
			}
		case 29:
			PlayerCharacter.currentMapName = "Kleine Village";
			return 13;
		case 30:
			PlayerCharacter.currentMapName = "Kleine Village";
			return 13;
		case 31:
			PlayerCharacter.currentMapName = "Kleine Village";
			return 13;
		case 32:
			PlayerCharacter.currentMapName = "Sicab City";
			return 9;
		case 33:
			if (y <= 22) {
				PlayerCharacter.currentMapName = "Route 28";
				return 17;
			}
			if (y > 22) {
				PlayerCharacter.currentMapName = "Peaceful Park";
				return 15;
			}
		case 34:
			PlayerCharacter.currentMapName = "Route 28";
			return 17;
		case 35:
			PlayerCharacter.currentMapName = "Electric Tunnel (1A)";
			return 18;
		case 36:
			PlayerCharacter.currentMapName = "Route 29";
			return 19;
		case 37:
			PlayerCharacter.currentMapName = "Route 29";
			return 19;
		case 38:
			if (y <= 63) {
				PlayerCharacter.currentMapName = y <= 30 ? "Icy Fields" : "Schrice City";
				return 20;
			}
			if (y > 63) {
				PlayerCharacter.currentMapName = "Route 30";
				return 22;
			}
		case 39:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 40:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 41:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 42:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 43:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 44:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 45:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 46:
			PlayerCharacter.currentMapName = "Poppy Grove";
			return 4;
		case 47:
			PlayerCharacter.currentMapName = "Bananaville Town";
			return 2;
		case 48:
			PlayerCharacter.currentMapName = "Poppy Grove";
			return 4;
		case 49:
			PlayerCharacter.currentMapName = "Kleine Village";
			return 13;
		case 50:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 51:
			PlayerCharacter.currentMapName = "New Minnow Town";
			return 0;
		case 52:
			PlayerCharacter.currentMapName = "New Minnow Town";
			return 0;
		case 53:
			PlayerCharacter.currentMapName = "Frenco City";
			return 0;
		case 54:
			PlayerCharacter.currentMapName = "New Minnow Town";
			return 0;
		case 55:
			PlayerCharacter.currentMapName = "Bananaville Town";
			return 2;
		case 56:
			PlayerCharacter.currentMapName = "Bananaville Town";
			return 2;
		case 57:
			PlayerCharacter.currentMapName = "Poppy Grove";
			return 4;
		case 58:
			PlayerCharacter.currentMapName = "Poppy Grove";
			return 4;
		case 59:
			PlayerCharacter.currentMapName = "Sicab City";
			return 9;
		case 60:
			PlayerCharacter.currentMapName = "Control Center";
			return 9;
		case 61:
			PlayerCharacter.currentMapName = "Kleine Village";
			return 13;
		case 62:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 63:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 64:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 65:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 66:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 67:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 68:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 69:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 70:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 71:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 72:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 73:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 74:
			PlayerCharacter.currentMapName = "Peaceful Park";
			return 15;
		case 75:
			PlayerCharacter.currentMapName = "Peaceful Park";
			return 15;
		case 76:
			PlayerCharacter.currentMapName = "Route 30";
			return 22;
		case 77:
			PlayerCharacter.currentMapName = "Mindagan Lake";
			return 23;
		case 78:
			PlayerCharacter.currentMapName = "Mindagan Cavern (1A)";
			return 23;
		case 79:
			PlayerCharacter.currentMapName = "Route 31";
			return 24;
		case 80:
			if (y <= 41) {
				PlayerCharacter.currentMapName = "Route 31";
				return 24;
			}
			if (y > 41) {
				PlayerCharacter.currentMapName = "Shadow Ravine (1A)";
				return 25;
			}
		case 81:
			PlayerCharacter.currentMapName = "Route 42";
			return 26;
		case 82:
			PlayerCharacter.currentMapName = "Shadow Ravine (1A)";
			return 25;
		case 83:
			if (x <= 56) {
				PlayerCharacter.currentMapName = "Shadow Ravine (1B)";
				return 25;
			}
			if (x > 56) {
				PlayerCharacter.currentMapName = "Route 32";
				return 27;
			}
		case 84:
			PlayerCharacter.currentMapName = "Route 32";
			return 27;
		case 85:
			if (x <= 63) {
				PlayerCharacter.currentMapName = "Frenco City";
				return 28;
			}
			if (x > 64) {
				PlayerCharacter.currentMapName = "Route 33";
				return 29;
			}
		case 86:
			PlayerCharacter.currentMapName = "Frenco City";
			return 28;
		case 87:
			PlayerCharacter.currentMapName = "Frenco City";
			return 28;
		case 88:
			PlayerCharacter.currentMapName = "Frenco City";
			return 28;
		case 89:
			PlayerCharacter.currentMapName = "Frenco City";
			return 28;
		case 90:
			PlayerCharacter.currentMapName = "Shadow Ravine (0A)";
			return 25;
		case 91:
			PlayerCharacter.currentMapName = "Frenco City";
			return 28;
		case 92:
			PlayerCharacter.currentMapName = "Peaceful Park";
			return 15;
		case 93:
			PlayerCharacter.currentMapName = "Frenco City";
			return 28;
		case 94:
			PlayerCharacter.currentMapName = "Frenco City";
			return 28;
		case 95:
			PlayerCharacter.currentMapName = "Electric Tunnel (0A)";
			return 18;
		case 96:
			PlayerCharacter.currentMapName = "Electric Tunnel (-1A)";
			return 18;
		case 97:
			PlayerCharacter.currentMapName = "Electric Tunnel (-2A)";
			return 18;
		case 98:
			PlayerCharacter.currentMapName = "Electric Tunnel (-3A)";
			return 18;
		case 99:
			PlayerCharacter.currentMapName = "Electric Tunnel (H)";
			return 18;
		case 100:
			PlayerCharacter.currentMapName = "Shadow Ravine (H)";
			return 25;
		case 101:
			PlayerCharacter.currentMapName = "Shadow Ravine (-1A)";
			return 25;
		case 102:
			PlayerCharacter.currentMapName = "Shadow Ravine (-2A)";
			return 25;
		case 103:
			PlayerCharacter.currentMapName = "Shadow Ravine (-3A)";
			return 25;
		case 104:
			PlayerCharacter.currentMapName = "Team Nuke Base";
			return -1;
		case 105:
			PlayerCharacter.currentMapName = "Shadow Path";
			return -1;
		case 106:
			PlayerCharacter.currentMapName = "Ghostly Woods";
			return 30;
		case 107:
			PlayerCharacter.currentMapName = "Ghostly Woods";
			return 30;
		case 108:
			PlayerCharacter.currentMapName = "Route 34 (1A)";
			return 31;
		case 109:
			if (x > 55) {
				PlayerCharacter.currentMapName = "Route 34 (1A)";
				return 31;
			}
			if (x <= 55) {
				PlayerCharacter.currentMapName = "Glurg Town";
				return 32;
			}
		case 110:
			PlayerCharacter.currentMapName = "Route 34 (0A)";
			return 31;
		case 111:
			PlayerCharacter.currentMapName = "Glurg Town";
			return 32;
		case 112:
			PlayerCharacter.currentMapName = "Glurg Town";
			return 32;
		case 113:
			PlayerCharacter.currentMapName = "Glurg Town";
			return 32;
		case 114:
			PlayerCharacter.currentMapName = "Route 35";
			return 33;
		case 115:
			PlayerCharacter.currentMapName = "Route 35";
			return 33;
		case 116:
			PlayerCharacter.currentMapName = "Schrice City";
			return 20;
		case 117:
			PlayerCharacter.currentMapName = "Mindagan Cavern (0A)";
			return 23;
		case 118:
			PlayerCharacter.currentMapName = "Glurg Town";
			return 32;
		case 119: 
			PlayerCharacter.currentMapName = "Route 43";
			return 45;
		case 120:
			PlayerCharacter.currentMapName = "New Minnow Town";
			return 0;
		case 121:
			PlayerCharacter.currentMapName = "Sicab City";
			return 9;
		case 122:
			PlayerCharacter.currentMapName = "Sicab City";
			return 9;
		case 123:
			PlayerCharacter.currentMapName = "Gelb Forest (1A)";
			return 7;
		case 124:
			if (y <= 49) {
				PlayerCharacter.currentMapName = "Route 37";
				return 34;
			}
			if (x <= 47) {
				PlayerCharacter.currentMapName = "Rawwar City";
				return 35;
			}
			if (x > 47) {
				PlayerCharacter.currentMapName = "Route 38";
				return 36;
			}
		case 125:
			PlayerCharacter.currentMapName = "Rawwar City";
			return 35;
		case 126:
			PlayerCharacter.currentMapName = "Rawwar City";
			return 35;
		case 127:
			PlayerCharacter.currentMapName = "Rawwar City";
			return 35;
		case 128:
			PlayerCharacter.currentMapName = "Rawwar City";
			return 35;
		case 129:
			PlayerCharacter.currentMapName = "Rawwar City";
			return 35;
		case 130:
			PlayerCharacter.currentMapName = "Rawwar City";
			return 35;
		case 131:
			PlayerCharacter.currentMapName = "Rawwar City";
			return 35;
		case 132:
			PlayerCharacter.currentMapName = "Rawwar City";
			return 35;
		case 133:
			PlayerCharacter.currentMapName = "Rawwar City";
			return 35;
		case 134:
			PlayerCharacter.currentMapName = "Rawwar City";
			return 35;
		case 135:
			PlayerCharacter.currentMapName = "Rawwar City";
			return 35;
		case 136:
			PlayerCharacter.currentMapName = "Rawwar City";
			return 35;
		case 137:
			PlayerCharacter.currentMapName = "Mt. St. Joseph (1A)";
			return 37;
		case 138:
			PlayerCharacter.currentMapName = "Mt. St. Joseph (2A)";
			return 37;
		case 139:
			PlayerCharacter.currentMapName = "Mt. St. Joseph (2B)";
			return 37;
		case 140:
			PlayerCharacter.currentMapName = "Mt. St. Joseph (3A)";
			return 37;
		case 141:
			PlayerCharacter.currentMapName = "Mt. St. Joseph (3B)";
			return 37;
		case 142:
			PlayerCharacter.currentMapName = "Mt. St. Joseph (4A)";
			return 37;
		case 143:
			PlayerCharacter.currentMapName = "Mt. St. Joseph (4B)";
			return 37;
		case 144:
			if (x <= 32) {
				PlayerCharacter.currentMapName = "Gelb Forest (2A)";
				return 7;
			}
			if (x > 32) {
				PlayerCharacter.currentMapName = "Route 44";
				return 41;
			}
		case 145:
			PlayerCharacter.currentMapName = "Mt. Splinkty (2A)";
			return 11;
		case 146:
			PlayerCharacter.currentMapName = "Mt. Splinkty (Outside)";
			return 11;
		case 147:
			PlayerCharacter.currentMapName = "Mt. Splinkty (H)";
			return 11;
		case 148:
			PlayerCharacter.currentMapName = "Mt. Splinkty (4A)";
			return 11;
		case 149:
			PlayerCharacter.currentMapName = "Mt. Splinkty (5A)";
			return 11;
		case 150:
			PlayerCharacter.currentMapName = "Shadow Cavern";
			return -1;
		case 151: // TODO from here down
			PlayerCharacter.currentMapName = "";
			return 15;
		case 152:
			PlayerCharacter.currentMapName = "";
			return 20;
		case 153:
			PlayerCharacter.currentMapName = "";
			return 20;
		case 154:
			PlayerCharacter.currentMapName = "";
			return 20;
		case 155:
			PlayerCharacter.currentMapName = "";
			return 4;
		case 156:
			PlayerCharacter.currentMapName = "";
			return 20;
		case 157:
			PlayerCharacter.currentMapName = "";
			return 20;
		case 158:
			PlayerCharacter.currentMapName = "";
			return 20;
		case 159:
			PlayerCharacter.currentMapName = "";
			return 20;
		case 160:
			PlayerCharacter.currentMapName = "";
			return 28;
		case 161:
			PlayerCharacter.currentMapName = "";
			return 15;
		case 162:
			PlayerCharacter.currentMapName = "";
			return 20;
		case 163:
			PlayerCharacter.currentMapName = "";
			return 20;
		case 164:
			PlayerCharacter.currentMapName = "";
			return 20;
		case 165:
			PlayerCharacter.currentMapName = "";
			return 4;
		case 166:
			PlayerCharacter.currentMapName = "";
			return 20;
		case 167:
			PlayerCharacter.currentMapName = "";
			return 20;
		case 168:
			PlayerCharacter.currentMapName = "";
			return 20;
		case 169:
			PlayerCharacter.currentMapName = "";
			return 20;
		}
		
		return -1;
	}
}
