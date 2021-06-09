package com.ques.ctci;

import java.util.*;

/**
 * Q8.1 Triple step
 * A child is running up a staircase with n steps either taking 1,2 or 3 steps.
 * Find the number of way the child can climb up.
 */
public class TripleStep {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of steps: ");
        int steps = sc.nextInt();
        System.out.format("Number of ways is "+ findWays(steps));
    }

    private int findWays(int steps) {
        List<Integer> queue = new ArrayList<>();
        queue.add(steps);
        int current = 0;
        while(queue.size()!=0){
            int elem = queue.get(0);
            queue.remove(0);
            if(elem == 0){
                current++;
            }else{
            if(elem-1>=0)
                queue.add(elem-1);
            if(elem-2>=0)
                queue.add(elem-2);
            if(elem-3>=0)
                queue.add(elem-3);
            }
        }
        return current;
    }
}
