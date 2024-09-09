/*
 * Quy Nguyen
 * CS635
 * Lab01 - Priority Queue
 * 9/9/24
 * MyPriorityQueue.java
 *
 *  This is my implementation of a priority Queue using Binary Heaps. It would not have been possible without all the
 *  resources available online. Some of the algorithm may look similar, but I have adapted it for the purposes of this
 *  Lab. We will go over some design chooses that I made in order of the Key Feature areas specified in the lab
 *  assignment. There are also comments in the code to clarify what was done if the logic may take more effort to
 *  comprehend.
 *
 *  1. Algorithm Efficiency: I choose to go with a binary heap implementation because it is more efficient than an
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
 *  the element being added or the element being added has reached the root. This also conserves the priority for objects
 *  with the same priority value in the order they were added to the head since the elements are not swapped when
 *  the comparison between the priorities of the added element, and it's parent is equal. The time complexity of this
 *  method is at most O(log_n) since the element only needs to traverse from the bottom of the tree to the root through
 *  its parent node.
 *
 *     public void insertObject(T element) {
 *       queueObject.add(element);
 *      if (queueObject.size() > 1) {
 *           raise();
 *       }
 *      }
 *
 *  * Returning element with the highest priority: To retrieve the element with the highest priority we would simply
 *  look at the root node since it will always contain the element with the highest priority. This operation gives has
 *  a time complexity of O(1).
 *
 *     public T getRoot() {
 *      return queueObject.getFirst();
 *  }
 *
 *  * Removing element with the highest priority: To remove the element with the highest priority we would first
 *  replace the element at the end of the heap with the root. Then we would run a sink operation on the root node to
 *  place that element in its correct position in the tree. This is done in the following order.
 *  while index is smaller than array size assign left child the as the higher priority child
 *  if the right child exists then compare the left and right child and assign the one with higher priority higherprioritychild
 *  then the higherprioritychild is higher than the element priority swap the two elements positions in the heap and
 *  continue until element is in the correct place or at the end of the heap. To conserve the priority of elements of
 *  the same priority added if the priority of the two elements is equal than swap the elements. This is because the
 *  element was originally located at the end of the heap suggesting it added after the parent node due to the logic of
 *  the raise method used when adding an element. The time complexity of this operation is at most O(log_n) since it
 *  it only has to traverse down the nodes of the tree when placing the last element that was set moved to root to
 *  its correct place in the heap.
 *
 *     public T removeRoot() {
 *       T root = queueObject.getFirst();
 *       queueObject.set(0, queueObject.getLast());
 *       queueObject.removeLast();
 *       sink();
 *       return root;
 *   }
 *
 *  * Time complexities
 *    Insert element - O(log_n)
 *    return root - O(1)
 *    remove root - O(log_n)
 *
 *   2. Object-Oriented Design:
 *   * Implement priority queue capable of holding student objects: My design follows a few design patterns. It mostly
 *   used behavioral pattern where I have an interface that interacts with a priorityQueue object. I'm not too savvy on
 *   the particulars of individual behavioral design pattern names, but I feel like this fits the bill. The priority
 *   queue class abstracts the way it adds elements, removes elements, returns the root, and prints out the queue.
 *   My implementation of the priority queue also allows inheritance with the use of generics allowing it to be used
 *   with different data types or class objects. I have also defined another priority queue class named StudentPriorityQueue
 *   which specifies that the queue will be using the Student class as it's data type.
 *
 *   * Define a student with class attributes; name, redID, email, gpa (0-4.0), and units taken (0-150): I created a
 *   student class with the specified requirements. In the class I defined the constructor and added data validation
 *   for gpa and units taken. I may be able to add more for name, redID, and email if time allows. The class also
 *   includes methods the calculates and returns a student's priority value. It also has a method for what to print out
 *   to console if requested.
 *
 *   * Design the priority queue operations to work seamlessly with the student class: This is enabled by the
 *   implementation of the priority queue class to use generics instead of a single data type. Creating another
 *   priority class, StudentPriorityQueue, that extends MyPriorityQueue, but with the data type specified as Student
 *   objects. The key part of having the Student class work seamlessly with the priority queue class is the override
 *   implementation of the compareTwo function which is used in the raise and sink operations.
 *
 *   3. Testing Practices: TBC
 *
 *   4. Code Quality: Judged by professor
 *
 *   5. Priority Calculation for Students:
 *      (gpa * 0.3 + unitsTaken * 0.70)
 *      Implemented in both student class and priority queue
 *
 *    6. Printing in priority order: Printing in priority order was a challenge to figure out a way without cloning
 *    the whole priority queue. My implementation requires the creation of a new priority queue object that will be
 *    filled up as elements from the original queue are retrieved for printing, adding the data to a new element in
 *    the new queue, and then removing root from the original queue to get the next priority item moved to the root.
 *    The print methods also exhibits the use of polymorphism with the overriding of the print method.
 *
 *    7. Custom Priority Queue Implementation: Will be judged by professor, but I did my best to use appropriate data
 *    structures and efficient algorithms.
 *
 *
 *
 *
 */

