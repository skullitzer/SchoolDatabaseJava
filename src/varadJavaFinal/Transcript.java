package varadJavaFinal;

/**a. For the prevCourses attribute we can use a map, where the keys are
 * courseIds and the values are grades. This data structure allows for efficient lookups and
 * allows for easy association between courseIds and grades.**/

import java.util.ArrayList;
import java.util.List;

public class Transcript {
    private List<String> prevCourses;

    public Transcript() {
        this.prevCourses = new ArrayList<String>();
    }

    public void addCourse(String courseId) {
        prevCourses.add(courseId);
    }

    public void addCourse(String courseId, int grade) {
        prevCourses.add(courseId + " (Grade: " + grade + ")");
    }

    public void displayPrevCourses() {
        System.out.println("Courses taken:");
        for (String courseId : prevCourses) {
            System.out.println(courseId);
        }
    }
}