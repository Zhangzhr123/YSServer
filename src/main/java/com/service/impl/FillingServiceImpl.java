package com.service.impl;
/**
 * Created by zzr on 2019/06/12
 * 用户表impl
 */

import com.bean.Filling;
import com.bean.Result;
import com.bean.User;
import com.service.IFillingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FillingServiceImpl implements IFillingService {

    @Autowired
    private com.dao.FillingDao FillingDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Result<Filling> create(Filling filling, User operator) {
        Result<Filling> res = new Result<>();
        try {
            FillingDao.insert(filling);
            res.setFlag(true);
            res.setData(filling);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<Filling> delete(String objectId, User operator) {
        Result<Filling> res = new Result<>();
        try {
            FillingDao.delete(objectId);
            res.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<Filling> deleteAll(List<String> idList, User operator) {
        Result<Filling> res = new Result<>();
        try {
            FillingDao.deleteAll(idList);
            res.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<Filling> update(Filling filling, User operator) {
        Result<Filling> res = new Result<>();
        try {
            FillingDao.update(filling);
            res.setFlag(true);
            res.setData(filling);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<Filling> getById(String objectId) {
        Result<Filling> res = new Result<>();
        try {
            Filling data = FillingDao.selectByPrimaryKey(objectId);
            res.setFlag(true);
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
    public Result<List<Filling>> getAll() {
        Result<List<Filling>> res = new Result<>();
        try {
            List<Filling> data = FillingDao.selectAll();
            if (data == null) {
                res.setFlag(false);
                res.setMessage("钢瓶称重信息表没有数据");
            }
            if (data != null && data.size() > 0) {
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
    public Result<List<Filling>> search(Filling filling) {
        Result<List<Filling>> res = new Result<>();
        try {
            List<Filling> data = FillingDao.selectBySelective(filling);
            res.setFlag(true);
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
    public Result<Long> searchResultsCount(Filling filling) {
        Result<Long> res = new Result<>();
        try {
            Long data = FillingDao.selectBySelectiveCount(filling);
            res.setFlag(true);
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
    public Result<List<Filling>> setListData(List<Filling> listFilling) {
        Result<List<Filling>> res = new Result<>();
        try {
            if (listFilling.size() < 0 || listFilling == null) {
                res.setFlag(false);
                res.setData(listFilling);
                res.setMessage("充装没有数据，上传失败");
            }
            if (listFilling.size() > 0 && listFilling != null) {
                for (int i = 0; i < listFilling.size(); i++) {
                    FillingDao.setListData(listFilling.get(i));
                }
				res.setFlag(true);
				res.setData(listFilling);
				res.setMessage("充装数据同步完成，上传成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage("充装数据丢失，上传失败");
        }
        return res;
    }
}
