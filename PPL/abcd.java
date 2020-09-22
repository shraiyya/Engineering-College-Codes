//banking application-exception handling
package banks;
import java.util.Scanner;
class exception1 extends Exception
{

	exception1(String s1)
	{
		super(s1);
	}
}
class bank
{
	Scanner s=new Scanner(System.in);
	String name;
	int acc;
	int bal;
	bank( String name,int bal, int acc)
	{
		name=this.name;
		acc=this.acc;
		bal=this.bal;
	}
	//bank account creation
	void create()
	{
		System.out.println("ENTER THE NAME");
		name=s.next();
		System.out.println("ENTER THE ACCOUNT NO");
		acc=s.nextInt();
		System.out.println("ENTER THE BALANCE");
		bal=s.nextInt();
		//the balance should be minimum 1000
		try
		{
			if (bal<1000)
			{
				throw new exception1("ENTER THE BALANCE AGAIN");
			}
		}
		catch(exception1 e)
		{
			System.out.println("BALANCE IS LESS THAN 1000");
			System.out.println("The minimum balance should be 1000 RS "+e+" ");
			
			bal=s.nextInt();
		}//the statement in finally block always gets executed
		finally
		{
			System.out.println("The account details are entered successfully");
		}
				
	}
	void display()
	{
		System.out.println("NAME: "+name);
		System.out.println("ACCOUNT NO: "+acc);
		System.out.println("BALANCE : "+bal);
		System.out.println(" ");
	}
	static void deposit(bank b[],int size)
	{
		int i=0;
		Scanner s1=new Scanner(System.in);
		int acc1=0;
		int amount1=0;
		System.out.println("ENTER THE ACCOUNT NO");
		acc1=s1.nextInt();
		int flag=0;
		int k=0;
	  for ( i=0;i<size;i++)
	  {
		if (acc1==b[i].acc)
		{
			System.out.println("the account is found");
			flag=1;
			k=i;
	}
	  }
	  if (flag==0)
		{
			System.out.println("The account does not exist");
		}
	if (flag==1)
	{ 
	  System.out.println("enter the amount to be deposited");
		amount1=s1.nextInt();
		b[k].bal=b[k].bal+amount1;
		b[k].display();
	
	}
	}
	//withdrawl of money
	//throws is used as it may or may not throw exception
	static void withdrawl(bank b[],int size) throws exception1
	{
		Scanner s1=new Scanner(System.in);
		int acc1=0;
		int amount1=0;
		System.out.println("ENTER THE ACCOUNT NO");
		acc1=s1.nextInt();
		int flag=0;
		int k=0;
	  for (int i=0;i<size;i++)
	  {
		if (acc1==b[i].acc)
		{
			System.out.println("the account is found");
			flag=1;
			k=i;
		}
	}
	  if (flag==0)
		{
			System.out.println("The account does not exist");
		}
	if (flag==1)
	{ 
		
		System.out.println("enter the amount to be withdrawed");
		amount1=s1.nextInt();
		try
		{
			if (amount1<b[k].bal)
			{
				b[k].bal=b[k].bal-amount1;
				b[k].display();
			}
			else if (amount1>b[k].bal)
			{
				throw new exception1("BALANCE IS LESS THAN AMOUNT");
			}
		}
		catch(exception1 e)
		{
			System.out.println("INSUFFICIENT BALANCE IS FOUND"+e);
		}
	
	
	}
	}
	
	static void showbal(bank b[],int size)
	{
		Scanner s1=new Scanner(System.in);
		int acc1=0;
		System.out.println("ENTER THE ACCOUNT NO");
		acc1=s1.nextInt();
		int flag=0;
		int k=0;
	  for (int i=0;i<size;i++)
	  {
		if (acc1==b[i].acc)
		{
			System.out.println("THE ACCOUNT IS FOUND");
			flag=1;
			k=i;
		}
	}
	  if (flag==0)
		{
			System.out.println("THE ABOVE ACCOUNT DOES NOT EXIST");
		}
	if (flag==1)
	{ 
		b[k].display();
	
	}
	}
	
}

public class abcd {
	public static void main(String[] args) throws exception1 {
		//TODO Auto-generated method stub
		Scanner s1=new Scanner(System.in);
		int size=0;
		int i=0;
		String name = null;
		int acc = 0;
		int bal = 0;
		System.out.println("ENTER NUMBER OF ACCOUNTS");
		size=s1.nextInt();
		//to create array of objects
		bank b[]=new bank[size];
		int choice=0;
		
		for(i=0;i<size;i++)
		{
			
			b[i] = new bank(name, acc, bal);
			b[i].create();
		}
		do
		{
		System.out.println("ENTER YOUR CHOICE");
		System.out.println("ENTER 1 FOR DISPLAY");
		System.out.println("ENTER 2 FOR WITHDRAWL");
		System.out.println("ENTER 3 FOR DEPOSIT");
		System.out.println("ENTER 4 FOR SHOW BALANCE");
		System.out.println("ENTER O TO EXIT MENU");
		choice=s1.nextInt();
		switch(choice)
		{
		case 1:
		 for (i=0;i<size;i++)
		 {
			 b[i].display();
		 }
		 System.out.println(" ");
		 break;
		case 2:
		 bank.withdrawl(b,size);
		 break;
		case 3:
		   bank.deposit(b,size);
		break;
		case 4:
	       bank.showbal(b, size);
	     break;
		}
		
		}while(choice!=0);
}
}

