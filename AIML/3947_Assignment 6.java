/*
 NAME : SHREYA CHETAN PAWASKAR
 ROLL NO : 3947
 C-NO : C22018881961
 TITLE : UNIFICATION
 */

import java.util.*;


public class Unification {

	int flag=0,c=0;
	Map<String,String> hash=new HashMap<>();
	
	public int Unify(Stack<String> stack1,Stack<String> stack2)		
	{

		//check for the correct no of parameters
		if(stack1.size()!=stack2.size())						   
		{
			System.out.println("UNSUCCESSFUL");
			System.out.println("THE NUMBER OF PARAMETERS IS DIFFERENT");
			return 0;
		}
		
		//check if function names are correct
		if(!stack1.elementAt(0).equals(stack2.elementAt(0)))	   
		{
			System.out.println("FUNCTION NAMES ARE NOT SAME");
			return 0;
		}
		
		for(int i=1;i<stack1.size();i++)
		{
			String str1=stack1.elementAt(i);			
			String str2=stack2.elementAt(i);
			
			// if both the strings are same
			if(str1==str2)								   
			{}
			
			else if(str1.length()==1)
			{
				if(check_duplicate(hash,str1,str2)==0)
				{
					flag=1;
					return 0;
				}
				else if(check_duplicate(hash,str1,str2)==1)
				{}
				else
				{
					
					hash.put(str1, str2);
				}
			}
			else if(str2.length()==1)
			{
				if(check_duplicate(hash,str1,str2)==0)
				{
					flag=1;
					return 0;
				}
				else if(check_duplicate(hash,str1,str2)==1)
				{}
				else
				{
					hash.put(str2, str1);
				}
			}
			
			//check the opening brackets
			else if(str1.contains("(")==true && str2.contains("(")==true)
			{
				if(Unify(Separate(str1),Separate(str2))==0)
				{
					return 0;
				}
			}
			else if(str1.contains("(")==true && str2.contains("(")==false && flag==0)
			{
				// if not duplicate
				if(check_duplicate(hash,str1,str2)==0)
				{
					//set flag =1 and return 0
					flag=1;
					return 0;
				}
				else if(check_duplicate(hash,str1,str2)==1)
				{}
				
				else
				{
					//put strings in the hash
					hash.put(str1, str2);
				}
			}
		}
		return 1;
	}
	
	public Stack<String> Separate(String str)			  
	{
		int i=0,k=0,temp,j=0;
		Stack<Character> s=new Stack<Character>();
		Stack<String> st=new Stack<String>();
		
		int n=str.length();
		i=str.indexOf('('); 		 
		st.push(str.substring(k,i)); 
		k=i+1;
		for(i=k;i<n;i++)			
		{
			char current=str.charAt(i);
			
			if((current>='a' && current<='z') || (current>='A' && current<='Z'))
			{
				continue;
			}						
			if(current==',' || current==')')
			{
				if(s.isEmpty())		
				{
					st.push(str.substring(k, i));
					k=i+1;
					continue;
				}
			}
			// if current character is an opening bracket
			else if(current=='(')
			{
				s.push(current);
			} 
			// if current character is a closing bracket
			if(current==')')
			{
				if(s.peek()=='(' && !s.isEmpty())
				{
					s.pop();		//pop out the character on top	
				} 
			}
				
		}
		
		return st;
	}
	
	// check for duplicate characters	
	int check_duplicate(Map<String,String>hash,String str1,String str2)
	{
		c++;
		for(Map.Entry<String, String>entry : hash.entrySet())
		{
			String temp=entry.getKey();
			
			if(temp.equals(str1))
			{
				if(entry.getValue().equals(str2))
				{
					System.out.println(temp+"\t"+entry.getValue());
					return 1;
				}
				else 
				{
					System.out.println(temp+" HAVE DIFFERENT VALUES");
					return 0;
				}
			}
			
		}
		
		return 2;
	}
	
	void display_answer()
	{
		for(Map.Entry<String, String> entry : hash.entrySet())
		{
			System.out.println(entry.getKey()+" / "+entry.getValue());			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int a=1;
		do
		{
		String str1,str2;
		int ans;
		System.out.print("ENTER STRING 1: ");		
		str1=s.next();
		System.out.print("ENTER STRING 2: ");
		str2=s.next();
		Unification u=new Unification();
		
		Stack<String> stack1=new Stack<String>();
		Stack<String> stack2=new Stack<String>();
		
		stack1=u.Separate(str1);
		stack2=u.Separate(str2);
		ans=u.Unify(stack1,stack2);
		
		if(ans!=0 && u.flag==0)
		{
			u.display_answer();
		}
		else if(u.flag==1)
		{
			System.out.println("NOT UNIFIED");
		}
		System.out.println("");
		System.out.println("PRESS 1 TO CONTINUE.");
		System.out.println("PRESS 0 TO EXIT.");
		a=s.nextInt();
		System.out.println(" ");
		}while(a!=0);

	}

}

/*
ENTER STRING 1: f(a,b)
ENTER STRING 2: g(a,b)

FUNCTION NAMES ARE NOT SAME

PRESS 1 TO CONTINUE.
PRESS 0 TO EXIT.
1
 
ENTER STRING 1: f(a,b)
ENTER STRING 2: f(x,y)

a / x
b / y

PRESS 1 TO CONTINUE.
PRESS 0 TO EXIT.
1
 
ENTER STRING 1: f(x,g(y))
ENTER STRING 2: f(m,n)

x / m
n / g(y)

PRESS 1 TO CONTINUE.
PRESS 0 TO EXIT.
1
 
\
ENTER STRING 1: f(x,g(z,y))
ENTER STRING 2: f(m,g(n,o))

x / m
y / o
z / n

PRESS 1 TO CONTINUE.
PRESS 0 TO EXIT.
1
 
ENTER STRING 1: q(a,g(x,a),f(y))
ENTER STRING 2: q(i,o)
UNSUCCESSFUL
THE NUMBER OF PARAMETERS IS DIFFERENT

PRESS 1 TO CONTINUE.
PRESS 0 TO EXIT.
0
*/
