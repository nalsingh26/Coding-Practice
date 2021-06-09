package com.ques.ctci;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Q8.4 Power Set
 * Write a program to find all subset of a set
 */
public class PowerSet {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the set: ");
        int r = sc.nextInt();
        ArrayList<Integer> set = new ArrayList<Integer>();
        System.out.print("Enter the elements (space separated): ");
        for (int i = 0; i < r; i++)
            set.add(sc.nextInt());
        HashSet<ArrayList<Integer>> subsets = new HashSet<>();
        for(int i: set){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(i);
            subsets.add(tmp);
        }
        getPowerSet(set, subsets);
        System.out.print(subsets.size());
    }

    private void getPowerSet(ArrayList<Integer> set, HashSet<ArrayList<Integer>> subsets) {
        if(set.size()<=2)
            return;
        subsets.add(set);
        for(int i=0; i<set.size(); i++){
            ArrayList<Integer> copyOfSet = (ArrayList<Integer>) set.clone();
            copyOfSet.remove(i);
            getPowerSet(copyOfSet, subsets);
        }
        return;
    }

    private void printSet(ArrayList<Integer> set) {
        for(Integer i:set)
            System.out.print(i+",");
        System.out.println();
    }
}
