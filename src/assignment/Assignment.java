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
public class Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int[] pid, at, bt;
        int n, q;
        System.out.println("Enter the number of Process:");
        n=sc.nextInt();
        pid = new int[n];
        at = new int[n];
        bt = new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter arrival time for process p"+(i+1)+": ");
            at[i]= sc.nextInt();
            pid[i]=i+1;
        }
        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time for process p"+(i+1)+": ");
            bt[i]= sc.nextInt();
        }
        System.out.print("\nEnter Quantum for RoundRobin: ");
        q = sc.nextInt();
        Processing process = new Processing();
        process.condition(n, pid, at, bt, q);
    }
    
}
