package com.task;

import com.bean.*;
import com.controller.DepartmentController;
import com.controller.SyncPasswordController;
import com.controller.UserController;
import com.dao.*;
import com.service.IUserService;
import com.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class MyTask {

    @Autowired
    private DepartmentController departmentController;
    @Autowired
    private UserController userController;
    @Autowired
    private SyncPasswordController syncPasswordController;

    //每天更新 60000 * 60 * 24
    @Scheduled(fixedRate = 60000)
    public synchronized void sync() {
//        System.out.println("进来了");
//        HttpUtil.sendGet("http://yunbpm.mesnac.com:8080/api/api/dingtalk/synchorize/organization?relatedId=2c90cd367283e880017283e8edc20000","");
//        System.out.println("执行了");
//        //同步根部门
//        departmentController.updateGBMDepartmentList();
//        //同步所有部门
//        departmentController.updateDepartmentList();
//        //同步根部门成员
//        userController.updateBPMGMLUser();
//        //同步所有成员
//        userController.updateUserList();
//        //删除多余部门
//        departmentController.deleteDepartmentList();
//        //删除多余人员
//        userController.deleteUserList();
//        //同步BPM密码到云枢
//        syncPasswordController.syncPassword();
    }


}
