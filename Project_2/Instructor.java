import java.util.*;

class Instructor extends User {
    private List<Course> createdCourses = new ArrayList<>();

    public Instructor(int id, String name) {
        super(id, name);
    }

    public void createCourse(Course c) {
        createdCourses.add(c);
        System.out.println("Course created: " + c.getTitle());
    }

    @Override
    public void displayRole() {
        System.out.println("Instructor");
    }
}