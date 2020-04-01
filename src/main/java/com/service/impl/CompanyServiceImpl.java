package com.service.impl;
/**
 * Created by zzr on 2019/06/12
 * 用户表impl
 */
import com.bean.Result;
import com.bean.Company;
import com.bean.User;
import com.service.ICompanyService;
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
public class CompanyServiceImpl implements ICompanyService {
	
	@Autowired
	private com.dao.CompanyDao CompanyDao;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Result<Company> create(Company company, User operator){
		Result<Company> res = new Result<>();
		try{
			CompanyDao.insert(company);
			res.setFlag(true);
			res.setData(company);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	@Override
	public Result<Company> delete(String objectId, User operator){
		Result<Company> res = new Result<>();
		try{
			CompanyDao.delete(objectId);
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
	public Result<Company> deleteAll(List<String> idList, User operator){
		Result<Company> res = new Result<>();
		try{
			CompanyDao.deleteAll(idList);
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
	public Result<Company> update(Company company, User operator){
		Result<Company> res = new Result<>();
		try{
			CompanyDao.update(company);
			res.setFlag(true);
			res.setData(company);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	@Override
	public Result<Company> getById(String objectId){
		Result<Company> res = new Result<>();
		try{
			Company data = CompanyDao.selectByPrimaryKey(objectId);
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
	public Result<List<Company>> getAll(){
		Result<List<Company>> res = new Result<>();
		try{
			List<Company> data = CompanyDao.selectAll();
			if (data == null) {
				res.setFlag(false);
				res.setMessage("制造信息表没有数据");
			}
			if (data != null && data.size() > 0) {
				res.setFlag(true);
				res.setData(data);
				res.setMessage("制造数据同步成功");
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			res.setFlag(false);
			res.setMessage("制造数据同步失败，下载失败");
		}
		return res;
	}

	@Override
	public Result<List<Company>> search(Company company){
		Result<List<Company>> res = new Result<>();
		try{
			List<Company> data = CompanyDao.selectBySelective(company);
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
	public Result<Long> searchResultsCount(Company company){
		Result<Long> res = new Result<>();
		try{
			Long data = CompanyDao.selectBySelectiveCount(company);
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
