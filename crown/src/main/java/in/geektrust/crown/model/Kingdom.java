package in.geektrust.crown.model;

import java.util.Objects;

import in.geektrust.crown.exceptions.InvalidKingdomException;
import in.geektrust.crown.utility.MessageDecryptionUtility;
import in.geektrust.crown.utility.MessageMatchUtility;

/**
 * Kingdom Model, which contains Kingdom Name, Associated Emblem Name
 * MessageDecryptionUtility and MessageMatchUtility
 * 
 * @author - Aman Singh
 * @version 1.0
 */

public class Kingdom {

	private String name;
	private String emblemName;
	private MessageDecryptionUtility messageDecrytionUtility;
	private MessageMatchUtility messageMatchUtility;

	/**
	 * Parameterized Constructor to Instantiate Kingdom
	 * 
	 * @param name       represent kingdom name
	 * @param emblemName represent Associated Emblem Name for Kingdom
	 */
	public Kingdom(String name, String emblemName) {
		super();
		this.name = name;
		this.emblemName = emblemName;
		this.messageDecrytionUtility = new MessageDecryptionUtility();
		this.messageMatchUtility = new MessageMatchUtility();
	}

	/**
	 * @return the name of Kingdom
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name set the name of Kingdom
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name of Emblem Name Associated with Kingdom
	 */
	public String getEmblemName() {
		return emblemName;
	}

	/**
	 * @param emblemName set the name of Emblem Name Associated with Kingdom
	 */
	public void setEmblemName(String emblemName) {
		this.emblemName = emblemName;
	}

	/**
	 * @param messageFromKing message from king to be validated
	 * @throws InvalidKingdomException if Kingdom Name is incorrect in message
	 */
	public boolean validateMessageByKingdom(Message messageFromKing) throws InvalidKingdomException {
		String decryptedMessage = this.messageDecrytionUtility.getDecryptedMessage(messageFromKing);
		boolean isValidMessage = this.messageMatchUtility.isMessageMatching(messageFromKing, decryptedMessage);
		return isValidMessage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kingdom other = (Kingdom) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
