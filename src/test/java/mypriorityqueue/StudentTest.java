/*
 * Quy Nguyen
 * CS635
 * Lab01 - Priority Queue
 * 9/9/24
 * StudentTest.java
 */

/*
This file is a file that contains unit tests for Student class. They are simple tests to test the functionality
individual modules.
 */

package mypriorityqueue;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private final ByteArrayOutputStream test = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpBeforeClass() {
        System.setOut(new PrintStream(test));
    }

    @AfterEach
    public void tearDownAfterClass() {
        System.setOut(originalOut);
    }

    Student hanna = new Student("hanna", 123, "hanna@sdsu.edu", 3.3F, 120);
    Student jesse = new Student("jesse", 1234, "jesse@sdsu.edu", 3.3F, 120);
    Student adam = new Student("adam", 124, "adam@sdsu.edu", 3.4F, 120);
    Student chris = new Student("chris", 123, "chris@sdsu.edu", 3.2F, 120);


    // Test to get calculation of priority of Student class
    @Test
    void getPriorityTest() {
        float priority = hanna.getPriority();
        float priority2 = hanna.calculatePriority();
        assertEquals(priority2, priority);
    }

    // TODO: Add functionality to test print statements
    // This will test the print output for a Student object.
    @Test
    void printStudentTest() {
        hanna.printStudent();
        assertEquals("Name: hanna redID: 123 priority: 84.99", test.toString().strip());
    }

    // Test compareTo implementation
    // 1. hanna and jesse priorities are the same so it should return 0
    // 2. hanna has lower priority than adam so we expect -1
    // 3. hanna should have higher priority than chris, so we expect 1
    @Test
    void compareToTest() {
        assertEquals(hanna.compareTo(jesse), 0);
        assertEquals(hanna.compareTo(adam), -1);
        assertEquals(hanna.compareTo(chris), 1);
    }
}