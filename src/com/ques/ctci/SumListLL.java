package com.ques.ctci;

import com.datastructures.Node;
import com.datastructures.LinkedList;

import java.util.Scanner;

/**
 * Chap-2
 * Implement a program to sum numbers represented by 2 lists. These number would be considered in
 * reverse while summing up... so carry would not be a problem when no. of digits are different
 * 131 + 1999 = 2130
 * 1->3->1
 * 9->9->9->1
 * Ans : 0->3->1->2
 */
public class SumListLL {
    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the digits in number 1: ");
        int l1 = sc.nextInt();
        System.out.print("Enter the number 1: ");
        int n1 = sc.nextInt();
        int[] ll1 = new int[l1];
        System.out.print("Enter the digits in number 2: ");
        int l2 = sc.nextInt();
        System.out.print("Enter the number 2: ");
        int n2 = sc.nextInt();
        int[] ll2 = new int[l2];
        int i=0;
        while(n1!=0){
            ll1[i++] = n1%10;
            n1/=10;
        }
        i=0;
        while(n2!=0){
            ll2[i++] = n2%10;
            n2/=10;
        }
        LinkedList num1 = new LinkedList(ll1);
        LinkedList num2 = new LinkedList(ll2);
        num1.printList();
        num2.printList();
        num1 = sumList(num1, num2);
        System.out.println("Sum of the number is:");
        num1.printList();
    }

    private LinkedList sumList(LinkedList list1, LinkedList list2) {
        LinkedList ans = new LinkedList();
        int carry=0;
        Node head1 = list1.head;
        Node head2 = list2.head;
        while(head1!=null || head2!=null){
            int sum;
            if(head1!=null && head2!=null){
                sum = head1.data+head2.data+carry;
                head1 = head1.next;
                head2 = head2.next;
            } else if(head1!=null){
                sum = head1.data+carry;
                head1 = head1.next;
            } else{
                sum = head2.data+carry;
                head2 = head2.next;
            }
            carry = sum/10;
            sum = sum%10;
            ans.add(sum);
        }
        return ans;
    }
}
