package com.service;

import com.bean.Result;
import com.bean.User;
import com.bean.AGVTask;
import java.util.List;

public interface IAGVTaskService {


    public Result<List<AGVTask>> getAll();

    Result<List<AGVTask>> selectByCode(String barCode);

    Result<AGVTask> updateType(String barCode);

    Result<List<AGVTask>> selectTask();

}
