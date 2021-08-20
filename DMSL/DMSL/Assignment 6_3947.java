//Name : shreya pawaskar
//Roll no : 3947
//Assignment 6

package jdbc;
import java.sql.*;
import java.util.Scanner;


public class assignment6_3947 {

	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/sample_database";
	static final String USER="root";
	static final String PASS="mysql";
	public static void main(String[] args) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String query;
		Scanner scan=new Scanner(System.in);
		int choice,ans;
		
		do {
			System.out.println("  ");
			System.out.println("PRESS 1 TO ADD ");
			System.out.println("PRESS 2 TO DISPLAY ");
			System.out.println("PRESS 3 TO DELETE ");
			System.out.println("PRESS 4 TO UPDATE ");
			System.out.println("PRESS 5 TO DISPLAY BY NUMBER ");
			System.out.println("PRESS 0 TO EXIT");
			System.out.println("  ");
			choice=scan.nextInt();
			
			switch(choice) {
			case 1:
				try {
					Class.forName(JDBC_DRIVER);
					conn=DriverManager.getConnection(DB_URL,USER,PASS);
					query="insert into person values(?,?,?,?)";
					pstmt=conn.prepareStatement(query);
					System.out.println("ENTER THE NUMBER OF THE PERSON : ");
					int person_no=scan.nextInt();
					System.out.println("ENTER THE NAME OF THE PERSON :");
					String name=scan.next();
					System.out.println("ENTER THE ADDRESS (CITY) OF THE PERSON :");
					String addr=scan.next();
					System.out.println("ENTER MOBILE NUMBER  OF THE PERSON: ");
					String phone_no=scan.next();
					
					pstmt.setInt(1, person_no);
					pstmt.setString(2, name);
					pstmt.setString(3, addr);
					pstmt.setString(4, phone_no);
					pstmt.executeUpdate();
					
					
					pstmt.close();
					conn.close();
					System.out.println("RECORD HAS BEEN ADDED IN THE DB");
					System.out.println("");
				}
				catch(ClassNotFoundException e)
				{
					e.printStackTrace();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					Class.forName(JDBC_DRIVER);
					conn=DriverManager.getConnection(DB_URL,USER,PASS);
					query="select * from person";
					pstmt=conn.prepareStatement(query);
					ResultSet rs=pstmt.executeQuery(query);
					System.out.println("  ");
					System.out.println("Owner number :"+"  Name : "+"  Address :"+"  Phone number :");
					while(rs.next())
					{
						int person_no=rs.getInt("person_no");
						String name=rs.getString("name");
						String addr=rs.getString("address");
						String phone_no=rs.getString("phone_no");
						System.out.println(person_no+"\t\t\t\t"+name+"\t\t"+addr+"\t"+phone_no);
					}
					System.out.println("");
					rs.close();
					pstmt.close();
					conn.close();
					
				}
				catch(ClassNotFoundException e)
				{
					e.printStackTrace();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					Class.forName(JDBC_DRIVER);
					conn=DriverManager.getConnection(DB_URL,USER,PASS);
					System.out.println("ENTER NUMBER TO BE DELETED ");
					int num=scan.nextInt();
					query="delete from person where person_no=?";
					pstmt=conn.prepareStatement(query);
					pstmt.setInt(1,num);
					pstmt.executeUpdate();
					pstmt.close();
					conn.close();
					
					
				}
				catch(ClassNotFoundException e)
				{
					e.printStackTrace();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					Class.forName(JDBC_DRIVER);
					conn=DriverManager.getConnection(DB_URL,USER,PASS);
					System.out.println("ENTER NUMBER FOR UPDATION : ");
					int num=scan.nextInt();
					System.out.println("PRESS 1 TO UPDATE NUMBER(ID) ");
					System.out.println("PRESS 2 TO UPDATE NAME");
					System.out.println("PRESS 3 TO UPDATE ADDRESS");
					System.out.println("PRESS 4 TO UPDATE PHONE NUMBER");
					int ch=scan.nextInt();
					switch(ch)
					{
					case 1:
						System.out.println("ENTER NEW PERSONN NUMBER :");
						int n=scan.nextInt();
						query="update person set person_no=? where person_no=?";
						pstmt=conn.prepareStatement(query);
						pstmt.setInt(1, n);
						pstmt.setInt(2, num);
						break;
					case 2:
						System.out.println("ENTER THE NEW NAME : ");
						String name=scan.next();
						query="update person set name=? where person_no=?";
						pstmt=conn.prepareStatement(query);
						pstmt.setString(1, name);
						pstmt.setInt(2, num);
						break;
					case 3:
						System.out.println("ENTER NEW CITY :");
						String addr=scan.next();
						query="update person set address=? where person_no=?";
						pstmt=conn.prepareStatement(query);
						pstmt.setString(1, addr);
						pstmt.setInt(2, num);
						break;
					case 4:
						System.out.println("ENTER NEW PHONE NO :");
						long no=scan.nextLong();
						query="update person set phone_no=? where person_no=?";
						pstmt=conn.prepareStatement(query);
						pstmt.setLong(1, no);
						pstmt.setInt(2, num);
						break;
					}
					pstmt.executeUpdate();
					System.out.println("UPDATION HAS BEEN DONE SUCCESSFULLY");
					System.out.println("");
					pstmt.close();
					conn.close();
				}
				catch(ClassNotFoundException e)
				{
					e.printStackTrace();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					Class.forName(JDBC_DRIVER);
					conn=DriverManager.getConnection(DB_URL,USER,PASS);
					System.out.println("  ");
					System.out.println("ENTER PERSON NUMBER: ");
					int num=scan.nextInt();
					query="select * from person where person_no=?";
					pstmt=conn.prepareStatement(query);
					pstmt.setInt(1, num);
					ResultSet rs=pstmt.executeQuery();
					System.out.println("");
					while(rs.next())
					{
						int person_no=rs.getInt("person_no");
						String name=rs.getString("name");
						String addr=rs.getString("address");
						String phone_no=rs.getString("phone_no");
						System.out.println("Owner number :"+"  Name : "+"  Address :"+"  Phone number :");
						System.out.println(person_no+"\t\t\t"+name+"\t\t"+addr+"\t"+phone_no);
					}
					rs.close();
					pstmt.close();
					conn.close();
					
				}
				catch(ClassNotFoundException e)
				{
					e.printStackTrace();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				break;
			}
				
			System.out.println("DO YOU WANT TO CONTINUE?(1=YES / 2=N0)");
			ans=scan.nextInt();
			System.out.println("  ");
		}while(ans==1);
		
		
		
	}
		
}

