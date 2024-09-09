package mypriorityqueue;

import org.junit.jupiter.api.Test;

class MyPriorityQueueTest {
    static MyPriorityQueue<Integer> myPriorityQueue = new MyPriorityQueue<>();
/*
    @BeforeAll
    void setUp() {
        myPriorityQueue = new MyPriorityQueue<>();
    }

    @AfterEach
    void tearDown() {
    }
*/
    @Test
    void insertObject() {
        int input;
        for (int i = 0; i < 100; i++) {
            input = (int)(Math.random()*100)+1;
            myPriorityQueue.insertObject(input);
        }
        myPriorityQueue.printQueuePriorities();
    }

    @Test
    void removeRootTest() {
        myPriorityQueue.removeRoot();
        myPriorityQueue.printQueuePriorities();
    }

    @Test
    void getRoot() {
        System.out.println(myPriorityQueue.getRoot());
    }
    @Test

    void printQueuePriorities() {
        myPriorityQueue.printQueuePriorities();
    }

    @Test
    void printOutput() {
        printQueuePriorities();
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
}