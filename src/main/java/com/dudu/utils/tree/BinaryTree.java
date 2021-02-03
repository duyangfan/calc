package com.dudu.utils.tree;

public class BinaryTree<K extends Comparable<K>,V> {

    private Node<K,V> root;
    private int N;



    public int size(){
        return N;
    }

    public void put(K key,V val){
        root=put(root, key, val);
    }

    public Node<K,V> put(Node<K,V> x,K key,V val){
        //如果x子树为空
        if(x==null){
            N++;
            return new Node<K,V>(key,val,null,null);
        }
        //如果x子树不为空
        //比较x.key 和 key 的大小
        //小于：找左子树  大于：找右子树   等于：value值覆盖
        int cmp=x.key.compareTo(key);
        if (cmp>0){
            x.right=put(x.right,key,val);
        }
        if(cmp<0){
            x.left=put(x.left,key,val);
        }
        if(cmp==0){
            x.value=val;
        }
        return x;
    }
}
