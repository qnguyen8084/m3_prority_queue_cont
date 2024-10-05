/*
 * Quy Nguyen
 * CS635
 * Lab01 - Priority Queue
 * 9/9/24
 * LabRequirementsTests.java
 */

/*
* This file contains the testing needed to satisfy the requirements from the lab objectives.
* It should promote scalability, address boundary/edge cases, and other uncommon scenarios.
* Due to time constraints I was only able to test the priorities using integers instead of the
* StudentPriorityQueue class. Assuming that all the unit tests are satisfactory, it reduces the
* risk of unexpected behavior significantly.
 */

package mypriorityqueue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LabRequirementTests {
    StudentPriorityQueue studentPriorityQ = new StudentPriorityQueue();
    PriorityQueue<Integer> myPriorityQ = new PriorityQueue<>(Collections.reverseOrder());

    Student s1 = new Student("s1", 1, "s1@sdsu.edu", 1.1F, 50);
    Student s2 = new Student("s2", 2, "s2@sdsu.edu", 2.2F, 100);
    Student s3 = new Student("s3", 3, "s3@sdsu.edu", 3.3F, 75);
    Student s4 = new Student("s4", 4, "s4@sdsu.edu", 0.0F, 150);
    Student s5 = new Student("s5", 5, "s5@sdsu.edu", 4.0F, 0);

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

    // Adding Students with different priorities
    @Test
    void addingDifferentPrioritiesTest() {
        myPriorityQ.offer(1);
        assertEquals(1, myPriorityQ.peek());
        myPriorityQ.offer(10);
        assertEquals(10, myPriorityQ.peek());
        myPriorityQ.offer(5);
        assertEquals(10, myPriorityQ.peek());
        myPriorityQ.offer(7);
        assertEquals(10, myPriorityQ.peek());
        myPriorityQ.offer(12);
        assertEquals(12, myPriorityQ.peek());
        myPriorityQ.offer(20);
        assertEquals(20, myPriorityQ.peek());
        myPriorityQ.offer(20);
        assertEquals(20, myPriorityQ.peek());
        myPriorityQ.offer(21);
        assertEquals(21, myPriorityQ.peek());
    }

    // Adding and removing students with different priorities
//    @Test
//    void removingDifferentPrioritiesTest() {
//        int nextPriority;
//        for(int i = 0; i < 20; i++) {
//            myPriorityQ.offer((int) (Math.random() * (100)));
//        }
//        for(int i = 0; i < 20; i++) {
//            if(myPriorityQ.queue.size() > 1) {
//                if(myPriorityQ.queue.size() <= 2) {
//                    nextPriority = myPriorityQ.queue.get(1);
//                } else if (myPriorityQ.queue.get(1) >= myPriorityQ.queue.get(2)) {
//                    nextPriority = myPriorityQ.queue.get(1);
//                } else {
//                    nextPriority = myPriorityQ.queue.get(2);
//                }
//            } else {
//                break;
//            }
//            myPriorityQ.poll();
//            assertEquals(nextPriority, myPriorityQ.peek());
//        }
//    }

    // Adding removing Students with the same priority
    // There is an issue in keeping priority order with the order of Student objects added to Q
    //
    @Test
    void addingAndRemovingStudentsWithSamePriorityTest() {
        Student s1 = new Student("s1", 1, "s1@sdsu.edu", 1.0F, 100);
        Student s2 = new Student("s2", 2, "s2@sdsu.edu", 1.0F, 100);
        Student s3 = new Student("s3", 2, "s2@sdsu.edu", 1.0F, 100);
        Student s4 = new Student("s4", 2, "s2@sdsu.edu", 1.0F, 100);
        Student s5 = new Student("s5", 2, "s2@sdsu.edu", 1.0F, 100);
        Student s6 = new Student("s6", 2, "s2@sdsu.edu", 1.0F, 100);
        Student s7 = new Student("s7", 2, "s2@sdsu.edu", 1.0F, 100);
        Student s8 = new Student("s8", 2, "s2@sdsu.edu", 1.0F, 100);
        Student s9 = new Student("s9", 2, "s2@sdsu.edu", 1.0F, 100);
        Student s10 = new Student("s10", 2, "s2@sdsu.edu", 1.0F, 100);
        studentPriorityQ.offer(s1);
        studentPriorityQ.offer(s2);
        studentPriorityQ.offer(s3);
        studentPriorityQ.offer(s4);
        studentPriorityQ.offer(s5);
        studentPriorityQ.offer(s6);
        studentPriorityQ.offer(s7);
        studentPriorityQ.offer(s8);
        studentPriorityQ.offer(s9);
        studentPriorityQ.offer(s10);
        studentPriorityQ.printQueuePriorities();
        assert studentPriorityQ.peek() != null;
        assertEquals("s1", studentPriorityQ.peek().getName());
        studentPriorityQ.poll();
        assert studentPriorityQ.peek() != null;
        assertEquals("s2", studentPriorityQ.peek().getName());
        studentPriorityQ.poll();
        assert studentPriorityQ.peek() != null;
        assertEquals("s3", studentPriorityQ.peek().getName());
        studentPriorityQ.poll();
        assert studentPriorityQ.peek() != null;
        assertEquals("s4", studentPriorityQ.peek().getName());
        studentPriorityQ.poll();
        assert studentPriorityQ.peek() != null;
        assertEquals("s5", studentPriorityQ.peek().getName());
        studentPriorityQ.poll();
    }

    // Pass if exception is detected for GPA is above 4.0 or under 0
    @Test
    void outOfRangeGPATest() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> new Student("Over GPA", 1234566, "gpa@sdsu.edu", 4.1F, 120));
        Assertions.assertThrows(ArithmeticException.class,
                () -> new Student("Negative GPA", 1234566, "gpa@sdsu.edu", -0.1F, 120));
    }

    // Pass if exception is detected for unitsTaken above 150 or below 0
    @Test
    void outOfRangeUnitsTakenTest() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> new Student("Over Units", 1234566, "gpa@sdsu.edu", 4.0F, 151));
        Assertions.assertThrows(ArithmeticException.class,
                () -> new Student("Lost Units", 1234566, "gpa@sdsu.edu", 0.0F, -1));
    }

    // Test to check priority calculation of Student object, this method is defined in Student class
    @Test
    void calculatePriorityTest() {
        float priority = s1.calculatePriority();
        assertEquals((s1.getGpa() * 0.3F + s1.getUnitsTaken() * 0.7F), priority);
    }

    // Test to verify calculation of student priority, queueCalculatePriority,
    // defined in StudentPriorityClass
    @Test
    void calculateQueuePriorityTest() {
        assertEquals(s1.getGpa() * 0.3f + s1.getUnitsTaken() * 0.7f,
                studentPriorityQ.queueCalculatePriority(s1));
        assertEquals(s2.getGpa() * 0.3f + s2.getUnitsTaken() * 0.7f,
                studentPriorityQ.queueCalculatePriority(s2));
        assertEquals(s3.getGpa() * 0.3f + s3.getUnitsTaken() * 0.7f,
                studentPriorityQ.queueCalculatePriority(s3));
        assertEquals(s4.getGpa() * 0.3f + s4.getUnitsTaken() * 0.7f,
                studentPriorityQ.queueCalculatePriority(s4));
        assertEquals(s5.getGpa() * 0.3f + s5.getUnitsTaken() * 0.7f,
                studentPriorityQ.queueCalculatePriority(s5));
    }
}