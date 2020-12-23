package com.ques.ctci;


import java.util.HashMap;
import java.util.Scanner;

/**
 * Chap-1
 * Given a smaller string s and a bigger string b, design algorithm to find all permutation of the
 * shorter string within the longer one. Print the location of each permutation
 */
public class PermutationString {
    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the smaller string:");
        String s = sc.next();
        System.out.println("Enter the bigger string:");
        String b = sc.next();
        printPositionOfPermutation(s,b);
    }

    private HashMap<Character,Integer> addToMap(int i, String str, HashMap<Character,Integer> map){
        int count = 0;
        char ch = str.charAt(i);
        if(map.containsKey(ch))
            count=map.get(ch);
        map.put(ch,++count);
        return map;
    }
    private void printPositionOfPermutation(String s, String b) {
        if(s.length()==0 || b.length()==0){
            System.out.println("Length of s or b is zero. Terminating...");
            return;
        }
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> bmap = new HashMap<>();
        int pos = -1 * s.length();
        for(int i=0; i<s.length();i++)
            smap = addToMap(i,s,smap);
        for(int i=0; i<b.length(); i++) {
            bmap = addToMap(i,b,bmap);
            int count;
            char ch;
            if (pos >= 0) {
                ch = b.charAt(pos);
                count = bmap.get(ch);
                count--;
                if (count <= 0)
                    bmap.remove(ch);
                else
                    bmap.put(ch, count);
            }
            pos++;
            if (bmap.equals(smap))
                System.out.println("Permutation starts at " + pos);
        }
    }
}
