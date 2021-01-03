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
public class RoundRobin {
    String ganttChart="";
    String seq="";
    float avgwt;
    float avgta;
    void roundRobin(int n, int pid[], int a[], int b[], int q) { 
        // result of average times
        int res = 0; 
        int resc = 0; 
  
        // for sequence storage 
//        String seq = new String(); 
        String gantt[] = new String[50];
        int count=0;
  
        // copy the burst array and arrival array 
        // for not effecting the actual array 
        int res_b[] = new int[b.length]; 
        int res_a[] = new int[a.length]; 
        String[] p = new String[n];
  
        for (int i = 0; i < res_b.length; i++) { 
            res_b[i] = b[i]; 
            res_a[i] = a[i];
            p[i]=Integer.toString(pid[i]);
        } 
  
        // critical time of system 
        int t = 0; 
  
        // for store the waiting time 
        int w[] = new int[p.length]; 
  
        // for store the Completion time 
        int ttime[] = new int[p.length]; 
  
        while (true) { 
            boolean flag = true; 
            for (int i = 0; i < p.length; i++) { 
  
                // these condition for if 
                // arrival is not on zero 
  
                // check that if there come before qtime 
                
                if (res_a[i] <= t) { 
                    if (res_a[i] <= q) { 
                        if (res_b[i] > 0) { 
                            flag = false; 
                            if (res_b[i] > q) { 
  
                                // make decrease the b time 
                                t = t + q; 
                                res_b[i] = res_b[i] - q; 
                                res_a[i] = res_a[i] + q; 
                                seq += "->" + p[i]; 
                                ganttChart+= ".|."+p[i];
                                gantt[count]=p[i];
                                count++;
                            } 
                            else { 
  
                                // for last time 
                                t = t + res_b[i]; 
  
                                // store comp time 
                                ttime[i] = t - a[i]; 
  
                                // store wait time 
                                w[i] = t - b[i] - a[i]; 
                                res_b[i] = 0; 
  
                                // add sequence 
                                seq += "->" + p[i];
                                ganttChart+= ".|."+p[i];
                                gantt[count]=p[i];
                                count++;
                            } 
                        } 
                    } 
                    else if (res_a[i] > q) { 
  
                        // is any have less arrival time 
                        // the coming process then execute them 
                        for (int j = 0; j < p.length; j++) { 
  
                            // compare 
                            if (res_a[j] < res_a[i]) { 
                                if (res_b[j] > 0) { 
                                    flag = false; 
                                    if (res_b[j] > q) { 
                                        t = t + q; 
                                        res_b[j] = res_b[j] - q; 
                                        res_a[j] = res_a[j] + q; 
                                        seq += "->" + p[j]; 
                                        ganttChart+= ".|."+p[i];
                                        gantt[count]=p[i];
                                        count++;
                                    } 
                                    else { 
                                        t = t + res_b[j]; 
                                        ttime[j] = t - a[j]; 
                                        w[j] = t - b[j] - a[j]; 
                                        res_b[j] = 0; 
                                        seq += "->" + p[j]; 
                                        ganttChart+= ".|."+p[i];
                                        gantt[count]=p[i];
                                        count++;
                                    } 
                                } 
                            } 
                        } 
  
                        // now the previous porcess according to 
                        // ith is process 
                        if (res_b[i] > 0) { 
                            flag = false; 
  
                            // Check for greaters 
                            if (res_b[i] > q) { 
                                t = t + q; 
                                res_b[i] = res_b[i] - q; 
                                res_a[i] = res_a[i] + q; 
                                seq += "->" + p[i]; 
                                ganttChart+= ".|."+p[i];
                                gantt[count]=p[i];
                                count++;
                            } 
                            else { 
                                t = t + res_b[i]; 
                                ttime[i] = t - a[i]; 
                                w[i] = t - b[i] - a[i]; 
                                res_b[i] = 0; 
                                seq += "->" + p[i]; 
                                ganttChart+= ".|."+p[i];
                                gantt[count]=p[i];
                                count++;
                            } 
                        } 
                    } 
                } 
  
                // if no process is come on thse critical 
                else if (res_a[i] > t) { 
                    t++; 
                    i--; 
                } 
            } 
            // for exit the while loop 
            if (flag) { 
                break; 
            } 
        } 
  
//        System.out.println("name  ctime  wtime"); 
        for (int i = 0; i < p.length; i++) { 
//            System.out.println(" " + p[i] + "    " + ttime[i] 
//                               + "    " + w[i]); 
  
            res = res + w[i]; 
            resc = resc + ttime[i]; 
        } 
  
//        System.out.println("Average waiting time is "
//                           + (float)res / p.length); 
        avgwt=(float)res / p.length;
//        System.out.println("Average compilation  time is "
//                           + (float)resc / p.length); 
        avgta = (float)resc / p.length;
//        System.out.println("Sequence is like that " + seq); 
//        System.out.println("Gantt Chart:");
        
//        String ganttChart = "|.";
//        for (int i = 0; i < count; i++) {
//            ganttChart += gantt[i]+".|.";
//            
//       }
//       System.out.println(ganttChart);
    }
}
