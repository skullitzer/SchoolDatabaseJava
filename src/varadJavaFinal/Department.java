package varadJavaFinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Department {
    private String id;
    private String title;
    private String discipline;
    private short numberOfHours;
    private byte numberOfGroups;
    private List<String> prerequisites;
    private HashMap<String, Courses> courseMap;

    public Department(String id, String title, String discipline, short numberOfHours, byte numberOfGroups, List<String> prerequisites) {
        this.id = id;
        this.title = title;
        this.discipline = discipline;
        this.numberOfHours = numberOfHours;
        this.numberOfGroups = numberOfGroups;
        this.prerequisites = prerequisites;
        this.courseMap = new HashMap<String, Courses>();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDiscipline() {
        return discipline;
    }

    public short getNumberOfHours() {
        return numberOfHours;
    }

    public byte getNumberOfGroups() {
        return numberOfGroups;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public void addCourse(Courses course) {
        courseMap.put(course.getId(), course);
    }

    public boolean registerCourse(Student student, String courseId) {
        if (courseMap.containsKey(courseId)) {
            Courses course = courseMap.get(courseId);
            List<String> coursePrerequisites = course.getPrerequisites();
            List<String> prevCourses = student.getTranscript().getPrevCourses();
            if (prevCourses.containsAll(coursePrerequisites)) {
                student.getTranscript().addCourse(courseId);
                return true;
            } else {
                System.out.println("Registration failed. Student " + student.getName() + " does not have the required prerequisites to take course " + courseId);
                System.out.println("PrevCourses: " + prevCourses.toString());
                System.out.println("Prerequisites: " + coursePrerequisites.toString());
                return false;
            }
        } else {
            System.out.println("Registration failed. Course " + courseId + " not found in department " + this.title);
            return false;
        }
    }
}
