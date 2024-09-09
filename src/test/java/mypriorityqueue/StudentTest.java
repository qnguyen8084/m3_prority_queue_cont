package mypriorityqueue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {


    @Test
    void calculatePriority() {
        hanna.printStudent();
        float priority = hanna.calculatePriority();
        assertEquals((hanna.gpa * 0.3F + hanna.unitsTaken * 0.7F), priority);
    }

    @Test
    void getPriority() {
        hanna.printStudent();
        float priority = hanna.getPriority();
        assertEquals((hanna.gpa * 0.3F + hanna.unitsTaken * 0.7F), priority);
    }

    @Test
    void printStudent() {
        hanna.printStudent();
        jesse.printStudent();
        bob.printStudent();
        adam.printStudent();
        chris.printStudent();
    }

    @Test
    void compareTo() {
        float priority = hanna.calculatePriority();
        float priority2 = jesse.calculatePriority();
        System.out.println(hanna.compareTo(jesse));
    }
}