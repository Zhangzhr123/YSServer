package com.service.impl;
/**
 * Created by zzr on 2019/06/12
 * 用户表impl
 */
import com.bean.Result;
import com.bean.User;
import com.service.IUserService;
import com.utils.LogUtil;
import com.utils.MD5Util;
import com.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private com.dao.UserDao UserDao;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Result<User> create(User user, User operator){
		Result<User> res = new Result<>();
		try{
			UserDao.insert(user);
			res.setFlag(true);
			res.setData(user);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	@Override
	public Result<User> delete(String objectId, User operator){
		Result<User> res = new Result<>();
		try{
			UserDao.delete(objectId);
			res.setFlag(true);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	@Override
	public Result<User> deleteAll(List<String> idList, User operator){
		Result<User> res = new Result<>();
		try{
			UserDao.deleteAll(idList);
			res.setFlag(true);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	@Override
	public Result<User> update(User user, User operator){
		Result<User> res = new Result<>();
		try{
			UserDao.update(user);
			res.setFlag(true);
			res.setData(user);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	@Override
	public Result<User> updateSelective(User user, User operator){
		Result<User> res = new Result<>();
		try{
			UserDao.updateSelective(user);
			res.setFlag(true);
			res.setData(user);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	@Override
	public Result<User> getById(String objectId){
		Result<User> res = new Result<>();
		try{
			User data = UserDao.selectByPrimaryKey(objectId);
			res.setFlag(true);
			res.setData(data);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	@Override
	public Result<List<User>> getAll(){
		Result<List<User>> res = new Result<>();
		try{
			List<User> data = UserDao.selectAll();
			if (data == null) {
				res.setFlag(false);
				res.setMessage("用户信息表没有数据");
			}
			if (data != null && data.size() > 0) {
				res.setFlag(true);
				res.setData(data);
				res.setMessage("用户数据同步成功");
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage("用户数据同步失败，下载失败");
		}
		return res;
	}

	@Override
	public Result<List<User>> search(User user){
		Result<List<User>> res = new Result<>();
		try{
			List<User> data = UserDao.selectBySelective(user);
			res.setFlag(true);
			res.setData(data);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	@Override
	public Result<Long> searchResultsCount(User user){
		Result<Long> res = new Result<>();
		try{
			Long data = UserDao.selectBySelectiveCount(user);
			res.setFlag(true);
			res.setData(data);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	@Override
	public Result<List<User>> searchWithPage(User user){
		Result<List<User>> res = new Result<>();
		try{
			long count = UserDao.selectBySelectiveCount(user);
			List<User> data = UserDao.selectBySelectivePage(user);
			res.setFlag(true);
			res.setCount(count);
			res.setData(data);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	@Transactional
	@Override
	public Result<User> login(String usercode,String password) {
		Result<User> res = new Result<>();
		try{
			User user1 = UserDao.selectByPrimaryKey(usercode);
			User user2 = UserDao.login(usercode,MD5Util.encode(password));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dt1 = sdf.parse(sdf.format(new Date()));
				Date dt2 = sdf.parse("2020-03-01");
				if (dt1.getTime() < dt2.getTime()) {
					if(user1 != null && user2 != null){
						if(!user1.getUserName().equals(usercode) && !user2.getPassWord().equals(MD5Util.encode(password)) ){
							res.setFlag(false);
							res.setMessage("用户信息错误");
						}else{
							res.setFlag(true);
							res.setData(user1);
						}
					}else{
						res.setFlag(false);
						res.setMessage("用户不存在");
					}

				}else {
					res.setFlag(false);
					res.setMessage("-1");
				}

			}catch (Exception exception) {
				exception.printStackTrace();
			}

		}catch (Exception e){
			e.printStackTrace();
			LogUtil.writeLog(e);
			res.setFlag(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	@Transactional
	@Override
	public Result<User> login(User user) {
		System.out.println(user.getUserCode()+"---"+user.getPassWord());
		Result<User> res = new Result<>();
		try{
			if(StringUtil.isNullOrEmpty(user.getUserCode())){
				res.setFlag(false);
				res.setMessage("用户名不能为空！");
				return res;
			}
			if(StringUtil.isNullOrEmpty(user.getPassWord())){
				res.setFlag(false);
				res.setMessage("密码不能为空！");
				return res;
			}
			User uname = new User();
			uname.setUserCode(user.getUserCode());
			List<User> users = UserDao.selectBySelective(uname);
			if(users == null || users.isEmpty()){
				res.setFlag(false);
				res.setMessage("用户名不存在！");
				return res;
			}
			users = null;
			uname.setPassWord(MD5Util.encode(user.getPassWord()));
			users = UserDao.selectBySelective(uname);
			if(users == null || users.isEmpty()){
				res.setFlag(false);
				res.setMessage("密码错误！");
				return res;
			}
			if(users.size() > 1){
				res.setFlag(false);
				res.setMessage("用户信息异常，请联系管理员！");
			}
			user = users.get(0);
			res.setFlag(true);
			res.setData(user);
			return res;
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	//按关键字查找
	@Override
	public Result<List<User>> searchLikeString(String userLikeString){
		Result<List<User>> res = new Result<>();
		try{
			userLikeString="%"+userLikeString+"%";
			List<User> data = UserDao.selectLikeString(userLikeString);
			res.setFlag(true);
			res.setCount((long)data.size());
			res.setData(data);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}
}
