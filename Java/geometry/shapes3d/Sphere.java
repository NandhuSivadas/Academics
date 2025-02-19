package geometry.shapes3d;

import geometry.interfaces.*;
import java.util.Scanner;

public class Sphere implements CalcArea, CalcPerimeter {
    private double radius;

    public Sphere(Scanner sc) {
        System.out.println("Enter radius: ");
        radius = sc.nextDouble();
    }

    public double area() {
        return 4 * Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
