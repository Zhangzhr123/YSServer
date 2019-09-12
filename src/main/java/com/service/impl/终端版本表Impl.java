package com.service.impl;

import com.bean.Result;
import com.bean.User;
import com.bean.终端版本表;
import com.dao.终端版本表Dao;
import com.service.I终端版本表Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 终端版本表Impl implements I终端版本表Service {

    @Autowired
    private 终端版本表Dao 终端版本表dao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Result<终端版本表> create(终端版本表 终端版本表, User operator){
        Result<终端版本表> res = new Result<>();
        try{
//            终端版本表.setObjectId(UUID.randomUUID().toString());
//            终端版本表.setCreateTime(new Date());
//            终端版本表.setCreateBy(operator.getObjectId());
//            终端版本表.setDeleteFlag(0);
            终端版本表dao.insert(终端版本表);
            res.setFlag(true);
            res.setData(终端版本表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }
    @Override
    public Result<终端版本表> delete(String objectId, User operator){
        Result<终端版本表> res = new Result<>();
        try{
            终端版本表dao.delete(objectId);
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
    public Result<终端版本表> deleteAll(List<String> idList, User operator){
        Result<终端版本表> res = new Result<>();
        try{
            if(idList.size() > 0){
                终端版本表dao.deleteAll(idList);
                res.setFlag(true);
            }else{
                res.setFlag(false);
                res.setMessage("未获取到要删除的数据");
            }

        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }
    @Override
    public Result<终端版本表> update(终端版本表 终端版本表, User operator){
        Result<终端版本表> res = new Result<>();
        try{
//            终端版本表.setUpdateTime(new Date());
//            终端版本表.setUpdateBy(operator.getObjectId());
            终端版本表dao.update(终端版本表);
            res.setFlag(true);
            res.setData(终端版本表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }
    @Override
    public Result<终端版本表> updateSelective(终端版本表 终端版本表, User operator){
        Result<终端版本表> res = new Result<>();
        try{
//            终端版本表.setUpdateTime(new Date());
//            终端版本表.setUpdateBy(operator.getObjectId());
            终端版本表dao.updateSelective(终端版本表);
            res.setFlag(true);
            res.setData(终端版本表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }
    @Override
    public Result<终端版本表> getById(String objectId){
        Result<终端版本表> res = new Result<>();
        try{
            终端版本表 data = 终端版本表dao.selectByPrimaryKey(objectId);
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
    public Result<List<终端版本表>> getAll(){
        Result<List<终端版本表>> res = new Result<>();
        try{
            List<终端版本表> data = 终端版本表dao.selectAll();
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
    public Result<List<终端版本表>> search(终端版本表 终端版本表){
        Result<List<终端版本表>> res = new Result<>();
        try{
            List<终端版本表> data = 终端版本表dao.selectBySelective(终端版本表);
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
    public Result<Long> searchResultsCount(终端版本表 终端版本表){
        Result<Long> res = new Result<>();
        try{
            Long data = 终端版本表dao.selectBySelectiveCount(终端版本表);
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
    public Result<List<终端版本表>> searchWithPage(终端版本表 终端版本表){
        Result<List<终端版本表>> res = new Result<>();
        try{
            long count = 终端版本表dao.selectBySelectiveCount(终端版本表);
            List<终端版本表> data = 终端版本表dao.selectBySelectivePage(终端版本表);
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
    public Result<终端版本表> 获取最新版本() {
        Result<终端版本表> res = new Result<>();
        try{
            终端版本表 data = 终端版本表dao.获取最新版本();
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
}
