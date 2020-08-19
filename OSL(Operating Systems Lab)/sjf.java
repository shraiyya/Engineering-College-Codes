import java.util.Scanner;
import java.util.Arrays;

class process
{
	int at,bt,ct,tt,wt,id;
	process()
	{
		at=0;
		bt=0;
		ct=0;
		tt=0;
		wt=0;
		id=0;
	}
		
	
	static void total1(process p[],int n)
	{
		int tot=0,st=0;
        double wsum=0.0,tsum=0.0;
        int f[] = new int[n];
        for(int i=0;i<n;i++) {
        	p[i].tt=0;
        	p[i].wt=0;
        }
        boolean a = true;
		while(true)
		{
			int c=n, min=999;
			if (tot == n) // total no of process = completed process loop will be terminated
				break;
			
			for (int i=0; i<n; i++)
			{
				/*
				 * If i'th process arrival time <= system time and its flag=0 and burst<min 
				 * That process will be executed first 
				 */ 
				if ((p[i].at <= st) && (f[i] == 0) && (p[i].bt<min))
				{
					min=p[i].bt;
					c=i;
				}
			}
			
			/* If c==n means c value can not updated because no process arrival time< system time so we increase the system time */
			if (c==n) 
				st++;
			else
			{
				p[c].ct=st+p[c].bt;
				st+=p[c].bt;
				p[c].tt=p[c].ct-p[c].at;
				p[c].wt=p[c].tt-p[c].bt;
				f[c]=1;
				tot++;
			}
		}
		
		//for calculation of the average
		p[0].tt=p[0].ct-p[0].at;
		p[0].wt=p[0].tt-p[0].bt;
		for(int i=0;i<n;i++)
		{
			tsum=p[i].tt + tsum;
			
			wsum=p[i].wt + wsum;
		}
		System.out.println(" ");
		 System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		//to display the  table
		 System.out.println("PROCESS \t\tARRIVAL TIME\t\tBURST TIME\t\tCOMPLETION TIME\t\tTURNAROUND TIME\t\tWAITING TIME");
		for(int i=0;i<n;i++)
		{
			System.out.println("PROCESS "+(i+1)
					+ "\t\t\t"+p[i].at+"\t\t\t"+p[i].bt+"\t\t\t"+p[i].ct+"\t\t\t"+p[i].tt+"\t\t\t"+p[i].wt);
					
			
		}
		 System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		//display average values
		System.out.println("AVERAGE TURNAROUND TIME OF THE PROCESSES IS "+(tsum)/n);
		System.out.println("AVERAGE WAITING TIME OF THE PROCESSES IS "+(wsum)/n);
		System.out.println(" ");
		
	}
	
	static void total2(process p[],int n)
	{
		double tt1=0.0,wt1=0.0;
		int tot=0,i=0,j=0,st=0;
		int f[] = new int[n]; 
		int k[]= new int[n];
		for(i=0;i<n;i++) {
        	p[i].tt=0;
        	p[i].wt=0;
        }
		 for( i=0;i<n;i++)
 		{
     	  
     	 k[i]=p[i].bt;
 		}
		while(true){
	    	int min=99,c=n;
	    	if (tot==n)
	    		break;
	    	
	    	for ( i=0;i<n;i++)
	    	{
	    		if ((p[i].at<=st) && (f[i]==0) && (p[i].bt<min))
	    		{	
	    			min=p[i].bt;
	    			c=i;
	    		}
	    	}
	    	
	    	if (c==n)
	    		st++;
	    	else
	    	{
	    		p[c].bt--;
	    		st++;
	    		if (p[c].bt==0)
	    		{
	    			p[c].ct= st;
	    			f[c]=1;
	    			tot++;
	    		}
	    	}
	     }
	    
	    for(i=0;i<n;i++)
	    {
	    p[i].tt = p[i].ct - p[i].at;
	    p[i].wt = p[i].tt - k[i];
	    //to calculate average
	    tt1=p[i].tt + tt1;
		wt1=p[i].wt + wt1;
	    }
	    
	    System.out.println(" ");
	    //display the table
	    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	    System.out.println("PROCESS \t\tARRIVAL TIME\t\tBURST TIME\t\tCOMPLETION TIME\t\tTURNAROUND TIME\t\tWAITING TIME");
		for(i=0;i<n;i++)
		{
			System.out.println("PROCESS "+(i+1)+ "\t\t\t"+p[i].at+"\t\t\t"+k[i]+"\t\t\t"+p[i].ct+"\t\t\t"+p[i].tt+"\t\t\t"+p[i].wt);
					
			
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		//to display the average values
		System.out.println(" ");
	    System.out.println("AVERAGE TURNAROUND TIME OF THE PROCESSES IS "+(tt1)/n);
		System.out.println("AVERAGE WAITING TIME OF THE PROCESSES IS "+(wt1)/n);
		System.out.println(" ");
	}
	
	
	static void Ganttchart(process s1[],int size)
	{
System.out.println("GANTT CHART :");
		
		for(int i=0;i<size;i++)
			
		{
		System.out.print("   P"+s1[i].id+" ");
		}
		System.out.println();
		 System.out.println("*************************");
		System.out.print("[0");
        for(int i=0;i<size;i++)
			
		{
		System.out.print("    "+s1[i].ct);
		
		}
       
		System.out.println("]");
		 System.out.println("*************************");
		 System.out.println();
	}
	
	
}
public class sjf{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  Scanner s=new Scanner(System.in);
	  int choice=0;
	        
