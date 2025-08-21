/**Contains additional instance variable for weather or not it is offered in the weekend. 
 * The additional cost for drinks offered in the weekend is 60 cents. 
 * 
 * @author Sakina Lougue
 */

public class Alcohol extends Beverage
{
        private boolean isWeekend;
        private final double WEEKEND_FEE = .6;
        
        /**parametrized constructor  
         * @param aString
         * @param size
         * @param bool
         */
        public Alcohol(String aString, SIZE size, boolean bool) {
                super(aString, TYPE.ALCOHOL, size);
                isWeekend = bool;
        }
        
        /**Overridden Utility 
         * String representation of a alcohol drink including the name,
         * size, whether or not beverage is offered in the weekend and the price.
         */
        public String toString() {
                String s = getBevName() +", " +getSize();
                
                if (isWeekend) {
                        s += " Weekend";
                }
                
                s += ", $" +calcPrice();
                
                return s;
        }
        
        /**Overridden equals method
         * checks equality based on the Beverage class equals method and additional instance variables for this class.
         * @param alchol 
         * @return true or false
         */
        public boolean equals(Alcohol alcohol) {
                if (super.equals(alcohol) && isWeekend == alcohol.getIsWeekend()) {
                        return true;
                }
                else {
                        return false;
                }
        }
        
        /**
         * An Overridden calcPrice method.
         * @return price the price of alcohol per cups
         */
        public double calcPrice() {
                double price = super.getBasePrice();
                
                if (super.getSize() == SIZE.MEDIUM) {
                        price += super.getSizePrice();
                }
                else if (super.getSize() == SIZE.LARGE) {
                        price += 2 * super.getSizePrice();
                }
                
                if (isWeekend) {
                        price += WEEKEND_FEE;
                }
                
                return price; 
        }
        
        /** Accessors
         * @return isWeekend on weekends
         * */
        public boolean getIsWeekend() {
                return isWeekend;
        }
        
        /** Accessors
         * @return WEEKEND_FEE weekends fees
         * */
        public double getWeekendFee() {
                return WEEKEND_FEE;
        }
        
        /** Mutators
         * @param bool 
         * */
        public void setIsWeekend(boolean bool) {
                isWeekend = bool;
        }
}