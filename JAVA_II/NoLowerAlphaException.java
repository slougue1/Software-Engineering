/**
 * NoLowerAlphaException Class
 * @author sakina lougue
 *
 */
public class NoLowerAlphaException extends Exception{
	/**
	 * Default constructor of NoLowerAlphaException
	 * Assigns appropriate message to print in case exception happens
	 */
	public NoLowerAlphaException() {
		super("The password must contain at least one lower case alphabetic character");
	}
}
