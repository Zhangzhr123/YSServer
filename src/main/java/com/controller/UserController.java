package com.controller;
/**
 * Created by zzr on 2019/06/10
 * 用户表Controller
 */
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.bean.*;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController extends BaseController{

	@Autowired
	private IUserService userService;
	
	@RequestMapping()
    public String index(HttpServletRequest request, Model model){
		User operator = (User)request.getSession().getAttribute("operator");
        model.addAttribute("operator", operator);
        return "User";
    }
	@ResponseBody
    @RequestMapping("getListDataPage")
    public JqueryResult<User> getListData(@RequestParam(value="page", required=false) int page, 
            @RequestParam(value="rows", required=false) int rows, User user, HttpServletRequest request, Model model){
		if(rows == 0){
			rows = 15;
		}
		if(page == 0){
			page = 1;
		}
		long startIndex = (page-1)*rows + 1;
		long endIndex = page*rows + 1;
		user.setStartIndex(startIndex);
		user.setEndIndex(endIndex);
		JqueryResult<User> jres = new JqueryResult<>();
		Result<List<User>> res = userService.searchWithPage(user);
		jres.setRows(res.getData());
		jres.setTotal(res.getCount());
		return jres;
    }
    @ResponseBody
    @RequestMapping("getListData")
    public Result<List<User>> getListData(User user, HttpServletRequest request, Model model){
    	Result<List<User>> res = userService.search(user);
    	return res;
    }
    @ResponseBody
	@RequestMapping("create")
    public Result<User> create(User user, HttpServletRequest request, Model model){
    	User operator = (User)request.getSession().getAttribute("operator");
    	Result<User> res = userService.create(user, operator);
    	return res;
    } 
    
    @ResponseBody
	@RequestMapping("update")
    public Result<User> update(User user, HttpServletRequest request, Model model){
    	User operator = (User)request.getSession().getAttribute("operator");
    	Result<User> res = userService.updateSelective(user, operator);
    	return res;
    }
    
    @ResponseBody
	@RequestMapping("delete")
    public Result<User> delete(String objectId, HttpServletRequest request, Model model){
    	User operator = (User)request.getSession().getAttribute("operator");
    	Result<User> res = userService.delete(objectId, operator);
    	return res;
    }
    
    @ResponseBody
	@RequestMapping("deleteAll")
    public Result<User> deleteAll(@RequestBody Param<List<String>> param, HttpServletRequest request, Model model){
    	User operator = (User)request.getSession().getAttribute("operator");
    	Result<User> res = userService.deleteAll(param.getField(), operator);
    	return res;
    }
}
