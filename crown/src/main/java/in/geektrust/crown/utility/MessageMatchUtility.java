package in.geektrust.crown.utility;

import java.util.Map;

import in.geektrust.crown.globals.Constants;
import in.geektrust.crown.model.Message;

/**
 * MessageMatchUtility Class to validate the secret message
 * 
 * @author - Aman Singh
 * @version 1.0
 */

public class MessageMatchUtility {

	/**
	 * 
	 * @param messageFromKing  contains message from kingdom
	 * @param decryptedMessage contains decrypted message
	 * @return true if message is valid else false
	 */
	public boolean isMessageMatching(Message messageFromKing, String decryptedMessage) {
		Constants constants = new Constants();
		Map<String, String> kingdomToEmblemMappig = constants.getMapOfKingdomToEmblemMapping();
		boolean isValid = validateMessageAndEmblemName(decryptedMessage,
				kingdomToEmblemMappig.get(messageFromKing.getKingdomName()));
		return isValid;
	}

	private boolean validateMessageAndEmblemName(String decryptedMessage, String emblemName) {
		int characterCountArrayForEmblemName[] = new int[Constants.NUMBER_OF_ALPABETS];
		updateEmblemCountArrayByEmblemName(emblemName, characterCountArrayForEmblemName);
		updateEmblemCountArrayByDecrytedMessage(decryptedMessage, characterCountArrayForEmblemName);
		return validateUpdatedEmblemCountArray(characterCountArrayForEmblemName);

	}

	private boolean validateUpdatedEmblemCountArray(int[] characterCountArrayForEmblemName) {
		for (int index = 0; index < characterCountArrayForEmblemName.length; index++) {
			if (characterCountArrayForEmblemName[index] > 0) {
				return false;
			}
		}
		return true;
	}

	private void updateEmblemCountArrayByEmblemName(String emblemName, int[] characterCountArrayForEmblemName) {
		for (int index = 0; index < emblemName.length(); index++) {
			if (emblemName.charAt(index) >= Constants.ASCII_OF_CHARACTER_A
					&& emblemName.charAt(index) <= Constants.ASCII_OF_CHARACTER_Z) {
				characterCountArrayForEmblemName[emblemName.charAt(index) - Constants.ASCII_OF_CHARACTER_A]++;
			}
		}
	}

	private void updateEmblemCountArrayByDecrytedMessage(String decryptedMessage,
			int characterCountArrayForEmblemName[]) {
		for (int index = 0; index < decryptedMessage.length(); index++) {
			if (decryptedMessage.charAt(index) >= Constants.ASCII_OF_CHARACTER_A
					&& decryptedMessage.charAt(index) <= Constants.ASCII_OF_CHARACTER_Z)
				characterCountArrayForEmblemName[decryptedMessage.charAt(index) - Constants.ASCII_OF_CHARACTER_A]--;
		}
	}

}
