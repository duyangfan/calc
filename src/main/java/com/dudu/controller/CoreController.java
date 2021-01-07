package com.dudu.controller;

import com.dudu.ms.MainMsg;
import com.dudu.ms.Store;
import com.dudu.ms.WatchLocker;
import com.dudu.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("core")
public class CoreController {



    @RequestMapping("begin")
    public ResultVo<Map<String,String>> begin(int peo, int pro, int store){
        WatchLocker wl=new WatchLocker(0);
        MainMsg msg=new MainMsg(peo,pro,store);
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                MainMsg.menu(wl,msg);
            }
        });

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Store> stores = msg.getStores();
        ResultVo<Map<String,String>> resultVo=null;
        if(stores==null||stores.size()<=0){
            return resultVo=new ResultVo<>(201,"运行失败",null);
        }
        Map<String, String> mapInfo = wl.getMapInfo();
        int min=peo;
        if(min>=pro){
            min=pro;
        }
        while(true){
            if(mapInfo.size()>=min){
                break;
            }
        }
        resultVo=new ResultVo<>(200,"OK",mapInfo);
        return resultVo;
    }

}
