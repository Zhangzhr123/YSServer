package com.controller;
/**
 * Created by zzr on 2019/06/10
 * 物流任务历史表Controller
 */
import com.bean.*;
import com.service.I物流任务历史表Service;
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
@RequestMapping("物流任务历史表")
public class 物流任务历史表Controller extends BaseController {
    @Autowired
    private I物流任务历史表Service 物流任务历史表Service;

    @RequestMapping()
    public String index(HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        model.addAttribute("operator", operator);
        return "物流任务历史表";
    }
    @ResponseBody
    @RequestMapping("getListDataPage")
    public JqueryResult<物流任务历史表> getListData(@RequestParam(value="page", required=false) int page,
                                           @RequestParam(value="rows", required=false) int rows, 物流任务历史表 物流任务历史表, HttpServletRequest request, Model model){
        if(rows == 0){
            rows = 15;
        }
        if(page == 0){
            page = 1;
        }
        long startIndex = (page-1)*rows + 1;
        long endIndex = page*rows + 1;
        物流任务历史表.setStartIndex(startIndex);
        物流任务历史表.setEndIndex(endIndex);
        JqueryResult<物流任务历史表> jres = new JqueryResult<>();
        Result<List<物流任务历史表>> res = 物流任务历史表Service.searchWithPage(物流任务历史表);
        jres.setRows(res.getData());
        jres.setTotal(res.getCount());
        return jres;
    }
    @ResponseBody
    @RequestMapping("getListData")
    public Result<List<物流任务历史表>> getListData(物流任务历史表 物流任务历史表, HttpServletRequest request, Model model){
        Result<List<物流任务历史表>> res = 物流任务历史表Service.search(物流任务历史表);
        return res;
    }
    @ResponseBody
    @RequestMapping("create")
    public Result<物流任务历史表> create(物流任务历史表 物流任务历史表, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<物流任务历史表> res = 物流任务历史表Service.create(物流任务历史表, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("update")
    public Result<物流任务历史表> update(物流任务历史表 物流任务历史表, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<物流任务历史表> res = 物流任务历史表Service.updateSelective(物流任务历史表, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("delete")
    public Result<物流任务历史表> delete(String objectId, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<物流任务历史表> res = 物流任务历史表Service.delete(objectId, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("deleteAll")
    public Result<物流任务历史表> deleteAll(@RequestBody Param<List<String>> param, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<物流任务历史表> res = 物流任务历史表Service.deleteAll(param.getField(), operator);
        return res;
    }

//    @ResponseBody
//    @RequestMapping("/抽检返架")
//    public Result<List<物流任务历史表>> 抽检返架(@RequestBody 物流任务历史表 物流任务历史表, HttpServletRequest request, Model model){
//        Result<List<物流任务历史表>> res = 物流任务历史表Service.抽检返架(物流任务历史表);
//        return res;
//    }
}
