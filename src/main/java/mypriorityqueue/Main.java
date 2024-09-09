package mypriorityqueue;

import java.lang.Math;

public class Main {
    public static void main(String[] args) {

        Student hanna = new Student("hanna", 123, "hanna@sdsu.edu", 3.3F, 120);
        Student jesse = new Student("jesse", 1234, "hanna@sdsu.edu", 3.3F, 120);
        Student adam = new Student("adam", 124, "adam@sdsu.edu", 3.4F, 120);
        Student bob = new Student("bob", 123, "bob@sdsu.edu", 3.3F, 121);
        Student chris = new Student("chris", 123, "chris@sdsu.edu", 3.2F, 120);

        MyPriorityQueue<Integer> studentList;
        studentList = new MyPriorityQueue<>();
        StudentPriorityQueue studentList2;
        studentList2 = new StudentPriorityQueue();
        int input;
        for (int i = 0; i < 5; i++) {
            //input = (int)(Math.random()*100)+1;
            //studentList.insertObject(input);
            studentList.insertObject(i);
        }

        studentList.insertObject(2);
        studentList.insertObject(3);
        studentList.insertObject(1);
        studentList.insertObject(5);
        studentList.printQueuePriorities();

        studentList2.insertObject(adam);
        studentList2.insertObject(bob);
        studentList2.insertObject(chris);
        studentList2.insertObject(hanna);
        studentList2.insertObject(jesse);

        studentList2.printQueuePriorities();

    }
}