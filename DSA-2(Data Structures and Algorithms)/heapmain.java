/*
 * SHREYA CHETAN PAWASKAR
 * ROLL NO-2939
 * BATCH -C3
 * SY COMP DIVISION C
 * Assignment- Implementation of heap.
 */

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

class heap //max-heap
{
	private static final int d = 2;
	private int[] arr1;
	private int heapSize;
    //This will initialize our heap with default size.
	 
	public heap(int capacity) {
		heapSize = 0;
		arr1 = new int[capacity + 1];
		Arrays.fill(arr1, -1);

	}

	//This will check if the heap is empty or not 
	public boolean isEmpty() {
		return heapSize == 0;
	}

	//to check if heap is full or not
	public boolean isFull() {
		return heapSize == arr1.length;
	}

	private int parent(int i) {
		return (i - 1) / d;
	}

	private int kthChild(int i, int k) {
		return d * i + k;
	}

	//This will insert new element in to heap Complexity: O(log N) As worst case scenario, we need to traverse till the root
	public void insert(int x) {
		if (isFull())
			throw new NoSuchElementException("Heap is full, No space to insert new element");
		arr1[heapSize++] = x;
		heapifyUp(heapSize - 1);
	}


	public int delete(int x) //This will delete element at index x 
{
		if (isEmpty())
			throw new NoSuchElementException("Heap is empty, No element to delete");
		int key = arr1[x];
		arr1[x] = arr1[heapSize - 1];
		heapSize--;
		heapifyDown(x);
		return key;
	}
	
	 private void heapifyUp(int i) // This method used to maintain the heap property while inserting an element.
	 {
		int temp = arr1[i];
		while (i > 0 && temp > arr1[parent(i)]) {
			arr1[i] = arr1[parent(i)];
			i = parent(i);
		}
		arr1[i] = temp;
	}

	
     private void heapifyDown(int i) // This method used to maintain the heap property while deleting an element.
     {
		int child;
		int temp = arr1[i];
		while (kthChild(i, 1) < heapSize) {
			child = maxChild(i);
			if (temp < arr1[child]) {
				arr1[i] = arr1[child];
			} else
				break;
			i = child;
		}
		arr1[i] = temp;
	}

	private int maxChild(int i) {
		int leftChild = kthChild(i, 1);
		int rightChild = kthChild(i, 2);
		return arr1[leftChild] > arr1[rightChild] ? leftChild : rightChild;
	}

	public void printHeap() //This method used to print all element of the heap
	 
	{
		
		for (int i = 0; i < heapSize; i++)
			System.out.print(arr1[i] + " ");
		System.out.println();
	}
	
