package com.controller;
/**
 * Created by zzr on 2019/06/10
 * 用户表Controller
 */

import com.bean.*;
import com.service.IDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(description = "同步接口")
@Controller
@RequestMapping("SyncDepartAndUser")
public class SyncDepartAndUserController extends BaseController {

    @Autowired
    private DepartmentController departmentController;
    @Autowired
    private UserController userController;
    @Autowired
    private SyncPasswordController syncPasswordController;
    @Autowired
    private com.dao.UserDao UserDao;
    @Autowired
    private com.dao.DepartmentDao departmentDao;
    @Autowired
    private SendDXController sendDXController;

    @ApiOperation(value = "同步接口", notes = "同步接口")
    @ResponseBody
    @GetMapping("SyncAll")
    public void SyncAll() {
        //同步根部门
        departmentController.updateGBMDepartmentList();
        //同步所有部门
        departmentController.updateDepartmentList();
        //同步根部门成员
        userController.updateBPMGMLUser();
        //同步所有成员
        userController.updateUserList();
        //同步之后执行删除
        departmentController.deleteDepartmentList();
        userController.deleteUserList();
    }

    @ApiOperation(value = "同步bpm密码到云枢接口", notes = "同步bpm密码到云枢接口")
    @ResponseBody
    @GetMapping("SyncPw")
    public void SyncPw() {
        //同步BPM密码到云枢
        syncPasswordController.syncPassword();
    }

    @ApiOperation(value = "发送验证码接口", notes = "发送验证码接口")
    @ResponseBody
    @GetMapping("sendDX")
    public void sendDX() {
        //发送短信验证码
        sendDXController.sendDX();
    }

    @ApiOperation(value = "测试接口", notes = "测试接口")
    @ResponseBody
    @GetMapping("test")
    public void test() {
        System.out.println("进来了");
//        sendDXController.sendDX();
    }

}
