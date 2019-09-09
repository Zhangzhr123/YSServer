package com.service.impl;

import com.bean.ERP单据明细表;
import com.bean.Result;
import com.bean.User;
import com.bean.物流任务表;
import com.service.IERP单据明细表Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ERP单据明细表Impl implements IERP单据明细表Service {
    @Autowired
    private com.dao.ERP单据明细表Dao ERP单据明细表Dao;
    @Autowired
    private com.dao.物流任务表Dao 物流任务表Dao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Result<ERP单据明细表> create(ERP单据明细表 ERP单据明细表, User operator) {
        Result<ERP单据明细表> res = new Result<>();
        try{
            ERP单据明细表Dao.insert(ERP单据明细表);
            res.setFlag(true);
            res.setData(ERP单据明细表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<ERP单据明细表> delete(String userId, User operator) {
        Result<ERP单据明细表> res = new Result<>();
        try{
            ERP单据明细表Dao.delete(userId);
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
    public Result<ERP单据明细表> deleteAll(List<String> idList, User operator) {
        Result<ERP单据明细表> res = new Result<>();
        try{
            ERP单据明细表Dao.deleteAll(idList);
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
    public Result<ERP单据明细表> update(ERP单据明细表 ERP单据明细表, User operator) {
        Result<ERP单据明细表> res = new Result<>();
        try{
            ERP单据明细表Dao.update(ERP单据明细表);
            res.setFlag(true);
            res.setData(ERP单据明细表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<ERP单据明细表> updateSelective(ERP单据明细表 ERP单据明细表, User operator) {
        Result<ERP单据明细表> res = new Result<>();
        try{
            ERP单据明细表Dao.updateSelective(ERP单据明细表);
            res.setFlag(true);
            res.setData(ERP单据明细表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<ERP单据明细表> getById(String objectId) {
        Result<ERP单据明细表> res = new Result<>();
        try{
            ERP单据明细表 data = ERP单据明细表Dao.selectByPrimaryKey(objectId);
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
    public Result<List<ERP单据明细表>> getAll() {
        Result<List<ERP单据明细表>> res = new Result<>();
        try{
            List<ERP单据明细表> data = ERP单据明细表Dao.selectAll();
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
    public Result<List<ERP单据明细表>> search(ERP单据明细表 ERP单据明细表) {
        Result<List<ERP单据明细表>> res = new Result<>();
        try{
            List<ERP单据明细表> data = ERP单据明细表Dao.selectBySelective(ERP单据明细表);
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
    public Result<Long> searchResultsCount(ERP单据明细表 ERP单据明细表) {
        Result<Long> res = new Result<>();
        try{
            Long data = ERP单据明细表Dao.selectBySelectiveCount(ERP单据明细表);
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
    public Result<List<ERP单据明细表>> searchWithPage(ERP单据明细表 ERP单据明细表) {
        Result<List<ERP单据明细表>> res = new Result<>();
        try{
            long count = ERP单据明细表Dao.selectBySelectiveCount(ERP单据明细表);
            List<ERP单据明细表> data = ERP单据明细表Dao.selectBySelectivePage(ERP单据明细表);
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
    public Result<List<ERP单据明细表>> searchLikeString(String userLikeString) {
        Result<List<ERP单据明细表>> res = new Result<>();
        try {
            userLikeString = "%" + userLikeString + "%";
            List<ERP单据明细表> data = ERP单据明细表Dao.selectLikeString(userLikeString);
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
    public Result<List<ERP单据明细表>> 查询调拨单(ERP单据明细表 ERP单据明细表) {
        Result<List<ERP单据明细表>> res = new Result<>();
        try{
            List<ERP单据明细表> data = ERP单据明细表Dao.查询调拨单();
            if(data == null || data.size() == 0){
                res.setFlag(false);
                res.setMessage("未查到单据");
            }
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
    public Result<List<ERP单据明细表>> 查询入库单据(ERP单据明细表 ERP单据明细表) {
        Result<List<ERP单据明细表>> res = new Result<>();
        try{
            List<ERP单据明细表> data = ERP单据明细表Dao.查询入库单据();
            if(data == null || data.size() == 0){
                res.setFlag(false);
                res.setMessage("未查到单据");
            }
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
    public Result<List<ERP单据明细表>> 查询出库单据(ERP单据明细表 ERP单据明细表) {
        Result<List<ERP单据明细表>> res = new Result<>();
        try{
            List<ERP单据明细表> data = ERP单据明细表Dao.查询出库单据();
            if(data == null || data.size() == 0){
                res.setFlag(false);
                res.setMessage("未查到单据");
            }
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
    public Result<ERP单据明细表> 修改单据标识(List<String> list) {
        Result<ERP单据明细表> res = new Result<>();
        try{
            System.out.println(list.get(0)+"---"+list.get(1)+"---"+list.get(2));
            //根据条件查询单据
            ERP单据明细表 update = new ERP单据明细表();
            update.set单据编号(list.get(0));
            update.set单据类型(list.get(1));
            update.set物料名称(list.get(2));
            List<ERP单据明细表> data = ERP单据明细表Dao.展示单据(update);
            if(data != null && data.size() != 0){
                ERP单据明细表Dao.修改单据标识(update);
            }else{
                res.setFlag(false);
                res.setMessage("未查到单据");
            }
            res.setFlag(true);
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
    public Result<List<ERP单据明细表>> 展示单据(List<String> list) {
        Result<List<ERP单据明细表>> res = new Result<>();
        try{
            System.out.println(list.get(0)+"---"+list.get(1)+"---"+list.get(2));
            //根据条件查询单据
            ERP单据明细表 search = new ERP单据明细表();
            search.set单据编号(list.get(0));
            search.set单据类型(list.get(1));
            search.set物料名称(list.get(2));
            List<ERP单据明细表> data = ERP单据明细表Dao.展示单据(search);
            if(data == null || data.size() == 0){
                res.setFlag(false);
                res.setMessage("未查到单据");
            }
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
    public Result<List<ERP单据明细表>> 完成入库(List<String> list) {
        Result<List<ERP单据明细表>> res = new Result<>();
        try{
            System.out.println(list.get(0)+"---"+list.get(1)+"---"+list.get(2)+"---"+list.get(3));
            //根据条件查询单据
            ERP单据明细表 search = new ERP单据明细表();
            search.set单据编号(list.get(0));
            search.set物料名称(list.get(1));
            search.set数量(Double.valueOf(list.get(3)));//总重量
            List<ERP单据明细表> data = ERP单据明细表Dao.selectBySelective(search);
            if(data == null || data.size() == 0){
                res.setFlag(false);
                res.setMessage("没有相关单据");
            }
            //查询任务
            物流任务表 wl = new 物流任务表();
            wl.set单据编号(data.get(0).get单据编号());
            wl.set物料名称(data.get(0).get物料名称());
            List<物流任务表> data1 = 物流任务表Dao.selectBySelective(wl);
            if(data1 == null || data1.size() == 0){
                res.setFlag(false);
                data.add(search);
                res.setData(data);
            }
            //计算剩余数量，从物流任务表中拿数据，注意如果AGV执行完任务，数据会出错
            if(data1.size() > 0){
                Double sum = Double.valueOf(list.get(3));
                for(int i = 0;i<data1.size();i++){
                    sum-=data1.get(i).get数量();//递减计算剩余重量
                }
                if(sum > 0){
                    //将递减后的重量发送给android端
                    List<ERP单据明细表> data3 = new ArrayList<>();
                    ERP单据明细表 erp = new ERP单据明细表();
                    erp.set数量(sum);
                    data3.add(erp);
                    res.setFlag(false);
                    res.setData(data3);
                }else {
                    res.setFlag(true);
                    res.setData(data);
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
