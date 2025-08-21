/**
 * This class implements Comparable, and consists of five attributes:
 * the Course ID (a String), the CRN (an int), the number of credits (an int),
 * the room number (a String), and the instructor name (a String).
 * @author Sakina Lougue
 */
public class CourseDBElement implements Comparable
{
        private String id;          //Hold the course ID
        private int crn;            //Hold the course CRN
        private int numOfCredits;   //Hold the number of credit of the course
        private String roomNum;     //Hold the room number
        private String instructor;  //Hold the name of the instructor
        
        /**
         * This is default Constructor with not parametor.
         * It sets the different attributes above to either 0 or an empty string depending of the data or class type
         */
        public CourseDBElement() 
        {
                id = "";
                crn = 0;
                numOfCredits = 0;
                roomNum = "";
                instructor = "";
        }
        
        /**
         * This parametised constructor initializes the attributes to the parameters 
         * @param id - the course ID
         * @param crn - the course CRN
         * @param numOfCredits - the number of course's credits
         * @param roomNum - the room number
         * @param instructor - the instructor name
         */
        public CourseDBElement(String id, int crn, int numCredits, String roomNum, String instructor) 
        {
                this.id = id;
                this.crn = crn;
                this.numOfCredits = numCredits;
                this.roomNum = roomNum;
                this.instructor = instructor;
        }
        
        /**
         * This override method the sign of the substruction between the CRN number and the parameter
         * @return either a positive, negative, or zero
         */
        @Override
        public int compareTo(CourseDBElement element) 
        {
                return (this.crn - element.crn);
        }
        
        /**
         * This method return and permit to get the CRN umber
         * @return crn - the current CRN number
         */
        public int getCRN() 
        {
                return crn;
        }
        
        /**
         * This method initializes the CRN attribute
         * @param crn - the CRN number
         */
        public void setCRN(int crn) 
        {
                this.crn = crn;
        }
        
        /**
         * This method sets the CRN and cast it into a string. Then the hashcode of the string is returned
         * @return str.hashCode()
         */
        @Override
        public int hashCode() {
                String str = crn + "";
                return str.hashCode();
        }
        
        /**
         * This method generated equals method
         * @return either false or true depending on the value of the parameter
         */
        @Override
        public boolean equals(Object object) 
        {
                if (this == object)
                        return true;
                if (object == null)       // Check if the object is is null
                        return false;
                if (getClass() != object.getClass())
                        return false;
                
                CourseDBElement other = (CourseDBElement) object; //cast object from Object to CourseDBElement
                if (crn != other.crn)
                        return false;
                return true;
        }
        
        /**
         * This method returns the values of a CourseDBElement as a string
         * @return a string
         */
        @Override
        public String toString() 
        {
                return "\nCourse:" + id + " CRN:" + crn + " Credits:" + numOfCredits + " Instructor:" + instructor + " Room:" + roomNum;
       
        }
        
}