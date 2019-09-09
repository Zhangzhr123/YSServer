package com.controller;
/**
 * Created by zzr on 2019/06/10
 * 仓库单据明细表Controller
 */
import com.bean.*;
import com.service.I仓库单据明细表Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("仓库单据明细表")
public class 仓库单据明细表Controller extends BaseController {

    @Autowired
    private I仓库单据明细表Service 仓库单据明细表Service;

    @RequestMapping()
    public String index(HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        model.addAttribute("operator", operator);
        return "仓库单据明细表";
    }
    @ResponseBody
    @RequestMapping("getListDataPage")
    public JqueryResult<仓库单据明细表> getListData(@RequestParam(value="page", required=false) int page,
                                             @RequestParam(value="rows", required=false) int rows, 仓库单据明细表 仓库单据明细表, HttpServletRequest request, Model model){
        if(rows == 0){
            rows = 15;
        }
        if(page == 0){
            page = 1;
        }
        long startIndex = (page-1)*rows + 1;
        long endIndex = page*rows + 1;
        仓库单据明细表.setStartIndex(startIndex);
        仓库单据明细表.setEndIndex(endIndex);
        JqueryResult<仓库单据明细表> jres = new JqueryResult<>();
        Result<List<仓库单据明细表>> res = 仓库单据明细表Service.searchWithPage(仓库单据明细表);
        jres.setRows(res.getData());
        jres.setTotal(res.getCount());
        return jres;
    }
    @ResponseBody
    @RequestMapping("getListData")
    public Result<List<仓库单据明细表>> getListData(仓库单据明细表 仓库单据明细表, HttpServletRequest request, Model model){
        Result<List<仓库单据明细表>> res = 仓库单据明细表Service.search(仓库单据明细表);
        return res;
    }
    @ResponseBody
    @RequestMapping("create")
    public Result<仓库单据明细表> create(仓库单据明细表 仓库单据明细表, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<仓库单据明细表> res = 仓库单据明细表Service.create(仓库单据明细表, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("update")
    public Result<仓库单据明细表> update(仓库单据明细表 仓库单据明细表, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<仓库单据明细表> res = 仓库单据明细表Service.updateSelective(仓库单据明细表, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("delete")
    public Result<仓库单据明细表> delete(String objectId, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<仓库单据明细表> res = 仓库单据明细表Service.delete(objectId, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("deleteAll")
    public Result<仓库单据明细表> deleteAll(@RequestBody Param<List<String>> param, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<仓库单据明细表> res = 仓库单据明细表Service.deleteAll(param.getField(), operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("/根据物料编号获取仓库单据明细")//根据单据编号获取信息
    public Result<List<仓库单据明细表>> 根据物料编号获取仓库单据明细(HttpServletRequest request,@RequestBody 仓库单据明细表 仓库单据明细表){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<List<仓库单据明细表>> res = 仓库单据明细表Service.search物料编号(仓库单据明细表);
        return res;
    }

    @ResponseBody
    @RequestMapping("/获取仓库单据明细")//根据单据编号获取信息
    public Result<List<仓库单据明细表>> 获取仓库单据明细(HttpServletRequest request,@RequestBody 仓库单据明细表 仓库单据明细表){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<List<仓库单据明细表>> res = 仓库单据明细表Service.searchAll(仓库单据明细表);
        return res;
    }
}
