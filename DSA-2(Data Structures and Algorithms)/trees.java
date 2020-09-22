/*
 * SHREYA CHETAN PAWASKAR
 * ROLL NO-2939
 * BATCH -C3
 * SY COMP DIVISION C
 * Assignment- tree traversals in java
 */
package trees;

import java.util.Scanner;
import java.util.Stack;

class node
{
	 int data; 
    node left, right; 
     
    node()
    { 
        data = 0; 
        left = null; 
        right = null; 
     }
}    

class btree
{
	Scanner s= new Scanner(System.in);
	node root;
	btree()
	{
		root=null;
	}
	
	
	void insert()
	{
		
		int value=0;
		int flag=0;
		String dir;
		Scanner sc=new Scanner(System.in);
		node temp=new node();
		System.out.println("Enter the node data:");
		value=s.nextInt();
		temp.data=value;
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
				System.out.println("Enter direction? PRESS L FOR LEFT AND R FOR RIGHT");
				dir=sc.next();
				if(dir.equalsIgnoreCase("l"))
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
					if(dir.equalsIgnoreCase("r"))
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
	
	void preorder1(node temp) //recursive
	{
		if (temp==null)
		{
			return;
		}
		System.out.print(temp.data +" ");
		preorder1(temp.left);
		preorder1(temp.right);
	}
	
	void postorder1(node temp) //recursive
	{
		if (temp==null)
		{
			return;
		}
		
		postorder1(temp.left);
		postorder1(temp.right);
		System.out.print(temp.data +" ");
	}
	
	void inorder1(node temp) //recursive
	{
		if (temp==null)
		{
			return;
		}
		
		inorder1(temp.left);
		System.out.print(temp.data +" ");
		inorder1(temp.right);
		
	}
	
	void  inorder() //non recursive
	{
		Stack<node> s= new Stack<node>();
		node temp=root;
		if(root==null)
		{
			return;
		}
		while(temp!=null || s.size()>0)
		{
			while(temp!=null)
			{
				s.push(temp);
				temp=temp.left;
			}
			temp=s.pop();
			System.out.print(temp.data+" ");
			temp=temp.right;
			
		}
	
		
	}
	
	void postorder()
	{
		Stack<node> s1, s2; 
		s1 = new Stack<>(); 
        s2 = new Stack<>(); 
  
        if (root == null) 
            return; 
  
        // push root to first stack 
        s1.push(root); 
  
        // Run while first stack is not empty 
        while (!s1.isEmpty()) { 
            // Pop an item from s1 and push it to s2 
            node temp = s1.pop(); 
            s2.push(temp); 
  
            // Push left and right children of 
            // removed item to s1 
            if (temp.left != null) 
                s1.push(temp.left); 
            if (temp.right != null) 
                s1.push(temp.right); 
        } 
  
        // Print all elements of second stack 
        while (!s2.isEmpty()) { 
            node temp = s2.pop(); 
            System.out.print(temp.data + " "); 
        } 
			}
		
			
	
	void preorder()
	{
		Stack<node> s= new Stack<node>();
	
		s.push(root);
		while(!s.isEmpty())
		{
			node temp=s.pop();
			System.out.print(temp.data+" ");
			if(temp.right!=null)
			{
				s.push(temp.right);
			}
			if(temp.left!=null)
			{
				s.push(temp.left);
			}
		}
	}
}


public class trees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s1= new Scanner(System.in);
		int choice=0;
		btree a=new btree();
		 do
		 {
		 System.out.println("press 1 to create a tree"); 
		 System.out.println("press 2 to display non recursive preorder"); 
		 System.out.println("press 3 to display non recursive postorder"); 
		 System.out.println("press 4 to display non recursive inorder");
		 System.out.println("press 5 to display recursive preorder"); 
		 System.out.println("press 6 to display recursive postorder"); 
		 System.out.println("press 7 to display recursive inorder");
		 System.out.println("press 0 to exit"); 
		 System.out.println("  ");
		 choice=s1.nextInt();
		 switch(choice)
		 {
		 case 1:
			 a.insert();
			 break;
		 
		 case 2:
			 System.out.print("THE NON RECURSIVE PREORDER TRAVERSAL IS -  ");
			 a.preorder();
			 System.out.println(" ");
			 break;
		 case 3:
			 System.out.print("THE NON RECURSIVE POSTORDER TRAVERSAL IS -  ");
			 a.postorder();
			 System.out.println(" ");
			 break;
		 case 4:
			 System.out.print("THE NON RECURSIVE INORDER TRAVERSAL IS -  ");
			 a.inorder();
			 System.out.println(" ");
			 break;
		 case 5:
			 System.out.print("THE RECURSIVE PREORDER TRAVERSAL IS -  ");
			 a.preorder1(a.root);
			 System.out.println(" ");
			 break;
		 case 6:
			 System.out.print("THE RECURSIVE POSTORDER TRAVERSAL IS -  ");
			 a.postorder1(a.root);
			 System.out.println(" ");
			 break;
		 case 7:
			 System.out.print("THE RECURSIVE INORDER TRAVERSAL IS -  ");
			 a.inorder1(a.root);
			 System.out.println(" ");
			 break;
			 
		 
		 }
		 }while(choice!=0 && choice<=7);
	} 

}


