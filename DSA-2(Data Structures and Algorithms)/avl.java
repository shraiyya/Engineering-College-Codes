package avl;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class node {
	String name,number;
	node left, right;
	int ht;

	node() {
		ht=0;
		name="";
		number="";
		left = null;
		right = null;
	}
	
	node(String n1,String n2) {
		ht=0;
		name=n1;
		number=n2;
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
	static int height(node temp) // to find height of tree....not used
	{
		if (temp == null)
			return 0;
		return 1 + Math.max(height(temp.left), height(temp.right));
		
	}
	static node ll(node root) //LL ROTATION
    {
    	root=right(root);
		return root;
    	
    }
    static node rr(node root) //RR ROTATION
    {
    	root=left(root);
		return root;
    	
    }
    static node rl(node root) //RL ROTATION
    {
    	root.right=right(root.right);
    	root=left(root);
		return root;
    	
    }
    static node lr(node root) //LR ROTATION
    {
    	root.left=left(root.left);
    	root=right(root);
		return root;
    	
    }
    static node left(node a) 
    {
    	node b;
    	b=a.right;
    	a.right=b.left;
    	b.left=a;
    	a.ht=height(a);
    	b.ht=height(b);
    	return b;
    }
    static node right(node a) 
    {
    	node b;
    	b=a.left;
    	a.left=b.right;
    	b.right=a;
    	a.ht=height(a);
    	b.ht=height(b);
    	return b;
    }
    
    /* Function to max of left/right node */
     int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }
		
	
	node insert(String value,String value1, node t)//insertion in avl
    {
        if (t == null)
            t = new node(value,value1);
        else if (value.compareTo(t.name)<0)
        {
            t.left = insert( value, value1, t.left );
            if( height( t.left ) - height( t.right ) == 2 )
                if(value.compareTo(t.left.name)<0) {
                	node x=t;
                    t = ll( t );
                    System.out.println("LL ROTATION PERFORMED AT "+x.name);
                    System.out.println(" ");
                    }
                else {
                	node x=t;
                    t = lr( t );
                    System.out.println("LR ROTATION PERFORMED AT "+x.name);
                    System.out.println(" ");
                }
        }
        else if(value.compareTo(t.name)>0)
        {
            t.right = insert( value, value1, t.right );
            if( height( t.right ) - height( t.left ) == 2 )
                if(value.compareTo(t.right.name)>0) {
                	node x=t;
                    t = rr( t );
                    System.out.println("RR ROTATION PERFORMED AT "+x.name);
                    System.out.println(" ");
                }
                else {
                	node x=t;
                    t = rl( t );
                    System.out.println("RL ROTATION PERFORMED AT "+x.name);
                    System.out.println(" ");
                }
            
        }
        else
        {
			System.out.println("Duplicate entry is found");
		}
        t.ht = height(t);
        return t;
    }

	void display(node temp) //recursive inorder traversal
	{
		if (temp==null)
		{
			return;
		}
		display(temp.left);
		System.out.println(temp.name +"\t"+"\t|       "+temp.number+" ");
		display(temp.right);
		
	}
	int search(String q)//search the present names in the directory
	{
		node ptr = root;
		node temp=null;
		int flag = 0;
		while(ptr != null)
		{
			if(q.equals(ptr.name))
			{
				flag = 1;
				temp=ptr;
				break;
			}
			else if(q.compareTo(ptr.name) < 0)
			{
				ptr = ptr.left;
			}
			else if(q.compareTo(ptr.name) > 0)
			{
				ptr = ptr.right;
			}
		}
		if(flag==1) {
			System.out.println("THE NAME HAS BEEN FOUND");
			System.out.println(temp.name+"  =  "+temp.number);
		}
		else {
			System.out.println("THE NAME IS NOT PRESENT IN THE CONTACT LIST");
		}
		return flag;
	}
	
	
	void update(String q) //update the number of the present members 
	
	{
		node ptr = root;
		node temp=null;
		int flag = 0;
		while(ptr != null)
		{
			if(q.equals(ptr.name))
			{
				flag = 1;
				temp=ptr;
				break;
			}
			else if(q.compareTo(ptr.name) < 0)
			{
				ptr = ptr.left;
			}
			else if(q.compareTo(ptr.name) > 0)
			{
				ptr = ptr.right;
			}
		}
		if(flag==1) {
			System.out.println("THE NAME HAS BEEN FOUND");
			System.out.println("ENTER THE NEW PHONE NUMBER OF THE CONTACT");
			String m2="";
			m2=s.next();
			temp.number=m2;
			System.out.println(temp.name+" "+temp.number);
		}
		else {
			System.out.println("THE NAME IS NOT PRESENT IN THE CONTACT LIST");
		}
	}

	

}
public class avl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s1 = new Scanner(System.in);
		int choice = 0;
		btree a = new btree();
		int yn=0;
		do
		{
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("PRESS 1 TO ADD CONTACTS");
			System.out.println("PRESS 2 TO DISPLAY CONTACTS");
			System.out.println("PRESS 3 TO SEARCH CONTACTS");
			System.out.println("PRESS 4 TO UPDATE CONTACTS");
			System.out.println("PRESS 0 TO EXIT");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("  ");
			 choice=s1.nextInt();
			 switch(choice)
			 {
			 case 1:
				 do {
						String value = "",value1="";
			            System.out.println("ENTER THE NAME:");
						value = s1.next();
						System.out.println("ENTER THE PHONE NUMBER:");
						value1 = s1.next();
					a.root=a.insert(value,value1,a.root);
					System.out.println("DO YOU WANT TO CONTINUE?(1=YES /2=N0)");
					yn=s1.nextInt();
				 }while(yn!=2);
					break;
				case 2:
					System.out.println();
					System.out.println("NAME OF CONTACT"+"\t"+"\t"+"PHONE NUMBER");
					a.display(a.root);
					System.out.println(" ");
					break;
				case 3:
					System.out.println("ENTER THE NAME OF CONTACT TO BE SEARCHED");
					String q="";
					q=s1.next();
					a.search(q);
					System.out.println(" ");
					break;
				case 4:
					System.out.println("ENTER THE NAME OF CONTACT TO BE UPDATED");
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
 -------------------------------------------------------------------------------------------------------------------------------------
PRESS 1 TO ADD CONTACTS
PRESS 2 TO DISPLAY CONTACTS
PRESS 3 TO SEARCH CONTACTS
PRESS 4 TO UPDATE CONTACTS
PRESS 0 TO EXIT
-------------------------------------------------------------------------------------------------------------------------------------
  
1
ENTER THE NAME:
shreya
ENTER THE PHONE NUMBER:
83499938
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
1
ENTER THE NAME:
rohit
ENTER THE PHONE NUMBER:
38949874
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
1
ENTER THE NAME:
aniya
ENTER THE PHONE NUMBER:
348477090
LL ROTATION PERFORMED AT shreya
 
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
1
ENTER THE NAME:
zeya
ENTER THE PHONE NUMBER:
764901939
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
2
-------------------------------------------------------------------------------------------------------------------------------------
PRESS 1 TO ADD CONTACTS
PRESS 2 TO DISPLAY CONTACTS
PRESS 3 TO SEARCH CONTACTS
PRESS 4 TO UPDATE CONTACTS
PRESS 0 TO EXIT
-------------------------------------------------------------------------------------------------------------------------------------
  
2

NAME OF CONTACT		PHONE NUMBER
aniya		|       348477090 
rohit		|       38949874 
shreya		|       83499938 
zeya		|       764901939 
 
-------------------------------------------------------------------------------------------------------------------------------------
PRESS 1 TO ADD CONTACTS
PRESS 2 TO DISPLAY CONTACTS
PRESS 3 TO SEARCH CONTACTS
PRESS 4 TO UPDATE CONTACTS
PRESS 0 TO EXIT
-------------------------------------------------------------------------------------------------------------------------------------
  
1
ENTER THE NAME:
adya
ENTER THE PHONE NUMBER:
936289000
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
1
ENTER THE NAME:
danish
ENTER THE PHONE NUMBER:
868397908
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
1
ENTER THE NAME:
vara
ENTER THE PHONE NUMBER:
826849948
RL ROTATION PERFORMED AT shreya
 
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
1
ENTER THE NAME:
stuti
ENTER THE PHONE NUMBER:
98937998
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
1
ENTER THE NAME:
hiya
ENTER THE PHONE NUMBER:
9839498974
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
1
ENTER THE NAME:
anshul
ENTER THE PHONE NUMBER:
849473999
DO YOU WANT TO CONTINUE?(1=YES /2=N0)
2
-------------------------------------------------------------------------------------------------------------------------------------
PRESS 1 TO ADD CONTACTS
PRESS 2 TO DISPLAY CONTACTS
PRESS 3 TO SEARCH CONTACTS
PRESS 4 TO UPDATE CONTACTS
PRESS 0 TO EXIT
-------------------------------------------------------------------------------------------------------------------------------------
  
2

NAME OF CONTACT		PHONE NUMBER
adya		|       936289000 
aniya		|       348477090 
anshul		|       849473999 
danish		|       868397908 
hiya		|       9839498974 
rohit		|       38949874 
shreya		|       83499938 
stuti		|       98937998 
vara		|       826849948 
zeya		|       764901939 
 
-------------------------------------------------------------------------------------------------------------------------------------
PRESS 1 TO ADD CONTACTS
PRESS 2 TO DISPLAY CONTACTS
PRESS 3 TO SEARCH CONTACTS
PRESS 4 TO UPDATE CONTACTS
PRESS 0 TO EXIT
-------------------------------------------------------------------------------------------------------------------------------------
  
3
ENTER THE NAME OF CONTACT TO BE SEARCHED
anshul
THE NAME HAS BEEN FOUND
anshul  =  849473999
 
-------------------------------------------------------------------------------------------------------------------------------------
PRESS 1 TO ADD CONTACTS
PRESS 2 TO DISPLAY CONTACTS
PRESS 3 TO SEARCH CONTACTS
PRESS 4 TO UPDATE CONTACTS
PRESS 0 TO EXIT
-------------------------------------------------------------------------------------------------------------------------------------
  
3
ENTER THE NAME OF CONTACT TO BE SEARCHED
jiya
THE NAME IS NOT PRESENT IN THE CONTACT LIST
 
-------------------------------------------------------------------------------------------------------------------------------------
PRESS 1 TO ADD CONTACTS
PRESS 2 TO DISPLAY CONTACTS
PRESS 3 TO SEARCH CONTACTS
PRESS 4 TO UPDATE CONTACTS
PRESS 0 TO EXIT
-------------------------------------------------------------------------------------------------------------------------------------
  
4
ENTER THE NAME OF CONTACT TO BE UPDATED
shreya
THE NAME HAS BEEN FOUND
ENTER THE NEW PHONE NUMBER OF THE CONTACT
7888775688
shreya 7888775688
 
-------------------------------------------------------------------------------------------------------------------------------------
PRESS 1 TO ADD CONTACTS
PRESS 2 TO DISPLAY CONTACTS
PRESS 3 TO SEARCH CONTACTS
PRESS 4 TO UPDATE CONTACTS
PRESS 0 TO EXIT
-------------------------------------------------------------------------------------------------------------------------------------
  
2

NAME OF CONTACT		PHONE NUMBER
adya		|       936289000 
aniya		|       348477090 
anshul		|       849473999 
danish		|       868397908 
hiya		|       9839498974 
rohit		|       38949874 
shreya		|       7888775688 
stuti		|       98937998 
vara		|       826849948 
zeya		|       764901939 
 
-------------------------------------------------------------------------------------------------------------------------------------
PRESS 1 TO ADD CONTACTS
PRESS 2 TO DISPLAY CONTACTS
PRESS 3 TO SEARCH CONTACTS
PRESS 4 TO UPDATE CONTACTS
PRESS 0 TO EXIT
-------------------------------------------------------------------------------------------------------------------------------------
  
4
ENTER THE NAME OF CONTACT TO BE UPDATED
amy
THE NAME IS NOT PRESENT IN THE CONTACT LIST
 
-------------------------------------------------------------------------------------------------------------------------------------
PRESS 1 TO ADD CONTACTS
PRESS 2 TO DISPLAY CONTACTS
PRESS 3 TO SEARCH CONTACTS
PRESS 4 TO UPDATE CONTACTS
PRESS 0 TO EXIT
-------------------------------------------------------------------------------------------------------------------------------------
  
0


*/