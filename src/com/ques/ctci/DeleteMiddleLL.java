package com.ques.ctci;

import com.datastructures.LinkedList;
import com.datastructures.Node;

import java.util.Scanner;

/**
 * Chap-2
 * Implement an algorithm to delete a node in the middle of the linked list
 */
public class DeleteMiddleLL {
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
        deleteMiddle(list);
        list.printList();
    }

    private void deleteMiddle(LinkedList list) {
        if(list.head == list.current || list.head.next == list.current){
            list.deleteFirstElem();
            return;
        }
        Node ptr1 = list.head.next.next;
        Node ptr2 = list.head;
        while(ptr1.next!=null){
            if(ptr1.next.next==null)
                break;
            ptr1 = ptr1.next.next;
            ptr2=ptr2.next;
        }
        ptr2.next = ptr2.next.next;
    }
}
