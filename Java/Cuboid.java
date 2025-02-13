interface Measurable{
    public double volume();

}

interface Printable{
    public String print();
}


class Rectangle{
    double length,width;
   public Rectangle(double length,double width){
        this.length=length;
        this.width=width;

    }

    public double area()
      {
        return length * width;

      }
}

class Cuboid extends Rectangle implements Measurable,Printable
  {
    double height;
    public Cuboid(double length,double width,double height)
      {
        super(length,width);
        this.height=height;
      }
      public double volume()
       {
        return area()*height;
       }

    public String print()
     {
        return "";
     }

       public static void main(String[] args) 
         {
            Cuboid c=new Cuboid(2,5,4);
            System.out.println("Area:"+c.volume());
            
         }
  }