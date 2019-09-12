package com;

import com.bean.库存查询表;
import com.bean.物流任务表;
import com.bean.终端版本表;
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
	private com.dao.终端版本表Dao 终端版本表dao;

	@Test
	public void contextLoads() {
		List<终端版本表> data = 终端版本表dao.selectAll();
		System.out.println(data.get(0).get版本id());
	}

}
