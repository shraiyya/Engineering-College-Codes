/*
 * SHREYA CHETAN PAWASKAR
 * ROLL NO-2939
 * BATCH -C3
 * SY COMP DIVISION C
 * Assignment- Binary Search Tree operations
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class node {
	int data;
	node left, right;

	node() {
		data = 0;
		left = null;
		right = null;
	}
}

class btree {
	Scanner s = new Scanner(System.in);
	node root;

	btree() {
		root = null;
	}

	void insert() {

		int value = 0;
		int flag = 0;
		String dir;
		Scanner sc = new Scanner(System.in);
		node temp = new node();
		node ptr = root;
		System.out.println("Enter the node data:");
		value = s.nextInt();
		temp.data = value;
		if(root==null)
		{
			root=temp;
			flag=1;
		}
		else
		{
			node ptr1=root;
			while(flag==0)
			{

				if(temp.data<ptr1.data)
				{
					if(ptr1.left!=null)
					{
						ptr1=ptr1.left;
					}
					else
					{
						ptr1.left=temp;
						flag=1;
					}
				}
				else
				{
					if(temp.data>ptr1.data)
					{
						if(ptr1.right!=null)
						{
							ptr1=ptr1.right;
						}
						else
						{
							ptr1.right=temp;
							flag=1;
						}
					}
				}
				
			}
		}			
		
	}

	void max(node curr) {
		/* loop down to find the rightmost leaf */
		node current = root;
		while (current.right != null)
			current = current.right;

		System.out.println(current.data + " ");
	}

	void min(node curr) // to find minimum element
	{
		/* loop down to find the left most leaf */
		node current = root;
		while (current.left != null)
			current = current.left;

		System.out.println(current.data + " ");
	}

	void level() // to print level order of bst
	{

		Queue<node> q = new LinkedList<>();
		if (root == null) {
			System.out.println("The tree is empty.");
			return;
		}
		q.add(this.root);
		while (!q.isEmpty()) {
			node temp1 = q.poll(); // to remove the present head
			System.out.print(temp1.data + " ");
			if (temp1.left != null) {
				q.add(temp1.left);
			}
			if (temp1.right != null) {
				q.add(temp1.right);
			}
			
		}
	}

	int height(node temp) // to find height of tree
	{
		if (temp == null)
			return 0;
		return 1 + Math.max(height(temp.left), height(temp.right));
		
	}

	void descending(node temp) // to find descending order
	{
		if (temp == null) {
			return;
		}

		descending(temp.right);
		System.out.print(temp.data + " ");
		descending(temp.left);

	}

	int leaf(node temp) // to find number of leaves
	{

		if (temp == null)
			return 0;
		if (temp.left == null && temp.right == null)
			return 1;
		else
			return leaf(temp.left) + leaf(temp.right);
	}

	 void parent(node n, int val,int p) {
		if (n == null) 
	        return; 
	  
	    // If current node is the required node 
	    if (n.data==val)  
	    {  // Print its parent 
	        System.out.print(p); 
	    } 
	    else 
	    { 
	        parent(n.left, val,n.data); 
	        parent(n.right, val,n.data); 
	    } 
	}

}

public class bstree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s1 = new Scanner(System.in);
		int choice = 0;
		btree a = new btree();
		do {
			System.out.println("press 1 to create a tree");
			System.out.println("press 2 to display minimum");
			System.out.println("press 3 to display maximum");
			System.out.println("press 4 to display tree level wise");
			System.out.println("press 5 to display height");
			System.out.println("press 6 to display descending order");
			System.out.println("press 7 to display no of leaf in recursively");
			System.out.println("press 8 to display parent of node");
			System.out.println("press 0 to exit");
			System.out.println("  ");
			choice = s1.nextInt();
			switch (choice) {
			case 1:
				a.insert();
				break;
			case 2:
				System.out.print("THE MINIMUM ELEMENT OF THE BINARY SEARCH  TREE -  ");
				a.min(a.root);
				System.out.println(" ");
				break;
			case 3:
				System.out.print("THE MAXIMUM ELEMENT OF THE BINARY SEARCH  TREE -  ");
				a.max(a.root);
				System.out.println(" ");
				break;
			case 4:
				System.out.print("THE LEVEL WISE ORDER OF THE BINARY SEARCH  TREE -  ");
				a.level();
				System.out.println(" ");
				break;
			case 5:
				System.out.print("THE HEIGHT OF THE BINARY SEARCH  TREE - ");
				System.out.print(a.height(a.root));
				System.out.println(" ");
				break;
			case 6:
				System.out.print("THE DESCENDING ORDER OF THE BINARY SEARCH  TREE -  ");
				a.descending(a.root);
				System.out.println(" ");
				break;
			case 7:
				System.out.print("THE NUMBER  OF LEAF IN THE BINARY SEARCH  TREE IS/ARE -  ");
				int l=a.leaf(a.root);
				System.out.print(l);
				System.out.println(" ");
				break;
			case 8:
				int val=0;
				System.out.println("ENTER THE NODE TO FIND PARENT");
				val=s1.nextInt();
				if(a.root.data==val)
				{
					System.out.println("THIS IS THE ROOT OF TREE");
				}
				else {
				System.out.print("THE PARENT  OF THE NODE IN  THE BINARY SEARCH  TREE IS/ARE -  ");
				a.parent(a.root,val,-1);
				}
				System.out.println(" ");
				
				break;

			}
		} while (choice != 0 && choice <= 8);
	}

}


