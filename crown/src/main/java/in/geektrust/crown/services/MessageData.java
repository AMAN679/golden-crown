package in.geektrust.crown.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import in.geektrust.crown.exceptions.InvalidInputException;
import in.geektrust.crown.model.Message;

/**
 * MessageData Class to read Message from input file
 * 
 * @author - Aman Singh
 * @version 1.0
 */

public class MessageData {

	private List<Message> allMessagesSentByKing;

	public MessageData() {
		this.allMessagesSentByKing = new ArrayList<>();
	}

	/**
	 * 
	 * @param inputFile -path of the input file
	 * @return the list of messages sent by King to others kingdom
	 * @throws InvalidInputException for invalid input
	 */
	public List<Message> getAllMessageSend(String inputFile) throws InvalidInputException {
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(inputFile));
			String line = reader.readLine();
			while (line != null) {

				if (line.indexOf(' ') == -1) {
					throw new InvalidInputException("Invalid Input Please Provide Correct Input.");
				}
				String messageSentToKingdom = line.substring(0, line.indexOf(' '));
				String encryptedMessage = line.substring(line.indexOf(' ') + 1);
				this.allMessagesSentByKing
						.add(new Message(messageSentToKingdom.toUpperCase(), encryptedMessage.toUpperCase()));
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return allMessagesSentByKing;
	}
}