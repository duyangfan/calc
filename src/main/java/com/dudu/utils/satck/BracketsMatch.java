package com.dudu.utils.satck;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BracketsMatch {

    public static void main(String[] args) {
        String str="(上海(长安))";
        boolean match=isMatch(str);
        System.out.println(str+"括号是否匹配: "+match);
    }

    private static boolean isMatch(String str) {
        Stack stack=new Stack();

        for (int i = 0; i < str.length(); i++) {
            String temp=str.charAt(i)+"";
            if("(".equals(temp)){
                stack.push(temp);
                continue;
            }
            if(")".equals(temp)){
                String pop = stack.pop();
                if(pop==null){
                    return false;
                }
                continue;
            }
        }
        if(stack.size()==0){
            return true;
        }
        return false;
    }


}

class Stack{

    private LinkedList<String> list=new LinkedList<>();

    public void push(String str){
        list.addLast(str);
    }

    public String pop(){
        return list.removeLast();
    }
    public int size(){
        return list.size();
    }

}
