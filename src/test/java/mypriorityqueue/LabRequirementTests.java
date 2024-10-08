/*
 * Quy Nguyen
 * CS635
 * M3 - Priority Queue (continued)
 * 10/7/2024
 * LabRequirementTests.java
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
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LabRequirementTests {
    PriorityOrderStrategy priorityOrder = new PriorityOrderStrategy(new MaxStrategy());
    StudentPriorityQueue studentPriorityQ = new StudentPriorityQueue(priorityOrder.applyPriority());
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

    // Adding removing Students with the same priority
    // There is an issue in keeping priority order with the order of Student objects added to Q
    //
    @Test
    void addingAndRemovingStudentsWithSamePriorityMaxPriorityTest() throws InterruptedException {
        StudentPriorityQueue studentPriorityQ2 = new StudentPriorityQueue(priorityOrder.applyPriority());
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
        Student[] studentList = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};
        for (Student student: studentList) {
            studentPriorityQ2.insert(student);
            TimeUnit.NANOSECONDS.sleep(1);
        }

        System.setOut(originalOut);

        Iterator<Student> iterator = studentPriorityQ2.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            student.printStudent();
        }

        for (Student student: studentList) {
            Student result = studentPriorityQ2.poll();
            assertEquals(student.getName(), result.getName());
        }


    }

    // Adding removing Students with the same priority
    // There is an issue in keeping priority order with the order of Student objects added to Q
    //
    @Test
    void addingAndRemovingStudentsWithSamePriorityMinPriorityTest() throws InterruptedException {
        priorityOrder.setPriorityOrder(new MinStrategy());
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
        Student[] studentList = {s10, s9, s8, s7, s6, s5, s4, s3, s2, s1};
        for (Student student: studentList) {
            studentPriorityQ.insert(student);
            TimeUnit.NANOSECONDS.sleep(1);
        }
        assert studentPriorityQ.peek() != null;

        System.setOut(originalOut);

        Iterator<Student> iterator = studentPriorityQ.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            student.printStudent();
        }

        for (Student student: studentList) {
            Student result = studentPriorityQ.poll();
            assertEquals(student.getName(), result.getName());
        }

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

    @Test
    void transferedFromMain() {

        PriorityOrderStrategy priorityOrder = new PriorityOrderStrategy(new MinStrategy());
        StudentPriorityQueue studentPriorityQ = new StudentPriorityQueue(priorityOrder.applyPriority());
        priorityOrder.setPriorityOrder(new MaxStrategy());
        StudentPriorityQueue studentPriorityQ2 = new StudentPriorityQueue(priorityOrder.applyPriority());

        Student hanna = new Student("hanna", 123, "hanna@sdsu.edu", 3.3F, 120);
        Student jesse = new Student("jesse", 1234, "hanna@sdsu.edu", 3.3F, 120);
        Student adam = new Student("adam", 124, "adam@sdsu.edu", 3.4F, 120);
        Student bob = new Student("bob", 123, "bob@sdsu.edu", 3.3F, 121);
        Student chris = new Student("chris", 123, "chris@sdsu.edu", 3.2F, 120);

        Student[] studentList = {hanna, jesse, adam, bob, chris};

        for (Student student: studentList) {
            boolean result = studentPriorityQ.insert(student);
            System.out.println("Inserted: " + result);
        }

        for (Student student: studentList) {
            Student result = studentPriorityQ.remove();
            System.out.println("Removed: " + result);
        }


        for (Student student: studentList) {
            boolean result = studentPriorityQ2.insert(student);
            System.out.println("Inserted: " + result);
        }
        for (Student student: studentList) {
            Student result = studentPriorityQ2.remove();
            System.out.println("Removed: " + result);
        }
    }
}