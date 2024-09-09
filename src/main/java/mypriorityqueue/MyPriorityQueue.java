/*
 * Quy Nguyen
 * CS635
 * Lab01 - Priority Queue
 * 9/9/24
 */

package mypriorityqueue;

import java.util.ArrayList;

// Declaration of PriorityQueue class that is implemented using a binary max heap
public class MyPriorityQueue<T extends Comparable<? super T>> {
    // Declare a ArrayList object, students
    protected ArrayList<T> queueObject;

    // Constructor for PriorityQueue class
    public MyPriorityQueue() {
        queueObject = new ArrayList<>();
    }

    // Method to add Student object to the heap. It adds the student object to the end of the list and if the entries
    // contained in the priorityQueue are greater than 1 it will call the raise method to move the entry to the correct
    // position in the heap.
    public void insertObject(T element) {
        queueObject.add(element);
        if (queueObject.size() > 1) {
            raise();
        }
    }

    // This method returns the entry at root with the highest priority. It first copies the entry to a temporary Student
    // object, then it sets the last entry to the first entry, removes the last entry, performs sink method on new root
    // entry, and then returns the Student object that was originally removed from root.
    public T removeRoot() {
        T root = getRoot();
        queueObject.set(0, queueObject.getLast());
        queueObject.removeLast();
        sink();
        return root;
    }

    public T getRoot() {
        T first = queueObject.getFirst();
        return first;
    }

    // Method to print all Student object entries contained in the heap
    public void printQueuePriorities() {
        MyPriorityQueue<T> temp = new MyPriorityQueue<>();
        T root;
        while (!queueObject.isEmpty()) {
            root = removeRoot();
            temp.insertObject(root);
            printOutput(root);
        }
        System.out.println();
        queueObject = temp.queueObject;
    }

    public void printOutput(T root) {
        System.out.print(root + ", ");
    }

    // Method to obtain index of parent node which is used to raise or float student objects to their correct
    // place in the heap
    static int getParentIndex(int currentIndex) {
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
    public void swap(int IndexA, int IndexB) {
        T temp = queueObject.get(IndexA);
        queueObject.set(IndexA, queueObject.get(IndexB));
        queueObject.set(IndexB, temp);
    }

    // This method is to raise a new entry added to the heap that is always added to the end to its correct place in
    // the heap by swapping with parent entries that have a lower priority.
    public void raise() {
        int arrayIndex = queueObject.size() - 1;
        while (arrayIndex > 0
                && (queueObject.get(getParentIndex(arrayIndex)).compareTo(queueObject.get(arrayIndex))) < 0) {
            swap(getParentIndex(arrayIndex), arrayIndex);
            arrayIndex = getParentIndex(arrayIndex);
        }
    }



    // Method to sink an entry to it's correct place in the heap. This method is used when removing the highest priority
    // entry from root by swapping the highest priority entry with the last entry in the heap, removing the last entry which
    // was the highest priority entry, then using this sink method on the entry now located at the root of the heap.
    public void sink() {
        int arraySize = queueObject.size();
        int index = 0;

        while (index < arraySize) {
            int leftChild = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);
            int highPriorityChildIndex = leftChild;

            if (rightChildIndex < arraySize
                    && queueObject.get(rightChildIndex).compareTo(queueObject.get(leftChild)) > 0) {
                highPriorityChildIndex = rightChildIndex;
            }

            if (highPriorityChildIndex < arraySize
                    && queueObject.get(highPriorityChildIndex).compareTo(queueObject.get(index)) > 0) {
                swap(highPriorityChildIndex, index);
                index = highPriorityChildIndex;
            } else {
                break;
            }
        }
    }
}
