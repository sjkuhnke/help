package Swing;

import java.util.ArrayList;

public enum Move {
	ABDUCT(0,100,0,0,2,0,PType.GALACTIC,"Abducts the foe and forces their next move to be used on themselves. Can be used once every other turn",false),
	ABSORB(20,100,0,0,1,0,PType.GRASS,"Heals 50% of damage dealt to foe",false),
	ACCELEROCK(40,100,0,0,0,1,PType.ROCK,"Always goes first",true),
	ACID(40,100,10,0,1,0,PType.POISON,"% chance to lower foe's Sp.Def by 1",false),
	ACID_ARMOR(0,1000,0,0,2,0,PType.POISON,"Raises user's Defense by 2",false),
	ACID_SPRAY(40,100,100,0,1,0,PType.POISON,"% chance to lower foe's Sp.Def by 2",false),
	ACROBATICS(90,90,30,0,0,0,PType.FLYING,"% chance of causing foe to flinch",true),
	AERIAL_ACE(60,1000,0,0,0,0,PType.FLYING,"This attack always hits",true),
	AEROBLAST(100,95,0,1,1,0,PType.FLYING,"Boosted Crit Rate",false),
	AGILITY(0,1000,0,0,2,0,PType.FLYING,"Raises user's Speed by 2",false),
	AIR_CUTTER(55,95,0,1,1,0,PType.FLYING,"Boosted Crit Rate",false),
	AIR_SLASH(75,95,30,0,1,0,PType.FLYING,"% chance of causing foe to flinch",false),
	AMNESIA(0,1000,0,0,2,0,PType.PSYCHIC,"Raises user's Sp.Def by 2",false),
	ANCIENT_POWER(60,100,10,0,1,0,PType.ROCK,"% chance to raise all of the user's stats by 1",false),
	AQUA_JET(40,100,0,0,0,1,PType.WATER,"Always goes first",true),
	AQUA_RING(0,1000,0,0,2,0,PType.WATER,"Restores a small amount of HP at the end of every turn",false),
	AQUA_TAIL(90,90,0,0,0,0,PType.WATER,"A normal attack",true),
	AROMATHERAPY(0,1000,0,0,2,0,PType.GRASS,"Cures team of any status conditions",false),
	//ASSURANCE(50,100,0,0,0,0,PType.DARK,"A normal attack",false),
	ASTONISH(30,100,30,0,0,0,PType.GHOST,"% chance of causing foe to flinch",true),
	AURORA_VEIL(0,1000,0,0,2,0,PType.ICE,"Can only be used in SNOW, reduces both physical and special damage recieved for 5 turns",false),
	AURA_SPHERE(90,1000,0,0,1,0,PType.FIGHTING,"This attack always hits",false),
	//AUTO_SHOT(0,1000,0,0,2,0,PType.STEEL,"Causes all of user's \"Shooting\" moves to hit twice",false),
	AURORA_BEAM(75,100,10,0,1,0,PType.ICE,"% chance to lower foe's Attack by 1",false),
	AUTOMOTIZE(0,1000,0,0,2,0,PType.STEEL,"Raises user's Speed by 2",false),
	BABY$DOLL_EYES(0,100,0,0,2,1,PType.LIGHT,"",false),
	//BAWL(0,100,0,0,2,0,PType.DARK,"Lowers foe's Attack by 2",false),
	BEAT_UP(10,100,0,0,0,0,PType.DARK,"Attacks once per healthy Pokemon on your team",false),
	BEEFY_BASH(100,85,50,0,0,-1,PType.FIGHTING,"% chance to paralyze foe, moves last",true),
	BELCH(120,100,0,0,1,0,PType.POISON,"Only works on the first turn out",false),
	//BIG_BULLET(70,90,30,0,0,0,PType.STEEL,"% chance to Paralyze foe",false),
	BIND(15,85,100,0,0,0,PType.NORMAL,"",true),
	BITE(60,100,30,0,0,0,PType.DARK,"% chance of causing foe to flinch",true),
	BITTER_MALICE(75,100,30,0,1,0,PType.GHOST,"% chance to Frostbite foe",false),
	//BLACK_HOLE(90,90,100,0,1,0,PType.DARK,"% chance of lowering foe's Accuracy by 1",false),
	BLACK_HOLE_ECLIPSE(140,100,100,0,1,0,PType.GALACTIC,"",false),
	BLAZE_KICK(90,100,10,1,0,0,PType.FIRE,"",true),
	BLAST_BURN(150,90,0,0,1,0,PType.FIRE,"User must rest after using this move",false), // recharge
	//BLAST_FLAME(100,100,100,0,1,0,PType.FIRE,"% chance to Burn foe",false),
	//BLAZING_SWORD(90,90,50,0,0,0,PType.FIRE,"% chance to Burn foe",false),
	//BLIND(0,100,0,0,2,0,PType.NORMAL,"Lowers foe's Accuracy by 2",false),
	BLIZZARD(110,70,20,0,1,0,PType.ICE,"",false),
	BLUE_FLARE(130,85,20,0,1,0,PType.FIRE,"% chance to Burn foe",false),
	BODY_PRESS(80,100,0,0,0,0,PType.FIGHTING,"",true),
	BODY_SLAM(85,100,30,0,0,0,PType.NORMAL,"% chance to Paralyze foe",true),
	BOLT_STRIKE(130,85,20,0,0,0,PType.ELECTRIC,"% chance to Paralyze foe",true),
	//BOULDER_CRUSH(85,80,50,0,0,0,PType.ROCK,"% chance of causing foe to flinch",false),
	//BOULDER_SLAM(70,100,0,0,0,0,PType.ROCK,"A normal attack",false),
	BOUNCE(85,85,30,0,0,0,PType.FLYING,"% chance to Paralyze foe",true),
	//BRANCH_WHACK(50,95,0,0,0,0,PType.ROCK,"A normal attack",false),
	BRANCH_POKE(40,100,0,0,0,0,PType.GRASS,"",true),
	BRAVE_BIRD(120,100,0,0,0,0,PType.FLYING,"User takes 1/3 of damage inflicted",true), // recoil
	BREAKING_SWIPE(60,100,100,0,0,0,PType.DRAGON,"",true),
	BRICK_BREAK(75,100,100,0,0,0,PType.FIGHTING,"Breaks Screen effects",true),
	BRINE(-1,100,0,0,1,0,PType.WATER,"Damage is doubled if foe is below 50% HP",false), 
	BRUTAL_SWING(60,100,0,0,0,0,PType.DARK,"A normal attack",true),
	BUBBLE(20,100,0,0,1,0,PType.WATER,"A normal attack",false),
	BUBBLEBEAM(65,100,10,0,1,0,PType.WATER,"% to lower foe's Speed by 1",false),
	BUG_BITE(60,100,0,0,0,0,PType.BUG,"A normal attack",true),
	BUG_BUZZ(90,100,10,0,1,0,PType.BUG,"% chance to lower foe's Sp.Def by 1",false),
	BULK_UP(0,1000,0,0,2,0,PType.FIGHTING,"Raises user's Attack and Defense by 1",false),
	BULLDOZE(60,100,100,0,0,0,PType.GROUND,"",false),
	BULLET_PUNCH(40,100,0,0,0,1,PType.STEEL,"Always goes first",true),
	BURN_UP(130,100,100,0,0,0,PType.FIRE,"",false),
	//BUZZ(0,100,0,0,2,0,PType.BUG,"Confuses foe",false),
	CALM_MIND(0,1000,0,0,2,0,PType.MAGIC,"Raises user's Sp.Atk and Sp.Def by 1",false),
	CHANNELING_BLOW(65,100,0,3,0,0,PType.FIGHTING,"",true),
	CHARGE(0,1000,0,0,2,0,PType.ELECTRIC,"User's next electric-type attack damage is doubled. Raises user's Sp.Def by 1",false),
	CHARGE_BEAM(50,90,50,0,1,0,PType.ELECTRIC,"",false),
	CHARM(0,100,0,0,2,0,PType.LIGHT,"Lowers foe's Attack by 2",false),
	CIRCLE_THROW(60,90,100,0,0,-6,PType.FIGHTING,"",true),
	//CHOMP(70,100,30,0,0,0,PType.DARK,"% chance to lower foe's Speed by 1",false),
	CLOSE_COMBAT(120,100,100,0,0,0,PType.FIGHTING,"Lowers user's Defense and Sp.Def by 1",true),
	COIL(0,1000,0,0,2,0,PType.POISON,"Raises user's Atk, Def, and Acc by 1",false),
	COMET_CRASH(-1,90,0,0,0,0,PType.GALACTIC,"Damage is doubled if user's HP is full",true),
	COMET_PUNCH(55,100,0,0,0,0,PType.GALACTIC,"A normal attack",true),
	CONFUSE_RAY(0,100,0,0,2,0,PType.GHOST,"Confuses foe",false),
	CONFUSION(50,100,10,0,1,0,PType.PSYCHIC,"% chance to Confuse foe",false),
	//CONSTRICT(10,100,50,0,0,0,PType.NORMAL,"% chance to lower foe's Speed by 1",false),
	CORE_ENFORCER(100,100,10,0,1,0,PType.GALACTIC,"",false),
	COSMIC_POWER(0,1000,0,0,2,0,PType.GALACTIC,"Raises user's Def and Sp.Def by 1",false),
	COTTON_GUARD(0,1000,0,0,2,0,PType.GRASS,"Raises user's Defense by 3",false),
	//COUNTER(-1,100,0,0,0,-5,PType.FIGHTING,"",false),
	CROSS_CHOP(100,80,0,1,0,0,PType.FIGHTING,"",true),
	CROSS_POISON(90,100,10,1,0,0,PType.POISON,"% chance to Poison foe, boosted Crit rate",true),
	CRUNCH(80,100,30,0,0,0,PType.DARK,"% chance to lower foe's Defense by 1",true),
	CURSE(0,100,0,0,2,0,PType.GHOST,"User loses half of its total HP. In exchance, foe takes 1/4 of its max HP at the end of every turn",false),
	DARK_PULSE(80,100,30,0,1,0,PType.DARK,"% chance of causing foe to flinch",false),
	DARKEST_LARIAT(85,100,0,0,0,0,PType.DARK,"",true),
	DAZZLING_GLEAM(80,100,0,0,1,0,PType.LIGHT,"",false),
	DEEP_SEA_BUBBLE(100,100,0,0,1,0,PType.WATER,"A normal attack. Turns into Draco Meteor when used by Kissyfishy-D",false),
	//DARK_VOID(0,80,0,0,2,0,PType.DARK,"Foe falls asleep",false),
	DEFENSE_CURL(0,1000,0,0,2,0,PType.NORMAL,"Raises user's Defense by 1",false),
	DEFOG(0,1000,0,0,2,0,PType.FLYING,"",false),
	DESOLATE_VOID(65,85,50,0,1,0,PType.GALACTIC,"",false),
	DESTINY_BOND(0,1000,0,0,2,1,PType.GHOST,"Always goes first; can't be used twice in a row. If foe knocks out user the same turn, foe faints as well",false),
	//DISAPPEAR(0,1000,50,0,2,0,PType.GHOST,"% chance to Confuse foe; raises user's Evasion by 2",false),
	DETECT(0,1000,0,0,2,4,PType.FIGHTING,"",false),
	DIAMOND_STORM(100,95,50,0,0,0,PType.FIGHTING,"",false),
	DIG(80,100,0,0,0,0,PType.GROUND,"",true),
	DISCHARGE(80,100,30,0,1,0,PType.ELECTRIC,"% chance to Paralyze foe",false),
	DIVE(80,100,0,0,0,0,PType.WATER,"A normal attack",true),
	//DOUBLE_BLAST(-1,60,30,0,1,0,PType.NORMAL,"% chance to Confuse foe",false),
	//DOUBLE$EDGE(120,100,0,0,0,0,PType.NORMAL,"User takes 1/3 of damage inflicted",false),
	DOUBLE_HIT(35,90,0,0,0,0,PType.NORMAL,"Attacks twice",true),
	//DOUBLE_JET(-1,85,0,0,0,0,PType.WATER,"Attacks 2-5 times",false),
	DOUBLE_KICK(30,100,0,0,0,0,PType.FIGHTING,"Attacks twice",true),
	//DOUBLE_PUNCH(-1,85,0,0,0,0,PType.FIGHTING,"Attacks twice",false),
	DOUBLE_SLAP(15,85,0,0,0,0,PType.NORMAL,"Attacks 2-5 times",true),
	//DOUBLE_SLICE(-1,80,15,0,0,0,PType.STEEL,"% to cause foe to Bleed; attacks twice",false),
	DOUBLE_TEAM(0,1000,0,0,2,0,PType.NORMAL,"Raises user's Evasion by 1",false),
	DRACO_METEOR(140,100,100,0,1,0,PType.DRAGON,"% to lower user's Sp.Atk by 2",false),
	DRAGON_BREATH(60,100,30,0,1,0,PType.DRAGON,"% chance to Paralyze foe",false),
	DRAGON_CLAW(80,100,0,1,0,0,PType.DRAGON,"Boosted Crit rate",true),
	DRAGON_DANCE(0,1000,0,0,2,0,PType.DRAGON,"Raises user's Attack and Speed by 1",false),
	DRAGON_DARTS(50,100,0,0,0,0,PType.DRAGON,"",false),
	DRAGON_PULSE(85,100,0,0,1,0,PType.DRAGON,"A normal attack",false),
	DRAGON_RAGE(0,100,0,0,1,0,PType.DRAGON,"Always does 40 HP damage",false),
	DRAGON_RUSH(100,75,20,0,0,0,PType.DRAGON,"% chance of causing foe to flinch",true),
	DRAGON_TAIL(60,90,100,0,0,-6,PType.DRAGON,"",true),
	DRAIN_PUNCH(75,100,0,0,0,0,PType.FIGHTING,"",true),
	DRAINING_KISS(50,100,0,0,1,0,PType.LIGHT,"",true),
	DREAM_EATER(100,100,0,0,1,0,PType.PSYCHIC,"Only works if target is asleep. Heals 50% of damage dealt to foe",false),
	DRILL_PECK(80,100,0,1,0,0,PType.FLYING,"Boosted Crit rate",true),
	DRILL_RUN(80,95,0,1,0,0,PType.GROUND,"Boosted Crit rate",true),
	DUAL_CHOP(40,90,0,0,0,0,PType.DRAGON,"",true),
	DYNAMIC_PUNCH(100,50,100,0,0,0,PType.FIGHTING,"% chance to confuse foe",false),
	EARTH_POWER(90,100,10,0,1,0,PType.GROUND,"% chance to lower foe's Sp.Def by 1",false),
	EARTHQUAKE(100,100,0,0,0,0,PType.GROUND,"A normal attack",false),
	ELECTRIC_TERRAIN(0,1000,0,0,2,0,PType.ELECTRIC,"Sets the terrain to ELECTRIC for 5 turns",false),
	ELECTRO_BALL(-1,100,0,0,1,0,PType.ELECTRIC,"Power is higher the faster the user is than the target",false),
	//ELECTROEXPLOSION(300,100,0,0,1,0,PType.ELECTRIC,"User faints. Bypasses Ground's immunity to Electric",false),
	ELEMENTAL_SPARKLE(45,90,0,0,1,0,PType.MAGIC,"",false),
	EMBER(40,100,10,0,1,0,PType.FIRE,"% chance to Burn foe",false),
	ENCORE(0,100,0,0,2,0,PType.NORMAL,"",false),
	ENDEAVOR(0,100,0,0,0,0,PType.NORMAL,"",true),
	ENDURE(0,1000,0,0,2,4,PType.NORMAL,"",false),
	ENERGY_BALL(90,100,10,0,1,0,PType.GRASS,"",false),
	ENTRAINMENT(0,100,0,0,2,0,PType.NORMAL,"Changes foe's ability to the user's",false),
	ERUPTION(-1,100,0,0,1,0,PType.FIRE,"Power is higher the more HP the user has",false),
	EXPANDING_FORCE(-1,100,0,0,1,0,PType.PSYCHIC,"Power is stronger if the terrain is PSYCHIC",false),
	EXPLOSION(250,100,0,0,0,0,PType.NORMAL,"User faints",false),
	EXTRASENSORY(80,100,10,0,1,0,PType.PSYCHIC,"",false),
	METRONOME(-1,1000,0,0,1,0,PType.MAGIC,"Selects a random move!",false),
	EXTREME_SPEED(80,100,0,0,0,2,PType.NORMAL,"Always goes first",true),
	FAKE_OUT(40,100,100,0,0,3,PType.NORMAL,"",true),
	FAKE_TEARS(0,100,0,0,2,0,PType.DARK,"Lowers foe's Sp.Def by 2",false),
	FAILED_SUCKER(0,100,0,0,0,0,PType.DARK,"If you're seeing this, something went horribly wrong",false),
	FALSE_SURRENDER(80,1000,0,0,0,0,PType.DARK,"",true),
	FATAL_BIND(70,85,100,0,0,0,PType.BUG,"Causes foe to faint in 3 turns",true),
	FEATHER_DANCE(0,100,0,0,2,0,PType.FLYING,"Lowers foe's Attack by 2",false),
	FEINT(30,100,0,0,0,2,PType.NORMAL,"",false),
	FEINT_ATTACK(60,1000,0,0,0,0,PType.DARK,"This attack always hits",true),
	FALSE_SWIPE(40,100,0,0,0,0,PType.NORMAL,"Always leaves the foe with at least 1 HP",true),
	FELL_STINGER(50,100,0,0,0,0,PType.BUG,"",true),
	FIERY_DANCE(80,100,50,0,2,0,PType.FIRE,"",false),
	FIRE_BLAST(120,85,10,0,1,0,PType.FIRE,"% chance to Burn foe",false),
	//FIRE_CHARGE(75,90,10,0,0,0,PType.FIRE,"% of flinching and/or Burning foe",false),
	//FIRE_DASH(0,100,100,0,0,0,PType.FIRE,"% to Burn foe, user faints. Damage equals user's remaining HP",false),
	FIRE_FANG(65,95,10,0,0,0,PType.FIRE,"% of flinching and/or Burning foe",true),
	FIRE_PUNCH(75,100,10,0,0,0,PType.FIRE,"% to Burn foe",true),
	FIRE_SPIN(35,85,100,0,1,0,PType.FIRE,"% to spin foe for 2-5 turns. While foe is spun, it takes 1/16 HP in damage, and cannot switch",false),
	//FIRE_TAIL(85,90,10,0,0,0,PType.FIRE,"% to Burn foe",false),
	//FIREBALL(-1,100,10,0,1,0,PType.FIRE,"% chance to Burn foe, damage is doubled if foe is Burned",false),
	FIRST_IMPRESSION(90,100,0,0,0,1,PType.BUG,"Always attacks first, fails after the first turn a user is out in battle",true),
	FISSURE(0,30,0,0,0,0,PType.GROUND,"",false),
	FLAIL(-1,100,0,0,0,0,PType.NORMAL,"Power is higher the lower HP the user has",true),
	FLAME_BURST(70,100,0,0,1,0,PType.FIRE,"A normal attack",false),
	FLAME_CHARGE(50,100,100,0,0,0,PType.FIRE,"",true),
	FLAME_WHEEL(70,100,10,0,0,0,PType.FIRE,"% to Burn foe",true),
	FLAMETHROWER(90,100,10,0,1,0,PType.FIRE,"% to Burn foe",false),
	FLARE_BLITZ(120,100,10,0,0,0,PType.FIRE,"% to Burn foe, user takes 1/3 of damage inflicted",true),
	FLASH(0,100,0,0,2,0,PType.LIGHT,"Lowers foe's Accuracy by 1, and raises user's Sp.Atk by 1",false),
	FLASH_CANNON(80,100,10,0,1,0,PType.STEEL,"% chance to lower foe's Sp.Def by 1",false),
	FLASH_RAY(40,100,50,0,1,0,PType.LIGHT,"",false),
	FLATTER(0,100,100,0,2,0,PType.DARK,"Confuses foe, and raises their Sp.Atk by 2",false),
	FLY(100,100,0,0,0,0,PType.FLYING,"A normal attack",true),
	FOCUS_BLAST(120,70,0,0,1,0,PType.FIGHTING,"",false),
	FOCUS_ENERGY(0,1000,0,0,2,0,PType.NORMAL,"",false),
	FORCE_PALM(60,100,30,0,0,0,PType.FIGHTING,"",true),
	FORESIGHT(0,1000,0,0,2,0,PType.MAGIC,"Indentifies foe, replacing their Ghost typing with Normal if they have it. It also raises user's Accuracy by 1 stage",false),
	FORESTS_CURSE(0,100,0,0,2,0,PType.GRASS,"",false),
	FOUL_PLAY(95,100,0,0,0,0,PType.DARK,"",true),
	FREEZE$DRY(70,100,10,0,1,0,PType.ICE,"",false),
	FREEZING_GLARE(90,100,20,0,1,0,PType.PSYCHIC,"",false),
	FRENZY_PLANT(150,90,0,0,1,0,PType.GRASS,"User must rest after using this move",false),
	FRUSTRATION(-1,100,0,0,0,0,PType.NORMAL,"A normal attack",true),
	FURY_ATTACK(15,85,0,0,0,0,PType.NORMAL,"Attacks 2-5 times",true),
	FURY_CUTTER(-1,95,0,0,0,0,PType.BUG,"Power increases the more times this move is used in succession",true),
	FURY_SWIPES(18,80,0,0,0,0,PType.NORMAL,"Attacks 2-5 times",true),
	FUSION_BOLT(100,100,0,0,0,0,PType.ELECTRIC,"",false),
	FUSION_FLARE(100,100,0,0,1,0,PType.FIRE,"",false),
	//GALAXY_ATTACK(115,90,30,0,0,0,PType.MAGIC,"% chance to inflict the foe with a random Status condition",false),
	GALAXY_BLAST(90,100,0,0,1,0,PType.GALACTIC,"",false),
	GASTRO_ACID(0,100,0,0,2,0,PType.POISON,"",false),
	GENESIS_SUPERNOVA(120,95,0,0,1,0,PType.GALACTIC,"",false),
	GEOMANCY(0,1000,0,0,2,0,PType.LIGHT,"",false),
	GIGA_DRAIN(75,100,0,0,1,0,PType.GRASS,"Heals 50% of damage dealt to foe",false),
	//GIGA_HIT(110,75,50,0,0,0,PType.FIGHTING,"% chance to Paralyze foe",false),
	GIGA_IMPACT(150,90,0,0,0,0,PType.NORMAL,"User must rest after using this move",true),
	GLACIATE(65,95,100,0,1,0,PType.ICE,"",false),
	GLARE(0,100,0,0,2,0,PType.NORMAL,"Paralyzes foe",false),
	GLITTER_DANCE(0,1000,0,0,2,0,PType.LIGHT,"Raises user's Sp.Atk and Speed by 1",false),
	GLITTERING_SWORD(95,100,20,0,0,0,PType.LIGHT,"",true),
	GLITTERING_TORNADO(55,100,30,0,1,0,PType.LIGHT,"",false),
	GLITZY_GLOW(80,100,30,0,1,0,PType.LIGHT,"",false),
	GRASS_KNOT(-1,100,0,0,1,0,PType.GRASS,"A normal attack",true),
	GRASS_WHISTLE(0,55,0,0,2,0,PType.GRASS,"",false),
	GRASSY_TERRAIN(0,1000,0,0,2,0,PType.GRASS,"Sets the terrain to GRASSY for 5 turns",false),
	//GRASS_PUNCH(80,100,0,0,0,0,PType.GRASS,"A normal attack",false),
	GRAVITY(0,1000,0,0,2,0,PType.GALACTIC,"Sets GRAVITY for 5 turns",false),
	GROWL(0,100,0,0,2,0,PType.NORMAL,"Lowers foe's Attack by 1",false),
	GROWTH(0,1000,0,0,2,0,PType.GRASS,"Raises user's Attack and Sp.Atk by 1",false),
	GUILLOTINE(0,30,0,0,0,0,PType.NORMAL,"",true),
	GUNK_SHOT(120,70,30,0,1,0,PType.POISON,"% chance to Poison foe",false),
	//GUNSHOT(70,60,0,2,0,0,PType.STEEL,"25% chance to Crit. If it Crits, foe is Bleeding",false),
	GUST(40,100,0,0,1,0,PType.FLYING,"A normal attack",false),
	GYRO_BALL(-1,100,0,0,0,0,PType.STEEL,"The lower the user's speed compared to the foe, the more power",true),
	SNOWSCAPE(0,1000,0,0,2,0,PType.ICE,"Sets the weather to SNOW for 5 turns",false),
	HAMMER_ARM(100,90,100,0,0,0,PType.FIGHTING,"% chance to lower user's speed by 1",true),
	HARDEN(0,1000,0,0,2,0,PType.NORMAL,"Raises user's Defense by 1",false),
	HAZE(0,1000,0,0,2,0,PType.ICE,"Clears all stat changes on the field",false),
	HEAD_SMASH(150,80,0,0,0,0,PType.ROCK,"User takes 1/3 of damage inflicted",true),
	HEADBUTT(70,100,30,0,0,0,PType.NORMAL,"% chance of causing foe to flinch",true),
	HEAL_PULSE(0,1000,0,0,2,0,PType.PSYCHIC,"Heals foe by 50% HP",false),
	HEALING_WISH(0,1000,0,0,2,0,PType.PSYCHIC,"",false),
	HEAT_CRASH(-1,100,0,0,0,0,PType.FIRE,"",true),
	HEAT_WAVE(95,90,10,0,1,0,PType.FIRE,"% to Burn foe",false),
	HEAVY_SLAM(-1,100,0,0,0,0,PType.STEEL,"",true),
	HEX(-1,100,0,0,1,0,PType.GHOST,"",false),
	HI_JUMP_KICK(130,90,0,0,0,0,PType.FIGHTING,"If this attack misses, user takes 50% of its max HP",true),
	HIDDEN_POWER(60,100,0,0,1,0,PType.NORMAL,"",false),
	HONE_CLAWS(0,1000,0,0,2,0,PType.DARK,"Raises user's Attack and Accuracy by 1",false),
	HORN_ATTACK(65,100,0,0,0,0,PType.NORMAL,"A normal attack",false), // recharge
	HORN_DRILL(0,30,0,0,0,0,PType.NORMAL,"If this move hits, it always K.Os foe",true),
	HORN_LEECH(75,100,0,0,0,0,PType.GRASS,"",true),
	HOWL(0,1000,0,0,2,0,PType.NORMAL,"Raises user's Attack by 1",false),
	HURRICANE(110,70,30,0,1,0,PType.FLYING,"",false),
	HYDRO_CANNON(150,90,0,0,1,0,PType.WATER,"User must rest after using this move",false),
	HYDRO_PUMP(110,80,0,0,1,0,PType.WATER,"A normal attack",false),
	HYPER_BEAM(150,90,0,0,1,0,PType.NORMAL,"User must rest after using this move",false),
	HYPER_FANG(80,90,10,0,0,0,PType.NORMAL,"% of causing foe to flinch",true),
	HYPER_VOICE(90,100,0,0,1,0,PType.NORMAL,"A normal attack",true),
	HYPNOSIS(0,60,0,0,2,0,PType.PSYCHIC,"Causes foe to sleep",false),
	ICE_BALL(-1,90,0,0,0,0,PType.ICE,"",true),
	ICE_BEAM(90,100,10,0,1,0,PType.ICE,"",false),
	ICE_FANG(65,95,10,0,0,0,PType.ICE,"",true),
	ICE_PUNCH(75,100,10,0,0,0,PType.ICE,"",true),
	ICE_SHARD(40,100,0,0,0,1,PType.ICE,"Always goes first",false),
	ICE_SPINNER(80,100,100,0,0,0,PType.ICE,"",true),
	ICICLE_CRASH(85,90,30,0,0,0,PType.ICE,"",false),
	ICICLE_SPEAR(25,100,0,0,0,0,PType.ICE,"",false),
	ICY_WIND(55,95,100,0,1,0,PType.ICE,"",false),
	//IGNITE(0,75,0,0,2,0,PType.FIRE,"Burns foe",false),
	INCINERATE(60,100,100,0,1,0,PType.FIRE,"% to lower foe's Sp. Def by 1",false),
	INFERNO(100,50,100,0,1,0,PType.FIRE,"",false),
	INFESTATION(20,100,100,0,1,0,PType.BUG,"",true),
	INGRAIN(0,1000,0,0,2,0,PType.GRASS,"",false),
	//INJECT(55,100,100,0,0,0,PType.BUG,"% to Poison foe, heals 50% of damage dealt",false),
	IRON_BLAST(85,90,30,0,1,0,PType.STEEL,"",false),
	IRON_DEFENSE(0,1000,0,0,2,0,PType.STEEL,"Raises user's Defense by 2",false),
	IRON_HEAD(80,100,30,0,0,0,PType.STEEL,"% of causing foe to flinch",true),
	IRON_TAIL(100,75,30,0,0,0,PType.STEEL,"% of lowering foe's Defense by 1",true),
	JAW_LOCK(80,100,100,0,0,0,PType.DARK,"",true),
	KARATE_CHOP(50,100,0,1,0,0,PType.FIGHTING,"Boosted Crit rate",true),
	LAVA_PLUME(80,100,30,0,1,0,PType.FIRE,"% to Burn foe",false),
	//LEAF_BALL(75,95,0,0,1,0,PType.GRASS,"A normal attack",false),
	LEAF_BLADE(90,100,0,1,0,0,PType.GRASS,"Boosted Crit rate",true),
	//LEAF_GUST(50,100,0,0,1,0,PType.GRASS,"A normal attack",false),
	//LEAF_KOBE(75,90,100,0,0,0,PType.GRASS,"% to Paralyze foe",false),
	//LEAF_PULSE(85,75,100,0,1,0,PType.GRASS,"% to lower foe's accuracy, 50% to cause foe to fall asleep",false),
	//LEAF_SLAP(30,100,0,0,0,0,PType.GRASS,"A normal attack",false),
	LEAF_STORM(130,90,100,0,1,0,PType.GRASS,"% to lower user's Sp.Atk by 2",false),
	LEAF_TORNADO(65,90,50,0,1,0,PType.GRASS,"% to lower foe's Accuracy by 1",false),
	LEAFAGE(40,100,0,0,0,0,PType.GRASS,"",false),
	LEECH_LIFE(80,100,0,0,0,0,PType.BUG,"Heals 50% of damage dealt",true), // recoil
	LEECH_SEED(0,90,0,0,2,0,PType.GRASS,"At the end of every turn, user steals 1/8 of foe's max HP",false),
	LEER(0,100,0,0,2,0,PType.NORMAL,"Lowers foe's Defense by 1",false),
	LICK(20,100,30,0,0,0,PType.GHOST,"% to Paralyze foe",true),
	//LIGHTNING_HEADBUTT(90,95,30,0,0,0,PType.ELECTRIC,"% of Paralysis and/or causing foe to flinch. User takes 1/3 of damage dealt as recoil",false),
	LIFE_DEW(0,1000,0,0,2,0,PType.WATER,"Restores 25% HP",false),
	LIGHT_BEAM(60,100,20,0,1,0,PType.LIGHT,"",false),
	LIGHT_OF_RUIN(140,90,0,0,1,0,PType.LIGHT,"",false),
	LIGHT_SCREEN(0,1000,0,0,2,0,PType.PSYCHIC,"",false),
	LIQUIDATION(85,100,20,0,0,0,PType.WATER,"",true),
	LOAD_FIREARMS(0,100,0,0,2,0,PType.STEEL,"",false),
	LOCK$ON(0,1000,0,0,2,0,PType.NORMAL,"Raises user's Accuracy by 6",false),
	LOVELY_KISS(0,75,0,0,2,0,PType.NORMAL,"",false),
	LOW_KICK(-1,100,0,0,0,0,PType.FIGHTING,"Damage is based on how heavy foe is",true),
	LOW_SWEEP(65,100,100,0,0,0,PType.FIGHTING,"",true),
	LUNAR_DANCE(0,1000,0,0,2,0,PType.PSYCHIC,"",false),
	LUSTER_PURGE(70,100,50,0,1,0,PType.LIGHT,"",false),
	MACH_PUNCH(40,100,0,0,0,1,PType.FIGHTING,"Always goes first",true),
	MACHETE_JAB(75,80,100,0,0,0,PType.STEEL,"% to lower foe's Attack by 1",true),
	MAGIC_BLAST(30,100,0,0,1,0,PType.MAGIC,"A random Rock, Ground or Grass move is also used",false),
	MAGIC_CRASH(110,80,100,0,0,0,PType.MAGIC,"% to inflict foe with a random Status condition. User must rest after using",true),
	MAGIC_FANG(70,95,75,0,0,0,PType.MAGIC,"% to flinch foe if this move is Super-Effective against it",true),
	MAGIC_POWDER(0,100,0,0,2,0,PType.MAGIC,"",false),
	MAGIC_REFLECT(0,1000,0,0,2,0,PType.MAGIC,"Foe's next attack will be reflected against them. Can be used every other turn",false),
	MAGIC_TOMB(90,100,0,0,1,0,PType.MAGIC,"A normal attack",true),
	MAGICAL_LEAF(60,1000,0,0,1,0,PType.GRASS,"This move will never miss",false),
	MAGNET_BOMB(60,1000,0,0,0,0,PType.STEEL,"",false),
	MAGNET_RISE(0,1000,0,0,2,0,PType.STEEL,"User will float for 5 turns, causing it to be immune to all Ground-type attacks",false),
	MAGNITUDE(-1,100,0,0,0,0,PType.GROUND,"A random Magnitude between 4-10 will be used, corresponding to its power",false),
	MEAN_LOOK(0,100,0,0,2,0,PType.NORMAL,"",false),
	MEGA_DRAIN(40,100,0,0,1,0,PType.GRASS,"Heals 50% of damage dealt",false),
	MEGAHORN(120,85,0,0,0,0,PType.BUG,"",true),
	MEMENTO(0,100,0,0,2,0,PType.DARK,"",false),
	METAL_CLAW(50,95,10,0,0,0,PType.STEEL,"",true),
	//MEGA_KICK(70,100,60,0,0,0,PType.FIGHTING,"% to Paralyze foe",true),
	//MEGA_PUNCH(70,100,60,0,0,0,PType.FIGHTING,"% to Paralyze foe",true),
	//MEGA_SWORD(70,100,60,0,0,0,PType.STEEL,"% to Paralyze foe",false),
	METAL_SOUND(0,100,0,0,2,0,PType.STEEL,"Lowers foe's Sp.Def by 2",false),
	METEOR_ASSAULT(120,100,100,0,0,0,PType.GALACTIC,"",false),
	METEOR_MASH(90,90,20,0,0,0,PType.STEEL,"",true),
	MINIMIZE(0,1000,0,0,2,0,PType.GHOST,"Raises user's Evasion by 2",false),
	MIRROR_SHOT(65,85,30,0,1,0,PType.STEEL,"",false),
	MIRROR_MOVE(0,1000,0,0,1,0,PType.FLYING,"Uses the move last used by the foe, fails if foe hasn't used a move yet",false),
	MIST_BALL(70,100,50,0,1,0,PType.PSYCHIC,"",false),
	MOLTEN_CONSUME(50,100,100,0,0,1,PType.FIRE,"% chance to Burn foe",true),
	MOLTEN_LAIR(0,100,0,0,2,0,PType.FIRE,"",false),
	MOLTEN_STEELSPIKE(100,90,30,0,1,0,PType.STEEL,"",false),
	MOONBLAST(95,100,30,0,1,0,PType.LIGHT,"",false),
	MOONLIGHT(0,1000,0,0,2,0,PType.LIGHT,"Restores 1/2 of user's max HP",false),
	MORNING_SUN(0,1000,0,0,2,0,PType.LIGHT,"",false),
	MUD_BOMB(65,85,30,0,1,0,PType.GROUND,"% to lower foe's Accuracy by 1",false),
	MUD_SHOT(55,95,100,0,1,0,PType.GROUND,"",false),
	MUD$SLAP(20,100,100,0,1,0,PType.GROUND,"% to lower foe's Accuracy by 1",false),
	MUD_SPORT(0,1000,0,0,2,0,PType.GROUND,"",false),
	MUDDY_WATER(90,85,30,0,1,0,PType.WATER,"",false),
	MYSTICAL_FIRE(75,100,100,0,1,0,PType.FIRE,"",false),
	NASTY_PLOT(0,1000,0,0,2,0,PType.DARK,"",false),
	NEEDLE_ARM(90,100,30,0,1,0,PType.GRASS,"",true),
	//NEEDLE_SPRAY(55,95,10,0,0,0,PType.POISON,"% to Poison or Paralyze foe",false),
	//NIBBLE(10,100,0,0,0,0,PType.NORMAL,"A normal attack",false),
	NIGHT_DAZE(85,95,40,0,0,0,PType.DARK,"",false),
	NIGHT_SHADE(0,100,0,0,1,0,PType.GHOST,"Deals damage equal to user's level",false),
	NIGHT_SLASH(70,100,0,1,0,0,PType.DARK,"Boosted Crit rate",true),
	NIGHTMARE(0,100,0,0,2,0,PType.GHOST,"Foe loses 1/4 of max HP each turn; wears off when foe wakes up",false),
	NO_RETREAT(0,1000,0,0,2,0,PType.FIGHTING,"",false),
	NOBLE_ROAR(0,100,0,0,2,0,PType.NORMAL,"",false),
	NUZZLE(20,100,100,0,0,0,PType.ELECTRIC,"",true),
	OBSTRUCT(0,1000,0,0,2,4,PType.DARK,"",false),
	ODOR_SLEUTH(0,1000,0,0,2,0,PType.NORMAL,"Indentifies foe, replacing their Ghost typing with Normal if they have it. It also lowers foe's Evasion by 1",false),
	OUTRAGE(120,100,0,0,0,0,PType.DRAGON,"User is locked into this move for 2-3 turns, Confuses user when the effect is done",true),
	OVERHEAT(140,90,100,0,1,0,PType.FIRE,"% to lower user's Sp.Atk by 2",false),
	PARABOLIC_CHARGE(65,100,0,0,1,0,PType.ELECTRIC,"",false),
	PAYBACK(-1,100,0,0,0,0,PType.DARK,"",true),
	PECK(35,100,0,0,0,0,PType.FLYING,"A normal attack",true),
	PERISH_SONG(0,1000,0,0,2,0,PType.GHOST,"All Pokemon hearing this song will faint in 3 turns",false),
	PETAL_BLIZZARD(90,100,0,0,0,0,PType.GRASS,"",false),
	PETAL_DANCE(120,100,0,0,1,0,PType.GRASS,"",true),
	PHANTOM_FORCE(100,100,0,0,0,0,PType.GHOST,"",true),
	PHOTON_GEYSER(130,90,100,0,1,0,PType.LIGHT,"",false),
	PIN_MISSILE(25,95,0,0,0,0,PType.BUG,"",false),
	PISTOL_POP(110,70,0,0,0,0,PType.STEEL,"",false),
	PLASMA_FISTS(100,100,0,0,0,0,PType.ELECTRIC,"",true),
	PLAY_NICE(0,100,0,0,2,0,PType.NORMAL,"",false),
	PLAY_ROUGH(90,90,10,0,0,0,PType.LIGHT,"",true),
	PLUCK(60,100,0,0,0,0,PType.FLYING,"",true),
	//PHASE_SHIFT(0,1000,0,0,2,0,PType.MAGIC,"Switches user's type to Magic and the type of the move that the foe just used",false),
	//POISON_BALL(65,80,100,0,0,0,PType.POISON,"% to Poison foe",false),
	POISON_FANG(50,100,50,0,0,0,PType.POISON,"% to Poison and/or flinch foe",true),
	POISON_GAS(0,80,0,0,2,0,PType.POISON,"Poisons foe",true),
	POISON_JAB(80,100,30,0,0,0,PType.POISON,"% to Poison foe",true),
	//POISON_POWDER(0,75,0,0,2,0,PType.POISON,"Poisons foe",false),
	POISON_STING(15,100,30,0,0,0,PType.POISON,"% chance to Poison foe",false),
	POISON_TAIL(85,100,10,1,0,0,PType.POISON,"% chance to Poison foe. Boosted crit rate",false),
	POP_POP(70,80,0,0,0,0,PType.STEEL,"",false),
	//POISONOUS_WATER(95,85,30,0,1,0,PType.POISON,"% chance to Poison foe",false),
	//POKE(10,100,0,0,0,0,PType.NORMAL,"A normal attack",false),
	POUND(40,100,0,0,0,0,PType.NORMAL,"A normal attack",true),
	POWDER_SNOW(40,100,30,0,1,0,PType.ICE,"",false),
	POWER_GEM(80,100,0,0,1,0,PType.ROCK,"",false),
	POWER_WHIP(120,85,0,0,0,0,PType.GRASS,"",true),
	POWER$UP_PUNCH(40,100,100,0,0,0,PType.FIGHTING,"",true),
	PRISMATIC_LASER(100,100,0,0,1,0,PType.LIGHT,"",false),
	PROTECT(0,1000,0,0,2,4,PType.NORMAL,"",false),
	PSYBEAM(65,100,10,0,1,0,PType.PSYCHIC,"",false),
	PSYCHIC(90,100,10,0,1,0,PType.PSYCHIC,"",false),
	PSYCHIC_FANGS(85,100,100,0,0,0,PType.PSYCHIC,"",true),
	PSYCHIC_TERRAIN(0,1000,0,0,2,0,PType.PSYCHIC,"",false),
	PSYCHO_CUT(70,100,0,1,0,0,PType.PSYCHIC,"Boosted Crit rate",false),
	PSYSHOCK(80,100,0,0,1,0,PType.PSYCHIC,"",false),
	PSYWAVE(0,100,0,0,1,0,PType.PSYCHIC,"",false),
	//PUNCH(40,90,0,0,0,0,PType.FIGHTING,"A normal attack",false),
	PURSUIT(40,100,0,0,0,0,PType.DARK,"A normal attack",true),
	QUICK_ATTACK(40,100,0,0,0,1,PType.NORMAL,"Always attacks first",true),
	QUIVER_DANCE(0,1000,0,0,2,0,PType.BUG,"",false),
	RAGE(-1,100,0,0,0,0,PType.NORMAL,"Power increases the more times this move is used in succession",true),
	RAIN_DANCE(0,1000,0,0,2,0,PType.WATER,"",false),
	RAPID_SPIN(20,100,100,0,0,0,PType.NORMAL,"% to raise user's Speed by 1, and frees user of being Spun",true),
	RAZOR_LEAF(55,95,0,1,0,0,PType.GRASS,"Boosted Crit rate",false),
	RAZOR_SHELL(75,95,50,0,0,0,PType.WATER,"",true),
	REBOOT(0,1000,0,0,2,0,PType.STEEL,"Clears user or any Status condition, and raises user's Speed by 1",false),
	RECOVER(0,1000,0,0,2,0,PType.NORMAL,"",false),
	RED$NOSE_BOOST(0,1000,0,0,2,0,PType.MAGIC,"",false),
	REFLECT(0,1000,0,0,2,0,PType.PSYCHIC,"",false),
	REST(0,1000,0,0,2,0,PType.PSYCHIC,"",false),
	RETURN(-1,100,0,0,0,0,PType.NORMAL,"",true),
	REVENGE(-1,100,0,0,0,0,PType.FIGHTING,"Power is doubled if user is slower than foe",true),
	REVERSAL(-1,100,0,0,2,0,PType.FIGHTING,"",true),
	ROAR(0,1000,0,0,2,-6,PType.NORMAL,"",false),
	//ROCK_BLADE(80,100,0,1,0,0,PType.ROCK,"Boosted Crit rate",false),
	ROCK_BLAST(25,90,0,0,0,0,PType.ROCK,"Hits 2-5 times",false),
	ROCK_POLISH(0,1000,0,0,2,0,PType.ROCK,"Raises user's Speed by 2",false),
	ROCK_SLIDE(75,90,30,0,0,0,PType.ROCK,"% of causing foe to flinch",false),
	ROCK_THROW(50,90,0,0,0,0,PType.ROCK,"A normal attack",false),
	ROCK_TOMB(60,95,100,0,0,0,PType.ROCK,"% to lower foe's Speed by 1",false),
	ROCK_WRECKER(150,90,0,0,0,0,PType.ROCK,"User takes 1/3 of damage dealt as recoil",false),
	ROCKFALL_FRENZY(75,95,100,0,1,0,PType.ROCK,"",false),
	//ROCKET(120,75,50,0,0,0,PType.STEEL,"% to Paralyze foe",false),
	ROLLOUT(-1,90,0,0,0,0,PType.ROCK,"Attacks up to 5 times, damage doubles each time. While active, user cannot switch out",true),
	ROOST(0,1000,0,0,2,0,PType.FLYING,"Restores 1/2 of user's max HP",false),
	//ROOT_CRUSH(105,90,100,0,0,0,PType.ROCK,"% to Paralyze foe",false),
	ROOT_KICK(60,95,0,0,0,0,PType.ROCK,"A normal attack",true),
	ROUND(60,100,0,0,1,0,PType.NORMAL,"",false),
	SACRED_FIRE(100,95,50,0,0,0,PType.FIRE,"",false),
	SACRED_SWORD(90,100,0,0,0,0,PType.FIGHTING,"",true),
	SAFEGUARD(0,1000,0,0,2,0,PType.NORMAL,"",false),
	SAND_ATTACK(0,100,0,0,2,0,PType.GROUND,"Lowers foe's Accuracy by 1",false),
	SANDSTORM(0,1000,0,0,2,0,PType.ROCK,"",false),
	SCALD(80,100,30,0,1,0,PType.WATER,"",false),
	SCALE_SHOT(25,90,100,0,2,0,PType.DRAGON,"",false),
	SCARY_FACE(0,100,0,0,2,0,PType.NORMAL,"Lowers foe's Speed by 2",false),
	SCORCHING_SANDS(70,100,30,0,1,0,PType.GROUND,"",false),
	SCRATCH(40,100,0,0,0,0,PType.NORMAL,"A normal attack",true),
	SCREECH(0,85,0,0,2,0,PType.NORMAL,"Lowers foe's Defense by 2",false),
	SEA_DRAGON(0,1000,0,0,2,0,PType.MAGIC,"",false),
	SEISMIC_TOSS(0,100,0,0,0,0,PType.FIGHTING,"Damage dealt is equal to the user's level",true),
	SELF$DESTRUCT(200,100,0,0,0,0,PType.NORMAL,"User faints",false),
	SHADOW_BALL(80,100,30,0,1,0,PType.GHOST,"% to lower foe's Sp.Def by 1",false),
	SHADOW_CLAW(80,100,0,1,0,0,PType.GHOST,"",true),
	SHADOW_PUNCH(80,1000,0,0,0,0,PType.GHOST,"",true), // TODO: give to Poov line
	SHADOW_SNEAK(40,100,0,0,0,1,PType.GHOST,"Always attacks first",true),
	SHEER_COLD(0,30,0,0,1,0,PType.ICE,"",false),
	//SHELL_BASH(70,100,0,1,0,0,PType.NORMAL,"User takes 1/3 of damage dealt as recoil",false),
	SHELL_SMASH(0,1000,0,0,2,0,PType.NORMAL,"Raises user's Attack, Sp.Atk, and Speed by 2, at the cost of lowering its Defense and Sp.Def by 1",false),
	SHIFT_GEAR(0,1000,0,0,2,0,PType.STEEL,"",false),
	//SHOCK(15,100,100,0,1,0,PType.ELECTRIC,"% to Paralyze foe",false),
	SHOCK_WAVE(60,1000,0,0,1,0,PType.ELECTRIC,"This attack never misses",false),
	SILVER_WIND(60,100,10,0,1,0,PType.BUG,"",false),
	//SHURIKEN(75,85,50,0,0,0,PType.STEEL,"% to cause foe to Bleed",false),
	SKULL_BASH(100,100,100,0,0,0,PType.NORMAL,"% to raise the user's Defense by 1, user must charge on the first turn",true),
	SKY_ATTACK(140,90,30,1,0,0,PType.FLYING,"% chance to flinch. User must charge up on the first turn, attacks on the second. Boosted Crit rate",false),
	SKY_UPPERCUT(85,90,0,0,0,0,PType.FIGHTING,"A normal attack",true),
	SLACK_OFF(0,1000,0,0,2,0,PType.NORMAL,"",false),
	SLAM(80,75,0,0,0,0,PType.NORMAL,"A normal attack",true),
	//SLAP(20,100,0,0,0,0,PType.NORMAL,"A normal attack",false),
	SLASH(70,100,0,1,0,0,PType.NORMAL,"Boosted Crit rate",true),
	SLEEP_POWDER(0,75,0,0,2,0,PType.GRASS,"Foe falls asleep",false),
	SLUDGE(75,100,30,0,1,0,PType.POISON,"% to Poison foe",false),
	SLUDGE_BOMB(90,100,30,0,1,0,PType.POISON,"% to Poison foe",false),
	SLUDGE_WAVE(95,100,10,0,1,0,PType.POISON,"",false),
	SMACK_DOWN(50,100,100,0,0,0,PType.ROCK,"",false),
	SMART_STRIKE(70,1000,0,0,0,0,PType.STEEL,"",false),
	//SMASH(70,90,0,0,0,0,PType.NORMAL,"A normal attack",false),
	SMOG(20,70,50,0,1,0,PType.POISON,"% to Poison foe",false),
	SMOKESCREEN(0,100,0,0,2,0,PType.NORMAL,"Lowers foe's accuracy by 1",false),
	SNARL(55,95,100,0,1,0,PType.DARK,"",false),
	SNORE(50,100,0,0,1,0,PType.NORMAL,"",false),
	SOLAR_BEAM(120,100,0,0,1,0,PType.GRASS,"User must charge up on the first turn, attacks on the second",false),
	SOLAR_BLADE(125,100,0,0,0,0,PType.GRASS,"",true),
	SPACE_BEAM(60,100,30,0,1,0,PType.GALACTIC,"",false),
	SPACIAL_REND(100,95,0,1,1,0,PType.GALACTIC,"",false),
	SPARK(65,100,30,0,0,0,PType.ELECTRIC,"% to Paralyze foe",true),
	SPARKLE_STRIKE(80,1000,0,0,0,0,PType.MAGIC,"",true),
	SPARKLING_ARIA(90,100,100,0,1,0,PType.WATER,"",false),
	SPARKLING_TERRAIN(0,1000,0,0,2,0,PType.MAGIC,"",false),
	SPARKLING_WATER(0,1000,0,0,2,0,PType.WATER,"Raises Sp.Def by 1. Turns into Sparkling Aria when used by Kissyfishy-D",false),
	SPARKLY_SWIRL(70,100,10,0,1,0,PType.MAGIC,"",false),
	SPECTRAL_THIEF(90,100,100,0,0,0,PType.GHOST,"",true),
	SPEEDY_SHURIKEN(40,100,0,0,0,1,PType.STEEL,"",false),
	SPIKE_CANNON(20,100,0,0,0,0,PType.NORMAL,"",false),
	//SPIKE_JAB(55,80,100,0,0,0,PType.POISON,"% to Poison foe",false),
	//SPIKE_SHOT(-1,100,0,0,0,0,PType.POISON,"Attacks 2-5 times",false),
	SPIKES(0,1000,0,0,2,0,PType.GROUND,"",false),
	//SPIKE_SLAM(65,90,0,0,0,0,PType.NORMAL,"A normal attack",false),
	SPIKY_SHIELD(0,1000,0,0,2,4,PType.GRASS,"",false),
	SPIRIT_BREAK(75,100,100,0,0,0,PType.LIGHT,"",true),
	SPLASH(0,1000,0,0,2,0,PType.NORMAL,"",false),
	STAR_STORM(110,85,0,0,1,0,PType.GALACTIC,"A normal attack",false),
	STAR_STRUCK_ARCHER(75,85,0,3,0,0,PType.GALACTIC,"",false),
	STEALTH_ROCK(0,1000,0,0,2,0,PType.ROCK,"",false),
	STEEL_BEAM(140,95,100,0,1,0,PType.STEEL,"",false),
	STEEL_WING(70,90,10,0,0,0,PType.STEEL,"",true),
	STICKY_WEB(0,1000,0,0,2,0,PType.BUG,"",false),
	STOCKPILE(0,1000,0,0,2,0,PType.NORMAL,"",false),
	//STARE(0,100,0,0,2,0,PType.NORMAL,"Confuses foe, but raises foe's Attack by 1",false), // recoil
	//STING(55,100,100,0,0,0,PType.BUG,"% to make foe Bleed",false),
	STOMP(65,100,30,0,0,0,PType.NORMAL,"% of causing foe to flinch",true),
	STONE_EDGE(100,80,0,1,0,0,PType.ROCK,"Boosted Crit rate",false),
	STRENGTH_SAP(0,100,0,0,2,0,PType.GRASS,"",false),
	STRENGTH(80,100,0,0,0,0,PType.NORMAL,"A normal attack",true),
	STRING_SHOT(0,100,0,0,2,0,PType.BUG,"Lowers foe's Speed by 2",false),
	STRUGGLE_BUG(50,100,100,0,1,0,PType.BUG,"",false),
	//STRONG_ARM(90,85,30,0,0,0,PType.FIGHTING,"% chance of Paralyzing and/or causing foe to flinch",false),
	STUN_SPORE(0,75,0,0,2,0,PType.GRASS,"",false),
	SUBMISSION(80,90,0,0,0,0,PType.FIGHTING,"",true),
	SUCKER_PUNCH(80,100,0,0,0,2,PType.DARK,"Always attacks first. Fails if foe didn't use an attacking move",true),
	SUNNY_DAY(0,1000,0,0,2,0,PType.FIRE,"",false),
	SUNNY_DOOM(80,100,0,0,1,0,PType.LIGHT,"If this attack faints foe, causes weather to turn SUNNY",false),
	SUNSTEEL_STRIKE(100,100,0,0,0,0,PType.STEEL,"",true),
	//SUPER_CHARGE(90,50,100,0,0,0,PType.ELECTRIC,"% of causing foe to flinch, user takes 1/3 of damage dealt as recoil",false),
	SUPER_FANG(0,90,0,0,0,0,PType.NORMAL,"Halves foe's remaining HP",true),
	SUPERCHARGED_SPLASH(10,100,50,0,1,0,PType.WATER,"% chance to raise user's Sp.Atk by 1. Turns into Thunder when used by Kissyfishy-D",false),
	SUPERNOVA_EXPLOSION(200,100,0,0,1,0,PType.GALACTIC,"",false),
	SUPERPOWER(120,100,100,0,0,0,PType.FIGHTING,"% of lowering user's Attack and Defense by 1",true),
	SUPERSONIC(0,55,0,0,2,0,PType.NORMAL,"Confuses foe",false),
	SWAGGER(0,85,0,0,2,0,PType.NORMAL,"Confuses foe, but raises foe's Attack by 2",false),
	//SWEEP_KICK(60,95,100,0,0,0,PType.FIGHTING,"% to lower foe's Attack by 1",false),
	SWEET_KISS(0,75,0,0,2,0,PType.LIGHT,"",false),
	SWEET_SCENT(0,1000,0,0,2,0,PType.NORMAL,"",false),
	SWIFT(60,1000,0,0,1,0,PType.MAGIC,"This attack never misses",false),
	//SWORD_SLASH(75,90,0,1,0,0,PType.STEEL,"Boosted Crit rate",false), // recoil
	//SWORD_SLICE(65,85,0,1,0,0,PType.STEEL,"Boosted Crit rate. If it Crits, foe is Bleeding",false),
	SWORD_SPIN(50,95,100,0,0,0,PType.STEEL,"% to raise user's Attack by 1",false),
	//SWORD_STAB(95,60,100,0,0,0,PType.STEEL,"% to cause foe to Bleed",false),
	SWORDS_DANCE(0,1000,0,0,2,0,PType.NORMAL,"Raises user's Attack by 2",false),
	SYNTHESIS(0,1000,0,0,2,0,PType.GRASS,"Restores 1/2 of user's max HP",false),
	TACKLE(50,100,0,0,0,0,PType.NORMAL,"A normal attack",true),
	//TAIL_WHACK(90,85,0,0,0,0,PType.NORMAL,"A normal attack",false),
	TAIL_GLOW(0,1000,0,0,2,0,PType.BUG,"",false),
	TAIL_WHIP(0,100,0,0,2,0,PType.NORMAL,"Lowers foe's Defense by 1",false),
	TAILWIND(0,1000,0,0,2,0,PType.FLYING,"",false),
	TAKE_DOWN(90,85,0,0,0,0,PType.NORMAL,"User takes 1/3 of damage dealt as recoil",true),
	TAKE_OVER(0,100,0,0,2,0,PType.GHOST,"Foe's next attack is used on itself. Can be used once every other turn",false),
	TAUNT(0,100,0,0,2,0,PType.DARK,"",false),
	TEETER_DANCE(0,100,0,0,2,0,PType.NORMAL,"",false),
	TELEPORT(0,1000,0,0,2,-6,PType.PSYCHIC,"",false),
	THRASH(120,100,0,0,0,0,PType.NORMAL,"",true),
	THROAT_CHOP(80,100,100,0,0,0,PType.DARK,"",true),
	THUNDER(120,70,30,0,1,0,PType.ELECTRIC,"% of Paralyzing foe",false),
	THUNDER_FANG(65,95,10,0,0,0,PType.ELECTRIC,"% of Paralyzing and/or flinching foe",true),
	//THUNDER_KICK(80,90,10,0,0,0,PType.ELECTRIC,"% of Paralyzing foe",true),
	THUNDER_PUNCH(75,100,10,0,0,0,PType.ELECTRIC,"% of Paralyzing foe",true),
	THUNDER_WAVE(0,90,0,0,2,0,PType.ELECTRIC,"Paralyzes foe",false),
	THUNDERBOLT(90,100,10,0,1,0,PType.ELECTRIC,"% of Paralyzing foe",false), // recoil
	THUNDERSHOCK(40,100,10,0,1,0,PType.ELECTRIC,"% of Paralyzing foe",false),
	TOPSY$TURVY(0,1000,0,0,2,0,PType.DARK,"",false),
	TORMENT(0,100,0,0,2,0,PType.DARK,"",false),
	//TIDAL_WAVE(-1,100,0,0,1,0,PType.WATER,"Picks a random tide level from the time of day. Morning = 90, Day = 50, and Evening = 130 Base Power",false),
	TORNADO_SPIN(60,95,100,0,0,0,PType.FIGHTING,"% to raise user's Speed and Accuracy by 1, and frees user of being Spun",true),
	TOXIC(0,90,0,0,2,0,PType.POISON,"Badly poisons foe",false),
	TOXIC_SPIKES(0,1000,0,0,2,0,PType.POISON,"",false),
	TRI_ATTACK(80,100,20,0,1,0,PType.NORMAL,"",false),
	TRICK_ROOM(0,1000,0,0,2,-7,PType.PSYCHIC,"",false),
	TWINKLE_TACKLE(85,90,20,0,0,0,PType.MAGIC,"",true),
	TWINEEDLE(25,100,30,0,0,0,PType.BUG,"",false),
	TWISTER(40,100,10,0,1,0,PType.DRAGON,"% of causing foe to flinch",false),
	UNSEEN_STRANGLE(60,100,100,0,0,0,PType.DARK,"",true),
	U$TURN(70,100,0,0,0,0,PType.BUG,"",true),
	VACUUM_WAVE(40,100,0,0,1,1,PType.FIGHTING,"",false),
	V$CREATE(180,95,100,0,0,0,PType.FIRE,"",true),
	VENOM_DRENCH(0,100,0,0,2,0,PType.POISON,"",false),
	VENOM_SPIT(40,100,100,0,1,0,PType.POISON,"",false), // TODO
	VENOSHOCK(-1,100,0,0,1,0,PType.POISON,"",false),
	VISE_GRIP(55,100,0,0,0,0,PType.NORMAL,"",true),
	VINE_WHIP(45,100,0,0,0,0,PType.GRASS,"A normal attack",true),
	VOLT_SWITCH(70,100,0,0,1,0,PType.ELECTRIC,"",false),
	VITAL_THROW(60,1000,0,0,0,-1,PType.FIGHTING,"This attack never misses, but goes last",false),
	VOLT_TACKLE(120,100,10,0,0,0,PType.ELECTRIC,"% to Paralyze foe. User takes 1/3 of damage dealt as recoil",true),
	WAKE$UP_SLAP(-1,100,0,0,0,0,PType.FIGHTING,"If foe is asleep, power is doubled, but the foe wakes up",true),
	WATER_CLAP(20,100,20,0,0,0,PType.WATER,"% to Paralyze foe. Turns into Dragon Darts when used by Kissyfishy-D",true),
	WATER_FLICK(0,100,0,0,2,0,PType.WATER,"Lowers foe's Attack by 1. Turns into Flamethrower when used by Kissyfishy-D",false),
	WATER_KICK(75,100,0,0,0,0,PType.WATER,"A normal attack. Turns into Hi Jump Kick when used by Kissyfishy-D",true),
	WATER_SMACK(40,95,30,0,0,0,PType.WATER,"% chance of causing foe to flinch. Turns into Darkest Lariat when used by Kissyfishy-D",true),
	WATER_SPOUT(-1,100,0,0,1,0,PType.WATER,"",false),
	WATER_SPORT(0,1000,0,0,2,0,PType.WATER,"",false),
	WAVE_CRASH(120,100,0,0,0,0,PType.WATER,"",false),
	WATER_GUN(40,100,0,0,1,0,PType.WATER,"A normal attack",false),
	//WATER_JET(50,100,0,0,0,1,PType.WATER,"Always attacks first",false),
	WATER_PULSE(60,100,30,0,1,0,PType.WATER,"% to Confuse foe",false),
	WATERFALL(80,100,10,0,0,0,PType.WATER,"% of causing foe to flinch",true),
	WEATHER_BALL(-1,100,0,0,1,0,PType.NORMAL,"",false),
	WHIP_SMASH(120,100,0,0,0,0,PType.NORMAL,"A normal attack",true),
	WHIRLPOOL(35,85,100,0,1,0,PType.WATER,"% to spin foe for 2-5 turns. While foe is spun, it takes 1/16 HP in damage, and cannot switch",false),
	WHIRLWIND(0,1000,0,0,2,-6,PType.FLYING,"",false),
	WILL$O$WISP(0,85,0,0,2,0,PType.FIRE,"Burns foe",false),
	WING_ATTACK(60,100,0,0,0,0,PType.FLYING,"A normal attack",true),
	WISH(0,1000,0,0,2,0,PType.NORMAL,"",false),
	WITHDRAW(0,1000,0,0,2,0,PType.WATER,"",false),
	WORRY_SEED(0,100,0,0,2,0,PType.GRASS,"",false),
	//WOOD_FANG(50,100,50,0,0,0,PType.ROCK,"% to cause foe to flinch",false), // recoil
	WRAP(15,90,100,0,0,0,PType.NORMAL,"% to spin foe for 2-5 turns. While foe is spun, it takes 1/16 HP in damage, and cannot switch",true),
	//WRING_OUT(-1,100,0,0,0,0,PType.NORMAL,"Attack's power is greater the more HP the foe has",true),
	X$SCISSOR(80,100,0,1,0,0,PType.BUG,"Boosted Crit rate",true),
	ZAP_CANNON(120,50,100,0,1,0,PType.ELECTRIC,"",false),
	//ZAP(20,100,0,0,0,0,PType.ELECTRIC,"A normal attack",false),
	ZEN_HEADBUTT(80,90,30,0,0,0,PType.PSYCHIC,"% of causing foe to flinch",true),
	ZING_ZAP(80,100,30,0,0,0,PType.ELECTRIC,"",true),
	
