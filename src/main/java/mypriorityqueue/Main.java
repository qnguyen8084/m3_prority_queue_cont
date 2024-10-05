package mypriorityqueue;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to MyPriorityQueue implementation");
        PriorityOrderStrategy priorityOrder = new PriorityOrderStrategy(new MinStrategy());
        StudentPriorityQueue studentPriorityQ = new StudentPriorityQueue(priorityOrder.applyPriority());
        priorityOrder.setPriorityOrder(new MaxStrategy());
        StudentPriorityQueue studentPriorityQ2 = new StudentPriorityQueue(priorityOrder.applyPriority());

        Student hanna = new Student("hanna", 123, "hanna@sdsu.edu", 3.3F, 120);
        Student jesse = new Student("jesse", 1234, "hanna@sdsu.edu", 3.3F, 120);
        Student adam = new Student("adam", 124, "adam@sdsu.edu", 3.4F, 120);
        Student bob = new Student("bob", 123, "bob@sdsu.edu", 3.3F, 121);
        Student chris = new Student("chris", 123, "chris@sdsu.edu", 3.2F, 120);

        Student[] studentList = {hanna, jesse, adam, bob, chris};

        for (Student student: studentList) {
            Student result = studentPriorityQ.insert(student);
            System.out.println("Inserted: " + result);
        }

        for (Student student: studentList) {
            Student result = studentPriorityQ.remove();
            System.out.println("Removed: " + result);
        }


        for (Student student: studentList) {
            Student result = studentPriorityQ.insert(student);
            System.out.println("Inserted: " + result);
        }
        for (Student student: studentList) {
            Student result = studentPriorityQ.remove();
            System.out.println("Removed: " + result);
        }
    }

}

