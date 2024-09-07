package mypriorityqueue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class StudentTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    void testPrintStudent() {
        Student studentTest = new Student("quy", 12345, "qnguyen.1234@sdsu.edu", 3.0F, 3);
        studentTest.printStudent();
        assertEquals("Name: quy redID: 12345", outContent.toString().strip());
    }

    @Test
    void testCalculatePriority() {
        Student studentTest = new Student("quy", 12345, "qnguyen.1234@sdsu.edu", 3.0F, 3);
        assertEquals( 3.0F * 0.3F + 3 * 0.7F, studentTest.calculatePriority(studentTest.gpa, studentTest.unitsTaken));
    }

    @Test
    void testGetPriority() {
        Student studentTest = new Student("quy", 12345, "qnguyen.1234@sdsu.edu", 3.0F, 3);
        assertEquals( 3.0F * 0.3F + 3 * 0.7F, studentTest.getPriority());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}