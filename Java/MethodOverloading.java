import java.util.Scanner;

class Demo {
   
    void area(int l, int b) {
        System.out.println("Area of Rectangle: " + (l * b));
    }

   
    void area(int a) {
        System.out.println("Area of Square: " + (a * a));
    }

    
    void area(float b, float h) {
        System.out.println("Area of Triangle: " + (0.5 * b * h));
    }

    
    void area(double r) {
        System.out.println("Area of Circle: " + (3.14 * r * r));
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Demo obj = new Demo();

        
        System.out.println("Enter the length of the rectangle:");
        int l = sc.nextInt();
        System.out.println("Enter the breadth of the rectangle:");
        int b = sc.nextInt();
        obj.area(l, b);

     
        System.out.println("Enter the side of the square:");
        int side = sc.nextInt();
        obj.area(side);

     
        System.out.println("Enter the base of the triangle:");
        float base = sc.nextFloat();
        System.out.println("Enter the height of the triangle:");
        float height = sc.nextFloat();
        obj.area(base, height);

        
        System.out.println("Enter the radius of the circle:");
        double radius = sc.nextDouble();
        obj.area(radius);

        sc.close(); 
    }
}
