package varadJavaFinal;

import java.util.ArrayList;
import java.util.List;

/**a. Since we can see that a Student object contains a Transcript object as a field we can say that
 * the Student and Transcript classes have a composition relationship. We can also see that
 * Transcript object cannot exist independently and Student object is composed of the Transcript
 * object.
**/

public class Student {
    private String id;
    private String name;
    private Transcript transcript;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.transcript = new Transcript();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void addPrevCourse(String courseId, String grade) {
        transcript.addPrevCourse(courseId, grade);
    }

    public void editPrevCourse(String courseId, String newGrade) {
        transcript.editPrevCourse(courseId, newGrade);
    }

    public List<String> getPrevCourses() {
        return transcript.getPrevCourses();
    }

    public void addCourse(String courseId) {
        transcript.addCourse(courseId);
    }

    public class Transcript {
        private List<String> prevCourses;

        public Transcript() {
            this.prevCourses = new ArrayList<>();
        }

        public void addPrevCourse(String courseId, String grade) {
            prevCourses.add(courseId + " (Grade: " + grade + ")");
        }

        public void editPrevCourse(String courseId, String newGrade) {
            for (int i = 0; i < prevCourses.size(); i++) {
                String course = prevCourses.get(i);
                if (course.startsWith(courseId)) {
                    prevCourses.set(i, courseId + " (Grade: " + newGrade + ")");
                    break;
                }
            }
        }

        public List<String> getPrevCourses() {
            return prevCourses;
        }

        public void addCourse(String courseId) {
            prevCourses.add(courseId);
        }
        
        
    }
}
