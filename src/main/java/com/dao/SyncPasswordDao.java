package com.dao;

import com.bean.SyncPassword;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SyncPasswordDao {

    public List<SyncPassword> getBPMPassword();

    public int updatePwd(SyncPassword records);
}
