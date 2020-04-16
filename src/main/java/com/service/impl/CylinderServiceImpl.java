package com.service.impl;
/**
 * Created by zzr on 2019/06/12
 * 用户表impl
 */

import com.bean.Result;
import com.bean.Cylinder;
import com.bean.User;
import com.service.ICylinderService;
import com.utils.LogUtil;
import com.utils.MD5Util;
import com.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CylinderServiceImpl implements ICylinderService {

    @Autowired
    private com.dao.CylinderDao CylinderDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Result<Cylinder> create(Cylinder cylinder, User operator) {
        Result<Cylinder> res = new Result<>();
        try {
            CylinderDao.insert(cylinder);
            res.setFlag(true);
            res.setData(cylinder);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<Cylinder> delete(String objectId, User operator) {
        Result<Cylinder> res = new Result<>();
        try {
            CylinderDao.delete(objectId);
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
    public Result<Cylinder> deleteAll(List<String> idList, User operator) {
        Result<Cylinder> res = new Result<>();
        try {
            CylinderDao.deleteAll(idList);
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
    public Result<Cylinder> update(Cylinder cylinder, User operator) {
        Result<Cylinder> res = new Result<>();
        try {
            CylinderDao.update(cylinder);
            res.setFlag(true);
            res.setData(cylinder);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<Cylinder> getById(String objectId) {
        Result<Cylinder> res = new Result<>();
        try {
            Cylinder data = CylinderDao.selectByPrimaryKey(objectId);
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
    public Result<List<Cylinder>> getAll() {
        Result<List<Cylinder>> res = new Result<>();
        try {
            List<Cylinder> data = CylinderDao.selectAll();
            if (data == null) {
				res.setFlag(false);
				res.setMessage("钢瓶信息表没有数据");
			}
			if (data != null && data.size() > 0) {
				res.setFlag(true);
				res.setData(data);
                res.setMessage("钢瓶数据同步成功");
			}

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage("钢瓶数据同步失败，下载失败");
        }
        return res;
    }

    @Override
    public Result<List<Cylinder>> search(Cylinder cylinder) {
        Result<List<Cylinder>> res = new Result<>();
        try {
            List<Cylinder> data = CylinderDao.selectBySelective(cylinder);
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
    public Result<Long> searchResultsCount(Cylinder cylinder) {
        Result<Long> res = new Result<>();
        try {
            Long data = CylinderDao.selectBySelectiveCount(cylinder);
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
    public Result<Cylinder> selsectByKey(Cylinder cylinder) {
        System.out.println(cylinder.getCylinderQRCode());
        Result<Cylinder> res = new Result<>();
        try {
            Cylinder data = CylinderDao.selectByKey(cylinder);
            System.out.println(data.getCylinderIDNum());
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
    public Result<List<Cylinder>> insertGPInformation(List<Cylinder> cylinderList) {
        Result<List<Cylinder>> res = new Result<>();
        try {
            if (cylinderList.size() < 0 || cylinderList == null) {
                res.setFlag(false);
                res.setData(cylinderList);
                res.setMessage("钢瓶注册信息没有数据，上传失败");
            }
            //获取流水号
            int number = CylinderDao.selectNumber();
            if (cylinderList.size() > 0 && cylinderList != null) {
                for (int i = 0; i < cylinderList.size(); i++) {
                    Cylinder cylinder = new Cylinder();
                    cylinder.setCylinderIDNum(String.format("%04d", Integer.valueOf(number+1+i)));
                    cylinder.setCylinderNumber(cylinderList.get(i).getCylinderNumber());
                    cylinder.setCylinderCode(cylinderList.get(i).getCylinderCode());
                    cylinder.setCylinderQRCode(cylinderList.get(i).getCylinderQRCode());
                    cylinder.setCompanyName(cylinderList.get(i).getCompanyName());
                    cylinder.setCylinderSpec(cylinderList.get(i).getCylinderSpec());
                    cylinder.setCylinderPressure(cylinderList.get(i).getCylinderPressure());
                    cylinder.setCylinderVolume(cylinderList.get(i).getCylinderVolume());
                    cylinder.setCylinderMakeDate(cylinderList.get(i).getCylinderMakeDate());
                    cylinder.setCylinderType(cylinderList.get(i).getCylinderType());
                    cylinder.setCylinderMedia(cylinderList.get(i).getCylinderMedia());
                    cylinder.setCylinderStatus(cylinderList.get(i).getCylinderStatus());
                    cylinder.setCylinderScrapDate(cylinderList.get(i).getCylinderScrapDate());
                    cylinder.setCylinderLastInspectDate(cylinderList.get(i).getCylinderLastInspectDate());
                    cylinder.setCylinderNextInspectDate(cylinderList.get(i).getCylinderNextInspectDate());
                    cylinder.setCreationDate(cylinderList.get(i).getCreationDate());
                    cylinder.setCreatedBy(cylinderList.get(i).getCreatedBy());
                    cylinder.setLastUpdateDate(cylinderList.get(i).getLastUpdateDate());
                    cylinder.setLastUpdatedBy(cylinderList.get(i).getLastUpdatedBy());
                    CylinderDao.insertGPInformation(cylinder);
                }
                //修改流水号
                CylinderDao.updateNumber((cylinderList.size()+number));
                res.setFlag(true);
                res.setData(cylinderList);
                res.setMessage("钢瓶数据同步完成，上传成功");
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
