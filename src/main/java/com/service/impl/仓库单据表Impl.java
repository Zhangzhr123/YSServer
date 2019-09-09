package com.service.impl;
/**
 * Created by zzr on 2019/06/12
 * 仓库单据表impl
 */
import com.bean.Result;
import com.bean.User;
import com.bean.仓库单据表;
import com.service.I仓库单据表Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 仓库单据表Impl implements I仓库单据表Service {

    @Autowired
    private com.dao.仓库单据表Dao 仓库单据表Dao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Result<仓库单据表> create(仓库单据表 仓库单据表, User operator) {
        Result<仓库单据表> res = new Result<>();
        try{
            仓库单据表Dao.insert(仓库单据表);
            res.setFlag(true);
            res.setData(仓库单据表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<仓库单据表> delete(String userId, User operator) {
        Result<仓库单据表> res = new Result<>();
        try{
            仓库单据表Dao.delete(userId);
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
    public Result<仓库单据表> deleteAll(List<String> idList, User operator) {
        Result<仓库单据表> res = new Result<>();
        try{
            仓库单据表Dao.deleteAll(idList);
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
    public Result<仓库单据表> update(仓库单据表 仓库单据表, User operator) {
        Result<仓库单据表> res = new Result<>();
        try{
            仓库单据表Dao.update(仓库单据表);
            res.setFlag(true);
            res.setData(仓库单据表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<仓库单据表> updateSelective(仓库单据表 仓库单据表, User operator) {
        Result<仓库单据表> res = new Result<>();
        try{
            仓库单据表Dao.updateSelective(仓库单据表);
            res.setFlag(true);
            res.setData(仓库单据表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<仓库单据表> getById(String objectId) {
        Result<仓库单据表> res = new Result<>();
        try{
            仓库单据表 data = 仓库单据表Dao.selectByPrimaryKey(objectId);
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
    public Result<List<仓库单据表>> getAll() {
        Result<List<仓库单据表>> res = new Result<>();
        try{
            List<仓库单据表> data = 仓库单据表Dao.selectAll();
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
    public Result<List<仓库单据表>> search(仓库单据表 仓库单据表) {
        Result<List<仓库单据表>> res = new Result<>();
        try{
            List<仓库单据表> data = 仓库单据表Dao.selectBySelective(仓库单据表);
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
    public Result<Long> searchResultsCount(仓库单据表 仓库单据表) {
        Result<Long> res = new Result<>();
        try{
            Long data = 仓库单据表Dao.selectBySelectiveCount(仓库单据表);
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
    public Result<List<仓库单据表>> searchWithPage(仓库单据表 仓库单据表) {
        Result<List<仓库单据表>> res = new Result<>();
        try{
            long count = 仓库单据表Dao.selectBySelectiveCount(仓库单据表);
            List<仓库单据表> data = 仓库单据表Dao.selectBySelectivePage(仓库单据表);
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
    public Result<List<仓库单据表>> searchLikeString(String userLikeString) {
        Result<List<仓库单据表>> res = new Result<>();
        try {
            userLikeString = "%" + userLikeString + "%";
            List<仓库单据表> data = 仓库单据表Dao.selectLikeString(userLikeString);
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
