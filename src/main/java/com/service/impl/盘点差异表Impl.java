package com.service.impl;
/**
 * Created by zzr on 2019/06/12
 * 盘点差异表impl
 */
import com.bean.Result;
import com.bean.User;
import com.bean.盘点差异表;
import com.service.I盘点差异表Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 盘点差异表Impl implements I盘点差异表Service {
    @Autowired
    private com.dao.盘点差异表Dao 盘点差异表Dao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Result<盘点差异表> create(盘点差异表 盘点差异表, User operator) {
        Result<盘点差异表> res = new Result<>();
        try{
            盘点差异表Dao.insert(盘点差异表);
            res.setFlag(true);
            res.setData(盘点差异表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<盘点差异表> delete(String userId, User operator) {
        Result<盘点差异表> res = new Result<>();
        try{
            盘点差异表Dao.delete(userId);
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
    public Result<盘点差异表> deleteAll(List<String> idList, User operator) {
        Result<盘点差异表> res = new Result<>();
        try{
            盘点差异表Dao.deleteAll(idList);
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
    public Result<盘点差异表> update(盘点差异表 盘点差异表, User operator) {
        Result<盘点差异表> res = new Result<>();
        try{
            盘点差异表Dao.update(盘点差异表);
            res.setFlag(true);
            res.setData(盘点差异表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<盘点差异表> updateSelective(盘点差异表 盘点差异表, User operator) {
        Result<盘点差异表> res = new Result<>();
        try{
            盘点差异表Dao.updateSelective(盘点差异表);
            res.setFlag(true);
            res.setData(盘点差异表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<盘点差异表> getById(String objectId) {
        Result<盘点差异表> res = new Result<>();
        try{
            盘点差异表 data = 盘点差异表Dao.selectByPrimaryKey(objectId);
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
    public Result<List<盘点差异表>> getAll() {
        Result<List<盘点差异表>> res = new Result<>();
        try{
            List<盘点差异表> data = 盘点差异表Dao.selectAll();
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
    public Result<List<盘点差异表>> search(盘点差异表 盘点差异表) {
        Result<List<盘点差异表>> res = new Result<>();
        try{
            List<盘点差异表> data = 盘点差异表Dao.selectBySelective(盘点差异表);
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
    public Result<Long> searchResultsCount(盘点差异表 盘点差异表) {
        Result<Long> res = new Result<>();
        try{
            Long data = 盘点差异表Dao.selectBySelectiveCount(盘点差异表);
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
    public Result<List<盘点差异表>> searchWithPage(盘点差异表 盘点差异表) {
        Result<List<盘点差异表>> res = new Result<>();
        try{
            long count = 盘点差异表Dao.selectBySelectiveCount(盘点差异表);
            List<盘点差异表> data = 盘点差异表Dao.selectBySelectivePage(盘点差异表);
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
    public Result<List<盘点差异表>> searchLikeString(String userLikeString) {
        Result<List<盘点差异表>> res = new Result<>();
        try {
            userLikeString = "%" + userLikeString + "%";
            List<盘点差异表> data = 盘点差异表Dao.selectLikeString(userLikeString);
            res.setFlag(true);
            res.setCount((long) data.size());
            res.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }
}
