package com.controller;

import com.utils.StringUtil;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    
	    binder.registerCustomEditor(Date.class, new PropertyEditorSupport(){  
	        @Override  
	        public void setAsText(String text){  
	            Date date = null;
	            String pattern = "yyyy-MM-dd";
	            if(!StringUtil.isNullOrEmpty(text)){
	            	if(text.length() > 10){
	            		pattern = "yyyy-MM-dd HH:mm:ss";
					}
					SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
	            	try{
	            		 date = dateFormat.parse(text);
	            	}catch(Exception e){
	            		e.printStackTrace();
	            	}
	            }
	            setValue(date);  
	        } 
	    });
	}
}
