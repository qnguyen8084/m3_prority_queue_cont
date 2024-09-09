package mypriorityqueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyPriorityQueueTest extends MyPriorityQueue<Integer> {
    public MyPriorityQueue<Integer> myPriorityQueue = new MyPriorityQueue<>();

    @BeforeEach

    @Test
     void insertObjectTest() {
        int input;
        for (int i = 0; i <= 10; i++) {
            //input = (int)(Math.random()*100)+1;
            myPriorityQueue.insertObject(i);
        }
        myPriorityQueue.printQueuePriorities();

    }

    @Test
    void removeRootTest() {
        myPriorityQueue.insertObject(102);
        myPriorityQueue.printQueuePriorities();
        myPriorityQueue.removeRoot();
        myPriorityQueue.printQueuePriorities();
    }

    @Test
    void getRootTest() {
        int priority = myPriorityQueue.getRoot();
    }


    @Test
    void printQueuePrioritiesTest() {
        myPriorityQueue.printQueuePriorities();
    }

    @Test
    void printOutputTest() {
        printQueuePriorities();
    }

    @Test
    void getParentIndexTest() {
    }

    @Test
    void getLeftChildIndexTest() {
    }

    @Test
    void getRightChildIndexTest() {
    }

    @Test
    void swapTest() {
    }

    @Test
    void raiseTest() {
    }

    @Test
    void sinkTest() {
    }
}