/*
press 1 to create a tree
press 2 to display minimum
press 3 to display maximum
press 4 to display tree level wise
press 5 to display height
press 6 to display descending order
press 7 to display no of leaf in recursively
press 8 to display parent of node
press 0 to exit
  
1
Enter the node data:
8
press 1 to create a tree
press 2 to display minimum
press 3 to display maximum
press 4 to display tree level wise
press 5 to display height
press 6 to display descending order
press 7 to display no of leaf in recursively
press 8 to display parent of node
press 0 to exit
  
1
Enter the node data:
3
press 1 to create a tree
press 2 to display minimum
press 3 to display maximum
press 4 to display tree level wise
press 5 to display height
press 6 to display descending order
press 7 to display no of leaf in recursively
press 8 to display parent of node
press 0 to exit
  
1
Enter the node data:
9
press 1 to create a tree
press 2 to display minimum
press 3 to display maximum
press 4 to display tree level wise
press 5 to display height
press 6 to display descending order
press 7 to display no of leaf in recursively
press 8 to display parent of node
press 0 to exit
  
1
Enter the node data:
1
press 1 to create a tree
press 2 to display minimum
press 3 to display maximum
press 4 to display tree level wise
press 5 to display height
press 6 to display descending order
press 7 to display no of leaf in recursively
press 8 to display parent of node
press 0 to exit
  
1
Enter the node data:
13
press 1 to create a tree
press 2 to display minimum
press 3 to display maximum
press 4 to display tree level wise
press 5 to display height
press 6 to display descending order
press 7 to display no of leaf in recursively
press 8 to display parent of node
press 0 to exit
  
2
THE MINIMUM ELEMENT OF THE BINARY SEARCH  TREE -  1 
 
press 1 to create a tree
press 2 to display minimum
press 3 to display maximum
press 4 to display tree level wise
press 5 to display height
press 6 to display descending order
press 7 to display no of leaf in recursively
press 8 to display parent of node
press 0 to exit
  
3
THE MAXIMUM ELEMENT OF THE BINARY SEARCH  TREE -  13 
 
press 1 to create a tree
press 2 to display minimum
press 3 to display maximum
press 4 to display tree level wise
press 5 to display height
press 6 to display descending order
press 7 to display no of leaf in recursively
press 8 to display parent of node
press 0 to exit
  
4
THE LEVEL WISE ORDER OF THE BINARY SEARCH  TREE -  8 3 9 1 13  
press 1 to create a tree
press 2 to display minimum
press 3 to display maximum
press 4 to display tree level wise
press 5 to display height
press 6 to display descending order
press 7 to display no of leaf in recursively
press 8 to display parent of node
press 0 to exit
  
5
THE HEIGHT OF THE BINARY SEARCH  TREE - 3 
press 1 to create a tree
press 2 to display minimum
press 3 to display maximum
press 4 to display tree level wise
press 5 to display height
press 6 to display descending order
press 7 to display no of leaf in recursively
press 8 to display parent of node
press 0 to exit
  
6
THE DESCENDING ORDER OF THE BINARY SEARCH  TREE -  13 9 8 3 1  
press 1 to create a tree
press 2 to display minimum
press 3 to display maximum
press 4 to display tree level wise
press 5 to display height
press 6 to display descending order
press 7 to display no of leaf in recursively
press 8 to display parent of node
press 0 to exit
  
7
THE NUMBER  OF LEAF IN THE BINARY SEARCH  TREE IS/ARE -  2 
press 1 to create a tree
press 2 to display minimum
press 3 to display maximum
press 4 to display tree level wise
press 5 to display height
press 6 to display descending order
press 7 to display no of leaf in recursively
press 8 to display parent of node
press 0 to exit
  
8
ENTER THE NODE TO FIND PARENT
13
THE PARENT  OF THE NODE IN  THE BINARY SEARCH  TREE IS/ARE -  9 
press 1 to create a tree
press 2 to display minimum
press 3 to display maximum
press 4 to display tree level wise
press 5 to display height
press 6 to display descending order
press 7 to display no of leaf in recursively
press 8 to display parent of node
press 0 to exit
  
8
ENTER THE NODE TO FIND PARENT
9
THE PARENT  OF THE NODE IN  THE BINARY SEARCH  TREE IS/ARE -  8 
press 1 to create a tree
press 2 to display minimum
press 3 to display maximum
press 4 to display tree level wise
press 5 to display height
press 6 to display descending order
press 7 to display no of leaf in recursively
press 8 to display parent of node
press 0 to exit
  
8
ENTER THE NODE TO FIND PARENT
1
THE PARENT  OF THE NODE IN  THE BINARY SEARCH  TREE IS/ARE -  3 
press 1 to create a tree
press 2 to display minimum
press 3 to display maximum
press 4 to display tree level wise
press 5 to display height
press 6 to display descending order
press 7 to display no of leaf in recursively
press 8 to display parent of node
press 0 to exit
  
0
*/
