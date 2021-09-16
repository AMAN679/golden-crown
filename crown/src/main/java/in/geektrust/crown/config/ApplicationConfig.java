package in.geektrust.crown.config;

import in.geektrust.crown.repositories.KingdomRepository;
import in.geektrust.crown.repositories.KingdomRepositoryImpl;
import in.geektrust.crown.repositories.data.Data;
import in.geektrust.crown.repositories.data.KingdomData;
import in.geektrust.crown.services.MessageService;

/**
 * ApplicationConfig class for Configuring initial setup between different
 * layers and for loading Kingdom data
 * 
 * @author - Aman Singh
 * @version 1.0
 */

public class ApplicationConfig {

	private final KingdomRepository kingdomRepository = new KingdomRepositoryImpl();
	private final MessageService messageService = new MessageService(kingdomRepository);
	Data loadKingdomData = new KingdomData(kingdomRepository);

	public Data getKingdomDataLoader() {
		return loadKingdomData;
	}

	public MessageService getMessageService() {
		return messageService;
	}

}