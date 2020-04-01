package com.controller;
/**
 * Created by zzr on 2019/06/10
 * 用户表Controller
 */

import com.bean.Filling;
import com.bean.Param;
import com.bean.Result;
import com.bean.User;
import com.service.IFillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("Filling")
public class FillingController extends BaseController{

	@Autowired
	private IFillingService FillingService;

	@RequestMapping()
	public String index(HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
		model.addAttribute("operator", operator);
		return "Filling";
	}

	@ResponseBody
	@RequestMapping("getListData")
	public Result<List<Filling>> getListData(@RequestBody Filling filling, HttpServletRequest request, Model model){
		Result<List<Filling>> res = FillingService.getAll();
		return res;
	}
	@ResponseBody
	@RequestMapping("create")
	public Result<Filling> create(@RequestBody Filling filling, HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
		Result<Filling> res = FillingService.create(filling, operator);
		return res;
	}

	@ResponseBody
	@RequestMapping("update")
	public Result<Filling> update(Filling filling, HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
		Result<Filling> res = FillingService.update(filling, operator);
		return res;
	}

	@ResponseBody
	@RequestMapping("delete")
	public Result<Filling> delete(String objectId, HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
		Result<Filling> res = FillingService.delete(objectId, operator);
		return res;
	}

	@ResponseBody
	@RequestMapping("deleteAll")
	public Result<Filling> deleteAll(@RequestBody Param<List<String>> param, HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
		Result<Filling> res = FillingService.deleteAll(param.getField(), operator);
		return res;
	}

	@ResponseBody
	@RequestMapping("setListData")
	public Result<List<Filling>> setListData(@RequestBody List<Filling> listFilling, HttpServletRequest request, HttpServletResponse response, Model model){
		Result<List<Filling>> res = FillingService.setListData(listFilling);
		return res;
	}
}
