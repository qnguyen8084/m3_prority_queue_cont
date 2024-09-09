package mypriorityqueue;

public class StudentPriorityQueue extends MyPriorityQueue<Student> {
    // Declare a ArrayList object, students
    // Constructor for PriorityQueue class

    public void printOutput(Student priorityStudent) {
        priorityStudent.printStudent();
    }

    public float calculatePriority(Student priorityStudent) {
        return priorityStudent.gpa * 0.3F + priorityStudent.unitsTaken * 0.7F;
    }

}
