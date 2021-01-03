/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Processing {
    int input;
    Scanner sc = new Scanner(System.in);
    
    void condition(int n, int pid[], int at[], int bt[], int q){
        FCFS fcfs = new FCFS();
        SJF sjf = new SJF();
        RoundRobin rr = new RoundRobin();
        
        rr.roundRobin(n,pid,at,bt,q);
        fcfs.fcfs(n,pid,at,bt);
        sjf.sjf(n,pid,at,bt);
        
        while(true){
        System.out.println("Choose any one:\n" +
                           "1. Show Gantt Chart\n" +
                           "2. Show comparison table");
        input = sc.nextInt();
        if (input==1) {
            System.out.println("Choose any one:\n" +
                           "1. FCFS\n" +
                           "2. SJF preemptive\n" +
                           "3. Round-Robin\nPress Any to back");
            input = sc.nextInt();
            if (input==1) {
                
                GanttChart("FCFS",fcfs.ganttChart);
            }
            else if(input==2){
                
                GanttChart("SFJ(premitive)",sjf.ganttChart);
            }
            else if(input==3){
                
                GanttChart("Round-Robin",rr.ganttChart);
                GanttChart("Round-Robin(Ready-Queue)",rr.seq);
            }
            else return;
        }
        else if(input==2){
            
            System.out.println("Algorithm   Avg. Waiting Time(ms)   Avg. Turnaround Time(ms)\n" +
                           "FCFS\t\t\t"+fcfs.avgwt+"\t\t"+fcfs.avgtat+"\n" +
                           "SJF (Preemptive)\t"+sjf.avgwt+"\t\t"+sjf.avgta+"\n" +
                           "Round-Robin\t\t"+rr.avgwt+"\t\t"+rr.avgta);
        }
        else return;
    }
    }
    static void GanttChart(String name, String ganttchart){
        System.out.println("Gantt Chart of "+ name+": \n"+ ganttchart);
   }
}
