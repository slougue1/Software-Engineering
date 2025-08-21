
/**
 *StackUnderflowException class
 * @author Sakina Lougue
 */
class StackUnderflowException extends Exception 
{/**
	 * This is a default constructor of the StackUnderflowException
	 * Assigns appropriate message to print in case exception happens
	 */

    public StackUnderflowException(String underflow_Exception) 
    {
        super(underflow_Exception);
    }

}
