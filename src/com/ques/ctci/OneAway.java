package com.ques.ctci;

import java.util.Scanner;

/**
 * Chap-1
 * There are 3 types of edits that are available: removing a character, replacing a character,
 * inserting a character. Given 2 strings, write a function to check if they are 0 or 1 edit away
 * or not.
 */
public class OneAway {
    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1st string:");
        String str1 = sc.nextLine();
        System.out.print("Enter 2nd string:");
        String str2 = sc.nextLine();
        if(oneAway(str1,str2))
            System.out.println("String is one edit away from the other");
        else
            System.out.println("String is not one edit away from the other");
    }
    private boolean oneAway(String s1, String s2){
        int l1 = s1.length(), l2=s2.length(), edit=0;
        if(!(l1 == l2 || l1+1 == l2|| l1-1 == l2))
            return false;
        int i=0,j=0;
        while(i<l1 && j<l2){
            if(s1.charAt(i)!=s2.charAt(j)){
                edit++;
                if(l1>l2)
                    i++;
                else if(l2>l1)
                    j++;
            }else{
                i++;j++;
            }
        }
        if(i!=l1 || j!=l2)
            edit++;
        if(edit<=1)
            return true;
        return false;
    }
}
