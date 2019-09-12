package com.dao;

import com.bean.终端版本表;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface 终端版本表Dao{

    public int insert(终端版本表 终端版本表);

    public int insertSelective(终端版本表 终端版本表);

    public int delete(String objectId);

    public void deleteAll(@Param("idList") List<String> idList);

    public int update(终端版本表 终端版本表);

    public int updateSelective(终端版本表 终端版本表);

    public 终端版本表 selectByPrimaryKey(String objectId);

    public List<终端版本表> selectAll();

    public long selectBySelectiveCount(终端版本表 终端版本表);

    public List<终端版本表> selectBySelectivePage(终端版本表 终端版本表);

    public List<终端版本表> selectBySelective(终端版本表 终端版本表);

    public 终端版本表 获取最新版本();

}
