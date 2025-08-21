/**This property represents a Property object
 * @author Sakina Lougue
 * */
public class Property 
{
   private java.lang.String city;         //holds the name of the city where the property is located
   private java.lang.String owner;        //holds the name of the owner
   private java.lang.String propertyName; //holds the name of the property
   private double rentAmount;             //holds the amount of the rent
   private Plot plot;                     //Declare reference variable of type Plot class
   
   /**
    * No-arg constructor with a default Property which set:
    *  city, owner, property name to the empty space, the rent amount to 0, 
    *  and create a default constructor plot
    */
   public Property()
   {
       this.city = "";
       this.owner = "";
       this.propertyName = "";
       this.rentAmount = 0;
       this.plot = new Plot();
   }
   
   /**
    * Copy Constructor accepting p, a Plot object
    * @param p property object
    */
   public Property (Property p) 
   {
	   this.city = p.city;
	   this.owner = p.owner;
	   this.propertyName = p.propertyName;
	   this.rentAmount = p.rentAmount;
	   plot = new Plot(p.plot);
   }
   
   /**
   * Parameterized constructor with no Plot information
   * Constructs a new object with the given propertyName, city, rentAmount, and owner
   * @param propertyName- the name of the property
   * @param city- the name of the city
   * @param rentAmount- price of the renting
   * @param owner- name of the owner
   */
   public Property(java.lang.String propertyName, java.lang.String city, double rentAmount, java.lang.String owner) 
   {
       this.propertyName = propertyName;
       this.city = city;
       this.owner = owner;
       this.rentAmount = rentAmount;
       plot = new Plot();
   }
   
   /**
    * This onstructor passes information along, Parameterized constructor
   * @param propertyName the property name
   * @param city where the property is located
   * @param rentAmount- price of the renting
   * @param owner- the owner's name
   * @param x-value of the property's plot
   * @param y-value of the property's plot
   * @param width the horizontal size of the property's plot
   * @param depth the vertical size of the property's plot
   */
   public Property(java.lang.String propertyName, java.lang.String city, double rentAmount, java.lang.String owner,
           int x, int y, int width, int depth) 
   {
       this.propertyName = propertyName;
       this.city = city;
       this.owner = owner;
       this.rentAmount = rentAmount;
       plot = new Plot(x, y, width, depth);
   }
   
   /**
   * This method allow to get the property name value by returning it
   * @return propertyName- the name of property
   */
   public java.lang.String getPropertyName()
   {
       return propertyName;
   }
   
   /**
   * This method sets the property name value to the parameter property name
   * @param propertyName- the name of property
   */
   public void setPropertyName(java.lang.String propertyName)
   {
       this.propertyName = propertyName;
   }
   
   /**
   * This method allow to get the city name value by returning it
   * @return city- the name of the city
   */
   public java.lang.String getCity()
   {
       return city;
   }
   
   /**
   * This method sets the city name value to the parameter city 
   * @param city- the name of the city
   */
   public void setCity(String city)
   {
       this.city = city;
   }
   
   /**
   * This method allow to get the owner name value by returning it
   * @return owner- the name of the owner
   */
   public java.lang.String getOwner()
   {
       return owner;
   }
   
   /**
   * This method sets the owrner name value to the parameter owner name
   * @param owner- the name of the owner
   */
   public void setOwner(java.lang.String owner)
   {
       this.owner = owner;
   }
   
   /**
   * This method allow to get the rent amount value by returning it
   * @return rentAmount- the price of renting
   */
   public double getRentAmount()
   {
       return rentAmount;
   }
   
   /**
   * This method sets the rent value to the parameter rent amount
   * @param rentAmount- the price of renting
   */
   public void setRentAmount(double rentAmount)
   {
       this.rentAmount = rentAmount;
   }
   public Plot getPlot()
   {
       return plot;
   }
   
   /**
   * This method sets the plot values and returns plot values
   * @param x-value of the property's plot
   * @param y-value of the property's plot
   * @param width the horizontal size of the property's plot
   * @param depth  the vertical size of the property's plot
   * @return plot the Plot for the property
   */
   public Plot setPlot(int x, int y, int width, int depth)
   {
       return new Plot(x, y, width, depth);
   }
   
   /**
   * This method prints out the name, city, owner and rent amount for a property
   * @return string -the string representation of a Property object
   */
   public java.lang.String toString()
   {
	   String result = "Property Name: " + propertyName + "\nLocated in city: " 
                       + city + "\nBelonging to: " + owner + "\nRent Amount: " + rentAmount;
	   return result;
   }
  
}