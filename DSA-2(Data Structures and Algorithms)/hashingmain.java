
/*
 * SHREYA CHETAN PAWASKAR
 * ROLL NO-2939
 * BATCH -C3
 * SY COMP DIVISION C
 * Assignment- Consider telephone book database of N clients.Make use of a hash table implementation to quickly look up client‘s telephone number.
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

class node {
	// data members
	int cno;
	int tno;
	node next;

	node() // constructor

	{
		cno = 0;
		tno = 0;
	}

	node(int c, int t) // Parameterized constructor
	{
		cno = c;
		tno = t;
		next = null;
	}
}

class hash {
	LinkedList<node>[] al = new LinkedList[10]; // al is array of object of node class

	hash() // constructor
	{
		for (int i = 0; i < 10; i++) {
			al[i] = new LinkedList<node>();
		}
	}

	int hash_func(int c) // Find hash address based on client id using hash function.

	{
		return c % 10;
	}

	void insert(int c, int t) // insert new node
	{
		node temp = new node(c, t);
		int a = hash_func(c);
		int flag=0;
		for (int j = 0; j < al[a].size(); j++) {

			if (c == al[a].get(j).cno) //duplicate entry
			{
				System.out.println("THE CLIENT HAS BEEN FOUND.THIS IS A DUPLICATE ENTRY");
				System.out.print("[Client id : " + al[a].get(j).cno + " & " + "telephone id : " + al[a].get(j).tno + "]");
				flag=1;
				break;
				
			}
		}
		if(flag==0) {
		al[a].add(temp); // Add new node <clientid,phone no.> in list of hashtable [hash_add] at last position
		System.out.println("CLIENT'S RECORD HAS BEEN ADDED SUCCESSFULLY !");
	  }
		System.out.println("  ");
	}

	void display() // display hash table
	{
		System.out.println(" ");

		for (int i = 0; i < 10; i++) {

			System.out.print(i + "==> ");

			for (int j = 0; j < al[i].size(); j++) {

				System.out
						.print("[Client id : " + al[i].get(j).cno + " & " + "telephone id : " + al[i].get(j).tno + "]");
				if (j != al[i].size() - 1) {
					System.out.print(" -> ");
				}
			}
			System.out.println(" ");

		}
		System.out.println("  ");
	}

	void search(int s) // search operation of hashing
	{
		int b = hash_func(s); // gives the index
		int flag = 0;
		for (int j = 0; j < al[b].size(); j++) {

			if (s == al[b].get(j).cno) {
				System.out.println("THE CLIENT HAS BEEN FOUND");
				System.out.print("[Client id : " + al[b].get(j).cno + " & " + "telephone id : " + al[b].get(j).tno + "]");
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("THE CLIENT IS NOT PRESENT !");
		}

		System.out.println(" ");
	}

	void delete(int s) // deletion of hashing
	{
		int b = hash_func(s); // gives the index
		int flag = 0;
		for (int j = 0; j < al[b].size(); j++) {

			if (s == al[b].get(j).cno) // j is is the index
			{
				System.out.println("THE CLIENT HAS BEEN FOUND");
				System.out
						.print("[Client id : " + al[b].get(j).cno + " & " + "telephone id : " + al[b].get(j).tno + "]");
				al[b].remove(j);
				System.out.println("THE CLIENT HAS BEEN DELETED SUCCESSFULLY");
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("THE CLIENT IS NOT PRESENT !");
		}

		System.out.println(" ");
	}

}

public class hashingmain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int ch = 0;
		hash h = new hash(); // menu
		do {
			System.out.println(
					"----------------------------------------------------------------------------------------------------");
			System.out.println("PRESS 1 TO ADD A CLIENT");
			System.out.println("PRESS 2 TO DISPLAY CLIENT DETAILS");
			System.out.println("PRESS 3 TO DELETE CLIENT DETAILS");
			System.out.println("PRESS 4 TO SEARCH CLIENT DETAILS");
			System.out.println("PRESS 0 TO EXIT");
			System.out.println(
					"----------------------------------------------------------------------------------------------------");
			System.out.println(" ");
			ch = sc.nextInt();
			System.out.println("  ");
			switch (ch) {
			case 1:
				int yn = 0;
				do {
					System.out.println(" ");
					System.out.println("ENTER THE CLIENT ID : ");
					int client1 = 0;// accept details of the client.
					do {
						client1 = sc.nextInt();
						if (client1 < 0) {
							System.out.println("THE CLIENT ID CANNOT BE NEGATIVE. TRY AGAIN");
						}
					} while (client1 < 0);
					System.out.println("ENTER THE TELEPHONE NUMBER : ");
					int phone1 = 0;
					do {
						phone1 = sc.nextInt();
						if (phone1 < 0) {
							System.out.println("THE PHONE NUMBER CANNOT BE NEGATIVE. TRY AGAIN");
						}
					} while (phone1 < 0);
					h.insert(client1, phone1);
					System.out.println("   ");
					System.out.println("DO YOU WANT TO CONTINUE? (1=YES /2=N0)");
					yn = sc.nextInt();
					System.out.println(" ");
				} while (yn != 2);
				break;
			case 2:
				System.out.println(" ");
				System.out.println("==========================================HASH TABLE=============================================");
				System.out.println(" ");
				h.display(); // Display the hash table.
				System.out.println("=================================================================================================");
				System.out.println("  ");
				break;
			case 3:

				System.out.println("ENTER THE CLIENT ID TO BE DELETED : ");
				int s1 = sc.nextInt();
				h.delete(s1); // Searching the particular client in hash table.
				System.out.println(" ");
				break;
			case 4:

				System.out.println("ENTER THE CLIENT ID TO BE SEARCHED : ");
				int s = sc.nextInt();
				h.search(s); // Searching the particular client in hash table.
				System.out.println(" ");
				break;
			default:
				System.out.println("CHECK YOUR CHOICE !! ");
				System.out.println(" ");
				break;
			case 0:
				System.out.println(" ");
				System.out.println("THANKYOU");
				System.out.println(" ");
				break;

			}
		} while (ch != 0);

	}

}
/*
----------------------------------------------------------------------------------------------------
PRESS 1 TO ADD A CLIENT
PRESS 2 TO DISPLAY CLIENT DETAILS
PRESS 3 TO DELETE CLIENT DETAILS
PRESS 4 TO SEARCH CLIENT DETAILS
PRESS 0 TO EXIT
----------------------------------------------------------------------------------------------------
 
1
  
 
ENTER THE CLIENT ID : 
1
ENTER THE TELEPHONE NUMBER : 
8939804
CLIENT'S RECORD HAS BEEN ADDED SUCCESSFULLY !
  
   
DO YOU WANT TO CONTINUE? (1=YES /2=N0)
1
 
 
ENTER THE CLIENT ID : 
-9
THE CLIENT ID CANNOT BE NEGATIVE. TRY AGAIN
9
ENTER THE TELEPHONE NUMBER : 
2838249
CLIENT'S RECORD HAS BEEN ADDED SUCCESSFULLY !
  
   
DO YOU WANT TO CONTINUE? (1=YES /2=N0)
1
 
 
ENTER THE CLIENT ID : 
68933
ENTER THE TELEPHONE NUMBER : 
8470949
CLIENT'S RECORD HAS BEEN ADDED SUCCESSFULLY !
  
   
DO YOU WANT TO CONTINUE? (1=YES /2=N0)
1
 
 
ENTER THE CLIENT ID : 
678
ENTER THE TELEPHONE NUMBER : 
-82749
THE PHONE NUMBER CANNOT BE NEGATIVE. TRY AGAIN
387297470
CLIENT'S RECORD HAS BEEN ADDED SUCCESSFULLY !
  
   
DO YOU WANT TO CONTINUE? (1=YES /2=N0)
1
 
 
ENTER THE CLIENT ID : 
22
ENTER THE TELEPHONE NUMBER : 
76812499
CLIENT'S RECORD HAS BEEN ADDED SUCCESSFULLY !
  
   
DO YOU WANT TO CONTINUE? (1=YES /2=N0)
1
 
 
ENTER THE CLIENT ID : 
5643
ENTER THE TELEPHONE NUMBER : 
248438050
CLIENT'S RECORD HAS BEEN ADDED SUCCESSFULLY !
  
   
DO YOU WANT TO CONTINUE? (1=YES /2=N0)
1
 
 
ENTER THE CLIENT ID : 
2003
ENTER THE TELEPHONE NUMBER : 
4794005
CLIENT'S RECORD HAS BEEN ADDED SUCCESSFULLY !
  
   
DO YOU WANT TO CONTINUE? (1=YES /2=N0)
2
 
----------------------------------------------------------------------------------------------------
PRESS 1 TO ADD A CLIENT
PRESS 2 TO DISPLAY CLIENT DETAILS
PRESS 3 TO DELETE CLIENT DETAILS
PRESS 4 TO SEARCH CLIENT DETAILS
PRESS 0 TO EXIT
----------------------------------------------------------------------------------------------------
 
2
  
 
==========================================HASH TABLE=============================================
 
 
0==>  
1==> [Client id : 1 & telephone id : 8939804] 
2==> [Client id : 22 & telephone id : 76812499] 
3==> [Client id : 68933 & telephone id : 8470949] -> [Client id : 5643 & telephone id : 248438050] -> [Client id : 2003 & telephone id : 4794005] 
4==>  
5==>  
6==>  
7==>  
8==> [Client id : 678 & telephone id : 387297470] 
9==> [Client id : 9 & telephone id : 2838249] 

=================================================================================================
  
----------------------------------------------------------------------------------------------------
PRESS 1 TO ADD A CLIENT
PRESS 2 TO DISPLAY CLIENT DETAILS
PRESS 3 TO DELETE CLIENT DETAILS
PRESS 4 TO SEARCH CLIENT DETAILS
PRESS 0 TO EXIT
----------------------------------------------------------------------------------------------------
 
1
  
 
ENTER THE CLIENT ID : 
7824
ENTER THE TELEPHONE NUMBER : 
37898493
CLIENT'S RECORD HAS BEEN ADDED SUCCESSFULLY !
  
   
DO YOU WANT TO CONTINUE? (1=YES /2=N0)
1
 
 
ENTER THE CLIENT ID : 
79955
ENTER THE TELEPHONE NUMBER : 
83129490
CLIENT'S RECORD HAS BEEN ADDED SUCCESSFULLY !
  
   
DO YOU WANT TO CONTINUE? (1=YES /2=N0)
1
 
 
ENTER THE CLIENT ID : 
200
ENTER THE TELEPHONE NUMBER : 
67588990
CLIENT'S RECORD HAS BEEN ADDED SUCCESSFULLY !
  
   
DO YOU WANT TO CONTINUE? (1=YES /2=N0)
2
 
----------------------------------------------------------------------------------------------------
PRESS 1 TO ADD A CLIENT
PRESS 2 TO DISPLAY CLIENT DETAILS
PRESS 3 TO DELETE CLIENT DETAILS
PRESS 4 TO SEARCH CLIENT DETAILS
PRESS 0 TO EXIT
----------------------------------------------------------------------------------------------------
 
2
  
 
==========================================HASH TABLE=============================================
 
 
0==> [Client id : 200 & telephone id : 67588990] 
1==> [Client id : 1 & telephone id : 8939804] 
2==> [Client id : 22 & telephone id : 76812499] 
3==> [Client id : 68933 & telephone id : 8470949] -> [Client id : 5643 & telephone id : 248438050] -> [Client id : 2003 & telephone id : 4794005] 
4==> [Client id : 7824 & telephone id : 37898493] 
5==> [Client id : 79955 & telephone id : 83129490] 
6==>  
7==>  
8==> [Client id : 678 & telephone id : 387297470] 
9==> [Client id : 9 & telephone id : 2838249] 

=================================================================================================
  
----------------------------------------------------------------------------------------------------
PRESS 1 TO ADD A CLIENT
PRESS 2 TO DISPLAY CLIENT DETAILS
PRESS 3 TO DELETE CLIENT DETAILS
PRESS 4 TO SEARCH CLIENT DETAILS
PRESS 0 TO EXIT
----------------------------------------------------------------------------------------------------
 
3
  
ENTER THE CLIENT ID TO BE DELETED : 
5645
THE CLIENT IS NOT PRESENT !
 
 
----------------------------------------------------------------------------------------------------
PRESS 1 TO ADD A CLIENT
PRESS 2 TO DISPLAY CLIENT DETAILS
PRESS 3 TO DELETE CLIENT DETAILS
PRESS 4 TO SEARCH CLIENT DETAILS
PRESS 0 TO EXIT
----------------------------------------------------------------------------------------------------
 
5
  
CHECK YOUR CHOICE !! 
 
----------------------------------------------------------------------------------------------------
PRESS 1 TO ADD A CLIENT
PRESS 2 TO DISPLAY CLIENT DETAILS
PRESS 3 TO DELETE CLIENT DETAILS
PRESS 4 TO SEARCH CLIENT DETAILS
PRESS 0 TO EXIT
----------------------------------------------------------------------------------------------------
 
3
  
ENTER THE CLIENT ID TO BE DELETED : 
2003
THE CLIENT HAS BEEN FOUND
[Client id : 2003 & telephone id : 4794005]THE CLIENT HAS BEEN DELETED SUCCESSFULLY
 
 
----------------------------------------------------------------------------------------------------
PRESS 1 TO ADD A CLIENT
PRESS 2 TO DISPLAY CLIENT DETAILS
PRESS 3 TO DELETE CLIENT DETAILS
PRESS 4 TO SEARCH CLIENT DETAILS
PRESS 0 TO EXIT
----------------------------------------------------------------------------------------------------
 
2
  
 
==========================================HASH TABLE=============================================
 
 
0==> [Client id : 200 & telephone id : 67588990] 
1==> [Client id : 1 & telephone id : 8939804] 
2==> [Client id : 22 & telephone id : 76812499] 
3==> [Client id : 68933 & telephone id : 8470949] -> [Client id : 5643 & telephone id : 248438050] 
4==> [Client id : 7824 & telephone id : 37898493] 
5==> [Client id : 79955 & telephone id : 83129490] 
6==>  
7==>  
8==> [Client id : 678 & telephone id : 387297470] 
9==> [Client id : 9 & telephone id : 2838249] 

=================================================================================================
  
----------------------------------------------------------------------------------------------------
PRESS 1 TO ADD A CLIENT
PRESS 2 TO DISPLAY CLIENT DETAILS
PRESS 3 TO DELETE CLIENT DETAILS
PRESS 4 TO SEARCH CLIENT DETAILS
PRESS 0 TO EXIT
----------------------------------------------------------------------------------------------------
 
4
  
ENTER THE CLIENT ID TO BE SEARCHED : 
768
THE CLIENT IS NOT PRESENT !
 
 
----------------------------------------------------------------------------------------------------
PRESS 1 TO ADD A CLIENT
PRESS 2 TO DISPLAY CLIENT DETAILS
PRESS 3 TO DELETE CLIENT DETAILS
PRESS 4 TO SEARCH CLIENT DETAILS
PRESS 0 TO EXIT
----------------------------------------------------------------------------------------------------
 
4
  
ENTER THE CLIENT ID TO BE SEARCHED : 
9
THE CLIENT HAS BEEN FOUND
[Client id : 9 & telephone id : 2838249] 
 
----------------------------------------------------------------------------------------------------
PRESS 1 TO ADD A CLIENT
PRESS 2 TO DISPLAY CLIENT DETAILS
PRESS 3 TO DELETE CLIENT DETAILS
PRESS 4 TO SEARCH CLIENT DETAILS
PRESS 0 TO EXIT
----------------------------------------------------------------------------------------------------
 
1
  
 
ENTER THE CLIENT ID : 
66
ENTER THE TELEPHONE NUMBER : 
83499
CLIENT'S RECORD HAS BEEN ADDED SUCCESSFULLY !
  
   
DO YOU WANT TO CONTINUE? (1=YES /2=N0)
1
 
 
ENTER THE CLIENT ID : 
557
ENTER THE TELEPHONE NUMBER : 
87490930
CLIENT'S RECORD HAS BEEN ADDED SUCCESSFULLY !
  
   
DO YOU WANT TO CONTINUE? (1=YES /2=N0)
2
 
----------------------------------------------------------------------------------------------------
PRESS 1 TO ADD A CLIENT
PRESS 2 TO DISPLAY CLIENT DETAILS
PRESS 3 TO DELETE CLIENT DETAILS
PRESS 4 TO SEARCH CLIENT DETAILS
PRESS 0 TO EXIT
----------------------------------------------------------------------------------------------------
 
2
  
 
==========================================HASH TABLE=============================================
 
 
0==> [Client id : 200 & telephone id : 67588990] 
1==> [Client id : 1 & telephone id : 8939804] 
2==> [Client id : 22 & telephone id : 76812499] 
3==> [Client id : 68933 & telephone id : 8470949] -> [Client id : 5643 & telephone id : 248438050] 
4==> [Client id : 7824 & telephone id : 37898493] 
5==> [Client id : 79955 & telephone id : 83129490] 
6==> [Client id : 66 & telephone id : 83499] 
7==> [Client id : 557 & telephone id : 87490930] 
8==> [Client id : 678 & telephone id : 387297470] 
9==> [Client id : 9 & telephone id : 2838249] 

=================================================================================================
  
----------------------------------------------------------------------------------------------------
PRESS 1 TO ADD A CLIENT
PRESS 2 TO DISPLAY CLIENT DETAILS
PRESS 3 TO DELETE CLIENT DETAILS
PRESS 4 TO SEARCH CLIENT DETAILS
PRESS 0 TO EXIT
----------------------------------------------------------------------------------------------------
 
3
  
ENTER THE CLIENT ID TO BE DELETED : 
68933
THE CLIENT HAS BEEN FOUND
[Client id : 68933 & telephone id : 8470949]THE CLIENT HAS BEEN DELETED SUCCESSFULLY
 
 
----------------------------------------------------------------------------------------------------
PRESS 1 TO ADD A CLIENT
PRESS 2 TO DISPLAY CLIENT DETAILS
PRESS 3 TO DELETE CLIENT DETAILS
PRESS 4 TO SEARCH CLIENT DETAILS
PRESS 0 TO EXIT
----------------------------------------------------------------------------------------------------
 
2
  
 
==========================================HASH TABLE=============================================
 
 
0==> [Client id : 200 & telephone id : 67588990] 
1==> [Client id : 1 & telephone id : 8939804] 
2==> [Client id : 22 & telephone id : 76812499] 
3==> [Client id : 5643 & telephone id : 248438050] 
4==> [Client id : 7824 & telephone id : 37898493] 
5==> [Client id : 79955 & telephone id : 83129490] 
6==> [Client id : 66 & telephone id : 83499] 
7==> [Client id : 557 & telephone id : 87490930] 
8==> [Client id : 678 & telephone id : 387297470] 
9==> [Client id : 9 & telephone id : 2838249] 

=================================================================================================
  
----------------------------------------------------------------------------------------------------
PRESS 1 TO ADD A CLIENT
PRESS 2 TO DISPLAY CLIENT DETAILS
PRESS 3 TO DELETE CLIENT DETAILS
PRESS 4 TO SEARCH CLIENT DETAILS
PRESS 0 TO EXIT
----------------------------------------------------------------------------------------------------
 
0
  
 
THANKYOU
 

*/
