package com.service.impl;
/**
 * Created by zzr on 2019/07/09
 * Binimpl
 */

import com.bean.Bin;
import com.bean.Result;
import com.bean.User;
import com.service.IBinService;
import com.service.IBinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BinImpl implements IBinService {

    @Autowired
    private com.dao.BinDao BinDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Result<Bin> updateNull(String barCode) {
        Result<Bin> res = new Result<>();
        try {
            System.out.println(barCode);
            if (barCode != null) {
                Bin bin = new Bin();
                bin.setBarCode(barCode);
                BinDao.updateNull(bin);
                res.setFlag(true);
                res.setData(bin);

            } else {
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

    @Override
    public Result<List<Bin>> selectAll() {
        Result<List<Bin>> res = new Result<>();
        try {
            List<Bin> data = BinDao.selectAll();
            if (data != null && data.size() != 0) {
                res.setFlag(true);
                res.setCount((long) data.size());
                res.setData(data);
            } else {
                res.setFlag(false);
                res.setMessage("没有此条码对应的数据");
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
