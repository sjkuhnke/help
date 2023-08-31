package Swing;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class Field {
	
	FieldEffect weather;
	int weatherTurns;
	FieldEffect terrain;
	int terrainTurns;
	public ArrayList<FieldEffect> playerSide;
	public ArrayList<FieldEffect> foeSide;
	public ArrayList<FieldEffect> fieldEffects;
	
	public Field() {
		weather = null;
		playerSide = new ArrayList<>();
		foeSide = new ArrayList<>();
		fieldEffects = new ArrayList<>();
	}
	
	public enum Effect {
		SUN(5, true, false),
		RAIN(5, true, false),
		SANDSTORM(5, true, false),
		SNOW(5, true, false),
		GRASSY(5, false, true),
		ELECTRIC(5, false, true),
		PSYCHIC(5, false, true),
		SPARKLY(5, false, true), 
		REFLECT(5, false, false),
		LIGHT_SCREEN(5, false, false),
		AURORA_VEIL(5, false, false),
		TRICK_ROOM(5, false, false),
		GRAVITY(5, false, false), 
		TAILWIND(4, false, false),
		STEALTH_ROCKS(-1, false, false),
		SPIKES(-1, false, false),
		TOXIC_SPIKES(-1, false, false),
		STICKY_WEBS(-1, false, false),
		SAFEGUARD(5, false, false),
		WATER_SPORT(5, false, false),
		MUD_SPORT(5, false, false),
		;
		
		private Effect(int turns, boolean isWeather, boolean isTerrain) {
			this.turns = turns;
			this.isWeather = isWeather;
			this.isTerrain = isTerrain;
		}
		
		public int turns;
		public boolean isWeather;
		public boolean isTerrain;
		
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
	}
	
	public class FieldEffect {
		int turns;
		Effect effect;
		int layers;
		
		public FieldEffect(Effect effect) {
			this.effect = effect;
			turns = effect.turns;
			layers = 0;
		}
		
		@Override
		public String toString() {
			return effect.toString();
		}

		public String toLowerCaseString() {
			return effect.toString().toLowerCase();
		}

		public Color getColor() {
			switch (effect) {
			case AURORA_VEIL:
				return new Color(150, 217, 214);
			case ELECTRIC:
				return new Color(247, 208, 44);
			case GRASSY:
				return new Color(122, 199, 76);
			case GRAVITY:
				return new Color(138, 30, 106);
			case LIGHT_SCREEN:
				return new Color(249, 85, 135);
			case MUD_SPORT:
				return new Color(226, 191, 101);
			case PSYCHIC:
				return new Color(249, 85, 135);
			case RAIN:
				return new Color(99, 144, 240);
			case REFLECT:
				return new Color(249, 85, 135);
			case SAFEGUARD:
				return new Color(168, 167, 122);
			case SANDSTORM:
				return new Color(182, 161, 54);
			case SNOW:
				return new Color(150, 217, 214);
			case SPARKLY:
				return new Color(254, 1, 77);
			case SPIKES:
				return new Color(226, 191, 101);
			case STEALTH_ROCKS:
				return new Color(182, 161, 54);
			case STICKY_WEBS:
				return new Color(166, 185, 26);
			case SUN:
				return new Color(238, 129, 48);
			case TAILWIND:
				return new Color(169, 143, 243);
			case TOXIC_SPIKES:
				return new Color(163, 62, 161);
			case TRICK_ROOM:
				return new Color(249, 85, 135);
			case WATER_SPORT:
				return new Color(99, 144, 240);
			default:
				return new Color(150, 217, 214);
			
			}
		}
	}
	
	public void setWeather(FieldEffect weather) {
		if (weather.effect.isWeather && this.weather != weather) {
			System.out.println("The weather became " + weather.toString() + "!");
			this.weather = weather;
			this.weatherTurns = weather.turns;
		}
	}
	
	public void setTerrain(FieldEffect terrain) {
		if (terrain.effect.isTerrain && this.weather != terrain) {
			System.out.println("The terrain became " + terrain.toString() + "!");
			this.terrain = terrain;
			this.terrainTurns = terrain.turns;
		}
	}
	
	public void setEffect(FieldEffect effect) {
		if (effect.effect == Effect.TRICK_ROOM) {
			if (contains(fieldEffects, effect.effect)) {
				removeEffect(fieldEffects, effect.effect);
				System.out.println("The twisted dimensions returned to normal!");
				return;
			}
		}
		if (!contains(fieldEffects, effect.effect)) {
			fieldEffects.add(effect);
			System.out.println(effect.toString() + " took effect!");
		}
	}
	
	public boolean setHazard(ArrayList<FieldEffect> side, FieldEffect hazard) {
		if (hazard.effect == Effect.STEALTH_ROCKS && !contains(side, Effect.STEALTH_ROCKS)) {
			System.out.println("Pointed rocks were scattered everywhere!");
			side.add(hazard);
			hazard.layers = 1;
			return true;
		} else if (hazard.effect == Effect.STICKY_WEBS && !contains(side, Effect.STICKY_WEBS)) {
			System.out.println("Sticky webs were scattered at the Pokemon's feet!");
			side.add(hazard);
			hazard.layers = 1;
			return true;
		} else if (hazard.effect == Effect.TOXIC_SPIKES) {
			if (getLayers(side, Effect.TOXIC_SPIKES) == 0) {
				System.out.println("Poisonous Spikes were put at the Pokemon's feet!");
				hazard.layers++;
				side.add(hazard);
				return true;
			} else if (getLayers(side, Effect.TOXIC_SPIKES) == 1) {
				System.out.println("Poisonous Spikes were put at the Pokemon's feet!");
				addLayer(side, Effect.TOXIC_SPIKES);
				return true;
			} else if (getLayers(side, Effect.TOXIC_SPIKES) == 2) {
				System.out.println("But it failed!");
				return false;
			}
			
		} else if (hazard.effect == Effect.SPIKES) {
			if (getLayers(side, Effect.SPIKES) == 0) {
				System.out.println("Spikes were scattered at the Pokemon's feet!");
				hazard.layers++;
				side.add(hazard);
				return true;
			} else if (getLayers(side, Effect.SPIKES) == 1 || getLayers(side, Effect.SPIKES) == 2) {
				System.out.println("Spikes were scattered at the Pokemon's feet!");
				addLayer(side, Effect.SPIKES);
				return true;
			} else if (getLayers(side, Effect.SPIKES) == 3) {
				System.out.println("But it failed!");
				return false;
			}
			
		}
		return false;
	}

	public boolean contains(ArrayList<FieldEffect> side, Effect effect) {
		for (FieldEffect e : side) {
			if (e.effect == effect) return true;
		}
		return false;
	}
	
	public boolean removeEffect(ArrayList<FieldEffect> side, Effect effect) {
		for (FieldEffect e : side) {
			if (e.effect == effect) {
				side.remove(e);
				return true;
			}
		}
		return false;
	}
	
	public boolean equals(FieldEffect fe, Effect e) {
		if (fe == null) return false;
		if (fe.effect == e) return true;
		return false;
	}
	
	public void endOfTurn() {
	    if (weather != null) {
	        weatherTurns--;
	        if (weatherTurns == 0) {
	            System.out.println("The weather returned to normal!");
	            weather = null;
	        }
	    }
	    if (terrain != null) {
	        terrainTurns--;
	        if (terrainTurns == 0) {
	            System.out.println("The terrain returned to normal!");
	            terrain = null;
	        }
	    }
	    
	    Iterator<FieldEffect> iterator = fieldEffects.iterator();
	    while (iterator.hasNext()) {
	        FieldEffect effect = iterator.next();
	        if (effect.turns > 0) effect.turns--;
	        if (effect.turns == 0) {
	            System.out.println(effect.effect.toString() + " wore off!");
	            iterator.remove();
	        }
	    }
	    
	    iterator = playerSide.iterator();
	    while (iterator.hasNext()) {
	        FieldEffect effect = iterator.next();
	        if (effect.turns > 0) effect.turns--;
	        if (effect.turns == 0) {
	            System.out.println("Your " + effect.effect.toString() + " wore off!");
	            iterator.remove();
	        }
	    }
	    
	    iterator = foeSide.iterator();
	    while (iterator.hasNext()) {
	        FieldEffect effect = iterator.next();
	        if (effect.turns > 0) effect.turns--;
	        if (effect.turns == 0) {
	            System.out.println("Foe's " + effect.effect.toString() + " wore off!");
	            iterator.remove();
	        }
	    }
	}

	public ArrayList<FieldEffect> getHazards(ArrayList<FieldEffect> side) {
		ArrayList<FieldEffect> result = new ArrayList<>();
		for (FieldEffect fe : side) {
			if (fe.effect == Effect.STEALTH_ROCKS || fe.effect == Effect.SPIKES || fe.effect == Effect.TOXIC_SPIKES || fe.effect == Effect.STICKY_WEBS) result.add(fe);
		}
		return result;
	}
	
	public int getLayers(ArrayList<FieldEffect> side, Effect effect) {
		for (FieldEffect e : side) {
			if (e.effect == effect) return e.layers;
		}
		return 0;
	}
	
	public void addLayer(ArrayList<FieldEffect> side, Effect effect) {
		for (FieldEffect e : side) {
			if (e.effect == effect) e.layers++;
			return;
		}
	}
	
	public boolean remove(ArrayList<FieldEffect> side, Effect effect) {
		for (FieldEffect e : side) {
			if (e.effect == effect) {
				side.remove(e);
				return true;
			}
		}
		return false;
	}


}
