/*
 NAME : SHREYA CHETAN PAWASKAR
 ROLL NO : 3947
 C-NO : C22018881961
 TITLE : logic gates using artificial neural network McCulloch-Pitts model
 */

import java.util.*;

public class ANN_Logic_Gates
{
	public static void main(String args[])
	{
		Scanner sc =  new Scanner(System.in);
		int choice1= 0;
		int ch2= 0;
		do
		{
			int input1= 0, input2= 0;
			int output= 0;		
			int threshold=0;
			int w1=0;
			int w2=0;
			System.out.println("----------------------MENU-----------------------");
			System.out.println("1. AND");
			System.out.println("2. OR");
			System.out.println("3. NOT");
			System.out.println("4. NAND");
			System.out.println("5. NOR");
			System.out.println("0. EXIT");
			System.out.print("ENTER YOUR CHOICE: ");
			choice1 =  sc.nextInt();
			
			switch(choice1)
			{
				case 0:
					System.out.println("EXITED SUCCESSFULLY! ");
					break;
				
				case 1: 
					System.out.println("ENTER FIRST INPUT: ");
					input1 =  sc.nextInt();
					System.out.println("ENTER SECOND INPUT: ");
					input2 =  sc.nextInt();
					w1=1;
					w2 = 1;
					threshold=1;
					if((w1*input1 + w2*input2 - threshold) <=  0)
						output = 0;
					else
						output = 1; 
					System.out.println("OUTPUT IS : "+output); 
					break;
					
				case 2:
					System.out.println("ENTER FIRST INPUT: ");
					input1 =  sc.nextInt();
					System.out.println("ENTER SECOND INPUT: ");
					input2 =  sc.nextInt();
					w1=2;
					w2 = 2;
					threshold=1;
					if((( w1 * input1) + (w2 * input2) - threshold) <=  0)
						output = 0;
					else
						output = 1;
					System.out.println("OUTPUT IS : "+output); 
					break;
					
				case 3: 
					System.out.println("ENTER INPUT: ");
					input1 =  sc.nextInt();
					w1 = -1;
					if(((w1 * input1) + 1) <=  0)
						output= 0;
					else
						output= 1;
					System.out.println("OUTPUT IS : "+output);  
					break;
					
				case 4:
					System.out.println("ENTER FIRST INPUT: ");
					input1 =  sc.nextInt();
					System.out.println("ENTER SECOND INPUT: ");
					input2 =  sc.nextInt();
					w1 = -1;
					w2 = -1;
					threshold=-2;
					if(((w1 * input1) + (w2 * input2) - threshold) <=  0)
						output = 0;
					else
						output = 1;
					System.out.println("OUTPUT IS : "+output); 
					break;
					
				case 5:
					System.out.println("ENTER FIRST INPUT: ");
					input1 =  sc.nextInt();
					System.out.println("ENTER SECOND INPUT: ");
					input2 =  sc.nextInt();
					w1 = -1;
					w2 = -1;
					threshold= -1;
					if(((w1 * input1) + (w2 * input2) - threshold) <=  0)
						output = 0;
					else
						output = 1; 
					System.out.println("OUTPUT IS : "+output); 
					break;
					
				default: System.out.println("WRONG CHOICE. TRY AGAIN!");
					break;
			}
			System.out.println(" ");
			System.out.println("PRESS 1 TO CONTINUE.");
			System.out.println("PRESS 0 TO EXIT.");
			ch2 =  sc.nextInt();
		
		}while(ch2!= 0);
	}
} 


/*

OUTPUT:
----------------------MENU-----------------------
1. AND
2. OR
3. NOT
4. NAND
5. NOR
0. EXIT
ENTER YOUR CHOICE: 1
ENTER FIRST INPUT: 
1
ENTER SECOND INPUT: 
0
OUTPUT IS : 0
 
PRESS 1 TO CONTINUE.
PRESS 0 TO EXIT.
1
----------------------MENU-----------------------
1. AND
2. OR
3. NOT
4. NAND
5. NOR
0. EXIT
ENTER YOUR CHOICE: 2
ENTER FIRST INPUT: 
0
ENTER SECOND INPUT: 
0
OUTPUT IS : 0
 
PRESS 1 TO CONTINUE.
PRESS 0 TO EXIT.
1
----------------------MENU-----------------------
1. AND
2. OR
3. NOT
4. NAND
5. NOR
0. EXIT
ENTER YOUR CHOICE: 3
ENTER INPUT: 
0
OUTPUT IS : 1
 
PRESS 1 TO CONTINUE.
PRESS 0 TO EXIT.
1
----------------------MENU-----------------------
1. AND
2. OR
3. NOT
4. NAND
5. NOR
0. EXIT
ENTER YOUR CHOICE: 4
ENTER FIRST INPUT: 
1
ENTER SECOND INPUT: 
0
OUTPUT IS : 1
 
PRESS 1 TO CONTINUE.
PRESS 0 TO EXIT.
1
----------------------MENU-----------------------
1. AND
2. OR
3. NOT
4. NAND
5. NOR
0. EXIT
ENTER YOUR CHOICE: 5
ENTER FIRST INPUT: 
1
ENTER SECOND INPUT: 
1
OUTPUT IS : 0
 
PRESS 1 TO CONTINUE.
PRESS 0 TO EXIT.
1
----------------------MENU-----------------------
1. AND
2. OR
3. NOT
4. NAND
5. NOR
0. EXIT
ENTER YOUR CHOICE: 99
WRONG CHOICE. TRY AGAIN!
 
PRESS 1 TO CONTINUE.
PRESS 0 TO EXIT.
0

*/