/***********OUTPUT*******
 * 
PRESS 1 TO ADD 
PRESS 2 TO DISPLAY 
PRESS 3 TO DELETE 
PRESS 4 TO UPDATE 
PRESS 5 TO DISPLAY BY NUMBER 
PRESS 0 TO EXIT
1

ENTER THE NUMBER OF THE PERSON : 
1

ENTER THE NAME OF THE PERSON :
shreya
ENTER THE ADDRESS (CITY) OF THE PERSON :
pune
ENTER MOBILE NUMBER  OF THE PERSON: 
9877123345
RECORD HAS BEEN ADDED IN THE DB

DO YOU WANT TO CONTINUE?(1=YES / 2=N0)
1

PRESS 1 TO ADD 
PRESS 2 TO DISPLAY 
PRESS 3 TO DELETE 
PRESS 4 TO UPDATE 
PRESS 5 TO DISPLAY BY NUMBER 
PRESS 0 TO EXIT
  
2
Owner number :  Name :   Address :  Phone number :
1		shreya	 pune	        9877123345

DO YOU WANT TO CONTINUE?(1=YES / 2=N0)
1

PRESS 1 TO ADD 
PRESS 2 TO DISPLAY 
PRESS 3 TO DELETE 
PRESS 4 TO UPDATE 
PRESS 5 TO DISPLAY BY NUMBER 
PRESS 0 TO EXIT
  
1
ENTER THE NUMBER OF THE PERSON : 
2
ENTER THE NAME OF THE PERSON :
sunita
ENTER THE ADDRESS (CITY) OF THE PERSON :
mumbai
ENTER MOBILE NUMBER  OF THE PERSON: 
88771200934
RECORD HAS BEEN ADDED IN THE DB

DO YOU WANT TO CONTINUE?(1=YES / 2=N0)
1

PRESS 1 TO ADD 
PRESS 2 TO DISPLAY 
PRESS 3 TO DELETE 
PRESS 4 TO UPDATE 
PRESS 5 TO DISPLAY BY NUMBER 
PRESS 0 TO EXIT
  
1
ENTER THE NUMBER OF THE PERSON : 
3
ENTER THE NAME OF THE PERSON :
mihika
ENTER THE ADDRESS (CITY) OF THE PERSON :
nashik
ENTER MOBILE NUMBER  OF THE PERSON: 
99126804383
RECORD HAS BEEN ADDED IN THE DB

DO YOU WANT TO CONTINUE?(1=YES / 2=N0)

1
PRESS 1 TO ADD 
PRESS 2 TO DISPLAY 
PRESS 3 TO DELETE 
PRESS 4 TO UPDATE 
PRESS 5 TO DISPLAY BY NUMBER 
PRESS 0 TO EXIT
  
1
ENTER THE NUMBER OF THE PERSON : 
4
ENTER THE NAME OF THE PERSON :
nisha
ENTER THE ADDRESS (CITY) OF THE PERSON :
jammu
ENTER MOBILE NUMBER  OF THE PERSON: 
97710772840
RECORD HAS BEEN ADDED IN THE DB

DO YOU WANT TO CONTINUE?(1=YES / 2=N0)

1
PRESS 1 TO ADD 
PRESS 2 TO DISPLAY 
PRESS 3 TO DELETE 
PRESS 4 TO UPDATE 
PRESS 5 TO DISPLAY BY NUMBER 
PRESS 0 TO EXIT
  
2
Owner number :  Name :   Address :  Phone number :
1		shreya	 pune		9877123345
2		sunita	 mumbai		88771200934
3		mihika	 nashik		99126804383
4		nisha	 jammu		97710772840

DO YOU WANT TO CONTINUE?(1=YES / 2=N0)
1

PRESS 1 TO ADD 
PRESS 2 TO DISPLAY 
PRESS 3 TO DELETE 
PRESS 4 TO UPDATE 
PRESS 5 TO DISPLAY BY NUMBER 
PRESS 0 TO EXIT
  
4
ENTER NUMBER FOR UPDATION : 
1
PRESS 1 TO UPDATE NUMBER(ID) 
PRESS 2 TO UPDATE NAME
PRESS 3 TO UPDATE ADDRESS
PRESS 4 TO UPDATE PHONE NUMBER
2
ENTER THE NEW NAME : 
riya

DO YOU WANT TO CONTINUE?(1=YES / 2=N0)

1

PRESS 1 TO ADD 
PRESS 2 TO DISPLAY 
PRESS 3 TO DELETE 
PRESS 4 TO UPDATE 
PRESS 5 TO DISPLAY BY NUMBER 
PRESS 0 TO EXIT
  
2
Owner number :  Name :   Address :  Phone number :
1		riya	 pune		9877123345
2		sunita	 mumbai		88771200934
3		mihika	 nashik		99126804383
4		nisha	 jammu		97710772840

DO YOU WANT TO CONTINUE?(1=YES / 2=N0)
1

PRESS 1 TO ADD 
PRESS 2 TO DISPLAY 
PRESS 3 TO DELETE 
PRESS 4 TO UPDATE 
PRESS 5 TO DISPLAY BY NUMBER 
PRESS 0 TO EXIT
5

ENTER PERSON NUMBER: 
4

Owner number :  Name :   Address :  Phone number :
4		nisha	 jammu	       97710772840

DO YOU WANT TO CONTINUE?(1=YES / 2=N0)
1

PRESS 1 TO ADD 
PRESS 2 TO DISPLAY 
PRESS 3 TO DELETE 
PRESS 4 TO UPDATE 
PRESS 5 TO DISPLAY BY NUMBER 
PRESS 0 TO EXIT
  
3
ENTER NUMBER TO BE DELETED 
3
DO YOU WANT TO CONTINUE?(1=YES / 2=N0)

1
PRESS 1 TO ADD 
PRESS 2 TO DISPLAY 
PRESS 3 TO DELETE 
PRESS 4 TO UPDATE 
PRESS 5 TO DISPLAY BY NUMBER 
PRESS 0 TO EXIT
  
2

Owner number :  Name :     Address :  Phone number :
1		riya	   pune	          9877123345
2		sunita	   mumbai	 88771200934
4		nisha	   jammu	 97710772840

DO YOU WANT TO CONTINUE?(1=YES / 2=N0)

2

 * */


