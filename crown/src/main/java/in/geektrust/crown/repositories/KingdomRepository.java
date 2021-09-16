package in.geektrust.crown.repositories;

import java.util.List;
import java.util.Map;

import in.geektrust.crown.model.Kingdom;

/**
 * KingdomRepository Interface
 * 
 * @author - Aman Singh
 * @version 1.0
 */

public interface KingdomRepository {

	/**
	 * 
	 * @param kingdom to save the Kingdom to Kingdom Repository
	 */
	void saveKingdom(Kingdom kingdom);

	/**
	 * 
	 * @return all the saved kingdom
	 */
	List<Kingdom> getAllKingdom();

	/**
	 * 
	 * @return kingdom to Emblem Mapping
	 */
	Map<String, String> getKingdomToEmblemMappig();
}
