package com.dao;
/**
 * Created by zzr on 2019/06/11
 * 盘点计划表Dao
 */
import com.bean.盘点计划表;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface 盘点计划表Dao {
    public int insert(盘点计划表 盘点计划表);

    public int insertSelective(盘点计划表 盘点计划表);

    public int delete(String objectId);

    public void deleteAll(@Param("idList") List<String> idList);

    public int update(盘点计划表 盘点计划表);

    public int updateSelective(盘点计划表 盘点计划表);

    public 盘点计划表 selectByPrimaryKey(String objectId);

    public List<盘点计划表> selectAll();

    public long selectBySelectiveCount(盘点计划表 盘点计划表);

    public List<盘点计划表> selectBySelectivePage(盘点计划表 盘点计划表);

    public List<盘点计划表> selectBySelective(盘点计划表 盘点计划表);

    public List<盘点计划表> selectByList(盘点计划表 盘点计划表);

    public List<盘点计划表> searchAll();

    public List<盘点计划表> search计划编号(盘点计划表 盘点计划表);

    public int 修改完成程度(盘点计划表 盘点计划表);

    public int 已完成();
}
