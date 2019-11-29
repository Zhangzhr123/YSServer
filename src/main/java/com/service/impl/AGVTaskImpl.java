package com.service.impl;

import com.bean.AGVTask;
import com.bean.Result;
import com.bean.User;
import com.service.IAGVTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AGVTaskImpl implements IAGVTaskService {
    @Autowired
    private com.dao.AGVTaskDao AGVTaskDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Result<List<AGVTask>> getAll() {
        Result<List<AGVTask>> res = new Result<>();
        try {
            List<AGVTask> data = AGVTaskDao.selectAll();
            res.setFlag(true);
            res.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<List<AGVTask>> selectByCode(String barCode) {
        Result<List<AGVTask>> res = new Result<>();
        try {
            System.out.println(barCode);
            if (barCode != null) {
                AGVTask agvTask = new AGVTask();
                agvTask.setBarCode(barCode);
                List<AGVTask> data = AGVTaskDao.selectByCode(agvTask);
                if(data!=null&&data.size()!=0){
                    res.setFlag(true);
                    res.setData(data);
                }else{
                    res.setFlag(false);
                    res.setMessage("数据为空");
                }
            } else {
                res.setFlag(false);
                res.setMessage("条码为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<AGVTask> updateType(String barCode) {
        Result<AGVTask> res = new Result<>();
        try {
            System.out.println(barCode);
            if (barCode != null) {
                AGVTask agvTask = new AGVTask();
                agvTask.setBarCode(barCode);
                AGVTaskDao.updateType(agvTask);
                res.setFlag(true);
                res.setData(agvTask);
            } else {
                res.setFlag(false);
                res.setMessage("条码为空");
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<List<AGVTask>> selectTask() {
        Result<List<AGVTask>> res = new Result<>();
        try {
            List<AGVTask> data = AGVTaskDao.selectTask();
            if(data!=null&&data.size()!=0){
                res.setFlag(true);
                res.setData(data);
            }else{
                res.setFlag(false);
                res.setMessage("数据为空,没有未完成的任务");
            }


        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }


}
