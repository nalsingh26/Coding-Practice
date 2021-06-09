package com.ques.ctci;

import java.util.Scanner;

public class RotateMN {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //row
        sc.nextLine();
        String str[] = new String[N];
        for(int i = 0; i<N; i++)
            str[i] = sc.nextLine();
        int M = str[0].split(" ").length;
        int result[][] = new int[M][N];
        for(int i = 0; i<N; i++){
            String elem[] = str[i].split(" ");
            for(int j = 0; j<M; j++){
                result[j][N-1-i] = Integer.parseInt(elem[j]);

            }
        }
        for(int i = 0; i<M; i++){
            for(int j = 0; j<N; j++)
                System.out.print(result[i][j]+" ");
            System.out.println();
        }
        printBoard(5);
    }

    public void printBoard(int n){
        char color[] = {'W', 'B'};
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                int offset = 1;
                if(i%2 == 0)
                    offset = 0;
                offset = (offset+j%2)%2;
                System.out.print(color[offset]);
            }
            System.out.println();
        }
    }
}



