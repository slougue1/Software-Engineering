/**Contains additional instance variables of type boolean to indicate 
 * if it contains extra shot of coffee (additional cost of 50 cents) and extra syrup (additional cost of 50 cents).
 *    
 * @author Sakina Lougue
 */

public class Coffee extends Beverage
{
        private boolean extraShot;
        private boolean extraSyrup;
        private final double SHOT_COST = .5;
        private final double SYRUP_COST = .5;
        
        /** parametrized constructor   
         * 
         * @param n the name
         * @param s the size
         * @param shot extra shot or not
         * @param syrup extra syrop or not
         */
        public Coffee(String n, SIZE s, boolean shot, boolean syrup) {
                super(n, TYPE.COFFEE, s);
                extraShot = shot;
                extraSyrup = syrup;
        }
        
        /** method: String representation of Coffee beverage, including the name , size, 
         *  whether it contains extra shot, extra syrup and the price of the coffee 
         */
        public String toString() {
                String s = getBevName() +", " +getSize();
                
                if (extraShot) {
                        s += " Extra shot";
                }
                if (extraSyrup) {
                        s += " Extra syrup";
                }
                
                s += ", $" +calcPrice();
                
                return s;
        }
        
        /** To calculate the prices 
         */
        public double calcPrice() {
                double price = super.getBasePrice();
                
                if (super.getSize() == SIZE.MEDIUM) {
                        price += super.getSizePrice();
                }
                else if (super.getSize() == SIZE.LARGE) {
                        price += 2 * super.getSizePrice();
                }
                
                if (extraShot) {
                        price += SHOT_COST;
                }
                if (extraSyrup) {
                        price += SYRUP_COST;
                }
                
                return price;
        }
        
        /**method: checks equality based on the Beverage class 
         * equals method and additional instance variables for this class.
         * @param coffee coffee
         * @return either true or false
         */
        public boolean equals(Coffee coffee) {
                if (super.equals(coffee) && extraShot==coffee.getExtraShot() && extraSyrup==coffee.getExtraSyrup()) {
                        return true;
                }
                else {
                        return false;
                }
        }
        
        /** Accessors 
         * 
         * @return extraShot for any extrat shot
         */
        public boolean getExtraShot() {
                return extraShot;
        }
        
        /** Accessors 
         * 
         * @return extraSyrup get any extra syrup
         */
        public boolean getExtraSyrup() {
                return extraSyrup;
        }
        
        /** Accessors 
         * 
         * @return SHOT_COST get the cost of the extra shot
         */
        public double getShotCost() {
                return SHOT_COST;
        }
        
        /** Accessors 
         * 
         * @return SYRUP_COST get the cost of the extra syrup
         */
        public double getSyrupCost() {
                return SYRUP_COST;
        }
        
        /** Mutators 
         * 
         * @param shot set the extra shot
         */
        public void setExtraShot(boolean shot) {
                extraShot = shot;
        }
        
        /** Mutators 
         * 
         * @param syrup set the extra syrup
         */
        public void setExtraSyrup(boolean syrup) {
                extraSyrup = syrup;
        }
}