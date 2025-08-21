import java.io.*;
import java.util.*;

/**
 * This interface check the sign of x.compareTo(y) and return an integer based on it
 * 
 * @param - element a CourseDBElement
 * @return - a negative integer for x.compareTo(y) being negative, a positive integer for x.compareTo(y) being positive,
 *           and zero for x.compareTo(y) equaling to zero.
 */

public interface Comparable 
{

        int compareTo(CourseDBElement element);

}