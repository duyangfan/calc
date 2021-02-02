package com.dudu.utils.list;

public class LinkListTest {
    public static void main(String[] args) {
        LinkList<String> seq=new LinkList<>();
        seq.insert("N");
        seq.insert("M");
        seq.insert("V");

        seq.insert(1,"D");
        seq.insert(0,"A");

        seq.reverse();
        /*System.out.println(seq.get(1));

        System.out.println(seq.remove(4));*/

        //System.out.println(seq.length());
        for (int i=0;i<seq.length();i++){
            System.out.println(seq.get(i));
        }
        //快慢指针解决中间值问题：
        // fast=fast.next.next;
        //slow=slow.next;
    }
}
