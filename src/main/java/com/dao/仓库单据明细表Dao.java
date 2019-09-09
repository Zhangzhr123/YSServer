package com.dao;
/**
 * Created by zzr on 2019/06/11
 * 仓库单据明细表Dao
 */
import com.bean.Result;
import com.bean.仓库单据明细表;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface 仓库单据明细表Dao {
    public int insert(仓库单据明细表 仓库单据明细表);

    public int insertSelective(仓库单据明细表 仓库单据明细表);

    public int delete(String objectId);

    public void deleteAll(@Param("idList") List<String> idList);

    public int update(仓库单据明细表 仓库单据明细表);

    public int updateSelective(仓库单据明细表 仓库单据明细表);

    public 仓库单据明细表 selectByPrimaryKey(String objectId);

    public List<仓库单据明细表> selectAll();

    public Result<List<仓库单据明细表>> search(仓库单据明细表 仓库单据明细表);

    public long selectBySelectiveCount(仓库单据明细表 仓库单据明细表);

    public List<仓库单据明细表> selectBySelectivePage(仓库单据明细表 仓库单据明细表);

    public List<仓库单据明细表> selectBySelective(仓库单据明细表 仓库单据明细表);

    public List<仓库单据明细表> selectByList(仓库单据明细表 仓库单据明细表);

    public List<仓库单据明细表> search物料编号(仓库单据明细表 物料编号);

    public List<仓库单据明细表> searchAll();
}