	void heapify(int arr[], int n, int i) 
	{
		   int temp;
		   int largest = i;
		   int l = 2 * i + 1;
		   int r = 2 * i + 2;
		   if (l < n && arr[l] > arr[largest])
		      largest = l;
		   if (r < n && arr[r] > arr[largest])
		      largest = r;
		   if (largest != i) {
		      temp = arr[i];
		      arr[i] = arr[largest];
		      arr[largest] = temp;
		      heapify(arr, n, largest);
		   }
		}
		void heapSort(int arr[], int n) {
		   int temp;
		   for (int i = n / 2 - 1; i >= 0; i--)
		      heapify(arr, n, i);
		   for (int i = n - 1; i >= 0; i--) {
		      temp = arr[0];
		      arr[0] = arr[i];
		      arr[i] = temp;
		      heapify(arr, i, 0);
		   }
		}
	 void sort1()
	 {
		 heapSort(arr1, heapSize);
	 }
    
}
public class heapmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s1 = new Scanner(System.in);
		int choice = 0;
		int a1 = 0;
		System.out.println("ENTER THE SIZE OF HEAP");
		a1=s1.nextInt();
		System.out.println(" ");
		heap a = new heap(a1);
		int yn = 0;
		do {
			System.out.println("PRESS 1 TO CREATE ");
			System.out.println("PRESS 2 TO ADD ");
			System.out.println("PRESS 3 TO DELETE ");
			System.out.println("PRESS 4 TO DISPLAY");
			System.out.println("PRESS 5 TO SORT");
			System.out.println("PRESS 0 TO EXIT");
			System.out.println("  ");
			choice = s1.nextInt();
			switch (choice) {
			case 1:
				do {
					System.out.println("ENTER THE NUMBER TO BE ADDED");
					int k = 0;
					k = s1.nextInt();
					a.insert(k);
					System.out.println("DO YOU WANT TO CONTINUE?(1=YES /2=N0)");
					yn = s1.nextInt();
				} while (yn != 2);
				break;
			case 2:
				System.out.println("ENTER THE  NEW NUMBER TO BE ADDED");
				int k = 0;
				k = s1.nextInt();
				a.insert(k);
				System.out.print("NEW HEAP = ");
				a.printHeap();
				System.out.println(" ");
				break;
			case 3:
				System.out.println("ENTER THE INDEX OF THE NUMBER TO BE DELETED");
				int q0 = 0;
				q0 = s1.nextInt();
				a.delete(q0);
				System.out.print("NEW HEAP = ");
				a.printHeap();
				System.out.println(" ");
				break;
			case 4:
				System.out.print("HEAP = ");
				a.printHeap();
				System.out.println(" ");
				break;
			case 5:
				System.out.print("SORTED HEAP = ");
				a.sort1();
				a.printHeap();
				System.out.println(" ");
				break;

			}

		} while (choice != 0);

	}

}
/*
ENTER THE SIZE OF HEAP
20

PRESS 1 TO CREATE 
PRESS 2 TO ADD 
PRESS 3 TO DELETE 
PRESS 4 TO DISPLAY
PRESS 5 TO SORT
PRESS 0 TO EXIT
  
1
ENTER THE NUMBER TO BE ADDED
17
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
1
ENTER THE NUMBER TO BE ADDED
25
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
1
ENTER THE NUMBER TO BE ADDED
3
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
1
ENTER THE NUMBER TO BE ADDED
1
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
1
ENTER THE NUMBER TO BE ADDED
0
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
1
ENTER THE NUMBER TO BE ADDED
1008
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
2
PRESS 1 TO CREATE 
PRESS 2 TO ADD 
PRESS 3 TO DELETE 
PRESS 4 TO DISPLAY
PRESS 5 TO SORT
PRESS 0 TO EXIT
  
4
HEAP = 1008 17 25 1 0 3 
 
PRESS 1 TO CREATE 
PRESS 2 TO ADD 
PRESS 3 TO DELETE 
PRESS 4 TO DISPLAY
PRESS 5 TO SORT
PRESS 0 TO EXIT
  
2
ENTER THE  NEW NUMBER TO BE ADDED
45
NEW HEAP = 1008 17 45 1 0 3 25 

PRESS 1 TO CREATE 
PRESS 2 TO ADD 
PRESS 3 TO DELETE 
PRESS 4 TO DISPLAY
PRESS 5 TO SORT
PRESS 0 TO EXIT
  
2
ENTER THE  NEW NUMBER TO BE ADDED
58
NEW HEAP = 1008 58 45 17 0 3 25 1 

PRESS 1 TO CREATE 
PRESS 2 TO ADD 
PRESS 3 TO DELETE 
PRESS 4 TO DISPLAY
PRESS 5 TO SORT
PRESS 0 TO EXIT
  
3
ENTER THE INDEX OF THE NUMBER TO BE DELETED
0
NEW HEAP = 58 17 45 1 0 3 25 
 
PRESS 1 TO CREATE 
PRESS 2 TO ADD 
PRESS 3 TO DELETE 
PRESS 4 TO DISPLAY
PRESS 5 TO SORT
PRESS 0 TO EXIT
  
5
SORTED HEAP = 0 1 3 17 25 45 58 
 
PRESS 1 TO CREATE 
PRESS 2 TO ADD 
PRESS 3 TO DELETE 
PRESS 4 TO DISPLAY
PRESS 5 TO SORT
PRESS 0 TO EXIT
  
0
*/
