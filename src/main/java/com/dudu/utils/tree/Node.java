package com.dudu.utils.tree;

public class Node<K,V> {

    public Node<K,V> left;
    public Node<K,V> right;
    public K key;
    public V value;

    public Node( K key, V value,Node<K, V> left, Node<K, V> right) {
        this.left = left;
        this.right = right;
        this.key = key;
        this.value = value;
    }
}
