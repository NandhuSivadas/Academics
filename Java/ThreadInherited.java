import java.util.*;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {
    String course;
    int marks;

    public Student(String name, int age, String course, int marks) {
        super(name, age);
        this.course = course;
        this.marks = marks;
    }
}

// Thread to print factors of 36
class Fact extends Thread {
    public void run() {
        int num = 36;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                System.out.println("\t\t\tfactor: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class Inherited extends Thread {
    Student[] s;

    public Inherited(Student[] s) {
        this.s = s;
    }

    public void run() {
        for (int i = 0; i < s.length; i++) {
            System.out.println("Student Name: " + s[i].name);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadInherited {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Student[] s = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Course: ");
            String course = sc.nextLine();

            System.out.print("Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            s[i] = new Student(name, age, course, marks);
        }

        // Create and start threads
        Inherited iThread = new Inherited(s);
        Fact fThread = new Fact();

        iThread.start();
        fThread.start();

        try {
            iThread.join();
            fThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
