package in.geektrust.crown.utility;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import in.geektrust.crown.exceptions.InvalidKingdomException;
import in.geektrust.crown.model.Message;

public class MesssageDecryptionUtilityTest {

	private MessageDecryptionUtility decryptionUtility;
	private String kingdomName;

	@Before
	public void setup() {
		decryptionUtility = new MessageDecryptionUtility();
		kingdomName = "LAND";
	}

	@Test
	public void getDecryptedMessage_GivenValidEncryptedMessage() throws InvalidKingdomException {
		String encryptedMessage = "FAIJWJSOOFAMAU";
		Message secretMessage = new Message(kingdomName, encryptedMessage);
		String expectedMessage = "AVDERENJJAVHVP";
		String actualMessage = decryptionUtility.getDecryptedMessage(secretMessage);
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void getDecryptedMessage_GivenInvalidEncryptedMessage() throws InvalidKingdomException {
		String encryptedMessage = "FAIJWJS";
		Message secretMessage = new Message(kingdomName, encryptedMessage);
		String unexpectedMessage = "AVDERENJJAVHVP";
		String actualMessage = decryptionUtility.getDecryptedMessage(secretMessage);
		Assert.assertNotEquals(unexpectedMessage, actualMessage);
	}

	@Test(expected = InvalidKingdomException.class)
	public void getDecryptedMessage_GivenInvalidKingdom_ShouldThrowException() throws InvalidKingdomException {

		MessageDecryptionUtility decryptionUtility = new MessageDecryptionUtility();
		kingdomName = "LA";
		String encryptedMessage = "FAIJWJSOOFAMAU";
		Message secretMessage = new Message(kingdomName, encryptedMessage);
		String expectedMessage = "AVDERENJJAVHVP";
		String actualMessage = decryptionUtility.getDecryptedMessage(secretMessage);
		Assert.assertEquals(expectedMessage, actualMessage);

	}

}
