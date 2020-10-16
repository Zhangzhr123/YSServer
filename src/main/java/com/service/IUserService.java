package com.service;
/**
 * Created by zzr on 2019/06/11
 * 用户表service
 */
import com.bean.Result;
import com.bean.User;
import java.util.List;
import java.util.Map;

public interface IUserService {

	public Result<Map<String, String>> updateUserList();

	public Result<List<User>> updateBPMGMLUser();

	public Result<Map<String, String>> deleteUserList();

}
