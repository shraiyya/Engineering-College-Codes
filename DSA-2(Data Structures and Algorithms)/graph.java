/*
 * SHREYA CHETAN PAWASKAR
 * ROLL NO-2939
 * BATCH -C3
 * SY COMP DIVISION C
 */

import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import java.util.*;
class node
{
	int hno;
	node(int h)
	{
		hno=h;
	}
}

class graphclass{
	Scanner sc=new Scanner(System.in);
	int v,e;
	int matrix[][]=new int[20][20];
	LinkedList<Integer> l1[];
	 
     void createlist(int v,int e)// create adjacency list
     {
    	 l1 =new LinkedList[20];
    	 for(int i = 0; i < 20 ; i++){ 
             l1[i] = new LinkedList<>(); 
         } 
    	 for(int i=0;i<e;i++)
			{
    		 
    	 System.out.println("Enter Vertices for edges");
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			l1[v1].add(v2); 
	        l1[v2].add(v1); 
	        System.out.println(" ");
			}
	 }
     
     void displaylist(int v) //to display the adjacency list
     {
    	 System.out.println(" ");
    	 
    	 for (int i = 0; i <20 ; i++) {

             if(l1[i].size()>0) {

                 System.out.print("Vertex " + i + " is connected to: ");

                 for (int j = 0; j < l1[i].size(); j++) {

                     System.out.print(l1[i].get(j) + " ");

                 }

                 System.out.println();

             }

         }
	 }
     
     
     void bfslist(int v,int s)  //bfs traversal using a queue
     {
    	 boolean visited[] = new boolean[20]; 
    	  
         // Create a queue for BFS 
         LinkedList<Integer> queue = new LinkedList<Integer>(); 
   
         // Mark the current node as visited and enqueue it 
         visited[s]=true; 
         queue.add(s); 
   
         while (queue.size() != 0) 
         { 
             // Dequeue a vertex from queue and print it 
             s = queue.poll(); 
             System.out.print(s+" "); 
   
             // Get all adjacent vertices of the dequeued vertex s 
             // If a adjacent has not been visited, then mark it 
             // visited and enqueue it 
             Iterator<Integer> i = l1[s].listIterator(); 
             while (i.hasNext()) 
             { 
                 int n = i.next(); 
                 if (!visited[n]) 
                 { 
                     visited[n] = true; 
                     queue.add(n); 
                 } 
             } 
         }
     }
     
     
     
     
     void createMatrix()//create a adjacency matrix
 	{
    	
 		System.out.println("ENTER NUMBER OF VERTICES");
 		v=sc.nextInt();
 		System.out.println("ENTER NUMBER OF EDGES");
 		e=sc.nextInt();
 		for(int i=0;i<e;i++)
 		{
 			System.out.println("Enter Vertices for edges");
 			int v1=sc.nextInt();
 			int v2=sc.nextInt();
 			matrix[v1-1][v2-1]=1;
 			matrix[v2-1][v1-1]=1;
 			System.out.println(" ");
 		}
 		displaymat(v);
 		DFS();
 	}
     
     void displaymat(int v) //display adjacency matrix
	 {
		 System.out.print("  ");
			for(int i=0;i<v;i++)
				System.out.print((i+1)+"   ");
			System.out.println(" ");
			System.out.println("______________________________________________");		
			for(int i=0;i<v;i++)
			{
				System.out.print((i+1)+"|  ");
				for(int j=0;j<v;j++)
				{
					System.out.print(matrix[i][j]+"   ");
				}
				System.out.println("  ");
			}	
			System.out.println("  ");
	 }
     
     
     void DFS() //Dfs traversal of the  adjacency matrix
 	{
 		int visited[]=new int[v];
 		System.out.println("Enter starting house number");
 		int start=sc.nextInt();
 		visited[start-1]=1;
 		System.out.println("DFS Traversal:");
 		System.out.print((start)+" ");
 		DFSmat(start-1,visited);
 		System.out.println(" ");
 	}
 	
