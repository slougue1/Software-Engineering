
/**
 *StackOverflowException class
 * @author Sakina Lougue
 */
class StackOverflowException extends Exception 
{   
	/**
	 * This is a default constructor of the StackOverflowException
	 * Assigns appropriate message to print in case exception happens
	 */

    public StackOverflowException(String stack_is_full) {
        super(stack_is_full);
    }

}
