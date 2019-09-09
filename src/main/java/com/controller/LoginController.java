package com.controller;

import com.bean.Result;
import com.bean.User;
import com.google.gson.Gson;
import com.service.IUserService;
import com.utils.DesUtil;
import com.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	private IUserService userService;

	@RequestMapping
	public String index(Model model){
		Result<Object> res = new Result<>();
		User user = new User();
		model.addAttribute("user", user);
		res.setMessage("请登录");
		res.setFlag(false);
		return "login";
	}
	@ResponseBody
	@RequestMapping("validate")
	public Result<User> validate(String usercode, String password, HttpServletRequest request, HttpServletResponse response){
		Result<User> result = userService.login(usercode,password);
		if(result.isFlag()){
			User us = result.getData();
			request.getSession().setAttribute("operator", us);
			//将登录信息保存至cookies
			User user = new User();
			user.set用户编号(result.getData().get用户编号());
			User u = new User();
			u.set用户编号(usercode);
			Cookie usercookie = getCookie(u);
			response.addCookie(usercookie);
		}
		return result;
	}

	@RequestMapping("validate2")
	public String validate2(User user, HttpServletRequest request, HttpServletResponse response, Model model){
		Result<User> result = userService.login(user);
		if(result.isFlag()) {
			request.getSession().setAttribute("operator", result.getData());
			//将登录信息保存至cookies
			Cookie usercookie = getCookie(user);
			response.addCookie(usercookie);
			String urlobj = request.getSession().getAttribute("url") + "";
			String url = "";
			if(!StringUtil.isNullOrEmpty(urlobj)){
				url = urlobj;
			}
			if(url.contains("login")){
				url = "";
			}
			url = "/project/mointor";
			model.addAttribute("operator", result.getData());
			return "redirect:" + url;
		}
		model.addAttribute("user", user);
		model.addAttribute("message", result.getMessage());
		return "login";
	}

    //获取Cookie信息
	private Cookie getCookie(User user) {

		String userjson = new Gson().toJson(user);
		userjson = DesUtil.encrypt(userjson, DesUtil.PWD);
		Cookie usercookie = new Cookie("operator", userjson);
		usercookie.setMaxAge(60*60*24);
		usercookie.setPath("/");
		return usercookie;
	}

	//语言设置
	@RequestMapping("/changeSessionLanauage")
	public String changeSessionLanauage(HttpServletRequest request, String lang, String url){
		System.out.println(lang);
		if("zh".equals(lang)){
			//代码中即可通过以下方法进行语言设置
			request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,new Locale("zh", "CN"));
		}else if("en".equals(lang)){
			//代码中即可通过以下方法进行语言设置
			request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,new Locale("en", "US"));
		}
		//重定向地址
		return "redirect:" + url;
	}

	//注销功能
	@RequestMapping("logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		request.getSession().removeAttribute("operator");
		Cookie usercookie = new Cookie("operator", "");
		usercookie.setMaxAge(0);
		usercookie.setPath("/");
		response.addCookie(usercookie);
		return "redirect:/login";
	}
}
