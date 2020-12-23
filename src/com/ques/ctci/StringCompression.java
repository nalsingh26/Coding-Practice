package com.ques.ctci;

import java.util.Scanner;

/**
 * Chap-1
 * Implement a method to perform basic string compression using the counts of repeated character.
 * Eg: aaabbbccccd = a3b3c4d1
 * If the length of the string is less than or equal to length of the compressed string,
 * return the string
 */
public class StringCompression {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string:");
        String str = sc.nextLine();
        System.out.format("The compressed string is : %s",stringCompression(str));
    }

    private String stringCompression(String str) {
        int len = str.length();
        if(len == 0)
            return "";
        StringBuffer compStr = new StringBuffer("");
        char currentChar = str.charAt(0);
        int count = 1;
        for(int i=1; i<len && compStr.length()<len; i++){
            char ch = str.charAt(i);
            if(currentChar == ch)
                count++;
            else{
                compStr.append(currentChar);
                compStr.append(count);
                count=1;
                currentChar=ch;
            }
        }
        compStr.append(currentChar);
        compStr.append(count);
        if(compStr.length()>=len)
            return str;
        return compStr.toString();
    }
}
