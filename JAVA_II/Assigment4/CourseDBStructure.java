import java.io.IOException;
import java.util.*;

/**
 * It will be an array of linked lists of CourseDBElements.  
 * Each CDE will have a hash code that comes from the CRN, since the CRN is unique for courses.
 * @author Sakina Lougue
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface 
{
        protected int size;
        protected LinkedList<CourseDBElement> hashTable[];
        
        /**
         * This is a default constructor that is the estimated number of courses
         * @param size - the size of the hashtable
         */
        @SuppressWarnings("unchecked")
        public CourseDBStructure(int size) 
        {
                this.size = size;
                hashTable = new LinkedList[size];
        }
        
        /**
         * This is a constructor for testing
         * @param testing
         * @param size - the size of the hashtable
         */
        @SuppressWarnings("unchecked")
        public CourseDBStructure(String testing, int size) 
        {
                this.size = size;
                hashTable = new LinkedList[size];
        }
        
        /**
         * This method uses the hashcode of the CourseDatabaseElement to see if it is in the hashtable.
         * If the CourseDatabaseElement is in the hashtable, return it If not, throw an IOException
         * @param element - element the CDE to be added
         * @throws IOException
         */
        @Override
        public void add(CourseDBElement element) 
        {
                int index = element.hashCode() % size;
                if(hashTable[index] == null) 
                {
                        hashTable[index] = new LinkedList<CourseDBElement>();
                }
                hashTable[index].add(element);
        }
        
        /**
         * This method returns the size of the ConcordanceDataStructure (number of indexes in the array)
         * @param crn - CRN of the course
         * @throws IOException
         */
        @Override
        public CourseDBElement get(int crn) throws IOException 
        {
                String str = crn + "";
                int index = str.hashCode() % size;
                if(hashTable[index] == null) 
                {
                        throw new IOException();
                }
                else 
                {
                        for(int index2 = 0; index2 < size; index2++) 
                        {
                                CourseDBElement temp = hashTable[index].get(index2);
                                if(temp.getCRN() == crn) 
                                {
                                        return temp;
                                }
                        }
                        return null;
                }
        }
        
        /**
         * This method gets the size of hashtable.
         * @return size - the size of the hashtable
         */
        @Override
        public int getTableSize() 
        {
                return size;
        }

}