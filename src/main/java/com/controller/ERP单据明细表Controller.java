package com.controller;

import com.bean.*;
import com.service.IERP单据明细表Service;
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
@RequestMapping("ERP单据明细表")
public class ERP单据明细表Controller extends BaseController {
    @Autowired
    private IERP单据明细表Service ERP单据明细表Service;

    @RequestMapping()
    public String index(HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        model.addAttribute("operator", operator);
        return "ERP单据明细表";
    }
    @ResponseBody
    @RequestMapping("getListDataPage")
    public JqueryResult<ERP单据明细表> getListData(@RequestParam(value="page", required=false) int page,
                                              @RequestParam(value="rows", required=false) int rows, ERP单据明细表 ERP单据明细表, HttpServletRequest request, Model model){
        if(rows == 0){
            rows = 15;
        }
        if(page == 0){
            page = 1;
        }
        long startIndex = (page-1)*rows + 1;
        long endIndex = page*rows + 1;
        ERP单据明细表.setStartIndex(startIndex);
        ERP单据明细表.setEndIndex(endIndex);
        JqueryResult<ERP单据明细表> jres = new JqueryResult<>();
        Result<List<ERP单据明细表>> res = ERP单据明细表Service.searchWithPage(ERP单据明细表);
        jres.setRows(res.getData());
        jres.setTotal(res.getCount());
        return jres;
    }
    @ResponseBody
    @RequestMapping("getListData")
    public Result<List<ERP单据明细表>> getListData(ERP单据明细表 ERP单据明细表, HttpServletRequest request, Model model){
        Result<List<ERP单据明细表>> res = ERP单据明细表Service.search(ERP单据明细表);
        return res;
    }
    @ResponseBody
    @RequestMapping("create")
    public Result<ERP单据明细表> create(ERP单据明细表 ERP单据明细表, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<ERP单据明细表> res = ERP单据明细表Service.create(ERP单据明细表, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("update")
    public Result<ERP单据明细表> update(ERP单据明细表 ERP单据明细表, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<ERP单据明细表> res = ERP单据明细表Service.updateSelective(ERP单据明细表, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("delete")
    public Result<ERP单据明细表> delete(String objectId, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<ERP单据明细表> res = ERP单据明细表Service.delete(objectId, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("deleteAll")
    public Result<ERP单据明细表> deleteAll(@RequestBody Param<List<String>> param, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<ERP单据明细表> res = ERP单据明细表Service.deleteAll(param.getField(), operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("查询调拨单")
    public Result<List<ERP单据明细表>> 查询调拨单(ERP单据明细表 ERP单据明细表, HttpServletRequest request, Model model){
        Result<List<ERP单据明细表>> res = ERP单据明细表Service.查询调拨单(ERP单据明细表);
        return res;
    }

    @ResponseBody
    @RequestMapping("查询入库单据")
    public Result<List<ERP单据明细表>> 查询入库单据(ERP单据明细表 ERP单据明细表, HttpServletRequest request, Model model){
        Result<List<ERP单据明细表>> res = ERP单据明细表Service.查询入库单据(ERP单据明细表);
        return res;
    }

    @ResponseBody
    @RequestMapping("查询出库单据")
    public Result<List<ERP单据明细表>> 查询出库单据(ERP单据明细表 ERP单据明细表, HttpServletRequest request, Model model){
        Result<List<ERP单据明细表>> res = ERP单据明细表Service.查询出库单据(ERP单据明细表);
        return res;
    }

    @ResponseBody
    @RequestMapping("展示调拨单据")
    public Result<List<ERP单据明细表>> 展示调拨单据(@RequestBody List<String> list, HttpServletRequest request, Model model){
        System.out.println(list.get(0));
        Result<List<ERP单据明细表>> res = ERP单据明细表Service.展示单据(list);
        return res;
    }

    @ResponseBody
    @RequestMapping("展示入库单据")
    public Result<List<ERP单据明细表>> 展示入库单据(@RequestBody List<String> list, HttpServletRequest request, Model model){
        System.out.println(list.get(0));
        Result<List<ERP单据明细表>> res = ERP单据明细表Service.展示单据(list);
        return res;
    }

    @ResponseBody
    @RequestMapping("展示出库单据")
    public Result<List<ERP单据明细表>> 展示出库单据(@RequestBody List<String> list, HttpServletRequest request, Model model){
        System.out.println(list.get(0));
        Result<List<ERP单据明细表>> res = ERP单据明细表Service.展示单据(list);
        return res;
    }

    @ResponseBody
    @RequestMapping("完成入库")
    public Result<List<ERP单据明细表>> 完成入库(@RequestBody List<String> list, HttpServletRequest request, Model model){
        System.out.println(list.size());
        Result<List<ERP单据明细表>> res = ERP单据明细表Service.完成入库(list);
        return res;
    }

}
