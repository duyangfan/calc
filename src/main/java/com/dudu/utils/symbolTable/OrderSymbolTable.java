package com.dudu.utils.symbolTable;

public class OrderSymbolTable<K extends Comparable<K>,V> {

    private Node<K,V> head;
    private int N;


    public OrderSymbolTable() {
        this.head=new Node<>(null,null,null);
        this.N=0;
    }


    public int size(){
        return N;
    }

    public void put(K key,V val){
        Node<K,V> curr=head.next;
        Node<K,V> pre=head;
        while(curr!=null&&curr.key.compareTo(key)>0){
            pre=curr;
            curr = curr.next;
        }

        if(curr!=null&&curr.key.compareTo(key)==0){
           curr.value=val;
           return;
        }
        Node<K, V> newNode = new Node<>(key, val, null);
        if(curr!=null&&curr.key.compareTo(key)<=0){
            newNode.next=curr;
            pre.next=newNode;
            N++;
            return;
        }
        Node<K, V> oldFirst = head.next;
        newNode.next=oldFirst;
        head.next=newNode;
        N++;
    }


    public V delete(K key){
        Node<K,V> curr=head;
        while(curr.next!=null){
            if(curr.next.key.equals(key)){
                curr=curr.next.next;
                N--;
                return curr.value;
            }
            curr=curr.next;
        }
        return null;
    }


    public V get(K key){
        Node<K,V> curr=head;
        while(curr.next!=null){
            curr=curr.next;
            if(curr.key.equals(key)){
                return curr.value;
            }

        }
        return null;
    }









}
