package com.dudu.msg.link;

import com.dudu.msg.Node;


public class LinkedNode<T> {

    private Node<T> firstNode;

    private int size;

    private Node<T> p;

    public void add(T t){Node newNode=new Node(t);
        newNode.setNext(firstNode);
        firstNode=newNode;
        size++;
    }



    public int getSize() {
        return size;
    }

    public void show(){
        for (int i=0;i<size;i++){
            System.out.println(firstNode);
        }
    }



    public static void main(String[] args) {
        LinkedNode<String> l=new LinkedNode<>();
        l.add("123");
        l.add("234");
        l.add("345");

    }




}
