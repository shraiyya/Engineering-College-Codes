/*
 NAME : SHREYA CHETAN PAWASKAR
 ROLL NO : 3947
 C-NO : C22018881961
 TITLE : BEST FIRST SEARCH ALGORITHM
 */


import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;
 
public class BestFirstSearch
{
    private static Scanner sc;
	private PriorityQueue<Vertex> pqueue;
    private int heuristic_values[];
    private int numberOfNodes;
 
    public static final int MAX_VALUE = 999999;
 
    public BestFirstSearch(int numberOfNodes)
    {
        this.numberOfNodes = numberOfNodes;
        this.pqueue = new PriorityQueue<Vertex>(this.numberOfNodes,new Vertex());
    }
 
    public void bfs(int mat[][], int[] heuristic_values,int start, int end)
    {
        int temp_node;
        int dest;
        int visited[] = new int [numberOfNodes + 1];
        this.heuristic_values = heuristic_values;
 
        pqueue.add(new Vertex(start, this.heuristic_values[start]));
        visited[start] = 1;
 
        while (!pqueue.isEmpty())//till priority queue is not empty
        {
        temp_node = get_min();
        if(temp_node == end)
        {
        System.out.print(temp_node + "\t");
        break;
        }
        dest = 1;
 
        System.out.print(temp_node + "\t");			
        while (dest <= numberOfNodes)
        {
            Vertex v = new Vertex(dest,this.heuristic_values[dest]);
            if ((mat[temp_node][dest] != MAX_VALUE 			                               
                  && temp_node != dest)&& visited[dest] == 0)
            {
                pqueue.add(v);
                visited[dest] = 1;
            }
            dest++;
        }
        }
    }
 
    private int get_min()//find out minimum heuristic value node
    {
        Vertex vertex = pqueue.remove();//if it is found then remove that node from queue
        return vertex.node;
    }
    class Vertex implements Comparator<Vertex>//compare the heuristic value
    {
        public int heuristic_values;
        public int node;
     
        public Vertex(int node, int heuristic_values)
        {
        this.heuristic_values = heuristic_values;
        this.node = node;
        }
     
        public Vertex()
        {
     
        } 
     
        public int compare(Vertex v1, Vertex v2)//compare the heuristic value
        {
        if (v1.heuristic_values < v2.heuristic_values)
            return -1;
        if (v1.heuristic_values > v2.heuristic_values)
            return 1;
        return 0;
        }
     
        @Override
        public boolean equals(Object obj)//if both vertex has same heuristic value
        {
        if (obj instanceof Vertex)
        {
            Vertex node = (Vertex) obj;
            if (this.node == node.node)
            {
                return true;
            }
        }
        return false;
        }
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	
        int matrix[][];
        int v=0;
        int e=0;
        int start = 0;
        int end = 0;
        int heuristic_values[];
 
        Scanner sc = new Scanner(System.in);
       	System.out.print("ENTER THE TOTAL NUMBER OF VERTICES : ");
        v=sc.nextInt();
        
        System.out.print("ENTER TOTAL NUMBER OF EDGES : ");
        e=sc.nextInt();
        
        matrix = new int[v + 1][v + 1];
        heuristic_values = new int[v + 1];
 
        
        System.out.println(" ");
    	System.out.println("ENTER THE 2 VERTICES AND THEIR COST");	
    		for(int i=1; i<e+1; i++)
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
    		
    		for(int i=1; i<=v; i++)
    		{
    			for(int j=1; j<=v; j++)
    				System.out.print(matrix[i][j]+" ");
    			System.out.println();
    		}
    		System.out.println(" ");
    		
    		
    		for (int i = 1; i <= v; i++)
        {
            for (int j = 1; j <= v; j++)
            {
            if (matrix[i][j] == 0)
                {
                matrix[i][j] = MAX_VALUE;
                }
            }
        }
    		 		
    		
    		System.out.println(" ");
        System.out.println("ENTER HEURISTIC VALUES");
        for (int vertex = 1; vertex <= v; vertex++)
        {
            System.out.print(vertex + " - ");
            heuristic_values[vertex] = sc.nextInt();
            System.out.println();
        }
 
        System.out.println(" ");
        System.out.println("ENTER THE SOURCE");
        start = sc.nextInt();
        
        System.out.println(" ");
        System.out.println("ENTER THE DESTINATION");
        end = sc.nextInt();
        
        System.out.println(""); 
        BestFirstSearch graph = new BestFirstSearch(v);
        graph.bfs(matrix, heuristic_values,start,end);

       sc.close();
   }
}
 
/*
ENTER THE TOTAL NUMBER OF VERTICES : 5
ENTER TOTAL NUMBER OF EDGES : 5
 
ENTER THE 2 VERTICES AND THEIR COST
ENTER THE START VERTICE : 1
ENTER THE ENDING VERTICE : 2
ENTER THE COST OF THE EDGE : 5
 
ENTER THE START VERTICE : 1
ENTER THE ENDING VERTICE : 3
ENTER THE COST OF THE EDGE : 1
 
ENTER THE START VERTICE : 2
ENTER THE ENDING VERTICE : 5
ENTER THE COST OF THE EDGE : 1
 
ENTER THE START VERTICE : 3
ENTER THE ENDING VERTICE : 4
ENTER THE COST OF THE EDGE : 2
 
ENTER THE START VERTICE : 4
ENTER THE ENDING VERTICE : 5
ENTER THE COST OF THE EDGE : 2
 
0 5 1 0 0 
5 0 0 0 1 
1 0 0 2 0 
0 0 2 0 2 
0 1 0 2 0 
 
 
ENTER HEURISTIC VALUES
1 - 5

2 - 1

3 - 4

4 - 2

5 - 0

 
ENTER THE SOURCE
1
 
ENTER THE DESTINATION
5

1	2	5	
*/
