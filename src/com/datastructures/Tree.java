package com.datastructures;

import java.util.PriorityQueue;
import java.util.Queue;

public class Tree {
    GTNode root=null;
    public Tree(Integer data){
        root = new GTNode(data);
    }
    public void inOrderPrint(GTNode node){
        if(node==null)
            return;
        inOrderPrint(node.getLeftChild());
        System.out.println(node.data);
        inOrderPrint(node.getRightChild());
    }
    public void preOrderPrint(GTNode node){
        if(node==null)
            return;
        System.out.println(node.data);
        inOrderPrint(node.getLeftChild());
        inOrderPrint(node.getRightChild());
    }
    public void postOrderPrint(GTNode node){
        if(node==null)
            return;
        inOrderPrint(node.getLeftChild());
        inOrderPrint(node.getRightChild());
        System.out.println(node.data);
    }
    public void verticalPrint(){

    }
    //not binary tree specific
    public void levelPrint(GTNode node){
        if(node==null)
            return;
        Queue<GTNode> helperQueue = new PriorityQueue<>();
        helperQueue.add(node);
        while(!helperQueue.isEmpty()) {
            GTNode tmp = helperQueue.poll();
            System.out.println(tmp.data);
            if(tmp.getLeftChild()!=null)
                helperQueue.add(node.getLeftChild());
            if(tmp.getLeftChild()!=null)
                helperQueue.add(node.getRightChild());
        }

    }

}
