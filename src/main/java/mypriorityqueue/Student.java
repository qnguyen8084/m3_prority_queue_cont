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

    // Constructor for Student class
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

    // Method to return value for priority when called.
    public float getPriority() {
        return calculatePriority();
    }

    // Method to print a name and redID of Student object.
    void printStudent() {
        System.out.println("Name: " + this.name + " redID: " + this.redID + " priority: " + this.getPriority());
    }

    public int compareTo(Student s) {
        float priority = this.gpa * 0.3F + this.unitsTaken * 0.7F;
        return Float.compare(priority, s.getPriority());
    }
}
