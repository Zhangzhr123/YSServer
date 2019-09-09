package com.controller;
/**
 * Created by zzr on 2019/06/10
 * 盘点计划表Controller
 */
import com.bean.*;
import com.service.I盘点计划表Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("盘点计划表")
public class 盘点计划表Controller extends BaseController {
    @Autowired
    private I盘点计划表Service 盘点计划表Service;

    @RequestMapping()
    public String index(HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        model.addAttribute("operator", operator);
        return "盘点计划表";
    }
    @ResponseBody
    @RequestMapping("getListDataPage")
    public JqueryResult<盘点计划表> getListData(@RequestParam(value="page", required=false) int page,
                                           @RequestParam(value="rows", required=false) int rows, 盘点计划表 盘点计划表, HttpServletRequest request, Model model){
        if(rows == 0){
            rows = 15;
        }
        if(page == 0){
            page = 1;
        }
        long startIndex = (page-1)*rows + 1;
        long endIndex = page*rows + 1;
        盘点计划表.setStartIndex(startIndex);
        盘点计划表.setEndIndex(endIndex);
        JqueryResult<盘点计划表> jres = new JqueryResult<>();
        Result<List<盘点计划表>> res = 盘点计划表Service.searchWithPage(盘点计划表);
        jres.setRows(res.getData());
        jres.setTotal(res.getCount());
        return jres;
    }
    @ResponseBody
    @RequestMapping("getListData")
    public Result<List<盘点计划表>> getListData(盘点计划表 盘点计划表, HttpServletRequest request, Model model){
        Result<List<盘点计划表>> res = 盘点计划表Service.search(盘点计划表);
        return res;
    }
    @ResponseBody
    @RequestMapping("create")
    public Result<盘点计划表> create(盘点计划表 盘点计划表, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<盘点计划表> res = 盘点计划表Service.create(盘点计划表, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("update")
    public Result<盘点计划表> update(盘点计划表 盘点计划表, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<盘点计划表> res = 盘点计划表Service.updateSelective(盘点计划表, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("delete")
    public Result<盘点计划表> delete(String objectId, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<盘点计划表> res = 盘点计划表Service.delete(objectId, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("deleteAll")
    public Result<盘点计划表> deleteAll(@RequestBody Param<List<String>> param, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<盘点计划表> res = 盘点计划表Service.deleteAll(param.getField(), operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("/获取盘点计划")//获取盘点计划信息
    public Result<List<盘点计划表>> 获取盘点计划(HttpServletRequest request,@RequestBody 盘点计划表 盘点计划表){
        Result<List<盘点计划表>> res = 盘点计划表Service.searchAll(盘点计划表);
        return res;
    }

    @ResponseBody
    @RequestMapping("/根据计划编号获取盘点计划")//根据计划编号获取信息
    public Result<List<盘点计划表>> 根据计划编号获取盘点计划(HttpServletRequest request,@RequestBody 盘点计划表 盘点计划表){
        Result<List<盘点计划表>> res = 盘点计划表Service.search计划编号(盘点计划表);
        return res;
    }

    @ResponseBody
    @RequestMapping("/修改完成程度")//根据计划编号获取信息
    public Result<盘点计划表> 修改完成程度(HttpServletRequest request,@RequestBody 盘点计划表 盘点计划表){
        Result<盘点计划表> res = 盘点计划表Service.修改完成程度(盘点计划表);
        return res;
    }

    @ResponseBody
    @RequestMapping("/已完成")//根据计划编号获取信息
    public Result<盘点计划表> 已完成(HttpServletRequest request,@RequestBody 盘点计划表 盘点计划表){
        Result<盘点计划表> res = 盘点计划表Service.已完成(盘点计划表);
        return res;
    }
}
