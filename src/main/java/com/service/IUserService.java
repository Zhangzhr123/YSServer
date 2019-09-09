package com.service;
/**
 * Created by zzr on 2019/06/11
 * 用户表service
 */
import com.bean.Result;
import com.bean.User;
import java.util.List;

public interface IUserService {

	public Result<User> create(User user, User operator);
	
	public Result<User> delete(String userId, User operator);

	public Result<User> deleteAll(List<String> idList, User operator);
	
	public Result<User> update(User user, User operator);

	public Result<User> updateSelective(User user, User operator);
	
	public Result<User> getById(String objectId);

	public Result<List<User>> getAll();

	public Result<List<User>> search(User user);

	public Result<Long> searchResultsCount(User user);

	public Result<List<User>> searchWithPage(User user);
	
	public Result<User> login(User user);

	public Result<User> login(String usercode,String password);

	public Result<List<User>> searchLikeString(String userLikeString);
}
