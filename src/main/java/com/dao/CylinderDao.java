package com.dao;
/**
 * Created by zzr on 2019/06/11
 * 用户表dao
 */
import com.bean.Company;
import com.bean.Cylinder;
import com.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CylinderDao {

	public int insert(Cylinder cylinder);

	public int delete(String objectId);

	public void deleteAll(@Param("idList") List<String> idList);

	public int update(Cylinder cylinder);

	public Cylinder selectByPrimaryKey(String objectId);

	public List<Cylinder> selectAll();

	public long selectBySelectiveCount(Cylinder cylinder);

	public List<Cylinder> selectBySelective(Cylinder cylinder);

    public Cylinder selectByKey(Cylinder cylinder);
}