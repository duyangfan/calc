package com.dudu.utils.satck;

public class ReversePolshNotationTest {

    public static void main(String[] args) {
        //中缀表达式：3*（17-15）+18/6
        //转化为逆波兰表达式：
        String[] str={"3","17","15","-","*","18","6","/","+"};
        String res=calc(str);
        System.out.println("结果为："+res);
    }

    private static String calc(String[] str) {
        String res="";
        Stack stack=new Stack();
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            System.out.print(s+" ->");
            int a,b;
            switch (s){
                case "+":
                    a=Integer.valueOf(stack.pop());
                    b=Integer.valueOf(stack.pop());
                    res=(b+a)+"";
                    stack.push(res);
                    break;
                case "-":
                    a=Integer.valueOf(stack.pop());
                    b=Integer.valueOf(stack.pop());
                    res=(b-a)+"";
                    stack.push(res);
                    break;
                case "*":
                    a=Integer.valueOf(stack.pop());
                    b=Integer.valueOf(stack.pop());
                    res=(b*a)+"";
                    stack.push(res);
                    break;
                case "/":
                    a=Integer.valueOf(stack.pop());
                    b=Integer.valueOf(stack.pop());
                    res=(b/a)+"";
                    stack.push(res);
                    break;
                    default:
                        stack.push(s);
            }
        }
        return stack.pop();
    }


}
