package com.service.impl;
/**
 * Created by zzr on 2019/06/12
 * 库存查询表impl
 */
import com.bean.*;
import com.service.I库存查询表Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class 库存查询表Impl implements I库存查询表Service {

    @Autowired
    private com.dao.库存查询表Dao 库存查询表Dao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Result<库存查询表> create(库存查询表 库存查询表, User operator) {
        Result<库存查询表> res = new Result<>();
        try{
            库存查询表Dao.insert(库存查询表);
            res.setFlag(true);
            res.setData(库存查询表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<库存查询表> delete(String userId, User operator) {
        Result<库存查询表> res = new Result<>();
        try{
            库存查询表Dao.delete(userId);
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
    public Result<库存查询表> deleteAll(List<String> idList, User operator) {
        Result<库存查询表> res = new Result<>();
        try{
            库存查询表Dao.deleteAll(idList);
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
    public Result<库存查询表> update(库存查询表 库存查询表, User operator) {
        Result<库存查询表> res = new Result<>();
        try{
            库存查询表Dao.update(库存查询表);
            res.setFlag(true);
            res.setData(库存查询表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<库存查询表> updateSelective(库存查询表 库存查询表, User operator) {
        Result<库存查询表> res = new Result<>();
        try{
            库存查询表Dao.updateSelective(库存查询表);
            res.setFlag(true);
            res.setData(库存查询表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<库存查询表> getById(String objectId) {
        Result<库存查询表> res = new Result<>();
        try{
            库存查询表 data = 库存查询表Dao.selectByPrimaryKey(objectId);
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
    public Result<List<库存查询表>> getAll() {
        Result<List<库存查询表>> res = new Result<>();
        try{
            List<库存查询表> data = 库存查询表Dao.selectAll();
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
    public Result<List<库存查询表>> search(库存查询表 库存查询表) {
        Result<List<库存查询表>> res = new Result<>();
        try{
            List<库存查询表> data = 库存查询表Dao.selectBySelective(库存查询表);
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
    public Result<Long> searchResultsCount(库存查询表 库存查询表) {
        Result<Long> res = new Result<>();
        try{
            Long data = 库存查询表Dao.selectBySelectiveCount(库存查询表);
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
    public Result<List<库存查询表>> searchWithPage(库存查询表 库存查询表) {
        Result<List<库存查询表>> res = new Result<>();
        try{
            long count = 库存查询表Dao.selectBySelectiveCount(库存查询表);
            List<库存查询表> data = 库存查询表Dao.selectBySelectivePage(库存查询表);
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
    public Result<List<库存查询表>> searchAll(库存查询表 库存查询表) {
        Result<List<库存查询表>> res = new Result<>();
        try{
            List<库存查询表> data = 库存查询表Dao.searchAll();
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

    @Transactional
    @Override
    public Result<库存查询表> 修改库存状态(库存查询表 库存查询表) {
        Result<库存查询表> res = new Result<>();
        try{
            String 成品条码 = 库存查询表.get条码编号();
            //查询成品条码
            库存查询表 kc = new 库存查询表();
            kc.set条码编号(成品条码);
            List<库存查询表> 库存查询表s = 库存查询表Dao.search条码编号(kc);
            if(库存查询表s == null || 库存查询表s.size() == 0){
                res.setFlag(false);
                res.setMessage("成品条码扫描错误");
            }else {
                if (成品条码.equals(库存查询表s.get(0).get条码编号())) {
                    //成品出库请空库位
                    库存查询表 update = new 库存查询表();
                    update.set库位编号(库存查询表s.get(0).get库位编号());
                    System.out.println(库存查询表s.get(0).get库位编号());
                    库存查询表Dao.清空库位(update);
                    res.setFlag(true);
                    res.setData(库存查询表);
                } else {
                    res.setFlag(false);
                    res.setMessage("成品条码未对应");
                }
            }

        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

}
