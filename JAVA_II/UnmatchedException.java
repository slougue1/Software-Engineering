/**
 * UnmatchedException Class
 * @author sakina lougue
 *
 */
public class UnmatchedException extends Exception {
	/**
	 * Default constructor of UnmatchedException
	 * Assigns appropriate message to print in case exception happens
	 */
	public UnmatchedException() {
		super("Passwords do not match");
	}
}
