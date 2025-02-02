import java.util.Scanner;
public class Main
{
    
    public static int factorial(int n)
      {
          int f=1;
          for(int i=1;i<=n;i++)
             {
                 f=f*i;
             }
        return f;
      }
 	public static void main(String[] args) 
 	{
	  Scanner sc=new Scanner(System.in);
	  System.out.print("N?:");
	  int n=sc.nextInt();
	  System.out.println(n+"!="+factorial(n));
	}
}