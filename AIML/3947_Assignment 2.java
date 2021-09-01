/*
 NAME : SHREYA CHETAN PAWASKAR
 ROLL NO : 3947
 C-NO : C22018881961
 TITLE : WATER JUG PROBLEM
 */

import java.util.Scanner;

public class Water_Jug {

	Scanner sc=new Scanner(System.in);
	int jug1=0,jug2=0;
	int goal1=0;
	int goal2=0;
	int count=0;
	
	//temp variables
	int a=0,b=0;
	void accept()
	{
		//take input with value >1
		do {
		System.out.println("ENTER CAPACITY OF JUG-1 : ");
		jug1=sc.nextInt();
		}while(jug1<1);
		
		do {
		System.out.println("ENTER CAPACITY OF JUG-2 : ");
		jug2=sc.nextInt();
		}while(jug2<1);
	
		//enter goal capacity
		System.out.println("ENTER GOAL CAPACITY OF JUG-1 : ");
		goal1=sc.nextInt();
		System.out.println("ENTER GOAL CAPACITY OF JUG-2 : ");
		goal2=sc.nextInt();
        System.out.println("");
        
        System.out.println("ANSWER: ");
        
        //While no of iterations < 50
        while(count<50)
		{
        	// if the initial capacities = goal states
			if(a == goal1 && b == goal2)
			{
				break;
			}
			
			//initial case for jug-1
			if(a == 0)
			{
				a = jug1;
				count++;
				System.out.println(a+" "+b);
			}
			
			//initial case for jug-2
			else if(b == jug2)
			{
				b = 0;
				count++;
				System.out.println(a +" " +b);
			}

			else if(a <= jug1 && b < jug2)
			{
				if(a >= jug2-b)
				{
					a = a-(jug2-b);
					b = jug2;
					count++;
					System.out.println(a +" " +b);
				}
				else
				{
					b = a + b;
					a = 0;
					count++;
					System.out.println(a +" " +b);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create an object for the class
		Water_Jug wj= new Water_Jug();
		//call the method
		wj.accept();
		
	}

}

/*
ENTER CAPACITY OF JUG-1 : 
4
ENTER CAPACITY OF JUG-2 : 
3
ENTER GOAL CAPACITY OF JUG-1 : 
2
ENTER GOAL CAPACITY OF JUG-2 : 
0

ANSWER: 
4	0
1	3
1	0
0	1
4	1
2	3
2	0


ENTER CAPACITY OF JUG-1 : 
5
ENTER CAPACITY OF JUG-2 : 
3
ENTER GOAL CAPACITY OF JUG-1 : 
4
ENTER GOAL CAPACITY OF JUG-2 : 
0

ANSWER: 
5	0
2	3
2	0
0	2
5	2
4	3
4	0

 */
