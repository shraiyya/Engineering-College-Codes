/*
 NAME : SHREYA CHETAN PAWASKAR
 ROLL NO : 3947
 C-NO : C22018881961
 TITLE : BFS DFS ON A GRAPH
 DIVISION : C
 */

package assignment_1;

import java.util.*;

class Graphs
{
	Scanner sc = new Scanner(System.in);
	int cost_matrix[][] = new int[30][30];
	int v, e;
	
	public void create_matrix()
	{	
		System.out.println(" ");
		System.out.print("ENTER NUMBER OF VERTICES : ");
		v = sc.nextInt();
		System.out.print("ENTER NUMBER OF EDGES : ");
		e = sc.nextInt();
		
		for(int i=0; i<v; i++)
		{
			for(int j=0; j<v; j++)
			{
				cost_matrix[i][j]=0;
			}
		}
		System.out.println("");
		for(int i=0; i<e; i++)
		{
			int start,destination;
			System.out.print("ENTER SOURCE : ");
			start = sc.nextInt();
			System.out.print("ENTER DESTINATION : ");
			destination = sc.nextInt();
			cost_matrix[start][destination] = 1;
			cost_matrix[destination][start] = 1;
			
		}
		System.out.println("");
	}
	
	public void bfs_traversal()
	{
		int i=1,j;
		int node;
		int visited_array[] = new int[20];
		Queue<Integer> queue1 = new LinkedList<Integer>();
		for(i=1;i<=v;i++)
		{
			visited_array[i]=0;
		}

		System.out.println("ENTER SOURCE VERTEX");
		int start=sc.nextInt();
		queue1.add(start);
		visited_array[start]=1;
		while(queue1.isEmpty()==false)
		{
			node=queue1.remove();
			System.out.print("  "+node);
			for(i=1;i<=v;i++)
			{
				if(cost_matrix[node][i]==1 && visited_array[i]==0)
				{
					queue1.add(i);
					visited_array[i]=1;
				}
			}
		}
	}
	
	
	public void dfs_traversal()
	{
		int i=1,j;
		int node;
		int visited_array[] = new int[20];
		Stack<Integer> stack1 = new Stack<Integer>();
		for(i=1;i<=v;i++)
		{
			visited_array[i]=0;
		}
		System.out.println("ENTER SOURCE VERTEX : ");
		int start=sc.nextInt();
		stack1.push(start);
		visited_array[start]=1;
		
		while(stack1.isEmpty()==false)
		{
			node=stack1.pop();
			System.out.print("  "+node);
			for(i=1;i<=v;i++)
			{
				if(cost_matrix[node][i]==1 && visited_array[i]==0)
				{
					stack1.push(i);
					visited_array[i]=1;
				}
			}
		}
	}
	
	
	
}

public class Dfs_Bfs
{
	
	public static void main(String[] args)
	{
		Graphs graph1 = new Graphs();
		Scanner sc = new Scanner(System.in);
		int ans=1;
		int choice=0;
		do
		{
			System.out.println("MENU:");
			System.out.println("PRESS 1 TO CREATE THE GRAPH");
			System.out.println("PRESS 2 TO BFS TRAVERSAL");
			System.out.println("PRESS 3 TO DFS TRAVERSAL");
			System.out.println("PRESS 4 TO EXIT");
			System.out.println("ENTER THE CHOICE");	
			choice = sc.nextInt();
			System.out.println("");
			switch(choice)
			{				
				case 1:
					graph1.create_matrix();
					System.out.println("");
					break;
					
				case 2:
					System.out.println("BFS TRAVERSAL :");
					graph1.bfs_traversal();
					System.out.println("");
					break;
					
				case 3:
					System.out.println("DFS TRAVERSAL : ");
					graph1.dfs_traversal();
					System.out.println("");
					break;
				case 4: //exit
					System.out.println("EXITED SUCCESSFULLY!");
					System.out.println("");
					break;
			}
		}while(ans!=0);
	}

}



/*

MENU:
PRESS 1 TO CREATE THE GRAPH
PRESS 2 TO BFS TRAVERSAL
PRESS 3 TO DFS TRAVERSAL
PRESS 4 TO EXIT
ENTER THE CHOICE
1

 
ENTER NUMBER OF VERTICES : 7
ENTER NUMBER OF EDGES : 9

ENTER SOURCE : 1
ENTER DESTINATION : 2
ENTER SOURCE : 1
ENTER DESTINATION : 4
ENTER SOURCE : 4
ENTER DESTINATION : 3
ENTER SOURCE : 3
ENTER DESTINATION : 5
ENTER SOURCE : 3
ENTER DESTINATION : 6
ENTER SOURCE : 3
ENTER DESTINATION : 2
ENTER SOURCE : 7
ENTER DESTINATION : 2
ENTER SOURCE : 7
ENTER DESTINATION : 5
ENTER SOURCE : 4
ENTER DESTINATION : 2


MENU:
PRESS 1 TO CREATE THE GRAPH
PRESS 2 TO BFS TRAVERSAL
PRESS 3 TO DFS TRAVERSAL
PRESS 4 TO EXIT
ENTER THE CHOICE
2

BFS TRAVERSAL :
ENTER SOURCE VERTEX
1
1	2	4	3	7	5	6

MENU:
PRESS 1 TO CREATE THE GRAPH
PRESS 2 TO BFS TRAVERSAL
PRESS 3 TO DFS TRAVERSAL
PRESS 4 TO EXIT
ENTER THE CHOICE
3

DFS TRAVERSAL : 
ENTER SOURCE VERTEX : 
3
3	6	5	7	4	1	2

MENU:
PRESS 1 TO CREATE THE GRAPH
PRESS 2 TO BFS TRAVERSAL
PRESS 3 TO DFS TRAVERSAL
PRESS 4 TO EXIT
ENTER THE CHOICE


*/