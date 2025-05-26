import java.util.*;
abstract class Shape{
    abstract void area();
    abstract void perimeter();
}

class Square extends Shape{
    int a;
    public Square(int a){
        this.a=a;
    }
    void area(){
        System.out.println("Area of Square:"+a*a);
    }

     void perimeter(){
        System.out.println("perimeter of Square:"+4*a);
    }
}

class Rectangle extends Shape{
    int l,b;
    public Rectangle(int l,int b){
        this.l=l;
        this.b=b;
    }
     void area(){
        System.out.println("Area of Rectangle:"+l*b);
    }

     void perimeter(){
        System.out.println("perimeter of Rectangle:"+2*(l+b));
    }
}
class AbstractDemo{
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a?:");
        int a=sc.nextInt();
        System.out.println("Enter l?:");
        int l=sc.nextInt();
        System.out.println("Enter b?:");
        int b=sc.nextInt();
        Square s=new Square(a);
         s.area();
        s.perimeter();
        Rectangle r=new Rectangle(l,b);
        r.area();
        r.perimeter();
       
    }
}