package mypriorityqueue;

import java.util.ArrayList;

// Declaration of PriorityQueue class that is implemented using MaxBinaryHeap using ArrayList
// I incorporate the use of generics here to allow StudentPriorityClass to promote inheritance as well as
// reusability and extensibility.
public class MyPriorityQueue<T extends Comparable<? super T>> {
    // Declare a ArrayList object, students
    // My decision to use an ArrayList for a priority queue in Java because it handles resizing the size of the
    // array dynamically.
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

    // This method removes the root by swapping the root with last element at end of queue then applying sink method
    // on root node.
    public void removeRoot() {
        queueObject.set(0, queueObject.getLast());
        queueObject.removeLast();
        sink();
    }

    // Returns the highest priority element located at root.
    public T getRoot() {
        return queueObject.getFirst();
    }

    // Method to print all Student object entries contained in the heap
    // Makes a copy of heap node by node as each element is printed.
    // Add root element to temp queue, print element, then remove root to get next priority element.
    // Repeat until queue is empty then assign queueObject, temp.
    public void printQueuePriorities() {
        MyPriorityQueue<T> temp = new MyPriorityQueue<>();
        T root;
        while (!queueObject.isEmpty()) {
            root = queueObject.getFirst();
            temp.insertObject(root);
            printOutput(root);
            removeRoot();
        }
        System.out.println();
        queueObject = temp.queueObject;
    }

    // Declared this method to allow other classes to override the function and promote polymorphism.
    // Function is used in printQueuePriorities method.
    public void printOutput(T object) {
        System.out.println(object);
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

    // This method is to raise a new element added to the end of the tree to reach its correct position in the
    // priority queue.
    public void raise() {
        int arrayIndex = queueObject.size() - 1;
        while (arrayIndex > 0
                && (queueObject.get(getParentIndex(arrayIndex)).compareTo(queueObject.get(arrayIndex))) < 0) {
            swap(getParentIndex(arrayIndex), arrayIndex);
            arrayIndex = getParentIndex(arrayIndex);
        }
    }

    // Method to sink an entry to it's correct place in the heap. This method is used when removing the highest priority
    // entry from root. By swapping the highest priority entry with the last entry in the heap, removing the last entry which
    // was the highest priority entry, then using this sink method on the entry now located at the root of the heap it
    // ensures that the heap retains the heap property where the child nodes will always have a lower priority than
    // the parent nodes.
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
                    && queueObject.get(highPriorityChildIndex).compareTo(queueObject.get(index)) >= 0) {
                swap(highPriorityChildIndex, index);
                index = highPriorityChildIndex;
            } else {
                break;
            }
        }
    }
}
