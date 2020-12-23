package com.ques.ctci;

import com.datastructures.LinkedList;
import com.datastructures.Node;

import java.util.Scanner;

/**
 * Chap-2
 * Reorder a linked list such that all the element less than a partition value 'val' to left
 * and all the values equal to or greater than val is to the right
 */
public class PartitionLL {
    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the list elements as an array");
        System.out.print("Enter the size of the linked list: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.format("Enter the numbers separated by space: ");
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(sc.next());
        LinkedList list = new LinkedList(arr);
        System.out.format("Enter the partition value: ");
        int val = Integer.parseInt(sc.next());
        list = partition(list, val);
        list.printList();
    }

    private LinkedList partition(LinkedList origList, int val) {
        LinkedList leftL = new LinkedList();
        LinkedList rightL = new LinkedList();
        Node tmp = origList.head;
        while(tmp!=null){
            if(tmp.data<val){
                leftL.add(tmp.data);
            }else{
                rightL.add(tmp.data);
            }
            tmp = tmp.next;
        }
        leftL.add(rightL.head);
        return leftL;
    }
}
