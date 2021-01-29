package com.dudu.ms;

public class People extends Thread {

    public  static  int id=1;



    public  static int sellNum=0;

    private  Product  product;

    private String peoName;

    private boolean isGet=false;

    public People(String peoName) {
        this.peoName = peoName+"_"+id++;
        setName(this.peoName);
    }

    public void setProduct(Product product) {
        this.product = product;
        sellNum++;
        isGet=true;
    }


    @Override
    public void run() {
        while(true){
            if(!Store.IS_BEGIN){
                synchronized (MainMsg.PEOPLE_LOCK){
                    try {
                        MainMsg.PEOPLE_LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(isGet){
                System.out.println(this.peoName+" get "+ this.product.getName());
               break;
            }
            if(Store.IS_FINISH){
                System.out.println(this.peoName+" no ...... ");
                break;
            }
        }
        System.out.println(this.getName()+" quit 。。");
    }



    @Override
    public String toString() {
        return "People{" +
                "peoName='" + peoName + '\'' +
                '}';
    }
}
