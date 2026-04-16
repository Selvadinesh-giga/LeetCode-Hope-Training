import java.util.*;

public class Course {
    private int id;
    private String title;
    private double price;
    private List<Lesson> lessons = new ArrayList<>();

    public Course(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }
}
