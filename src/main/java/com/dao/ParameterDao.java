package com.dao;
/**
 * Created by zzr on 2019/06/11
 * 用户表dao
 */
import com.bean.Parameter;
import com.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ParameterDao {

	public int insert(Parameter parameter);

	public int delete(String objectId);

	public void deleteAll(@Param("idList") List<String> idList);

	public int update(Parameter parameter);

	public Parameter selectByPrimaryKey(String objectId);

	public List<Parameter> selectAll();

	public long selectBySelectiveCount(Parameter parameter);

	public List<Parameter> selectBySelective(Parameter parameter);


}