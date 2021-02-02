package com.dudu.utils.list;

public class FastSlow {


    public static void main(String[] args) {
        Node a = new Node("A", null);
        Node b = new Node("B", null);
        Node c = new Node("C", null);
        Node d = new Node("D", null);
        Node e = new Node("E", null);
        Node f = new Node("F", null);
        Node g = new Node("G", null);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;


        String mid=getMid(a);
        System.out.println("中间值为："+mid);




    }

    private static String getMid(Node a) {
        Node fast=a;
        Node slow=a;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.data;
    }


}

class Node{
    String data;
    Node next;

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }

}
