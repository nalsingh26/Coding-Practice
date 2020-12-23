package com.ques.dsamadeeasy;
import java.util.Scanner;

/**
 * Given a matrix, each of which may be filled with 1 or 0. The filled cells connected form a region.
 * Two cells are connected if they are adjacent to each other diagonally, vertically or horizontally.
 * Find the max length of such a region
 */
public class ConnectedCells {
    int d = 10; //dimension of 2D array
    int arr[][] = new int[d][d];
    int visited[][]= new int[d][d];
    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.format("Enter a %dx%d matrix[Each row should be comma separate in a line]:\n", d, d);
        for (int i = 0; i < d; i++) {
            String row[] = in.next().split(",");
            for (int j = 0; j < d; j++)
                arr[i][j] = Integer.parseInt(row[j]);
        }
        int maxLen=0;
        for(int i = 0; i<d; i++){
            for(int j=0; j<d; j++){
                if(visited[i][j]==0 && arr[i][j]==1){
                    visited[i][j] = 1;
                    maxLen = Math.max(maxLen, find8Neighbours(i, j)+1);
                }
            }
        }
        System.out.println("Max length = "+maxLen);
    }
    public int find8Neighbours(int x, int y){
        int row[] = {1,1,1,-1,-1,-1,0,0};
        int col[] = {1,0,-1,1,0,-1,-1,1};
        int l=0;
        for(int i=0; i<8; i++){
            int nrow = row[i]+x;
            int ncol = col[i]+y;
            if(nrow<0 || ncol<0 || nrow>=d || ncol>=d)
                continue;
            if(arr[nrow][ncol] == 1 && visited[nrow][ncol]<1)
            {
                l++;
                visited[nrow][ncol]=2;
            }
            else
                visited[nrow][ncol]=1;
        }
        if(l==0)
            return l;
        for(int i=0;i<8;i++){
            int nrow = row[i]+x;
            int ncol = col[i]+y;
            if(nrow<0 || ncol<0 || nrow>=d || ncol>=d)
                continue;
            if(visited[nrow][ncol]==2) {
                visited[nrow][ncol]=1;
                l = l + find8Neighbours(nrow, ncol);
            }
        }
        return l;
    }
}
