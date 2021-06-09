package com.ques.ctci;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Q8.9
 * Parens: Implement an algorithm to print all valid (i.e., properly opened and closed) combinations
 * of n pairs of parentheses.
 * EXAMPLE
 * Input: 3
 * Output: (( () ) ) , ( () () ) , ( () ) () , () ( () ) , () () ()
 */
public class Parenthesis {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of parenthesis: ");
        int paren = sc.nextInt();
        ArrayList<String> result = new ArrayList<>();
        getParenthesis(paren,paren,"",result);
        for(String s: result){
            System.out.println(s);
        }
    }

    private void getParenthesis(int open, int close, String prefix, ArrayList<String> result) {
        if(open==0 && close==0)
        {
            result.add(prefix);
            return;
        }else if(open==0 && close!=0){
            while(close!=0){
                prefix+=")";
                close--;
            }
            getParenthesis(open,close, prefix, result);
        }
        else if(open<close && open!=0){
            getParenthesis(open-1,close,prefix+"(", result);
            getParenthesis(open,close-1,prefix+")", result);
        }
        else if(open==close){
            getParenthesis(open-1, close, prefix+"(", result);
        }

    }
}