	TERRAIN_PULSE(-1,100,0,0,1,0,PType.NORMAL,"",false),
	FACADE(-1,100,0,0,0,0,PType.NORMAL,"",true),
	SLEEP_TALK(-1,100,0,0,2,0,PType.NORMAL,"",false),
	CAPTIVATE(-1,100,0,0,2,0,PType.NORMAL,"",false),
	BATON_PASS(-1,100,0,0,2,0,PType.NORMAL,"",false),
	FLIP_TURN(60,100,0,0,0,0,PType.WATER,"",true),
	CUT(55,95,0,3,0,0,PType.NORMAL,"This move always crits",true),
	ROCK_SMASH(40,100,100,0,0,0,PType.FIGHTING,"% to lower foe's Defense by 1",true),
	VINE_CROSS(70,95,100,0,0,0,PType.GRASS,"% chance to lower foe's Speed by 1",false),
	SURF(90,100,0,0,1,0,PType.WATER,"A normal attack",false),
	SLOW_FALL(75,90,100,0,1,0,PType.PSYCHIC,"% chance to change user's ability to LEVITATE",false),
	ROCK_CLIMB(80,95,20,0,1,0,PType.ROCK,"% chance to confuse foe",false),
	LAVA_SURF(90,100,0,0,1,0,PType.FIRE,"A normal attack",false),
	BOOSTED_PURSUIT(80,100,0,0,0,0,PType.DARK,"If you're seeing this something went wrong",true),
	
