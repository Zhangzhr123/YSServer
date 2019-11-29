package com.dao;
/**
 * Created by zzr on 2019/07/09
 * RecordsDao
 */
import com.bean.Bin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BinDao {

    public int updateNull(Bin bin);

    public List<Bin> selectAll();

}
