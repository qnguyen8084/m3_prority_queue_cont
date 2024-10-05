package mypriorityqueue;

import java.util.Comparator;

public class MinStrategy implements PriorityStrategy<Student> {
    @Override
    public Comparator<Student> getComparator() {
        return Comparator.naturalOrder();
    }
}
