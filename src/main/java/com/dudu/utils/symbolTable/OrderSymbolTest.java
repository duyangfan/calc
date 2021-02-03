package com.dudu.utils.symbolTable;

public class OrderSymbolTest {


    public static void main(String[] args) {
        OrderSymbolTable<Integer,String> symbolTable=new OrderSymbolTable<>();
        symbolTable.put(1,"张");
        symbolTable.put(7,"李");
        symbolTable.put(3,"王");
        symbolTable.put(5,"赵");
        symbolTable.put(4,"六");
        symbolTable.put(8,"田");
        symbolTable.put(2,"测试");

    }

}

