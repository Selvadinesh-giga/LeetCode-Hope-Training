<<<<<<< HEAD
import java.util.*;

class Platform {
    private List<Student> students = new ArrayList<>();
    private List<Instructor> instructors = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter student id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        students.add(new Student(id, name));
    }

    public void addInstructor() {
        System.out.print("Enter instructor id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        instructors.add(new Instructor(id, name));
    }

    public void createCourse() {
        if (instructors.isEmpty()) {
            System.out.println("No instructors available");
            return;
        }

        System.out.print("Enter course id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter course title: ");
        String title = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        Course c = new Course(id, title, price);

        System.out.print("How many lessons? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter lesson " + (i + 1) + ": ");
            String content = sc.nextLine();
            c.addLesson(new Lesson(content));
        }

        courses.add(c);
        instructors.get(0).createCourse(c); // simple assign
    }

    public void showCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available");
            return;
        }

        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + ": " + courses.get(i).getTitle());
        }
    }

    public void enrollStudent() {
        if (students.isEmpty() || courses.isEmpty()) {
            System.out.println("Students or courses missing");
            return;
        }

        Student s = students.get(0);

        showCourses();
        System.out.print("Choose course index: ");
        int index = sc.nextInt();

        s.enrollCourse(courses.get(index));
    }
=======
import java.util.*;

class Platform {
    private List<Student> students = new ArrayList<>();
    private List<Instructor> instructors = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter student id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        students.add(new Student(id, name));
    }

    public void addInstructor() {
        System.out.print("Enter instructor id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        instructors.add(new Instructor(id, name));
    }

    public void createCourse() {
        if (instructors.isEmpty()) {
            System.out.println("No instructors available");
            return;
        }

        System.out.print("Enter course id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter course title: ");
        String title = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        Course c = new Course(id, title, price);

        System.out.print("How many lessons? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter lesson " + (i + 1) + ": ");
            String content = sc.nextLine();
            c.addLesson(new Lesson(content));
        }

        courses.add(c);
        instructors.get(0).createCourse(c); // simple assign
    }

    public void showCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available");
            return;
        }

        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + ": " + courses.get(i).getTitle());
        }
    }

    public void enrollStudent() {
        if (students.isEmpty() || courses.isEmpty()) {
            System.out.println("Students or courses missing");
            return;
        }

        Student s = students.get(0);

        showCourses();
        System.out.print("Choose course index: ");
        int index = sc.nextInt();

        s.enrollCourse(courses.get(index));
    }
>>>>>>> dbd05ca (Till Day12)
}