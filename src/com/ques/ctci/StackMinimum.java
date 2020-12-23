package com.ques.ctci;

import com.datastructures.LinkedList;
import com.datastructures.Node;
import com.datastructures.Stack;

import java.util.Scanner;

/**
 * Chap-2
 * Implement a stack to have an additional method min which returns the minimum element
 */
public class StackMinimum extends Stack{
    Stack minimum;

    public StackMinimum() {
        super(Integer.MAX_VALUE);
        minimum = new Stack(Integer.MAX_VALUE);
        pop();
    }

    @Override
    public void push(int data) {
        super.push(data);
        if(data<=minimum.top())
            minimum.push(data);
    }

    @Override
    public void pop() {
        if(minimum.top() == top())
            minimum.pop();
        super.pop();
    }

    public void getMinimum(){
        System.out.println("Current minimum is: "+ minimum.top());
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Pop to pop, Push N to Push N to the stack, Min to show the " +
                "current minimum, Print to print the stack, anything else would exit the process");
        while(1==1){
            String cmd = sc.next();
            if(cmd.equals("Pop")){
                System.out.println("Popping");
                pop();
            }else if(cmd.equals("Push")){
                int num = Integer.parseInt(sc.next());
                System.out.println("Pushing "+ num);
                push(num);
            }else if(cmd.equals("Min")){
                getMinimum();
            }else if(cmd.equals("Print")){
                printStack();
            }else{
                System.out.println("Exiting...");
                break;
            }
        }
    }
}
