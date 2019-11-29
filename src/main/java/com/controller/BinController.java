package com.controller;
/**
 * Created by zzr on 2019/06/10
 * BinController
 */
import com.bean.*;
import com.service.IBinService;
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
@RequestMapping("Bin")
public class BinController extends BaseController {
    @Autowired
    private IBinService BinService;

    @RequestMapping()
    public String index(HttpServletRequest request, Model model){
        User operator = (User)request.getSession().getAttribute("operator");
        model.addAttribute("operator", operator);
        return "Bin";
    }

    @ResponseBody
    @RequestMapping("/selectAll")
    public Result<List<Bin>> getList(HttpServletRequest request, HttpServletResponse response, Model model){
        Result<List<Bin>> res = BinService.selectAll();
        return res;
    }

    @ResponseBody
    @RequestMapping("/updateNull")
    public Result<Bin> updateType(String barCode, HttpServletRequest request,HttpServletResponse response, Model model){
        System.out.println(barCode);
        Result<Bin> res = BinService.updateNull(barCode);
        return res;
    }
    
}
