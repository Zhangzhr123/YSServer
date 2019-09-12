package com.controller;

import com.bean.*;
import com.service.I终端版本表Service;
import com.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("终端版本表")
public class 终端版本表Controller extends BaseController{

    @Autowired
    private I终端版本表Service 终端版本表Service;

    @RequestMapping()
    public String index(HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        model.addAttribute("operator", operator);
        return "终端版本表";
    }
    @ResponseBody
    @RequestMapping("getListDataPage")
    public JqueryResult<终端版本表> getListData(@RequestParam(value="page", required=false) int page,
                                           @RequestParam(value="rows", required=false) int rows, 终端版本表 终端版本表, HttpServletRequest request, Model model){
        if(rows == 0){
            rows = 15;
        }
        if(page == 0){
            page = 1;
        }
        long startIndex = (page-1)*rows + 1;
        long endIndex = page*rows + 1;
        终端版本表.setStartIndex(startIndex);
        终端版本表.setEndIndex(endIndex);
        JqueryResult<终端版本表> jres = new JqueryResult<>();
        Result<List<终端版本表>> res = 终端版本表Service.searchWithPage(终端版本表);
        jres.setRows(res.getData());
        jres.setTotal(res.getCount());
        return jres;
    }
    @ResponseBody
    @RequestMapping("getListData")
    public Result<List<终端版本表>> getListData(终端版本表 终端版本表, HttpServletRequest request, Model model){
        Result<List<终端版本表>> res = 终端版本表Service.search(终端版本表);
        return res;
    }
    @ResponseBody
    @RequestMapping("create")
    public Result<终端版本表> create(终端版本表 终端版本表, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<终端版本表> res = 终端版本表Service.create(终端版本表, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("update")
    public Result<终端版本表> update(终端版本表 终端版本表, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<终端版本表> res = 终端版本表Service.updateSelective(终端版本表, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("delete")
    public Result<终端版本表> delete(String objectId, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<终端版本表> res = 终端版本表Service.delete(objectId, operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("deleteAll")
    public Result<终端版本表> deleteAll(@RequestBody Param<List<String>> param, HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<终端版本表> res = 终端版本表Service.deleteAll(param.getField(), operator);
        return res;
    }

    @ResponseBody
    @RequestMapping("获取最新版本")
    public Result<终端版本表> 获取最新版本(HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        Result<终端版本表> res = 终端版本表Service.获取最新版本();
        return res;
    }

    @ResponseBody
    @RequestMapping("更新版本")
    public Result<终端版本表> 更新版本(@RequestParam(value = "file", required = true) MultipartFile file, 终端版本表 终端版本, HttpServletRequest request, Model model){
        Result<终端版本表> res = new Result<>();
        User operator = (User)request.getSession().getAttribute("operator");
        Result<String> result = UploadUtil.uploadFile(operator.get用户编号(), file);
        终端版本.set下载地址(result.getData());
        终端版本.set创建时间(new Date());
        res = 终端版本表Service.create(终端版本, operator);
        return res;
    }
}
