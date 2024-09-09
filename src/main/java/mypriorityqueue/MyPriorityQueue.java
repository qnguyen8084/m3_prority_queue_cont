/*
 * Quy Nguyen
 * CS635
 * Lab01 - Priority Queue
 * 9/9/24
 *
 *  This is my implementation of a priority Queue using Binary Heaps. It would not have been possible without all the
 *  resources available online. Some of the algorithm may look similar, but I have adapted it for the purposes of this
 *  Lab. We will go over some design chooses that I made in order of the Key Feature areas specified in the lab
 *  assignment. There are also comments in the code to clarify what was done if the logic may take more effort to
 *  comprehend.
 *
 *  1. Algorithm Efficiency : I choose to go with a binary heap implementation because it is more efficient than an
 *  array or linked list implementation of a priority queue. Without going into detail of the implementations of
 *  priority queues using an array or linked list has a time complexity of O(n) for certain operations. For a binary
 *  heap the operation to add and remove the root which contains the high priority object is O(log_n) because as the
 *  size of the heap grows the operation to add or remove elements is not linearly related to the size of the heap,
 *  but dependent on how many levels an operation has to traverse down or up a tree. As the tree grows the nodes in
 *  each level of the heap grows by a factor or 2 i.e. 1,2,4,8,16,32...
 *
 *  In this exercise the three main methods we will go over is are adding new elements, returning high priority element,
 *  and removing element with the highest priority.
 *
 *  * Adding new elements: To insert an object this method will add the element to the end of the heap and then use the
 *  raise method to find its respective place in the heap. The raise method compares the parent node and if the priority
 *  of the parent node is less than the priority of the element to be added they will have there positions in the heap
 *  swapped. This goes on until the priority of the parent node of the element added is either greater than or equal to
 *  the element being added or the element being added has reached the root. This also conserves a priority for objects
 *  with the same priority value in the order they were added to the head since the elements are not swapped when
 *  the comparison between the added element and it's parent is equal.
 *     public void insertObject(T element) {
 *       queueObject.add(element);
 *      if (queueObject.size() > 1) {
 *           raise();
 *       }
 *      }
 *
 *
 *  2.
 *
 */

package mypriorityqueue;

import java.util.ArrayList;

// Declaration of PriorityQueue class that is implemented using a binary max heap
public class MyPriorityQueue<T extends Comparable<? super T>> {
    // Declare a ArrayList object, students
    public ArrayList<T> queueObject;

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
        T root = queueObject.getFirst();
        queueObject.set(0, queueObject.getLast());
        queueObject.removeLast();
        sink();
        return root;
    }

    public T getRoot() {
        return queueObject.getFirst();
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
        System.out.println(root);
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