	ABYSSAL_CHOP(-1,90,50,0,0,0,PType.DRAGON,"% chance to paralyse foe. Damage is doulbed if foe is paralyzed",true),
	SUMMIT_STRIKE(70,95,100,0,0,0,PType.FIGHTING,"% to lower foe's Defense Stats by one stage. 30% to flinch foe",true),
	
	STRUGGLE(40,1000,0,0,0,0,PType.UNKNOWN,"",true),
	
	;
	
	public static Move getMove(String moveName) {
	    for (Move move : Move.values()) {
	        if (move.toString().equalsIgnoreCase(moveName)) {
	            return move;
	        }
	    }
	    return null;
	}

	public int accuracy;
	
	public int basePower;
	
	public int cat;
	
	public int critChance;
	private String desc;
	public PType mtype;
	public int priority;
	public int secondary;
	public boolean contact;
	Move(int bp, int acc, int sec, int crit, int cat, int p, PType type, String desc, boolean contact){
		this.basePower = bp;
		this.accuracy = acc;
		this.secondary = sec;
		this.cat = cat;
		this.critChance = crit;
		this.mtype = type;
		this.priority = p;
		this.desc = desc;
		this.contact = contact;
	}
	public String getbp() {
		if (basePower == -1) return "Varies";
		return basePower + "";
	}
	public String getCategory() {
		if (cat == 0) return "Physical";
		if (cat == 1) return "Special";
		else {
			return "Status";
		}
	}

