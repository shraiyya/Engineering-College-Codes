//Create a student result database in Java. Calculate the grades of students. 
package studentdata;


import java.util.Scanner;

class student
{
Scanner s=new Scanner(System.in);
String name,emailid;
int rollno,mark1,mark2,mark3,total;
double percent;
char grade;
//parameterized constructor of class student
student(String n, String e,int r,
int m1,int m2,int m3)
{
name=n;
emailid=e;
rollno=r;
mark1=m1;
mark2=m2;
mark3=m3;
}
//function to display data
void display()
{
System.out.println("name: "+name);
System.out.println("email id: "+emailid);
System.out.println("roll no : "+rollno);
System.out.println("marks 1: "+mark1);
System.out.println("marks 2: "+mark2);
System.out.println("marks 3: "+mark3);
System.out.println(" ");
}
//static function for calculation of grade and percentage
static void calculate(student s[], int size)
{
	int i=0;
	for (i = 0; i < size; i++) {
s[i].total=(s[i].mark1+s[i].mark2+s[i].mark3);
s[i].percent=(s[i].total)/3;
System.out.println("total  of  :"+s[i].name+" is "+s[i].total);
System.out.println("percent of  :"+s[i].name+" is "+s[i]. percent);
if(s[i].percent>=80)
{
System.out.println("Grade A");
}else if(s[i].percent>=60)
{
System.out.println("Grade B");
}else if(s[i].percent>=50)
{
System.out.println("Grade C");
}else if(s[i].percent>36)
{
System.out.println("Grade D");
}else if(s[i].percent<=35)
{
System.out.println("Grade F");
}
System.out.println(" ");
	}
	System.out.println(" ");
} 
//static function to find the topper in class
static void topper (student s[], int size) 
{
 int i = 0;
 int k = 0, k1 = 0, k2 = 0, k3 = 0;
 int max = s[0].total;
 int max2 = s[0].mark2;
 int max3 = s[0].mark3;
 int max1 = s[0].mark1;
 for (i = 0; i < size; i++) {
  if (max < s[i].total) {
   max = s[i].total;
   k = i;
  }
  if (max1 < s[i].mark1) {
   max1 = s[i].mark1;
   k1 = i;
  }
  if (max2 < s[i].mark2) {
   max2 = s[i].mark2;
   k2 = i;
  }
  if (max3 < s[i].mark3) {
   max3 = s[i].mark3;
   k3 = i;
  }
 }
 System.out.println("The Topper is  " + s[k].name);
 System.out.println("Topper for Subject 1 is  " + s[k1].name);
 System.out.println("Topper for Subject 2 is " + s[k2].name);
 System.out.println("Topper for Subject 3 is  " + s[k3].name);
 System.out.println(" ");
}



//function overloading for eligibility of a student
static void display(student s[],int size,int p)
{
	int i=0;

	for (i = 0; i < size; i++) {

if(s[i].total>=p)
{
System.out.println(s[i].name+" is  eligible");
}else
{
System.out.println(s[i].name +" is not  eligible");
}
	}
	System.out.println(" ");
}
}

