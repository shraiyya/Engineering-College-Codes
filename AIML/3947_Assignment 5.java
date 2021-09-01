/*
 NAME : SHREYA CHETAN PAWASKAR
 ROLL NO : 3947
 C-NO : C22018881961
 TITLE : TIC TAC TOE
 */

import java.util.*;

class Node
{
	int value;
	String[][] game_matrix;
	int i, j; 
	int[] player1;
	int[] player2;
	
	//constructor
	Node(int v, String[][] m, int i, int j, int[] p1, int[] p2)
	{
		value = v;
		game_matrix = m;
		this.i = i;
		this.j = j;
		player1 = p1;
		player2 = p2;
	}
}

// for the min case
class MinComparator implements Comparator<Node>
{
	public int compare(Node n1, Node n2)
	{
		if(n1.value == n2.value)
		{
			return 0;
		}
		else if(n1.value > n2.value)
		{
			return -1;
		}
		else 
		{
			return 1;
		}
	}
}


//for the max case
class MaxComparator implements Comparator<Node>
{
	public int compare(Node n1, Node n2)
	{
		if(n1.value == n2.value)
		{
			return 0;
		}
		else if(n1.value > n2.value)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}

public class TicTacToe
{
	Scanner sc = new Scanner(System.in);
	String[][] game_matrix;
	int[] player1; 
	int[] player2;
	
