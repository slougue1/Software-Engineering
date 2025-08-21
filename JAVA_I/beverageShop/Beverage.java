/**Contains an Instance variables for beverage name, beverage type, size, 
 * and constant attributes for the base price ($2.0) and size price (additional $1 to go a size up).
 * 
 * @author Sakina Lougue
 */

public abstract class Beverage 
{
        private String name;
        private TYPE type;
        private SIZE size;
        private final double BASE_PRICE = 2.0;
        private final double SIZE_PRICE = 1.0;
        
        /**A parametrized constructor to create a Beverage object given its name, type and  size 
         * @param n the name
         * @param t the type
         * @param s the size
         * */
        public Beverage(String n, TYPE t, SIZE s) {
                name = n;
                type = t;
                size = s;
        }
                
        /**An abstract methods that calculates and returns the beverage price.   
         */
        public abstract double calcPrice();

        /**String representation for Beverage including the name and size   
         */
        public String toString() {
                return name +", " +size;
        }
        
        /**method: checks equality based on name, type, size of the beverage
         * @param bev the type of berages
         * @return either true or false
         */
        public boolean equals(Beverage bev) {
                if (name.equals(bev.getBevName()) && type==bev.getType() && size==bev.getSize()) {
                        return true;
                }
                else {
                        return false;
                }
        }
        
        /** Accessors
         * 
         * @return
         */
        public String getBevName() {
                return name;
        }
        
        /** Accessors
         * 
         * @return type the type of drink
         */
        public TYPE getType() {
                return type;
        }
        
        /** Accessors
         * 
         * @return the size of the cup
         */
        public SIZE getSize() {
                return size;
        }
        
        /** Accessors
         * 
         * @return BASE_PRICE the initial price
         */
        public double getBasePrice() {
                return BASE_PRICE;
        }
        
        /** Accessors
         * 
         * @return SIZE_PRICE the price per size
         */
        public double getSizePrice() {
                return SIZE_PRICE;
        }
        
        /** Mutators 
         * 
         * @param n the name
         */
        public void setName(String n) {
                name = n;
        }
        
        /** Mutators 
         * 
         * @param t the type of drinks
         */
        public void setType(TYPE t) {
                type  = t;
        }
        
        /** Mutators 
         * 
         * @param s the size of the cup
         */
        public void setSize(SIZE s) {
                size = s;
        }
        
}