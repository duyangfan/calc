package com.dudu.utils.symbolTable;

public class Test {

    public static void main(String[] args) {
        SymbolTable<String,String> table=new SymbolTable<>();
        table.put("add","add");
        table.put("put","put");
        table.put("del","del");
        System.out.println("插入："+table.size()+"   个");
        table.put("del","测试");
        System.out.println(table.get("del"));
        System.out.println(table.delete("del"));
        System.out.println(table.size());
    }
}
