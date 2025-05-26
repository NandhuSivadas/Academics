import java.util.*;

interface showable {
    void show();
}

class Person {
    String name, gender;
    int phno;

    public Person(String name, String gender, int phno) {
        this.name = name;
        this.gender = gender;
        this.phno = phno;
    }
}

class Student extends Person {
    String course;
    int score;

    public Student(String course, int score, String name, String gender, int phno) {
        super(name, gender, phno);
        this.course = course;
        this.score = score;
    }
}

class PGstudent extends Student implements showable {
    String researchArea, guide;

    public PGstudent(String researchArea, String guide, String course, int score, String name, String gender, int phno) {
        super(course, score, name, gender, phno);
        this.researchArea = researchArea;
        this.guide = guide;
    }

    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Phone Number: " + phno);
        System.out.println("Course: " + course);
        System.out.println("Score: " + score);
        System.out.println("Research Area: " + researchArea);
        System.out.println("Guide: " + guide);
        System.out.println("-----");
    }
}


class ShowStudentThread extends Thread {
    PGstudent[] students;

    public ShowStudentThread(PGstudent[] students) {
        this.students = students;
    }

    public void run() {
        System.out.println("\n--- PG Student Details ---");
        for (PGstudent student : students) {
            student.show();
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                System.out.println("Display thread interrupted");
            }
        }
    }
}

class MultiplicationThread extends Thread {
    public void run() {
        System.out.println("\n\t\t\t\t--- Multiplication Table of 5 ---");
        for (int i = 1; i <= 10; i++) {
            System.out.println("\t\t\t\t5 x " + i + " = " + (5 * i));
            try {
                Thread.sleep(300); // pause for effect
            } catch (InterruptedException e) {
                System.out.println("Multiplication thread interrupted");
            }
        }
    }
}

public class PGstudentDetailsMulti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of PG students: ");
        int n = sc.nextInt();
        sc.nextLine();

        PGstudent[] students = new PGstudent[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Gender: ");
            String gender = sc.nextLine();

            System.out.print("Phone number: ");
            int phno = sc.nextInt();
            sc.nextLine();

            System.out.print("Course: ");
            String course = sc.nextLine();

            System.out.print("Score: ");
            int score = sc.nextInt();
            sc.nextLine();

            System.out.print("Research Area: ");
            String researchArea = sc.nextLine();

            System.out.print("Guide: ");
            String guide = sc.nextLine();

            students[i] = new PGstudent(researchArea, guide, course, score, name, gender, phno);
        }

        // Create threads
        ShowStudentThread studentThread = new ShowStudentThread(students);
        MultiplicationThread multiplicationThread = new MultiplicationThread();

        // Start threads
        studentThread.start();
        multiplicationThread.start();
    }
}
