package com.dao;

import com.bean.GZD;
import com.bean.SendDX;
import com.bean.SyncPassword;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SendDXDao {

    public List<SendDX> getSendDX();

}
