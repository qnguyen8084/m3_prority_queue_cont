/*
 * Quy Nguyen
 * CS635
 * Lab01 - Priority Queue
 * 9/9/24
 * StudentPriorityQueueTest.java
 */

/*
This file is a file that contains unit tests for StudentPriorityQueue class. They are simple tests to test the
functionality individual modules.
 */


package mypriorityqueue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StudentPriorityQueueTest {

    StudentPriorityQueue studentPriorityQ = new StudentPriorityQueue();

    Student hanna = new Student("hanna", 123, "hanna@sdsu.edu", 3.3F, 120);
    Student jesse = new Student("jesse", 1234, "hanna@sdsu.edu", 3.3F, 120);
    Student adam = new Student("adam", 124, "adam@sdsu.edu", 3.4F, 120);
    Student bob = new Student("bob", 123, "bob@sdsu.edu", 3.3F, 121);
    Student chris = new Student("chris", 123, "chris@sdsu.edu", 3.2F, 120);

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

    @Test
    void insertObjectTest() {
        studentPriorityQ.insertObject(hanna);
        assertEquals(studentPriorityQ.queueObject.getFirst(), hanna);
    }

    @Test
    void removeRootTest() {
        studentPriorityQ.insertObject(hanna);
        studentPriorityQ.insertObject(jesse);
        studentPriorityQ.insertObject(adam);
        studentPriorityQ.printQueuePriorities();
        studentPriorityQ.removeRoot();
    }

    @Test
    void getRootTest() {
        studentPriorityQ.insertObject(hanna);
        assertEquals(studentPriorityQ.getRoot(), hanna);
    }

    @Test
    void printQueuePrioritiesTest() {
        studentPriorityQ.insertObject(hanna);
        studentPriorityQ.insertObject(adam);
        studentPriorityQ.insertObject(bob);
        studentPriorityQ.insertObject(chris);
        studentPriorityQ.insertObject(jesse);
        studentPriorityQ.printQueuePriorities();
        assertEquals("Name:bobredID:123priority:85.689995Name:adamredID:124priority:85.02Name:hannaredID:123priority:84.99Name:jesseredID:1234priority:84.99Name:chrisredID:123priority:84.96", test.toString().strip().replaceAll("[\\n\\r ]", ""));
    }

    @Test
    void printOutputTest() {
        studentPriorityQ.printOutput(hanna);
        assertEquals("Name:hannaredID:123priority:84.99",
                test.toString().replaceAll("[\\n\\r ]", ""));

    }
}