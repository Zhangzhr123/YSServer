package com.controller;
/**
 * Created by zzr on 2019/06/10
 * 盘点差异表Controller
 */
import com.bean.*;
import com.service.I盘点差异表Service;
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
@RequestMapping("盘点差异表")
public class 盘点差异表Controller extends BaseController {
    @Autowired
    private I盘点差异表Service 盘点差异表Service;

    @RequestMapping()
    public String index(HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        model.addAttribute("operator", operator);
        return "盘点差异表";
    }
    @ResponseBody
    @RequestMapping("getListDataPage")
    public JqueryResult<盘点差异表> getListData(@RequestParam(value="page", required=false) int page,
                                           @RequestParam(value="rows", required=false) int rows, 盘点差异表 盘点差异表, HttpServletRequest request, Model model){
        if(rows == 0){
            rows = 15;
        }
        if(page == 0){
            page = 1;
        }
        long startIndex = (page-1)*rows + 1;
        long endIndex = page*rows + 1;
        盘点差异表.setStartIndex(startIndex);
        盘点差异表.setEndIndex(endIndex);
        JqueryResult<盘点差异表> jres = new JqueryResult<>();
        Result<List<盘点差异表>> res = 盘点差异表Service.searchWithPage(盘点差异表);
        jres.setRows(res.getData());
        jres.setTotal(res.getCount());
        return jres;
    }
    @ResponseBody
    @RequestMapping("getListData")
    public Result<List<盘点差异表>> getListData(盘点差异表 盘点差异表, HttpServletRequest request, Model model){
        Result<List<盘点差异表>> res = 盘点差异表Service.search(盘点差异表);
        return res;
    }
    @ResponseBody
    @RequestMapping("create")
    public Result<盘点差异表> create(盘点差异表 盘点差异表, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<盘点差异表> res = 盘点差异表Service.create(盘点差异表, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("update")
    public Result<盘点差异表> update(盘点差异表 盘点差异表, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<盘点差异表> res = 盘点差异表Service.updateSelective(盘点差异表, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("delete")
    public Result<盘点差异表> delete(String objectId, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<盘点差异表> res = 盘点差异表Service.delete(objectId, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("deleteAll")
    public Result<盘点差异表> deleteAll(@RequestBody Param<List<String>> param, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<盘点差异表> res = 盘点差异表Service.deleteAll(param.getField(), operator);
        return res;
    }
}
