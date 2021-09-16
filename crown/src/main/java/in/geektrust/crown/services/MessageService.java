package in.geektrust.crown.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import in.geektrust.crown.exceptions.InvalidInputException;
import in.geektrust.crown.exceptions.InvalidKingdomException;
import in.geektrust.crown.model.Kingdom;
import in.geektrust.crown.model.Message;
import in.geektrust.crown.repositories.KingdomRepository;

/**
 * MessageService Class to manipulate the Messages Sent by King to other
 * kingdoms
 * 
 * @author - Aman Singh
 * @version 1.0
 */

public class MessageService {

	private KingdomRepository kingdomRepository;

	public MessageService(KingdomRepository kingdomRepository) {
		this.kingdomRepository = kingdomRepository;
	}

	/**
	 * 
	 * @param inputFile path of input file to read messages
	 * @param allySet   contains allies of SPACE Kingdom
	 * @throws InvalidKingdomException if invalid kingdom name given
	 * @throws InvalidInputException   if invalid input
	 */
	public void processMessage(String inputFile, Set<Kingdom> allySet)
			throws InvalidKingdomException, InvalidInputException {
		MessageData messageData = new MessageData();
		Map<String, String> kingdomToEmblemMappig = kingdomRepository.getKingdomToEmblemMappig();
		List<Message> messagesSentToKingdom = messageData.getAllMessageSend(inputFile);
		sendMessageToKingdom(kingdomToEmblemMappig, messagesSentToKingdom, allySet);
	}

	/**
	 * 
	 * Method to send messages to Kingdom
	 * 
	 * @param kingdomToEmblemMappig - contains Kingdom and the corresponding Emblem
	 *                              Name
	 * @param messagesSentToKingdom - contains list of messages sent to Kingdom
	 * @param allySet               contains allies of SPACE Kingdom
	 * @throws InvalidKingdomException if invalid kingdom name given
	 */
	private void sendMessageToKingdom(Map<String, String> kingdomToEmblemMappig, List<Message> messagesSentToKingdom,
			Set<Kingdom> allySet) throws InvalidKingdomException {
		for (Message messageFromKing : messagesSentToKingdom) {
			Kingdom kingdom = new Kingdom(messageFromKing.getKingdomName(),
					kingdomToEmblemMappig.get(messageFromKing.getKingdomName()));
			if (kingdom.validateMessageByKingdom(messageFromKing)) {
				allySet.add(kingdom);
			}
		}
	}
}
