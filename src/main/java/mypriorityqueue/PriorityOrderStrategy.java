package mypriorityqueue;

import java.util.Comparator;

public class PriorityOrderStrategy {
    private PriorityStrategy<Student> priorityStrategy;

    public PriorityOrderStrategy(PriorityStrategy<Student> priorityStrategy) {
        this.priorityStrategy = priorityStrategy;
    }

    public void setPriorityOrder(PriorityStrategy<Student> priorityStrategy) { this.priorityStrategy = priorityStrategy; }

    public Comparator<Student> applyPriority() {
        return priorityStrategy.getComparator();
    }
}
