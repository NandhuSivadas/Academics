import java.util.Scanner;

class person {
    int age;
    String name;

    public void getName(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

class student extends person {
    int score;

    public void getScore(int score, int age, String name) {
        getName(age, name);
        this.score = score;
    }

    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Score: " + score);
        System.out.println("-----------------------");
    }
}

class Fact implements Runnable{
    public void run(){
    int num=36;
     System.out.println("\t\t\t"+"Factorial");
            
    for(int i=1;i<=num;i++){
       
        if(num%i==0){
             System.out.println("\t\t\t"+i);
            
        
        }
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        
    }
        
    }
}

class ArrayStudentFactorThread {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Fact f=new Fact();
        Thread t=new Thread(f);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume the leftover newline

        student[] students = new student[n];
        

        for (int i = 0; i < n; i++) {
            students[i] = new student();
            System.out.println("Enter details for student " + (i + 1) + ":");
            
            System.out.print("Name: ");
            String name = sc.nextLine();
            
            System.out.print("Age: ");
            int age = sc.nextInt();
            
            System.out.print("Score: ");
            int score = sc.nextInt();
            sc.nextLine(); // consume newline

            students[i].getScore(score, age, name);
        }

        System.out.println("\n--- Student Details ---");
        for (int i = 0; i < n; i++) {
            students[i].show();
        }

        sc.close();
        t.start();
        try{
            t.join();
            
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        
        
    }
}
