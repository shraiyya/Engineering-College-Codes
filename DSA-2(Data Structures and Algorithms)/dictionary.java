/*
 * SHREYA CHETAN PAWASKAR
 * ROLL NO-2939
 * BATCH -C3
 * SY COMP DIVISION C
 * Assignment- Implementing Dictionary using trees
 */
package dictionary;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class node {
	String word,meaning;
	node left, right;

	node() {
		word="";
		meaning="";
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
        int choice=0;
		String value = "",value1="";
		int flag = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the keyword:");
		value = s.next();
		System.out.println("Enter the meaning:");
		value1 = s.next();
		node temp = new node();
		node ptr = root;
		temp.word = value;
		temp.meaning=value1;
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

				if(temp.word.compareTo(ptr1.word)<0)
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
					if(temp.word.compareTo(ptr1.word)>0)
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

	
	public  node minimumKey(node ptr)
	{
		while(ptr.left != null) {
			ptr = ptr.left;
		}
		return ptr;
	}

	 node delete(node root,String q) {
		node parent = null;
		node ptr = root;

		// search key and set its parent pointer
		while (ptr != null && q.compareTo(ptr.word)!=0)
		{
			// update parent node as ptrent node
			parent = ptr;

			if (q.compareTo(ptr.word)<0) {
				ptr = ptr.left;
			}
			else {
				ptr = ptr.right;
			}
		}

		// return if key is not found in the tree
		if (ptr == null) {
			System.out.println("NOT FOUND  IN THE DICTIONARY");
			return root;
		}

		// leaf node
		if (ptr.left == null && ptr.right == null)
		{
			
			if (ptr != root) {
				if (parent.left == ptr) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
			// if tree has only root node, delete it and set root to null
			else {
				root = null;
			}
		}

		// 2 children
		else if (ptr.left != null && ptr.right != null)
		{
			// inorder successor node
			node successor  = minimumKey(ptr.right);

			// store successor value
			String val = successor.word;

			// recursively delete the successor.
			delete(root, successor.word);

			//value of successor = pArent node
			ptr.word = val;
		}

		// one child
		else
		{
			// find child node
			node child = (ptr.left != null)? ptr.left: ptr.right;

			// if node to be deleted is not a root node, then set its parent
			// to its child
			if (ptr != root)
			{
				if (ptr == parent.left) {
					parent.left = child;
				} else {
					parent.right = child;
				}
			}

			// node to be deleted is root then root = child
			else {
				root = child;
			}
		}

		return root;
		
		
	}
	
	void display(node temp) //recursive
	{
		if (temp==null)
		{
			return;
		}
		display(temp.left);
		System.out.println(temp.word +"\t"+"\t"+temp.meaning+" ");
		display(temp.right);
		
	}
	
	
	int search(String q)
	{
		node ptr = root;
		node temp=null;
		int flag = 0;
		while(ptr != null)
		{
			if(q.equals(ptr.word))
			{
				flag = 1;
				temp=ptr;
				break;
			}
			else if(q.compareTo(ptr.word) < 0)
			{
				ptr = ptr.left;
			}
			else if(q.compareTo(ptr.word) > 0)
			{
				ptr = ptr.right;
			}
		}
		if(flag==1) {
			System.out.println("THE WORD HAS BEEN FOUND");
			System.out.println(temp.word+" =  "+temp.meaning);
		}
		else {
			System.out.println("THE WORD IS NOT PRESENT IN THE DICTIONARY");
		}
		return flag;
	}
	
	
	void update(String q) 
	{
		node ptr = root;
		node temp=null;
		int flag = 0;
		while(ptr != null)
		{
			if(q.equals(ptr.word))
			{
				flag = 1;
				temp=ptr;
				break;
			}
			else if(q.compareTo(ptr.word) < 0)
			{
				ptr = ptr.left;
			}
			else if(q.compareTo(ptr.word) > 0)
			{
				ptr = ptr.right;
			}
		}
		if(flag==1) {
			System.out.println("THE WORD HAS BEEN FOUND");
			System.out.println("ENTER THE NEW MEANING OF THE WORD");
			String m2="";
			m2=s.next();
			temp.meaning=m2;
			System.out.println(temp.word+" "+temp.meaning);
		}
		else {
			System.out.println("THE WORD IS NOT PRESENT IN THE DICTIONARY");
		}
	}

}
public class dictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s1 = new Scanner(System.in);
		int choice = 0;
		btree a = new btree();
		int yn=0;
		do
		{
			System.out.println("PRESS 1 TO ADD WORDS");
			System.out.println("PRESS 2 TO DELETE WORDS");
			System.out.println("PRESS 3 TO DISPLAY WORDS");
			System.out.println("PRESS 4 TO SEARCH WORDS");
			System.out.println("PRESS 5 TO UPDATE WORDS");
			System.out.println("PRESS 0 TO EXIT");
			System.out.println("  ");
			 choice=s1.nextInt();
			 switch(choice)
			 {
			 case 1:
				 do {
					a.insert();
					System.out.println("DO YOU WANT TO CONTINUE?(1=YES /2=N0)");
					yn=s1.nextInt();
				 }while(yn!=2);
					break;
				case 2:
					System.out.println("ENTER THE WORD TO BE DELETED");
					String q0="";
					q0=s1.next();	
					a.root=a.delete(a.root,q0);
				
					System.out.println(" ");
					break;
				case 3:
					System.out.println();
					System.out.println("WORD"+"\t"+"\t"+"MEANING");
					a.display(a.root);
					System.out.println(" ");
					break;
				case 4:
					System.out.println("ENTER THE WORD TO BE SEARCHED");
					String q="";
					q=s1.next();
					a.search(q);
					System.out.println(" ");
					break;
				case 5:
					System.out.println("ENTER THE WORD TO BE UPDATED");
					String q1="";
					q1=s1.next();
					a.update(q1);
					System.out.println(" ");
					break;
			 }
			 
		}while(choice!=0);
	}

}
/*
 * 1PRESS 1 TO ADD WORDS
PRESS 2 TO DELETE WORDS
PRESS 3 TO DISPLAY WORDS
PRESS 4 TO SEARCH WORDS
PRESS 5 TO UPDATE WORDS
PRESS 0 TO EXIT
  

Enter the keyword:
happy
Enter the meaning:
joy
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
1
Enter the keyword:
unhappy
Enter the meaning:
sad
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
1
Enter the keyword:
play
Enter the meaning:
drama
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
1
Enter the keyword:
movie
Enter the meaning:
film
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
2
PRESS 1 TO ADD WORDS
PRESS 2 TO DELETE WORDS
PRESS 3 TO DISPLAY WORDS
PRESS 4 TO SEARCH WORDS
PRESS 5 TO UPDATE WORDS
PRESS 0 TO EXIT
  
3

WORD		MEANING
happy		joy 
movie		film 
play		drama 
unhappy		sad 
 
PRESS 1 TO ADD WORDS
PRESS 2 TO DELETE WORDS
PRESS 3 TO DISPLAY WORDS
PRESS 4 TO SEARCH WORDS
PRESS 5 TO UPDATE WORDS
PRESS 0 TO EXIT
  
2
ENTER THE WORD TO BE DELETED
unhappy
 
PRESS 1 TO ADD WORDS
PRESS 2 TO DELETE WORDS
PRESS 3 TO DISPLAY WORDS
PRESS 4 TO SEARCH WORDS
PRESS 5 TO UPDATE WORDS
PRESS 0 TO EXIT
  
3

WORD		MEANING
happy		joy 
movie		film 
play		drama 
 
PRESS 1 TO ADD WORDS
PRESS 2 TO DELETE WORDS
PRESS 3 TO DISPLAY WORDS
PRESS 4 TO SEARCH WORDS
PRESS 5 TO UPDATE WORDS
PRESS 0 TO EXIT
  
2
ENTER THE WORD TO BE DELETED
man
NOT FOUND  IN THE DICTIONARY
 
PRESS 1 TO ADD WORDS
PRESS 2 TO DELETE WORDS
PRESS 3 TO DISPLAY WORDS
PRESS 4 TO SEARCH WORDS
PRESS 5 TO UPDATE WORDS
PRESS 0 TO EXIT
  
4
ENTER THE WORD TO BE SEARCHED
happy
THE WORD HAS BEEN FOUND
happy =  joy
 
PRESS 1 TO ADD WORDS
PRESS 2 TO DELETE WORDS
PRESS 3 TO DISPLAY WORDS
PRESS 4 TO SEARCH WORDS
PRESS 5 TO UPDATE WORDS
PRESS 0 TO EXIT
  
4
ENTER THE WORD TO BE SEARCHED
knowledge
THE WORD IS NOT PRESENT IN THE DICTIONARY
 
PRESS 1 TO ADD WORDS
PRESS 2 TO DELETE WORDS
PRESS 3 TO DISPLAY WORDS
PRESS 4 TO SEARCH WORDS
PRESS 5 TO UPDATE WORDS
PRESS 0 TO EXIT
  
5
ENTER THE WORD TO BE UPDATED
toys
THE WORD IS NOT PRESENT IN THE DICTIONARY
 
PRESS 1 TO ADD WORDS
PRESS 2 TO DELETE WORDS
PRESS 3 TO DISPLAY WORDS
PRESS 4 TO SEARCH WORDS
PRESS 5 TO UPDATE WORDS
PRESS 0 TO EXIT
  
5
ENTER THE WORD TO BE UPDATED
happy
THE WORD HAS BEEN FOUND
ENTER THE NEW MEANING OF THE WORD
contented
happy contented
 
PRESS 1 TO ADD WORDS
PRESS 2 TO DELETE WORDS
PRESS 3 TO DISPLAY WORDS
PRESS 4 TO SEARCH WORDS
PRESS 5 TO UPDATE WORDS
PRESS 0 TO EXIT
  
3

WORD		MEANING
happy		contented 
movie		film 
play		drama 
 
PRESS 1 TO ADD WORDS
PRESS 2 TO DELETE WORDS
PRESS 3 TO DISPLAY WORDS
PRESS 4 TO SEARCH WORDS
PRESS 5 TO UPDATE WORDS
PRESS 0 TO EXIT
  
0

*/
