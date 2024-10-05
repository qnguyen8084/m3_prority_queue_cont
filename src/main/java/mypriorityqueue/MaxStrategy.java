package mypriorityqueue;

import java.util.Comparator;

public class MaxStrategy implements PriorityStrategy<Student> {
    @Override
    public Comparator<Student> getComparator() {
        return Comparator.reverseOrder();
    }
}