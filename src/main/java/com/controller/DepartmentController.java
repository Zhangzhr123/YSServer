package com.controller;
/**
 * Created by zzr on 2019/06/10
 * 用户表Controller
 */

import com.bean.Depart;
import com.bean.DepartmentEntity;
import com.bean.GetDepartList;
import com.bean.Result;
import com.service.IDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Api(description = "部门信息接口")
@Controller
@RequestMapping("Department")
public class DepartmentController extends BaseController{

	@Autowired
	private IDepartmentService departmentService;

	@ApiOperation(value = "根据BPM根部门同步钉钉根部门", notes="根据BPM根部门同步钉钉根部门")
    @ResponseBody
    @GetMapping("updateGBMDepartmentList")
    public Result<List<Depart>> updateGBMDepartmentList(){
    	Result<List<Depart>> res = departmentService.updateGBMDepartmentList();
    	return res;
    }

	@ApiOperation(value = "根据BPM根部门下所有部门同步钉钉根部门下所有部门", notes="根据BPM根部门下所有部门同步钉钉根部门下所有部门")
	@ResponseBody
	@GetMapping("updateDepartmentList")
	public Result<List<DepartmentEntity>> updateDepartmentList(){
		Result<List<DepartmentEntity>> res = departmentService.updateDepartmentList();
		return res;
	}

	@ApiOperation(value = "根据BPM部门删除钉钉中多余的部门", notes="根据BPM部门删除钉钉中多余的部门")
	@ResponseBody
	@GetMapping("deleteDepartmentList")
	public Result<List<Depart>> deleteDepartmentList(){
		Result<List<Depart>> res = departmentService.deleteDepartmentList();
		return res;
	}

}
