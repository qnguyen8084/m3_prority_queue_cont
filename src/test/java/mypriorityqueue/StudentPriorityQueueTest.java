package mypriorityqueue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentPriorityQueueTest {

    StudentPriorityQueue studentPriorityQ = new StudentPriorityQueue();

    Student hanna = new Student("hanna", 123, "hanna@sdsu.edu", 3.3F, 120);
    Student jesse = new Student("jesse", 1234, "hanna@sdsu.edu", 3.3F, 120);
    Student adam = new Student("adam", 124, "adam@sdsu.edu", 3.4F, 120);
    Student bob = new Student("bob", 123, "bob@sdsu.edu", 3.3F, 121);
    Student chris = new Student("chris", 123, "chris@sdsu.edu", 3.2F, 120);

    @Test
    void insertObject() {
        studentPriorityQ.insertObject(hanna);
        assertEquals(studentPriorityQ.getRoot(), hanna);

    }

    @Test
    void removeRoot() {
        studentPriorityQ.insertObject(hanna);
        studentPriorityQ.insertObject(jesse);
        studentPriorityQ.insertObject(adam);
        studentPriorityQ.printQueuePriorities();
        studentPriorityQ.removeRoot();
    }

    @Test
    void getRoot() {
    }

    @Test
    void printQueuePriorities() {
    }

    @Test
    void printOutput() {
    }

    @Test
    void getParentIndex() {
    }

    @Test
    void getLeftChildIndex() {
    }

    @Test
    void getRightChildIndex() {
    }

    @Test
    void swap() {
    }

    @Test
    void raise() {
    }

    @Test
    void sink() {
    }

    @Test
    void testPrintOutput() {
    }

    @Test
    void calculatePriority() {
    }
}