package varadJavaFinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**a. The set data structure seems to be the way to go in this case,
 * as looking up course IDs and inserting more course IDs will be easier
 * this way. It will also help us to be sure about every course ID being
 * unique. Also don't forget that the access modifier needs to be private
 * because we want to only be able to modify the prerequisites using the
 * addPrerequisite() and deletePrerequisite() methods. If we want to modify
 * the prerequisites from outside the class, the getter and setter is needed.**/

public class Courses {
    private String id;
    private String title;
    private String discipline;
    private short numberOfHours;
    private byte numberOfGroups;
    private List<String> prerequisites;

    public Courses(String id, String title, String discipline, short numberOfHours, byte numberOfGroups, List<String> prerequisites) {
        this.id = id;
        this.title = title;
        this.discipline = discipline;
        this.numberOfHours = numberOfHours;
        this.numberOfGroups = numberOfGroups;
        this.prerequisites = prerequisites;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public short getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(short numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public byte getNumberOfGroups() {
    	return numberOfGroups;
    }

    public void setNumberOfGroups(byte numberOfGroups) {
        this.numberOfGroups = numberOfGroups;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public void addPrerequisite(String courseId) {
        prerequisites.add(courseId);
    }

    public void deletePrerequisite(String courseId) {
        prerequisites.remove(courseId);
    }

    public void displayPrerequisites() {
        if (prerequisites.isEmpty()) {
            System.out.println("No prerequisites");
        } else {
            System.out.println("Prerequisites:");
            for (String courseId : prerequisites) {
                System.out.println(courseId);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course [id=").append(id)
                .append(", title=").append(title)
                .append(", discipline=").append(discipline)
                .append(", numberOfHours=").append(numberOfHours)
                .append(", numberOfGroups=").append(numberOfGroups);
        if (!prerequisites.isEmpty()) {
            sb.append(", prerequisites=").append(prerequisites);
        }
        sb.append("]");
        return sb.toString();
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        File courseFile = new File("C:\\Users\\VARAD\\source\\Java\\Java_Final\\src\\varadJavaFinal\\courses_f22.txt");
        try {
            Scanner sc = new Scanner(courseFile);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] courseEntry = data.split(":");
                String id = courseEntry[0].trim();
                String title = courseEntry[1].trim();
                String discipline = courseEntry[2].trim();
                short numberOfHours = Short.parseShort(courseEntry[3].trim());
                byte numberOfGroups = 0;
                String numberOfGroupsStr = courseEntry[4].trim();
                if (!numberOfGroupsStr.equals("none")) {
                    try {
                        numberOfGroups = Byte.parseByte(numberOfGroupsStr);
                    } catch (NumberFormatException e) {
                     
                    }
                }
                List<String> prerequisites = new ArrayList<>();
                if (courseEntry.length == 6) {
                    String[] prerequisiteIds = courseEntry[5].trim().split(",");
                    for (String prerequisiteId : prerequisiteIds) {
                        prerequisites.add(prerequisiteId.trim());
                    }
                }
                Courses c1 = new Courses(id,title, discipline, numberOfHours, numberOfGroups, prerequisites);
                System.out.println(c1);
            }
            sc.close();
            } catch (FileNotFoundException e) {
            System.out.println("Cannot find file");
            e.printStackTrace();
            }
         }
}