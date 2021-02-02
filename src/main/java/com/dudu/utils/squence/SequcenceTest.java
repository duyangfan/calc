package com.dudu.utils.squence;

public class SequcenceTest {
    public static void main(String[] args) {
        SequenceList<String> seq=new SequenceList<>(2);

        seq.insert("N");
        seq.insert("M");
        seq.insert("V");

        seq.insert(1,"D");
        seq.insert(0,"A");

        //System.out.println(seq.get(1));

        //System.out.println(seq.remove(4));

        System.out.println(seq.length());
        for (int i=0;i<seq.length();i++){
            System.out.println(seq.get(i));
        }
    }
}
