package com.service.impl;
/**
 * Created by zzr on 2019/07/09
 * Recordsimpl
 */
import com.bean.*;
import com.service.IRecordsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecordsImpl implements IRecordsService {

    @Autowired
    private com.dao.RecordsDao RecordsDao;
    @Autowired
    private com.dao.BinDao BinDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Transactional
    @Override
    public Result<Records> create(Records Records, User operator) {
        Result<Records> res = new Result<>();
        try{
            RecordsDao.insert(Records);
            res.setFlag(true);
            res.setData(Records);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<Records> delete(String userId, User operator) {
        Result<Records> res = new Result<>();
        try{
            RecordsDao.delete(userId);
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
    public Result<Records> deleteAll(List<String> idList, User operator) {
        Result<Records> res = new Result<>();
        try{
            RecordsDao.deleteAll(idList);
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
    public Result<Records> update(Records Records, User operator) {
        Result<Records> res = new Result<>();
        try{
            RecordsDao.update(Records);
            res.setFlag(true);
            res.setData(Records);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<Records> updateSelective(Records Records, User operator) {
        Result<Records> res = new Result<>();
        try{
            RecordsDao.updateSelective(Records);
            res.setFlag(true);
            res.setData(Records);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<Records> getById(String objectId) {
        Result<Records> res = new Result<>();
        try{
            Records data = RecordsDao.selectByPrimaryKey(objectId);
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
    public Result<List<Records>> getAll() {
        Result<List<Records>> res = new Result<>();
        try{
            List<Records> data = RecordsDao.selectAll();
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
    public Result<List<Records>> search(Records Records) {
        Result<List<Records>> res = new Result<>();
        try{
            List<Records> data = RecordsDao.selectBySelective(Records);
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
    public Result<Long> searchResultsCount(Records Records) {
        Result<Long> res = new Result<>();
        try{
            Long data = RecordsDao.selectBySelectiveCount(Records);
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
    public Result<List<Records>> searchWithPage(Records Records) {
        Result<List<Records>> res = new Result<>();
        try{
            long count = RecordsDao.selectBySelectiveCount(Records);
            List<Records> data = RecordsDao.selectBySelectivePage(Records);
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
    public Result<List<Records>> searchLikeString(String userLikeString) {
        Result<List<Records>> res = new Result<>();
        try {
            userLikeString = "%" + userLikeString + "%";
            List<Records> data = RecordsDao.selectLikeString(userLikeString);
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

    @Override
    public Result<Records> updateType(String barCode) {
        Result<Records> res = new Result<>();
        try{
            System.out.println(barCode);
            if(barCode!=null){
                Records records = new Records();
                records.setBarCode(barCode);
                int update = RecordsDao.updateType(barCode);
                if(update == 0){
                    res.setFlag(false);
                    res.setMessage("出库确认失败");
                }else{
                    Bin bin = new Bin();
                    bin.setBarCode(barCode);
                    int out = BinDao.updateNull(bin);
                    if(out == 0){
                        res.setFlag(false);
                        res.setMessage("清空库位失败");
                    }else{
                        res.setFlag(true);
                        res.setData(records);
                    }
                }

            }else{
                res.setFlag(false);
                res.setMessage("条码为空");
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
    public Result<List<Records>> getList(String barCode) {
        Result<List<Records>> res = new Result<>();
        try {
            System.out.println(barCode);
            if(barCode!=null){
                List<Records> data = RecordsDao.getList(barCode);
                if(data!=null&&data.size()!=0){
                    res.setFlag(true);
                    res.setCount((long) data.size());
                    res.setData(data);
                }else{
                    res.setFlag(false);
                    res.setMessage("没有此条码对应的数据");
                }

            }else{
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

}
