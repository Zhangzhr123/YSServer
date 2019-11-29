package com.dao;

import com.bean.AGVTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AGVTaskDao {

    public List<AGVTask> selectAll();

    public List<AGVTask> selectByCode(AGVTask barCode);

    public int updateType(AGVTask barCode);

    public List<AGVTask> selectTask();

}
