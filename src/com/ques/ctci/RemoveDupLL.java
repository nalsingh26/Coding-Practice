package com.ques.ctci;

import com.datastructures.LinkedList;
import com.datastructures.Node;


import java.util.HashSet;
import java.util.Scanner;

/**
 * Chap-2
 * Code to remove duplicates from an unsorted list
 */
public class RemoveDupLL {
    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the list elements as an array");
        System.out.print("Enter the size of the array: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.format("Enter the numbers separated by space: ");
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(sc.next());
        LinkedList list = new LinkedList(arr);
        System.out.format("The numbers with duplicates removed are: ");
        removeDup(list);
        list.printList();
    }

   private void removeDup(LinkedList list) {
       HashSet<Integer> elemSet= new HashSet<>();
       Node tmp = list.head;
       if(tmp!=null)
           elemSet.add(tmp.data);
       while(tmp.next!=null){
           if(elemSet.contains(tmp.next.data))
               tmp.next = tmp.next.next;
           else
               tmp = tmp.next;
       }
   }

}
