package com.dao;
/**
 * Created by zzr on 2019/06/11
 * 物流任务表Dao
 */
import com.bean.物流任务表;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface 物流任务表Dao {
    public int insert(物流任务表 物流任务表);

    public int insertSelective(物流任务表 物流任务表);

    public int delete(String objectId);

    public void deleteAll(@Param("idList") List<String> idList);

    public int update(物流任务表 物流任务表);

    public int updateSelective(物流任务表 物流任务表);

    public 物流任务表 selectByPrimaryKey(String objectId);

    public List<物流任务表> selectAll();

    public long selectBySelectiveCount(物流任务表 物流任务表);

    public List<物流任务表> selectBySelectivePage(物流任务表 物流任务表);

    public List<物流任务表> selectBySelective(物流任务表 物流任务表);

    public List<物流任务表> selectLikeString(String userLikeString);

    public List<物流任务表> selectByList(物流任务表 物流任务表);

    public List<物流任务表> search任务(物流任务表 物流任务表);

    public int 强制执行(物流任务表 物流任务表);

    public int 强制取消(物流任务表 物流任务表);

    public List<物流任务表> 异常AGV(物流任务表 物流任务表);

    public List<物流任务表> search单据编号(物流任务表 物流任务表);

    public List<物流任务表> search完成();

    public int 添加到历史表(物流任务表 物流任务表);

    public int 删除任务(物流任务表 物流任务表);

}
