/**
* TThe class Road that can represent the edges of a Graph of Towns. The class must implement Comparable. The class stores references to the two vertices(Town endpoints), the distance between vertices, and a name, and the traditional methods (constructors, getters/setters, toString, etc.), and a compareTo, which compares two Road objects. 
* Since this is a undirected graph, an edge from A to B is equal to an edge from B to A.
* @author Sakina Lougue
*/
public class Road implements java.lang.Comparable<Road>
{
   private Town source;
   private Town destination;
   private String name;
   private int weight;
  
   /**
   * Parametrized Constructor
   * @param source - One town on the road
   * @param destination - Another town on the road
   * @param degrees - Weight of the edge, i.e., distance from one town to the other
   * @param name - Name of the road
   */
   public Road(Town source, Town destination, int degrees, java.lang.String name) 
   {
       this.source = source;
       this.destination = destination;
       weight = degrees;
       this.name = name;
   }
  
   /**
   * Constructor with weight preset at 1
   * @param source - One town on the road
   * @param destination - Another town on the road
   * @param name - Name of the road
   */
   public Road(Town source, Town destination, String name) 
   {
       this.source = source;
       this.destination = destination;
       this.name = name;
       weight = 1;
   }
  
   /**
   * Returns the Town at the first end of this Road
   * @return source - A town on the road
   */
   public Town getSource() 
   {
       return source;
   }

   /**
   * Sets the Town at the first end of this Road to the desired reference.
   * @param source - A town on the road
   */
   public void setSource(Town source) 
   {
       this.source = source;
   }

   /**
   * Returns the second town on the road.
   * @return destination - A town on the road
   */
   public Town getDestination() {
       return destination;
   }

   /**
   * Sets the second town on the road to the desired reference.
   * @param destination - A town on the road
   */
   public void setDestination(Town destination) 
   {
       this.destination = destination;
   }

   /**
   * Returns the road name
   * @return name - The name of the road
   */
   public String getName() 
   {
       return name;
   }

   /**
   * Sets the name of the Road to the desired String
   * @param name - The name of the road
   */
   public void setName(String name) 
   {
       this.name = name;
   }

   /**
   * Returns the distance of the road
   * @return weight - the distance of the road
   */
   public int getWeight() {
       return weight;
   }

   /**
   * Sets the weight of the road 
   * @param weight - the distance of the road
   */
   public void setWeight(int weight) {
       this.weight = weight;
   }

   /**
   * Compares the roads based on weigh
   * @return if the road names are the same, a positive or negative number if the road names are not the same
   */
   @Override
   public int compareTo(Road o) {
       return this.getWeight() - o.getWeight();
   }
  
   /**
   * Returns true if each of the ends of the road r is the same as the ends of this road. 
   * Remember that a road that goes from point A to point B is the same as a road that goes from point B to point A.
   * @param r - road object to compare it to
   * @return true if they have the same towns, false otherwise
   */
   @Override
   public boolean equals(java.lang.Object r) {
       Road o2;
       if(r instanceof Road) {
           o2 = (Road) r;
           return (o2.contains(this.getSource()) && o2.contains(this.getDestination()));
       }
       return false;
   }
  
   /**
   * This method returns the hash code of the road, which is based on its two towns added together
   * @return the hash code of the road, which is based on its two towns added together
   */
   @Override
   public int hashCode() {
       return getSource().hashCode() + getDestination().hashCode();
   }
  
   /**
   * Checks if the road contains the desired town
   * @param town - the town to be checked for
   * @return true if the road contains the town, false otherwise
   */
   public boolean contains(Town town) 
   {
       return (source.equals(town) || destination.equals(town));
   }
  
   /**
   * Returns string representation of the road
   * @return a String representation of the road
   */
   @Override
   public java.lang.String toString() 
   {
	   String representation = "Road: " + getName() + " connects towns: " + getSource().getName()
               + " and " + getDestination().getName();
	   return representation;
   }

}