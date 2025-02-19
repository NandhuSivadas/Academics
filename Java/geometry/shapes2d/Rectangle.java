package geometry.shapes2d;

import geometry.interfaces.*;
import java.util.Scanner;

public class Rectangle implements CalcArea, CalcPerimeter {
    private double length, width;

    public Rectangle(Scanner sc) {
        System.out.println("Enter length and width: ");
        length = sc.nextDouble();
        width = sc.nextDouble();
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }
}