/*
ENTER NUMBER OF ACCOUNTS
5
ENTER THE NAME
shreya
ENTER THE ACCOUNT NO
12
ENTER THE BALANCE
1234
The account details are entered successfully
ENTER THE NAME
riya
ENTER THE ACCOUNT NO
89
ENTER THE BALANCE
67
BALANCE IS LESS THAN 1000
The minimum balance should be 1000 RS banks.exception1: ENTER THE BALANCE AGAIN 
6700
The account details are entered successfully
ENTER THE NAME
lisa
ENTER THE ACCOUNT NO
90
ENTER THE BALANCE
8768
The account details are entered successfully
ENTER THE NAME
mary
ENTER THE ACCOUNT NO
45
ENTER THE BALANCE
3245
The account details are entered successfully
ENTER THE NAME
alina
ENTER THE ACCOUNT NO
98
ENTER THE BALANCE
12345
The account details are entered successfully
ENTER YOUR CHOICE
ENTER 1 FOR DISPLAY
ENTER 2 FOR WITHDRAWL
ENTER 3 FOR DEPOSIT
ENTER 4 FOR SHOW BALANCE
ENTER O TO EXIT MENU
1
NAME: shreya
ACCOUNT NO: 12
BALANCE : 1234
 
NAME: riya
ACCOUNT NO: 89
BALANCE : 6700
 
NAME: lisa
ACCOUNT NO: 90
BALANCE : 8768
 
NAME: mary
ACCOUNT NO: 45
BALANCE : 3245
 
NAME: alina
ACCOUNT NO: 98
BALANCE : 12345
 
 
ENTER YOUR CHOICE
ENTER 1 FOR DISPLAY
ENTER 2 FOR WITHDRAWL
ENTER 3 FOR DEPOSIT
ENTER 4 FOR SHOW BALANCE
ENTER O TO EXIT MENU
2
ENTER THE ACCOUNT NO
7890
The account does not exist
ENTER YOUR CHOICE
ENTER 1 FOR DISPLAY
ENTER 2 FOR WITHDRAWL
ENTER 3 FOR DEPOSIT
ENTER 4 FOR SHOW BALANCE
ENTER O TO EXIT MENU
2
ENTER THE ACCOUNT NO
1
The account does not exist
ENTER YOUR CHOICE
ENTER 1 FOR DISPLAY
ENTER 2 FOR WITHDRAWL
ENTER 3 FOR DEPOSIT
ENTER 4 FOR SHOW BALANCE
ENTER O TO EXIT MENU
2
ENTER THE ACCOUNT NO
12
the account is found
enter the amount to be withdrawed
100000
INSUFFICIENT BALANCE IS FOUNDbanks.exception1: BALANCE IS LESS THAN AMOUNT
ENTER YOUR CHOICE
ENTER 1 FOR DISPLAY
ENTER 2 FOR WITHDRAWL
ENTER 3 FOR DEPOSIT
ENTER 4 FOR SHOW BALANCE
ENTER O TO EXIT MENU
2
ENTER THE ACCOUNT NO
98
the account is found
enter the amount to be withdrawed
100
NAME: alina
ACCOUNT NO: 98
BALANCE : 12245
 
ENTER YOUR CHOICE
ENTER 1 FOR DISPLAY
ENTER 2 FOR WITHDRAWL
ENTER 3 FOR DEPOSIT
ENTER 4 FOR SHOW BALANCE
ENTER O TO EXIT MENU
3
ENTER THE ACCOUNT NO
89
the account is found
enter the amount to be deposited
780
NAME: riya
ACCOUNT NO: 89
BALANCE : 7480
 
ENTER YOUR CHOICE
ENTER 1 FOR DISPLAY
ENTER 2 FOR WITHDRAWL
ENTER 3 FOR DEPOSIT
ENTER 4 FOR SHOW BALANCE
ENTER O TO EXIT MENU
3
ENTER THE ACCOUNT NO
456
The account does not exist
ENTER YOUR CHOICE
ENTER 1 FOR DISPLAY
ENTER 2 FOR WITHDRAWL
ENTER 3 FOR DEPOSIT
ENTER 4 FOR SHOW BALANCE
ENTER O TO EXIT MENU
4
ENTER THE ACCOUNT NO
23
THE ABOVE ACCOUNT DOES NOT EXIST
ENTER YOUR CHOICE
ENTER 1 FOR DISPLAY
ENTER 2 FOR WITHDRAWL
ENTER 3 FOR DEPOSIT
ENTER 4 FOR SHOW BALANCE
ENTER O TO EXIT MENU
4
ENTER THE ACCOUNT NO
45
THE ACCOUNT IS FOUND
NAME: mary
ACCOUNT NO: 45
BALANCE : 3245
 
ENTER YOUR CHOICE
ENTER 1 FOR DISPLAY
ENTER 2 FOR WITHDRAWL
ENTER 3 FOR DEPOSIT
ENTER 4 FOR SHOW BALANCE
ENTER O TO EXIT MENU
0
*/
