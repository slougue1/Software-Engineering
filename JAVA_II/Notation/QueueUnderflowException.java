
 
/**
 *QueueUnderflowException class
 * @author Sakina Lougue
 */
class QueueUnderflowException extends Exception 
{
	/**
	 * This is a default constructor of the QueueUnderflowException
	 * Assigns appropriate message to print in case exception happens
	 */

    public QueueUnderflowException(String underflow_Exception) {
        super(underflow_Exception);
    }

}
