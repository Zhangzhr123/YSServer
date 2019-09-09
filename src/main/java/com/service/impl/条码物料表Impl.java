package com.service.impl;
/**
 * Created by zzr on 2019/07/08
 * 条码物料表Impl
 */
import com.bean.*;
import com.service.I条码物料表Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 条码物料表Impl implements I条码物料表Service {
    @Autowired
    private com.dao.条码物料表Dao 条码物料表Dao;
    @Autowired
    private com.dao.库存查询表Dao 库存查询表Dao;
    @Autowired
    private com.dao.物流任务历史表Dao 物流任务历史表Dao;
    @Autowired
    private com.dao.仓库单据明细表Dao 仓库单据明细表Dao;
    @Autowired
    private com.dao.仓库单据表Dao 仓库单据表Dao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Result<条码物料表> create(条码物料表 条码物料表, User operator) {
        Result<条码物料表> res = new Result<>();
        try{
            条码物料表Dao.insert(条码物料表);
            res.setFlag(true);
            res.setData(条码物料表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<条码物料表> delete(String userId, User operator) {
        Result<条码物料表> res = new Result<>();
        try{
            条码物料表Dao.delete(userId);
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
    public Result<条码物料表> deleteAll(List<String> idList, User operator) {
        Result<条码物料表> res = new Result<>();
        try{
            条码物料表Dao.deleteAll(idList);
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
    public Result<条码物料表> update(条码物料表 条码物料表, User operator) {
        Result<条码物料表> res = new Result<>();
        try{
            条码物料表Dao.update(条码物料表);
            res.setFlag(true);
            res.setData(条码物料表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<条码物料表> updateSelective(条码物料表 条码物料表, User operator) {
        Result<条码物料表> res = new Result<>();
        try{
            条码物料表Dao.updateSelective(条码物料表);
            res.setFlag(true);
            res.setData(条码物料表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<条码物料表> getById(String objectId) {
        Result<条码物料表> res = new Result<>();
        try{
            条码物料表 data = 条码物料表Dao.selectByPrimaryKey(objectId);
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
    public Result<List<条码物料表>> getAll() {
        Result<List<条码物料表>> res = new Result<>();
        try{
            List<条码物料表> data = 条码物料表Dao.selectAll();
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
    public Result<List<条码物料表>> search(条码物料表 条码物料表) {
        Result<List<条码物料表>> res = new Result<>();
        try{
            List<条码物料表> data = 条码物料表Dao.selectBySelective(条码物料表);
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
    public Result<Long> searchResultsCount(条码物料表 条码物料表) {
        Result<Long> res = new Result<>();
        try{
            Long data = 条码物料表Dao.selectBySelectiveCount(条码物料表);
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
    public Result<List<条码物料表>> searchWithPage(条码物料表 条码物料表) {
        Result<List<条码物料表>> res = new Result<>();
        try{
            long count = 条码物料表Dao.selectBySelectiveCount(条码物料表);
            List<条码物料表> data = 条码物料表Dao.selectBySelectivePage(条码物料表);
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
    public Result<List<条码物料表>> searchLikeString(String userLikeString) {
        Result<List<条码物料表>> res = new Result<>();
        try {
            userLikeString = "%" + userLikeString + "%";
            List<条码物料表> data = 条码物料表Dao.selectLikeString(userLikeString);
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
