package com.datastructures;

public class LinkedList{
    public Node head = null;
    public Node current = null;

    public LinkedList(Integer data){
        this.head = new Node(data,null);
        this.current = head;
    }
    public LinkedList(){

    }
    public LinkedList(Node head){
        this.head = head;
        current = head;
        while(current.next!=null){
            current = current.next;
        }
    }

    // get list from array
    public LinkedList(int[] arr){
        if(arr.length == 0){
            return;
        }
        this.head = new Node(arr[0],null);
        this.current = head;
        for(int i=1; i<arr.length; i++){
            Node node = new Node(arr[i], null);
            current.next = node;
            current = current.next;
        }
    }
    public void printList(){
        Node tmp = head;
        while(tmp!=null){
            System.out.format("%d -> ",tmp.data);
            tmp=tmp.next;
        }
        System.out.println("null");
    }

    public void add(Integer data){
        Node node = new Node(data, null);
        if(current == null){
            this.head = node;
            this.current = node;
            return;
        }
        current.next = node;
        current=current.next;
    }

    public void add(Node node){
        if(current == null){
            this.head = node;
            this.current = node;
            return;
        }
        current.next = node;
        while(current!=null)
            current = current.next;
    }

    public void deleteFirstElem(){
        if(head!=null)
            head = head.next;
        if(head == null)
            current = null;
    }

    public void deleteLastElem(){
        if(head == current){
            head=null;
            current=null;
            return;
        }
        Node tmp = head;
        while(tmp.next != current){
            tmp = tmp.next;
        }
        current = tmp;
    }

    public boolean isEmpty(){
        if(head == null)
            return true;
        return false;
    }

    public int length(){
        Node tmp = this.head;
        int len = 0;
        while(tmp!=null){
            len++;
            tmp = tmp.next;
        }
        return len;
    }

}
