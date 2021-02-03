package com.dudu.utils.symbolTable;

public class SymbolTable<K,V> {

    private Node<K,V> head;
    private int N;


    public SymbolTable() {
        this.head=new Node<>(null,null,null);
        this.N=0;
    }


    public int size(){
        return N;
    }

    public void put(K key,V val){
        Node<K,V> curr=head;
        while(curr.next!=null){
            curr=curr.next;
            if(curr.key.equals(key)){
                curr.value=val;
                break;
            }

        }
        Node<K,V> newNode=new Node<>(key,val,null);
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