	public String getDescription() {
		if (this.secondary > 0) {
            return secondary + desc;
        } else {
        	return desc;
        }
		
	}
	
	public String getDescriptor() {
		String message = "Move: " + toString() + "\n";
        message += "Type: " + mtype + "\n";
        message += "BP: " + getbp() + "\n";
        message += "Accuracy: " + getAccuracy() + "\n";
        message += "Category: " + getCategory() + "\n";
        message += "Description: " + getDescription();
        
        return message;
	}
	
	public boolean isAttack() {
		return cat != 2;
	}

	public boolean isPhysical() {
		return cat == 0;
	}
	
	public String getAccuracy() {
		String result = "";
		if (accuracy > 100) {
			result += "--";
		} else {
			result += accuracy;
		}
		
		return result;
	}
	
	@Override // implementation
	public String toString() {
	    String name = super.toString();
	    name = name.replace('$', '-'); // Replace '$' with '-'
	    name = name.toLowerCase().replace('_', ' '); // Convert underscores to spaces
	    String[] words = name.split(" ");
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < words.length; i++) {
	        String word = words[i];
	        if (word.contains("-")) {
	            String[] hyphenWords = word.split("-");
	            for (int j = 0; j < hyphenWords.length; j++) {
	                sb.append(Character.toUpperCase(hyphenWords[j].charAt(0)))
	                  .append(hyphenWords[j].substring(1));
	                if (j < hyphenWords.length - 1) {
	                    sb.append('-');
	                }
	            }
	        } else {
	            sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1));
	        }
	        if (i < words.length - 1) { // Check if there's a next word
	            char nextChar = name.charAt(name.indexOf(word) + word.length());
	            if (nextChar == ' ' || nextChar == '-') {
	                sb.append(nextChar); // Keep the space or hyphen
	            } else {
	                sb.append(" "); // Add a space if the next character is not space or hyphen
	            }
	        }
	    }
	    return sb.toString().trim();
	}
	
	public int getNumHits(Pokemon[] team) {
		if (this == Move.DOUBLE_SLAP || this == Move.FURY_ATTACK ||this == Move.FURY_SWIPES || this == Move.ICICLE_SPEAR ||
				this == Move.PIN_MISSILE || this == Move.ROCK_BLAST|| this == Move.SCALE_SHOT || this == Move.SPIKE_CANNON) {
			int randomNum = (int) (Math.random() * 100) + 1; // Generate a random number between 1 and 100 (inclusive)
	        if (randomNum <= 35) {
	            return 2; // 2 hits with 35% probability
	        } else if (randomNum <= 70) {
	            return 3; // 3 hits with 35% probability
	        } else if (randomNum <= 85) {
	            return 4; // 4 hits with 15% probability
	        } else {
	            return 5; // 5 hits with 15% probability
	        }
		} else if (this == Move.DOUBLE_KICK || this == Move.DRAGON_DARTS || this == Move.DUAL_CHOP || this == Move.DOUBLE_HIT || this == Move.TWINEEDLE || this == Move.POP_POP) {
			return 2;
		} else if (this == Move.BEAT_UP) {
			int result = 0;
			if (team == null) {
				result++;
				team = new Pokemon[1];
			}
			for (Pokemon p : team) {
				if (p != null && !p.isFainted()) {
					result++;
				}
			}
			return result;
		} else {
			return 1;
		}
	}
	public boolean isHMmove() {
		if (this == Move.CUT || this == Move.ROCK_SMASH || this == Move.VINE_CROSS || this == Move.SURF || this == Move.SLOW_FALL || this == Move.FLY
			|| this == Move.ROCK_CLIMB || this == Move.LAVA_SURF) {
			return true;
		}
		return false;
	}
	public static ArrayList<Move> getSound() {
		ArrayList<Move> result = new ArrayList<>();
		
		result.add(Move.BUG_BUZZ);
		result.add(Move.GRASS_WHISTLE);
		result.add(Move.GROWL);
		result.add(Move.HOWL);
		result.add(Move.METAL_SOUND);
		result.add(Move.NOBLE_ROAR);
		result.add(Move.PERISH_SONG);
		result.add(Move.ROAR);
		result.add(Move.ROUND);
		result.add(Move.SCREECH);
		result.add(Move.SNORE);
		result.add(Move.SNARL);
		result.add(Move.SPARKLING_ARIA);
		result.add(Move.SPARKLING_WATER);
		result.add(Move.SUPERSONIC);
		result.add(Move.HYPER_VOICE);
		
		return result;
	}
	
	public boolean isSlicing() {
		ArrayList<Move> result = new ArrayList<>();
		result.add(AERIAL_ACE);
		result.add(AIR_CUTTER);
		result.add(AIR_SLASH);
		result.add(FURY_CUTTER);
		result.add(LEAF_BLADE);
		result.add(NIGHT_SLASH);
		result.add(PSYCHO_CUT);
		result.add(RAZOR_SHELL);
		result.add(SACRED_SWORD);
		result.add(SLASH);
		result.add(SOLAR_BLADE);
		result.add(X$SCISSOR);
		result.add(CROSS_POISON);
		result.add(CUT);
		result.add(RAZOR_LEAF);
		
		if (result.contains(this)) {
			return true;
		}
		return false;
	}
	
	public boolean isTM() {
		for (int i = 93; i < 200; i++) {
			Item test = new Item(i);
			if (test.getMove() == this) {
				return true;
			}
		}
		return false;
	}

}