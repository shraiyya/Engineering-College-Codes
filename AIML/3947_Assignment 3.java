/*
 NAME : SHREYA CHETAN PAWASKAR
 ROLL NO : 3947
 C-NO : C22018881961
 TITLE : A STAR ALGORITHM
 */

import java.util.*;

class Node
{
	int cost;
	int data;
	int heuristic_valuesr;
	int value;

	Node(int d, int h, int c, int v)
	{
		heuristic_valuesr = h;
		data = d;
		cost = c;	
		value = v;
	}
}

class Heuristic_Comparator implements Comparator<Node>
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

public class AstarAlgorithm
{
	Scanner sc = new Scanner(System.in);	
	int[][] matrix; 
	int ver;
	int ed;
	int visited_array[];
	int[] heuristic_values;
	ArrayList<Integer> path;

	AstarAlgorithm(int v, int e)
	{
		
		ver = v+1;
		ed = e+1;
		matrix = new int[ver][ver];
		for(int i=0; i<ver; i++)
		{
			matrix[i] = new int[ver];
		}
		visited_array = new int[ver];
		path = new ArrayList<Integer>();
		heuristic_values = new int[ver];
	
	}

	
	void create_matrix()
	{
		System.out.println(" ");
		System.out.println("ENTER THE 2 VERTICES AND THEIR COST");
		System.out.println(" ");
		for(int i=1; i<ed; i++)
		{
			System.out.print("ENTER THE START VERTICE : ");
			int a = sc.nextInt();
			System.out.print("ENTER THE ENDING VERTICE : ");
			int b = sc.nextInt();
			System.out.print("ENTER THE COST OF THE EDGE : ");
			int cost = sc.nextInt();
			matrix[a][b] = cost;
			matrix[b][a] = cost;
			System.out.println(" ");
		}
		System.out.println(" ");
	}	
	
	
	void display_matrix()
	{
		for(int i=1; i<ver; i++)
		{
			for(int j=1; j<ver; j++)
				System.out.print(matrix[i][j]+" ");
			System.out.println();
		}
		System.out.println(" ");
	}
	
	void get_heuristics()
	{
		System.out.println(" ");
		System.out.println("ENTER HEURISTIC VALUES : ");
		for(int i=1; i<ver; i++)
		{
			heuristic_values[i] = sc.nextInt();
		}
		System.out.println();

	}
	void astar(int start, int goal)
	{
		int sum=0;
		PriorityQueue<Node> pqueue = new PriorityQueue<Node>(ver, new Heuristic_Comparator()); 
		for(int i=0; i<ver; i++)
		{
			visited_array[i] = 0;
		}
		pqueue.add(new Node(start,heuristic_values[1],0,heuristic_values[1]+0));
		visited_array[start] = 1;
		while(!pqueue.isEmpty())
		{
			Node n = pqueue.remove();
			path.add(n.data);
			if(n.data==goal) 
			{
				break;
			}
			else
			{
				for(int i=0; i<ver; i++)
				{
					if(matrix[n.data][i]!=0 && visited_array[i]!=1)
					{
						visited_array[i] = 1;
						int dist = heuristic_values[i]+matrix[n.data][i]+n.cost;
						pqueue.add(new Node(i,heuristic_values[i],matrix[n.data][i],dist));
					}
				}
			}
	}
	int i=0;
	System.out.println("\nTHE PATH FOLLOWED IS : "+path);
	while(i<path.size()-1)
	{
		if(matrix[path.get(i)][path.get(i+1)]!=0)
		{
			sum=sum+matrix[path.get(i)][path.get(i+1)];
			i++;
		}
		else
		{
			sum=sum-matrix[path.get(i-1)][path.get(i)];
			path.remove(i);
			i=0;
		}
	}
	System.out.println("THE TOTAL COST OF THE PATH : "+sum);
	}



public static void main(String[] args) 
{
	Scanner sc =  new Scanner(System.in);
	
	System.out.print("ENTER THE TOTAL NUMBER OF VERTICES : ");
	int v=sc.nextInt();
	System.out.print("ENTER TOTAL NUMBER OF EDGES : ");
	int e=sc.nextInt();
        System.out.println(" ");
	
	AstarAlgorithm A = new AstarAlgorithm(v,e);
	A.get_heuristics();
	A.create_matrix();
	A.display_matrix();
	
	System.out.print("ENTER THE SOURCE : ");
	int start = sc.nextInt();
        System.out.println(" ");
	System.out.print("ENTER THE DESTINATION : ");
	int goal = sc.nextInt();
	
	A.astar(start,goal);
}

}

/*

OUTPUT:

ENTER THE TOTAL NUMBER OF VERTICES : 4
ENTER TOTAL NUMBER OF EDGES : 6

ENTER HEURISTIC VALUES : 
1
3
6
2

ENTER THE 2 VERTICES AND THEIR COST

ENTER THE START VERTICE : 1
ENTER THE ENDING VERTICE : 2
ENTER THE COST OF THE EDGE : 5

ENTER THE START VERTICE : 2
ENTER THE ENDING VERTICE : 3
ENTER THE COST OF THE EDGE : 9

ENTER THE START VERTICE : 3
ENTER THE ENDING VERTICE : 4
ENTER THE COST OF THE EDGE : 11

ENTER THE START VERTICE : 4
ENTER THE ENDING VERTICE : 1
ENTER THE COST OF THE EDGE : 17

ENTER THE START VERTICE : 2
ENTER THE ENDING VERTICE : 4
ENTER THE COST OF THE EDGE : 11

ENTER THE START VERTICE : 1
ENTER THE ENDING VERTICE : 3
ENTER THE COST OF THE EDGE : 6

0  5  6 17 
5  0  9 11 
6  9  0 11 
17 11 11 0 

ENTER THE SOURCE : 1

ENTER THE DESTINATION : 4

THE PATH FOLLOWED IS : [1, 2, 3, 4]
THE TOTAL COST OF THE PATH : 25

*/