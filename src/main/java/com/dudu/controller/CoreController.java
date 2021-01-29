package com.dudu.controller;

import com.dudu.ms.MainMsg;
import com.dudu.ms.Store;
import com.dudu.ms.WatchLocker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("core")
public class CoreController {

    @RequestMapping("begin")
    public void begin(int peo, int pro, int store){
        WatchLocker wl=new WatchLocker(0);
        MainMsg msg=new MainMsg(peo,pro,store);
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                MainMsg.menu(wl,msg);
            }
        });
        /**
         *
         **/
        Store.IS_BEGIN=false;
        t1.start();
    }
}

class  A{
    private String name="f";

    public String getName() {
        return name;
    }
}

class B extends A{
    private String name="c";
    int i=015;

    public void show(){

        System.out.println(i);
    }

    public static void main(String[] args) {
        B b=new B();
        System.out.println(b.getName());
        b.show();
    }
}
