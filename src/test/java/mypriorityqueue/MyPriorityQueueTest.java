/*
 * Quy Nguyen
 * CS635
 * Lab01 - Priority Queue
 * 9/9/24
 * MyPriorityQueueTest.java
 */

/*
This file is a file that contains unit tests for MyPriorityQueue class. They are simple tests to test the functionality
individual modules.
 */


package mypriorityqueue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyPriorityQueueTest extends MyPriorityQueue<Integer> {

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

    MyPriorityQueue<Integer> myPriorityQueue = new MyPriorityQueue<>();

    @Test
     void insertObjectTest() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            //input = (int)(Math.random()*100)+1;
            myPriorityQueue.insertObject(i);
            count++;
        }
        assertEquals(count, myPriorityQueue.queueObject.size());
    }

    @Test
    void removeRootTest() {
        myPriorityQueue.insertObject(102);
        assertEquals(102, myPriorityQueue.queueObject.getFirst());
        myPriorityQueue.removeRoot();
        assertEquals(0, myPriorityQueue.queueObject.size());
    }

    @Test
    void getRootTest() {
        myPriorityQueue.insertObject(102);
        assertEquals(102, myPriorityQueue.getRoot());
    }


    @Test
    void printQueuePrioritiesTest() {
        myPriorityQueue.insertObject(102);
        myPriorityQueue.insertObject(10);
        myPriorityQueue.insertObject(1);
        myPriorityQueue.insertObject(40);
        myPriorityQueue.insertObject(13);
        myPriorityQueue.insertObject(40);
        myPriorityQueue.printQueuePriorities();
        assertEquals("102404013101", test.toString().replaceAll("[\\n\\r]", ""));
    }

    @Test
    void printOutputTest() {
        myPriorityQueue.insertObject(102);
        myPriorityQueue.insertObject(10);
        myPriorityQueue.insertObject(1);
        myPriorityQueue.insertObject(40);
        myPriorityQueue.insertObject(13);
        myPriorityQueue.insertObject(40);
        myPriorityQueue.printQueuePriorities();
        assertEquals("102404013101", test.toString().replaceAll("[\\n\\r]", ""));
    }

    @Test
    void getParentIndexTest() {
        assertEquals(0, getParentIndex(1));
        assertEquals(0, getParentIndex(2));
        assertEquals(2, getParentIndex(5));
        assertEquals(4, getParentIndex(10));
        assertEquals(24, getParentIndex(50));
        assertEquals(40, getParentIndex(81));
    }

    @Test
    void getLeftChildIndexTest() {
        assertEquals(21, getLeftChildIndex(10));
        assertEquals(1, getLeftChildIndex(0));
        assertEquals(19, getLeftChildIndex(9));
        assertEquals(25, getLeftChildIndex(12));
        assertEquals(101, getLeftChildIndex(50));
        assertEquals(163, getLeftChildIndex(81));
    }

    @Test
    void getRightChildIndexTest() {
        assertEquals(22, getRightChildIndex(10));
        assertEquals(2, getRightChildIndex(0));
        assertEquals(20, getRightChildIndex(9));
        assertEquals(22, getRightChildIndex(10));
        assertEquals(102, getRightChildIndex(50));
        assertEquals(164, getRightChildIndex(81));
    }

    @Test
    void swapTest() {
        myPriorityQueue.queueObject.add(102);
        myPriorityQueue.queueObject.add(10);
        Integer a = myPriorityQueue.queueObject.getFirst();
        Integer b = myPriorityQueue.queueObject.getLast();
        myPriorityQueue.swap(0,1);
        assertEquals(a, myPriorityQueue.queueObject.getLast());
        assertEquals(b, myPriorityQueue.queueObject.getFirst());
    }
}