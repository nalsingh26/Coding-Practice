package com.ques.ctci;

import com.datastructures.LinkedList;
import com.datastructures.Node;

import java.util.Scanner;

/**
 * Chap-2
 * Implement a program to sum numbers represented by 2 lists.
 * 131 + 1999 = 2130
 * 1->3->1
 * 1->9->9->9
 * Ans : 2->1->3->0
 */
class PartialSum{
     Node sum = null;
     int carry = 0;
}
public class SumReverseLL {
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
          for(int i=0; i<l1; i++){
               int pow = (int) Math.pow(10, l1-i-1);
               ll1[i] = n1/pow;
               n1 = n1%pow;
          }
          for(int i=0; i<l2; i++){
               int pow = (int) Math.pow(10, l2-i-1);
               ll2[i] = n2/pow;
               n2 = n2%pow;
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
          int len1 = list1.length();
          int len2 = list2.length();
          if(len1 > len2){
               list2 = zeroFill(list2, len1-len2);
          }else if (len2>len1) {
               list1 = zeroFill(list1, len2 - len1);
          }
          PartialSum partSum = new PartialSum();
          PartialSum latest = addSum(partSum, list1.head,list2.head);
          Node head = latest.sum;
          if(latest.carry!=0){
               head = new Node(latest.carry, head);
          }
          LinkedList ans = new LinkedList(head);
          return ans;
     }

     private PartialSum addSum(PartialSum partSum, Node n1, Node n2) {
          if(n1 == null)
               return partSum;
          PartialSum latestSum = addSum(partSum, n1.next, n2.next);
          int sum = n1.data + n2.data + latestSum.carry;
          int carry = (int) sum/10;
          latestSum.carry = carry;
          latestSum.sum = new Node(sum%10,latestSum.sum);
          return latestSum;
     }

     private LinkedList zeroFill(LinkedList list, int i) {
          if(i<=0)
               return list;
          Node head = new Node(0,null);
          Node tmp = head;
          i--;
          while(i!=0){
               tmp.next = new Node(0, null);
               i--;
               if(i!=0)
                    tmp = tmp.next;
          }
          tmp.next = list.head;
          LinkedList zeroFilledList = new LinkedList(head);
          return zeroFilledList;
     }

}
