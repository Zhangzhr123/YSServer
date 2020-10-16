package com.controller;

import com.service.ISyncPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("syncpassword")
public class SyncPasswordController {

//    public static boolean ifStart = false;
    @Autowired
    private ISyncPasswordService syncPasswordService;
//    BlockingQueue queue = new LinkedBlockingQueue();
//    ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 1000, TimeUnit.SECONDS, queue);
    @RequestMapping
    public void syncPassword(){
        syncPasswordService.syncPassword();
//        if(!ifStart){
//            ifStart = true;
//            executor.execute(new Runnable() {
//                @Override
//                public void run(){
//                    while (ifStart){
//
////                        try {
////                            Thread.sleep(24*60*60000);
////                        } catch (InterruptedException e) {
////                            e.printStackTrace();
////                        }
//                    }
//                }
//            });
//        }
    }
}
