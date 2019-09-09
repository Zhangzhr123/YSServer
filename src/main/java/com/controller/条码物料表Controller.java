package com.controller;
/**
 * Created by zzr on 2019/07/08
 * 条码物料表Controller
 */
import com.bean.*;
import com.service.I条码物料表Service;
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
@RequestMapping("条码物料表")
public class 条码物料表Controller extends BaseController {

        @Autowired
        private I条码物料表Service 条码物料表Service;

        @RequestMapping()
        public String index(HttpServletRequest request, Model model){
            User operator = (User)request.getSession().getAttribute("operator");
            model.addAttribute("operator", operator);
            return "条码物料表";
        }
        @ResponseBody
        @RequestMapping("getListDataPage")
        public JqueryResult<条码物料表> getListData(@RequestParam(value="page", required=false) int page,
                                               @RequestParam(value="rows", required=false) int rows, 条码物料表 条码物料表, HttpServletRequest request, Model model){
            if(rows == 0){
                rows = 15;
            }
            if(page == 0){
                page = 1;
            }
            long startIndex = (page-1)*rows + 1;
            long endIndex = page*rows + 1;
            条码物料表.setStartIndex(startIndex);
            条码物料表.setEndIndex(endIndex);
            JqueryResult<条码物料表> jres = new JqueryResult<>();
            Result<List<条码物料表>> res = 条码物料表Service.searchWithPage(条码物料表);
            jres.setRows(res.getData());
            jres.setTotal(res.getCount());
            return jres;
        }
        @ResponseBody
        @RequestMapping("getListData")
        public Result<List<条码物料表>> getListData(条码物料表 条码物料表, HttpServletRequest request, Model model){
            Result<List<条码物料表>> res = 条码物料表Service.search(条码物料表);
            return res;
        }
        @ResponseBody
        @RequestMapping("create")
        public Result<条码物料表> create(条码物料表 条码物料表, HttpServletRequest request, Model model){
            User operator = (User)request.getSession().getAttribute("operator");
            Result<条码物料表> res = 条码物料表Service.create(条码物料表, operator);
            return res;
        }

        @ResponseBody
        @RequestMapping("update")
        public Result<条码物料表> update(条码物料表 条码物料表, HttpServletRequest request, Model model){
            User operator = (User)request.getSession().getAttribute("operator");
            Result<条码物料表> res = 条码物料表Service.updateSelective(条码物料表, operator);
            return res;
        }

        @ResponseBody
        @RequestMapping("delete")
        public Result<条码物料表> delete(String objectId, HttpServletRequest request, Model model){
            User operator = (User)request.getSession().getAttribute("operator");
            Result<条码物料表> res = 条码物料表Service.delete(objectId, operator);
            return res;
        }

        @ResponseBody
        @RequestMapping("deleteAll")
        public Result<条码物料表> deleteAll(@RequestBody Param<List<String>> param, HttpServletRequest request, Model model){
            User operator = (User)request.getSession().getAttribute("operator");
            Result<条码物料表> res = 条码物料表Service.deleteAll(param.getField(), operator);
            return res;
        }
}
