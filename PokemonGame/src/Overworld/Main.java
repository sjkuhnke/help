package Overworld;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Swing.Player;
import Swing.Pokemon;
import Swing.Trainer;
import Swing.Ability;
import Swing.Battle.JGradientButton;
import Swing.Item;
import Swing.Move;

public class Main {
	public static Trainer[] trainers;

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Pokemon Game");
		
		setTrainers();
		
		GamePanel gamePanel = new GamePanel();
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("player.dat"))) {
	        gamePanel.player.p = (Player) ois.readObject();
	        for (Pokemon p : gamePanel.player.p.team) {
	            if (p != null) p.clearVolatile();
	        }
	        gamePanel.player.worldX = gamePanel.player.p.getPosX();
	        gamePanel.player.worldY = gamePanel.player.p.getPosY();
	        gamePanel.currentMap = gamePanel.player.p.currentMap;
	        ois.close();
	    } catch (IOException | ClassNotFoundException e) {
	        // If there's an error reading the file, create a new Player object
	        gamePanel.player.p = new Player(gamePanel);

	        String[] options = {"Twigle", "Lagma", "Lizish"};
	        JPanel optionPanel = new JPanel(new GridLayout(1, options.length));

	        int index = 0;
	        for (int i = 1; i < 8; i += 3) {
	            Pokemon dummy = new Pokemon(i, 1, false, false);
	            JGradientButton optionButton = new JGradientButton(options[index]);
	            ImageIcon spriteIcon = new ImageIcon(dummy.getSprite(i));
	            optionButton.setIcon(spriteIcon);
	            optionButton.setBackground(dummy.type1.getColor());

	            // Add an ActionListener to the button to handle user selection
	            int finalChoice = index + 1; // To make the variable effectively final
	            optionButton.addActionListener(f -> {
	                // Record the selected choice and close the JOptionPane
	                gamePanel.player.p.starter = finalChoice;
	                JComponent component = (JComponent) f.getSource();
	                SwingUtilities.getWindowAncestor(component).dispose();
	            });

	            optionPanel.add(optionButton);
	            index++;
	        }

	        // Show the JOptionPane with the custom option panel
	        JOptionPane.showOptionDialog(
	            null, 
	            optionPanel, 
	            "Choose your starter Pokemon", 
	            JOptionPane.DEFAULT_OPTION, 
	            JOptionPane.QUESTION_MESSAGE, 
	            null, 
	            null, 
	            null
	        );

	        // Add the chosen starter to the player's team
	        if (gamePanel.player.p.starter <= 0) gamePanel.player.p.starter = (int)(Math.random() * options.length) + 1;
	        if (gamePanel.player.p.starter == 1) {
	            gamePanel.player.p.catchPokemon(new Pokemon(1, 5, true, false));
	        } else if (gamePanel.player.p.starter == 2) {
	            gamePanel.player.p.catchPokemon(new Pokemon(4, 5, true, false));
	        } else if (gamePanel.player.p.starter == 3) {
	            gamePanel.player.p.catchPokemon(new Pokemon(7, 5, true, false));
	        }
	        
	        //gamePanel.player.p.bag.add(new Item(22), 999);
	    }
		
		modifyTrainers(gamePanel);
		
		gamePanel.setupGame();
		
		window.add(gamePanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.startGameThread();
		
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		window.addWindowListener(new WindowAdapter() {
            @Override // implementation
            public void windowClosing(WindowEvent e) {
            	int option = JOptionPane.showConfirmDialog(window, "Are you sure you want to exit?\nAny unsaved progress will be lost!", "Confirm Exit", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    // Close the application
                    System.exit(0);
                }
            }
        });
		
		gamePanel.eHandler.p = gamePanel.player.p;
	}
	
	private static void modifyTrainers(GamePanel gp) {
		if (gp.player.p.starter == 1) {
			trainers[0] = new Trainer("Scott 1", new Pokemon[]{new Pokemon(7, 7, false, true)}, 400, 1);
			trainers[34] = new Trainer("Fred 1", new Pokemon[]{new Pokemon(78, 18, false, true), new Pokemon(5, 20, false, true)}, 400);
			trainers[55] = new Trainer("Scott 2", new Pokemon[]{new Pokemon(130, 21, false, true), new Pokemon(8, 22, false, true), new Pokemon(166, 22, false, true)}, 400, new Item(94), 4);
			trainers[89] = new Trainer("Fred 2", new Pokemon[]{new Pokemon(98, 29, false, true), new Pokemon(210, 30, false, true), new Pokemon(5, 30, false, true), new Pokemon(79, 31, false, true)}, 400, 5);
		}
		else if (gp.player.p.starter == 2) {
			trainers[0] = new Trainer("Scott 1", new Pokemon[]{new Pokemon(1, 7, false, true)}, 400, 1);
			trainers[34] = new Trainer("Fred 1", new Pokemon[]{new Pokemon(78, 18, false, true), new Pokemon(8, 20, false, true)}, 400);
			trainers[55] = new Trainer("Scott 2", new Pokemon[]{new Pokemon(130, 21, false, true), new Pokemon(2, 22, false, true), new Pokemon(166, 22, false, true)}, 400, new Item(94), 4);
			trainers[89] = new Trainer("Fred 2", new Pokemon[]{new Pokemon(98, 29, false, true), new Pokemon(210, 30, false, true), new Pokemon(8, 30, false, true), new Pokemon(79, 31, false, true)}, 400, 5);
		}
		else if (gp.player.p.starter == 3) {
			trainers[0] = new Trainer("Scott 1", new Pokemon[]{new Pokemon(4, 7, false, true)}, 400, 1);
			trainers[34] = new Trainer("Fred 1", new Pokemon[]{new Pokemon(78, 18, false, true), new Pokemon(2, 20, false, true)}, 400);
			trainers[55] = new Trainer("Scott 2", new Pokemon[]{new Pokemon(130, 21, false, true), new Pokemon(5, 22, false, true), new Pokemon(166, 22, false, true)}, 400, new Item(94), 4);
			trainers[89] = new Trainer("Fred 2", new Pokemon[]{new Pokemon(98, 29, false, true), new Pokemon(210, 30, false, true), new Pokemon(2, 30, false, true), new Pokemon(79, 31, false, true)}, 400, 5);
		}
		
		trainers[17].getTeam()[2].moveset = new Move[]{Move.MEGA_DRAIN, Move.SUPERSONIC, Move.AERIAL_ACE, Move.MEAN_LOOK};
		trainers[17].getTeam()[3].moveset = new Move[]{Move.SAND_ATTACK, Move.LEER, Move.AERIAL_ACE, Move.QUICK_ATTACK};
		
		trainers[66].getTeam()[0].moveset = new Move[]{Move.SUPER_FANG, Move.BITE, Move.HEADBUTT, Move.BULK_UP};
		trainers[66].getTeam()[2].moveset = new Move[]{Move.SUPER_FANG, Move.METAL_CLAW, Move.FLAME_WHEEL, Move.BODY_SLAM};
		
		trainers[94].getTeam()[0].moveset = new Move[]{Move.FELL_STINGER, Move.AQUA_TAIL, Move.IRON_TAIL, Move.STEALTH_ROCK};
		trainers[94].getTeam()[0].ability = Ability.COMPOUND_EYES;
		trainers[94].getTeam()[1].moveset = new Move[]{Move.STICKY_WEB, Move.THUNDERBOLT, Move.BUG_BUZZ, Move.THUNDER_WAVE};
		trainers[94].getTeam()[2].moveset = new Move[]{Move.LEAF_BLADE, Move.X_SCISSOR, Move.FELL_STINGER, Move.SWORDS_DANCE};
		trainers[94].getTeam()[3].moveset = new Move[]{Move.FIRST_IMPRESSION, Move.FELL_STINGER, Move.SACRED_SWORD, Move.MACHETE_JAB};
		trainers[94].getTeam()[4].moveset = new Move[]{Move.BUG_BITE, Move.MOONLIGHT, Move.FEINT_ATTACK, Move.FELL_STINGER};
		trainers[94].getTeam()[5].moveset = new Move[]{Move.AURORA_BEAM, Move.BUG_BUZZ, Move.SNOWSCAPE, Move.QUIVER_DANCE};
		
	}

	private static void setTrainers() {
		trainers = new Trainer[]{
				new Trainer("Scott 1", new Pokemon[]{new Pokemon(1, 100, false, true)}, 400),
				new Trainer("A", new Pokemon[]{new Pokemon(16, 4, false, true)}, 100),
				new Trainer("B", new Pokemon[]{new Pokemon(13, 3, false, true)}, 100),
				new Trainer("C", new Pokemon[]{new Pokemon(32, 4, false, true), new Pokemon(29, 4, false, true)}, 100),
				new Trainer("D", new Pokemon[]{new Pokemon(22, 2, false, true), new Pokemon(22, 2, false, true), new Pokemon(22, 2, false, true)}, 100),
				new Trainer("TN 1", new Pokemon[]{new Pokemon(22, 9, false, true)}, 100), // 5
				new Trainer("TN 2", new Pokemon[]{new Pokemon(22, 9, false, true)}, 100),
				new Trainer("TN 3", new Pokemon[]{new Pokemon(29, 10, false, true)}, 100),
				new Trainer("TN 4", new Pokemon[]{new Pokemon(59, 11, false, true)}, 100),
				new Trainer("TN 5", new Pokemon[]{new Pokemon(41, 10, false, true)}, 100),
				new Trainer("TN 6", new Pokemon[]{new Pokemon(73, 10, false, true)}, 100), // 10
				new Trainer("TN 7", new Pokemon[]{new Pokemon(90, 10, false, true)}, 100),
				new Trainer("TN 8", new Pokemon[]{new Pokemon(52, 12, false, true)}, 100),
				new Trainer("Rick 1", new Pokemon[]{new Pokemon(66, 11, false, true), new Pokemon(111, 12, false, true), new Pokemon(44, 13, false, true), new Pokemon(120, 10, false, true)}, 400, new Item(93), 2),
				new Trainer("1 Gym A", new Pokemon[]{new Pokemon(13, 11, false, true), new Pokemon(13, 12, false, true), new Pokemon(13, 13, false, true)}, 200),
				new Trainer("1 Gym B", new Pokemon[]{new Pokemon(10, 12, false, true), new Pokemon(10, 13, false, true)}, 200), // 15
				new Trainer("1 Gym C", new Pokemon[]{new Pokemon(13, 13, false, true), new Pokemon(10, 14, false, true)}, 200),
				new Trainer("1 Gym Leader 1", new Pokemon[]{new Pokemon(13, 15, false, true), new Pokemon(10, 16, false, true), new Pokemon(153, 15, false, true), new Pokemon(14, 17, false, true),}, 500, new Item(152)),
				new Trainer("E", new Pokemon[]{new Pokemon(19, 13, false, true)}, 100),
				new Trainer("F", new Pokemon[]{new Pokemon(32, 8, false, true), new Pokemon(32, 9, false, true)}, 100),
				new Trainer("G", new Pokemon[]{new Pokemon(13, 10, false, true)}, 100), // 20
				new Trainer("H", new Pokemon[]{new Pokemon(26, 10, false, true)}, 100),
				new Trainer("I", new Pokemon[]{new Pokemon(47, 10, false, true), new Pokemon(55, 11, false, true)}, 100),
				new Trainer("J", new Pokemon[]{new Pokemon(85, 14, false, true), new Pokemon(10, 14, false, true)}, 100),
				new Trainer("K", new Pokemon[]{new Pokemon(38, 18, false, true)}, 100),
				new Trainer("L", new Pokemon[]{new Pokemon(19, 18, false, true)}, 100), // 25
				new Trainer("M", new Pokemon[]{new Pokemon(141, 18, false, true)}, 100),
				new Trainer("N", new Pokemon[]{new Pokemon(42, 18, false, true)}, 100),
				new Trainer("O1", new Pokemon[]{new Pokemon(143, 18, false, true)}, 100),
				new Trainer("O2", new Pokemon[]{new Pokemon(137, 19, false, true)}, 100),
				new Trainer("P", new Pokemon[]{new Pokemon(26, 18, false, true)}, 100), // 30
				new Trainer("Q", new Pokemon[]{new Pokemon(90, 17, false, true), new Pokemon(82, 19, false, true)}, 100),
				new Trainer("R", new Pokemon[]{new Pokemon(64, 19, false, true)}, 100),
				new Trainer("S", new Pokemon[]{new Pokemon(137, 16, false, true), new Pokemon(137, 16, false, true), new Pokemon(137, 16, false, true), new Pokemon(71, 19, false, true)}, 100),
				new Trainer("Fred 1", new Pokemon[]{new Pokemon(1, 7, false, true)}, 400),
				new Trainer("T", new Pokemon[]{new Pokemon(42, 16, false, true), new Pokemon(52, 17, false, true)}, 100), // 35
				new Trainer("U1", new Pokemon[]{new Pokemon(104, 15, false, true), new Pokemon(94, 15, false, true)}, 100),
				new Trainer("U2", new Pokemon[]{new Pokemon(106, 15, false, true), new Pokemon(94, 15, false, true)}, 100),
				new Trainer("V", new Pokemon[]{new Pokemon(85, 17, false, true), new Pokemon(82, 16, false, true), new Pokemon(80, 17, false, true), new Pokemon(75, 18, false, true)}, 100),
				new Trainer("W", new Pokemon[]{new Pokemon(138, 20, false, true)}, 100),
				new Trainer("EP-AA", new Pokemon[]{new Pokemon(90, 22, false, true)}, 100), // 40
				new Trainer("EP-AB", new Pokemon[]{new Pokemon(36, 21, false, true), new Pokemon(82, 21, false, true), new Pokemon(80, 21, false, true)}, 100),
				new Trainer("EP-AC", new Pokemon[]{new Pokemon(114, 20, false, true)}, 100),
				new Trainer("EP-AD", new Pokemon[]{new Pokemon(181, 22, false, true)}, 100),
				new Trainer("EP-AE", new Pokemon[]{new Pokemon(126, 21, false, true), new Pokemon(123, 22, false, true), new Pokemon(120, 21, false, true)}, 100),
				new Trainer("EP-BA", new Pokemon[]{new Pokemon(138, 21, false, true), new Pokemon(138, 21, false, true)}, 100), // 45
				new Trainer("EP-BB", new Pokemon[]{new Pokemon(148, 22, false, true)}, 100),
				new Trainer("EP-BC", new Pokemon[]{new Pokemon(140, 22, false, true)}, 100),
				new Trainer("EP-BD", new Pokemon[]{new Pokemon(144, 21, false, true)}, 100),
				new Trainer("TN O1", new Pokemon[]{new Pokemon(23, 19, false, true)}, 100),
				new Trainer("TN O2", new Pokemon[]{new Pokemon(73, 19, false, true)}, 100), // 50
				new Trainer("TN O3", new Pokemon[]{new Pokemon(95, 19, false, true)}, 100),
				new Trainer("TN O4", new Pokemon[]{new Pokemon(104, 19, false, true)}, 100),
				new Trainer("TN O5", new Pokemon[]{new Pokemon(52, 20, false, true), new Pokemon(141, 20, false, true)}, 100),
				new Trainer("TN O6", new Pokemon[]{new Pokemon(90, 20, false, true), new Pokemon(144, 20, false, true)}, 100, 3),
				new Trainer("Scott 2", new Pokemon[]{new Pokemon(10, 5, false, true)}, 100), // 55
				new Trainer("2 Gym A", new Pokemon[]{new Pokemon(16, 22, false, true)}, 200),
				new Trainer("2 Gym B", new Pokemon[]{new Pokemon(16, 22, false, true)}, 200),
				new Trainer("2 Gym C", new Pokemon[]{new Pokemon(14, 19, false, true), new Pokemon(14, 20, false, true)}, 200),
				new Trainer("2 Gym D", new Pokemon[]{new Pokemon(14, 19, false, true), new Pokemon(14, 20, false, true)}, 200),
				new Trainer("2 Gym E", new Pokemon[]{new Pokemon(20, 21, false, true)}, 200), // 60
				new Trainer("2 Gym F", new Pokemon[]{new Pokemon(20, 21, false, true)}, 200),
				new Trainer("2 Gym G", new Pokemon[]{new Pokemon(19, 23, false, true), new Pokemon(19, 23, false, true)}, 200),
				new Trainer("2 Gym H", new Pokemon[]{new Pokemon(19, 23, false, true), new Pokemon(19, 23, false, true)}, 200),
				new Trainer("2 Gym I", new Pokemon[]{new Pokemon(16, 22, false, true)}, 200),
				new Trainer("2 Gym J", new Pokemon[]{new Pokemon(14, 22, false, true)}, 200), // 65
				new Trainer("2 Gym Leader 1", new Pokemon[]{new Pokemon(16, 24, false, true), new Pokemon(126, 23, false, true), new Pokemon(92, 24, false, true), new Pokemon(89, 24, false, true), new Pokemon(20, 25, false, true)}, 500, new Item(101)),
				new Trainer("SA", new Pokemon[]{new Pokemon(151, 8, false, true)}, 100),
				new Trainer("SB", new Pokemon[]{new Pokemon(44, 9, false, true)}, 100),
				new Trainer("SC", new Pokemon[]{new Pokemon(35, 9, false, true)}, 100),
				new Trainer("SD", new Pokemon[]{new Pokemon(153, 8, false, true)}, 100), // 70
				new Trainer("X", new Pokemon[]{new Pokemon(132, 24, false, true), new Pokemon(102, 25, false, true)}, 100),
				new Trainer("Y", new Pokemon[]{new Pokemon(11, 24, false, true), new Pokemon(134, 27, false, true)}, 100),
				new Trainer("Z", new Pokemon[]{new Pokemon(105, 27, false, true)}, 100),
				new Trainer("AA", new Pokemon[]{new Pokemon(131, 29, false, true)}, 100),
				new Trainer("MS A", new Pokemon[]{new Pokemon(61, 30, false, true)}, 100), // 75
				new Trainer("MS B", new Pokemon[]{new Pokemon(92, 31, false, true)}, 100),
				new Trainer("MS C", new Pokemon[]{new Pokemon(115, 30, false, true)}, 100),
				new Trainer("MS D", new Pokemon[]{new Pokemon(155, 51, false, true), new Pokemon(161, 53, false, true)}, 100),
				new Trainer("TN MS 1", new Pokemon[]{new Pokemon(53, 30, false, true)}, 100, new Item(95)),
				new Trainer("AB", new Pokemon[]{new Pokemon(86, 28, false, true), new Pokemon(82, 30, false, true), new Pokemon(86, 29, false, true), new Pokemon(75, 30, false, true), new Pokemon(79, 30, false, true)}, 100), // 80
				new Trainer("AC", new Pokemon[]{new Pokemon(49, 30, false, true), new Pokemon(53, 31, false, true)}, 100),
				new Trainer("AD", new Pokemon[]{new Pokemon(98, 30, false, true), new Pokemon(102, 31, false, true), new Pokemon(105, 31, false, true)}, 100),
				new Trainer("AE", new Pokemon[]{new Pokemon(96, 37, false, true)}, 100),
				new Trainer("AF", new Pokemon[]{new Pokemon(110, 38, false, true)}, 100),
				new Trainer("AG", new Pokemon[]{new Pokemon(74, 29, false, true), new Pokemon(91, 30, false, true)}, 100), // 85
				new Trainer("AH", new Pokemon[]{new Pokemon(97, 30, false, true)}, 100),
				new Trainer("AI", new Pokemon[]{new Pokemon(89, 30, false, true), new Pokemon(47, 31, false, true)}, 100),
				new Trainer("AJ", new Pokemon[]{new Pokemon(46, 30, false, true), new Pokemon(27, 31, false, true)}, 100),
				new Trainer("Fred 2", new Pokemon[]{new Pokemon(10, 18, false, true)}, 500),
				new Trainer("3 Gym A", new Pokemon[]{new Pokemon(33, 29, false, true), new Pokemon(73, 29, false, true), new Pokemon(33, 30, false, true), new Pokemon(34, 31, false, true)}, 200), // 90
				new Trainer("3 Gym B", new Pokemon[]{new Pokemon(23, 30, false, true), new Pokemon(36, 31, false, true), new Pokemon(43, 32, false, true)}, 200),
				new Trainer("3 Gym C", new Pokemon[]{new Pokemon(62, 31, false, true), new Pokemon(63, 31, false, true)}, 200),
				new Trainer("3 Gym D", new Pokemon[]{new Pokemon(24, 31, false, true), new Pokemon(25, 31, false, true)}, 200),
				new Trainer("3 Gym Leader 1", new Pokemon[]{new Pokemon(25, 31, false, true), new Pokemon(37, 32, false, true), new Pokemon(34, 32, false, true), new Pokemon(43, 32, false, true), new Pokemon(74, 32, false, true), new Pokemon(63, 33, false, true)}, 500),
				new Trainer("RR A", new Pokemon[]{new Pokemon(71, 30, false, true), new Pokemon(68, 31, false, true)}, 100), // 95
				new Trainer("RR B", new Pokemon[]{new Pokemon(27, 30, false, true), new Pokemon(30, 31, false, true)}, 100),
				new Trainer("RR C", new Pokemon[]{new Pokemon(108, 30, false, true), new Pokemon(107, 31, false, true)}, 100),
				new Trainer("CR", new Pokemon[]{new Pokemon(86, 18, false, true), new Pokemon(45, 19, false, true)}, 100),
				new Trainer("CS", new Pokemon[]{new Pokemon(36, 20, false, true)}, 100),
				new Trainer("CT", new Pokemon[]{new Pokemon(68, 20, false, true)}, 100), // 100
				new Trainer("CU", new Pokemon[]{new Pokemon(42, 20, false, true)}, 100),
//				new Trainer("Rival 3", new Pokemon[]{new Pokemon(-131, 25, false, true), new Pokemon(-24, 16, false, true), new Pokemon(-21, 19, false, true)}, 500),
//				new Trainer("4 Gym A", new Pokemon[]{new Pokemon(-46, 15, false, true), new Pokemon(-44, 20, false, true)}, 200),
//				new Trainer("4 Gym Leader 1", new Pokemon[]{new Pokemon(-43, 16, false, true), new Pokemon(-46, 17, false, true), new Pokemon(-46, 24, false, true), new Pokemon(-44, 21, false, true)}, 500),
//				new Trainer("Q", new Pokemon[]{new Pokemon(-50, 25, false, true)}, 100),
//				new Trainer("5 Gym A", new Pokemon[]{new Pokemon(-63, 14, false, true), new Pokemon(-63, 16, false, true), new Pokemon(-63, 18, false, true)}, 200),
//				new Trainer("5 Gym B", new Pokemon[]{new Pokemon(-66, 27, false, true)}, 200),
//				new Trainer("5 Gym C", new Pokemon[]{new Pokemon(-24, 18, false, true), new Pokemon(-25, 21, false, true)}, 200),
//				new Trainer("5 Gym D", new Pokemon[]{new Pokemon(-69, 21, false, true)}, 200),
//				new Trainer("5 Gym E", new Pokemon[]{new Pokemon(-70, 22, false, true)}, 200),
//				new Trainer("5 Gym Leader 1", new Pokemon[]{new Pokemon(-65, 20, false, true), new Pokemon(-66, 30, false, true), new Pokemon(-69, 28, false, true), new Pokemon(-64, 25, false, true)}, 500),
//				new Trainer("R", new Pokemon[]{new Pokemon(-106, 24, false, true)}, 100),
//				new Trainer("S", new Pokemon[]{new Pokemon(-92, 20, false, true), new Pokemon(-92, 20, false, true), new Pokemon(-46, 15, false, true)}, 100),
//				new Trainer("T", new Pokemon[]{new Pokemon(-75, 18, false, true), new Pokemon(-77, 23, false, true)}, 100),
//				new Trainer("U", new Pokemon[]{new Pokemon(-84, 24, false, true)}, 100),
//				new Trainer("V", new Pokemon[]{new Pokemon(-86, 25, false, true)}, 100),
//				new Trainer("W", new Pokemon[]{new Pokemon(-61, 23, false, true), new Pokemon(-55, 23, false, true)}, 100),
//				new Trainer("X", new Pokemon[]{new Pokemon(-8, 24, false, true), new Pokemon(-80, 25, false, true)}, 100),
//				new Trainer("6 Gym A", new Pokemon[]{new Pokemon(-90, 32, false, true)}, 200),
//				new Trainer("6 Gym B", new Pokemon[]{new Pokemon(-87, 30, false, true)}, 200),
//				new Trainer("6 Gym C", new Pokemon[]{new Pokemon(-89, 24, false, true), new Pokemon(-89, 24, false, true)}, 200),
//				new Trainer("6 Gym D", new Pokemon[]{new Pokemon(-86, 24, false, true), new Pokemon(-86, 27, false, true)}, 200),
//				new Trainer("6 Gym E", new Pokemon[]{new Pokemon(-69, 29, false, true)}, 200),
//				new Trainer("6 Gym F", new Pokemon[]{new Pokemon(-90, 31, false, true)}, 200),
//				new Trainer("6 Gym Leader 1", new Pokemon[]{new Pokemon(-89, 29, false, true), new Pokemon(-90, 34, false, true), new Pokemon(-87, 36, false, true)}, 500),
//				new Trainer("Y", new Pokemon[]{new Pokemon(-93, 24, false, true), new Pokemon(-89, 23, false, true)}, 100),
//				new Trainer("Z", new Pokemon[]{new Pokemon(-75, 26, false, true)}, 100),
//				new Trainer("AA", new Pokemon[]{new Pokemon(-97, 19, false, true), new Pokemon(-98, 26, false, true)}, 100),
//				new Trainer("BB", new Pokemon[]{new Pokemon(-41, 26, false, true)}, 100),
//				new Trainer("CC", new Pokemon[]{new Pokemon(-46, 25, false, true), new Pokemon(-47, 31, false, true)}, 100),
//				new Trainer("CA", new Pokemon[]{new Pokemon(-18, 10, false, true), new Pokemon(-21, 10, false, true)}, 100),
//				new Trainer("CB", new Pokemon[]{new Pokemon(-18, 21, false, true), new Pokemon(-19, 26, false, true), new Pokemon(-19, 28, false, true)}, 100),
//				new Trainer("CD", new Pokemon[]{new Pokemon(-38, 21, false, true), new Pokemon(-40, 21, false, true)}, 100),
//				new Trainer("CE", new Pokemon[]{new Pokemon(-33, 20, false, true), new Pokemon(-33, 20, false, true), new Pokemon(-34, 25, false, true)}, 100),
//				new Trainer("DD", new Pokemon[]{new Pokemon(-80, 10, false, true), new Pokemon(-74, 8, false, true)}, 100),
//				new Trainer("EE", new Pokemon[]{new Pokemon(-18, 9, false, true), new Pokemon(-18, 9, false, true), new Pokemon(-18, 9, false, true), new Pokemon(-18, 9, false, true)}, 100),
//				new Trainer("FF", new Pokemon[]{new Pokemon(-25, 25, false, true), new Pokemon(-25, 25, false, true)}, 100),
//				new Trainer("GG", new Pokemon[]{new Pokemon(-63, 23, false, true), new Pokemon(-64, 27, false, true)}, 100),
//				new Trainer("HH", new Pokemon[]{new Pokemon(-65, 23, false, true), new Pokemon(-66, 27, false, true)}, 100),
//				new Trainer("II", new Pokemon[]{new Pokemon(-69, 30, false, true)}, 100),
//				new Trainer("JJ", new Pokemon[]{new Pokemon(-68, 20, false, true), new Pokemon(-68, 25, false, true), new Pokemon(-68, 25, false, true)}, 100),
//				new Trainer("VV", new Pokemon[]{new Pokemon(-28, 36, false, true)}, 100),
//				new Trainer("Rival 4", new Pokemon[]{new Pokemon(-131, 33, false, true), new Pokemon(-25, 24, false, true), new Pokemon(-22, 29, false, true), new Pokemon(-41, 28, false, true)}, 500),
//				new Trainer("MM", new Pokemon[]{new Pokemon(-35, 12, false, true), new Pokemon(-35, 12, false, true), new Pokemon(-36, 12, false, true), new Pokemon(-36, 12, false, true)}, 100),
//				new Trainer("NN", new Pokemon[]{new Pokemon(-14, 13, false, true), new Pokemon(-29, 13, false, true), new Pokemon(-29, 14, false, true)}, 100),
//				new Trainer("7 Gym A", new Pokemon[]{new Pokemon(-75, 30, false, true), new Pokemon(-75, 30, false, true)}, 200),
//				new Trainer("7 Gym B", new Pokemon[]{new Pokemon(-78, 36, false, true)}, 200),
//				new Trainer("7 Gym C", new Pokemon[]{new Pokemon(-80, 26, false, true), new Pokemon(-81, 29, false, true)}, 200),
//				new Trainer("7 Gym D", new Pokemon[]{new Pokemon(-84, 26, false, true), new Pokemon(-85, 33, false, true)}, 200),
//				new Trainer("7 Gym Leader 1", new Pokemon[]{new Pokemon(-78, 39, false, true), new Pokemon(-85, 30, false, true), new Pokemon(-76, 41, false, true)}, 500),
//				new Trainer("Rival 5", new Pokemon[]{new Pokemon(-132, 36, false, true), new Pokemon(-25, 27, false, true), new Pokemon(-22, 32, false, true), new Pokemon(-41, 29, false, true), new Pokemon(-78, 35, false, true)}, 500),
//				new Trainer("KK", new Pokemon[]{new Pokemon(-96, 25, false, true), new Pokemon(-97, 20, false, true), new Pokemon(-98, 30, false, true)}, 100),
//				new Trainer("LL", new Pokemon[]{new Pokemon(-39, 25, false, true), new Pokemon(-41, 25, false, true), new Pokemon(-39, 30, false, true), new Pokemon(-41, 30, false, true)}, 100),
//				new Trainer("OO", new Pokemon[]{new Pokemon(-39, 30, false, true), new Pokemon(-41, 30, false, true)}, 100),
//				new Trainer("PP", new Pokemon[]{new Pokemon(-45, 33, false, true)}, 100),
//				new Trainer("Rival 6", new Pokemon[]{new Pokemon(-132, 45, false, true), new Pokemon(-25, 33, false, true), new Pokemon(-23, 40, false, true), new Pokemon(-41, 34, false, true), new Pokemon(-78, 44, false, true), new Pokemon(-87, 38, false, true)}, 500),
//				new Trainer("QQ", new Pokemon[]{new Pokemon(-64, 30, false, true), new Pokemon(-66, 30, false, true)}, 100),
//				new Trainer("RR", new Pokemon[]{new Pokemon(-78, 35, false, true)}, 100),
//				new Trainer("SS", new Pokemon[]{new Pokemon(-25, 30, false, true), new Pokemon(-25, 30, false, true), new Pokemon(-69, 28, false, true), new Pokemon(-70, 28, false, true), new Pokemon(-64, 30, false, true), new Pokemon(-66, 30, false, true)}, 100),
//				new Trainer("8 Gym A", new Pokemon[]{new Pokemon(-100, 30, false, true), new Pokemon(-100, 30, false, true), new Pokemon(-100, 30, false, true), new Pokemon(-100, 30, false, true), new Pokemon(-100, 30, false, true), new Pokemon(-100, 30, false, true)}, 200),
//				new Trainer("8 Gym B", new Pokemon[]{new Pokemon(-101, 40, false, true), new Pokemon(-101, 40, false, true)}, 200),
//				new Trainer("8 Gym C", new Pokemon[]{new Pokemon(-70, 45, false, true), new Pokemon(-78, 42, false, true)}, 200),
//				new Trainer("8 Gym D", new Pokemon[]{new Pokemon(-122, 50, false, true)}, 200),
//				new Trainer("8 Gym E", new Pokemon[]{new Pokemon(-101, 41, false, true), new Pokemon(-100, 32, false, true), new Pokemon(-78, 39, false, true)}, 200),
//				new Trainer("8 Gym F", new Pokemon[]{new Pokemon(-122, 30, false, true), new Pokemon(-122, 35, false, true), new Pokemon(-122, 40, false, true), new Pokemon(-122, 45, false, true)}, 200),
//				new Trainer("8 Gym Leader 1", new Pokemon[]{new Pokemon(-100, 33, false, true), new Pokemon(-101, 45, false, true), new Pokemon(-79, 55, false, true), new Pokemon(-122, 50, false, true), new Pokemon(-70, 48, false, true), new Pokemon(-102, 55, false, true)}, 500),
//				new Trainer("TA", new Pokemon[]{new Pokemon(-112, 50, false, true)}, 100),
//				new Trainer("TB", new Pokemon[]{new Pokemon(-113, 50, false, true)}, 100),
//				new Trainer("TC", new Pokemon[]{new Pokemon(-114, 50, false, true)}, 100),
//				new Trainer("TD", new Pokemon[]{new Pokemon(-115, 50, false, true)}, 100),
//				new Trainer("TE", new Pokemon[]{new Pokemon(-116, 50, false, true)}, 100),
//				new Trainer("TF", new Pokemon[]{new Pokemon(-117, 50, false, true)}, 100),
//				new Trainer("TG", new Pokemon[]{new Pokemon(-118, 50, false, true)}, 100),
//				new Trainer("TH", new Pokemon[]{new Pokemon(-119, 50, false, true)}, 100),
//				new Trainer("TI", new Pokemon[]{new Pokemon(-120, 50, false, true)}, 100),
//				new Trainer("TJ", new Pokemon[]{new Pokemon(-121, 50, false, true)}, 100),
//				new Trainer("TK", new Pokemon[]{new Pokemon(-122, 50, false, true)}, 100),
//				new Trainer("TL", new Pokemon[]{new Pokemon(-123, 50, false, true)}, 100),
//				new Trainer("TA 2", new Pokemon[]{new Pokemon(-112, 80, false, true)}, 100),
//				new Trainer("TB 2", new Pokemon[]{new Pokemon(-113, 80, false, true)}, 100),
//				new Trainer("TC 2", new Pokemon[]{new Pokemon(-114, 80, false, true)}, 100),
//				new Trainer("TD 2", new Pokemon[]{new Pokemon(-115, 80, false, true)}, 100),
//				new Trainer("TE 2", new Pokemon[]{new Pokemon(-116, 80, false, true)}, 100),
//				new Trainer("TF 2", new Pokemon[]{new Pokemon(-117, 80, false, true)}, 100),
//				new Trainer("TG 2", new Pokemon[]{new Pokemon(-118, 80, false, true)}, 100),
//				new Trainer("TH 2", new Pokemon[]{new Pokemon(-119, 80, false, true)}, 100),
//				new Trainer("TI 2", new Pokemon[]{new Pokemon(-120, 80, false, true)}, 100),
//				new Trainer("TJ 2", new Pokemon[]{new Pokemon(-121, 80, false, true)}, 100),
//				new Trainer("TK 2", new Pokemon[]{new Pokemon(-122, 80, false, true)}, 100),
//				new Trainer("TL 2", new Pokemon[]{new Pokemon(-123, 80, false, true)}, 100),
//				new Trainer("TM", new Pokemon[]{new Pokemon(-92, 50, false, true), new Pokemon(-92, 50, false, true), new Pokemon(-92, 50, false, true), new Pokemon(-92, 50, false, true)}, 100),
//				new Trainer("TN", new Pokemon[]{new Pokemon(-47, 50, false, true), new Pokemon(-45, 50, false, true), new Pokemon(-37, 50, false, true), new Pokemon(-37, 50, false, true), new Pokemon(-90, 50, false, true), new Pokemon(-90, 50, false, true)}, 100),
//				new Trainer("TO", new Pokemon[]{new Pokemon(-90, 50, false, true), new Pokemon(-43, 50, false, true), new Pokemon(-37, 50, false, true), new Pokemon(-87, 50, false, true), new Pokemon(-41, 50, false, true), new Pokemon(-91, 55, false, true)}, 100),
//				new Trainer("1 Gym Leader 2", new Pokemon[]{new Pokemon(-20, 50, false, true), new Pokemon(-23, 55, false, true), new Pokemon(-20, 50, false, true), new Pokemon(-118, 58, false, true), new Pokemon(-3, 57, false, true), new Pokemon(-6, 57, false, true)}, 500),
//				new Trainer("2 Gym Leader 2", new Pokemon[]{new Pokemon(-13, 60, false, true), new Pokemon(-3, 60, false, true), new Pokemon(-11, 54, false, true), new Pokemon(-113, 61, false, true), new Pokemon(-60, 58, false, true), new Pokemon(-126, 61, false, true)}, 500),
//				new Trainer("3 Gym Leader 2", new Pokemon[]{new Pokemon(-41, 59, false, true), new Pokemon(-39, 60, false, true), new Pokemon(-41, 61, false, true), new Pokemon(-94, 64, false, true), new Pokemon(-94, 64, false, true), new Pokemon(-39, 60, false, true)}, 500),
//				new Trainer("4 Gym Leader 2", new Pokemon[]{new Pokemon(-43, 66, false, true), new Pokemon(-45, 64, false, true), new Pokemon(-47, 63, false, true), new Pokemon(-45, 65, false, true), new Pokemon(-117, 67, false, true), new Pokemon(-83, 62, false, true)}, 500),
//				new Trainer("5 Gym Leader 2", new Pokemon[]{new Pokemon(-132, 72, false, true), new Pokemon(-66, 69, false, true), new Pokemon(-9, 70, false, true), new Pokemon(-64, 70, false, true), new Pokemon(-144, 67, false, true), new Pokemon(-115, 71, false, true)}, 500),
//				new Trainer("6 Gym Leader 2", new Pokemon[]{new Pokemon(-90, 73, false, true), new Pokemon(-41, 72, false, true), new Pokemon(-90, 73, false, true), new Pokemon(-87, 74, false, true), new Pokemon(-119, 76, false, true), new Pokemon(-69, 74, false, true)}, 500),
//				new Trainer("7 Gym Leader 2", new Pokemon[]{new Pokemon(-85, 75, false, true), new Pokemon(-108, 77, false, true), new Pokemon(-129, 78, false, true), new Pokemon(-76, 76, false, true), new Pokemon(-114, 77, false, true), new Pokemon(-81, 76, false, true)}, 500),
//				new Trainer("8 Gym Leader 2", new Pokemon[]{new Pokemon(-79, 82, false, true), new Pokemon(-102, 83, false, true), new Pokemon(-102, 83, false, true), new Pokemon(-122, 85, false, true), new Pokemon(-79, 82, false, true), new Pokemon(-102, 83, false, true)}, 500),
//				new Trainer("Rival 7", new Pokemon[]{new Pokemon(-132, 90, false, true), new Pokemon(-25, 71, false, true), new Pokemon(-23, 82, false, true), new Pokemon(-41, 74, false, true), new Pokemon(-79, 88, false, true), new Pokemon(-87, 78, false, true)}, 500),
		};
	}

}
