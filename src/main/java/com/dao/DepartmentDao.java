package com.dao;
/**
 * Created by zzr on 2019/06/11
 * 用户表dao
 */
import com.bean.Depart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentDao {

	public List<Depart> selectDepartment();

	public List<Depart> selectGMLDepartment();

	public List<Depart> selectDepartByName(String name);

	public List<Depart> selectDepartByParentID(String ParentID);

}