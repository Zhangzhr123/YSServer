package com.controller;
/**
 * Created by zzr on 2019/06/10
 * 用户表Controller
 */
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.*;
import com.service.ICylinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Cylinder")
public class CylinderController extends BaseController{

	@Autowired
	private ICylinderService CylinderService;

	@RequestMapping()
	public String index(HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
		model.addAttribute("operator", operator);
		return "Cylinder";
	}

	@ResponseBody
	@RequestMapping("getListData")
	public Result<List<Cylinder>> getListData(@RequestBody Cylinder cylinder, HttpServletRequest request, HttpServletResponse response, Model model){
		Result<List<Cylinder>> res = CylinderService.getAll();
		return res;
	}
	@ResponseBody
	@RequestMapping("create")
	public Result<Cylinder> create(Cylinder cylinder, HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
		Result<Cylinder> res = CylinderService.create(cylinder, operator);
		return res;
	}

	@ResponseBody
	@RequestMapping("update")
	public Result<Cylinder> update(Cylinder cylinder, HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
		Result<Cylinder> res = CylinderService.update(cylinder, operator);
		return res;
	}

	@ResponseBody
	@RequestMapping("delete")
	public Result<Cylinder> delete(String objectId, HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
		Result<Cylinder> res = CylinderService.delete(objectId, operator);
		return res;
	}

	@ResponseBody
	@RequestMapping("deleteAll")
	public Result<Cylinder> deleteAll(@RequestBody Param<List<String>> param, HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
		Result<Cylinder> res = CylinderService.deleteAll(param.getField(), operator);
		return res;
	}

	@ResponseBody
	@RequestMapping("selsectByKey")
	public Result<Cylinder> selsectByKey(@RequestBody Cylinder cylinder, HttpServletRequest request, Model model){
		System.out.println(cylinder.getCylinderQRCode());
		Result<Cylinder> res = CylinderService.selsectByKey(cylinder);
		return res;
	}

	@ResponseBody
	@RequestMapping("insertGPInformation")
	public Result<List<Cylinder>> insertGPInformation(@RequestBody List<Cylinder> cylinder, HttpServletRequest request, HttpServletResponse response, Model model){
		Result<List<Cylinder>> res = CylinderService.insertGPInformation(cylinder);
		return res;
	}
}
