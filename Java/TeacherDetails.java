import java.util.*;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Employee extends Person {
    int emp_id, salary;
    String comp_name, qualification;

    public Employee(int emp_id, int salary, String comp_name, String qualification, String name, int age) {
        super(name, age);  
        this.emp_id = emp_id;
        this.salary = salary;
        this.comp_name = comp_name;
        this.qualification = qualification;
    }
}

class Teacher extends Employee {
    int teacher_id;
    String sub, dep;

    public Teacher(int teacher_id, String sub, String dep, int emp_id, int salary, String comp_name, String qualification, String name, int age) {
        super(emp_id, salary, comp_name, qualification, name, age);  
        this.teacher_id = teacher_id;
        this.sub = sub;
        this.dep = dep;
    }

    void Display() {
        System.out.println("===========================================");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Emp ID: " + emp_id);
        System.out.println("Salary: " + salary);
        System.out.println("Company: " + comp_name);
        System.out.println("Qualification: " + qualification);
        System.out.println("Teacher ID: " + teacher_id);
        System.out.println("Subject: " + sub);
        System.out.println("Department: " + dep);
        System.out.println("===========================================");
    }
}

public class TeacherDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of teachers: ");
        int n = sc.nextInt();
        sc.nextLine();  

        Teacher[] t = new Teacher[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Teacher " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();

            System.out.print("Emp ID: ");
            int emp_id = sc.nextInt();
            sc.nextLine();  

            System.out.print("Company Name: ");
            String comp_name = sc.nextLine();

            System.out.print("Qualification: ");
            String qualification = sc.nextLine();

            System.out.print("Salary: ");
            int salary = sc.nextInt();
            sc.nextLine();

            System.out.print("Teacher ID: ");
            int teacher_id = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Subject: ");
            String sub = sc.nextLine();

            System.out.print("Department: ");
            String dep = sc.nextLine();

           
            t[i] = new Teacher(teacher_id, sub, dep, emp_id, salary, comp_name, qualification, name, age);
        }

        System.out.println("\n=== TEACHER DETAILS ===");
        for (int i = 0; i < n; i++) {
            t[i].Display();
        }
    }
}
