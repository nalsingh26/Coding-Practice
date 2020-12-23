package com.ques.ctci;

import java.util.Scanner;

/**
 * Chap-1
 * Find is all the character of the string are unique
 */
public class IsUnique {
    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string:");
        String str = sc.nextLine();
        if(isUnique(str))
            System.out.println("Characters in the string are unique");
        else
            System.out.println("Characters in the string are not unique");
    }
    private boolean isUnique(String str){
        boolean b[]= new boolean[128];
        for(int i=0; i<str.length(); i++){
            if(b[str.charAt(i)])
                return false;
            else
                b[str.charAt(i)] = true;
        }
        return true;
    }
}
