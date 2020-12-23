package com.ques.ctci;

import com.datastructures.LinkedList;
import com.datastructures.Node;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

/**
 * Chap-2
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class KthToLastLL {
    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the list elements as an array");
        System.out.print("Enter the size of the linked list: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.format("Enter the numbers separated by space: ");
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(sc.next());
        System.out.print("Enter k: ");
        int k = Integer.parseInt(sc.next());
        LinkedList list = new LinkedList(arr);
        System.out.format("The %dth element from the end is %d", k,kthToLastElem(list.head,k));
    }

    private int kthToLastElem(@NotNull Node head, int k) {
        Node ptr1, ptr2;
        ptr1 = head;
        ptr2 = head.next;
        for(int i=1; i<k; i++)
            ptr2 = ptr2.next;
        while(ptr2!=null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1.data;
    }
}