 	void DFSmat(int hno,int visited[])
 	{
 		for(int j=0;j<v;j++)
 		{
 			if(matrix[hno][j]==1 && visited[j]!=1)
 			{
 				System.out.print((j+1)+" ");
 				visited[j]=1;
 				DFSmat(j,visited);
 			}
 		}
 	}
}

public class graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s1=new Scanner(System.in);
		 int choice=0;
	     graphclass g =new graphclass();
	     do
			{
	    	    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("PRESS 1 TO BFS TRAVERSAL (ADJACENCY LIST)");
				System.out.println("PRESS 2 TO DFS TRAVERSAL (ADJACENCY MATRIX)");
				System.out.println("PRESS 0 TO EXIT");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("  "); 
				choice=s1.nextInt();
				 switch(choice)
				 {
				 case 1:
					 System.out.println("ENTER NUMBER OF VERTICES");
						int v1=s1.nextInt();
						System.out.println("ENTER NUMBER OF EDGES");
						int e1=s1.nextInt();
					    g.createlist(v1,e1);
					    System.out.println("THE GRAPH IN THE FORM OF ADJACENCY LIST :-");
                       g.displaylist(v1);
                       System.out.println(" ");
                       System.out.println("ENTER S AS THE SOURCE");
                       int s0=s1.nextInt();
                        g.bfslist(v1, s0);
					    System.out.println(" ");
						break;
				 case 2:
					     g.createMatrix();
						System.out.println(" ");
						break;
				 }
				 
			}while(choice!=0);
		
		}
}

/*
 -------------------------------------------------------------------------------------------------------------------------------------
PRESS 1 TO BFS TRAVERSAL (ADJACENCY LIST)
PRESS 2 TO DFS TRAVERSAL (ADJACENCY MATRIX)
PRESS 0 TO EXIT
-------------------------------------------------------------------------------------------------------------------------------------
  
1
ENTER NUMBER OF VERTICES
7
ENTER NUMBER OF EDGES
6
Enter Vertices for edges
2
4
 
Enter Vertices for edges
5
1
 
Enter Vertices for edges
1
3
 
Enter Vertices for edges
6
4
 
Enter Vertices for edges
2
5
 
Enter Vertices for edges
1
4
 
THE GRAPH IN THE FORM OF ADJACENCY LIST :-
 
Vertex 1 is connected to: 5 3 4 
Vertex 2 is connected to: 4 5 
Vertex 3 is connected to: 1 
Vertex 4 is connected to: 2 6 1 
Vertex 5 is connected to: 1 2 
Vertex 6 is connected to: 4 
 
ENTER S AS THE SOURCE
2
2 4 5 6 1 3  
-------------------------------------------------------------------------------------------------------------------------------------
PRESS 1 TO BFS TRAVERSAL (ADJACENCY LIST)
PRESS 2 TO DFS TRAVERSAL (ADJACENCY MATRIX)
PRESS 0 TO EXIT
-------------------------------------------------------------------------------------------------------------------------------------
  
2
ENTER NUMBER OF VERTICES
6
ENTER NUMBER OF EDGES
5
Enter Vertices for edges
1
3
 
Enter Vertices for edges
4
2
 
Enter Vertices for edges
5
3
 
Enter Vertices for edges
3
1
 
Enter Vertices for edges
2
5
 
  1   2   3   4   5   6    
______________________________________________
1|  0   0   1   0   0   0     
2|  0   0   0   1   1   0     
3|  1   0   0   0   1   0     
4|  0   1   0   0   0   0     
5|  0   1   1   0   0   0     
6|  0   0   0   0   0   0     
  
Enter starting house number
1
DFS Traversal:
1 3 5 2 4  
 
-------------------------------------------------------------------------------------------------------------------------------------
PRESS 1 TO BFS TRAVERSAL (ADJACENCY LIST)
PRESS 2 TO DFS TRAVERSAL (ADJACENCY MATRIX)
PRESS 0 TO EXIT
-------------------------------------------------------------------------------------------------------------------------------------
  
0

*/