	TicTacToe()
	{
		//create the tic tac toe game board
		game_matrix = new String[3][3];
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				game_matrix[i][j] = new String("-");
			}
		}
		//create 2 arrays for the 2 players
		player1 = new int[8];
		player2 = new int[8];
	}
	
	void print_matrix(String[][] game_matrix)
	{
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				System.out.print(game_matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	int[] addition(int[] score, int i, int j, int point)
	{ 
		score[i] = score[i] + point; 
		score[3 + j] = score[3+j] + point; 
		if(i == j)
		{
			score[6] = score[6] + point;
		}
		if((2-j) == i)
		{
			score[7] = score[7] + point; 
		}
		return score;
	}

	boolean next(boolean p)
	{
		return (p) ? false : true;
	}
	int check_win(int[] p1, int[] p2)
	{
		for(int i=0; i<8; i++)
		{
			if(p1[i] == 3)
			{
				return 1;
			} 
			else if(p2[i] == -3)
			{
				return -1; 
			}
		}
		return 0;
	}
	
	boolean check_draw(String[][] game_matrix, int[] player1, int[] player2)
	{
		if(check_win(player1, player2)!=0) 
		{
			return false;
		}
		
		else
		{
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
				{
					if(game_matrix[i][j].equals("-"))
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	

	Node Min_Max_Algo(boolean play, String[][] game_matrix, int x, int y, int[] player1, int[] player2)
	{
		int value = check_win(player1, player2);
		
		//check for the draw case
		if(check_draw(game_matrix, player1, player2))
		{ 
			return new Node(0,game_matrix, x, y, player1, player2); 
		}
		if(value != 0)
		{
		 	return new Node(value,game_matrix, x, y, player1, player2); 
		}
		
		
		PriorityQueue<Node> priority_queue1;
		
		if(play)
		{
			priority_queue1 = new PriorityQueue<Node>(9, new MaxComparator());
		}
		else
		{
			priority_queue1 = new PriorityQueue<Node>(9, new MinComparator());
		}
		
		String[][] new_matrix1 = new String[3][3];
		int[] new_player1;
		int[] new_player2;
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(game_matrix[i][j].equals("-"))
				{
					for(int k=0; k<3; k++)
					{
						System.arraycopy(game_matrix[k], 0, new_matrix1[k], 0, game_matrix[k].length);	
					}	
					new_player1 = new int[8];
					new_player2 = new int[8];	
					System.arraycopy(player1, 0, new_player1, 0, player1.length);
					System.arraycopy(player2, 0, new_player2, 0, player2.length);
					if(play)
					{
						new_matrix1[i][j] = "X";
						new_player1 = addition(new_player1, i, j, 1);
					}
					else
					{
						new_matrix1[i][j] = "O"; 
						new_player2 = addition(new_player2, i, j, -1);
					}
					priority_queue1.add(Min_Max_Algo(next(play), new_matrix1, i, j, new_player1, new_player2));	
				}
			}
		}
		return priority_queue1.remove(); 
	}
	
	void play()
	{
		//set the initial value of play -> true
		boolean play = true;
		
		int num = 9, i=0, j=0, win=0;		
	    
		//print the blank matrix
		print_matrix(game_matrix);
				
		while(num-->0)
		{
			if(play)
			{ 
				System.out.println("");
				//ask the human user for the first turn
				System.out.println("YOUR TURN: ");
				while(true)
				{
					//input i
					System.out.print("ENTER I POSITION - ");
					i = sc.nextInt();
					
					//input j
					System.out.print("ENTER J POSITION - ");
					j = sc.nextInt();
					if(i>0 && j>0 && i<4 && j<4 && game_matrix[i-1][j-1].equals("-"))
					{
						i--;
						j--;
						//set the matrix element to X
						game_matrix[i][j] = "X";
						break;
					}					
					else
					{
						//if the user enters wrong values or filled matrix element
						System.out.println("\nINVALID ith & jth POSITION!");
					}
				}
			}
			else
			{
				System.out.println("COMPUTER'S TURN: ");
				Node n = Min_Max_Algo(false, game_matrix, 0, 0, player1, player2);
				i = n.i;
				j = n.j;
				
				//set matrix element = O
				game_matrix[i][j] = "O";
			}
				
			if(play)
			{ 
				addition(player1, i, j, 1);
				play = false;
			}
			else
			{
				addition(player2, i, j, -1);
				play = true;
			}
			
			// check if any player one
			win = check_win(player1, player2);
			if(win!=0)
			{
				//first case when player one wins
				if(win==1)
				{
					System.out.println("CONGRATULATIONS! YOU WON!");
				}
				//when player 2 wins
				if(win==2)
				{
					System.out.println("COMPUTER WON!");
				}
				print_matrix(game_matrix);
				break;
			}
			//print the empty matrix
			print_matrix(game_matrix);
			System.out.println();
		}
		
		if(num == 0)
		{
			System.out.println("IT IS A DRAW!");
		}
	}

	public static void main(String[] args) 
	{
		Scanner sc =  new Scanner(System.in);
		System.out.println("PLAYER 1 (YOU) = 'X' ");
		System.out.println("PLAYER 2 (COMPUTER) = 'O' ");
		int ans=1;
		// do while loop for menu
		do {
		TicTacToe t = new TicTacToe();
		t.play();
		System.out.println("DO YOU WANT TO CONTINUE? PRESS 1 TO CONTINUE AND 0 TO EXIT");
		ans=sc.nextInt();
		System.out.println("");
		}while(ans!=0);
	}
}

/* 

OUTPUT:
PLAYER 1 (YOU) = 'X' 
PLAYER 2 (COMPUTER) = 'O' 
- - - 
- - - 
- - - 

YOUR TURN: 
ENTER I POSITION - 1
ENTER J POSITION - 3
- - X 
- - - 
- - - 

COMPUTER'S TURN: 
- - X 
- - - 
O - - 


YOUR TURN: 
ENTER I POSITION - 2
ENTER J POSITION - 3
- - X 
- - X 
O - - 

COMPUTER'S TURN: 
- - X 
- - X 
O - O 


YOUR TURN: 
ENTER I POSITION - 2
ENTER J POSITION - 2
- - X 
- X X 
O - O 

COMPUTER'S TURN: 
- - X 
- X X 
O O O 
DO YOU WANT TO CONTINUE? PRESS 1 TO CONTINUE AND 0 TO EXIT
1

- - - 
- - - 
- - - 

YOUR TURN: 
ENTER I POSITION - 3
ENTER J POSITION - 1
- - - 
- - - 
X - - 

COMPUTER'S TURN: 
- - - 
O - - 
X - - 


YOUR TURN: 
ENTER I POSITION - 3
ENTER J POSITION - 2
- - - 
O - - 
X X - 

COMPUTER'S TURN: 
- - - 
O O - 
X X - 


YOUR TURN: 
ENTER I POSITION - 3
ENTER J POSITION - 3
CONGRATULATIONS! YOU WON!
- - - 
O O - 
X X X 
DO YOU WANT TO CONTINUE? PRESS 1 TO CONTINUE AND 0 TO EXIT
1

- - - 
- - - 
- - - 

YOUR TURN: 
ENTER I POSITION - 1
ENTER J POSITION - 3
- - X 
- - - 
- - - 

COMPUTER'S TURN: 
- - X 
- - - 
O - - 


YOUR TURN: 
ENTER I POSITION - 2
ENTER J POSITION - 2
- - X 
- X - 
O - - 

COMPUTER'S TURN: 
- - X 
O X - 
O - - 


YOUR TURN: 
ENTER I POSITION - 1
ENTER J POSITION - 1
X - X 
O X - 
O - - 

COMPUTER'S TURN: 
X - X 
O X - 
O - O 


YOUR TURN: 
ENTER I POSITION - 3
ENTER J POSITION - 2
X - X 
O X - 
O X O 

COMPUTER'S TURN: 
X O X 
O X - 
O X O 


YOUR TURN: 
ENTER I POSITION - 1
ENTER J POSITION - 1

INVALID ith & jth POSITION!
ENTER I POSITION - 2
ENTER J POSITION - 3
X O X 
O X X 
O X O 

DO YOU WANT TO CONTINUE? PRESS 1 TO CONTINUE AND 0 TO EXIT
0


*/
