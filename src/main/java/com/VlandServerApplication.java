package com;

import com.ui.AppForm;
import com.utils.LogUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Controller
@EnableAutoConfiguration//事务
@MapperScan("com.dao")//mybatis扫描路径，针对的是接口Mapper类

@SpringBootApplication
@EnableScheduling//与@Component连用，服务开启时执行TASK定时执行操作
public class VlandServerApplication {

	public static ConfigurableApplicationContext context;
	public static AppForm form;
	private static JButton jbtstart;

	public static void main(String[] args) {
		form = new AppForm();
		jbtstart = form.btstart;

		start();
		jbtstart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});

	}

	public static void start(){
		try{
			jbtstart.setEnabled(false);
			context = SpringApplication.run(VlandServerApplication.class);
			form.setState("正在运行");
		}catch (Exception e){
			form.logText(LogUtil.writeLog(e));
			e.printStackTrace();
			jbtstart.setEnabled(true);
		}
	}

}
