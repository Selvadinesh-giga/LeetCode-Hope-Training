import java.util.*;

class Student extends User {
    private List<Course> enrolledCourses = new ArrayList<>();

    public Student(int id, String name) {
        super(id, name);
    }

    public void enrollCourse(Course c) {
        enrolledCourses.add(c);
        System.out.println(getName() + " enrolled in " + c.getTitle());
    }

    public void viewCourses() {
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled");
            return;
        }
        for (Course c : enrolledCourses) {
            System.out.println(c.getTitle());
        }
    }

    @Override
    public void displayRole() {
        System.out.println("Student");
    }
}