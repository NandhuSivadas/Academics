import java.util.Scanner;

public class Main {
    
    
    public void printMultiplicationTable(int n) {
        for (int i = n; i == n; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + "*" + j + "=" + (i * j)); 
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N?: ");
        int n = sc.nextInt();
        sc.close();
        
        
        Main obj = new Main();
        obj.printMultiplicationTable(n);  
    }
}