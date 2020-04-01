package com.dao;
/**
 * Created by zzr on 2019/06/11
 * 用户表dao
 */
import com.bean.Company;
import com.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyDao {

	public int insert(Company company);

	public int delete(String objectId);

	public void deleteAll(@Param("idList") List<String> idList);

	public int update(Company company);

	public Company selectByPrimaryKey(String objectId);

	public List<Company> selectAll();

	public long selectBySelectiveCount(Company company );

	public List<Company> selectBySelective(Company company);
}