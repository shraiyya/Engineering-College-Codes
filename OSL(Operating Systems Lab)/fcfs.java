import java.util.*;

class Queue
{
	Process front,rear;

	Queue()
	{
		front=rear=null;
	}
	
	boolean empty()
	{
		if(front==null)
			return true;
		return false;
	}
	
	void add(Process tmp)
	{
		tmp.next=null;
		if(front==null)
			front=rear=tmp;
		else
		{
			rear.next=tmp;
			rear=rear.next;
		}
	}
	
	Process peek()
	{
		return front;
	}
	
	Process remove()
	{
		Process data;
		if(front==null)
			return null;
		else 
		{
			data=front;
			front=front.next;
			return data;
		}
	}
}

class Process
{
	Process next;
	int AT,BT,CT,TT,WT,RT,PID;
	Scanner s=new Scanner(System.in);

	void acceptFCFS(int i)
	{
		System.out.println("ENTER THE ARRIVAL TIMES OF THE PROCESS "+(i+1)+" : ");
		AT=s.nextInt();
		System.out.println("ENTER THE BURST TIME OF THE PROCESS "+(i+1)+" : ");
		BT=s.nextInt();
		PID=i+1;
	}
	
	void acceptRR(int i)
	{
		AT=0;
		System.out.println("ENTER THE BURST TIME OF THE PROCESS "+(i+1)+" : ");
		BT=s.nextInt();
		PID=i+1;
	}
	
	static void calculateFCFS(Process p[],int no)
	{
		int x;
		x=p[0].BT;
		p[0].CT=p[0].BT;
		p[0].TT=p[0].CT-p[0].AT;
		p[0].WT=p[0].TT-p[0].BT;
	
		for(int i=1;i<no;i++)
		{
			x=x+p[i].BT;
			p[i].CT=x;
			p[i].TT=p[i].CT-p[i].AT;
			p[i].WT=p[i].TT-p[i].BT;
		}
	}
	
	static void calculateRR(Process p[],int no,int qn)
	{	
		Process pr=new Process();
		int q1,c=0,curr=0,t=0;
		Queue q=new Queue();
		int finish[]=new int[100];
		int pidarr[]=new int[100];
		
		for(int i=0;i<no;i++)
		{
			p[i].RT=p[i].BT;
			q.add(p[i]);
		}
		
		while(c < no)
		{
			q1=qn;
			pr=q.remove();
			if(pr.RT > qn)
			{
				while(q1 > 0)
				{
					curr++;
					q1--;
					finish[t]=curr;
					pidarr[t]=pr.PID;
					t++;
				}
				pr.RT=pr.RT - qn;
				q.add(pr);
			}
			else
			{
				while(pr.RT > 0)
				{
					pr.RT--;
					curr++;
					finish[t]=curr;
					pidarr[t]=pr.PID;
					t++;
				}
				
				if(pr.RT==0)
				{
					pr.CT=curr;
					c++;
				}
			}
		}
		
		for(int i=0;i<no;i++)
        {
        	p[i].TT=p[i].CT-p[i].AT;
        	p[i].WT=p[i].TT-p[i].BT;
        }
		
		System.out.println("\nGANTT CHART IS : ");
		for(int i=0;i<t;i++)
			System.out.format("%5s","P"+pidarr[i]+" |");
		System.out.println();
		
		System.out.print("0");
		for(int i=0;i<t;i++)
			System.out.format("%5s",finish[i]);
		System.out.println();
		System.out.println();
	}

	static void displayFCFS(Process p[],int no)//display of gantt chart
	{
		int time=0;
		System.out.println("\nGANTT CHART : ");
		for(int i=0;i<no;i++)
		{
			time=time+p[i].BT;
			System.out.print("| P"+p[i].PID+" |"+time);
		}
		System.out.println();
		System.out.println();
	}
	
	static void display1(Process p[],int no)//display the table
	{
		float awgTT=0,awgWT=0;		
		
		System.out.format("%10s %15s %13s %17s %17s %15s","Process","Arrival Time","Burst Time","Completion Time","Turnaround Time","Waiting Time");
		System.out.println("              ");
		for(int i=0;i<no;i++)
		{
			System.out.format("%10s %15s %13s %17s %17s %15s","P"+p[i].PID,p[i].AT,p[i].BT,p[i].CT,p[i].TT,p[i].WT);
			System.out.println();
		}
		
		for(int i=0;i<no;i++)
			awgTT=awgTT+p[i].TT;
		System.out.println("     ");
		System.out.println("AVERAGE TURNAROUND TIME OF THE PROCESSES IS  : "+awgTT/no);
		
		for(int i=0;i<no;i++)
			awgWT=awgWT+p[i].WT;
		System.out.println("AVERAGE WAITING TIME OF THE PROCESSES IS  : "+awgWT/no);
	}

