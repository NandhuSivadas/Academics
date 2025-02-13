import java.util.Scanner;

interface Printable {
    public void display();
    public void show();
}

interface Computable {
    public double area();
    public double perimeter(); 
    public double volume();
}

interface Drawable {
    public void draw();
}

class Rectangle implements Printable, Computable, Drawable {
    double length, width;

    public Rectangle(double l, double w) {
        length = l;
        width = w;
    }

    public void display() {
        System.out.println("Length: " + length + " Width: " + width);
    }

    public void show() {
        System.out.println("Drawing Rectangle...");
    }

    public double perimeter() {
        return 2 * (length + width);
    }

    public double area() {
        return length * width;
    }

    public double volume() {
        return 0; 
    }

    public void draw() {
        System.out.println("Drawing a rectangle...");
    }
}

class Sphere implements Printable, Computable, Drawable {
    double radius;
    
    public Sphere(double r) {
        radius = r;
    }
    
    public void display() {
        System.out.println("Radius: " + radius);
    }
    
    public void show() {
        System.out.println("Displaying sphere properties...");
    }
    
    public double perimeter() {
        return 0; 
    }
    
    public double area() {
        return 4 * 3.14* radius * radius; 
    }
    
    public double volume() {
        return (4.0 / 3.0) * 3.14 * radius * radius * radius; 
    }
    public void draw() {
        System.out.println("Drawing a sphere...");
    }
}

public class SphereDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter length:");
        double length = sc.nextDouble();
        
        System.out.println("Enter width:");
        double width = sc.nextDouble();
        
        System.out.println("Enter radius:");
        double radius = sc.nextDouble();
        
        Rectangle rect = new Rectangle(length, width);
        Sphere sphere = new Sphere(radius);

        System.out.println("\nRectangle Details:");
        rect.display();
        System.out.println("Area: " + rect.area());
        System.out.println("Perimeter: " + rect.perimeter());
        rect.draw();
        
        System.out.println("\nSphere Details:");
        sphere.display();
        System.out.println("Surface Area: " + sphere.area());
        System.out.println("Volume: " + sphere.volume());
        sphere.draw();
        
        sc.close(); 
    }
}

// output

// Enter length:
// 12
// Enter width:
// 10
// Enter radius:
// 3

// Rectangle Details:
// Length: 12.0 Width: 10.0
// Area: 120.0
// Perimeter: 44.0
// Drawing a rectangle...

// Sphere Details:
// Radius: 3.0
// Surface Area: 113.03999999999999
// Volume: 113.03999999999998
// Drawing a sphere...