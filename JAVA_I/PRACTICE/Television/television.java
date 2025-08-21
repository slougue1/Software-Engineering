/** 
model a television
*/

public class Television 
{
	private final String MANUFACTURER;   //This variable's instance holds the only one name of the television's brand (since it is constant)
	private final int SCREEN_SIZE;       //the only one size of the screen (since it's constant)
	private boolean powerOn;             /*will hold true of the method power is on
	                                       and false if the method power is off */
	private int channel,                 //hold the value of the number of the channel playing o the tv (ex: 37 for CNN, 27 for Disney Channel)
	            volume;                  //hold the number at which the volume of the tv is (ex: 5 for the loudness, 4 for less loud....)
	
	/**
	 * This method assign the first values of the different fields
	 * The function does not return a value because it is a constructor
	 * @param brand when ever we will create a Television object in the data element class,
	 *         we'll pass a string argument to the parameter brand, which will then be assign to the field MANUFACTUERER 
	 * @param size  This parameter will hold an argument being passed, and the paramenter's value will be assign to the field SCREEN SIZE
	 */
	public Television (String brand, int size)
	{
		MANUFACTURER = brand;
		SCREEN_SIZE= size;
		powerOn = false;
		volume = 20;
		channel=2;
	}
	
	
	/**This method accepts an argument of type int, assigns it to the parameter station
	 * then the parameter station will assign it to the field channel 
	 * the method doesn't return a value
	 * @param station to hold and argument and assign it to the field channel
	 */
	public void setChannel(int station)
	{
		channel = station;
	}
	
	
	/**This method turn on the power, when it is off
	 * and turn it off when it is on
	 * The method doesn't accept an argument
	 */
	public void power()
	{	
		powerOn = !powerOn;
		
	}
	
	/**this method increase the volume value by one, doesn't accept an argument, and doen't return a value
	 * To increase the value of the volume more by a, call it a times in the data element class
	 */
	public void increaseVolume()
	{
		volume++;
	}
	
	
	/**this method decrease the volume value by one, doesn't accept an argument, and doen't return a value
	 * To decrease the value of the volume more by a, call it a times in the driver class
	 */
	public void decreaseVolume()
	{
		volume--;
	}
	
	/**This method allow the user to get the value of the channel
	 * @return channel returns the value of channel (after being modify by the setChannel)
	 */
	public int getChannel()
	{
		return channel;
	}
	
	
	/**This method allow the user to get the value of the volume
	 * @return volume return the value of volume (after being modify by the setVolume)
	 */
	public int getVolume()
	{
		return volume;
	}
	
	/**This method allow the user to get the value of the manufacturer
	 * @return MANUFACTURER returns the value of manufacturer (after being modify by the constructor)
	 */
	public String getManufacturer()
	{
		return MANUFACTURER;
	}
	
	
	/**This method allow the user to get the value of the screen size
	 * @return SCREEN_SIZE returns the value of screen size (after being modify by the constructor)
	 */
	public int getScreenSize()
	{
		return SCREEN_SIZE;
	}
	

}
