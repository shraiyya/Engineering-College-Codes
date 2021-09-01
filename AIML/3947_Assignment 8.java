/*
 NAME : SHREYA CHETAN PAWASKAR
 DIV : C
 ROLL NO : 3947
 C-NO : C22018881961
 TITLE : Perceptron learning algorithm of artificial neural network
 */

import java.text.DecimalFormat;
import java.util.*;

class Perceptron_ANN
{
	Scanner sc = new Scanner(System.in);
	
	void perceptron_algo(int[][] input, int[] output) 
	{
		//counter
		int c= 0;
		int epoch = 0;
		float weight1=0,weight2=0,bias=0,learning_rate=0;
		//decimal formatter
		DecimalFormat d = new DecimalFormat("#.##");
		
		System.out.println("ENTER FIRST WEIGHT: ");
		weight1 = sc.nextFloat();
		System.out.println("ENTER SECOND WEIGHT: ");
		weight2 = sc.nextFloat();
		System.out.println("ENTER BIAS : ");
		bias = sc.nextFloat();
		System.out.println("ENTER LEARNING RATE : ");
		learning_rate = sc.nextFloat();
		
		float dw1=0, dw2=0;
		float db=0;			
		int error=0;
		int actual_answer=0;
		
		while(true)
		{
			//increase the count of epoch
			epoch++;
			System.out.println("________________________________________________________________________________________________);
			System.out.println("EPOCH "+epoch);
			System.out.println("X1		"+"X2	    "+"DESIRED	     "+"ACTUAL		"+"ERROR	        "+"WEIGHT1		  "+"WEIGHT2	"+"BIAS	");
			for(int i=0; i<4; i++)
			{
				//formula
				float calculated_answer = input[i][0]*weight1 + input[i][1]*weight2 + bias;
				// if the result is greater than zero the ans will be 1
				if(calculated_answer >= 0)
				{
					actual_answer = 1;
				}
				else
				{
					actual_answer = 0;
				}
				//error calculation
				error = output[i] - actual_answer;
				
				// if actual = desired
				if(output[i] == actual_answer)
				{
					c++;
					dw1 = 0;
					dw2 = 0;
					db = 0;
				}
				// if actual != desired
				else
				{
					// calculate weight changes
					dw1 = (learning_rate*input[i][0]*error);
					dw2 = (learning_rate*input[i][1]*error);
					db = (learning_rate*error);
				}
				//weight updation
				weight1 = weight1 + dw1;
				weight2 = weight2 + dw2;
				bias = bias +db;
				
				System.out.println(input[i][0]+"\t\t"+input[i][1]+"\t\t"+output[i]+"\t\t"+actual_answer+"\t\t"+error+"\t\t"+d.format(weight1)+"\t\t\t"+d.format(weight2)+"\t\t"+d.format(bias));
			}
			if(c == 4)
			{
				break;
			}
			else
			{
				c = 0;
			}
		}
		//display the tables
		System.out.println("________________________________________________________________________________________________");
		System.out.println("WEIGHT 1: " +d.format(weight1));
		System.out.println("WEIGHT 2: " +d.format(weight2));
		System.out.println("BIAS : " +d.format(bias));
		System.out.println("________________________________________________________________________________________________");
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Perceptron_ANN a = new Perceptron_ANN();
		int choice1= 0;
		int choice2= 0;
		do
		{
			System.out.println("__________________________________________MENU__________________________________________________");
			System.out.println("1. AND");
			System.out.println("2. OR");
			System.out.println("0. EXIT");
			System.out.print("ENTER YOUR CHOICE: ");
			choice1 = sc.nextInt();
			System.out.println(" ");
			switch(choice1)
			{
				case 0:
					//exit case
					System.out.println("EXITED SUCCESSFULLY! ");
					break;
				
				case 1: 
					//and gate inputs
					int input[][] = {{0,0},{0,1},{1,0},{1,1}};
					int output[] = {0,0,0,1};	
					System.out.println("AND GATE :");
					a.perceptron_algo(input, output);	
					break;
					
				case 2:
					//or gates input
					int input1[][] = {{0,0},{0,1},{1,0},{1,1}};
					int output1[] = {0,1,1,1};	
					System.out.println("OR GATE :");
					a.perceptron_algo(input1, output1);	
					break;
					
				default: System.out.println("WRONG CHOICE. TRY AGAIN!");
				break;
		}
			System.out.println("PRESS 1 TO CONTINUE.");
			System.out.println("PRESS 0 TO EXIT.");
			choice2=sc.nextInt();
			System.out.println("");
		}while(choice2!=0);
	}
}


/*

__________________________________________MENU__________________________________________________
1. AND
2. OR
0. EXIT
ENTER YOUR CHOICE: 44
 
WRONG CHOICE. TRY AGAIN!
PRESS 1 TO CONTINUE.
PRESS 0 TO EXIT.
1

__________________________________________MENU__________________________________________________
1. AND
2. OR
0. EXIT
ENTER YOUR CHOICE: 1
 
AND GATE :
ENTER FIRST WEIGHT: 
0.1
ENTER SECOND WEIGHT: 
0.5
ENTER BIAS : 
-0.8
ENTER LEARNING RATE : 
0.2
________________________________________________________________________________________________
EPOCH 1
X1	X2    DESIRED	     ACTUAL	ERROR	        WEIGHT1	        WEIGHT2	         BIAS	
0	0	0		0	0		0.1		0.5		-0.8
0	1	0		0	0		0.1		0.5		-0.8
1	0	0		0	0		0.1		0.5		-0.8
1	1	1		0	1		0.3		0.7		-0.6
________________________________________________________________________________________________
EPOCH 2
X1	X2    DESIRED	     ACTUAL	ERROR	        WEIGHT1	        WEIGHT2	         BIAS	
0	0	0		0	0		0.3		0.7		-0.6
0	1	0		1	-1		0.3		0.5		-0.8
1	0	0		0	0		0.3		0.5		-0.8
1	1	1		1	0		0.3		0.5		-0.8
________________________________________________________________________________________________
EPOCH 3
X1	X2    DESIRED	     ACTUAL	ERROR	        WEIGHT1	        WEIGHT2	         BIAS	
0	0	0		0	0		0.3		0.5		-0.8
0	1	0		0	0		0.3		0.5		-0.8
1	0	0		0	0		0.3		0.5		-0.8
1	1	1		1	0		0.3		0.5		-0.8
________________________________________________________________________________________________
WEIGHT 1: 0.3
WEIGHT 2: 0.5
BIAS : -0.8
________________________________________________________________________________________________
PRESS 1 TO CONTINUE.
PRESS 0 TO EXIT.
1

__________________________________________MENU__________________________________________________
1. AND
2. OR
0. EXIT
ENTER YOUR CHOICE: 2
 
OR GATE :
ENTER FIRST WEIGHT: 
0.1
ENTER SECOND WEIGHT: 
0.5
ENTER BIAS : 
-0.8
ENTER LEARNING RATE : 
0.2
________________________________________________________________________________________________
EPOCH 1
X1	X2	DESIRED	     ACTUAL	ERROR	        WEIGHT1		WEIGHT2	        BIAS	
0	0	0		0	0		0.1		0.5		-0.8
0	1	1		0	1		0.1		0.7		-0.6
1	0	1		0	1		0.3		0.7		-0.4
1	1	1		1	0		0.3		0.7		-0.4
________________________________________________________________________________________________
EPOCH 2
X1	X2	DESIRED	     ACTUAL	ERROR	        WEIGHT1	        WEIGHT2	         BIAS	
0	0	0		0	0		0.3		0.7		-0.4
0	1	1		1	0		0.3		0.7		-0.4
1	0	1		0	1		0.5		0.7		-0.2
1	1	1		1	0		0.5		0.7		-0.2
________________________________________________________________________________________________
EPOCH 3
X1	X2	DESIRED	     ACTUAL	ERROR	        WEIGHT1		WEIGHT2	         BIAS	
0	0	0		0	0		0.5		0.7		-0.2
0	1	1		1	0		0.5		0.7		-0.2
1	0	1		1	0		0.5		0.7		-0.2
1	1	1		1	0		0.5		0.7		-0.2
________________________________________________________________________________________________
WEIGHT 1: 0.5
WEIGHT 2: 0.7
BIAS : -0.2
________________________________________________________________________________________________
PRESS 1 TO CONTINUE.
PRESS 0 TO EXIT.
0



*/