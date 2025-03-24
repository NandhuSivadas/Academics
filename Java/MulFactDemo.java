class Mul implements Runnable {
    public void run() {
      
        for (int i = 1; i <=10; i++) {
            System.out.println("\t\t"+i + " * 5 = " + (i * 5));
            try{
              Thread.sleep(500);
              
            }
            catch(InterruptedException e){
              e.printStackTrace();
            }
        }
    }
}

class Fact implements Runnable {
    int num = 36;

    public void run() {
      
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {  
                System.out.println("factor "+ i);
                
                try{
              Thread.sleep(500);
              
            }
            catch(InterruptedException e){
              e.printStackTrace();
            }
            }
        }
    }
}

public class MulFactDemo {
    public static void main(String[] args) {
        Mul mulTask = new Mul();
        Fact factTask = new Fact();

        Thread t1 = new Thread(mulTask);
        Thread t2 = new Thread(factTask);

        t1.start();
        t2.start();

        try {
            t1.join(); 
            t2.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




// Output:

// factor 1
// 		1 * 5 = 5
// factor 2
// 		2 * 5 = 10
// factor 3
// 		3 * 5 = 15
// factor 4
// 		4 * 5 = 20
// factor 6
// 		5 * 5 = 25
// factor 9
// 		6 * 5 = 30
// factor 12
// 		7 * 5 = 35
// factor 18
// 		8 * 5 = 40
// factor 36
// 		9 * 5 = 45
// 		10 * 5 = 50