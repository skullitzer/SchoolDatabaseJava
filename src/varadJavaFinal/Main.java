package varadJavaFinal;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // create some courses
        Courses cs101 = new Courses("CS101", "Introduction to Computer Science", "Computer Science", (short) 45, (byte) 3, new ArrayList<String>());
        Courses cs201 = new Courses("CS201", "Data Structures and Algorithms", "Computer Science", (short) 60, (byte) 4, new ArrayList<String>());
        Courses math101 = new Courses("MATH101", "Calculus I", "Mathematics", (short) 45, (byte) 3, new ArrayList<String>());

        // create a department
        Department csDept = new Department("CS", "Computer Science", "School of Computer Science", (short) 300, (byte) 10, new ArrayList<String>());
        csDept.addCourse(cs101);
        csDept.addCourse(cs201);

        // create a student
        Student alice = new Student("1", "Alice");
        alice.addPrevCourse(cs101.getId(), "A");
        alice.addPrevCourse(math101.getId(), "B+");

        // register the student for a course
        boolean isRegistered = csDept.registerCourse(alice, cs201.getId());
        if (isRegistered) {
            System.out.println("Registration successful!");
        }

        // display the student's previous courses and transcript
        System.out.println("Previous courses:");
        for (String course : alice.getPrevCourses()) {
            System.out.println(course);
        }

        System.out.println("Transcript:");
        alice.getTranscript();
        
    }
    public static void displayTranscript(Student student) {
        System.out.println("Transcript for " + student.getName() + ":");
        List<String> prevCourses = student.getPrevCourses();
        if (prevCourses.isEmpty()) {
            System.out.println("No courses taken.");
        } else {
            student.getTranscript().getPrevCourses();
        }
        System.out.println();
    }


}
