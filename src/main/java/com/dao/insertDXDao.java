package com.dao;

import com.bean.GZD;
import com.bean.SendDX;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface insertDXDao {

    public int insertDX(GZD records);

    public List<GZD> getByMbl(GZD records);
}
