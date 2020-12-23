package com.ques.ctci;

import java.util.Scanner;

/**
 * Chap-1
 * Given an image represented by NxN matrix where each pixel in the image is 4 byte, write a
 * method to rotate the matrix in place by 90 degree.
 */
public class RotateArrayBy90 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++){
            System.out.format("Enter row no. %d. Separate each value by a space: ", i+1);
            for(int j=0; j<N; j++)
                arr[i][j] = Integer.parseInt(sc.next());
        }
        rotate(arr);
        for(int i = 0; i<N;i++){
            for(int j=0; j<N; j++)
                System.out.print(arr[i][j]+ " ");
            System.out.println("");
        }
    }
    private boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix. length != matrix[0].length)
            return false;
        int n = matrix. length;
        for (int i = 0; i < n / 2; i++) {
            int first = i;
            int last = n - 1 - i;
            for(int j = first; j < last; j++) {
                int top = matrix[first][j]; // save top
                int right = matrix[j][last];
                int bottom = matrix[last][n-1-j];
                int left = matrix[n-1-j][first];

                // left -> top
                matrix[first][j] = left;
                // bottom -> left
                matrix[n-1-j][first] = bottom;
                // right -> bottom
                matrix[last][n-1-j] = right;
                // top -> right
                matrix[j][last]=top;
            }
        }
        return true;
    }/*
    private boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix. length != matrix[0].length)
            return false;
        int n = matrix. length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++) {
                int offset = i-first;
                int top = matrix[first][i]; // save top
                // left -> top
                matrix[first][i]= matrix[last-offset][first];
                // bottom -> left
                matrix[last-offset][first]= matrix[last][last - offset];
                // right -> bottom
                matrix[last][last - offset]=matrix[i][last];
                // top -> right
                matrix[i][last] =top;
            }
        }
        return true;
    }*/
}