/*
 * press 1 to create a tree
press 2 to display non recursive preorder
press 3 to display non recursive postorder
press 4 to display non recursive inorder
press 5 to display recursive preorder
press 6 to display recursive postorder
press 7 to display recursive inorder
press 0 to exit
  
1
Enter the node data:
5
press 1 to create a tree
press 2 to display non recursive preorder
press 3 to display non recursive postorder
press 4 to display non recursive inorder
press 5 to display recursive preorder
press 6 to display recursive postorder
press 7 to display recursive inorder
press 0 to exit
  
1
Enter the node data:
2
Enter direction? PRESS L FOR LEFT AND R FOR RIGHT
l
press 1 to create a tree
press 2 to display non recursive preorder
press 3 to display non recursive postorder
press 4 to display non recursive inorder
press 5 to display recursive preorder
press 6 to display recursive postorder
press 7 to display recursive inorder
press 0 to exit
  
1
Enter the node data:
8
Enter direction? PRESS L FOR LEFT AND R FOR RIGHT
r
press 1 to create a tree
press 2 to display non recursive preorder
press 3 to display non recursive postorder
press 4 to display non recursive inorder
press 5 to display recursive preorder
press 6 to display recursive postorder
press 7 to display recursive inorder
press 0 to exit
  
1
Enter the node data:
1
Enter direction? PRESS L FOR LEFT AND R FOR RIGHT
l
Enter direction? PRESS L FOR LEFT AND R FOR RIGHT
l
press 1 to create a tree
press 2 to display non recursive preorder
press 3 to display non recursive postorder
press 4 to display non recursive inorder
press 5 to display recursive preorder
press 6 to display recursive postorder
press 7 to display recursive inorder
press 0 to exit
  
1
Enter the node data:
4
Enter direction? PRESS L FOR LEFT AND R FOR RIGHT
l
Enter direction? PRESS L FOR LEFT AND R FOR RIGHT
r
press 1 to create a tree
press 2 to display non recursive preorder
press 3 to display non recursive postorder
press 4 to display non recursive inorder
press 5 to display recursive preorder
press 6 to display recursive postorder
press 7 to display recursive inorder
press 0 to exit
  
1
Enter the node data:
9
Enter direction? PRESS L FOR LEFT AND R FOR RIGHT
r
Enter direction? PRESS L FOR LEFT AND R FOR RIGHT
r
press 1 to create a tree
press 2 to display non recursive preorder
press 3 to display non recursive postorder
press 4 to display non recursive inorder
press 5 to display recursive preorder
press 6 to display recursive postorder
press 7 to display recursive inorder
press 0 to exit
  
2
THE NON RECURSIVE PREORDER TRAVERSAL IS -  5 2 1 4 8 9  
press 1 to create a tree
press 2 to display non recursive preorder
press 3 to display non recursive postorder
press 4 to display non recursive inorder
press 5 to display recursive preorder
press 6 to display recursive postorder
press 7 to display recursive inorder
press 0 to exit
  
3
THE NON RECURSIVE POSTORDER TRAVERSAL IS -  1 4 2 9 8 5  
press 1 to create a tree
press 2 to display non recursive preorder
press 3 to display non recursive postorder
press 4 to display non recursive inorder
press 5 to display recursive preorder
press 6 to display recursive postorder
press 7 to display recursive inorder
press 8 to display level order
press 0 to exit
  
4
THE NON RECURSIVE INORDER TRAVERSAL IS -  1 2 4 5 8 9  
press 1 to create a tree
press 2 to display non recursive preorder
press 3 to display non recursive postorder
press 4 to display non recursive inorder
press 5 to display recursive preorder
press 6 to display recursive postorder
press 7 to display recursive inorder
press 8 to display level order
press 0 to exit
  
5
THE RECURSIVE PREORDER TRAVERSAL IS -  5 2 1 4 8 9  
press 1 to create a tree
press 2 to display non recursive preorder
press 3 to display non recursive postorder
press 4 to display non recursive inorder
press 5 to display recursive preorder
press 6 to display recursive postorder
press 7 to display recursive inorder
press 8 to display level order
press 0 to exit
  
6
THE RECURSIVE POSTORDER TRAVERSAL IS -  1 4 2 9 8 5  
press 1 to create a tree
press 2 to display non recursive preorder
press 3 to display non recursive postorder
press 4 to display non recursive inorder
press 5 to display recursive preorder
press 6 to display recursive postorder
press 7 to display recursive inorder
press 0 to exit
  
7
THE RECURSIVE INORDER TRAVERSAL IS -  1 2 4 5 8 9  
press 1 to create a tree
press 2 to display non recursive preorder
press 3 to display non recursive postorder
press 4 to display non recursive inorder
press 5 to display recursive preorder
press 6 to display recursive postorder
press 7 to display recursive inorder
press 0 to exit
*/
