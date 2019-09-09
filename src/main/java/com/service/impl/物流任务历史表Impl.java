package com.service.impl;
/**
 * Created by zzr on 2019/07/09
 * 物流任务历史表impl
 */
import com.bean.*;
import com.service.I物流任务历史表Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class 物流任务历史表Impl implements I物流任务历史表Service {

    @Autowired
    private com.dao.物流任务历史表Dao 物流任务历史表Dao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Transactional
    @Override
    public Result<物流任务历史表> create(物流任务历史表 物流任务历史表, User operator) {
        Result<物流任务历史表> res = new Result<>();
        try{
            物流任务历史表Dao.insert(物流任务历史表);
            res.setFlag(true);
            res.setData(物流任务历史表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<物流任务历史表> delete(String userId, User operator) {
        Result<物流任务历史表> res = new Result<>();
        try{
            物流任务历史表Dao.delete(userId);
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
    public Result<物流任务历史表> deleteAll(List<String> idList, User operator) {
        Result<物流任务历史表> res = new Result<>();
        try{
            物流任务历史表Dao.deleteAll(idList);
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
    public Result<物流任务历史表> update(物流任务历史表 物流任务历史表, User operator) {
        Result<物流任务历史表> res = new Result<>();
        try{
            物流任务历史表Dao.update(物流任务历史表);
            res.setFlag(true);
            res.setData(物流任务历史表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<物流任务历史表> updateSelective(物流任务历史表 物流任务历史表, User operator) {
        Result<物流任务历史表> res = new Result<>();
        try{
            物流任务历史表Dao.updateSelective(物流任务历史表);
            res.setFlag(true);
            res.setData(物流任务历史表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<物流任务历史表> getById(String objectId) {
        Result<物流任务历史表> res = new Result<>();
        try{
            物流任务历史表 data = 物流任务历史表Dao.selectByPrimaryKey(objectId);
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
    public Result<List<物流任务历史表>> getAll() {
        Result<List<物流任务历史表>> res = new Result<>();
        try{
            List<物流任务历史表> data = 物流任务历史表Dao.selectAll();
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
    public Result<List<物流任务历史表>> search(物流任务历史表 物流任务历史表) {
        Result<List<物流任务历史表>> res = new Result<>();
        try{
            List<物流任务历史表> data = 物流任务历史表Dao.selectBySelective(物流任务历史表);
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
    public Result<Long> searchResultsCount(物流任务历史表 物流任务历史表) {
        Result<Long> res = new Result<>();
        try{
            Long data = 物流任务历史表Dao.selectBySelectiveCount(物流任务历史表);
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
    public Result<List<物流任务历史表>> searchWithPage(物流任务历史表 物流任务历史表) {
        Result<List<物流任务历史表>> res = new Result<>();
        try{
            long count = 物流任务历史表Dao.selectBySelectiveCount(物流任务历史表);
            List<物流任务历史表> data = 物流任务历史表Dao.selectBySelectivePage(物流任务历史表);
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
    public Result<List<物流任务历史表>> searchLikeString(String userLikeString) {
        Result<List<物流任务历史表>> res = new Result<>();
        try {
            userLikeString = "%" + userLikeString + "%";
            List<物流任务历史表> data = 物流任务历史表Dao.selectLikeString(userLikeString);
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

    @Transactional
    @Override
    public Result<List<物流任务历史表>> 抽检返架(物流任务历史表 物流任务历史表) {
        Result<List<物流任务历史表>> res = new Result<>();
        try{
            List<物流任务历史表> data = 物流任务历史表Dao.抽检返架();
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
