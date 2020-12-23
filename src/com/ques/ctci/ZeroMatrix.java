package com.ques.ctci;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Chap-1
 * Write a program such that if an element in an MxN matrix is 0, its entire row and column is set
 * to zero as well
 */
public class ZeroMatrix {
    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("This program requires a MxN matrix");
        System.out.print("Enter the value of M: ");
        int M = sc.nextInt();
        System.out.print("Enter the value of N: ");
        int N= sc.nextInt();
        int[][] arr = new int[M][N];
        for(int i=0; i<M; i++){
            System.out.format("Enter row no. %d. Separate each value by a space: ", i+1);
            for(int j=0; j<N; j++)
                arr[i][j] = Integer.parseInt(sc.next());
        }
        zerofy(arr);
        for(int i = 0; i<M;i++){
            for(int j=0; j<N; j++)
                System.out.print(arr[i][j]+ " ");
            System.out.println("");
        }
    }

    private void zerofy(int[][] arr) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        int m = arr.length, n =arr[0].length;
        for(int i=0; i<m; i++){
            boolean isRowZero=false;
            for(int j=0; j<n; j++){
                if(arr[i][j]==0){
                    cols.add(j);
                    isRowZero = true;
                }
                if(isRowZero)
                    rows.add(i);
            }
        }
        for(Integer row: rows){
            for(int i=0; i<n; i++)
                arr[row][i]=0;
        }
        for(Integer col: cols){
            for(int i=0; i<m; i++)
                arr[i][col]=0;
        }
    }
}
