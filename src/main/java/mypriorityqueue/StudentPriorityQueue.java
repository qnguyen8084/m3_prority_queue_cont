/*
* Quy Nguyen
* CS635
* Lab01 - Priority Queue
* 9/9/24
* StudentPriorityQueue.java
*/

package mypriorityqueue;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.PriorityQueue;

// Definition of StudentPriorityQueue that extends/inherits the properties MyPriorityQueue class
// We specify that we will be using Student objects instead of generic T
public class StudentPriorityQueue extends PriorityQueue<Student> {

    StudentPriorityQueue() {
    }

    StudentPriorityQueue(Comparator<Student> comparator) {
        super(comparator);
    }

}
