/**This class represents an order. 
 * It implements two interfaces: OrderInterface and Comparable
 * 
 * @author Sakina Lougue
 */
import java.util.ArrayList;
import java.util.Random;


public class Order implements OrderInterface, Comparable<Order> {
        private int orderNo;
        private int orderTime;
        private DAY orderDay;
        private Customer customer;
        private ArrayList<Beverage> beverages;
        
        /**A parametrized constructor 
         * @param orderTime
         * @param orderDay
         * @param customer
         */
        public Order(int orderTime, DAY orderDay, Customer customer) {
                orderNo = genOrderNum();
                this.orderTime = orderTime;
                this.orderDay = orderDay;
                this.customer = customer;
                beverages = new ArrayList<>();
        }
        
        /**This method generates a random number within the range of 10000 and 90000
         * 
         * @return randInteger the random integer
         */
        public int genOrderNum() {
                Random rand = new Random();
                // [10_000, 90_000)
                int randInteger = rand.nextInt(90_000-10_000)+10_000;
                return randInteger;
        }
        
        /**This method includes order number, time, day, customer name ,
         *  customer age and the list of beverages (with information of the beverage).
         */
        public String toString() {
                String s = "__________________________________"
                                   +orderDay.toString() +", " +orderTime
                                   +"\n" +customer.toString() +" Order Num: " +orderNo;
                
                for (Beverage b : beverages) {
                        s += "\n" +b.toString();
                }
                s += "\n Order Total: " +calcOrderTotal();
                
                return s;
        }
        
        
        public boolean isWeekend() {
                if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
                        return true;
                }
                return false;
        }
        public Beverage getBeverage(int itemNum) {
                return beverages.get(itemNum);
        }
        
        /**This method compares this order with another order based on the order number 
         * @param order the type of order
         * @return 0,1, or -1 :Returns 0 if this order number is same as another order's order number,
         *  1 if it is greater than another order's order number,
         *   -1 if it smaller than another order's order number.
         */
        public int compareTo(Order order) {
                if (orderNo == order.getOrderNo()) {
                        return 0;
                }
                else if (orderNo > order.getOrderNo()) {
                        return 1;
                }
                else {
                        return -1;
                }
        }
        /**To calculate the total 
         */
        public double calcOrderTotal() {
                double orderTotal = 0;
                
                for (Beverage b : beverages) {
                        orderTotal += b.calcPrice();
                }
                
                return orderTotal;
        }
        
        /**To find the different beverages 
         * @param type the type of beverages
         * @return count the count 
         */
        public int findNumOfBeveType(TYPE type) {
                int count = 0;
                
                for (Beverage b : beverages) {
                        if (b.getType() == type) {
                                count++;
                        }
                }
                
                return count;
        }
        
        /**getters 
         * 
         * @return beverages.size() the size of the beverage
         */
        public int getTotalItems() {
                return beverages.size();
        }
        
        /** Add Beverages  
         * @param name the name of the beverages
         * @param size the size of the cup
         * @param extraShot extra shop
         * @param extraSyrup extra syrup
         */
        public void addNewBeverage(String name, SIZE size, boolean extraShot, boolean extraSyrup) 
        {
                Coffee c = new Coffee(name, size, extraShot, extraSyrup);
                beverages.add(c);
        }
        
        /**To add a new beverage 
         * @param name the name of the beverages
         * @param size the size of the cup
         * @param numOfFruits extra fruit
         * @param proteinPowder extra protein powder
         */
        public void addNewBeverage(String name, SIZE size, int numOfFruits, boolean proteinPowder) 
        {
                Smoothie s = new Smoothie(name, size, numOfFruits, proteinPowder);
                beverages.add(s);
        }
        
        /**To add a new beverage 
         * @param name the name of the beverages
         * @param size the size of the cup
         */
        public void addNewBeverage(String name, SIZE size) {
                boolean isWeekend = false;
                if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
                        isWeekend = true;
                }
                Alcohol a = new Alcohol(name, size, isWeekend);
                beverages.add(a);
        }
        
        /** Accessor 
         * 
         * @return orderNo to get the order number
         */
        public int getOrderNo() {
                return orderNo;
        }
        
        /** Accessors 
         * 
         * @return orderTime to get the order time
         */
        public int getOrderTime() {
                return orderTime;
        }
        
        /** Accessors 
         * 
         * @return orderDay to get the day of the order
         */
        public DAY getOrderDay() {
                return orderDay;
        }
        
        /** Accessors 
         * 
         * @return Customer(customer) to get the costumer
         */
        public Customer getCustomer() {
                return new Customer(customer);
        }
        
        /** Accessors 
         * 
         * @return beverages to get the type of beverage
         */
        public ArrayList<Beverage> getBeverages() {
                return beverages;
        }
        
        /** Mutators 
         * 
         * @param orderNumb to set the order number
         */
        public void setOrderNum(int orderNumb) {
                orderNo = orderNumb;
        }
        
        /** Mutators 
         * 
         * @param orderTim to set the order time
         */
        public void setOrderTime(int orderTim) {
                orderTime = orderTim;
        }
        
        /** Mutators 
         * 
         * @param orderDy to set the order day
         */
        public void setOrderDay(DAY orderDy) {
                orderDay = orderDy;
        }
        
        /** Mutators 
         * 
         * @param cust to set the customer
         */
        public void setCustomer(Customer cust) {
                customer = cust;
        }
}