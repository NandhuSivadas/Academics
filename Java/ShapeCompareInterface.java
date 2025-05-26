import java.util.*;
interface ShapeComparable{
    void volume();
    void area();
    int compare();

}

class cuboid implements ShapeComparable{
    int l,w,h,volume;
    public cuboid(int l,int w,int h){
        {
            this.l=l;
            this.w=w;
            this.h=h;

        }
    }
        public void volume(){
           volume=l*w*h;
            System.out.println("volume:"+volume);
        }
        public void area(){
            int area=l*w*h;
            System.out.println("area:"+area);
        }
         public int compare(){
        return volume;

    }
    }


class cyclinder implements ShapeComparable{
    int r,h;
    int volume;
    public cyclinder(int r,int h){
        this.r=r;
        this.h=h;

    }
    public void volume(){
       volume=r*h;
       System.out.println("volume:"+volume);
    }

    public void area(){
            int area=r*r;
            System.out.println("area:"+area);
        }
    public int compare(){
        return volume;

    }
}

public class ShapeCompareInterface{
    public static void main(String arg[]){
        cuboid c=new cuboid(4,5,6);
        cyclinder cy=new cyclinder(4,5);
        c.area();
        c.volume();
        cy.area();
        cy.volume();
        if(c.compare()>cy.compare())
            {
              System.out.println("cuboid has larger volume");
            }
        else
        {
           System.out.println("cuboid has larger volume");
        }
        }
    }
