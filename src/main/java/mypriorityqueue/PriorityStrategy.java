package mypriorityqueue;

import java.util.Comparator;

public interface PriorityStrategy<T>{
    Comparator<T> getComparator();
}


