package com.dudu.utils.list;

public class CircleListCheck {

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
        g.next=c;


        //链表环
        boolean circle=isCircle(a);
        System.out.println(circle);
        //寻找环入口
        Node entrance=getEntrance(a);
        System.out.println(entrance.data);


    }

    private static Node getEntrance(Node a) {
        Node fast=a;
        Node slow=a;
        Node temp=null;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast.equals(slow)){
                temp=a;
                continue;
            }
            //让临时节点变换
            if(temp!=null){
                temp=temp.next;
                if(temp.equals(slow)){
                    return temp;
                }
            }

        }
        return null;
    }

    public  static boolean isCircle(Node a) {
        Node fast=a;
        Node slow=a;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast.equals(slow)){
                return true;
            }
        }
        return false;
    }


}

