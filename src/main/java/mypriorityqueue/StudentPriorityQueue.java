/*
* Quy Nguyen
* CS635
* Lab01 - Priority Queue
* 9/9/24
* StudentPriorityQueue.java
*/

package mypriorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

// Definition of StudentPriorityQueue that extends/inherits the properties MyPriorityQueue class
// We specify that we will be using Student objects instead of generic T
public class StudentPriorityQueue extends PriorityQueue<Student> {


    QueueCommandInvoker cmdInvoker = new QueueCommandInvoker();

    StudentPriorityQueue() {
    }

    StudentPriorityQueue(Comparator<Student> comparator) {
        super(comparator);
    }

    public Student insert(Student student) {
        QueueCommand addElementCommand = new AddElementCommand(this, student);
        return cmdInvoker.execute(addElementCommand);
    }


    public Student remove() {
        QueueCommand removeElementCommand = new RemoveElementCommand(this);
        return cmdInvoker.execute(removeElementCommand);
    }

    public Student getHead() {
        QueueCommand peekElementCommand = new PeekElementCommand(this);
        return cmdInvoker.execute(peekElementCommand);
    }
}
