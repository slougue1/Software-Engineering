/**This class represents a Plot object
 * @author Sakina Lougue
 * */
public class Plot 
{
   private int x;     //The x-value of the upper-left corner of the Plot
   private int y;     //The y-value of the upper-left corner of the Plot
   private int width; //The horizontal extent of the Plot
   private int depth; //The vertical extent of the Plot
   
   /**
   * No-arg constructor with a default Plot which set:
   *  x to 0, y to 0, width to 1, and depth to 1.
   */
   public Plot()
   {
       this.x = 0;
       this.y = 0;
       this.width = 1;
       this.depth = 1;
   }
   
   /**
   * Copy Constructor accepting p, a Plot object
   * @param p a plot object
   */
   public Plot(Plot p)
   {
       this.x = p.x;
       this.y = p.y;
       this.width = p.width;
       this.depth = p.depth;
   }
   
   /**
    * Parameterized constructor
   * Constructs a new object with the given x, y, width, and depth
   * @param x - horizontal coordinate of upper left corner
   * @param y - vertical coordinate of upper left corner
   * @param width - horizontal size
   * @param depth - vertical size
   */
   public Plot(int x, int y, int width, int depth)
   {
       this.x = x;
       this.y = y;
       this.width = width;
       this.depth = depth;
   }
   
   /**
   * This method checks if plot overlaps
   * @param plot object
   * @return true if it overlaps, otherwise false
   */
   public boolean overlaps(Plot plot) 
   {
       return x < plot.x + plot.width && x + width > plot.x && y < plot.y + plot.depth && y + depth > plot.y;
   }
   
   /**
   * This method verify if the class plot is within the parameter plot bounds
   * @param plot object
   * @return true if plot encompasses the parameter, false otherwise
   */
   public boolean encompasses(Plot plot) 
   {
       boolean encompass;
       double rightX = x + width;
       double bottomY = y + depth;
       double RightX1 = plot.getX()+plot.getWidth();
       double BottomY1 = plot.getY() + plot.getDepth();
       
       if ((this.x<=plot.getX()) && (plot.getX()<=rightX) && (this.y<=plot.getY()) && (plot.getY()<=bottomY)
               && (this.x<=rightX) && (RightX1<=rightX)
               && (this.y<=BottomY1) && BottomY1<=bottomY) 
       {
           encompass = true;
       }
       
       else
    	   encompass = false;  
       return encompass;
   }

   /**
   * This method allow to gets x value by returning it
   * @return x- value
   */
   public int getX()
   {
       return x;
   }
   
   /**
   * This method sets the x value to the parameter x
   * @param x- value
   */
   public void setX(int x)
   {
       this.x = x;
   }
   
   /**
   * This method allow to gets y value by returning it
   * @return y- value
   */
   public int getY()
   {
       return y;
   }
   
   /**
   * This method sets the y value to the parameter y
   * @param y- value
   */
   public void setY(int y)
   {
       this.y = y;
   }
   
   /**
   * This method allow to gets width value by returning it
   * @return width- The horizontal extent of the Plot 
   */
   public int getWidth()
   {
       return width;
   }
   
   /**
   * This method sets the width value to the parameter width
   * @param width- The horizontal extent of the Plot
   */
   public void setWidth(int width)
   {
       this.width = width;
   }
   
   /**
   * This method allow to gets depth value by returning it
   * @return depth- The vertical extent of the Plot
   */
   public int getDepth()
   {
       return depth;
   }
   
   /**
   * This method sets the depth value to the parameter depth
   * @param depth- The vertical extent of the Plot
   */
   public void setDepth(int depth)
   {
       this.depth = depth;
   }
   
   /**
   * This method prints out the name, city, owner, and rent's amount for a property
   * @return string representation of a Plot object
   */
   public java.lang.String toString()
   {
	   String wholeName = "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
	   return wholeName;
   }
}