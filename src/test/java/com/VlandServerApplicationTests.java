package com;

import com.bean.*;
import com.utils.MD5Util;
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
	private com.dao.ParameterDao ParameterDao;

	@Test
	public void contextLoads() {
		List<Parameter> list = ParameterDao.selectAll();
		System.out.println(list.get(0).getParameterMasterName());

	}

}
