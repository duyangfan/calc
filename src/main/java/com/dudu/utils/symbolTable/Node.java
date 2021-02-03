package com.dudu.utils.symbolTable;

public class Node<K,V> {

    public K key;
    public V value;
    public Node<K,V> next;

    public Node(K key, V value, Node<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
