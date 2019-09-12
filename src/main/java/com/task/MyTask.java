package com.task;

import com.bean.*;
import com.dao.*;
import com.service.I物流任务表Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class MyTask {

    @Autowired
    private I物流任务表Service 物流任务表Service;

    //每分钟更新stockIn
    @Scheduled(fixedRate = 60000)
    public synchronized void stockIn() {
        物流任务表Service.stockIn();
    }

    //每分钟更新productOut
    @Scheduled(fixedRate = 60000)
    public synchronized void productOut() {
        物流任务表Service.productOut();
    }

    //每分钟更新allocation
    @Scheduled(fixedRate = 60000)
    public synchronized void allocation() {
        物流任务表Service.allocation();
    }


}
