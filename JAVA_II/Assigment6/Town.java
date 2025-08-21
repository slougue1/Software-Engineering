/**
* Represents an town as a node of a graph. The Town class holds the name of the town and a list of adjacent towns, and other fields as desired, and the traditional methods (constructors, getters/setters, toString, etc.). 
* It will implement the Comparable interface These are the minimum methods that are needed. Please feel free to add as many methods as you need.
*
*/

import java.util.LinkedHashSet;
import java.util.Iterator;

public class Town implements Comparable<Town>
{
   private String name;
   private LinkedHashSet<Town> neighbors;
   private int weight;

   /**
    * This is a parametirised constructor
    * @param name - town's name
    */
   public Town(java.lang.String name) 
   {
       this.name = name;
       neighbors = new LinkedHashSet<Town>();
   }

   /**
   * Copy constructor
   * @param templateTown - an instance of Town
   */
   public Town(Town templateTown) 
   {
       this.setName(templateTown.getName());
       neighbors = new LinkedHashSet<Town>();

       for(Town t: templateTown.getAdjacentTown())
           this.neighbors.add(t);
   }

   /**
   * Returns the name of this town
   * @return the name - town's name
   */
   public java.lang.String getName() {
       return name;
   }

   /**
   * Sets the name of this town to the desired String
   * @param name - town's name
   */
   public void setName(java.lang.String name) {
       this.name = name;
   }

   /**
   * This method returns a LinkedHashSet of all of the neighboring towns 
   * @return a LinkedHashSet of type Town
   */
   public LinkedHashSet<Town> getAdjacentTown() {
       return neighbors;
   }

   /**
   * This method sets the neighbors of this Town to the desired
   * @param neighbors
   */
   public void setAdjacentTown(LinkedHashSet<Town> neighbors) 
   {
       this.neighbors = neighbors;
   }

   /**
   * This method adds neighboring to the list of town 
   * @param newNeighbor
   * @return true if the element was not already in the set
   */
   public boolean addAdjacentTown(Town newNeighbor) 
   {
       return neighbors.add(newNeighbor);
   }

   /**
   * This method reemoves the desired town from the set of neighboring towns
   * @param aTown - the town to be removed
   * @return true if the element was in the set and removed.
   */
   public boolean removeAdjacentTown(Town aTown) {
       return neighbors.remove(aTown);
   }

   /**
   * This method checks two Town objects to see if they are equal.
   * @param obj - the Town to be compared with this instance
   * @return true if the town names are equal, false if not
   */
   @Override
   public boolean equals(java.lang.Object obj) 
   {
       if(obj instanceof Town) 
       {
           Town o2 = (Town) obj;
           return this.getName().equals(o2.getName());
       }
       else return false;
   }

   /**
   * Returns the hashcode for the name of the town
   * @return the hashcode for the name of the town
   */
   @Override
   public int hashCode() {
       return name.hashCode();
   }

   /**
   * Compares the Town basded on the name
   * @param o - the Town object to compare it to
   * @return 0 if they are equal, a positive number if this instance
   * is bigger than o, or a negative number if o is bigger than this
   * instance.
   */
   @Override
   public int compareTo(Town o) 
   {
       Town o2 = (Town) o;
       return this.getName().compareTo(o2.getName());
   }
  
   /**
    * This the string method that returns the the town name
    * @return townName - the town name
    */
   @Override
   public java.lang.String toString() 
   {
       String townName = getName() + "T1";
       Iterator i = getAdjacentTown().iterator();
       while(i.hasNext()) 
       {
    	   townName += ((Town) i.next()).getName() + ", ";
       }
       townName = townName.substring(0, townName.length()-2);
       return townName;
   }

}