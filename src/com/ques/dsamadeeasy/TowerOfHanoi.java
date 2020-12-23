package com.ques.dsamadeeasy;
import java.util.*;
public class TowerOfHanoi {
    // time complexity 2^n
    public void run(){
        Scanner in = new Scanner(System.in);
        System.out.println("From tower: A, To tower: C, Auxillary tower: B");
        System.out.print("Enter number of disks in the tower: ");
        int n = in.nextInt();
        printMoves(n,'A', 'C', 'B');
    }
    private void printMoves(int n, char from, char to, char aux){
        if(n==1){
            System.out.format("Move disk %d from %s to %s \n", n,from,to);
            return;
        }
        printMoves(n-1, from, aux, to);
        System.out.format("Move disk %d from %s to %s \n", n, from, to);
        printMoves(n-1, aux, to, from);
    }
}
