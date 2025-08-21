
 
/**
 *QueueOverflowException class
 * @author Sakina Lougue
 */
class QueueOverflowException extends Exception 
{
	/**
	 * This is a default constructor of the QueueOverflowException
	 * Assigns appropriate message to print in case exception happens
	 */
    public QueueOverflowException(String overflow_Exception) {
         super(overflow_Exception);
    }

}
