package com.dudu.msg;

public class Node<T> {

    private T data;

    private Node next;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
