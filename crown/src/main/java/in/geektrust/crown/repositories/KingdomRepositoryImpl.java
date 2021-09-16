package in.geektrust.crown.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.geektrust.crown.model.Kingdom;

/**
 * KingdomRepositoryImpl implementation class for KingdomRepository
 * 
 * @author - Aman Singh
 * @version 1.0
 */
public class KingdomRepositoryImpl implements KingdomRepository {

	private List<Kingdom> kingdomList;

	/**
	 * Constructor to initialize kingdomList
	 */
	public KingdomRepositoryImpl() {
		kingdomList = new ArrayList<Kingdom>();
	}

	public KingdomRepositoryImpl(List<Kingdom> kingdomList) {
		this.kingdomList = kingdomList;
	}

	@Override
	public void saveKingdom(Kingdom kingdom) {
		this.kingdomList.add(kingdom);

	}

	@Override
	public List<Kingdom> getAllKingdom() {
		return this.kingdomList;
	}

	@Override
	public Map<String, String> getKingdomToEmblemMappig() {
		Map<String, String> kingdomToEmblemMapping = new HashMap<>();
		for (Kingdom kingdom : this.kingdomList) {
			kingdomToEmblemMapping.put(kingdom.getName(), kingdom.getEmblemName());
		}
		return kingdomToEmblemMapping;
	}

}
