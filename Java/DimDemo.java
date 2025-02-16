// Functional Interface
interface Dim {
    double area(double x);
}

public class DimDemo {
    public static void main(String[] args) {
        
        Dim square = (x) -> x * x;
        Dim cube = (x) -> 6 * x * x;
        Dim circle = (x) -> Math.PI * x * x; 
        Dim sphere = (x) -> 4 * Math.PI * x * x; 

        System.out.println("Area of Square (side = 4): " + square.area(4));
        System.out.println("Surface Area of Cube (side = 3): " + cube.area(3));
        System.out.println("Area of Circle (radius = 5): " + circle.area(5));
        System.out.println("Surface Area of Sphere (radius = 6): " + sphere.area(6));
    }
}
