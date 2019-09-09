package com.dao;

import com.bean.条码物料表;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * Created by zzr on 2019/07/08
 * 条码物料表Dao
 */
@Mapper
public interface 条码物料表Dao {
    public int insert(条码物料表 条码物料表);

    public int insertSelective(条码物料表 条码物料表);

    public int delete(String objectId);

    public void deleteAll(@Param("idList") List<String> idList);

    public int update(条码物料表 条码物料表);

    public int updateSelective(条码物料表 条码物料表);

    public 条码物料表 selectByPrimaryKey(String objectId);

    public List<条码物料表> selectAll();

    public long selectBySelectiveCount(条码物料表 条码物料表);

    public List<条码物料表> selectBySelectivePage(条码物料表 条码物料表);

    public List<条码物料表> selectBySelective(条码物料表 条码物料表);

    public List<条码物料表> selectLikeString(String userLikeString);

    public List<条码物料表> selectByList(条码物料表 条码物料表);
}
