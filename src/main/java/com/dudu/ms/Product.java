package com.dudu.ms;

public class Product {

    public  static int id=1 ;

    private String name;

    public String getName() {
        return name;
    }

    public Product(String name) {
        this.name = name+"_"+id++;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
