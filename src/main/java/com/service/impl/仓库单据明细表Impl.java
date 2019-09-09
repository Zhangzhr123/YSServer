package com.service.impl;
/**
 * Created by zzr on 2019/06/12
 * 仓库单据明细表impl
 */
import com.bean.Result;
import com.bean.User;
import com.bean.仓库单据明细表;
import com.service.I仓库单据明细表Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 仓库单据明细表Impl implements I仓库单据明细表Service {

    @Autowired
    private com.dao.仓库单据明细表Dao 仓库单据明细表Dao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Result<仓库单据明细表> create(仓库单据明细表 仓库单据明细表, User operator) {
        Result<仓库单据明细表> res = new Result<>();
        try{
            仓库单据明细表Dao.insert(仓库单据明细表);
            res.setFlag(true);
            res.setData(仓库单据明细表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<仓库单据明细表> delete(String userId, User operator) {
        Result<仓库单据明细表> res = new Result<>();
        try{
            仓库单据明细表Dao.delete(userId);
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
    public Result<仓库单据明细表> deleteAll(List<String> idList, User operator) {
        Result<仓库单据明细表> res = new Result<>();
        try{
            仓库单据明细表Dao.deleteAll(idList);
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
    public Result<仓库单据明细表> update(仓库单据明细表 仓库单据明细表, User operator) {
        Result<仓库单据明细表> res = new Result<>();
        try{
            仓库单据明细表Dao.update(仓库单据明细表);
            res.setFlag(true);
            res.setData(仓库单据明细表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<仓库单据明细表> updateSelective(仓库单据明细表 仓库单据明细表, User operator) {
        Result<仓库单据明细表> res = new Result<>();
        try{
            仓库单据明细表Dao.updateSelective(仓库单据明细表);
            res.setFlag(true);
            res.setData(仓库单据明细表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<仓库单据明细表> getById(String objectId) {
        Result<仓库单据明细表> res = new Result<>();
        try{
            仓库单据明细表 data = 仓库单据明细表Dao.selectByPrimaryKey(objectId);
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
    public Result<List<仓库单据明细表>> getAll(String operator) {
        Result<List<仓库单据明细表>> res = new Result<>();
        try{
            List<仓库单据明细表> data = 仓库单据明细表Dao.selectAll();
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
    public Result<List<仓库单据明细表>> search(仓库单据明细表 仓库单据明细表) {
        Result<List<仓库单据明细表>> res = new Result<>();
        try{
            List<仓库单据明细表> data = 仓库单据明细表Dao.selectBySelective(仓库单据明细表);
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
    public Result<Long> searchResultsCount(仓库单据明细表 仓库单据明细表) {
        Result<Long> res = new Result<>();
        try{
            Long data = 仓库单据明细表Dao.selectBySelectiveCount(仓库单据明细表);
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
    public Result<List<仓库单据明细表>> searchWithPage(仓库单据明细表 仓库单据明细表) {
        Result<List<仓库单据明细表>> res = new Result<>();
        try{
            long count = 仓库单据明细表Dao.selectBySelectiveCount(仓库单据明细表);
            List<仓库单据明细表> data = 仓库单据明细表Dao.selectBySelectivePage(仓库单据明细表);
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
    public Result<List<仓库单据明细表>> search物料编号(仓库单据明细表 仓库单据明细表) {
        Result<List<仓库单据明细表>> res = new Result<>();
        try{
            String 物料编号 = 仓库单据明细表.get物料编号();
            物料编号="%"+物料编号+"%";
            仓库单据明细表 ck = new 仓库单据明细表();
            ck.set物料编号(物料编号);
            List<仓库单据明细表> data = 仓库单据明细表Dao.search物料编号(ck);
            if(!data.get(0).get物料编号().equals(物料编号)){
                res.setFlag(false);
                res.setMessage("物料编号错误");
            }else{
                res.setFlag(true);
                res.setCount((long)data.size());
                res.setData(data);
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
    public Result<List<仓库单据明细表>> searchAll(仓库单据明细表 仓库单据明细表) {
        Result<List<仓库单据明细表>> res = new Result<>();
        try{
            List<仓库单据明细表> data = 仓库单据明细表Dao.searchAll();
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
