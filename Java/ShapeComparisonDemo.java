import java.util.Scanner;

interface ShapeComparable {
    double volume();
    
    int compareByVolume(ShapeComparable other);
  
}

class Cuboid implements ShapeComparable {
    double length, width, height;

    public Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double volume() {
        return length * width * height;
    }

   

    public int compareByVolume(ShapeComparable other) {
        return Double.compare(this.volume(), other.volume());
    }

    
}

class Cylinder implements ShapeComparable {
    double radius, height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double volume() {
        return Math.PI * radius * radius * height;
    }

   

    public int compareByVolume(ShapeComparable other) {
        return Double.compare(this.volume(), other.volume());
    }

   
}

public class ShapeComparisonDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.println("Enter the cuboid's length, width, and height:");
        double length = sc.nextDouble();
        double width = sc.nextDouble();
        double height = sc.nextDouble();
        Cuboid cuboid = new Cuboid(length, width, height);

       
        System.out.println("Enter the cylinder's radius and height:");
        double radius = sc.nextDouble();
        double cylinderHeight = sc.nextDouble();
        Cylinder cylinder = new Cylinder(radius, cylinderHeight);

      
        System.out.println("\nCuboid Volume: " + cuboid.volume());
        System.out.println("Cylinder Volume: " + cylinder.volume());

       
        int volumeComparison = cuboid.compareByVolume(cylinder);
        if (volumeComparison > 0) {
            System.out.println("Cuboid has a larger volume than the cylinder.");
        } else if (volumeComparison < 0) {
            System.out.println("Cylinder has a larger volume than the cuboid.");
        } else {
            System.out.println("Both shapes have the same volume.");
        }

     

        sc.close();
    }
}


// output

// Enter the cuboid's length, width, and height:
// 12
// 3
// 4
// Enter the cylinder's radius and height:
// 2
// 4

// Cuboid Volume: 144.0
// Cylinder Volume: 50.26548245743669
// Cuboid has a larger volume than the cylinder.
