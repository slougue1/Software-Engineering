/**This class represents the management company object
 * @author Sakina Lougue
 * */

public class ManagementCompany 
{
	private int MAX_PROPERTY = 5;    //Holds the maximum number of properties that this management company handles is set to 5
	private double mgmFeePer;        //Holds the management fee percentage
	private java.lang.String name;   //Holds the name of the management company
	private Property[] properties;   //Holds An array of Property objects
	private java.lang.String taxID;  //Holds the tax ID of the management Company
	private int MGMT_WIDTH = 10;     //Initialized to 10 
	private int MGMT_DEPTH = 10;     //Initialized to 10
	private Plot plot;               //Holds the Plot of the ManagemntCompany

	/**
	 * Get the name of the property
	 * @return name of the property
	 */
	public java.lang.String getName()
	{
		return name;
	}

	/**Assign and set the name of the property to the parameter name
	 * @param name of the property
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Get the plot
	 * @return plot- plot object
	 */
	public Plot getPlot()
	{
		return plot;
	}
	
	/**
	 * Set the Plot
	 * @param x- value
	 * @param y- value
	 * @param width- The horizontal extent of the Plot
	 * @param depth- The vertical extent of the Plot
	 * @return plot- plot object
	 */
	public Plot setPlot(int x, int y, int width, int depth)
	{
		plot = new Plot(x, y, width, depth);
		return plot;
	}

	/**
	 * No-Arg Constructor that creates a ManagementCompany object 
	 * using empty strings and the plot set to a Plot with x, y set to 0 , width and depth set to 10.
	 * properties array is initialized here as well
	 * */
	public ManagementCompany()
	{
		name = "";
		taxID = "";
		mgmFeePer = 0;
		plot = new Plot(0, 0, 10, 10);
		properties = new Property[MAX_PROPERTY];
	}
	
	/**
	 * Constructor that passes parameter values
	 * Constructor Creates a ManagementCompany object using the passed information.
     * plot is set to a Plot with x, y set to 0 , width and depth set to 10
     * properties array is initialized here as well
	 * @param name of the property
	 * @param taxID of the property
	 * @param mgmFee the management property fee
	 */
	public ManagementCompany(java.lang.String name, java.lang.String taxID, double mgmFee)
	{
		this.properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	/**
	 * Constructor that passes parameter values
	 * @param name- management company name
	 * @param taxID-  tax id
	 * @param mgmFee- management fee
	 * @param x values
	 * @param y values
	 * @param width- The horizontal extent of the Plot
	 * @param depth- The vertical extent of the Plot
	 */
	public ManagementCompany(java.lang.String name, java.lang.String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		this.properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x,y,width,depth);
	}
	
	/**
	 * Copy Constructor that creates a ManagementCompany object from another ManagementCompany object
	 * @param otherCompany- another management company
	 */
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this.properties = new Property[MAX_PROPERTY];
		name = otherCompany.name;
		taxID = otherCompany.taxID;
		mgmFeePer = otherCompany.mgmFeePer;
		plot = new Plot(otherCompany.plot);
	}
	
	/**
	 * This method returns the MAX_PROPERTY constant that represents the size of the "properties" array.
	 * @return max_property- the MAX_PROPERTY a constant attribute for this class that is set 5
	 */
	public int getMAX_PROPERTY()
	{
		return MAX_PROPERTY;
	}
	
	
	/**
	 * Method that adds property to properties array
	 * @param property- a property object
	 * @return conditional values-Returns either: -1 if the array is full, -2 if property is null,
	 *         -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property,
	 *          or the index in the array where the property was added successfully.

	 */
	public int addProperty(Property property)
	{
		if(property == null) 
		{
			return -2;
		}
		if(!plot.encompasses(property.getPlot()))
		{
			return -3;
		}
		for (int i = 0;i < properties.length; i++) 
		{
			if (properties[i] != null) 
			{
				if(properties[i].getPlot().overlaps(property.getPlot())) 
				{
					return -4;
				}
			}
			else 
			{
				properties[i] = property;
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Method creates new object with default plot and adds to properties array
	 * @param name-property name
	 * @param city-location of the property
	 * @param rent-monthly rent
	 * @param owner-owner of the property
	 * @return conditional values-Returns either: -1 if the array is full, -2 if property is null,
	 *         -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property,
	 *          or the index in the array where the property was added successfully.
	 */
	public int addProperty(String name, String city, double rent, String owner) 
	{
		return addProperty(new Property(name, city, rent, owner));
	}
	
	/**
	 * Method that creates object and adds it to properties array
	 * @param name of the property
	 * @param city- name of the location
	 * @param rent- the price of renting
	 * @param owner- the name of owner
	 * @param x- location of upper left corner of property's plot
	 * @param y- location of upper left corner of property's plot
	 * @param width- of the property's plot
	 * @param depth- depth of the property's plot
	 * @return conditional values-Returns either: -1 if the array is full, -2 if property is null,
	 *         -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property,
	 *          or the index in the array where the property was added successfully.
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	}
	
	/**
	 * This method accesses each "Property" object within the array "properties" 
	 * and sums up the property rent and returns the total amount.
	 * @return total- total rent
	 */
	public double totalRent() {
		double totalRent =0.0 ;

		for(int i = 0; i < properties.length; i++) 
		{
			if(properties[i] != null) 
			{
				totalRent += properties[i].getRentAmount();
			}
		}
		return totalRent;
	}



	/**
	 * This method finds a property within the properties array that has the maximum rent amount
	 * and returns the rent amount.
	 * @return maxRentAmount- double, the maximum rent amount
	 */
	public double maxRentProp()
	{
		double rentAmount = 0;
		for (Property property : properties)
		{
			if (property == null)
			{
				break;
			}
			if (rentAmount < property.getRentAmount())
			{
				rentAmount = property.getRentAmount();
			}
		}
		return rentAmount;
	}

	/**
	 * This method finds the index of the property with the maximum rent amount.
	 * @return index- integer , the index of the property with the maximum rent amount
	 */
	public int maxRentPropertyIndex()
	{
		int index = 0;
		for (int i =0; i < properties.length; i++)
		{
			if (properties[i] == null)
			{
				break;
			}
			if (properties[i].getRentAmount() >= properties[index].getRentAmount())
			{
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * This method displays the information of the property at index i
	 * @param i-The index of the property within the array "properties"
	 * @return string- information of the property at index i
	 */
	public java.lang.String	 displayPropertyAtIndex(int i)
	{
		String result = properties[i].toString();
		return result;
	}
	
	/**
	 * This method displays the information of all the properties in the "properties" array.
	 * @return string- information of ALL the properties within this management company by accessing the "Properties" array.
	 */
	public java.lang.String	 toString(){
		String result = "";
		for (int i=0; i<MAX_PROPERTY;i++) {
			if(properties[i]==null){
				break;
			}
			result += properties[i].toString()+"\n";
		}
		return "List of the properties for " + name + ", taxID: " + taxID + "\n___________________________________\n"+result+"\n"
		+ "___________________________________\ntotal " + "management Fee: "+(totalRent()*mgmFeePer/100);
	}
}
