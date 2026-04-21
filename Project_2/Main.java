<<<<<<< HEAD
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Platform p = new Platform();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Add Instructor");
            System.out.println("3. Create Course");
            System.out.println("4. Show Courses");
            System.out.println("5. Enroll Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1: p.addStudent(); break;
                case 2: p.addInstructor(); break;
                case 3: p.createCourse(); break;
                case 4: p.showCourses(); break;
                case 5: p.enrollStudent(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
=======
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Platform p = new Platform();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Add Instructor");
            System.out.println("3. Create Course");
            System.out.println("4. Show Courses");
            System.out.println("5. Enroll Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1: p.addStudent(); break;
                case 2: p.addInstructor(); break;
                case 3: p.createCourse(); break;
                case 4: p.showCourses(); break;
                case 5: p.enrollStudent(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
>>>>>>> dbd05ca (Till Day12)
}