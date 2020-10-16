package com.dao;
/**
 * Created by zzr on 2019/06/11
 * 用户表dao
 */
import com.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

	public List<User> selectUser();

	public List<User> selectRKGMLUser();

	public List<User> selectUserByDepartName(String name);

	public List<User> selectUserByUserName(String name);


}