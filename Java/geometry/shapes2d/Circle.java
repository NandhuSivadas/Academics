package geometry.shapes2d;

import geometry.interfaces.*;
import java.util.Scanner;

public class Circle implements CalcArea, CalcPerimeter {
    private double radius;

    public Circle(Scanner sc) {
        System.out.println("Enter radius: ");
        radius = sc.nextDouble();
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
