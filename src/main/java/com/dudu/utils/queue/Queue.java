package com.dudu.utils.queue;

public class Queue<T> {
    private class Node<T>{
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }


    private Node<T> first;
    private Node<T> last;
    private int N;

    public Queue() {
        this.first = new Node<>(null,null);
        this.last=null;
        N=0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void enqueue(T t){
        N++;
        if(last==null){
            last=new Node<>(t,null);
            first.next=last;
            return;
        }
        Node oldLast=last;
        last.next= new Node<>(t, null);
        last=oldLast.next;
    }

    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        Node<T> head=first.next;
        first.next=head.next;
        N--;
        if(isEmpty()){
            last=null;
        }
        return (T) head;
    }
}


