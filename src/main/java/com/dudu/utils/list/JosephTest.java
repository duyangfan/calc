package com.dudu.utils.list;

public class JosephTest {

    public static void main(String[] args) {
       //生成循环链表
        Node first=null,pre=null;
        for (int i=1;i<=41;i++){
            //头节点
            if(i==1){
                first=new Node(i+"",null);
                pre=first;
                continue;
            }
            //中间节点
            Node node = new Node(i + "", null);
            pre.next=node;
            pre=node;
            //最后一个
            if(i==41){
                pre.next=first;
            }
        }

        System.out.println(CircleListCheck.isCircle(first));


        int count=0;
        Node current=first;
        Node before=null;
        while(current.next!=current){
            count++;
            //模拟报数

            //如果为3，删除该节点，重置count=0;
            if(count==3){
                before.next=current.next;
                count=0;
                System.out.print(current.data+"->");
                current=current.next;
                continue;
            }
            //不是3,当前节点后移，让before=current;
            before=current;
            current=current.next;
        }
        System.out.println(current.data);








    }








}




