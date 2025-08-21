import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Sakina Lougue
 *
 */
class CourseDBManager_STUDENT_Test {
        private CourseDBManagerInterface test = new CourseDBManager();
        @BeforeEach
        void setUp() throws Exception {
                test = new CourseDBManager();
        }

        @AfterEach
        void tearDown() throws Exception {
                test = null;
        }

        @Test
        void testAddToDB() {
                try {
                        test.add("CMSC204",32461,4,"Remote-Teaching","Sakina Lougue");
                }
                catch(Exception e) {
                        fail("This should not have caused an Exception");
                }
        }
        
        @Test
        void testShowAll() {
                test.add("CMSC204",32461,4,"Remote-Teaching","Sakina Lougue");
                test.add("CMSC204",32462,4,"Remote-Teaching","Sakina Lougue");
                ArrayList<String> list = test.showAll();
                
                assertEquals(list.get(0),"\nCourse:CMSC204 CRN:32461 Credits:4 Instructor:Sakina Lougue Room:Remote-Teaching");
                assertEquals(list.get(1),"\nCourse:CMSC204 CRN:32462 Credits:4 Instructor:Sakina Lougue Room:Remote-Teaching");
        }
        
        @Test
        void testReadFile() {
                try {
                        File inputFile = new File("Test1.txt");
                        PrintWriter inFile = new PrintWriter(inputFile);
                        inFile.println("CMSC204 32461 4 Distance-Learning Sakina Lougue");
                        inFile.print("CMSC204 32462 4 Distance-Learning Sakina Lougue");
                        inFile.close();
                        test.readFile(inputFile);
                } catch (Exception e) {
                        fail("Should not have thrown an exception");
                }
        }

}