import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

interface Showable {
    void show();
}

class Person {
    String name, gender;
    double phone;

    public Person(String name, String gender, double phone) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }
}

class Student extends Person {
    String course;
    double score;

    public Student(String course, double score, String name, String gender, double phone) {
        super(name, gender, phone);
        this.course = course;
        this.score = score;
    }
}

class PGStudents extends Student implements Showable {
    String researchArea, guide;

    public PGStudents(String researchArea, String guide, String course, double score, String name, String gender, double phone) {
        super(course, score, name, gender, phone);
        this.researchArea = researchArea;
        this.guide = guide;
    }

    public void show() {
        System.out.println("\nPG Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Phone: " + phone);
        System.out.println("Course: " + course);
        System.out.println("Score: " + score);
        System.out.println("Research Area: " + researchArea);
        System.out.println("Guide: " + guide);
    }
}

class PGStudentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of persons:");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        PGStudents[] p = new PGStudents[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter gender: ");
            String gender = sc.nextLine();
            System.out.print("Enter phone: ");
            double phone = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter course: ");
            String course = sc.nextLine();
            System.out.print("Enter score: ");
            double score = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter research area: ");
            String researchArea = sc.nextLine();
            System.out.print("Enter guide: ");
            String guide = sc.nextLine();

            p[i] = new PGStudents(researchArea, guide, course, score, name, gender, phone);
        }

        // Sorting students by researchArea (Alphabetical Order)
        Arrays.sort(p, Comparator.comparing(student -> student.researchArea));

        System.out.println("\nDisplaying PG Student Details (Sorted by Research Area):");
        for (PGStudents student : p) {
            student.show();
        }
         

          // Sorting students by Score (Descending Order)
        Arrays.sort(p, Comparator.comparingDouble(student -> -student.score));

        System.out.println("\nDisplaying PG Student Details (Sorted by Score - Descending Order):");
        for (PGStudents student : p) {
            student.show();
        }
        sc.close();
    }
}
