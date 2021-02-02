package com.dudu.utils.list;

import com.dudu.utils.squence.Sequence;

import java.util.Iterator;

public class LinkList<T> implements Sequence<T>,Iterable<T> {


    private class Node<T>{
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private int N;

    public LinkList() {
        this.head = new Node(null,null);
        N=0;
    }

    @Override
    public void clear() {
        N=0;
        head.next=null;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public int length() {
        return N;
    }

    @Override
    public T get(int i) {
        Node<T> current=head;
        int index=0;
        while(current.next!=null){
            current=current.next;
            if(index==i){
                break;
            }
            index++;
        }
        return current.data;
    }

    @Override
    public void insert(T t) {
        Node<T> current=head;
        while(current.next!=null){

            current=current.next;
        }
        Node<T> node=new Node<>(t,null);
        current.next=node;
        N++;
    }

    @Override
    public void insert(int i, T t) {
        //找到前驱结点
        Node<T> pre=head;
        for (int index=0;index<i-1;index++){
            pre=pre.next;
        }
        //找到当前节点
        Node<T> current = pre.next;
        //新节点的的后继指向当前节点
        Node<T> newNode=new Node(t,current);
        //前驱节点的后继指向新节点
        pre.next=newNode;
        //长度+1
        N++;

    }

    @Override
    public T remove(int i) {
        //找到i节点的前驱节点
        Node<T> pre=head;
        for (int index=0;index<i;index++){
            pre=pre.next;
        }
        //找到i节点的后继节点
        Node<T> cur=pre.next;
        Node<T> next=cur.next;
        //i的前驱节点的后继节点直接指向i的后继节点
        pre.next=next;
        N--;
        return cur.data;
    }



    public void reverse(){
        if(isEmpty()){
            return;
        }
        reverse(head.next);
    }


    public Node reverse(Node curr){
        if(curr.next==null){
            head.next=curr;
            return curr;
        }
        Node pre = reverse(curr.next);
        pre.next=curr;
        curr.next=null;
        return curr;
    }

    @Override
    public int indexOf(T t) {
        Node<T> current=head;
        int i=0;
        while(current.next!=null){
            if(current.data.equals(t)){
                return i;
            }
            current=current.next;
            i++;
        }

        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkIterator<>();
    }

    private class LinkIterator<T> implements Iterator<T>{

        Node<T> current;

        public LinkIterator() {
            this.current= head;
        }

        @Override
        public boolean hasNext() {
            return current.next!=null;
        }

        @Override
        public T next() {
            current=current.next;
            return current.data;
        }
    }
}
