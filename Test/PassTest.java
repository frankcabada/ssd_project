import java.util.Scanner;

public class Change
{
    public static void main(String[] args)
    {
	//First get amount from user
	Scanner fred = new Scanner(System.in);
	System.out.println("Please enter amount due:  ");
	int total = fred.nextInt();
	System.out.println("Please enter amount to give:  ");
	int amount = fred.nextInt();
    
	//Calculations
	int change = amount - total;
	int dollars = change/100;
	int dremain = change%100;
	int quarters = dremain/25;
	int qremain = dremain%25;
	int dimes = qremain/10;
	int dmremain = qremain%10;
	int nickels = dmremain/5;
	int nremain = dmremain%5;
	int pennies = nremain;
	
	System.out.println("Your change is:  " + dollars + "dollars ");
	System.out.println(quarters + "quarters " + dimes + "dimes ");
	System.out.println( + nickels + "nickels " + pennies + "pennies.");
    }
}
