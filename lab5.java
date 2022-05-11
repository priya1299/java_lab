import java.util.Scanner;

 
import java.util.*;

 
public class lab5
{
  
public static int NewRandom (int min, int max)
  {
    
Random rand = new Random ();
    
int randomNum = rand.nextInt ((max - min) + 1) + min;
    
return randomNum;
  
}
  
public static void main (String[]args) 
  {
    
 
 
 
if (args.length > 0)
      
 
      {
	
 
try 
	{
	  
 
 
Scanner keyboard = new Scanner (System.in);
	  
 
 
 
System.out.println ("WELCOME TO THE BANK OF PG.");
	  
 
 
int firstNum = Integer.parseInt (args[0]);
	  
 
int secNum = Integer.parseInt (args[1]);
	  
 
 
int pin = 12345;
	  
int tries = 0;
	  
 
while (firstNum != pin && tries < 3)
	    
 
	    {
	      
 
System.out.println ("\nINCORRECT PIN. TRY AGAIN.");
	      
 
System.out.print ("ENTER YOUR PIN: ");
	      
 
firstNum = keyboard.nextInt ();
	      
tries++;
	    
 
 
}
	  
 
 
 
 
 
 
 
 
System.out.
	    println ("\nPIN ACCEPTED. YOU NOW HAVE ACCESS TO YOUR ACCOUNT.");
	  
 
Random rand = new Random ();
	  
String card = "PG";
	  
for (int i = 0; i < 8; i++)
	    {
	      
int n = rand.nextInt (10) + 0;
	      
card += Integer.toString (n);
	  
} 
for (int i = 0; i < 8; i++)
	    {
	      
if (i % 4 == 0)
		
System.out.print (" ");
	    
 
}
	  
 
 
System.out.
	    println ("\n This is your System Generated Session Number: " +
		     card + secNum);
	  
System.out.
	    println ("\n This is your 4 digit Session Key Entered BY you : " +
		     secNum);
	  
	    /////////////////////////////////////////////////////////////////////////////////////////
	    
Scanner KB = new Scanner (System.in);
	  
 
	    //create initial accounts
	    System.out.print ("How Many Customer U Want to Input : ");
	  
int n = KB.nextInt ();
	  
BankDetails C[] = new BankDetails[n];
	  
for (int i = 0; i < C.length; i++)
	    {
	      
C[i] = new BankDetails ();
	      
C[i].openAccount ();
	    
} 
 
	    //run loop until menu 5 is not pressed
	  int ch;
	  
	  do
	    {
	      
System.out.
		println
		("Main Menu\n1. Display All\n 2. Search By Account\n 3. Deposit\n 4. Withdrawal\n 5.E xit ");
	      
System.out.println ("Ur Choice :");
	      ch = KB.nextInt ();
	      
switch (ch)
		{
		
case 1:
		  
for (int i = 0; i < C.length; i++)
		    {
		      
C[i].showAccount ();
		    
} 
break;
		
 
case 2:
		  
System.out.
		    print ("Enter Account No U Want to Search...: ");
		  
String acn = KB.next ();
		  
boolean found = false;
		  
for (int i = 0; i < C.length; i++)
		    {
		      
found = C[i].search (acn);
		      
if (found)
			{
			  
break;
			
}
		    
}
		  
if (!found)
		    {
		      
System.out.
			println ("Search Failed..Account Not Exist..");
		    
}
		  
break;
		
 
case 3:
		  
System.out.print ("Enter Account No : ");
		  
acn = KB.next ();
		  
found = false;
		  
for (int i = 0; i < C.length; i++)
		    {
		      
found = C[i].search (acn);
		      
if (found)
			{
			  
C[i].deposit ();
			  
break;
			
}
		    
}
		  
if (!found)
		    {
		      
System.out.
			println ("Search Failed..Account Not Exist..");
		    
}
		  
break;
		
 
case 4:
		  
System.out.print ("Enter Account No : ");
		  
acn = KB.next ();
		  
found = false;
		  
for (int i = 0; i < C.length; i++)
		    {
		      
found = C[i].search (acn);
		      
if (found)
			{
			  
C[i].withdrawal ();
			  
break;
			
}
		    
}
		  
if (!found)
		    {
		      
System.out.
			println ("Search Failed..Account Not Exist..");
		    
}
		  
break;
		
 
case 5:
		  
System.out.println ("Good Bye..");
		  
break;
		
}
	    
}
	  
while (ch != 5);
	}
	
 
catch (NumberFormatException nfe) 
	{
	  
 
System.out.println ("Argument/s must be the integer value");
	
 
}
      
 
}
  
 
}

 
}


 
class BankDetails
{
  
private String accno;
  
private String name;
  
private String acc_type;
  
private long balance;
  
Scanner sc = new Scanner (System.in);
  
    //method to open new account  
  public void openAccount ()
  {
    
System.out.print ("Enter Account No: ");
    
accno = sc.next ();
    
System.out.print ("Enter Account type: ");
    
acc_type = sc.next ();
    
System.out.print ("Enter Name: ");
    
name = sc.next ();
    
System.out.print ("Enter Balance: ");
    
balance = sc.nextLong ();
  
} 
    //method to display account details  
  public void showAccount ()
  {
    
 
 
System.out.println ("Name of account holder: " + name);
    
System.out.println ("Account no.: " + accno);
    
System.out.println ("Account type: " + acc_type);
    
System.out.println ("Balance: " + balance);
  
} 
    //method to deposit money  
  public void deposit ()
  {
    
long amt;
    
System.out.println ("Enter the amount you want to deposit: ");
    
amt = sc.nextLong ();
    
 
balance = balance + amt;
  
} 
    //method to withdraw money  
  public void withdrawal ()
  {
    
long amt;
    
System.out.println ("Enter the amount you want to withdraw: ");
    
amt = sc.nextLong ();
    
 
if (this.balance >= amt)
      {
	balance = balance - amt;
	
System.out.println ("Balance after withdrawal: " + balance);
      }
    
    else
      {
	
System.out.println ("Your balance is less than " + amt +
			     "\tTransaction failed...!!");
      
}
  
}
  
    //method to search an account number  
    public boolean search (String ac_no)
  {
    
 
if (this.accno.equals (this.accno))
      
 
      {
	
showAccount ();
	
return (true);
      
}
    
return (false);
  
}

}
