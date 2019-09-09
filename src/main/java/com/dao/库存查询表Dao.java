package com.dao;
/**
 * Created by zzr on 2019/06/11
 * 库存查询表Dao
 */
import com.bean.库存查询表;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface 库存查询表Dao {

    public int insert(库存查询表 库存查询表);

    public int insertSelective(库存查询表 库存查询表);

    public int delete(String objectId);

    public void deleteAll(@Param("idList") List<String> idList);

    public int update(库存查询表 库存查询表);

    public int updateSelective(库存查询表 库存查询表);

    public 库存查询表 selectByPrimaryKey(String objectId);

    public List<库存查询表> selectAll();

    public long selectBySelectiveCount(库存查询表 库存查询表);

    public List<库存查询表> selectBySelectivePage(库存查询表 库存查询表);

    public List<库存查询表> selectBySelective(库存查询表 库存查询表);

    public List<库存查询表> selectByList(库存查询表 库存查询表);

    public List<库存查询表> searchAll();

    public List<库存查询表> search条码编号(库存查询表 库存查询表);

    public int 入库任务更改库位信息(库存查询表 库存查询表);

    public int 改为占用状态(库存查询表 库存查询表);

    public int 清空库位(库存查询表 库存查询表);

    public List<库存查询表> search库位(库存查询表 库存查询表);

    public List<库存查询表> search偶数库位(库存查询表 库存查询表);

    public List<库存查询表> search奇数库位(库存查询表 库存查询表);

    public List<库存查询表> search偶数空库位();

    public List<库存查询表> search奇数空库位();

}
