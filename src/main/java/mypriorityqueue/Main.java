package mypriorityqueue;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to MyPriorityQueue implementation");
        PriorityStrategy max = new MaxStrategy();
        StudentPriorityQueue studentPriorityQ = new StudentPriorityQueue();

        Student hanna = new Student("hanna", 123, "hanna@sdsu.edu", 3.3F, 120);
        Student jesse = new Student("jesse", 1234, "hanna@sdsu.edu", 3.3F, 120);
        Student adam = new Student("adam", 124, "adam@sdsu.edu", 3.4F, 120);
        Student bob = new Student("bob", 123, "bob@sdsu.edu", 3.3F, 121);
        Student chris = new Student("chris", 123, "chris@sdsu.edu", 3.2F, 120);
        studentPriorityQ.offer(hanna);
        studentPriorityQ.offer(jesse);
        studentPriorityQ.offer(adam);
        studentPriorityQ.offer(bob);
        studentPriorityQ.offer(chris);

        studentPriorityQ.poll().printStudent();
        studentPriorityQ.poll().printStudent();
        studentPriorityQ.poll().printStudent();
        studentPriorityQ.poll().printStudent();
        studentPriorityQ.poll().printStudent();


    }
}