      do {
    	  System.out.println("---------------------PROCESS SCHEDULING : SRTF & SJF -----------------------");
    	  System.out.println(" ");
    	  System.out.println("PRESS 1 FOR SHORTEST JOB FIRST");
    	  System.out.println("PRESS 2 FOR SRTF");
    	  System.out.println("PRESS O FOR EXIT ");
    	  System.out.println(" ");
    	  System.out.println("PLEASE ENTER YOUR CHOICE: ");
    	  choice=s.nextInt();
    	  switch(choice) {
    	  case 1:
    		  System.out.println("ENTER THE NUMBER OF PROCESSES");
              int n =s.nextInt();
             
              process p[]=new process[n];
              
              for(int i=0;i<n;i++)
        		{
            	  p[i]=new process();
            	  p[i].id=(i+1);
            	  System.out.println("ENTER THE ARRIVAL TIME OF PROCESS");
            	  p[i].at=s.nextInt();
            	  System.out.println("ENTER THE BURST TIME OF PROCESS");
            	  p[i].bt=s.nextInt();
        		}
    		  process.total1(p, n);
    		  process.Ganttchart(p ,n);
    		  System.out.println(" ");
    		  break;
    	  case 2:
    		  System.out.println("ENTER THE NUMBER OF PROCESSES");
              n =s.nextInt();
             
              process p1[]=new process[n];
              
              for(int i=0;i<n;i++)
        		{
            	  p1[i]=new process();
            	  p1[i].id=(i+1);
            	  System.out.println("ENTER THE ARRIVAL TIME OF PROCESS");
            	  p1[i].at=s.nextInt();
            	  System.out.println("ENTER THE BURST TIME OF PROCESS");
            	  p1[i].bt=s.nextInt();
        		}
    		  System.out.println(" ");
    		  process.total2(p1, n);
    		  process.Ganttchart(p1,n);
    		  break;
    	  }
      }while(choice!=0);
      
	}
}

/*
----------------------PROCESS SCHEDULING : SRTF & SJF -----------------------
 
PRESS 1 FOR SHORTEST JOB FIRST
PRESS 2 FOR SRTF
PRESS O FOR EXIT 
 
PLEASE ENTER YOUR CHOICE: 
1
ENTER THE NUMBER OF PROCESSES
4
ENTER THE ARRIVAL TIME OF PROCESS
0
ENTER THE BURST TIME OF PROCESS
6
ENTER THE ARRIVAL TIME OF PROCESS
0
ENTER THE BURST TIME OF PROCESS
2
ENTER THE ARRIVAL TIME OF PROCESS
0
ENTER THE BURST TIME OF PROCESS
5
ENTER THE ARRIVAL TIME OF PROCESS
0
ENTER THE BURST TIME OF PROCESS
3
 
-------------------------------------------------------------------------------------------------------------------------------------
PROCESS 		ARRIVAL TIME		BURST TIME		COMPLETION TIME		TURNAROUND TIME		WAITING TIME
PROCESS 1			0			6			16			16			10
PROCESS 2			0			2			2			2			0
PROCESS 3			0			5			10			10			5
PROCESS 4			0			3			5			5			2
-------------------------------------------------------------------------------------------------------------------------------------
AVERAGE TURNAROUND TIME OF THE PROCESSES IS 8.25
AVERAGE WAITING TIME OF THE PROCESSES IS 4.25
 
GANTT CHART :
   P1    P2    P3    P4 
*************************
[0    16    2    10    5]
*************************

 
---------------------PROCESS SCHEDULING : SRTF & SJF -----------------------
 
PRESS 1 FOR SHORTEST JOB FIRST
PRESS 2 FOR SRTF
PRESS O FOR EXIT 
 
PLEASE ENTER YOUR CHOICE: 
2
ENTER THE NUMBER OF PROCESSES
4
ENTER THE ARRIVAL TIME OF PROCESS
0
ENTER THE BURST TIME OF PROCESS
6
ENTER THE ARRIVAL TIME OF PROCESS
2
ENTER THE BURST TIME OF PROCESS
2
ENTER THE ARRIVAL TIME OF PROCESS
4
ENTER THE BURST TIME OF PROCESS
5
ENTER THE ARRIVAL TIME OF PROCESS
6
ENTER THE BURST TIME OF PROCESS
3
 
 
-------------------------------------------------------------------------------------------------------------------------------------
PROCESS 		ARRIVAL TIME		BURST TIME		COMPLETION TIME		TURNAROUND TIME		WAITING TIME
PROCESS 1			0			6			8			8			2
PROCESS 2			2			2			4			2			0
PROCESS 3			4			5			16			12			7
PROCESS 4			6			3			11			5			2
-------------------------------------------------------------------------------------------------------------------------------------
 
AVERAGE TURNAROUND TIME OF THE PROCESSES IS 6.75
AVERAGE WAITING TIME OF THE PROCESSES IS 2.75
 
GANTT CHART :
   P1    P2    P3    P4 
*************************
[0    8    4    16    11]
*************************

---------------------PROCESS SCHEDULING : SRTF & SJF -----------------------
 
PRESS 1 FOR SHORTEST JOB FIRST
PRESS 2 FOR SRTF
PRESS O FOR EXIT 
 
PLEASE ENTER YOUR CHOICE: 

*/