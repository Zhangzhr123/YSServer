package com.dao;
/**
 * Created by zzr on 2019/06/11
 * 用户表dao
 */
import com.bean.Company;
import com.bean.Filling;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FillingDao {

	public int insert(Filling filling);

	public int delete(String objectId);

	public void deleteAll(@Param("idList") List<String> idList);

	public int update(Filling filling);

	public Filling selectByPrimaryKey(String objectId);

	public List<Filling> selectAll();

	public long selectBySelectiveCount(Filling filling);

	public List<Filling> selectBySelective(Filling filling);

	public Filling selectByKey(Filling filling);

	public int setListData(Filling filling);
}