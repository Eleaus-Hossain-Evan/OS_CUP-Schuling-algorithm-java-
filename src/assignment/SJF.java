/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author User
 */
public class SJF {
    String ganttChart="";
    float avgwt;
    float avgta;
    void sjf(int n, int pid[], int at[], int bt[]){
        
//	int pid[] = new int[n]; // it takes pid of process
//	int at[] = new int[n]; // at means arrival time
//	int bt[] = new int[n]; // bt means burst time
	int ct[] = new int[n]; // ct means complete time
	int ta[] = new int[n];// ta means turn around time
	int wt[] = new int[n];  // wt means waiting time
	int f[] = new int[n];  // f means it is flag it checks process is completed or not
	int k[]= new int[n];   // it is also stores brust time
        int i, st=0, tot=0;
                
//	float avgwt=0, avgta=0;
//           
	for (i=0;i<n;i++){
//	    pid[i]= i+1;
//	    System.out.println ("enter process " +(i+1)+ " arrival time:");
//	    at[i]= sc.nextInt();
//	    System.out.println("enter process " +(i+1)+ " burst time:");
//	    bt[i]= sc.nextInt();
	    k[i]= bt[i];
	    f[i]= 0;
	}
            
        System.out.println("\n\n\n");
	String gt="";
	while(true){
	    int min=99,c=n;
	    if (tot==n)
	    	break;
	    	
	    for ( i=0;i<n;i++){
	    	if ((at[i]<=st) && (f[i]==0) && (bt[i]<min)){	
                    min=bt[i];
                    c=i;
                }
	    }
	    	
	    if (c==n)
	    	st++;
	    else{
	    	bt[c]--;
	    	st++;
	    	if (bt[c]==0){
                    ct[c]= st;
                    f[c]=1;
                    tot++;
                }
	    }
                
            gt+=Integer.toString(c+1);   
	}
            
	    
	    
	    
	for(i=0;i<n;i++){
	    ta[i] = ct[i] - at[i];
	    wt[i] = ta[i] - k[i];
	    avgwt+= wt[i];
	    avgta+= ta[i];
	}
//	System.out.println("\n");
//	System.out.println("pid  arrival  burst  turn waiting");
//	for(i=0;i<n;i++){
//	    System.out.println(pid[i] +"\t"+ at[i]+"\t"+ k[i] +"\t"+ ta[i] +"\t"+ wt[i]);
//	}
        ganttChart="0";
        for(i=0;i<gt.length();i++){
	    ganttChart+="|_P"+ gt.charAt(i)+"_|"+(i+1);
	}
	avgta=(float)(avgta/n);
       
        avgwt=(float)(avgwt/n);
//	System.out.println("\naverage tat is "+avgta);
//	System.out.println("average wt is "+avgwt);
//        System.out.println("Gantt Chart:\n"+ganttChart);
    }
}
