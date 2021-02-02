package com.dudu.utils.list;

import com.dudu.utils.squence.Sequence;

import java.util.Iterator;

public class TowWayLinkList<T> implements Sequence<T>,Iterable<T> {



    private class Node<T>{
        T data;
        Node<T> pre;
        Node<T> next;

        public Node(T data, Node<T> pre, Node<T> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }


    private Node<T> head;
    private Node<T> last;
    private int N;


    public TowWayLinkList() {
        this.head = new Node<>(null,null,null);
        this.last=null;
        N=0;
    }

    @Override
    public void clear() {
        this.head.next=null;
        this.head.pre=null;
        this.head.data=null;
        this.last=null;
        N=0;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public int length() {
        return N;
    }

    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        return head.data;
    }

    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return last.data;
    }

    @Override
    public T get(int index) {
        Node<T> curr=head.next;
        for (int i=0;i<index;i++){
            curr=curr.next;
        }

        return curr.data;
    }

    @Override
    public void insert(T t) {
        N++;
        if (isEmpty()){
            Node<T> newNode=new Node<>(t,head,null);
            last=newNode;
            head.next=last;
            return;
        }
        Node<T> newNode=new Node<>(t,last,null);
        last.next=newNode;
        last=newNode;
    }

    @Override
    public void insert(int index, T t) {
        Node<T> pre=head;
        for (int i=0;i<index;i++){
            pre=pre.next;
        }
        Node<T> curent=pre.next;
        Node newNode=new Node(t,pre,curent);
        pre.next=newNode;
        curent.pre=newNode;
        N++;
    }

    @Override
    public T remove(int i) {
        N--;
        Node<T> pre=head;

        for (int index=0;index<i;index++){
            pre=pre.next;
        }

        Node<T> cur=pre.next;
        Node<T> next = cur.next;
        pre.next=next;
        next.pre=pre;
        return cur.data;
    }

    @Override
    public int indexOf(T t) {
        Node curr=head;
        for (int i=0;curr.next!=null;i++){
            if (curr.data.equals(t)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new TwoWayIterator();
    }


    private class TwoWayIterator<T> implements Iterator<T>{

        Node<T> n;

        public TwoWayIterator() {
            this.n = (Node<T>) head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public T next() {
            n=n.next;
            return n.data;
        }
    }
}
