package in.geektrust.crown.repositories.data;

import java.util.Map;

import in.geektrust.crown.globals.Constants;
import in.geektrust.crown.model.Kingdom;
import in.geektrust.crown.repositories.KingdomRepository;

/**
 * KingdomData implementation class for Data to save Kingdom to Repository
 * 
 * @author - Aman Singh
 * @version 1.0
 */
public class KingdomData implements Data {

	private final KingdomRepository kingdomRepository;

	public KingdomData(KingdomRepository kingdomRepository) {
		this.kingdomRepository = kingdomRepository;
	}

	@Override
	public void loadData() {

		Constants constants = new Constants();
		Map<String, String> kingdomToEmblemMapping = constants.getMapOfKingdomToEmblemMapping();

		for (Map.Entry<String, String> kingdomToEmblemMapEntry : kingdomToEmblemMapping.entrySet()) {
			addKingdom(kingdomToEmblemMapEntry.getKey(), kingdomToEmblemMapEntry.getValue());
		}

	}

	/**
	 * 
	 * @param kingdomName to be saved to Kingdom Repository
	 * @param emblemName  to be saved to Kingdom Repository
	 */
	private void addKingdom(String kingdomName, String emblemName) {
		kingdomRepository.saveKingdom(new Kingdom(kingdomName, emblemName));
	}
}
