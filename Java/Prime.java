import java.util.Scanner;

public class Main {

    // Non-static method to check if a number is prime
    public void checkPrime(int num) {
        int flag = 0;

        if (num > 1) {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                System.out.println(num + " is a Prime Number.");
            } else {
                System.out.println(num + " is NOT a Prime Number.");
            }
        } else {
            System.out.println(num + " is NOT a Prime Number.");
        }
    }

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        sc.close();

        Main obj = new Main();  
        obj.checkPrime(num);  
    }
}