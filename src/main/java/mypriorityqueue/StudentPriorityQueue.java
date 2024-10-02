/*
* Quy Nguyen
* CS635
* Lab01 - Priority Queue
* 9/9/24
* StudentPriorityQueue.java
*/

package mypriorityqueue;

import java.util.PriorityQueue;

// Definition of StudentPriorityQueue that extends/inherits the properties MyPriorityQueue class
// We specify that we will be using Student objects instead of generic T
public class StudentPriorityQueue extends MyPriorityQueue<Student> {

    // Overrides printOutput function to call printStudent function from a student object
    @Override
    public void printOutput(Student student) {
        student.printStudent();
    }

    // Implementation of priority calculation for student according to assignment specification
    // Another method is also defined in Student class file to reduce coupling.
    public float queueCalculatePriority(Student priorityStudent) {
        return (priorityStudent.getGpa() * 0.3F + priorityStudent.getUnitsTaken() * 0.7F);
    }

}
