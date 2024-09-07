package mypriorityqueue;

public class Main {
    public static void main(String[] args) {


        Student hanna = new Student("hanna", 123, "hanna@sdsu.edu", 3.3F, 120);
        Student adam = new Student("adam", 124, "adam@sdsu.edu", 3.4F, 120);
        Student bob = new Student("bob", 123, "bob@sdsu.edu", 3.3F, 121);
        Student chris = new Student("chris", 123, "chris@sdsu.edu", 3.2F, 120);

        MyPriorityQueue<Integer> studentList;
        studentList = new MyPriorityQueue<>();
        StudentPriorityQueue studentList2;
        studentList2 = new StudentPriorityQueue();

        studentList.insertObject(2);
        studentList.insertObject(3);
        studentList.insertObject(1);
        studentList.insertObject(5);
        studentList.printQueueElements();

        studentList2.insertObject(hanna);
        studentList2.insertObject(adam);
        studentList2.insertObject(bob);
        studentList2.insertObject(chris);
        studentList2.printQueueElements();

    }
}