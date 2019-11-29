package com.dao;
/**
 * Created by zzr on 2019/07/09
 * RecordsDao
 */
import com.bean.Records;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordsDao {

    public int insert(Records records);

    public int insertSelective(Records records);

    public int delete(String objectId);

    public void deleteAll(@Param("idList") List<String> idList);

    public int update(Records records);

    public int updateSelective(Records records);

    public Records selectByPrimaryKey(String objectId);

    public List<Records> selectAll();

    public long selectBySelectiveCount(Records records);

    public List<Records> selectBySelectivePage(Records records);

    public List<Records> selectBySelective(Records records);

    public List<Records> selectLikeString(String userLikeString);

    public List<Records> selectByList(Records records);

    public List<Records> search任务编号(Records records);

    public int updateType(String barCode);

    public List<Records> getList(String barCode);

}
