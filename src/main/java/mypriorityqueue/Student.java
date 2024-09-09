/*
 * Quy Nguyen
 * CS635
 * Lab01 - Priority Queue
 * 9/9/24
 * Student.java
 */

package mypriorityqueue;

// Declaration of Student class
// This class will be used to work seamlessly with MyPriorityQueue class.
// We also add implements Comparable so that we can override compareTo which is the key
// addition that allows seamless integration with our priority queue implementation.
public class Student implements Comparable<Student> {
    /* Instance variables for Student class
    identifier: name    data-type: String
    identifier: redID   data-type: int
    identifier: email   data-type: String
    identifier: gpa     data-type: unitsTaken
    identifier: priority data-type: float
    */
    private final String name;
    private final int redID;
    private final String email;
    private final float gpa;
    private final int unitsTaken;

    // Constructor for Student class
    // Assigns data to members and also checks for ranges of gpa and unitsTaken.
    // TODO: May be a lot of improvements here
    // TODO: Add getters, no setters needed
    // TODO: Encapsulate data members
    // TODO: Add more data validation
    public Student(String name, int redID, String email, float gpa, int unitsTaken) {
        // Assigns input parameters to respective variables for when Student object is instantiated.
        this.name = name;
        this.redID = redID;
        this.email = email;
        this.gpa = gpa;
        if (this.gpa < 0F || this.gpa > 4.0F) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("GPA must not be smaller than 0 and no greater than 4.0.");
                throw new RuntimeException(e);
            }
        }
        this.unitsTaken = unitsTaken;
        if (this.unitsTaken < 0 || this.unitsTaken > 150) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Units Taken must not be smaller than 0 and no greater than 150.");
                throw new RuntimeException(e);
            }
        }
    }

    // Method definition to calculatePriority from gpa and unitsTaken.
    // Assignment requirements define priority as the sum of 30% of GPA and 70% of unitsTaken.
    public float calculatePriority() {
        return this.gpa * 0.3F + this.unitsTaken * 0.7F;
    }

    // Add getter for gpa to allow StudentPriorityQueue to calculate priority
    public float getGpa() {
        return this.gpa;
    }

    // Add getter for unitsTaken to allow StudentPriorityQueue to calculate priority
    public int getUnitsTaken() {
        return unitsTaken;
    }

    // Method to return value for priority when called.
    public float getPriority() {
        return calculatePriority();
    }

    // Method to print a name and redID of Student object.
    // Used for printing out students in priority order or just a single entry.
    // TODO: could use some better formatting
    void printStudent() {
        System.out.println("Name: " + this.name + " redID: " + this.redID + " priority: " + this.getPriority());
    }

    // This is the key component to have our implementation of Student class to work with our implementation of
    // priority queue. Exhibits polymorphism.
    @Override
    public int compareTo(Student s) {
        float priority = this.gpa * 0.3F + this.unitsTaken * 0.7F;
        return Float.compare(priority, s.getPriority());
    }
}
