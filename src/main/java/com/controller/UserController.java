package com.controller;
/**
 * Created by zzr on 2019/06/10
 * 用户表Controller
 */
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.*;
import com.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Api(description = "用户信息接口")
@Controller
@RequestMapping("User")
public class UserController extends BaseController{

	@Autowired
	private IUserService userService;

	@ApiOperation(value = "根据BPM部门人员同步钉钉部门人员", notes="根据BPM部门人员同步钉钉部门人员")
    @ResponseBody
    @GetMapping("updateUserList")
    public Result<Map<String, String>> updateUserList(){
    	Result<Map<String, String>> res = userService.updateUserList();
    	return res;
    }

	@ApiOperation(value = "同步BPM根目录下的人员信息", notes="同步BPM根目录下的人员信息")
	@ResponseBody
	@GetMapping("updateBPMGMLUser")
	public Result<List<User>> updateBPMGMLUser(){
		Result<List<User>> res = userService.updateBPMGMLUser();
		return res;
	}

	@ApiOperation(value = "根据BPM人员删除钉钉人员", notes="根据BPM人员删除钉钉人员")
	@ResponseBody
	@GetMapping("deleteUserList")
	public Result<Map<String, String>> deleteUserList(){
		Result<Map<String, String>> res = userService.deleteUserList();
		return res;
	}

}
