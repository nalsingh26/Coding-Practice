package com.datastructures;

public class Stack {
    Node head = null;

    public Stack(int data){
        Node node = new Node(data,null);
        this.head = node;
    }
    public Stack(Node node){
        this.head = node;
    }

    public void push(int data){
        Node node = new Node(data,null);
        node.next = head;
        head = node;
    }

    public void push(Node node){
        node.next = head;
        head = node;
    }

    public void pop(){
        if(head != null)
            head = head.next;
    }

    public Integer top(){
        if(head != null)
            return head.data;
        return null;
    }

    public void printStack(){
        Node tmp = head;
        while(tmp!=null){
            System.out.format("%d -> ",tmp.data);
            tmp=tmp.next;
        }
        System.out.println("null");
    }
}
