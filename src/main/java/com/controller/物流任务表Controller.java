package com.controller;
/**
 * Created by zzr on 2019/06/10
 * 物流任务表Controller
 */
import com.bean.*;
import com.service.I物流任务表Service;
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
@RequestMapping("物流任务表")
public class 物流任务表Controller extends BaseController {
    @Autowired
    private I物流任务表Service 物流任务表Service;

    @RequestMapping()
    public String index(HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        model.addAttribute("operator", operator);
        return "物流任务表";
    }

    @ResponseBody
    @RequestMapping("getListDataPage")
    public JqueryResult<物流任务表> getListData(@RequestParam(value="page", required=false) int page,
                                           @RequestParam(value="rows", required=false) int rows, 物流任务表 物流任务表, HttpServletRequest request, Model model){
        if(rows == 0){
            rows = 15;
        }
        if(page == 0){
            page = 1;
        }
        long startIndex = (page-1)*rows + 1;
        long endIndex = page*rows + 1;
        物流任务表.setStartIndex(startIndex);
        物流任务表.setEndIndex(endIndex);
        JqueryResult<物流任务表> jres = new JqueryResult<>();
        Result<List<物流任务表>> res = 物流任务表Service.searchWithPage(物流任务表);
        jres.setRows(res.getData());
        jres.setTotal(res.getCount());
        return jres;
    }

    @ResponseBody
    @RequestMapping("getListData")
    public Result<List<物流任务表>> getListData(物流任务表 物流任务表, HttpServletRequest request, Model model){
        Result<List<物流任务表>> res = 物流任务表Service.search(物流任务表);
        return res;
    }

    @ResponseBody
    @RequestMapping("create")
    public Result<物流任务表> create(物流任务表 物流任务表, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<物流任务表> res = 物流任务表Service.create(物流任务表, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("update")
    public Result<物流任务表> update(物流任务表 物流任务表, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<物流任务表> res = 物流任务表Service.updateSelective(物流任务表, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("delete")
    public Result<物流任务表> delete(String objectId, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<物流任务表> res = 物流任务表Service.delete(objectId, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("deleteAll")
    public Result<物流任务表> deleteAll(@RequestBody Param<List<String>> param, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<物流任务表> res = 物流任务表Service.deleteAll(param.getField(), operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("/原料发布入库任务")
    public Result<物流任务表> 原料发布入库任务(@RequestBody ERP单据明细表 ERP单据明细表, HttpServletRequest request, HttpServletResponse response){
        System.out.println(ERP单据明细表.hashCode());
        Result<物流任务表> res = 物流任务表Service.原料发布入库任务(ERP单据明细表);
        return res;
    }

    @ResponseBody
    @RequestMapping("/发布出库任务")
    public Result<物流任务表> 发布出库任务(@RequestBody ERP单据明细表 ERP单据明细表, HttpServletRequest request, HttpServletResponse response){
        System.out.println(ERP单据明细表.hashCode());
        Result<物流任务表> res = 物流任务表Service.发布出库任务(ERP单据明细表);
        return res;
    }

    @ResponseBody
    @RequestMapping("/查询任务")//AGV异常处理
    public Result<List<物流任务表>> 查询任务(@RequestBody 物流任务表 物流任务表, HttpServletRequest request, HttpServletResponse response, Model model){
        Result<List<物流任务表>> res = 物流任务表Service.search任务(物流任务表);
        return res;
    }

    @ResponseBody
    @RequestMapping("/获取任务信息")//AGV异常处理
    public Result<List<物流任务表>> 获取任务信息(@RequestBody List<String> list, HttpServletRequest request, HttpServletResponse response, Model model){
        Result<List<物流任务表>> res = 物流任务表Service.获取任务信息(list);
        return res;
    }

    @ResponseBody
    @RequestMapping("/强制执行")
    public Result<物流任务表> 强制执行(@RequestBody List<String> list, HttpServletRequest request, Model model){
        System.out.println(list.get(0));
        Result<物流任务表> res = 物流任务表Service.强制执行(list);
        return res;
    }

    @ResponseBody
    @RequestMapping("/强制取消")
    public Result<物流任务表> 强制取消(@RequestBody List<String> list, HttpServletRequest request, Model model){
        System.out.println(list.get(0));
        Result<物流任务表> res = 物流任务表Service.强制取消(list);
        return res;
    }

    @ResponseBody
    @RequestMapping("/调拨")
    public Result<物流任务表> 调拨(@RequestBody ERP单据明细表 ERP单据明细表, HttpServletRequest request, Model model){
        System.out.println(ERP单据明细表.hashCode());
        Result<物流任务表> res = 物流任务表Service.调拨(ERP单据明细表);
        return res;
    }

}
