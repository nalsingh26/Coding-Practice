package com.ques.dsamadeeasy;
import java.util.*;

public class KnaryString {
    int x = 10;
    int a[] =new int[x];
    public void run(){
        Scanner in = new Scanner(System.in);
        System.out.format("The value of n is %d \n", x);
        System.out.print("Enter the value of k:");
        int k = in.nextInt();
        knary(10,k);
    }
    private void knary(int n, int k){
        if(n<1){
            System.out.println(Arrays.toString(a).replace(", ","").replace("]","")
                    .replace("[",""));
            return;
        }
        for(int i = 0; i<k; i++){
            a[n-1]=i;
            knary(n-1,k);
        }
    }
}
