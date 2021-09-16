package in.geektrust.crown.model;



import org.junit.Assert;
import org.junit.Test;

import in.geektrust.crown.exceptions.InvalidKingdomException;


public class KingdomTest {

	@Test
	public void validateMessageByKingdom_GivenValidMessage_ShouldReturnTrue() throws InvalidKingdomException {

		String kingdomName = "LAND";
		String encryptedMessage = "FAIJWJSOOFAMAU";
		String emblemName = "PANDA";
		// Arrange
		Message messageFromking = new Message(kingdomName, encryptedMessage);
		Kingdom kingdom = new Kingdom(kingdomName, emblemName);

		// Act
		boolean actualValue = kingdom.validateMessageByKingdom(messageFromking);

		// Assert
		Assert.assertTrue(actualValue);
	}

	@Test
	public void validateMessageByKingdom_GivenValidMessage_ShouldReturnFalse() throws InvalidKingdomException {

		String kingdomName = "LAND";
		String encryptedMessage = "ABCD";
		String emblemName = "PANDA";
		// Arrange
		Message messageFromking = new Message(kingdomName, encryptedMessage);
		Kingdom kingdom = new Kingdom(kingdomName, emblemName);

		// Act
		boolean actualValue = kingdom.validateMessageByKingdom(messageFromking);

		// Assert
		Assert.assertFalse(actualValue);
	}

	@Test(expected = InvalidKingdomException.class)
	public void validateMessageByKingdom_GivenInvalidKingdom_ShouldThrowException() throws InvalidKingdomException {

		String kingdomName = "LAND";
		String encryptedMessage = "FAIJWJSOOFAMAU";
		String emblemName = "PANDA";
		String invalidMessage = "LA";
		// Arrange
		Message messageFromking = new Message(invalidMessage, encryptedMessage);
		Kingdom kingdom = new Kingdom(kingdomName, emblemName);

		// Act
        kingdom.validateMessageByKingdom(messageFromking);

	}

}
