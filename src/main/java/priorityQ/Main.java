package priorityQ;

public class Main {
    public static void main(String[] args) {

        PriorityQueue studentList = new PriorityQueue();
        Student hanna = new Student("hanna", 123, "hanna@sdsu.edu", 3.3F, 120);
        Student adam = new Student("adam", 124, "adam@sdsu.edu", 3.4F, 120);
        Student bob = new Student("bob", 123, "bob@sdsu.edu", 3.3F, 121);
        Student chris = new Student("chris", 123, "chris@sdsu.edu", 3.2F, 120);
        System.out.println(hanna.name + "'s priority is " + hanna.priority);
        float priority_one = hanna.getPriority();
        System.out.println("another priority is " + priority_one);
        hanna.printStudent();


        studentList.insertRecord(hanna);
        Student topPriority = studentList.getTopPriority();
        System.out.println("top priority is " + topPriority);
        studentList.insertRecord(adam);
        studentList.printTopPriority();
        System.out.println("top priority is " + topPriority);
        studentList.insertRecord(bob);
        studentList.printTopPriority();
        System.out.println("top priority is " + topPriority);
        studentList.insertRecord(chris);
        studentList.printTopPriority();
        System.out.println("top priority is " + topPriority);


        studentList.printStudentPriorities();


    }
}