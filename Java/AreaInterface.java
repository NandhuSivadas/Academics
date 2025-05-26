import java.util.*;
interface compute{
    void area();
    void perimeter();

}
class square implements compute{
    int a;
    public square(int a){
        this.a=a;
    }

    public void area(){
        System.out.println("Area of Square: "+a*a);

    }
    public void perimeter(){
        System.out.println("Perimeter of square: "+4*a);
    }

}

class rectangle implements compute{
    int l,b;
    public rectangle(int l,int b){
        this.l=l;
        this.b=b;
    }

     public void area(){
        System.out.println("Area of rectangle: "+l*b);

    }
    public void perimeter(){
        System.out.println("perimeter of rectangle: "+(2*(l+b)));
    }
}
public class AreaInterface{
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter:?");
        int a=sc.nextInt();
        System.out.println("Enter:?");
        int l=sc.nextInt();
        System.out.println("Enter:?");
        int b=sc.nextInt();
        square s=new square(a);
        s.area();
        s.perimeter();
        rectangle r=new rectangle(l,b);
        r.area();
        r.perimeter();
    }
}