	static void sort(int no,Process p[])//for sorting
	{
		Process temp=new Process();
		for(int i=0;i<no-1;i++)          
		{
			for(int j=i+1;j<no;j++)
			{
				if(p[i].AT > p[j].AT)
				{
					temp=p[i];
					p[i]=p[j];
					p[j]=temp;
				}
			}
		}
	}
}

public class fcfs
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int no,ch;
		System.out.print("ENTER THE NUMBER OF PROCESSES : ");
		no=sc.nextInt();
		Process p[]=new Process[no];
		
		do
		{
			System.out.println("   ");
			System.out.println("Press 1 for First come first serve (FCFS)");
			System.out.println("Press 2 for Round robin (RR)");
			System.out.println("press 3 for Exit");
			System.out.print("ENTER YOUR CHOICE : ");
			System.out.println("     ");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1:for(int i=0;i<no;i++)
						{
							p[i]=new Process();
							p[i].acceptFCFS(i);
						}
				
						Process.sort(no,p);
						Process.calculateFCFS(p,no);
						Process.displayFCFS(p,no);
						Process.display1(p,no);
						break;
					
				case 2:int qn;
				        System.out.println("   ");
						System.out.println("ENTER THE TIME QUANTAM  : ");
						qn=sc.nextInt();
						
						for(int i=0;i<no;i++)
						{
							p[i]=new Process();
							p[i].acceptRR(i);
						}
				
						Process.sort(no,p);
						Process.calculateRR(p,no,qn);
						Process.display1(p,no);
						break;
					
				case 3:System.exit(0);
				
				default:System.out.println("YOU HAVE ENTERED THE WRONG CHOICE  ");
			}
		}while(ch>0);
	}
}

/*
ENTER THE NUMBER OF PROCESSES : 4
   
Press 1 for First come first serve (FCFS)
Press 2 for Round robin (RR)
press 3 for Exit
ENTER YOUR CHOICE :      
1
ENTER THE ARRIVAL TIMES OF THE PROCESS 1 : 
0
ENTER THE BURST TIME OF THE PROCESS 1 : 
6
ENTER THE ARRIVAL TIMES OF THE PROCESS 2 : 
2
ENTER THE BURST TIME OF THE PROCESS 2 : 
5
ENTER THE ARRIVAL TIMES OF THE PROCESS 3 : 
4
ENTER THE BURST TIME OF THE PROCESS 3 : 
8
ENTER THE ARRIVAL TIMES OF THE PROCESS 4 : 
6
ENTER THE BURST TIME OF THE PROCESS 4 : 
4

GANTT CHART : 
| P1 |6| P2 |11| P3 |19| P4 |23

   Process    Arrival Time    Burst Time   Completion Time   Turnaround Time    Waiting Time              
        P1               0             6                 6                 6               0
        P2               2             5                11                 9               4
        P3               4             8                19                15               7
        P4               6             4                23                17              13
     
AVERAGE TURNAROUND TIME OF THE PROCESSES IS  : 11.75
AVERAGE WAITING TIME OF THE PROCESSES IS  : 6.0
   
Press 1 for First come first serve (FCFS)
Press 2 for Round robin (RR)
press 3 for Exit
ENTER YOUR CHOICE :      
2
   
ENTER THE TIME QUANTAM  : 
3
ENTER THE BURST TIME OF THE PROCESS 1 : 
7
ENTER THE BURST TIME OF THE PROCESS 2 : 
4
ENTER THE BURST TIME OF THE PROCESS 3 : 
2
ENTER THE BURST TIME OF THE PROCESS 4 : 
5

GANTT CHART IS : 
 P1 | P1 | P1 | P2 | P2 | P2 | P3 | P3 | P4 | P4 | P4 | P1 | P1 | P1 | P2 | P4 | P4 | P1 |
0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17   18

   Process    Arrival Time    Burst Time   Completion Time   Turnaround Time    Waiting Time              
        P1               0             7                18                18              11
        P2               0             4                15                15              11
        P3               0             2                 8                 8               6
        P4               0             5                17                17              12
     
AVERAGE TURNAROUND TIME OF THE PROCESSES IS  : 14.5
AVERAGE WAITING TIME OF THE PROCESSES IS  : 10.0
   
Press 1 for First come first serve (FCFS)
Press 2 for Round robin (RR)
press 3 for Exit
ENTER YOUR CHOICE :      
0
YOU HAVE ENTERED THE WRONG CHOICE  

*/