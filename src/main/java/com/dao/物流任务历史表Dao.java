package com.dao;
/**
 * Created by zzr on 2019/07/09
 * 物流任务历史表Dao
 */
import com.bean.物流任务历史表;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface 物流任务历史表Dao {

    public int insert(物流任务历史表 物流任务历史表);

    public int insertSelective(物流任务历史表 物流任务历史表);

    public int delete(String objectId);

    public void deleteAll(@Param("idList") List<String> idList);

    public int update(物流任务历史表 物流任务历史表);

    public int updateSelective(物流任务历史表 物流任务历史表);

    public 物流任务历史表 selectByPrimaryKey(String objectId);

    public List<物流任务历史表> selectAll();

    public long selectBySelectiveCount(物流任务历史表 物流任务历史表);

    public List<物流任务历史表> selectBySelectivePage(物流任务历史表 物流任务历史表);

    public List<物流任务历史表> selectBySelective(物流任务历史表 物流任务历史表);

    public List<物流任务历史表> selectLikeString(String userLikeString);

    public List<物流任务历史表> selectByList(物流任务历史表 物流任务历史表);

    public List<物流任务历史表> search任务编号(物流任务历史表 物流任务历史表);

    public List<物流任务历史表> 抽检返架();

}
