import java.util.*;
class Person{
    String name;
    int price;
    public Person(String name,int price){
        this.name=name;
        this.price=price;
    }
}
class Product{
    
    ArrayList<Person> item=new ArrayList<>();
    void addproduct(Scanner sc){
       
        System.out.println("Enter the product name:");
        String name=sc.nextLine();
        System.out.println("Enter Price?:");
        int price=sc.nextInt();
        sc.nextLine();
        item.add(new Person(name,price));
        System.out.println("Item added successfully?:");
     
        
    }

    void removeproduct(Scanner sc){
        System.out.println("Enter the product to be removed:");
        String k=sc.nextLine();
        for(Person pro:item){
        if(pro.name.equals(k)){
            item.remove(pro);
            System.out.println("Removed Successfully");

        }
        }
    }

    void searchproduct(Scanner sc){
        System.out.println("Enter the product to be searched:");
        String k=sc.nextLine();
        for(Person pro:item)
        if(pro.name.equalsIgnoreCase(k)){
            System.out.println("Item Found");
        }
        else{
            System.out.println("Item not found");
        }
    }

     void display(){
        
    for(Person pro:item){
       System.out.println("Name: "+pro.name);
       System.out.println("Price: "+pro.price);
    }
}
}
public class ProductArrayList{
    public static void main(String arg[]){
        Product p=new Product();
        Scanner sc=new Scanner(System.in);
        int ch;
        
        do{
            System.out.println("1.Add");
            System.out.println("2.Remove");
            System.out.println("3.search");
            System.out.println("4.display");
            System.out.println("Enter the choice:");
            ch=sc.nextInt();
            sc.nextLine();
            
            switch(ch){
                case 1:p.addproduct(sc);
                break;

                case 2:p.removeproduct(sc);
                break;

                case 3:p.searchproduct(sc);
                break;

                case 4:p.display();
                break;
            }
            

        }while(ch!=5);
    }
}