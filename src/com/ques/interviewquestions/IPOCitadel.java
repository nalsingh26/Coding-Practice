package com.ques.interviewquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Lets say we have total of N which we want to divide among bidders
 * Bidders are represented in 2d arrays as [bidder_id, no of shares bid, price, timestamp]
 * Build a function returns the bidder_id's that did not receive any shares.
 * Shares are allocated based on the following rule:-
 * if the price is highest among all the bidders. Allocate shares
 * If the price is same among 2 bidders. Allocate share based on timestamp.
 * Like 2 bidders with bidder id 1&2, have same price, timestamp 4 and 1, bids for 5 shares each and N=1.
 * So, in this case only bidder id 1 get share, bidder id 2 will not recieve any shares
 */
public class IPOCitadel {
    private List<Integer> getUnallocatedUsers(int numShares, List<List<Integer>> bidders) {
        List<Integer> unallocatedUsers = new ArrayList<>();
        if(bidders.size()==0)
            return unallocatedUsers;
        bidders = bidders.stream().sorted((b1,b2) -> {
            int c = (b1.get(2)).compareTo(b2.get(2));
            if(c!=0)
                return c*-1;
            else
                return (b1.get(3)).compareTo(b2.get(3));
        }).collect(Collectors.toList());
        for(List<Integer> bidder: bidders){
            System.out.format("%d,%d,%d,%d\n",bidder.get(0),bidder.get(1),bidder.get(2),bidder.get(3));
        }
        int f=0;
        for(List<Integer> bidder: bidders){
            if(numShares<=0)
                f=1;
            if(f==0){
                numShares-=bidder.get(1);
            }else{
                unallocatedUsers.add(bidder.get(0));
            }
        }
        return unallocatedUsers;
    }
    public void run(){
        System.out.println("Enter the total number of shares:");
        Scanner sc = new Scanner(System.in);
        int numShares = sc.nextInt();
        System.out.println("Enter the number of bidder:");
        int bidderCount = sc.nextInt();
        List<List<Integer>> bidders = new ArrayList<>();
        for(int i = 1; i<=bidderCount; i++){
            System.out.println("Enter the user,number of shares,bid price,timestamp(press enter after each number):");
            int u = sc.nextInt();
            int s = sc.nextInt();
            int bp = sc.nextInt();
            int ts = sc.nextInt();
            List<Integer> elem = new ArrayList<>(4);
            elem.add(u);
            elem.add(s);
            elem.add(bp);
            elem.add(ts);
            bidders.add(elem);
        }
        List<Integer> result = getUnallocatedUsers(numShares, bidders);
        System.out.println("The unallocated users are:");
        for(Integer i: result){
            System.out.print(i+", ");
        }
    }
}
