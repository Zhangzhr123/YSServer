package com.controller;

import com.service.ISendDXService;
import com.service.ISyncPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("sendDX")
public class SendDXController {

    @Autowired
    private ISendDXService sendDXService;

    @RequestMapping
    public void sendDX() {
        sendDXService.sendDX();
    }
}
