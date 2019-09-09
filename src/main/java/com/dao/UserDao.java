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
	
	public int insert(User user);
	
	public int insertSelective(User user);
	
	public int delete(String objectId);
	
	public void deleteAll(@Param("idList") List<String> idList);
	
	public int update(User user);
	
	public int updateSelective(User user);
	
	public User selectByPrimaryKey(String objectId);
	
	public List<User> selectAll();
	
	public long selectBySelectiveCount(User user);

	public List<User> selectBySelectivePage(User user);

	public List<User> selectBySelective(User user);

	public List<User> selectLikeString(String userLikeString);

	public List<User> selectByList(User user);

	public User login(@Param("用户编号")String usercode,@Param("用户密码")String password);
}