package com.controller;
/**
 * Created by zzr on 2019/06/10
 * RecordsController
 */
import com.bean.*;
import com.service.IRecordsService;
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
@RequestMapping("Records")
public class RecordsController extends BaseController {
    @Autowired
    private IRecordsService RecordsService;

    @RequestMapping()
    public String index(HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        model.addAttribute("operator", operator);
        return "Records";
    }
    @ResponseBody
    @RequestMapping("getListDataPage")
    public JqueryResult<Records> getListData(@RequestParam(value="page", required=false) int page,
                                           @RequestParam(value="rows", required=false) int rows, Records Records, HttpServletRequest request, Model model){
        if(rows == 0){
            rows = 15;
        }
        if(page == 0){
            page = 1;
        }
        long startIndex = (page-1)*rows + 1;
        long endIndex = page*rows + 1;
        Records.setStartIndex(startIndex);
        Records.setEndIndex(endIndex);
        JqueryResult<Records> jres = new JqueryResult<>();
        Result<List<Records>> res = RecordsService.searchWithPage(Records);
        jres.setRows(res.getData());
        jres.setTotal(res.getCount());
        return jres;
    }
    @ResponseBody
    @RequestMapping("getListData")
    public Result<List<Records>> getListData(Records Records, HttpServletRequest request, Model model){
        Result<List<Records>> res = RecordsService.search(Records);
        return res;
    }
    @ResponseBody
    @RequestMapping("create")
    public Result<Records> create(Records Records, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<Records> res = RecordsService.create(Records, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("update")
    public Result<Records> update(Records Records, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<Records> res = RecordsService.updateSelective(Records, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("delete")
    public Result<Records> delete(String objectId, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<Records> res = RecordsService.delete(objectId, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("deleteAll")
    public Result<Records> deleteAll(@RequestBody Param<List<String>> param, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<Records> res = RecordsService.deleteAll(param.getField(), operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("/getList")
    public Result<List<Records>> getList(String barCode, HttpServletRequest request, HttpServletResponse response, Model model){
        System.out.println(barCode);
        Result<List<Records>> res = RecordsService.getList(barCode);
        return res;
    }

    @ResponseBody
    @RequestMapping("/updateType")
    public Result<Records> updateType(String barCode, HttpServletRequest request,HttpServletResponse response, Model model){
        System.out.println(barCode);
        Result<Records> res = RecordsService.updateType(barCode);
        return res;
    }
    
}
