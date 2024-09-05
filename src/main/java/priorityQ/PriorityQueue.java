/*
 * Quy Nguyen
 * CS635
 * Lab01 - Priority Queue
 * 9/9/24
 */

package priorityQ;
import java.util.ArrayList;

// Declaration of PriorityQueue class that is implemented using a binary max heap
public class PriorityQueue {
    // Declare a ArrayList object, students
    ArrayList<Student> students;

    // Constructor for PriorityQueue class
    public PriorityQueue() {
        this.students = new ArrayList<>();
    }

    // Method to obtain index of parent node which is used to raise or float student objects to their correct
    // place in the heap
    static int parentIndex(int currentIndex) {
        return (currentIndex - 1) / 2;
    }

    // Method to obtain the index of the left child of a parent located at currentIndex
    static int getLeftChildIndex(int currentIndex) {
        return (currentIndex * 2) + 1;
    }

    // Method to obtain the index of the right child of a parent located at currentIndex
    static int getRightChildIndex(int currentIndex) {
        return (currentIndex * 2) + 2;
    }

    // Method to swap two entries in the array by assigning the first entry to a temporary Student object, overriding that object
    // with the other entry of the second Student object, and finally assigning the original entry assigned to temp to the location that
    // was previously assigned to the second object.
    public void swap(int firstIndex, int secondIndex) {
        Student temp = students.get(firstIndex);
        students.set(firstIndex, students.get(secondIndex));
        students.set(secondIndex, temp);
    }

    // This method is to raise a new entry added to the heap that is always added to the end to its correct place in
    // the heap by swapping with parent entries that have a lower priority.
    public void raise() {
        int arrayIndex = students.size() - 1;
        while (arrayIndex > 0
                && (students.get(parentIndex(arrayIndex)).priority < students.get(arrayIndex).priority)) {
            swap(parentIndex(arrayIndex), arrayIndex);
            arrayIndex = parentIndex(arrayIndex);
        }
    }

    // Method to sink an entry to it's correct place in the heap. This method is used when removing the highest priority
    // entry from root by swapping the highest priority entry with the last entry in the heap, removing the last entry which
    // was the highest priority entry, then using this sink method on the entry now located at the root of the heap.
    public void sink() {
        int arraySize = students.size();
        int index = 0;

        while (index < arraySize) {
            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);
            int highPriorityChildIndex = leftChildIndex;

            if (rightChildIndex < arraySize && students.get(rightChildIndex).priority > students.get(leftChildIndex).priority) {
                highPriorityChildIndex = rightChildIndex;
            }

            if (highPriorityChildIndex < arraySize && students.get(highPriorityChildIndex).priority > students.get(index).priority) {
                swap(highPriorityChildIndex, index);
                index = highPriorityChildIndex;
            } else {
                break;
            }
        }
    }

    // Method to add Student object to the heap. It adds the student object to the end of the list and if the entries
    // contained in the priorityQueue are greater than 1 it will call the raise method to move the entry to the correct
    // position in the heap.
    public void insertRecord(Student student) {
        students.add(student);
        if (students.size() > 1) {
            raise();
        }
    }

    // This method returns the entry at root with the highest priority. It first copies the entry to a temporary Student
    // object, then it sets the last entry to the first entry, removes the last entry, performs sink method on new root
    // entry, and then returns the Student object that was originally removed from root.
    public Student removeTopPriority(ArrayList<Student> students) {
        Student firstPriorityStudent = students.getFirst();
        students.set(0, students.getLast());
        students.removeLast();
        sink();
        return firstPriorityStudent;
    }

    // Method to return root node to caller
    public Student getTopPriority() {
        return students.getFirst();
    }

    // Method called to print data contained at root node
    public void printTopPriority() {
        Student topPriority = getTopPriority();
        System.out.println(topPriority.name + topPriority.redID + topPriority.email + topPriority.gpa + topPriority.unitsTaken + topPriority.priority);
    }

    // Method to print all Student object entries contained in the heap
    public void printStudentPriorities() {
        int arraySize = students.size();
        System.out.println("arraySize = " + arraySize);
        for (int i = 0; i < arraySize; i++) {
            System.out.println(
                     i + ": " + students.get(i).name + " - " + students.get(i).priority);
        }
    }

}
