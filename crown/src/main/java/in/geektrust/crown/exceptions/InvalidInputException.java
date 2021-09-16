package in.geektrust.crown.exceptions;

/**
 * InvalidInputException Custom Class for InvalidInput
 * 
 * @author - Aman Singh
 * @version 1.0
 */
public class InvalidInputException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param errorMessage to set error message of the super class
	 */
	public InvalidInputException(String errorMessage) {
		super(errorMessage);
	}

}
