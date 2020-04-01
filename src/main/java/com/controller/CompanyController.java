package com.controller;
/**
 * Created by zzr on 2019/06/10
 * 用户表Controller
 */
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.*;
import com.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Company")
public class CompanyController extends BaseController{

	@Autowired
	private ICompanyService CompanyService;

	@RequestMapping()
	public String index(HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
		model.addAttribute("operator", operator);
		return "Company";
	}

	@ResponseBody
	@RequestMapping("getListData")
	public Result<List<Company>> getListData(@RequestBody Company Company, HttpServletRequest request, HttpServletResponse response, Model model){
		Result<List<Company>> res = CompanyService.getAll();
		return res;
	}
	@ResponseBody
	@RequestMapping("create")
	public Result<Company> create(Company Company, HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
		Result<Company> res = CompanyService.create(Company, operator);
		return res;
	}

	@ResponseBody
	@RequestMapping("update")
	public Result<Company> update(Company Company, HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
		Result<Company> res = CompanyService.update(Company, operator);
		return res;
	}

	@ResponseBody
	@RequestMapping("delete")
	public Result<Company> delete(String objectId, HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
		Result<Company> res = CompanyService.delete(objectId, operator);
		return res;
	}

	@ResponseBody
	@RequestMapping("deleteAll")
	public Result<Company> deleteAll(@RequestBody Param<List<String>> param, HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
		Result<Company> res = CompanyService.deleteAll(param.getField(), operator);
		return res;
	}
}
