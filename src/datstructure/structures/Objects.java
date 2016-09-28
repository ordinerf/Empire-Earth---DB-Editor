package datstructure.structures;

import java.util.stream.IntStream;

import constants.ObjectType;
import constants.ResourceType;
import constants.UnitType;
import constants.WonderType;
import datmanager.Core;
import datstructure.DatStructure;
import datstructure.DatStructureParse;
import datstructure.DatStructureParse.ParseState;
import datstructure.FieldStruct;
import datstructure.Knowledge;
import datstructure.Type;

/**
 * Represents the file dbobjects.dat
 * @author MarcoForlini
 */
@DatStructureParse(Vanilla = ParseState.MISSING_UNKNOWN, AOC = ParseState.MISSING_UNKNOWN)
public class Objects extends DatStructure {

	/**
	 * Unique instance of this structure
	 */
	public static final Objects instance = new Objects();

	/**
	 * Creates a new {@link Objects}
	 */
	private Objects () {
		super("Objects", "dbobjects.dat", true, 0, 1, 0, 0, 1, 5, 4, 125, 175);
	}
	
	@Override
	public void init () {
		if (!Core.AOC){		//File structure has been changed in AOC
			fieldStructs = new FieldStruct[]{
					FieldStruct.NAME, FieldStruct.SEQ_NUMBER, ID_FAMILY, FieldStruct.UNKNOWN_INT4,
					FieldStruct.UNKNOWN_INT4, FieldStruct.ID, new FieldStruct("Health", Type.INTEGER), FieldStruct.UNKNOWN_INT4,
					new FieldStruct("Min range", Type.FLOAT), new FieldStruct("Max range", Type.FLOAT), new FieldStruct("Line of sight", Type.FLOAT), new FieldStruct("Attack reload time", Type.FLOAT),
					new FieldStruct("Area of effect", Type.FLOAT), new FieldStruct("Speed", Type.FLOAT), new FieldStruct("Acceleration/Deceleration", Type.FLOAT), new FieldStruct("Idle turning speed", Type.FLOAT),
					new FieldStruct("Moving turning speed", Type.FLOAT), FieldStruct.UNKNOWN_FLOAT, new FieldStruct("<PROBABLY> Is air unit", Type.INTEGER), new FieldStruct("Flight time", Type.INTEGER),
					FieldStruct.UNKNOWN_FLOAT, new FieldStruct("Attack angle", Type.FLOAT), new FieldStruct("<PROBABLY> Attack from the side", Type.INTEGER), ID_WEAPON_TO_HIT,
					new FieldStruct("Attack", Type.INTEGER), new FieldStruct("Shock armor", Type.INTEGER), new FieldStruct("Arrow armor", Type.INTEGER), new FieldStruct("Pierce armor", Type.INTEGER),
					new FieldStruct("Gun armor", Type.INTEGER), new FieldStruct("Laser armor", Type.INTEGER), new FieldStruct("Missile armor", Type.INTEGER), new FieldStruct("Projectile ID", Objects.instance, 0),
					new FieldStruct("Family attack multiplier index", IntStream.range(0, 66).boxed().toArray(Integer[]::new)), FieldStruct.UNKNOWN_INT4, new FieldStruct("Graphic size", Type.FLOAT), new FieldStruct("Unit type", Type.STRING, 52),
					new FieldStruct("Unit type", UnitType.values()), FieldStruct.UNUSED_INT4, ID_BUTTON, ID_GRAPHIC,
					new FieldStruct("Build rate", Type.FLOAT), new FieldStruct("Iron gather rate", Type.FLOAT), new FieldStruct("Farm gather rate", Type.FLOAT), new FieldStruct("Gold gather rate", Type.FLOAT),
					new FieldStruct("Stone gather rate", Type.FLOAT), new FieldStruct("Wood gather rate", Type.FLOAT), new FieldStruct("Hunt gather rate", Type.FLOAT), new FieldStruct("Forage gather rate", Type.FLOAT),
					new FieldStruct("Creation sound", Sounds.instance, 0), new FieldStruct("Action sound 1", Sounds.instance, 0), new FieldStruct("Action sound 2", Sounds.instance, 0), new FieldStruct("Selection sound 1", Sounds.instance, 0),
					new FieldStruct("Selection sound 2", Sounds.instance, 0), new FieldStruct("Death sound", Sounds.instance, 0), new FieldStruct("<PROBABLY> Can build", Type.BOOLEAN), ID_BUTTON_COMMAND,
					ID_BUTTON_COMMAND, ID_BUTTON_COMMAND, ID_BUTTON_COMMAND, ID_BUTTON_COMMAND,
					ID_BUTTON_COMMAND, ID_BUTTON_COMMAND, ID_BUTTON_COMMAND, ID_BUTTON_COMMAND,
					FieldStruct.UNCHANGED_INT4, new FieldStruct("Square occupied", Type.INTEGER), new FieldStruct("Resource type", ResourceType.values()), new FieldStruct("Resource amount", Type.FLOAT),
					new FieldStruct("Always face camera", Type.INTEGER), FieldStruct.UNKNOWN_INT4, new FieldStruct("Rotting time", Type.FLOAT), new FieldStruct("Population count", Type.INTEGER),
					new FieldStruct("Transport capacity", Type.INTEGER), new FieldStruct("Show area effect stat"), new FieldStruct("Show repair stat"), new FieldStruct("Show shock armor stat"),
					new FieldStruct("Show pierce armor stat"), new FieldStruct("Show arrow armor stat"), new FieldStruct("Show laser armor stat"), new FieldStruct("Show gun armor stat"),
					new FieldStruct("Show missile armor stat"), new FieldStruct("Show range", Type.INTEGER), new FieldStruct("Morale bonus", Type.INTEGER), FieldStruct.UNKNOWN_INT4,
					FieldStruct.UNKNOWN_INT4, FieldStruct.UNKNOWN_FLOAT, FieldStruct.UNUSED_INT4, new FieldStruct("Flight altitude", Type.FLOAT),
					FieldStruct.ID_LANGUAGE, FieldStruct.UNKNOWN_INT4, new FieldStruct("Healer heal amount", Type.INTEGER), new FieldStruct("Health regeneration", Type.INTEGER),
					new FieldStruct("Can garrison in air transports"), new FieldStruct("Can garrison in land transports"), new FieldStruct("Can garrison in sea transports"), FieldStruct.UNUSED_INT1,
					new FieldStruct("Object type", ObjectType.values()), FieldStruct.UNKNOWN_INT4, new FieldStruct("Circle selection size", Type.FLOAT), new FieldStruct("Shadow size", Type.FLOAT),
					FieldStruct.UNUSED_INT4, new FieldStruct("Formation size", Type.FLOAT), new FieldStruct("Physical size", Type.FLOAT), new FieldStruct("Interact/obstruct/bump other objects"),
					FieldStruct.UNKNOWN_INT1, FieldStruct.UNKNOWN_INT1, FieldStruct.UNKNOWN_INT1, FieldStruct.UNKNOWN_FLOAT,
					new FieldStruct("Initial projectile angle", Type.FLOAT), new FieldStruct("Ammo amount", Type.INTEGER), new FieldStruct("<All bombers use this>"), FieldStruct.UNKNOWN_BOOL1,
					FieldStruct.UNKNOWN_BOOL1, new FieldStruct("<PROBABLY> Parabolic projectile"), FieldStruct.UNKNOWN_INT4, FieldStruct.UNUSED_INT4,
					new FieldStruct("Category (Heroes use 27)", Type.INTEGER), FieldStruct.UNKNOWN_INT4, FieldStruct.UNKNOWN_INT4, FieldStruct.UNKNOWN_INT4,
					FieldStruct.UNKNOWN_INT4, ID_UPGRADE, new FieldStruct("<Used by units/buildings who can convert>", Type.INTEGER), FieldStruct.UNKNOWN_FLOAT,
					new FieldStruct("Can be owned by a player"), new FieldStruct("Can be owned by \"World\""), FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNKNOWN_BOOL1,
					new FieldStruct("Can be killed with Delete"), FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNKNOWN_INT1, FieldStruct.UNUSED_INT1,
					new FieldStruct("Low health effect ID", GFXEffects.instance, 0), new FieldStruct("Death effect ID", GFXEffects.instance, 0), new FieldStruct("Start of attack ID", GFXEffects.instance, 0), ID_GFX_UNKNOWN,
					new FieldStruct("Movement effect", GFXEffects.instance, 0), ID_GFX_UNKNOWN, new FieldStruct("Heal other effect ID", GFXEffects.instance, 0), ID_GFX_UNKNOWN,
					ID_GFX_UNKNOWN,	new FieldStruct("Get hit effect ID", GFXEffects.instance, 0), new FieldStruct("Permanent effect", GFXEffects.instance, 0), ID_GFX_UNUSED,
					new FieldStruct("Projectile effect", GFXEffects.instance, 0), ID_GFX_UNUSED, ID_GFX_UNUSED, ID_GFX_UNUSED,
					ID_GFX_UNUSED, ID_GFX_UNUSED, ID_GFX_UNKNOWN, new FieldStruct("<only used by volcano-projectile and meteor>", Type.INTEGER),
					new FieldStruct("Attack effect ID", GFXEffects.instance, 0), new FieldStruct("Disease effect ID 1", GFXEffects.instance, 0), new FieldStruct("Disease effect ID 2", GFXEffects.instance, 0), new FieldStruct("Diffraction shield effect ID", GFXEffects.instance, 0),
					new FieldStruct("Pulse cannon effect ID", GFXEffects.instance, 0), new FieldStruct("Battle cry effect ID", GFXEffects.instance, 0), new FieldStruct("Bomb hole effect ID", GFXEffects.instance, 0), ID_GFX_UNUSED,
					ID_GFX_UNKNOWN, FieldStruct.UNUSED_INT4, FieldStruct.UNKNOWN_INT4, new FieldStruct("<only used by ships>", Type.FLOAT),
					FieldStruct.UNUSED_INT4, FieldStruct.UNUSED_INT4, FieldStruct.UNUSED_INT4, FieldStruct.UNUSED_INT4,
					new FieldStruct("Terrain: Grass, Snow"), new FieldStruct("Elevation: Deep water"), new FieldStruct("Terrain: Rock, Stones and Artificial"), FieldStruct.UNKNOWN_BOOL1,
					FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNKNOWN_BOOL1,
					FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNKNOWN_BOOL1, new FieldStruct("Terrain: Asphalt"), new FieldStruct("Elevation: cliffs"),
					new FieldStruct("Elevation: Shallow water"), FieldStruct.UNKNOWN_BOOL1, new FieldStruct("Terrain: Sand"), new FieldStruct("Terrain: Space"),
					FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNKNOWN_INT1, FieldStruct.UNUSED_INT1, FieldStruct.UNUSED_INT1,
					ID_AREA_EFFECT, ID_AREA_EFFECT, ID_AREA_EFFECT, ID_AREA_EFFECT,
					FieldStruct.UNUSED_INT4, FieldStruct.UNUSED_INT4, FieldStruct.UNUSED_INT4, new FieldStruct("Carry capacity", Type.FLOAT),
					FieldStruct.UNKNOWN_INT4, FieldStruct.UNUSED_INT4, FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNUSED_BOOL1,
					FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNUSED_INT1, FieldStruct.UNKNOWN_INT4, FieldStruct.UNKNOWN_INT4,
					new FieldStruct("Debris on death", Objects.instance, 0), new FieldStruct("Debris on death", Objects.instance, 0), FieldStruct.UNKNOWN_INT4, new FieldStruct("Min stealth radius", Type.INTEGER),
					new FieldStruct ("<It seems \"Interaction type\">", Type.INTEGER), new FieldStruct("Max citizens garrison", Type.INTEGER), new FieldStruct("Initial citizens garrison", Type.INTEGER), new FieldStruct("Garrison upgrade object to", TechTree.instance, 0),
					new FieldStruct ("Plane refuel location", Type.INTEGER), new FieldStruct("<Seems related to ships...>", Type.INTEGER), new FieldStruct("Wonder bonus", WonderType.values()), new FieldStruct ("Effect apply to", UnitSet.instance, 0),
					FieldStruct.UNKNOWN_FLOAT, FieldStruct.UNKNOWN_FLOAT, new FieldStruct("Friendly damage mult", Type.FLOAT), new FieldStruct("Garrison citizens bonus", Type.FLOAT),
					FieldStruct.UNKNOWN_FLOAT, FieldStruct.UNUSED_INT4, FieldStruct.UNKNOWN_INT4, FieldStruct.UNKNOWN_INT4,
					new FieldStruct("Num techs it can build", Type.INTEGER, 4, false), ID_TECH, new FieldStruct("Is building?"), new FieldStruct("Stealth"),
					FieldStruct.UNKNOWN_BOOL1, new FieldStruct("<Seems related to aircraft, but the clubman...>", Type.INTEGER, 1), FieldStruct.UNKNOWN_INT4, new FieldStruct("Spawn on death", Objects.instance, 0),
					new FieldStruct("Power", Type.INTEGER), new FieldStruct("Power recover rate", Type.INTEGER), new FieldStruct("Default stance", UnitBehavior.instance, 0), new FieldStruct("Conversion time", Type.INTEGER),
					FieldStruct.UNKNOWN_FLOAT, new FieldStruct("<It seems heal power, but the roman legionnaire...>", Type.FLOAT, 4, Knowledge.UNKNOWN), FieldStruct.UNKNOWN_FLOAT, new FieldStruct("<PROBABLY> Load range", Type.FLOAT),
					new FieldStruct("<PROBABLY> Unload range", Type.FLOAT), new FieldStruct("Can walk through trees"), FieldStruct.UNUSED_BOOL1, FieldStruct.UNKNOWN_BOOL1,
					new FieldStruct("Can attack area"), new FieldStruct("<PROBABLY> Melee attack"), new FieldStruct("Garrison heal rate", Type.INTEGER, 1), FieldStruct.UNKNOWN_INT1, FieldStruct.UNKNOWN_INT1,
					new FieldStruct("Unknown string", Type.STRING, 100), new FieldStruct("Unknown string", Type.STRING, 100),
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
			};
			newEntryValues = new Object[]{
					"<New object>", 0, -1, -1, 0, -1, 0, 0,
					0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f,
					0f, 0f, 0, 0, 0f, 0f, 0, -1,
					0, 0, 0, 0, 0, 0, 0, -1,
					-1, 0, 0f, "<Object type>", 0, 0, -1, -1,
					0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f,
					-1, -1, -1, -1, -1, -1, 0, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, 0, 0, 0f, 0, -1, 0f, 0,
					0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0f, -1, 0f,
					0, 0, 0, 0, 0, 0, 0, 204,
					0, 0, 0f, 0f, 0, 0f, 0f, 0,
					1, 204, 204, 0f, 0f, 0, 0, 0,
					0, 0, -1, 0, 0, 0, 0, 0,
					0, 0, 0, 0f, 1, 0, 0, 0,
					0, 0, 204, 204, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, 0f, 0, 0, 0, 0,
					1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 1, 1, 1, 0,
					0, 0, 204, 204, -1, -1, -1, -1,
					0, 0, 0, 0f, 0, 0, 0, 0,
					0, 204, 0, 0, 0, 0, 0, 0,
					0, 0, 0, -1, 0, 0, 0, 0,
					0f, 0f, 0f, 0f, 0f, 0, 0, 0,
					0, -1, 1, 0, 0, 204, 0, 0,
					0, 0, 0, 0, 0f, 0f, 0f, 0f,
					0f, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
			};



		} else {



			fieldStructs = new FieldStruct[]{
					FieldStruct.NAME, FieldStruct.SEQ_NUMBER, ID_FAMILY, FieldStruct.UNKNOWN_INT4,
					FieldStruct.UNKNOWN_INT4, FieldStruct.ID, new FieldStruct("Health", Type.INTEGER), FieldStruct.UNKNOWN_INT4,
					new FieldStruct("Min range", Type.FLOAT), new FieldStruct("Max range", Type.FLOAT), new FieldStruct("Line of sight", Type.FLOAT), new FieldStruct("Attack reload time", Type.FLOAT),
					new FieldStruct("Area of effect", Type.FLOAT), new FieldStruct("Speed", Type.FLOAT), new FieldStruct("Acceleration/Deceleration", Type.FLOAT), new FieldStruct("Idle turning speed", Type.FLOAT),
					new FieldStruct("Moving turning speed", Type.FLOAT), FieldStruct.UNKNOWN_FLOAT, new FieldStruct("<PROBABLY> Is air unit", Type.INTEGER), new FieldStruct("Flight time", Type.INTEGER),
					FieldStruct.UNKNOWN_FLOAT, new FieldStruct("Attack angle", Type.FLOAT), new FieldStruct("<PROBABLY> Attack from the side", Type.INTEGER), ID_WEAPON_TO_HIT,
					new FieldStruct("Attack", Type.INTEGER), new FieldStruct("Shock armor", Type.INTEGER), new FieldStruct("Arrow armor", Type.INTEGER), new FieldStruct("Pierce armor", Type.INTEGER),
					new FieldStruct("Gun armor", Type.INTEGER), new FieldStruct("Laser armor", Type.INTEGER), new FieldStruct("Missile armor", Type.INTEGER), new FieldStruct("Projectile ID", Objects.instance, 0),
					new FieldStruct("Family attack multiplier index", IntStream.range(0, 66).boxed().toArray(Integer[]::new)), FieldStruct.UNKNOWN_INT4, new FieldStruct("Graphic size", Type.FLOAT), new FieldStruct("Unit type", Type.STRING, 52),
					new FieldStruct("Unit type", UnitType.values()), FieldStruct.UNUSED_INT4, ID_BUTTON, ID_GRAPHIC,
					new FieldStruct("Build rate", Type.FLOAT), new FieldStruct("Iron gather rate", Type.FLOAT), new FieldStruct("Farm gather rate", Type.FLOAT), new FieldStruct("Gold gather rate", Type.FLOAT),
					new FieldStruct("Stone gather rate", Type.FLOAT), new FieldStruct("Wood gather rate", Type.FLOAT), new FieldStruct("Hunt gather rate", Type.FLOAT), new FieldStruct("Forage gather rate", Type.FLOAT),
					new FieldStruct("Creation sound", Sounds.instance, 0), new FieldStruct("Action sound 1", Sounds.instance, 0), new FieldStruct("Action sound 2", Sounds.instance, 0), new FieldStruct("Selection sound 1", Sounds.instance, 0),
					new FieldStruct("Selection sound 2", Sounds.instance, 0), new FieldStruct("Death sound", Sounds.instance, 0), new FieldStruct("<PROBABLY> Can build", Type.BOOLEAN), ID_BUTTON_COMMAND,
					ID_BUTTON_COMMAND, ID_BUTTON_COMMAND, ID_BUTTON_COMMAND, ID_BUTTON_COMMAND,
					ID_BUTTON_COMMAND, ID_BUTTON_COMMAND, ID_BUTTON_COMMAND, ID_BUTTON_COMMAND,
					FieldStruct.UNCHANGED_INT4, new FieldStruct("Square occupied", Type.INTEGER), new FieldStruct("Resource type", ResourceType.values()), new FieldStruct("Resource amount", Type.FLOAT),
					new FieldStruct("Always face camera", Type.INTEGER), FieldStruct.UNKNOWN_INT4, new FieldStruct("Rotting time", Type.FLOAT), new FieldStruct("Population count", Type.INTEGER),
					new FieldStruct("Transport capacity", Type.INTEGER), new FieldStruct("Show area effect stat"), new FieldStruct("Show repair stat"), new FieldStruct("Show shock armor stat"),
					new FieldStruct("Show pierce armor stat"), new FieldStruct("Show arrow armor stat"), new FieldStruct("Show laser armor stat"), new FieldStruct("Show gun armor stat"),
					new FieldStruct("Show missile armor stat"), new FieldStruct("Show range", Type.INTEGER), new FieldStruct("Morale bonus", Type.INTEGER), FieldStruct.UNKNOWN_INT4,
					FieldStruct.UNKNOWN_INT4, FieldStruct.UNKNOWN_FLOAT, FieldStruct.UNUSED_INT4, new FieldStruct("Flight altitude", Type.FLOAT),
					FieldStruct.ID_LANGUAGE, FieldStruct.UNKNOWN_INT4, new FieldStruct("Healer heal amount", Type.INTEGER), new FieldStruct("Health regeneration", Type.INTEGER),
					new FieldStruct("Can garrison in air transports"), new FieldStruct("Can garrison in land transports"), new FieldStruct("Can garrison in sea transports"), FieldStruct.UNUSED_INT1,
					new FieldStruct("Object type", ObjectType.values()), FieldStruct.UNKNOWN_INT4, new FieldStruct("Circle selection size", Type.FLOAT), new FieldStruct("Shadow size", Type.FLOAT),
					FieldStruct.UNUSED_INT4, new FieldStruct("Formation size", Type.FLOAT), new FieldStruct("Physical size", Type.FLOAT), new FieldStruct("Interact/obstruct/bump other objects"),
					FieldStruct.UNKNOWN_INT1, FieldStruct.UNKNOWN_INT1, FieldStruct.UNKNOWN_INT1, FieldStruct.UNKNOWN_FLOAT,
					new FieldStruct("Initial projectile angle", Type.FLOAT), new FieldStruct("Ammo amount", Type.INTEGER), new FieldStruct("<All bombers use this>"), FieldStruct.UNKNOWN_BOOL1,
					FieldStruct.UNKNOWN_BOOL1, new FieldStruct("<PROBABLY> Parabolic projectile"), FieldStruct.UNKNOWN_INT4, FieldStruct.UNUSED_INT4,
					new FieldStruct("Category (Heroes use 27)", Type.INTEGER), FieldStruct.UNKNOWN_INT4, FieldStruct.UNKNOWN_INT4, FieldStruct.UNKNOWN_INT4,
					FieldStruct.UNKNOWN_INT4, ID_UPGRADE, new FieldStruct("<Used by units/buildings who can convert>", Type.INTEGER), FieldStruct.UNKNOWN_FLOAT,
					new FieldStruct("Can be owned by a player"), new FieldStruct("Can be owned by \"World\""), FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNKNOWN_BOOL1,
					new FieldStruct("Can be killed with Delete"), FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNKNOWN_INT1, FieldStruct.UNUSED_INT1,
					new FieldStruct("Low health effect ID", GFXEffects.instance, 0), new FieldStruct("Death effect ID", GFXEffects.instance, 0), new FieldStruct("Start of attack ID", GFXEffects.instance, 0), ID_GFX_UNKNOWN,
					new FieldStruct("Movement effect", GFXEffects.instance, 0), ID_GFX_UNKNOWN, new FieldStruct("Heal other effect ID", GFXEffects.instance, 0), ID_GFX_UNKNOWN,
					ID_GFX_UNKNOWN, new FieldStruct("Get hit effect ID", GFXEffects.instance, 0), new FieldStruct("Permanent effect", GFXEffects.instance, 0), ID_GFX_UNUSED,
					new FieldStruct("Projectile effect", GFXEffects.instance, 0), ID_GFX_UNUSED, ID_GFX_UNUSED, ID_GFX_UNUSED,
					ID_GFX_UNUSED, ID_GFX_UNUSED, ID_GFX_UNKNOWN, new FieldStruct("<only used by volcano-projectile and meteor>", Type.INTEGER),
					new FieldStruct("Attack effect ID", GFXEffects.instance, 0), new FieldStruct("Disease effect ID 1", GFXEffects.instance, 0), new FieldStruct("Disease effect ID 2", GFXEffects.instance, 0), new FieldStruct("Diffraction shield effect ID", GFXEffects.instance, 0),
					new FieldStruct("Pulse cannon effect ID", GFXEffects.instance, 0), new FieldStruct("Battle cry effect ID", GFXEffects.instance, 0), new FieldStruct("Bomb hole effect ID", GFXEffects.instance, 0), ID_GFX_UNUSED,
					ID_GFX_UNKNOWN, FieldStruct.UNUSED_INT4, FieldStruct.UNKNOWN_INT4, new FieldStruct("<only used by ships>", Type.FLOAT),
					FieldStruct.UNUSED_INT4, FieldStruct.UNUSED_INT4, FieldStruct.UNUSED_INT4, FieldStruct.UNUSED_INT4,
					new FieldStruct("Terrain: Grass, Snow"), new FieldStruct("Elevation: Deep water"), new FieldStruct("Terrain: Rock, Stones and Artificial"), FieldStruct.UNKNOWN_BOOL1,
					FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNKNOWN_BOOL1,
					FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNKNOWN_BOOL1, new FieldStruct("Terrain: Asphalt"), new FieldStruct("Elevation: cliffs"),
					new FieldStruct("Elevation: Shallow water"), FieldStruct.UNKNOWN_BOOL1, new FieldStruct("Terrain: Sand"), new FieldStruct("Terrain: Space"),
					FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNUSED_INT1, FieldStruct.UNUSED_INT1,
					ID_AREA_EFFECT, ID_AREA_EFFECT, ID_AREA_EFFECT, ID_AREA_EFFECT,
					FieldStruct.UNUSED_INT4, FieldStruct.UNUSED_INT4, FieldStruct.UNUSED_INT4, new FieldStruct("Carry capacity", Type.FLOAT),
					FieldStruct.UNKNOWN_INT4, FieldStruct.UNUSED_INT4, FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNUSED_BOOL1,
					FieldStruct.UNKNOWN_BOOL1, FieldStruct.UNUSED_INT1, FieldStruct.UNKNOWN_INT4, FieldStruct.UNKNOWN_INT4,
					new FieldStruct("Debris on death", Objects.instance, 0), new FieldStruct("Debris on death", Objects.instance, 0), FieldStruct.UNKNOWN_INT4, new FieldStruct("Min stealth radius", Type.INTEGER),
					new FieldStruct ("<It seems \"Interaction type\">", Type.INTEGER), new FieldStruct("Max citizens garrison", Type.INTEGER), new FieldStruct("Initial citizens garrison", Type.INTEGER), new FieldStruct("Garrison upgrade object to", TechTree.instance, 0),
					new FieldStruct ("Plane refuel location", Type.INTEGER), new FieldStruct("<Seems related to ships...>", Type.INTEGER), new FieldStruct("Wonder bonus", WonderType.values()), new FieldStruct ("Effect apply to", UnitSet.instance, 0),
					FieldStruct.UNKNOWN_FLOAT, FieldStruct.UNKNOWN_FLOAT, new FieldStruct("Friendly damage mult", Type.FLOAT), new FieldStruct("Garrison citizens bonus", Type.FLOAT),
					FieldStruct.UNKNOWN_FLOAT, FieldStruct.UNUSED_INT4, FieldStruct.UNKNOWN_INT4, FieldStruct.UNKNOWN_INT4,
					new FieldStruct("Num techs it can build", Type.INTEGER, 4, false), ID_TECH, new FieldStruct("Is building?"), new FieldStruct("Stealth"),
					FieldStruct.UNKNOWN_BOOL1, new FieldStruct("<Seems related to aircraft, but the clubman...>", Type.INTEGER, 1), FieldStruct.UNKNOWN_INT4, new FieldStruct("Spawn on death", Objects.instance, 0),
					new FieldStruct("Power", Type.INTEGER), new FieldStruct("Power recover rate", Type.INTEGER), new FieldStruct("Default stance", UnitBehavior.instance, 0), new FieldStruct("Conversion time", Type.INTEGER),
					FieldStruct.UNKNOWN_FLOAT, new FieldStruct("<It seems heal power, but the roman legionnaire...>", Type.FLOAT, 4, Knowledge.UNKNOWN), FieldStruct.UNKNOWN_FLOAT, new FieldStruct("<PROBABLY> Load range", Type.FLOAT),
					new FieldStruct("<PROBABLY> Unload range", Type.FLOAT), new FieldStruct("Can walk through trees"), FieldStruct.UNUSED_BOOL1, FieldStruct.UNKNOWN_BOOL1,
					new FieldStruct("Can attack area"), new FieldStruct("<PROBABLY> Melee attack"), new FieldStruct("Garrison heal rate", Type.INTEGER, 1), FieldStruct.UNKNOWN_INT1, FieldStruct.UNKNOWN_INT1,
					new FieldStruct("Unknown string", Type.STRING, 100), new FieldStruct("Unknown string", Type.STRING, 100),
					FieldStruct.UNUSED_INT4, FieldStruct.UNUSED_INT4, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH,
					ID_OBJECT_BUILD_TECH, ID_OBJECT_BUILD_TECH, FieldStruct.UNKNOWN_INT4
			};
			newEntryValues = new Object[]{
					"<New object>", 0, -1, -1, 0, -1, 0, 0,
					0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f,
					0f, 0f, 0, 0, 0f, 0f, 0, -1,
					0, 0, 0, 0, 0, 0, 0, -1,
					-1, 0, 0f, "<Object type>", 0, 0, -1, -1,
					0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f,
					-1, -1, -1, -1, -1, -1, 0, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, 0, 0, 0f, 0, -1, 0f, 0,
					0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0f, -1, 0f,
					0, 0, 0, 0, 0, 0, 0, 204,
					0, 0, 0f, 0f, 0, 0f, 0f, 0,
					1, 204, 204, 0f, 0f, 0, 0, 0,
					0, 0, -1, 0, 0, 0, 0, 0,
					0, 0, 0, 0f, 1, 0, 0, 0,
					0, 0, 204, 204, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, 0f, 0, 0, 0, 0,
					1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 1, 1, 1, 0,
					0, 0, 204, 204, -1, -1, -1, -1,
					0, 0, 0, 0f, 0, 0, 0, 0,
					0, 204, 0, 0, 0, 0, 0, 0,
					0, 0, 0, -1, 0, 0, 0, 0,
					0f, 0f, 0f, 0f, 0f, 0, 0, 0,
					0, -1, 1, 0, 0, 204, 0, 0,
					0, 0, 0, 0, 0f, 0f, 0f, 0f,
					0f, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1,
					0
			};
		}
	}

	@Override
	public int indexExtraFields () {
		return -1;
	}

}