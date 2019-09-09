package com.controller;
/**
 * Created by zzr on 2019/06/10
 * 库存查询表Controller
 */
import com.bean.*;
import com.service.I库存查询表Service;
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
@RequestMapping("库存查询表")
public class 库存查询表Controller extends BaseController {

    @Autowired
    private I库存查询表Service 库存查询表Service;

    @RequestMapping()
    public String index(HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        model.addAttribute("operator", operator);
        return "库存查询表";
    }
    @ResponseBody
    @RequestMapping("getListDataPage")
    public JqueryResult<库存查询表> getListData(@RequestParam(value="page", required=false) int page,
                                           @RequestParam(value="rows", required=false) int rows, 库存查询表 库存查询表, HttpServletRequest request, Model model){
        if(rows == 0){
            rows = 15;
        }
        if(page == 0){
            page = 1;
        }
        long startIndex = (page-1)*rows + 1;
        long endIndex = page*rows + 1;
        库存查询表.setStartIndex(startIndex);
        库存查询表.setEndIndex(endIndex);
        JqueryResult<库存查询表> jres = new JqueryResult<>();
        Result<List<库存查询表>> res = 库存查询表Service.searchWithPage(库存查询表);
        jres.setRows(res.getData());
        jres.setTotal(res.getCount());
        return jres;
    }
    @ResponseBody
    @RequestMapping("getListData")
    public Result<List<库存查询表>> getListData(库存查询表 库存查询表, HttpServletRequest request, Model model){
        Result<List<库存查询表>> res = 库存查询表Service.search(库存查询表);
        return res;
    }
    @ResponseBody
    @RequestMapping("create")
    public Result<库存查询表> create(库存查询表 库存查询表, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<库存查询表> res = 库存查询表Service.create(库存查询表, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("update")
    public Result<库存查询表> update(库存查询表 库存查询表, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<库存查询表> res = 库存查询表Service.updateSelective(库存查询表, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("delete")
    public Result<库存查询表> delete(String objectId, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<库存查询表> res = 库存查询表Service.delete(objectId, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("deleteAll")
    public Result<库存查询表> deleteAll(@RequestBody Param<List<String>> param, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<库存查询表> res = 库存查询表Service.deleteAll(param.getField(), operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("/修改库存状态")
    public Result<库存查询表> 修改库存状态(@RequestBody 库存查询表 库存查询表, HttpServletRequest request, Model model){
        System.out.println(库存查询表.get条码编号());
        Result<库存查询表> res = 库存查询表Service.修改库存状态(库存查询表);
        return res;
    }
}
