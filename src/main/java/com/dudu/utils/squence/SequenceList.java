package com.dudu.utils.squence;

import java.util.Iterator;

public class SequenceList<T> implements Sequence<T>,Iterable<T>{

    private T[] data;

    private int size;

    public SequenceList(int capacity){
        this.data= (T[]) new Object[capacity];
        this.size=0;
    }


    @Override
    public void clear() {
        this.size=0;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public T get(int i) {
        return data[i];
    }

    @Override
    public void insert(T t) {
        if(data.length==size){
            reSize(data.length*2);
        }
        data[size++]=t;
    }

    @Override
    public void insert(int index, T t) {
        if(data.length==size){
            reSize(data.length*2);
        }
        for(int i=size;i>index;i-- ){
            data[i]=data[i-1];
        }
        data[index]=t;
        size++;
    }

    @Override
    public T remove(int i) {
        if(data.length/2==size){
            reSize(data.length/2);
        }
        T temp=data[i];
        for (int index=i;i<size-1;i++)
        {
            data[index]=data[index+1];
        }
        size--;
        return temp;
    }

    @Override
    public int indexOf(T t) {
        for (int i=0;i<size;i++){
            if(data[i].equals(t)){
                return i;
            }
        }
        return -1;
    }


    public void reSize(int size){
        T[] temp=data;
        data= (T[]) new Object[size];
        for (int i=0;i<this.size;i++){
            data[i]=temp[i];
        }
    }




    @Override
    public Iterator<T> iterator() {
        return new SeqIterator();
    }

    private class SeqIterator  implements Iterator{

        private int index=0;
        @Override
        public boolean hasNext() {
            return index<size;
        }

        @Override
        public Object next() {
            return data[index++];
        }
    }
}
