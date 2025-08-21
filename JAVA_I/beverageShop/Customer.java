/**This class represents a customer, and and instance variables for  name and age
 * @author Sakina Lougue
 */

public class Customer 
{
        private String name; //the name of the customer
        private int age;     //the age o see if the customer is old enough to have alcohol
        
        /** parametrized constructor 
         * 
         * @param n the name of the customer
         * @param a the age of the customer
         */
        public Customer(String name, int age) {
                this.name = name;
                this.age = age;
        }
        
        /**A Copy constructor  
         * 
         * @param customer 
         */
        public Customer(Customer customer) {
                name = customer.getName();
                age = customer.getAge();
        }
        
        /** String representation for Customer including the name and age 
         */
        public String toString() {
                return name +", " +age +"y/o";
        }
        
        /** Accessors 
         * 
         * @return name get the name of the costumer
         */
        public String getName() {
                return name;
        }
        
        /** Accessors 
         * 
         * @return age get the age of the costumer
         */
        public int getAge() {
                return age;
        }
        
        /** Mutators 
         * 
         * @param name set the name of the costumer
         */
        public void setName(String name) {
                this.name = name;
        }
        
        /** Mutators 
         * 
         * @param age set the age of the costumer
         */
        public void setAge(int age) {
                this.age = age;
        }
}