public class studentdata {

public static void main(String[] args) {
// TODO Auto-generated method stub
Scanner s1=new Scanner(System.in);
int size;
String n=null;
String e=null;
int r=0,m1=0,m2=0,m3=0;
int i=0,p=0;
System.out.println("enter number of students");
size=s1.nextInt();
//to create array of objects
student s[]=new student[size];

//to accept data from the user
for(i=0;i<size;i++)

{
System.out.println("enter name");
n=s1.next();
System.out.println("enter emailid");
e=s1.next();
System.out.println("enter roll no");
r=s1.nextInt();
System.out.println("enter marks 1");
m1=s1.nextInt();
System.out.println("enter marks 2");
m2=s1.nextInt();
System.out.println("enter marks 3");
m3=s1.nextInt();
System.out.println(" ");
s[i]=new student(n,e,r,m1,m2,m3);
}

 int choice;
 //menu driven program
 do
 {
 System.out.println("enter your choice");
 System.out.println("enter 1 to display records");
 System.out.println("enter 2 to calculate ");
 System.out.println("enter 3 to find eligibility ");
 System.out.println("enter 4 to find topper ");
 System.out.println("enter 0 to exit ");
 System.out.println(" ");
 choice=s1.nextInt();
 switch(choice)
 {
 case 1:
	 for(i=0;i<size;i++)

	 {
 s[i].display();
	 }
 break;
 case 2:
		 student.calculate(s,size);
	  break;
 case 3:
	 System.out.println("Enter the eligibility");
	 p=s1.nextInt();
  student.display(s,size,p);
	   break;
 case 4:
	 
  student.topper(s,size);
  break;
 } 
 }
 while(choice!=0);
 
s1.close();
 
}


}


/**ouput
enter number of students
5
enter name
shreya
enter emailid
shreya@yahoo.com
enter roll no
1
enter marks 1
90
enter marks 2
80
enter marks 3
70
 
enter name
riya
enter emailid
riya@yahoo.com
enter roll no
2
enter marks 1
80
enter marks 2
90
enter marks 3
60
 
enter name
payal
enter emailid
payal@yahoo.com
enter roll no
3
enter marks 1
68
enter marks 2
79
enter marks 3
98
 
enter name
lisa
enter emailid
lisa@yahoo.com
enter roll no
30
enter marks 1
50
enter marks 2
61
enter marks 3
79
 
enter name
ira
enter emailid
ira@yahoo.com
enter roll no
5
enter marks 1
39
enter marks 2
41
enter marks 3
74
 
enter your choice
enter 1 to display records
enter 2 to calculate 
enter 3 to find eligibility 
enter 4 to find topper 
enter 0 to exit 
 
1
name: shreya
email id: shreya@yahoo.com
roll no : 1
marks 1: 90
marks 2: 80
marks 3: 70
 
name: riya
email id: riya@yahoo.com
roll no : 2
marks 1: 80
marks 2: 90
marks 3: 60
 
name: payal
email id: payal@yahoo.com
roll no : 3
marks 1: 68
marks 2: 79
marks 3: 98
 
name: lisa
email id: lisa@yahoo.com
roll no : 30
marks 1: 50
marks 2: 61
marks 3: 79
 
name: ira
email id: ira@yahoo.com
roll no : 5
marks 1: 39
marks 2: 41
marks 3: 74
 
enter your choice
enter 1 to display records
enter 2 to calculate 
enter 3 to find eligibility 
enter 4 to find topper 
enter 0 to exit 
 
2
total  of  :shreya is 240
percent of  :shreya is 80.0
Grade A
 
total  of  :riya is 230
percent of  :riya is 76.0
Grade B
 
total  of  :payal is 245
percent of  :payal is 81.0
Grade A
 
total  of  :lisa is 190
percent of  :lisa is 63.0
Grade B
 
total  of  :ira is 154
percent of  :ira is 51.0
Grade C
 
 
enter your choice
enter 1 to display records
enter 2 to calculate 
enter 3 to find eligibility 
enter 4 to find topper 
enter 0 to exit 
 
3
Enter the eligibility
200
shreya is  eligible
riya is  eligible
payal is  eligible
lisa is not  eligible
ira is not  eligible
 
enter your choice
enter 1 to display records
enter 2 to calculate 
enter 3 to find eligibility 
enter 4 to find topper 
enter 0 to exit 
 
4
The Topper is  payal
Topper for Subject 1 is  shreya
Topper for Subject 2 is riya
Topper for Subject 3 is  payal
 
enter your choice
enter 1 to display records
enter 2 to calculate 
enter 3 to find eligibility 
enter 4 to find topper 
enter 0 to exit 
 
0
**/
