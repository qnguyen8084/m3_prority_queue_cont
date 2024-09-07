package mypriorityqueue;

// Declaration of Student class
public class Student implements Comparable<Student> {
    /* Instance variables for Student class
    identifier: name    data-type: String
    identifier: redID   data-type: int
    identifier: email   data-type: String
    identifier: gpa     data-type: unitsTaken
    identifier: priority data-type: float
    */
    String name;
    int redID;
    String email;
    float gpa;
    int unitsTaken;
    float priority;

    // Constructor for Student class
    public Student(String name, int redID, String email, float gpa, int unitsTaken) {
        // Assigns input parameters to respective variables for when Student object is instantiated.
        this.name = name;
        this.redID = redID;
        this.email = email;
        this.gpa = gpa;
        this.unitsTaken = unitsTaken;
        // Calls the calculatePriority method to assign the value for priority of Student object.
        this.priority = calculatePriority(this.gpa, this.unitsTaken);
    }

    // Method definition to calculatePriority from gpa and unitsTaken.
    // Assignment requirements define priority as the sum of 30% of GPA and 70% of unitsTaken.
    public float calculatePriority(float gpa, int unitsTaken) {
        return gpa * 0.3F + unitsTaken * 0.7F;
    }

    // Method to return value for priority when called.
    public float getPriority() {
        return this.priority;
    }

    // Method to print a name and redID of Student object.
    void printStudent() {
        System.out.println("Name: " + this.name + " redID: " + this.redID + " priority: " + this.priority);
    }

    public int compareTo(Student s) {
        return Float.compare(this.priority, s.priority);
    }
}
