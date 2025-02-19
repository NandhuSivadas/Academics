import geometry.shapes2d.*;
import geometry.shapes3d.*;
import java.util.Scanner;

public class GeoMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create and compute for Circle
        Circle circle = new Circle(sc);
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Perimeter: " + circle.perimeter());

        // Create and compute for Rectangle
        Rectangle rectangle = new Rectangle(sc);
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Rectangle Perimeter: " + rectangle.perimeter());

        // Create and compute for Sphere
        Sphere sphere = new Sphere(sc);
        System.out.println("Sphere Surface Area: " + sphere.area());
        System.out.println("Sphere Circumference: " + sphere.perimeter());

        sc.close();
    }
}
