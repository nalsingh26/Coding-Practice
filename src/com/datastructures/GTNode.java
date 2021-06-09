package com.datastructures;

import java.util.ArrayList;
// node class for graph and tree
public class GTNode {
    public Integer data;
    public ArrayList<GTNode> children;

    public GTNode(Integer data){
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(Integer data){
        GTNode child = new GTNode(data);
        this.children.add(child);
    }

    public GTNode getNthChild(int idx){
        if(children.size()>=idx)
            return children.get(idx);
        return null;
    }

    // for binary tree
    public void addLeftChild(Integer data){
        GTNode child = new GTNode(data);
        if(children.size()>=1){
            children.set(0, child);
        }else{
            children.add(child);
        }
    }
    // for binary tree
    public void addRightChild(Integer data){
        GTNode child = new GTNode(data);
        int size = children.size();
        if(size == 0){
            GTNode LChild = new GTNode(null);
            children.add(LChild);
            children.add(child);
        }else if(size==1)
            children.add(child);
        else
            children.set(1,child);
    }
    // for binary tree
    public GTNode getRightChild(){
        if(children.size()>=2)
            return children.get(1);
        return null;
    }
    // for binary tree
    public GTNode getLeftChild(){
        if(children.size()>=1)
            return children.get(0);
        return null;
    }
}
