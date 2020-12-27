package com.ques.ctci;

import java.util.*;

/**
 * Chap-4
 * Implement a data structure Set of Plates. The set of plates should be kept as stacks of plates
 * such that after a certain size of the plate stack, a new stack is created. Implement push, pop,
 * and popAt method for this class.
 */

public class StackOfPlates{
    ArrayList<Stack<Integer>> plates = new ArrayList<>();
    int limit=0, currentStack=-1;
    public void push(int val){
        Stack<Integer> stack;
        if (currentStack >= 0)
            stack = plates.get(currentStack);
        else {
            stack = new Stack<>();
            currentStack++;
        }
        if(stack.size()>=limit){
            currentStack++;
            stack = new Stack<>();
        }
        stack.push(val);
        if(currentStack < plates.size())
            plates.set(currentStack,stack);
        else
            plates.add(stack);
    }

    public int pop() throws Exception{
        if(plates.isEmpty())
            throw new Exception("No plates found");
        Stack<Integer> stack = plates.get(currentStack);
        int val = stack.pop();
        if(stack.size() == 0)
            plates.remove(currentStack--);
        else
            plates.set(currentStack, stack);
        return val;
    }

    public int popAt(int position) throws Exception {
        position--;
        if(plates.size() < position)
            throw new Exception("No plates found at the position");
        Stack<Integer> stack = plates.get(position);
        int val = stack.pop();
        if(stack.size() == 0)
            plates.remove(position);
        else
            plates.set(position, stack);
        return val;
    }

    public void printStack(){
        Stack<Integer> tmpStack;
        if(plates.isEmpty()){
            System.out.println("Nothing found.");
            return;
        }
        int pos = 1;
        for(Stack s: plates){
            System.out.format("Stack %d contains: ", pos++);
            System.out.println(Arrays.toString(s.toArray()));
        }
    }
    public void run() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the maximum height of each stack: ");
        limit = sc.nextInt();
        System.out.println("Enter Pop to pop, Push N to Push the number N to the stack, PopAt P to pop the top element " +
                "at position P(1 to number of stacks), Print to print the stack, anything else would exit the process");
        while(true){
            String cmd = sc.next();
            if(cmd.equals("Pop")){
                pop();
                System.out.println("Popped");
            }else if(cmd.equals("Push")){
                int num = Integer.parseInt(sc.next());
                System.out.println("Pushing "+ num);
                push(num);
            }else if(cmd.equals("PopAt")){
                int num = Integer.parseInt(sc.next());
                popAt(num);
                System.out.println("Popped at position "+ num);
            }else if(cmd.equals("Print")){
                printStack();
            }else{
                System.out.println("Exiting...");
                break;
            }
        }
    }
}
