package com.service.impl;
/**
 * Created by zzr on 2019/06/12
 * 盘点计划表impl
 */
import com.bean.Result;
import com.bean.User;
import com.bean.盘点计划表;
import com.service.I盘点计划表Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 盘点计划表Impl implements I盘点计划表Service {
    @Autowired
    private com.dao.盘点计划表Dao 盘点计划表Dao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Result<盘点计划表> create(盘点计划表 盘点计划表, User operator) {
        Result<盘点计划表> res = new Result<>();
        try{
            盘点计划表Dao.insert(盘点计划表);
            res.setFlag(true);
            res.setData(盘点计划表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<盘点计划表> delete(String userId, User operator) {
        Result<盘点计划表> res = new Result<>();
        try{
            盘点计划表Dao.delete(userId);
            res.setFlag(true);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<盘点计划表> deleteAll(List<String> idList, User operator) {
        Result<盘点计划表> res = new Result<>();
        try{
            盘点计划表Dao.deleteAll(idList);
            res.setFlag(true);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<盘点计划表> update(盘点计划表 盘点计划表, User operator) {
        Result<盘点计划表> res = new Result<>();
        try{
            盘点计划表Dao.update(盘点计划表);
            res.setFlag(true);
            res.setData(盘点计划表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<盘点计划表> updateSelective(盘点计划表 盘点计划表, User operator) {
        Result<盘点计划表> res = new Result<>();
        try{
            盘点计划表Dao.updateSelective(盘点计划表);
            res.setFlag(true);
            res.setData(盘点计划表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<盘点计划表> getById(String objectId) {
        Result<盘点计划表> res = new Result<>();
        try{
            盘点计划表 data = 盘点计划表Dao.selectByPrimaryKey(objectId);
            res.setFlag(true);
            res.setData(data);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<List<盘点计划表>> getAll() {
        Result<List<盘点计划表>> res = new Result<>();
        try{
            List<盘点计划表> data = 盘点计划表Dao.selectAll();
            res.setFlag(true);
            res.setData(data);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<List<盘点计划表>> search(盘点计划表 盘点计划表) {
        Result<List<盘点计划表>> res = new Result<>();
        try{
            List<盘点计划表> data = 盘点计划表Dao.selectBySelective(盘点计划表);
            res.setFlag(true);
            res.setData(data);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<Long> searchResultsCount(盘点计划表 盘点计划表) {
        Result<Long> res = new Result<>();
        try{
            Long data = 盘点计划表Dao.selectBySelectiveCount(盘点计划表);
            res.setFlag(true);
            res.setData(data);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<List<盘点计划表>> searchWithPage(盘点计划表 盘点计划表) {
        Result<List<盘点计划表>> res = new Result<>();
        try{
            long count = 盘点计划表Dao.selectBySelectiveCount(盘点计划表);
            List<盘点计划表> data = 盘点计划表Dao.selectBySelectivePage(盘点计划表);
            res.setFlag(true);
            res.setCount(count);
            res.setData(data);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<List<盘点计划表>> searchAll(盘点计划表 盘点计划表) {
        Result<List<盘点计划表>> res = new Result<>();
        try{
            List<盘点计划表> data = 盘点计划表Dao.searchAll();
            res.setFlag(true);
            res.setData(data);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<List<盘点计划表>> search计划编号(盘点计划表 盘点计划表) {
        Result<List<盘点计划表>> res = new Result<>();
        try {
            String 计划编号 = 盘点计划表.get计划编号();
            计划编号="%"+计划编号+"%";
            盘点计划表 pd = new 盘点计划表();
            pd.set计划编号(计划编号);
            List<盘点计划表> data = 盘点计划表Dao.search计划编号(pd);
            if(!data.get(0).get计划编号().equals(计划编号)){
                res.setFlag(false);
                res.setMessage("计划编号错误");
            }else{
                res.setFlag(true);
                res.setData(data);
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
    public Result<盘点计划表> 修改完成程度(盘点计划表 盘点计划表) {
        Result<盘点计划表> res = new Result<>();
        try {
            盘点计划表Dao.修改完成程度(盘点计划表);
            List<盘点计划表> data = 盘点计划表Dao.selectByList(盘点计划表);
            if(data.get(0).get完成程度().equals("执行中")){
                res.setFlag(true);
                res.setData(盘点计划表);
            }else{
                res.setFlag(false);
                res.setMessage("未修改完成程度");
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
    public Result<盘点计划表> 已完成(盘点计划表 盘点计划表) {
        Result<盘点计划表> res = new Result<>();
        try {
            if(盘点计划表.get完成程度().equals("已完成")){
                盘点计划表Dao.已完成();
                res.setFlag(true);
                res.setData(盘点计划表);
            }else{
                res.setFlag(false);
                res.setMessage("未发送已完成信息");
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
