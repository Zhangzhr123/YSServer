package com;

import com.bean.库存查询表;
import com.bean.物流任务表;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VlandServerApplicationTests {

	@Autowired
	private com.dao.库存查询表Dao 库存查询表Dao;

	@Test
	public void contextLoads() {

		库存查询表 wl = new 库存查询表();
		wl.set库位编号("A010603");
		库存查询表Dao.清空库位(wl);


	}

}
