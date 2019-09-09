package com.dao;
/**
 * Created by zzr on 2019/06/11
 * 仓库单据表Dao
 */
import com.bean.仓库单据表;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface 仓库单据表Dao {
    public int insert(仓库单据表 仓库单据表);

    public int insertSelective(仓库单据表 仓库单据表);

    public int delete(String objectId);

    public void deleteAll(@Param("idList") List<String> idList);

    public int update(仓库单据表 仓库单据表);

    public int updateSelective(仓库单据表 仓库单据表);

    public 仓库单据表 selectByPrimaryKey(String objectId);

    public List<仓库单据表> selectAll();

    public long selectBySelectiveCount(仓库单据表 仓库单据表);

    public List<仓库单据表> selectBySelectivePage(仓库单据表 仓库单据表);

    public List<仓库单据表> selectBySelective(仓库单据表 仓库单据表);

    public List<仓库单据表> selectByList(仓库单据表 仓库单据表);

    public List<仓库单据表> selectLikeString(String userLikeString);
}
