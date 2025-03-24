import java.util.Scanner;

class Mul implements Runnable {
    Scanner sc = new Scanner(System.in);

    public void run() {
     
        int num =10;

        for (int i = 2; i <= num; i++) {  
            int flag = 0;  

            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    flag = 1; 
                    break;
                }
            }

            if (flag == 0) {  
                System.out.println("Prime: " + i);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Fact implements Runnable {
   

    public void run() {
    
        int num = 10;

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                System.out.println("\t\tEven: " + i);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Fib implements Runnable {
 

    public void run() {
       
        int num = 10;

        int a = 0, b = 1, c;
        for (int i = 1; i <= num; i++) {
            System.out.println("\t\t\t\tFibonacci: " + a);
            c = a + b;
            a = b;
            b = c;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class PrimeEvenFib {
    public static void main(String[] args) {
        Mul mulTask = new Mul();
        Fact factTask = new Fact();
        Fib fibTask = new Fib();

        Thread t1 = new Thread(mulTask);
        Thread t2 = new Thread(factTask);
        Thread t3 = new Thread(fibTask);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


// Output:

// Prime: 2
// 				Fibonacci: 0
// Prime: 3
// 				Fibonacci: 1
// 		Even: 2
// 				Fibonacci: 1
// Prime: 5
// 		Even: 4
// 				Fibonacci: 2
// 				Fibonacci: 3
// Prime: 7
// 		Even: 6
// 				Fibonacci: 5
// 				Fibonacci: 8
// 		Even: 8
// 				Fibonacci: 13
// 				Fibonacci: 21
// 		Even: 10
// 				Fibonacci: 34