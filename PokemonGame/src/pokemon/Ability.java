package pokemon;

public enum Ability {

	ADAPTABILITY("Powers up moves of the same type."),
	AMBUSH("Gives priority to the first move when this Pokemon enters battle."),
	ANGER_POINT("Maxes Attack after taking a critical hit."),
	ANTICIPATION("Senses an opposing Pokemon's dangerous moves."),
	INSOMNIA("Prevents the Pokemon from falling asleep."),
	BATTLE_ARMOR("This Pokemon cannot be Critical hit"),
	BLAZE("Powers up FIRE moves in a pinch."),
	BRAINWASH("Forces the opponent's stat changes to have an opposite effect while the user is active."),
	CHLOROPHYLL("Boosts the Pokemon's Speed stat in SUNSHINE."),
	CLEAR_BODY("Prevents other Pokemon from lowering its stats."),
	COMPETITIVE("Boosts the Pokemon's Special Attack stat when its stats are lowered."),
	COMPOUND_EYES("The Pokemon's accuracy is boosted."),
	CONTRARY("Makes stat changes have an opposite effect."),
	CORROSION("The Pokemon can poison the target even if it's a Steel or Poison type."), // TODO
	DEFIANT("Boosts the Pokemon's Attack stat when its stats are lowered."),
	DRIZZLE("The Pokemon makes it RAIN when it enters a battle."),
	DRY_SKIN("Restores HP in RAIN or when hit by WATER moves, but reduces HP in SUN and is weaker to FIRE."),
	DROUGHT("Turns the sunlight HARSH when it enters a battle."),
	ELECTRIC_SURGE("Turns the ground into ELECTRIC TERRAIN when the Pokemon enters a battle."),
	EMPATHIC_LINK("The Pokemon gets a boost in Sp.Atk after the foe raises any stat."),
	ILLUMINATION("Grants the user all the resistances from the LIGHT type."),
	FILTER("Reduces damage from supereffective attacks."),
	FLAME_BODY("Contact with the Pokemon may burn the attacker."),
	FLASH_FIRE("It powers up FIRE moves if it's hit by one."),
	FLUFFY("Halves the damage from moves that make direct contact, but doubles that of FIRE moves."),
	FRIENDLY_GHOST("Gives full immunity to all GHOST moves."),
	GALACTIC_AURA("Halves the damage of ICE and PSYCHIC moves."),
	GLACIER_AURA("Weakens the power of Physical moves."),
	GRASSY_SURGE("Turns the ground into GRASSY TERRAIN when the Pokemon enters a battle."),
	GRAVITATION("Creates GRAVITY when the Pokemon enters a battle."),
	GUTS("Boosts the Attack stat if the Pokemon has a status condition."),
	HUGE_POWER("Doubles the Pokemon's Attack stat."),
	HYPER_CUTTER("Prevents other Pokemon from lowering Attack stat."),
	ICE_BODY("The Pokemon gradually regains HP in SNOW."),
	ICY_SCALES("The Pokemon is protected by ice scales, which halve the damage from special moves."),
	INNER_FOCUS("The Pokemon is protected from flinching."),
	INSECT_FEEDER("Restores HP if hit by a BUG move."),
	INTIMIDATE("Lowers the opposing Pokemon's Attack stat."),
	IRON_BARBS("Inflicts damage to the Pokemon on contact."),
	IRON_FIST("Boosts the power of punching moves."),
	JUSTIFIED("Boosts the Attack stat when it's hit by a DARK move."),
	KEEN_EYE("Prevents the Pokemon from losing accuracy."),
	LEVITATE("Gives full immunity to all GROUND moves."),
	LIGHTNING_ROD("Raises Special Attack if hit by an ELECTRIC move."),
	MAGIC_BOUNCE("Reflects status moves instead of getting hit by them."),
	MAGIC_GUARD("The Pokemon only takes damage from attacks."),
	MIRROR_ARMOR("Bounces back only the stat-lowering effects that the Pokemon receives."),
	MOTOR_DRIVE("Raises Speed if hit by an ELECTRIC move."),
	MOUTHWATER("Prevents the foe from using any non-damaging moves."),
	MOXIE("Boosts the Attack stat after knocking out any Pokemon."),
	MULTISCALE("Reduces damage the Pokemon takes when its HP is full."),
	NATURAL_CURE("All status conditions heal when the Pokemon switches out."),
	NO_GUARD("Ensures the Pokemon and its foe's attacks land."),
	NORMALIZE("All the Pokemon's moves become Normal type. The power of those moves is boosted."),
	OVERGROW("Powers up GRASS moves in a pinch."),
	POISON_HEAL("Restores HP if the Pokemon is poisoned instead of losing HP."),
	POISON_POINT("Contact with the Pokemon may poison the attacker."),
	PRANKSTER("Gives priority to a status move."),
	PROTEAN("Makes the Pokemon's type to the move type it's about to use."),
	PSYCHIC_AURA("Weakens the power of Special moves."),
	PSYCHIC_SURGE("Turns the ground into PSYCHIC TERRAIN when the Pokemon enters a battle."),
	RADIANT("Lowers foe's Accuracy when hit by a LIGHT move"),
	RAIN_DISH("The Pokemon gradually regains HP in RAIN."),
	RATTLED("DARK, GHOST, and BUG moves scare the Pokemon and boost its Speed stat."),
	REGENERATOR("Restores a little HP when withdrawn from battle."),
	ROCK_HEAD("Prevents recoil damage."),
	ROUGH_SKIN("Inflicts damage to the Pokemon on contact."),
	SAND_FORCE("Boosts the power of ROCK, GROUND, and STEEL moves in a SANDSTORM."),
	SAND_RUSH("Boosts the Pokemon's Speed stat in a SANDSTORM."),
	SAND_STREAM("The Pokemon summons a SANDSTORM when it enters a battle."),
	SAND_VEIL("When SANDSTORM is active, this Pokemon is evasive."),
	SAP_SIPPER("Raises Attack if hit by an GRASS move."),
	SERENE_GRACE("Boosts the likelihood of additional effects occurring when attacking."),
	SCALY_SKIN("Lowers the foe's Attack, and this Pokemon only takes damage from attacks."),
	SHARPNESS("Boosts the power of Slicing moves."),
	SHED_SKIN("The Pokemon may heal its own status conditions."),
	SHEER_FORCE("Removes additional effects to increase the power of moves when attacking."),
	SHIELD_DUST("Blocks the added effects of attacks taken."),
	SIMPLE("The stat changes the Pokemon receives are doubled."),
	SLUSH_RUSH("Boosts the Pokemon's Speed stat in SNOW."),
	SNIPER("Powers up moves if they become critical hits."),
	SNOW_CLOAK("When SNOW is active, this Pokemon is evasive."),
	SNOW_WARNING("The Pokemon makes it SNOW when it enters a battle."),
	SOLAR_POWER("Boosts the Sp. Atk stat in SUNNY weather, but HP decreases."),
	SOLID_ROCK("Reduces damage from supereffective attacks."),
	SPARKLY_SURGE("Turns the ground into SPARKLY TERRAIN when the Pokemon enters a battle."),
	SPEED_BOOST("Its Speed stat is gradually boosted."),
	STATIC("Contact with the Pokemon may paralyze the attacker."),
	STEELWORKER("Powers up STEEL moves."),
	STRONG_JAW("The Pokemon's strong jaw boosts the power of its biting moves."),
	STURDY("It cannot be knocked out with one hit. One-hit KO moves cannot knock it out, either."),
	SUPER_LUCK("Heightens the critical-hit ratios of moves."),
	SWARM("Powers up BUG moves in a pinch."),
	SWIFT_SWIM("Boosts the Pokemon's Speed stat in RAIN."),
	SYNCHRONIZE("Passes a burn, poison, or paralysis to the foe."),
	TECHNICIAN("Powers up the Pokemon's weaker moves."),
	THICK_FAT("Boosts resistance to FIRE and ICE moves."),
	TINTED_LENS("Powers up \"not very effective\" moves."),
	TORRENT("Powers up WATER moves in a pinch."),
	TOUGH_CLAWS("Powers up moves that make direct contact."),
	TOXIC_DEBRIS("Puts toxic spikes on the opposing side when the hit by physical moves."), // TODO
	TERRIFY("Lowers the opposing Pokemon's Sp. Atk stat."),
	TRACE("The Pokemon copies a foe's Ability."),
	TYPE_MASTER("Grants STAB on all moves."),
	UNAWARE("Ignores the opposing Pokemon's stat changes."),
	UNERODIBLE("Reduces damage from GRASS, WATER, and GROUND attacks."),
	VOLT_ABSORB("Restores HP if hit by a ELECTRIC move."),
	VOLT_VORTEX("Boosts the Pokemon's speed in ELECTRIC TERRAIN."),
	WATER_ABSORB("Restores HP if hit by a WATER move."),
	WATER_VEIL("Prevents the Pokemon from getting a burn."),
	WONDER_GUARD("Only supereffective moves will hit."),
	NULL("No Ability.");

	Ability(String string) {
		desc = string;
	}
	
	@Override
	public String toString() {
		String name = super.toString();
	    name = name.toLowerCase().replace('_', ' ');
	    String[] words = name.split(" ");
	    StringBuilder sb = new StringBuilder();
	    for (String word : words) {
	        sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
	    }
	    return sb.toString().trim();
	}
	
	public String desc;

	String superToString() {
		return super.toString();
	}
}
