package com.controller;
/**
 * Created by zzr on 2019/06/10
 * 用户表Controller
 */

import com.bean.*;
import com.service.IParameterService;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("Parameter")
public class ParameterController extends BaseController{

	@Autowired
	private IParameterService parameterService;
	
	@RequestMapping()
    public String index(HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
        model.addAttribute("operator", operator);
        return "Parameter";
    }
    @ResponseBody
    @RequestMapping("getListData")
    public Result<List<Parameter>> getListData(@RequestBody Parameter parameter, HttpServletRequest request, HttpServletResponse response, Model model){
    	Result<List<Parameter>> res = parameterService.getAll();
    	return res;
    }
    @ResponseBody
	@RequestMapping("create")
    public Result<Parameter> create(Parameter parameter, HttpServletRequest request, Model model){
    	User operator = (User)request.getSession().getAttribute("operator");
    	Result<Parameter> res = parameterService.create(parameter, operator);
    	return res;
    }

    @ResponseBody
	@RequestMapping("update")
    public Result<Parameter> update(Parameter parameter, HttpServletRequest request, Model model){
    	User operator = (User)request.getSession().getAttribute("operator");
    	Result<Parameter> res = parameterService.update(parameter, operator);
    	return res;
    }
    
    @ResponseBody
	@RequestMapping("delete")
    public Result<Parameter> delete(String objectId, HttpServletRequest request, Model model){
    	User operator = (User)request.getSession().getAttribute("operator");
    	Result<Parameter> res = parameterService.delete(objectId, operator);
    	return res;
    }
    
    @ResponseBody
	@RequestMapping("deleteAll")
    public Result<Parameter> deleteAll(@RequestBody Param<List<String>> param, HttpServletRequest request, Model model){
    	User operator = (User)request.getSession().getAttribute("operator");
    	Result<Parameter> res = parameterService.deleteAll(param.getField(), operator);
    	return res;
    }
}
