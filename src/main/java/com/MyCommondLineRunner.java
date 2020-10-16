package com;

import com.utils.Common;
import com.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=1)
public class MyCommondLineRunner implements CommandLineRunner {
    //服务器域名
    @Value("${server}")
    private String SERVER;
    @Value("${server.port}")
    private String PORT;
    @Value("${server.project}")
    private String PROJECT;

    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("===MyStartupRunnerTest1执行，它的@Order注解value值为1===");
        Common.BASE_URL = SERVER + (StringUtil.isNullOrEmpty(PORT) ? "":":"+PORT) + (StringUtil.isNullOrEmpty(PROJECT) ? "":"/"+PROJECT) + "/";
    }
}
