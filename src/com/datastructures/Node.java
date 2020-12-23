package com.datastructures;

public class Node {
    public Integer data = null;
    public Node next = null;
    public Node prev = null;

    public Node(Integer data, Node next){
        this.data = data;
        this.next = next;
    }

    //for doubly linked list
    public Node(Integer data, Node next, Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
