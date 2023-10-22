package Overworld;

import Entity.Entity;
import Entity.NPC_Block;
import Entity.NPC_Clerk;
import Entity.NPC_GymLeader;
import Entity.NPC_Market;
import Entity.NPC_Nurse;
import Entity.NPC_PC;
import Entity.NPC_Rival;
import Entity.NPC_Rival2;
import Entity.NPC_TN;
import Entity.NPC_Trainer;
import Obj.Cut_Tree;
import Obj.GymBarrier;
import Obj.InteractiveTile;
import Obj.ItemObj;
import Obj.Rock_Smash;
import Obj.Tree_Stump;
import Obj.Vine;
import Obj.Vine_Crossable;
import Swing.Item;

public class AssetSetter {

	GamePanel gp;
	int index;
	int objIndex;
	private int iIndex;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
		index = 0;
		objIndex = 0;
		iIndex = 0;
	}
	
	public void setObject() {
		int mapNum = 0;
		
		gp.obj[mapNum][objIndex] = ObjSetup(60, 45, 4, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(2, 54, 9, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(25, 31, 1, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(89, 24, 40, mapNum);
		
		gp.obj[mapNum][objIndex] = ObjSetup(89, 10, 184, mapNum); // dark pulse
		gp.obj[mapNum][objIndex] = ObjSetup(79, 11, 30, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(80, 18, 42, mapNum);
		
		mapNum = 4;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(86, 56, 131, mapNum); // false swipe
		gp.obj[mapNum][objIndex] = ObjSetup(39, 59, 5, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(39, 60, 41, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(42, 74, 126, mapNum); // hidden power
		gp.obj[mapNum][objIndex] = ObjSetup(15, 57, 117, mapNum); // solar beam
		gp.obj[mapNum][objIndex] = ObjSetup(9, 72, 0, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(9, 75, 2, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(71, 29, 199, mapNum); // return (need cut)
		gp.obj[mapNum][objIndex] = ObjSetup(74, 19, 27, mapNum);
		
		mapNum = 11;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(91, 55, 26, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(60, 66, 0, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(61, 62, 16, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(15, 76, 2, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(57, 75, 5, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(53, 67, 12, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(55, 57, 1, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(40, 68, 19, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(50, 78, 4, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(40, 82, 5, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(37, 81, 9, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(30, 87, 4, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(25, 90, 20, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(16, 81, 14, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(26, 69, 0, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(80, 65, 140, mapNum);
		
		gp.obj[mapNum][objIndex] = ObjSetup(4, 43, 109, mapNum); // leaf blade
		gp.obj[mapNum][objIndex] = ObjSetup(32, 60, 1, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(35, 52, 10, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(34, 50, 5, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(33, 47, 11, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(15, 46, 0, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(32, 34, 16, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(35, 38, 19, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(35, 44, 14, mapNum);
		
		mapNum = 13;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(32, 35, 14, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(17, 48, 137, mapNum); // rock tomb
		gp.obj[mapNum][objIndex] = ObjSetup(17, 45, 13, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(32, 30, 37, mapNum); // quiet
		gp.obj[mapNum][objIndex] = ObjSetup(28, 8, 172, mapNum); // ice spinner (v.cross)
		
		mapNum = 14;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(22, 48, 157, mapNum); // charge beam
		gp.obj[mapNum][objIndex] = ObjSetup(42, 35, 14, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(36, 30, 31, mapNum); // brave
		gp.obj[mapNum][objIndex] = ObjSetup(39, 32, 42, mapNum);
		
		mapNum = 15;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(33, 39, 16, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(25, 15, 12, mapNum);

		mapNum = 16;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(44, 33, 5, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(21, 37, 3, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(22, 27, 127, mapNum); // taunt
		gp.obj[mapNum][objIndex] = ObjSetup(26, 27, 114, mapNum); // drain punch
		gp.obj[mapNum][objIndex] = ObjSetup(46, 28, 27, mapNum);
		
		mapNum = 17;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(43, 38, 161, mapNum); // smack down
		gp.obj[mapNum][objIndex] = ObjSetup(53, 38, 41, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(63, 38, 6, mapNum);
		
		mapNum = 18;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(55, 33, 40, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(43, 35, 18, mapNum);
		
		mapNum = 22;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(60, 15, 128, mapNum); // flame charge
		gp.obj[mapNum][objIndex] = ObjSetup(94, 15, 19, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(72, 18, 11, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(82, 14, 4, mapNum);
		
		mapNum = 24;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(69, 84, 169, mapNum); // rock polish
		gp.obj[mapNum][objIndex] = ObjSetup(67, 75, 6, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(78, 52, 168, mapNum); // flash
		
		mapNum = 25;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(77, 68, 3, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(58, 74, 14, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(59, 79, 18, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(45, 84, 27, mapNum);
		
		mapNum = 26;
		gp.obj[mapNum][objIndex] = ObjSetup(62, 69, 0, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(54, 69, 34, mapNum); // impish
		
		mapNum = 28;
		gp.obj[mapNum][objIndex] = ObjSetup(15, 43, 9, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(25, 46, 183, mapNum); // captivate
		gp.obj[mapNum][objIndex] = ObjSetup(52, 43, 6, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(82, 23, 189, mapNum); // acrobatics
		gp.obj[mapNum][objIndex] = ObjSetup(43, 37, 28, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(83, 14, 6, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(53, 32, 22, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(89, 34, 2, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(71, 34, 10, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(64, 23, 0, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(28, 29, 42, mapNum);
		
		mapNum = 33;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(22, 6, 6, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(38, 21, 13, mapNum);
		
		gp.obj[mapNum][objIndex] = ObjSetup(25, 80, 6, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(48, 82, 0, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(39, 75, 40, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(16, 76, 20, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(14, 39, 41, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(35, 43, 33, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(42, 39, 105, mapNum); // body slam (change to in house??)
		
		mapNum = 35;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(7, 56, 12, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(30, 62, 6, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(31, 77, 18, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(46, 68, 16, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(59, 76, 27, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(62, 73, 3, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(64, 78, 7, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(91, 57, 0, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(61, 41, 41, mapNum);
		
		mapNum = 36;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(12, 52, 3, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(21, 32, 6, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(49, 56, 36, mapNum); // modest
		gp.obj[mapNum][objIndex] = ObjSetup(61, 28, 14, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(54, 45, 19, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(58, 51, 0, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(66, 52, 5, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(68, 54, 12, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(89, 52, 16, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(64, 20, 186, mapNum); // x-scissor
		
		mapNum = 38;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(16, 34, 38, mapNum); // serious
		gp.obj[mapNum][objIndex] = ObjSetup(41, 34, 6, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(54, 7, 23, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(67, 30, 13, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(40, 30, 13, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(34, 75, 26, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(35, 77, 148, mapNum); // scald
		gp.obj[mapNum][objIndex] = ObjSetup(54, 78, 29, mapNum); // adamant
		gp.obj[mapNum][objIndex] = ObjSetup(54, 79, 41, mapNum);
		
		mapNum = 41;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(40, 45, 3, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(48, 45, 0, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(22, 45, 162, mapNum); // bug buzz
		gp.obj[mapNum][objIndex] = ObjSetup(16, 41, 3, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(9, 18, 5, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(15, 17, 14, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(30, 29, 27, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(48, 17, 3, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(54, 18, 5, mapNum);
		
		gp.obj[mapNum][objIndex] = ObjSetup(29, 42, 12, 43);
		
		mapNum = 57;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(31, 40, 44, mapNum); // flame orb
		
		mapNum = 60;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(24, 36, 102, mapNum); // dragon claw
		gp.obj[mapNum][objIndex] = ObjSetup(38, 44, 173, mapNum); // gyro ball
		
		mapNum = 77;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(15, 22, 129, mapNum); // liquidation
		gp.obj[mapNum][objIndex] = ObjSetup(11, 10, 28, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(86, 11, 16, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(90, 12, 0, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(81, 28, 7, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(94, 28, 32, mapNum); // calm
		gp.obj[mapNum][objIndex] = ObjSetup(69, 43, 27, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(66, 40, 40, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(88, 51, 19, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(86, 44, 6, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(76, 62, 14, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(85, 75, 22, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(42, 76, 41, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(18, 73, 17, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(26, 63, 18, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(7, 63, 42, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(67, 5, 10, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(90, 5, 104, mapNum); // calm mind
		
		mapNum = 78;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(62, 69, 32, mapNum); // calm
		
		mapNum = 80;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(22, 11, 35, mapNum); // jolly
		gp.obj[mapNum][objIndex] = ObjSetup(21, 25, 190, mapNum); // iron blast
		gp.obj[mapNum][objIndex] = ObjSetup(28, 18, 6, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(35, 13, 40, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(39, 11, 27, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(23, 34, 41, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(25, 55, 39, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(27, 72, 42, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(88, 46, 165, mapNum); // shadow claw
		
		mapNum = 83;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(24, 79, 39, mapNum); // timid
		gp.obj[mapNum][objIndex] = ObjSetup(21, 54, 19, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(10, 56, 42, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(33, 57, 40, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(50, 80, 10, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(57, 74, 7, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(62, 73, 41, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(75, 50, 185, mapNum); // rock slide
		gp.obj[mapNum][objIndex] = ObjSetup(67, 55, 14, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(65, 49, 27, mapNum);
		
		mapNum = 85;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(16, 55, 37, mapNum); // quiet
		gp.obj[mapNum][objIndex] = ObjSetup(47, 60, 155, mapNum); // magic blast
		gp.obj[mapNum][objIndex] = ObjSetup(45, 70, 7, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(15, 76, 42, mapNum);
		
		mapNum = 90;
		objIndex = 0;
		gp.obj[mapNum][objIndex] = ObjSetup(56, 20, 21, mapNum);
		gp.obj[mapNum][objIndex] = ObjSetup(48, 18, 187, mapNum); // poison jab
		gp.obj[mapNum][objIndex] = ObjSetup(55, 9, 33, mapNum); // careful
	}
	
	public void setNPC() {
		boolean[] flags = gp.player.p.flags;
		int mapNum = 0;
		
		if (flags[0] && !flags[1]) {
			gp.npc[mapNum][index] = NPCSetup(10, 72, 48, 0);
		} else {
			gp.npc[mapNum][index++] = null;
		}
		
		gp.npc[mapNum][index] = NPCSetup(5, 18, 18, 1);
		
		gp.npc[mapNum][index] = NPCSetup(6, 23, 19, 2);
		
		gp.npc[mapNum][index] = NPCSetup(6, 23, 27, 3);
		
		gp.npc[mapNum][index] = NPCSetup(5, 21, 31, 4);
		
		gp.npc[mapNum][index] = NPCSetup(6, 21, 14, 102);
		
		gp.npc[mapNum][index] = NPCSetup(5, 88, 7, 175);
		gp.npc[mapNum][index] = NPCSetup(6, 83, 8, 176);
		gp.npc[mapNum][index] = NPCSetup(6, 82, 11, 177);
		gp.npc[mapNum][index] = NPCSetup(5, 88, 11, 178);
		gp.npc[mapNum][index] = NPCSetup(5, 88, 16, 179);
		
		
		// Nurses/PCs
		gp.npc[1][index] = NPCSetup(1, 31, 37, -1);
		gp.npc[1][index] = NPCSetup(0, 35, 36, -1);
		gp.npc[5][index] = NPCSetup(1, 31, 37, -1);
		gp.npc[5][index] = NPCSetup(0, 35, 36, -1);
		gp.npc[19][index] = NPCSetup(1, 31, 37, -1);
		gp.npc[19][index] = NPCSetup(0, 35, 36, -1);
		
		// Clerks
		gp.npc[2][index] = NPCSetup(2, 27, 39, -1);
		gp.npc[6][index] = NPCSetup(2, 27, 39, -1);
		gp.npc[20][index] = NPCSetup(2, 27, 39, -1);
		
		mapNum = 3;
		index = 0;
		if (!flags[1]) {
			gp.npc[mapNum][index] = NPCSetup(31, 40, "I saw a boy named Scott near New\nMinnow town saying he was looking\nfor a young man that looked like you.\nMaybe you should check it out?");
		} else {
			gp.npc[mapNum][index++] = null;
		}
		
		mapNum = 4;
		if (!flags[2]) {
			gp.npc[mapNum][index] = NPCSetup(81, 61, "The gym is currently closed because the\nLeader is trying to help the Warehouse\nowner get rid of Team Nuke.\nCome back later.");
		} else {
			gp.npc[mapNum][index++] = null;
		}
		
		gp.npc[mapNum][index] = NPCSetup(4, 32, 62, 18);
		gp.npc[mapNum][index] = NPCSetup(4, 23, 65, 19); // make way lower levels
		gp.npc[mapNum][index] = NPCSetup(4, 32, 68, 20); // make way lower levels
		gp.npc[mapNum][index] = NPCSetup(4, 34, 76, 21); // make way lower levels
		gp.npc[mapNum][index] = NPCSetup(4, 45, 75, 22); // make way lower levels
		gp.npc[mapNum][index] = NPCSetup(4, 15, 70, 103);
		gp.npc[mapNum][index] = NPCSetup(4, 11, 70, 23);
		
		gp.npc[mapNum][index] = NPCSetup(6, 72, 37, 98);
		gp.npc[mapNum][index] = NPCSetup(5, 77, 34, 99);
		gp.npc[mapNum][index] = NPCSetup(5, 76, 30, 100);
		gp.npc[mapNum][index] = NPCSetup(6, 72, 28, 101);
		
//		gp.npc[mapNum][index] = NPCSetup(4, 15, 70, 23);
//		gp.npc[mapNum][index] = NPCSetup(4, 15, 70, 23);
//		gp.npc[mapNum][index] = NPCSetup(4, 15, 70, 23);
		
		mapNum = 7;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(14, 30, 42, 5);
		gp.npc[mapNum][index] = NPCSetup(13, 33, 42, 6);
		gp.npc[mapNum][index] = NPCSetup(11, 36, 39, 7);
		gp.npc[mapNum][index] = NPCSetup(12, 36, 42, 8);
		
		mapNum = 8;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(13, 30, 39, 9);
		gp.npc[mapNum][index] = NPCSetup(12, 28, 41, 10);
		gp.npc[mapNum][index] = NPCSetup(11, 32, 39, 11);
		gp.npc[mapNum][index] = NPCSetup(12, 32, 45, 12);
		gp.npc[mapNum][index] = NPCSetup(8, 35, 41, 13);
		
		mapNum = 9;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(5, 34, 42, 14);
		gp.npc[mapNum][index] = NPCSetup(6, 27, 39, 15);
		gp.npc[mapNum][index] = NPCSetup(5, 42, 34, 16);
		gp.npc[mapNum][index] = NPCSetup(8, 38, 28, 17);
		
		mapNum = 11;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(4, 69, 65, 24);
		gp.npc[mapNum][index] = NPCSetup(4, 50, 72, 25);
		gp.npc[mapNum][index] = NPCSetup(4, 59, 74, 26);
		gp.npc[mapNum][index] = NPCSetup(4, 76, 68, 27);
		gp.npc[mapNum][index] = NPCSetup(3, 53, 59, 28);
		gp.npc[mapNum][index] = NPCSetup(4, 53, 65, 29);
		gp.npc[mapNum][index] = NPCSetup(4, 76, 59, 30);
		
		gp.npc[mapNum][index] = NPCSetup(16, 43, 73, 34);
		
		gp.npc[mapNum][index] = NPCSetup(5, 40, 78, 31);
		gp.npc[mapNum][index] = NPCSetup(5, 36, 79, 32);
		gp.npc[mapNum][index] = NPCSetup(4, 34, 89, 33);
		
		gp.npc[mapNum][index] = NPCSetup(7, 19, 61, -1);
		
		gp.npc[mapNum][index] = NPCSetup(6, 28, 55, 35);
		gp.npc[mapNum][index] = NPCSetup(6, 15, 49, 36);
		gp.npc[mapNum][index] = NPCSetup(5, 19, 49, 37);
		gp.npc[mapNum][index] = NPCSetup(6, 21, 45, 38);
		gp.npc[mapNum][index] = NPCSetup(6, 22, 33, 39);
		
		mapNum = 13;
		index = 0;
		if (!flags[4]) {
			gp.npc[mapNum][index] = NPCSetup(12, 56, "The gym leader is stuck in the\noffice upstairs trying to help\nScott with Team Nuke.\nGo find Scott and help!");
		} else {
			gp.npc[mapNum][index++] = null;
		}
		gp.npc[mapNum][index] = NPCSetup(5, 26, 49, 104);
		gp.npc[mapNum][index] = NPCSetup(6, 20, 49, 105);
		gp.npc[mapNum][index] = NPCSetup(5, 26, 34, 71);
		gp.npc[mapNum][index] = NPCSetup(5, 16, 37, 72);
		gp.npc[mapNum][index] = NPCSetup(6, 32, 24, 73);
		gp.npc[mapNum][index] = NPCSetup(6, 25, 18, 74);
		
		mapNum = 14;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(5, 33, 41, 44);
		gp.npc[mapNum][index] = NPCSetup(3, 26, 29, 40);
		gp.npc[mapNum][index] = NPCSetup(5, 39, 39, 41);
		gp.npc[mapNum][index] = NPCSetup(6, 22, 43, 42);
		gp.npc[mapNum][index] = NPCSetup(4, 26, 48, 43);
		
		mapNum = 16;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(6, 22, 29, 45);
		gp.npc[mapNum][index] = NPCSetup(6, 26, 29, 46);
		gp.npc[mapNum][index] = NPCSetup(5, 46, 29, 47);
		gp.npc[mapNum][index] = NPCSetup(6, 21, 39, 48);
		
		mapNum = 17;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(14, 50, 45, 49);
		gp.npc[mapNum][index] = NPCSetup(13, 56, 45, 50);
		gp.npc[mapNum][index] = NPCSetup(14, 50, 44, 51);
		gp.npc[mapNum][index] = NPCSetup(13, 56, 44, 52);
		gp.npc[mapNum][index] = NPCSetup(14, 50, 43, 53);
		gp.npc[mapNum][index] = NPCSetup(13, 56, 43, 54);
		
		if (!flags[3]) {
			gp.npc[mapNum][index] = NPCSetup(49, 53, "Quick! Team Nuke is taking over\nour office! Please help!");
			gp.npc[mapNum][index] = NPCSetup(57, 53, "Quick! Team Nuke is taking over\nour office! Please help!");
		} else {
			gp.npc[mapNum][index++] = null;
			gp.npc[mapNum][index++] = null;
		}
		
		mapNum = 18;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(10, 48, 45, 55);
		gp.npc[mapNum][index] = NPCSetup(6, 45, 38, 146);
		gp.npc[mapNum][index] = NPCSetup(46, 33, "That was an impressive battle!\nI found a rare MAGIC Pokemon,\nbut after watching that, you'd\nbe a better trainer. Here!", true);
		
		mapNum = 21;
		gp.npc[mapNum][index] = NPCSetup(3, 55, 60, 56);
		gp.npc[mapNum][index] = NPCSetup(4, 55, 62, 57);
		gp.npc[mapNum][index] = NPCSetup(3, 72, 52, 58);
		gp.npc[mapNum][index] = NPCSetup(4, 72, 54, 59);
		gp.npc[mapNum][index] = NPCSetup(6, 73, 57, 60);
		gp.npc[mapNum][index] = NPCSetup(5, 75, 57, 61);
		gp.npc[mapNum][index] = NPCSetup(3, 72, 46, 62);
		gp.npc[mapNum][index] = NPCSetup(4, 72, 48, 63);
		gp.npc[mapNum][index] = NPCSetup(3, 54, 46, 64);
		gp.npc[mapNum][index] = NPCSetup(4, 54, 48, 65);
		
		gp.npc[mapNum][index] = NPCSetup(8, 63, 39, 66);
		
		mapNum = 22;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(3, 80, 8, 67);
		gp.npc[mapNum][index] = NPCSetup(4, 78, 12, 68);
		gp.npc[mapNum][index] = NPCSetup(3, 72, 10, 69);
		gp.npc[mapNum][index] = NPCSetup(4, 69, 14, 70);
		
		mapNum = 24;
		gp.npc[mapNum][index] = NPCSetup(6, 65, 63, 75);
		
		mapNum = 25;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(6, 70, 65, 76);
		gp.npc[mapNum][index] = NPCSetup(6, 70, 80, 77);
		gp.npc[mapNum][index] = NPCSetup(4, 66, 87, 78);
		
		mapNum = 26;
		gp.npc[mapNum][index] = NPCSetup(11, 58, 70, 79);
		
		index = 0;
		// Nurses/PCs
		gp.npc[29][index] = NPCSetup(1, 31, 37, -1);
		gp.npc[29][index] = NPCSetup(0, 35, 36, -1);
		gp.npc[39][index] = NPCSetup(1, 31, 37, -1);
		gp.npc[39][index] = NPCSetup(0, 35, 36, -1);
		gp.npc[86][index] = NPCSetup(1, 31, 37, -1);
		gp.npc[86][index] = NPCSetup(0, 35, 36, -1);
		
		// Clerks
		gp.npc[30][index] = NPCSetup(17, 31, 41, -1);
		gp.npc[40][index] = NPCSetup(17, 34, 38, -1);
		gp.npc[45][index] = NPCSetup(2, 30, 39, -1);
		gp.npc[87][index] = NPCSetup(2, 27, 39, -1);
		gp.npc[89][index] = NPCSetup(17, 24, 36, -1);
		
		mapNum = 28;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(3, 12, 52, 85);
		gp.npc[mapNum][index] = NPCSetup(4, 13, 55, 86);
		gp.npc[mapNum][index] = NPCSetup(3, 30, 50, 80);
		gp.npc[mapNum][index] = NPCSetup(6, 50, 52, 87);
		gp.npc[mapNum][index] = NPCSetup(4, 52, 55, 81);
		gp.npc[mapNum][index] = NPCSetup(3, 56, 46, 82);
		gp.npc[mapNum][index] = NPCSetup(5, 60, 49, 88);
		gp.npc[mapNum][index] = NPCSetup(4, 38, 36, 83);
		gp.npc[mapNum][index] = NPCSetup(5, 55, 35, 84);
		
		if (!flags[5]) {
			gp.npc[mapNum][index] = NPCSetup(15, 87, 45, 89);
		} else {
			gp.npc[mapNum][index++] = null;
		}
		
		
		gp.npc[mapNum][index] = NPCSetup(6, 77, 26, 95);
		gp.npc[mapNum][index] = NPCSetup(3, 82, 20, 96);
		gp.npc[mapNum][index] = NPCSetup(5, 87, 26, 97);
		
		mapNum = 31;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(3, 48, 50, 90);
		gp.npc[mapNum][index] = NPCSetup(5, 65, 61, 91);
		gp.npc[mapNum][index] = NPCSetup(3, 45, 63, 92);
		gp.npc[mapNum][index] = NPCSetup(6, 38, 70, 93);
		gp.npc[mapNum][index] = NPCSetup(8, 51, 61, 94);
		
		mapNum = 32;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(31, 40, "Take my spare fishing rod!\nLook at water and press\n'A' to fish!");
		
		mapNum = 33;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(3, 49, 78, 195);
		gp.npc[mapNum][index] = NPCSetup(3, 40, 84, 196);
		gp.npc[mapNum][index] = NPCSetup(5, 35, 73, 197);
		gp.npc[mapNum][index] = NPCSetup(6, 22, 81, 198);
		gp.npc[mapNum][index] = NPCSetup(6, 25, 45, 199);
		gp.npc[mapNum][index] = NPCSetup(6, 32, 41, 200);
		gp.npc[mapNum][index] = NPCSetup(5, 41, 44, 201);
		
		mapNum = 36;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(3, 20, 45, 106);
		gp.npc[mapNum][index] = NPCSetup(5, 39, 47, 107);
		gp.npc[mapNum][index] = NPCSetup(3, 42, 27, 108);
		gp.npc[mapNum][index] = NPCSetup(6, 44, 32, 109);
		gp.npc[mapNum][index] = NPCSetup(3, 60, 31, 110);
		gp.npc[mapNum][index] = NPCSetup(6, 53, 44, 111);
		gp.npc[mapNum][index] = NPCSetup(4, 65, 48, 112);
		gp.npc[mapNum][index] = NPCSetup(5, 82, 39, 113);
		gp.npc[mapNum][index] = NPCSetup(6, 67, 30, 114);
		gp.npc[mapNum][index] = NPCSetup(3, 76, 25, 115);
		gp.npc[mapNum][index] = NPCSetup(4, 91, 43, 116);
		
		mapNum = 38;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(53, 7, "Do you have an ICE type to show me?\nAlso, say hi to my brother in the\nRADIO TOWER if you haven't yet!", true);
		
		if (!flags[8] || !flags[9]) {
			gp.npc[mapNum][index] = NPCSetup(62, 41, "What is going on at the school?!\nWhere is everybody?!?!");
		} else {
			gp.npc[mapNum][index++] = null;
		}
		
		gp.npc[mapNum][index] = NPCSetup(5, 35, 74, 138);
		gp.npc[mapNum][index] = NPCSetup(5, 51, 74, 139);
		gp.npc[mapNum][index] = NPCSetup(6, 46, 85, 140);
		gp.npc[mapNum][index] = NPCSetup(6, 36, 84, 141);
		
		mapNum = 43;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(31, 42, "Do you have an GROUND type to show me?\nAlso, say hi to my brother in the\nICY FIELDS if you haven't yet!", true);
		
		mapNum = 41;
		index = 0;
		
		if (!flags[7]) {
			gp.npc[mapNum][index] = NPCSetup(13, 24, "This room is locked!\nWhere could the key be?");
		} else {
			gp.npc[mapNum][index++] = null;
		}
		
		if (!flags[6]) {
			gp.npc[mapNum][index] = NPCSetup(50, 24, "This room is locked!\nWhere could the key be?");
		} else {
			gp.npc[mapNum][index++] = null;
		}
		
		gp.npc[mapNum][index] = NPCSetup(11, 51, 21, 117);
		gp.npc[mapNum][index] = NPCSetup(12, 51, 27, 118);
		gp.npc[mapNum][index] = NPCSetup(11, 12, 21, 119);
		gp.npc[mapNum][index] = NPCSetup(12, 12, 27, 120);
		gp.npc[mapNum][index] = NPCSetup(11, 14, 22, 121);
		gp.npc[mapNum][index] = NPCSetup(12, 14, 26, 122);
		gp.npc[mapNum][index] = NPCSetup(13, 19, 24, 123);
		gp.npc[mapNum][index] = NPCSetup(14, 21, 22, 124);
		gp.npc[mapNum][index] = NPCSetup(13, 25, 22, 125);
		gp.npc[mapNum][index] = NPCSetup(11, 23, 16, 126);
		gp.npc[mapNum][index] = NPCSetup(14, 32, 24, 127);
		gp.npc[mapNum][index] = NPCSetup(13, 37, 24, 128);
		gp.npc[mapNum][index] = NPCSetup(11, 40, 18, 129);
		gp.npc[mapNum][index] = NPCSetup(12, 40, 21, 130);
		gp.npc[mapNum][index] = NPCSetup(14, 36, 17, 131);
		gp.npc[mapNum][index] = NPCSetup(12, 32, 18, 132);
		
		gp.npc[mapNum][index] = NPCSetup(29, 18, "Who are these people??\nHave you cleared both rooms yet?", true);
		
		mapNum = 44;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(6, 60, 61, 133);
		gp.npc[mapNum][index] = NPCSetup(5, 66, 57, 134);
		gp.npc[mapNum][index] = NPCSetup(6, 60, 52, 135);
		gp.npc[mapNum][index] = NPCSetup(5, 66, 46, 136);
		gp.npc[mapNum][index] = NPCSetup(8, 63, 39, 137);
		
		mapNum = 46;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(31, 41, "Check your team's Hidden Power types here!", true);
		
		mapNum = 47;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(31, 41, "Here, take this as a gift!", true);
		
		mapNum = 48;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(6, 29, 42, 142);
		gp.npc[mapNum][index] = NPCSetup(5, 33, 42, 143);
		gp.npc[mapNum][index] = NPCSetup(3, 31, 36, 144);
		gp.npc[mapNum][index] = NPCSetup(6, 28, 39, 145);
		gp.npc[mapNum][index] = NPCSetup(24, 37, "Here, take this as a gift!", true);
		
		mapNum = 49;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(31, 41, "Deep below ELECTRIC TUNNEL there's\na secret trail called SHADOW PATH.", true);
		
		mapNum = 50;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(31, 41, "WOAOAOHAOAHOAHOH!!!\nHehehehehe I just\npopped a naughty yerkocet!!\nPick one of these NUTTY\n\"starters\" teheheheheheee", true);
		
		mapNum = 60;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(6, 29, 42, 147);
		gp.npc[mapNum][index] = NPCSetup(5, 33, 42, 148);
		
		mapNum = 77;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(6, 46, 18, 149);
		gp.npc[mapNum][index] = NPCSetup(5, 51, 24, 150);
		gp.npc[mapNum][index] = NPCSetup(6, 45, 30, 151);
		gp.npc[mapNum][index] = NPCSetup(6, 52, 64, 152);
		gp.npc[mapNum][index] = NPCSetup(5, 54, 37, 153);
		gp.npc[mapNum][index] = NPCSetup(5, 54, 52, 154);
		gp.npc[mapNum][index] = NPCSetup(5, 86, 33, 155);
		gp.npc[mapNum][index] = NPCSetup(4, 67, 34, 156);
		gp.npc[mapNum][index] = NPCSetup(6, 74, 61, 157);
		gp.npc[mapNum][index] = NPCSetup(5, 32, 45, 158);
		gp.npc[mapNum][index] = NPCSetup(3, 18, 20, 159);
		gp.npc[mapNum][index] = NPCSetup(4, 18, 24, 160);
		gp.npc[mapNum][index] = NPCSetup(5, 87, 15, 161);
		gp.npc[mapNum][index] = NPCSetup(6, 67, 41, 162);
		gp.npc[mapNum][index] = NPCSetup(6, 83, 47, 163);
		gp.npc[mapNum][index] = NPCSetup(6, 23, 60, 164);
		
		mapNum = 80;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(5, 33, 19, 165);
		gp.npc[mapNum][index] = NPCSetup(6, 27, 22, 166);
		gp.npc[mapNum][index] = NPCSetup(6, 28, 28, 167);
		gp.npc[mapNum][index] = NPCSetup(16, 35, 41, 185);
		
		gp.npc[mapNum][index] = NPCSetup(3, 41, 51, 168);
		gp.npc[mapNum][index] = NPCSetup(6, 31, 64, 169);
		gp.npc[mapNum][index] = NPCSetup(4, 75, 57, 170);
		gp.npc[mapNum][index] = NPCSetup(5, 49, 74, 171);
		
		gp.npc[mapNum][index] = NPCSetup(7, 25, 11, -1);
		
		mapNum = 83;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(3, 48, 64, 172);
		gp.npc[mapNum][index] = NPCSetup(4, 48, 67, 173);
		
		gp.npc[mapNum][index] = NPCSetup(4, 60, 70, 180);
		gp.npc[mapNum][index] = NPCSetup(6, 61, 66, 181);
		gp.npc[mapNum][index] = NPCSetup(5, 65, 65, 182);
		
		mapNum = 88;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(5, 75, 57, 186);
		gp.npc[mapNum][index] = NPCSetup(4, 81, 57, 187);
		gp.npc[mapNum][index] = NPCSetup(3, 85, 63, 188);
		gp.npc[mapNum][index] = NPCSetup(5, 45, 67, 189);
		gp.npc[mapNum][index] = NPCSetup(6, 41, 53, 190);
		gp.npc[mapNum][index] = NPCSetup(3, 51, 53, 191);
		gp.npc[mapNum][index] = NPCSetup(4, 41, 47, 192);
		gp.npc[mapNum][index] = NPCSetup(5, 55, 47, 193);
		gp.npc[mapNum][index] = NPCSetup(8, 63, 35, 194);
		
		mapNum = 90;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(6, 48, 10, 174);
		
		mapNum = 91;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(14, 29, 45, 183);
		gp.npc[mapNum][index] = NPCSetup(13, 33, 45, 184);
		
		mapNum = 92;
		index = 0;
		gp.npc[mapNum][index] = NPCSetup(1, 31, 37, -1);
		gp.npc[mapNum][index] = NPCSetup(0, 35, 36, -1);
		gp.npc[mapNum][index] = NPCSetup(17, 22, 37, -1);
		
	}
	
	public void setInteractiveTile() {
		iIndex = 0;
		int mapNum = 4;
		gp.iTile[mapNum][iIndex] = ITileSetup(17, 63, 0);
		gp.iTile[mapNum][iIndex] = ITileSetup(16, 68, 0);
		gp.iTile[mapNum][iIndex] = ITileSetup(10, 68, 0);
		
		gp.iTile[mapNum][iIndex] = ITileSetup(74, 43, 0);
		gp.iTile[mapNum][iIndex] = ITileSetup(75, 24, 1);
		
		mapNum = 11;
		gp.iTile[mapNum][iIndex] = ITileSetup(39, 77, 0);
		gp.iTile[mapNum][iIndex] = ITileSetup(13, 52, 1);
		
		mapNum = 13;
		iIndex = 0;
		gp.iTile[mapNum][iIndex] = ITileSetup(23, 7, 1);
		gp.iTile[mapNum][iIndex] = ITileSetup(22, 9, 0);
		gp.iTile[mapNum][iIndex] = ITileSetup(23, 9, 0);
		gp.iTile[mapNum][iIndex] = ITileSetup(24, 9, 0);
		
		gp.iTile[mapNum][iIndex] = ITileSetup(27, 10, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(27, 9, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(27, 8, 4);
		
		mapNum = 18;
		iIndex = 0;
		gp.iTile[mapNum][iIndex] = ITileSetup(46, 40, 1);
		
		mapNum = 21;
		iIndex = 0;
		gp.iTile[mapNum][iIndex] = ITileSetup(63, 60, 3);
		gp.iTile[mapNum][iIndex] = ITileSetup(63, 52, 3);
		gp.iTile[mapNum][iIndex] = ITileSetup(63, 50, 3);
		gp.iTile[mapNum][iIndex] = ITileSetup(63, 45, 3);
		gp.iTile[mapNum][iIndex] = ITileSetup(63, 43, 3);
		
		mapNum = 24;
		iIndex = 0;
		gp.iTile[mapNum][iIndex] = ITileSetup(63, 70, 1);
		
		mapNum = 25;
		gp.iTile[mapNum][iIndex] = ITileSetup(73, 73, 1);
		
		mapNum = 28;
		iIndex = 0;
		gp.iTile[mapNum][iIndex] = ITileSetup(23, 42, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(23, 41, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(23, 40, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(26, 39, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(27, 39, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(28, 39, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(29, 39, 4);
		
		gp.iTile[mapNum][iIndex] = ITileSetup(31, 40, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(31, 39, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(31, 38, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(31, 37, 4);
		
		gp.iTile[mapNum][iIndex] = ITileSetup(54, 36, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(54, 37, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(54, 38, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(54, 39, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(54, 40, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(54, 41, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(54, 42, 4);
		
		gp.iTile[mapNum][iIndex] = ITileSetup(15, 53, 0);
		gp.iTile[mapNum][iIndex] = ITileSetup(29, 53, 0);
		
		mapNum = 35;
		iIndex = 0;
		gp.iTile[mapNum][iIndex] = ITileSetup(57, 60, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(58, 60, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(59, 60, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(65, 62, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(66, 62, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(67, 62, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(68, 62, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(69, 62, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(81, 63, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(82, 63, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(83, 63, 4);
		
		gp.iTile[mapNum][iIndex] = ITileSetup(76, 68, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(76, 69, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(76, 70, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(68, 75, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(69, 75, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(70, 75, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(71, 75, 4);
		
		gp.iTile[mapNum][iIndex] = ITileSetup(50, 53, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(50, 52, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(58, 47, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(59, 47, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(60, 47, 4);
		
		mapNum = 60;
		iIndex = 0;
		gp.iTile[mapNum][iIndex] = ITileSetup(30, 44, 1);
		gp.iTile[mapNum][iIndex] = ITileSetup(31, 43, 1);
		gp.iTile[mapNum][iIndex] = ITileSetup(32, 43, 1);
		gp.iTile[mapNum][iIndex] = ITileSetup(31, 42, 1);
		gp.iTile[mapNum][iIndex] = ITileSetup(63, 70, 1);
		
		mapNum = 80;
		iIndex = 0;
		gp.iTile[mapNum][iIndex] = ITileSetup(26, 15, 0);
		gp.iTile[mapNum][iIndex] = ITileSetup(35, 48, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(35, 49, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(35, 50, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(32, 53, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(31, 53, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(37, 52, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(38, 52, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(39, 52, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(46, 52, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(47, 52, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(48, 52, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(50, 54, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(50, 55, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(55, 59, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(56, 59, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(59, 58, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(59, 57, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(70, 55, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(71, 55, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(72, 55, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(45, 60, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(46, 60, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(34, 64, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(33, 64, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(22, 69, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(21, 69, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(31, 71, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(32, 71, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(42, 74, 4);
		gp.iTile[mapNum][iIndex] = ITileSetup(43, 74, 4);
	}

	public void updateNPC() {
		boolean[] flags = gp.player.p.flags;
		// flags[0] is true after walking into first gate
		// flags[1] is true after beating Scott 1
		// flags[2] is true after beating Rick 1
		// flags[3] is true after beating all TN Grunts in the office
		// flags[4] is true after beating Scott 2
		// flags[5] is true after beating Fred 2
		// flags[6] is true after key A
		// flags[7] is true after key B
		// flags[8] is true after clearing room A
		// flags[9] is true after clearing room B
		// flags[10] is true after getting gift starter
		// flags[11] is true after getting gift dog
		// flags[12] is true after getting gift magic pokemon
		// flags[13] is true after getting gift fossil/ancient pokemon
		// flags[13] is true after getting gift "starter" pokemon
		// flags[14] is true after beating Fred 3
		// flags[15] is true after talking to Grandpa
		// flags[16] is true after beating Gym 5
		if (!flags[0] || flags[1]) gp.npc[0][0] = null;
		if (flags[0] && !flags[1]) gp.npc[0][0] = NPCSetup(10, 72, 48, 0);
		if (flags[1]) gp.npc[3][0] = null;
		if (flags[2]) gp.npc[4][1] = null;
		if (flags[3]) {
			gp.npc[17][6] = null;
			gp.npc[17][7] = null;
		}
		if (flags[4]) gp.npc[13][0] = null;
		if (flags[5]) gp.npc[28][9] = null;
		
		if (flags[7]) gp.npc[41][0] = null;
		if (flags[6]) gp.npc[41][1] = null;
		if (flags[8] && flags[9]) gp.npc[38][1] = null;
	}
	
	

	private Entity NPCSetup(int type, int x, int y, int team) {
		Entity result = null;
		switch (type) {
		case 0:
			result = new NPC_PC(gp);
			break;
		case 1:
			result = new NPC_Nurse(gp, "down");
			break;
		case 2:
			result = new NPC_Clerk(gp);
			break;
		case 3:
			result = new NPC_Trainer(gp, "down", team);
			break;
		case 4:
			result = new NPC_Trainer(gp, "up", team);
			break;
		case 5:
			result = new NPC_Trainer(gp, "left", team);
			break;
		case 6:
			result = new NPC_Trainer(gp, "right", team);
			break;
		case 7:
			result = new NPC_Nurse(gp, "up");
			break;
		case 8:
			result = new NPC_GymLeader(gp, "down", team);
			break;
		case 9:
			result = new NPC_Rival(gp, "down", team); // scott down
			break;
		case 10:
			result = new NPC_Rival(gp, "up", team); // scott up
			break;
		case 11:
			result = new NPC_TN(gp, "down", team);
			break;
		case 12:
			result = new NPC_TN(gp, "up", team);
			break;
		case 13:
			result = new NPC_TN(gp, "left", team);
			break;
		case 14:
			result = new NPC_TN(gp, "right", team);
			break;
		case 15:
			result = new NPC_Rival2(gp, "down", team); // fred down
			break;
		case 16:
			result = new NPC_Rival2(gp, "up", team); // fred up
			break;
		case 17:
			result = new NPC_Market(gp);
			break;
			
		}
		
		result.worldX = gp.tileSize*x;
		result.worldY = gp.tileSize*y;
		
		index++;
		
		return result;
	}
	
	private Entity NPCSetup(int x, int y, String message) {
		Entity result = new NPC_Block(gp, message, false);
		
		result.worldX = gp.tileSize*x;
		result.worldY = gp.tileSize*y;
		
		index++;
		
		return result;
	}
	
	private Entity NPCSetup(int x, int y, String message, boolean a) {
		Entity result = new NPC_Block(gp, message, a);
		
		result.worldX = gp.tileSize*x;
		result.worldY = gp.tileSize*y;
		
		index++;
		
		return result;
	}
	
	private ItemObj ObjSetup(int x, int y, int id, int mapNum) {
		if (gp.player.p.itemsCollected[mapNum][objIndex] == true) {
			objIndex++;
			return null;
		}
		
		ItemObj result = new ItemObj(gp);
		
		result.worldX = gp.tileSize*x;
		result.worldY = gp.tileSize*y;
		result.item = new Item(id);
		
		objIndex++;
		
		return result;
		
		
	}
	
	private InteractiveTile ITileSetup(int x, int y, int type) {
		InteractiveTile result = null;
		switch (type) {
		case 0:
			result = new Cut_Tree(gp);
			break;
		case 1:
			result = new Rock_Smash(gp);
			break;
		case 2:
			result = new Tree_Stump(gp);
			break;
		case 3:
			result = new GymBarrier(gp);
			break;
		case 4:
			result = new Vine_Crossable(gp);
			break;
		case 5:
			result = new Vine(gp);
			break;
		case 6:
			break;
		}
		
		result.worldX = gp.tileSize*x;
		result.worldY = gp.tileSize*y;
		
		iIndex++;
		
		return result;
	}
}