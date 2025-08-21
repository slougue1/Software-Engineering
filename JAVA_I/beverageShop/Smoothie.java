/**Contains additional instance variables for number of fruits and boolean variable to indicate if protein powder is added to the beverage.
 * The cost of adding protein is $1.50 and each additional fruit costs 50 cents.
 * 
 * @author Sakina Lougue
 */

public class Smoothie extends Beverage{
        private int numOfFruits;
        private boolean addProtein;
        private final double FRUIT_COST = .5;
        private final double PROTEIN_COST = 1.5;
        
        /** A parametrized constructor   
         * 
         * @param name the name of the drink
         * @param size the size of the cup
         * @param nof 
         * @param ap
         */
        public Smoothie(String name, SIZE size, int numbOfruit, boolean addProtei) {
                super(name, TYPE.SMOOTHIE, size);
                numOfFruits = numbOfruit;
                addProtein = addProtei;
        }
        
        /**String representation of a Smoothie drink including the name,
         * size, whether or not protein is added , number of fruits and the price 
         * 
         */
        public String toString() {
                String s = getBevName() +", " +getSize() +" " +numOfFruits +" Fruits";
                
                if (addProtein) {
                        s += " Protein powder";
                }
                
                s += ", $" +calcPrice();
                
                return s;
        }
        
        /**method: checks equality based on the Beverage class equals
         *  method and additional instance variables for this class
         * @param smoothie type of smoothie
         * @return true or false
         */
        public boolean equals(Smoothie smoothie) {
                if (super.equals(smoothie) && numOfFruits==smoothie.getNumOfFruits() && addProtein==smoothie.getAddProtien()) {
                        return true;
                }
                else {
                        return false;
                }
        }
        
        /**An Overridden calcPrice method
         * 
         */
        public double calcPrice() {
                double price = super.getBasePrice();
                
                if (super.getSize() == SIZE.MEDIUM) {
                        price += super.getSizePrice();
                }
                else if (super.getSize() == SIZE.LARGE) {
                        price += 2 * super.getSizePrice();
                }
                
                price += numOfFruits * FRUIT_COST;
                if (addProtein) {
                        price += PROTEIN_COST;
                }
                
                return price;
        }
        
        /** Accessors 
         * 
         * @return numOfFruits to get the number of fruit
         */
        public int getNumOfFruits() {
                return numOfFruits;
        }
        
        /** Accessors 
         * 
         * @return addProtein to get the extra protein
         */
        public boolean getAddProtien() {
                return addProtein;
        }
        
        /** Accessors 
         * 
         * @return FRUIT_COST to get the cost of the extra fruit
         */
        public double getFruitCost() {
                return FRUIT_COST;
        }
        
        /** Accessors 
         * 
         * @return PROTEIN_COST to get cost of the extra protein
         */
        public double getProteinCost() {
                return PROTEIN_COST;
        }
        
        /** Mutators 
         * 
         * @param nof to set the number of fruit 
         */
        public void setNumOfFruits(int numbOfruit) {
                numOfFruits = numbOfruit;
        }
        
        /** Mutators 
         * 
         * @param ap to set the add protein
         */
        public void setProteinPowder(boolean addProtei) {
                addProtein = addProtei;
        }
}