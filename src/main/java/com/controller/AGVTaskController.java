package com.controller;

import com.bean.*;
import com.service.IAGVTaskService;
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
@RequestMapping("AGVTask")
public class AGVTaskController extends BaseController {
    @Autowired
    private IAGVTaskService AGVTaskService;

    @RequestMapping()
    public String index(HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        model.addAttribute("operator", operator);
        return "AGVTask";
    }

    @ResponseBody
    @RequestMapping("/selectByCode")
    public Result<List<AGVTask>> selectByCode(String barCode,HttpServletResponse response, HttpServletRequest request, Model model){
        System.out.println(barCode);
        Result<List<AGVTask>> res = AGVTaskService.selectByCode(barCode);
        return res;
    }

    @ResponseBody
    @RequestMapping("/updateType")
    public Result<AGVTask> updateType(String barCode, HttpServletRequest request, HttpServletResponse response, Model model){
        System.out.println(barCode);
        Result<AGVTask> res = AGVTaskService.updateType(barCode);
        return res;
    }

    @ResponseBody
    @RequestMapping("/selectTask")
    public Result<List<AGVTask>> selectTask(AGVTask agvTask,HttpServletResponse response, HttpServletRequest request, Model model){
        Result<List<AGVTask>> res = AGVTaskService.selectTask();
        return res;
    }

}
