package com.dudu.ms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainMsg {

    public static final String PEOPLE_LOCK="";
    public static final String STORE_LOCK="";

    public static final  String singleLock="";

    private int peoNum[];
    private int proNum[];
    private int storeNum;




    public static void menu(){
        System.out.println("init ...");
        Scanner sc=new Scanner(System.in);
        System.out.print("config people num:");
        final int peoNum =sc.nextInt();
        System.out.println();
        System.out.print("config product num:");
        final int proNum = sc.nextInt();
        System.out.println();
        System.out.print("config store num:");
        final int storeNum = sc.nextInt();
        System.out.println();
        MainMsg mainMsg=new MainMsg(peoNum,proNum,storeNum);
        mainMsg.config();
        mainMsg.init();
        final WatchLocker watchLocker=new WatchLocker(0);
        Thread single=null;
        while(true){
            if(!Store.IS_BEGIN){
                System.out.println("is beginning? 1 OK ");
                if(single==null){
                    single=new Thread(new Runnable() {
                        @Override
                        public void run() {
                            synchronized (Store.FINISH_SIGNAL){
                                try {
                                    System.out.println("mainMSG wait");
                                    Store.FINISH_SIGNAL.wait();

                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            while(Store.STOP_SINGLE<storeNum){
                                synchronized (singleLock){
                                    singleLock.notifyAll();
                                }
                            }
                            System.out.println("Stop_Single"+Store.STOP_SINGLE);
                            long endTime= new Date().getTime();
                            watchLocker.setEnd(endTime);

                            System.out.println("single thread is finished ...");
                            System.out.println("耗时："+watchLocker.getTmes()+"ms");
                            System.out.println("sell product is "+People.sellNum);
                            System.out.println("productNum : "+ proNum+"  peopleNum :"+peoNum+"  storeNum : "+storeNum);

                        }
                    });
                    single.start();
                }
                int i = sc.nextInt();
                if(i!=1){
                    continue;
                }
                Date date=new Date();
                long beginTime= date.getTime();
                watchLocker.setStart(beginTime);
                Store.IS_BEGIN=true;
                synchronized (PEOPLE_LOCK){
                    PEOPLE_LOCK.notifyAll();
                }
                synchronized (STORE_LOCK){
                    STORE_LOCK.notifyAll();;
                }
            }
            break;
        }
    }


    public  void init(){
        if(proNum.length<=0){
            return;
        }
        if(proNum.length<=0){
            return ;
        }
        if(storeNum<=0){
            return;
        }

        List<Store> stores=new ArrayList<>();
        for (int i=0;i<storeNum;i++){
            Store store = new Store(storeNum);
            for (int j=0;j<peoNum[i];j++){
                store.setPeoples(new People("people"));
            }
            for (int j=0;j<proNum[i];j++){
                store.setProducts(new Product("product"));
            }
            store.start();
            stores.add(store);
        }
    }

    public MainMsg(int peoNum, int proNum, int storeNum) {
        this.peoNum = new int[peoNum];
        this.proNum = new int[proNum];
        this.storeNum = storeNum;
    }

    public void config(){
        if(peoNum.length<0&&proNum.length<0&&storeNum<0){
            System.out.println("date must be >0");
            return ;
        }
        this.proNum=getArr(storeNum,proNum.length);
        this.peoNum=getArr(storeNum,peoNum.length);
    }

    public static int[] getArr(int stores,int total){
        int size=total/stores;
        int[] temp=new int[stores];
        int index=0;
        for (int i=0;i<stores-1;i++){
            temp[i]=size;
            index+=size;
        }
        temp[temp.length-1]=total-index;
        return temp;
    }

    public static void main(String[] args) {
        menu();
    }

}
