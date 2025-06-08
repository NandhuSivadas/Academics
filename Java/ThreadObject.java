import java.util.*;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person implements Runnable {
    String course;
    int mark;

    public Student(String name, int age, String course, int mark) {
        super(name, age);
        this.course = course;
        this.mark = mark;
    }

    public void run() {
     
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Course: " + course);
        System.out.println("Mark  : " + mark);
        System.out.println();
        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Factorial implements Runnable {
    int num = 36;

    public void run() {
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.println("\t\t\t\tFactor: " + i);
            }
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadObject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

       
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Enter details for Student " + (i + 1) + " ---");
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Course: ");
            String course = sc.nextLine();

            System.out.print("Mark: ");
            int mark = sc.nextInt();
            sc.nextLine();

            students[i] = new Student(name, age, course, mark);
        }

      
        Factorial f = new Factorial();
        Thread t2 = new Thread(f);
        t2.start();

       
        for (Student s : students) {
            Thread t1 = new Thread(s);
            t1.start();
        }
    }
}
