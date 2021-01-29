package com.dudu.ms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store extends Thread {

    public static boolean IS_BEGIN=false;
    public static boolean IS_FINISH=false;
    public static String SELL_LOCK="";
    public static int STOP_SINGLE=0;
    public static String FINISH_SIGNAL="";

    public static int id=1;
    private String storeName;
    private int storeNum=0;

    private boolean isFinish=false;
    private List<People> peoples=new ArrayList<>();
    private List<Product> products=new ArrayList<>();
    private WatchLocker watchLocker=null;

    public void setProducts(Product pro){

        this.products.add(pro);
    }

    public void setPeoples(People peo){

        this.peoples.add(peo);
    }

    public  People getPeople(){
        synchronized (this){
            if(this.peoples.size()>0){
                int index=(int)(Math.random()*(this.peoples.size()-1));
                return this.peoples.remove(index);
            }
        }
        return null;

    }


    public  void sellPro(People peo){
        if(peo==null){
            return ;
        }
        synchronized (SELL_LOCK){
            if(this.products.size()>0){
                Product pro = this.products.remove(0);
                peo.start();
                peo.setProduct(pro);
                Map<String, String> mapInfo = this.watchLocker.getMapInfo();
                mapInfo.put(peo.getName(),pro.getName());
            }
        }
    }



    @Override
    public void run() {
        while(true){
            if(IS_FINISH){
                break;
            }
            if(isFinish){
               break;
            }
            if(!IS_BEGIN){
                synchronized (MainMsg.STORE_LOCK){
                    try {
                        MainMsg.STORE_LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            synchronized (SELL_LOCK){
                if(this.peoples.size()<=0){
                    isFinish=true;
                    STOP_SINGLE++;
                    break;
                }
                if(this.products.size()<=0){
                    isFinish=true;
                    STOP_SINGLE++;
                    break;
                }
            }
            People people = getPeople();
            sellPro(people);
        }

        if(Store.STOP_SINGLE>=storeNum){
            synchronized (Store.FINISH_SIGNAL){
                Store.FINISH_SIGNAL.notify();
            }
        }
    }


    public void show(){
        Map<String, String> mapInfo = this.watchLocker.getMapInfo();
        for (Map.Entry<String,String> entry:mapInfo.entrySet()){
            System.out.println(entry.getKey()+"<----->"+entry.getValue());
        }
    }


    public Store(int storeNum,WatchLocker watchLocker) {
        this.watchLocker=watchLocker;
        this.storeName="store_"+id++;
        this.storeNum=storeNum;
        setName(storeName);
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeName='" + storeName + '\'' +
                '}';
    }
}
