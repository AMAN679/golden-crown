package in.geektrust.crown.globals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Constant Class, which contains constants to be used globally
 * 
 * @author - Aman Singh
 * @version 1.0
 */
public class Constants {

	private final Map<String, String> kingdomToEmblemMappig = initMap();
	public static final String RULER_NAME = "SHAN";
	public static final int NUMBER_OF_ALPABETS = 26;
	public static final int ASCII_OF_CHARACTER_A = 65;
	public static final int ASCII_OF_CHARACTER_Z = 90;
	public static final int MIN_ALLIES_REQUIRE_INCLUDING_SPACE = 4;
	public static final String SHAN_CANNOT_RULE = "NONE";
	public static final String SHAN_KINGDOM = "SPACE";
	public static final String SPACE_KINGDOM_EMBLEM = "GORILLA";

	/**
	 * initialize the kingdomToEmblemMappig Map
	 */
	public Map<String, String> initMap() {
		Map<String, String> map = new HashMap<>();
		map.put("SPACE", "GORILLA");
		map.put("LAND", "PANDA");
		map.put("WATER", "OCTOPUS");
		map.put("ICE", "MAMMOTH");
		map.put("AIR", "OWL");
		map.put("FIRE", "DRAGON");
		return Collections.unmodifiableMap(map);
	}

	/**
	 * @return the kingdom to EmblemMap
	 */
	public Map<String, String> getMapOfKingdomToEmblemMapping() {
		return kingdomToEmblemMappig;
	}

}
