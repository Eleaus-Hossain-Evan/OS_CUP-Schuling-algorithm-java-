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
public class FCFS {
    String ganttChart="";
    float avgwt;
    float avgtat;
    void fcfs(int n, int pid[], int ar[], int bt[]){
        int numberOfProcesses = n;

//	int pid[] = new int[numberOfProcesses];
//	int bt[] = new int[numberOfProcesses];
//	int ar[] = new int[numberOfProcesses];
	int ct[] = new int[numberOfProcesses];
	int ta[] = new int[numberOfProcesses];
	int wt[] = new int[numberOfProcesses];
//        int avgwt = 0, avgtat = 0;

//	for(int i = 0; i < numberOfProcesses; i++) {
//	    System.out.println("Enter process " + (i+1) + " arrival time: ");
//	    ar[i] = in.nextInt();
//	    System.out.println("Enter process " + (i+1) + " brust time: ");
//	    bt[i] = in.nextInt();
//	    pid[i] = i+1;
//	}
	int temp;
	for (int i = 0; i < numberOfProcesses; i++) {
	    for (int j = i+1; j < numberOfProcesses; j++) {

	        if(ar[i] > ar[j]) {
	            temp = ar[i];
	            ar[i] = ar[j];
	            ar[j] = temp;

	            temp = pid[i];
	            pid[i] = pid[j];
	            pid[j] = temp;
	            temp = bt[i];
	            bt[i] = bt[j];
	            bt[j] = temp;
	        }
	    }
	}

	System.out.println();
	ct[0] = bt[0] + ar[0];
	for(int i = 1; i < numberOfProcesses; i++) {
	    ct[i] = ct[i - 1] + bt[i];
	}
	for(int i = 0; i < numberOfProcesses; i++) {
	    ta[i] = ct[i] - ar[i];
	    wt[i] = ta[i] - bt[i];
            avgwt+=wt[i];
            avgtat+=ta[i];
	}
//	System.out.println("Process\t\tAT\t\tBT\t\tTAT\t\tWT");
//	for(int i = 0; i < numberOfProcesses; i++) {
//	    System.out.println(pid[i]+"\t\t" + ar[i] + "\t\t" + bt[i]+ "\t\t" + ta[i]+ "\t\t" + wt[i]);
//	}

//	System.out.println("gantt chart: ");
        ganttChart="0";
	for(int i = 0; i < numberOfProcesses; i++) {
	    ganttChart+=("|_P" + pid[i] +"_|"+(i+1));
	}
        avgwt=(float)avgwt/numberOfProcesses;
                
        avgtat=(float)avgtat/numberOfProcesses;
                
//        System.out.println("A.Wait time: "+avgwt);
//        System.out.println("A.TrunAround time: "+avgtat);
//        System.out.println("Gantt Chart-\n"+ganttChart);
    }
}
