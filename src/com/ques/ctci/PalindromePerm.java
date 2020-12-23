package com.ques.ctci;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Chap-1
 * Find if any permutation of a string is a palindrome or not
 * Input : Tact Coa
 * Output : true (permutation-> taco cat, atco cta,...)
 */
public class PalindromePerm {
    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string:");
        String str = sc.nextLine();
        if(palindromePerm(str))
            System.out.println("A permutation of the string is a palindrome");
        else
            System.out.println("A permutation of the string is not a palindrome");
    }
    private boolean palindromePerm(String str){
        int count= 0, l=str.length();
        HashSet<Character> set= new HashSet<>();
        if(l<=1)
            return true;
        for(int i =0; i<l; i++){
            char ch = getEquivalentChar(str.charAt(i));
            if(ch==32)
                continue;
            count++;
            if(set.contains(ch))
                set.remove(ch);
            else
                set.add(ch);
        }
        if((count%2==1 && set.size()==1) || set.size()==0)
            return true;
        return false;
    }

    private char getEquivalentChar(char ch) {
        if(ch==32)
            return ch;
        else if(ch<97)
            return (char) (ch+32);
        return ch;
    }
}
