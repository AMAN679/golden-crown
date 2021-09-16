package in.geektrust.crown.model;

/**
 * Message Model, which contains Kingdom Name and Encrypted Message Sent by King
 * 
 * @author - Aman Singh
 * @version 1.0
 */

public class Message {

	private String kingdomName;
	private String encryptedMessage;

	/**
	 * Parameterized Constructor to Instantiate Message
	 * 
	 * @param kingdomName      kingdom name to which the message is sent
	 * @param encryptedMessage message sent by king to kingdom
	 */
	public Message(String kingdomName, String encryptedMessage) {
		super();
		this.kingdomName = kingdomName;
		this.encryptedMessage = encryptedMessage;
	}

	/**
	 * @return the name of Kingdom to which message is sent
	 */
	public String getKingdomName() {
		return kingdomName;
	}

	/**
	 * @param kingdomName set Kingdom Name to which message is sent
	 */
	public void setKingdomName(String kingdomName) {
		this.kingdomName = kingdomName;
	}

	/**
	 * @return the encrypted Message
	 */
	public String getEncryptedMessage() {
		return encryptedMessage;
	}

	/**
	 * @param encryptedMessage set encrypted Message to be sent
	 */
	public void setEncryptedMessage(String encryptedMessage) {
		this.encryptedMessage = encryptedMessage;
	}
}
