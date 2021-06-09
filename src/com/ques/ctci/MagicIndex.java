package com.ques.ctci;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Q8.3
 * The index for which A[i] = i is called magic index. Given a sorted array, find the magic index.
 * If it's is not there return -1.
 */
public class MagicIndex {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the list: ");
        int r = sc.nextInt();
        int[] arr = new int[r];
        System.out.print("Enter the elements (space separated): ");
        for (int i = 0; i < r; i++)
            arr[i] = sc.nextInt();

        int idx = getMagicIndex(arr, 0, arr.length - 1);
        System.out.print(idx);
    }

    private int getMagicIndex(int[] arr, int l, int r) {
        if (l == r && arr[l] == l)
            return l;
        else if (l == r)
            return -1;
        int mid = (l + r) / 2;
        int left = getMagicIndex(arr, l, mid);
        if (left >= 0)
            return left;
        if (mid + 1 >= arr.length)
            if (arr[r] == r)
                return r;
            else
                return -1;
        int right = getMagicIndex(arr, mid+1, r);
        if (right >= 0)
            return right;
        return -1;
    }
}
