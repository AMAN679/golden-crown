package in.geektrust.crown.exceptions;

/**
 * InvalidKingdomException Custom Class for Invalid Kingdom Name
 * 
 * @author - Aman Singh
 * @version 1.0
 */
public class InvalidKingdomException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param errorMessage to set error message of the super class
	 */
	public InvalidKingdomException(String errorMessage) {
		super(errorMessage);
	}
}
