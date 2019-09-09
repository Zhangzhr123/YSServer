package com.dao;

import com.bean.ERP单据明细表;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ERP单据明细表Dao {
    public int insert(ERP单据明细表 ERP单据明细表);

    public int insertSelective(ERP单据明细表 ERP单据明细表);

    public int delete(String objectId);

    public void deleteAll(@Param("idList") List<String> idList);

    public int update(ERP单据明细表 ERP单据明细表);

    public int updateSelective(ERP单据明细表 ERP单据明细表);

    public ERP单据明细表 selectByPrimaryKey(String objectId);

    public List<ERP单据明细表> selectAll();

    public long selectBySelectiveCount(ERP单据明细表 ERP单据明细表);

    public List<ERP单据明细表> selectBySelectivePage(ERP单据明细表 ERP单据明细表);

    public List<ERP单据明细表> selectBySelective(ERP单据明细表 ERP单据明细表);

    public List<ERP单据明细表> selectLikeString(String userLikeString);

    public List<ERP单据明细表> selectByList(ERP单据明细表 ERP单据明细表);

    public List<ERP单据明细表> 查询调拨单();

    public List<ERP单据明细表> 查询入库单据();

    public List<ERP单据明细表> 查询出库单据();

    public int 修改单据标识(ERP单据明细表 ERP单据明细表);

    public List<ERP单据明细表> 展示单据(ERP单据明细表 ERP单据明细表);
}
