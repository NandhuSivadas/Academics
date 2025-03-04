
import arithmetic.*;
import java.util.Scanner;

public class ArithmeticDemo {

    public static void main(String[] args) {
        int ch;
        Scanner sc = new Scanner(System.in);
        ArithmeticOperation ad = new Addition();
        ArithmeticOperation sub = new Subtraction();
        ArithmeticOperation mul = new Mult();
        ArithmeticOperation div = new Div();
        do {
            System.err.println("1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n5.Exit\nEnter your choice");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                        System.out.println("enter values for a and b");
                        double a = sc.nextDouble();
                        double b = sc.nextDouble();
                        System.out.println(a+" + "+b+" = "+ad.operation(a,b));
                        break;
                case 2:System.out.println("enter values for a and b");
                        double c=sc.nextDouble();
                        double d=sc.nextDouble();
                        System.out.println(c+" - "+d+" = "+sub.operation(c,d));
                        break;
                case 3:System.out.println("enter values for a and b");
                        double e=sc.nextDouble();
                        double f=sc.nextDouble();
                        System.out.println(e+" * "+f+" = "+mul.operation(e,f));
                        break;
                case 4:System.out.println("enter values for a and b");
                        double g=sc.nextDouble();
                        double h=sc.nextDouble();
                        System.out.println(g+" / "+h+" = "+div.operation(g,h));
                        break;
                case 5:System.exit(0);
                default:
                    throw new AssertionError();
            }
        } while (ch != 5);

    }
}