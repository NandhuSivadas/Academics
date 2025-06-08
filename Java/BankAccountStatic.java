// Use a BankAccount class.
// Track accountHolderName and balance for each account.
// Use static variables for:
// totalAccounts
// totalBankBalance
// Use static methods to:
// Display total number of accounts
// Display total bank balance
import java.util.*;

class BankAccount{
    String name;
    int balance;
    static int totalAccounts=0;
static int totalBankBalance=0;
    
    public BankAccount(String name,int balance){
        this.name=name;
        this.balance=balance;

        totalAccounts++;
        totalBankBalance+=balance;




    }
    static void CountAccount(){
        System.out.println("Total Accounts: "+totalAccounts);

    }

    static void CountBankBalance(){
        System.out.println("Total Balance: "+totalBankBalance);

    }
}

public class BankAccountStatic{
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter limit?:");
        int n=sc.nextInt();
        sc.nextLine();
        BankAccount[] b=new BankAccount[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter name?:");
            String name=sc.nextLine();
            System.out.println("Enter balance?:");
            int bal=sc.nextInt();
            sc.nextLine();
            b[i]=new BankAccount(name,bal);

        }
        BankAccount.CountAccount();
        BankAccount.CountBankBalance();
    }
}