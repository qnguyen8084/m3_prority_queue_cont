package mypriorityqueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyPriorityQueueTest extends MyPriorityQueue<Integer> {
    public MyPriorityQueue<Integer> myPriorityQueue = new MyPriorityQueue<>();

    @Test
     void insertObjectTest() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            //input = (int)(Math.random()*100)+1;
            myPriorityQueue.insertObject(i);
            count++;
        }
        System.out.println(myPriorityQueue.queueObject.size());
        assertEquals(count, myPriorityQueue.queueObject.size());
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