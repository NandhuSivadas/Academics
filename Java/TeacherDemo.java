import java.util.Scanner;

class Person {
    public String name;
    public String gender;
    public String address;
    public int age;

    public Person(String name, String gender, String address, int age) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Address: " + address);
        System.out.println("Age: " + age);
    }
}

class Employee extends Person {
    public int empid;
    public String company_name;
    public String qualification;
    public float salary;

    public Employee(String name, String gender, String address, int age, int empid, String company_name, String qualification, float salary) {
        super(name, gender, address, age);
        this.empid = empid;
        this.company_name = company_name;
        this.qualification = qualification;
        this.salary = salary;
    }

    public void display() {
        super.display();
        System.out.println("Employee ID: " + empid);
        System.out.println("Company Name: " + company_name);
        System.out.println("Qualification: " + qualification);
        System.out.println("Salary: " + salary);
    }
}

class Teacher extends Employee {
    public int teacherid;
    public String subject;
    public String department;

    public Teacher(String name, String gender, String address, int age, int empid, String company_name, String qualification, float salary, int teacherid, String subject, String department) {
        super(name, gender, address, age, empid, company_name, qualification, salary);
        this.teacherid = teacherid;
        this.subject = subject;
        this.department = department;
    }

    public void display() {
        super.display();
        System.out.println("Teacher ID: " + teacherid);
        System.out.println("Subject: " + subject);
        System.out.println("Department: " + department);
    }
}

public class TeacherDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for number of teachers
        System.out.print("Enter the number of teachers: ");
        int numTeachers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Create an array of Teacher objects
        Teacher[] teachers = new Teacher[numTeachers];

        // Loop to take input for each teacher
        for (int i = 0; i < numTeachers; i++) {
            System.out.println("\nEnter details for Teacher " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            System.out.print("Employee ID: ");
            int empid = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            System.out.print("Company Name: ");
            String company_name = scanner.nextLine();
            System.out.print("Qualification: ");
            String qualification = scanner.nextLine();
            System.out.print("Salary: ");
            float salary = scanner.nextFloat();
            System.out.print("Teacher ID: ");
            int teacherid = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            System.out.print("Subject: ");
            String subject = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();

            // Create and store teacher object
            teachers[i] = new Teacher(name, gender, address, age, empid, company_name, qualification, salary, teacherid, subject, department);
        }

        // Display teacher details
        System.out.println("\nTeacher Details:");
        for (int i = 0; i < teachers.length; i++) {
            System.out.println("-----------------------------");
            System.out.println("Teacher " + (i + 1) + " Details:");
            teachers[i].display();
        }

        // Close scanner
        scanner.close();
    }
}


// output
// -----


// Enter the number of teachers: 2

// Enter details for Teacher 1:
// Name: Nandhu
// Gender: Male
// Address: Asgard
// Age: 26
// Employee ID: 235
// Company Name: TCS
// Qualification: MCA
// Salary: 1200000
// Teacher ID: 298
// Subject: OS
// Department: MCA

// Enter details for Teacher 2:
// Name: Yadhu
// Gender: male
// Address: Pala
// Age: 27
// Employee ID: 754
// Company Name: TCS
// Qualification: MCA
// Salary: 661111
// Teacher ID: 568
// Subject: CO
// Department: MCA

// Teacher Details:
// -----------------------------
// Teacher 1 Details:
// Name: Nandhu
// Gender: Male
// Address: Asgard
// Age: 26
// Employee ID: 235
// Company Name: TCS
// Qualification: MCA
// Salary: 1200000.0
// Teacher ID: 298
// Subject: OS
// Department: MCA
// -----------------------------
// Teacher 2 Details:
// Name: Yadhu
// Gender: male
// Address: Pala
// Age: 27
// Employee ID: 754
// Company Name: TCS
// Qualification: MCA
// Salary: 661111.0
// Teacher ID: 568
// Subject: CO
// Department: MCA
// PS D:\Java> 