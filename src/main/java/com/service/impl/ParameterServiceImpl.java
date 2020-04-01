package com.service.impl;
/**
 * Created by zzr on 2019/06/12
 * 用户表impl
 */
import com.bean.Result;
import com.bean.Parameter;
import com.bean.User;
import com.service.IParameterService;
import com.utils.LogUtil;
import com.utils.MD5Util;
import com.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ParameterServiceImpl implements IParameterService {
	
	@Autowired
	private com.dao.ParameterDao ParameterDao;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Result<Parameter> create(Parameter parameter, User operator){
		Result<Parameter> res = new Result<>();
		try{
			ParameterDao.insert(parameter);
			res.setFlag(true);
			res.setData(parameter);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	@Override
	public Result<Parameter> delete(String objectId, User operator){
		Result<Parameter> res = new Result<>();
		try{
			ParameterDao.delete(objectId);
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
	public Result<Parameter> deleteAll(List<String> idList, User operator){
		Result<Parameter> res = new Result<>();
		try{
			ParameterDao.deleteAll(idList);
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
	public Result<Parameter> update(Parameter parameter, User operator){
		Result<Parameter> res = new Result<>();
		try{
			ParameterDao.update(parameter);
			res.setFlag(true);
			res.setData(parameter);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}


	@Override
	public Result<Parameter> getById(String objectId){
		Result<Parameter> res = new Result<>();
		try{
			Parameter data = ParameterDao.selectByPrimaryKey(objectId);
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
	public Result<List<Parameter>> getAll(){
		Result<List<Parameter>> res = new Result<>();
		try{
			List<Parameter> data = ParameterDao.selectAll();
			if (data == null) {
				res.setFlag(false);
				res.setMessage("基础信息表没有数据");
			}
			if (data != null && data.size() > 0) {
				res.setFlag(true);
				res.setData(data);
				res.setMessage("基础数据同步成功");
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage("基础数据同步失败，下载失败");
		}
		return res;
	}

	@Override
	public Result<List<Parameter>> search(Parameter parameter){
		Result<List<Parameter>> res = new Result<>();
		try{
			List<Parameter> data = ParameterDao.selectBySelective(parameter);
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
}
