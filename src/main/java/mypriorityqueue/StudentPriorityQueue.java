/*
 * Quy Nguyen
 * CS635
 * M3 - Priority Queue (continued)
 * 10/7/2024
 * StudentPriorityQueue.java
 */

package mypriorityqueue;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

// Definition of StudentPriorityQueue that extends/inherits the properties MyPriorityQueue class
// We specify that we will be using Student objects instead of generic T
public class StudentPriorityQueue extends PriorityQueue<Student> {
    CommandInvoker cmdInvoker = new CommandInvoker();

    StudentPriorityQueue() {
        super();
    }

    StudentPriorityQueue(Comparator<Student> comparator) {
        super(comparator);
    }

    public boolean insert(Student student) {
        Command addElementCommand = new AddElementCommand(this, student);
        cmdInvoker.execute(addElementCommand);
        return true;
    }


    public Student delete(Student student) {
        Command removeElementCommand = new RemoveElementCommand(this, student);
        return cmdInvoker.execute(removeElementCommand);
    }

    public Student deleteHead() {
        Command removeHeadCommand = new RemoveHeadCommand(this);
        return cmdInvoker.execute(removeHeadCommand);
    }

    public Student getHead() {
        Command peekElementCommand = new PeekElementCommand(this);
        return cmdInvoker.execute(peekElementCommand);
    }


    @Override
    public @NotNull Iterator<Student> iterator() {
        return new StudentPriorityQueueIterator();
    }

    private class StudentPriorityQueueIterator implements Iterator<Student> {
        private final PriorityQueue<Student> tempQueue;

        StudentPriorityQueueIterator() {
            tempQueue = new PriorityQueue<>(StudentPriorityQueue.this);
        }

        @Override
        public boolean hasNext() {
            return !tempQueue.isEmpty();
        }

        @Override
        public Student next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return tempQueue.poll();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
