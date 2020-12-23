package com.datastructures;

public class Queue {
    Node first = null;
    Node last = null;

    public Queue(int data){
        Node node = new Node(data,null);
        this.first = node;
        this.last = node;
    }

    public void add(int data){
        Node node = new Node(data,null);
        last.next = node;
        last = last.next;
    }
    public void add(Node node){
        last.next = node;
        last = last.next;
    }

    public void delete(){
        if(first == null)
            first = first.next;
        if(first == null)
            last = null;
    }

    public void printQueue(){
        Node tmp = first;
        while(tmp!=null){
            System.out.format("%d -> ",tmp.data);
            tmp=tmp.next;
        }
        System.out.println("null");
    }
}
