import java.util.Scanner;

public class synchronizedFact {
    static final Object lock = new Object();  // Use correct Object type
    static boolean factDone = false;          // Flag to signal completion

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();            // Fixed typo: nextInt()

        Factorial fact = new Factorial(number);
        Reverse rev = new Reverse(number);

        Thread factThread = new Thread(fact);
        Thread revThread = new Thread(rev);

        factThread.start();
        revThread.start();
    }
}

class Factorial implements Runnable {
    private int number;

    public Factorial(int number) {
        this.number = number;
    }

    public void run() {
        synchronized (Main.lock) {
            long result = 1;
            for (int i = 1; i <= number; i++) {
                result *= i;
            }
            System.out.println("Factorial: " + result);
            Main.factDone = true;
            Main.lock.notifyAll();  // Notify Reverse thread
        }
    }
}

class Reverse implements Runnable {
    private int num;

    public Reverse(int num) {
        this.num = num;
    }

    public void run() {
        synchronized (Main.lock) {
            while (!Main.factDone) {
                try {
                    Main.lock.wait();  // Wait for factorial to finish
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int rev = 0, temp = num;
            while (temp != 0) {
                rev = rev * 10 + temp % 10;
                temp /= 10;
            }
            System.out.println("Reverse: " + rev);
        }
    }
}
