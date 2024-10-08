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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StudentPriorityQueueTest {

    StudentPriorityQueue studentPriorityQ;

    Student hanna = new Student("hanna", 123, "hanna@sdsu.edu", 3.3F, 120);
    Student jesse = new Student("jesse", 1234, "hanna@sdsu.edu", 3.3F, 120);
    Student adam = new Student("adam", 124, "adam@sdsu.edu", 3.4F, 120);
    Student bob = new Student("bob", 123, "bob@sdsu.edu", 3.3F, 121);
    Student chris = new Student("chris", 123, "chris@sdsu.edu", 3.2F, 120);

    private final ByteArrayOutputStream test = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    StudentPriorityQueueTest() {
        studentPriorityQ = new StudentPriorityQueue();
    }

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
        studentPriorityQ.add(hanna);
        assertEquals(studentPriorityQ.peek(), hanna);
    }
//
    @Test
    void getRootTest() {
        studentPriorityQ.offer(hanna);
        assertEquals(studentPriorityQ.peek(), hanna);
    }

    @Test
    void insertMultipleStudents() {
        studentPriorityQ.insert(hanna);
        studentPriorityQ.insert(jesse);
        studentPriorityQ.insert(adam);
        assertEquals(studentPriorityQ.size(), 3);
    }

    @Test
    void getHeadFromEmptyQueue() {
        assertNull(studentPriorityQ.peek());
    }

    @Test
    void iteratorHasNextOnEmptyQueue() {
        Iterator<Student> iterator = studentPriorityQ.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    void iteratorNextOnEmptyQueue() {
        Iterator<Student> iterator = studentPriorityQ.iterator();
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void iteratorTraversal() {
        System.setOut(originalOut);
        studentPriorityQ.insert(hanna);
        studentPriorityQ.insert(jesse);
        studentPriorityQ.insert(adam);
        Iterator<Student> iterator = studentPriorityQ.iterator();
        assertTrue(iterator.hasNext());
        Student student = iterator.next();
        student.printStudent();
        assertEquals(student, hanna);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), jesse);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), adam);
        assertFalse(iterator.hasNext());
    }

    @Test
    void insertStudentIncreasesSize() {
        studentPriorityQ.insert(hanna);
        assertEquals(1, studentPriorityQ.size());
    }

    @Test
    void insertMultipleStudentsMaintainsOrder() {
        studentPriorityQ.insert(hanna);
        studentPriorityQ.insert(jesse);
        studentPriorityQ.insert(adam);
        assertEquals(hanna, studentPriorityQ.deleteHead());
        assertEquals(jesse, studentPriorityQ.deleteHead());
        assertEquals(adam, studentPriorityQ.deleteHead());
    }

    @Test
    void removeStudentDecreasesSize() {
        studentPriorityQ.insert(hanna);
        studentPriorityQ.insert(jesse);
        studentPriorityQ.remove(hanna);
        assertEquals(1, studentPriorityQ.size());
    }

    @Test
    void removeNonExistentStudent() {
        studentPriorityQ.insert(hanna);
        assertNull(studentPriorityQ.delete(adam));
    }

    @Test
    void getHeadFromNonEmptyQueue() {
        studentPriorityQ.insert(hanna);
        assertEquals(hanna, studentPriorityQ.getHead());
    }

    @Test
    void iteratorTraversesAllElements() {
        studentPriorityQ.insert(hanna);
        studentPriorityQ.insert(jesse);
        studentPriorityQ.insert(adam);
        Iterator<Student> iterator = studentPriorityQ.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(hanna, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(adam, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(jesse, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void deleteHeadRemovesHighestPriorityElement() {
        studentPriorityQ.insert(hanna);
        studentPriorityQ.insert(jesse);
        studentPriorityQ.insert(adam);
        assertEquals(hanna, studentPriorityQ.deleteHead());
        assertEquals(jesse, studentPriorityQ.peek());
    }

    @Test
    void deleteHeadFromEmptyQueueReturnsNull() {
        assertNull(studentPriorityQ.deleteHead());
    }

    @Test
    void deleteSpecificStudentRemovesCorrectElement() {
        studentPriorityQ.insert(hanna);
        studentPriorityQ.insert(jesse);
        studentPriorityQ.insert(adam);
        assertEquals(true, studentPriorityQ.remove(jesse));
        assertEquals(2, studentPriorityQ.size());
        assertFalse(studentPriorityQ.contains(jesse));
    }

    @Test
    void deleteNonExistentStudentReturnsNull() {
        studentPriorityQ.insert(hanna);
        assertNull(studentPriorityQ.delete(adam));
    }

    @Test
    void getHeadReturnsHighestPriorityElement() {
        studentPriorityQ.insert(hanna);
        studentPriorityQ.insert(jesse);
        studentPriorityQ.insert(adam);
        assertEquals(hanna, studentPriorityQ.getHead());
    }

    @Test
    void getHeadFromEmptyQueueReturnsNull() {
        assertNull(studentPriorityQ.getHead());
    }

}