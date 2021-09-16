package in.geektrust.crown.utility;

import java.util.Map;

import in.geektrust.crown.exceptions.InvalidKingdomException;
import in.geektrust.crown.globals.Constants;
import in.geektrust.crown.model.Message;

/**
 * MessageDecryptionUtility Class to Decrypt the encrypted Message kingdoms
 * 
 * @author - Aman Singh
 * @version 1.0
 */

public class MessageDecryptionUtility {

	/**
	 * Method to decrypt the encrypted message
	 * 
	 * @param encryptedMessage contains the encrypted Message from King
	 * @return the decrypted mesage
	 * @throws InvalidKingdomException if Kingdom Name is invalid
	 */
	public String getDecryptedMessage(Message encryptedMessage) throws InvalidKingdomException {
		Constants constants = new Constants();
		Map<String, String> kingdomToEmblemMappig = constants.getMapOfKingdomToEmblemMapping();
		int cipherKey;
		if (kingdomToEmblemMappig.get(encryptedMessage.getKingdomName()) == null) {
			throw new InvalidKingdomException("Sending Message to Invalid Kingdom! Pleae Send to Valid Kingdom.");
		}
		cipherKey = kingdomToEmblemMappig.get(encryptedMessage.getKingdomName()).length();

		return getDecryptSecretMessage(cipherKey, encryptedMessage.getEncryptedMessage().toUpperCase());
	}

	/**
	 * 
	 * @param cipherKey for every message based on Emblem name length
	 * @param secretMessage sent by king
	 * @return decrypted message
	 */
	private String getDecryptSecretMessage(int cipherKey, String secretMessage) {
		String decryptedMessage = "";
		for (int index = 0; index < secretMessage.length(); index++) {
			char characterOfSecretMessage = secretMessage.charAt(index);
			if (characterOfSecretMessage >= 'A' && characterOfSecretMessage <= 'Z') {
				characterOfSecretMessage = (char) (characterOfSecretMessage - cipherKey);
				if (characterOfSecretMessage < 'A') {
					characterOfSecretMessage = (char) (characterOfSecretMessage + 'Z' - 'A' + 1);
				}
				decryptedMessage += characterOfSecretMessage;
			} else {
				decryptedMessage += characterOfSecretMessage;
			}
		}
		return decryptedMessage;
	}
}
