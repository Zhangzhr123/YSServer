package com.dao;
/**
 * Created by zzr on 2019/06/11
 * 盘点差异表Dao
 */
import com.bean.盘点差异表;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface 盘点差异表Dao {
    public int insert(盘点差异表 盘点差异表);

    public int insertSelective(盘点差异表 盘点差异表);

    public int delete(String objectId);

    public void deleteAll(@Param("idList") List<String> idList);

    public int update(盘点差异表 盘点差异表);

    public int updateSelective(盘点差异表 盘点差异表);

    public 盘点差异表 selectByPrimaryKey(String objectId);

    public List<盘点差异表> selectAll();

    public long selectBySelectiveCount(盘点差异表 盘点差异表);

    public List<盘点差异表> selectBySelectivePage(盘点差异表 盘点差异表);

    public List<盘点差异表> selectBySelective(盘点差异表 盘点差异表);

    public List<盘点差异表> selectLikeString(String userLikeString);

    public List<盘点差异表> selectByList(盘点差异表 盘点差异表);
}
