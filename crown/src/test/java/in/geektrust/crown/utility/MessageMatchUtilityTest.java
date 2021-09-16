package in.geektrust.crown.utility;

import org.junit.Test;

import in.geektrust.crown.model.Message;
import org.junit.Assert;
import org.junit.Before;

public class MessageMatchUtilityTest {

	private MessageMatchUtility messageMatchUtility;
	private String kingdomName;

	@Before
	public void setUp() {
		messageMatchUtility = new MessageMatchUtility();
		kingdomName = "LAND";
	}

	@Test
	public void matchMessage_Given_ValidMessageFromKingAndDecryptedMessage() {

		String encryptedMessage = "FAIJWJSOOFAMAU";
		Message secretMessage = new Message(kingdomName, encryptedMessage);
		String decryptedMessage = "AVDERENJJAVHVP";
		boolean expectedValue = messageMatchUtility.isMessageMatching(secretMessage, decryptedMessage);
		Assert.assertTrue(expectedValue);
	}

	@Test
	public void matchMessage_Given_InvalidMessageFromKingAndDecryptedMessage() {
		String encryptedMessage = "FAIJ";
		Message secretMessage = new Message(kingdomName, encryptedMessage);
		String decryptedMessage = "AVDE";
		boolean expectedValue = messageMatchUtility.isMessageMatching(secretMessage, decryptedMessage);
		Assert.assertFalse(expectedValue);
	}
}
