package com.service.impl;
/**
 * Created by zzr on 2019/06/12
 * 物流任务表impl
 */
import com.bean.*;
import com.service.I物流任务表Service;
import com.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class 物流任务表Impl implements I物流任务表Service {

    @Autowired
    private com.dao.物流任务表Dao 物流任务表Dao;
    @Autowired
    private com.dao.库存查询表Dao 库存查询表Dao;
    @Autowired
    private com.dao.ERP单据明细表Dao ERP单据明细表Dao;

    Logger logger = LoggerFactory.getLogger(this.getClass());//日志

    //任务编号自增方法的全局变量
    public int SerialNumber = 1;//流水号初始值
    public String maxNum;//流水号

    //入库任务全局变量判断任务奇偶数
    public int position = 1;//进入次数初始值
    public int index = 0;//起始站点初始值

    @Transactional
    @Override
    public Result<物流任务表> create(物流任务表 物流任务表, User operator) {
        Result<物流任务表> res = new Result<>();
        try{
            物流任务表Dao.insert(物流任务表);
            res.setFlag(true);
            res.setData(物流任务表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<物流任务表> delete(String userId, User operator) {
        Result<物流任务表> res = new Result<>();
        try{
            物流任务表Dao.delete(userId);
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
    public Result<物流任务表> deleteAll(List<String> idList, User operator) {
        Result<物流任务表> res = new Result<>();
        try{
            物流任务表Dao.deleteAll(idList);
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
    public Result<物流任务表> update(物流任务表 物流任务表, User operator) {
        Result<物流任务表> res = new Result<>();
        try{
            物流任务表Dao.update(物流任务表);
            res.setFlag(true);
            res.setData(物流任务表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<物流任务表> updateSelective(物流任务表 物流任务表, User operator) {
        Result<物流任务表> res = new Result<>();
        try{
            物流任务表Dao.updateSelective(物流任务表);
            res.setFlag(true);
            res.setData(物流任务表);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @Override
    public Result<物流任务表> getById(String objectId) {
        Result<物流任务表> res = new Result<>();
        try{
            物流任务表 data = 物流任务表Dao.selectByPrimaryKey(objectId);
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
    public Result<List<物流任务表>> getAll() {
        Result<List<物流任务表>> res = new Result<>();
        try{
            List<物流任务表> data = 物流任务表Dao.selectAll();
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
    public Result<List<物流任务表>> search(物流任务表 物流任务表) {
        Result<List<物流任务表>> res = new Result<>();
        try{
            List<物流任务表> data = 物流任务表Dao.selectBySelective(物流任务表);
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
    public Result<Long> searchResultsCount(物流任务表 物流任务表) {
        Result<Long> res = new Result<>();
        try{
            Long data = 物流任务表Dao.selectBySelectiveCount(物流任务表);
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
    public Result<List<物流任务表>> searchWithPage(物流任务表 物流任务表) {
        Result<List<物流任务表>> res = new Result<>();
        try{
            long count = 物流任务表Dao.selectBySelectiveCount(物流任务表);
            List<物流任务表> data = 物流任务表Dao.selectBySelectivePage(物流任务表);
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
    public Result<List<物流任务表>> searchLikeString(String userLikeString) {
        Result<List<物流任务表>> res = new Result<>();
        try {
            userLikeString = "%" + userLikeString + "%";
            List<物流任务表> data = 物流任务表Dao.selectLikeString(userLikeString);
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
    public Result<物流任务表> 原料发布入库任务(ERP单据明细表 ERP单据明细表) {
        Result<物流任务表> res = new Result<>();
        try {
            System.out.println(ERP单据明细表.get单据类型()+"--"+ERP单据明细表.get单据编号()+"--"+ERP单据明细表.get物料编号()+"--"+ERP单据明细表.get物料名称()
                    +"--"+ERP单据明细表.get批次()+"--"+ERP单据明细表.get物料规格()+"--"+ERP单据明细表.get数量()+"--"+ERP单据明细表.get计划数量());
            //起始站点位置
            String[] arr= new String[]{"B010101","B010501","B010201","B010601","B010301","B010701","B010401","B010801"};
            //目的站点位置  分奇偶数查询和发布物流任务
            List<库存查询表> 偶数s = 库存查询表Dao.search偶数空库位();
            List<库存查询表> 奇数s = 库存查询表Dao.search奇数空库位();
            //判断奇偶数库位状态
            if(偶数s == null && 奇数s != null || 偶数s.size() == 0 && 奇数s.size() != 0){
                SerialNumber++;
            }else if(奇数s == null && 偶数s != null || 奇数s.size() == 0 && 偶数s.size() != 0){
                SerialNumber++;
            }else if(奇数s == null && 偶数s == null || 偶数s.size() == 0 && 奇数s.size() == 0){
                res.setFlag(false);
                res.setMessage("没有空库位");
            }
            //判断进入方法的次数是否为偶数
            if(SerialNumber%2 == 0){
                //采购入库单
                if(ERP单据明细表.get单据类型().equals("DJ1")){
                    stockInTask(ERP单据明细表, arr, 偶数s, "1002");//入库发布任务
                    //销售退货单
                }else if(ERP单据明细表.get单据类型().equals("DJ7")){
                    stockInTask(ERP单据明细表, arr, 偶数s, "1004");//入库发布任务
                }else{
                    res.setFlag(false);
                    res.setMessage("单据类型错误");
                }
                //判断进入方法的次数是否为奇数
            }else{
                //采购入库单
                if(ERP单据明细表.get单据类型().equals("DJ1")){
                    stockInTask(ERP单据明细表, arr, 奇数s, "1002");//入库发布任务
                    //销售退货单
                }else if(ERP单据明细表.get单据类型().equals("DJ7")){
                    stockInTask(ERP单据明细表, arr, 奇数s, "1004");//入库发布任务
                }else{
                    res.setFlag(false);
                    res.setMessage("单据类型错误");
                }
            }
            res.setFlag(true);
    } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    //入库发布任务
    public void stockInTask(ERP单据明细表 ERP单据明细表, String[] arr, List<库存查询表> 库位s, String 类型代码) {
        String 任务编号 = makeTaskNo();
        String 目的站点 = 库位s.get(0).get库位编号();
        //发布入库物流任务
        insertInTask(ERP单据明细表, arr[index], 任务编号, 目的站点, 类型代码);
        //预约入库
        updateBinStatus(目的站点, "I");
        //起始站点初始下标
        index++;
        if (index == arr.length) //当index的值到达小数组长度时，让小数组下标从零开始
        {
            index = 0;
        }
    }

    @Transactional
    @Override
    public Result<物流任务表> 发布出库任务(ERP单据明细表 ERP单据明细表) {
        Result<物流任务表> res = new Result<>();
        try {
            System.out.println(ERP单据明细表.get单据类型()+"--"+ERP单据明细表.get单据编号()+"--"+ERP单据明细表.get物料名称()
                    +"--"+ERP单据明细表.get批次()+"--"+ERP单据明细表.get物料规格()+"--"+ERP单据明细表.get计划数量());
            //查询物料库存
            库存查询表 kc = new 库存查询表();
            kc.set物料名称(ERP单据明细表.get物料名称());
            kc.set生产批次(ERP单据明细表.get批次());
            kc.set物料规格(ERP单据明细表.get物料规格());
            List<库存查询表> 库存查询表s = 库存查询表Dao.selectBySelective(kc);
            List<库存查询表> data = 库存查询表Dao.search库位(kc);
            //判断库存是否有物料
            if(库存查询表s != null && 库存查询表s.size() > 0) {
                //目的站点的位置
                String[] arr = new String[]{"B010101", "B010501", "B010201", "B010601", "B010301", "B010701", "B010401", "B010801"};
                //目的站点起始下标
                int index = 0;
                //销售出库单
                if (ERP单据明细表.get单据类型().equals("DJ3")) {
                    //判断总重量的数额类型
                    if (ERP单据明细表.get计划数量() / 1000 > 0 && ERP单据明细表.get计划数量() % 1000 > 0) {
                        //循环次数
                        int num = (int) (ERP单据明细表.get计划数量() / 1000) + 1;
                        //出库循环发布任务
                        outTaskLoop(res, ERP单据明细表.get单据编号(), kc, 库存查询表s, arr, index, num);

                    } else if (ERP单据明细表.get计划数量() / 1000 > 0 && ERP单据明细表.get计划数量() % 1000 == 0) {
                        int num = (int) (ERP单据明细表.get计划数量() / 1000);
                        //出库循环发布任务
                        outTaskLoop(res, ERP单据明细表.get单据编号(), kc, 库存查询表s, arr, index, num);

                    } else if (ERP单据明细表.get计划数量() / 1000 < 0) {
                        String 任务编号 = makeTaskNo();
                        String 起始站点 = data.get(0).get库位编号();
                        //发布出库物流任务
                        insertOutTask(ERP单据明细表.get单据编号(), 库存查询表s, arr[0], 任务编号, 起始站点);
                        //预约出库
                        updateBinStatus(起始站点, "O");
                    }
                    res.setFlag(true);
                    //判断是否是其他出库单或采购退货单
                } else if (ERP单据明细表.get单据类型().equals("DJ5") || ERP单据明细表.get单据类型().equals("DJ6")) {
                    Double sum = 0.0;
                    Double num = 0.0;
                    //循环次数
                    int i = 0;
                    frist: while (sum < ERP单据明细表.get计划数量()) {
                        List<库存查询表> 偶数s = 库存查询表Dao.search偶数库位(kc);
                        List<库存查询表> 奇数s = 库存查询表Dao.search奇数库位(kc);
                        //判断奇偶数库存是否有物料
                        if(偶数s.size() == 0 && 奇数s.size() == 0 || 奇数s == null && 偶数s == null){
                            res.setFlag(true);
                            break;
                        }
                        //判断任务编号奇偶数
                        if (SerialNumber % 2 != 0) {

                            奇数s = 库存查询表Dao.search奇数库位(kc);
                            if(奇数s.size() == 0 && 偶数s.size() != 0 || 奇数s == null && 偶数s != null){//判断当奇数库位为空偶数有库位时
                                SerialNumber++;
                                num++;
                                continue frist;
                            }
                            String 任务编号 = makeTaskNo();
                            String 起始站点 = 奇数s.get(0).get库位编号();
                            //发布出库物流任务
                            insertOutTask(ERP单据明细表.get单据编号(), 库存查询表s, arr[index], 任务编号, 起始站点);
                            //预约出库
                            updateBinStatus(起始站点, "O");
                            //目的站点的循环
                            index++;
                            if (index == arr.length) //当index的值到达小数组长度时，让小数组下标从零开始
                            {
                                index = 0;
                            }

                        } else {

                            偶数s = 库存查询表Dao.search偶数库位(kc);
                            if(偶数s.size() == 0 && 奇数s.size() != 0 || 奇数s != null && 偶数s == null){//判断当偶数库位为空奇数有库位时
                                SerialNumber++;
                                num++;
                                continue frist;
                            }
                            String 任务编号 = makeTaskNo();
                            String 起始站点 = 偶数s.get(0).get库位编号();
                            //发布出库物流任务
                            insertOutTask(ERP单据明细表.get单据编号(), 库存查询表s, arr[index], 任务编号, 起始站点);
                            //预约出库
                            updateBinStatus(起始站点, "O");
                            //中转站点下标
                            index++;
                            if (index == arr.length) //当index的值到达小数组长度时，让小数组下标从零开始
                            {
                                index = 0;
                            }
                        }
                        //循环次数
                        sum += data.get(i).get物料重量();
                        i++;
                    }
                    res.setFlag(true);
                } else {
                    res.setFlag(false);
                    res.setMessage("单据类型错误");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    //出库循环发布任务
    public void outTaskLoop(Result<物流任务表> res, String 单据编号, 库存查询表 kc, List<库存查询表> 库存查询表s, String[] arr, int index, int num) {
        frist: for (int i = 0; i < num; i++) {
            List<库存查询表> 偶数s = 库存查询表Dao.search偶数库位(kc);
            List<库存查询表> 奇数s = 库存查询表Dao.search奇数库位(kc);
            if(偶数s.size() == 0 && 奇数s.size() == 0 || 奇数s == null && 偶数s == null){
                res.setFlag(true);
                break;
            }
            //判断是否为奇数
            if (SerialNumber % 2 != 0) {
                if(奇数s.size() == 0 && 偶数s.size() != 0 || 奇数s == null && 偶数s != null){//判断当奇数库位为空偶数有库位时
                    SerialNumber++;
                    num++;
                    continue frist;
                }
                String 任务编号 = makeTaskNo();
                String 起始站点 = 奇数s.get(0).get库位编号();
                //发布出库物流任务
                insertOutTask(单据编号, 库存查询表s, arr[index], 任务编号, 起始站点);
                //预约出库
                updateBinStatus(起始站点, "O");
                //目的站点的循环
                index++;
                if (index == arr.length) //当index的值到达小数组长度时，让小数组下标从零开始
                {
                    index = 0;
                }
                //判断是否为偶数
            } else {
                if(偶数s.size() == 0 && 奇数s.size() != 0 || 奇数s != null && 偶数s == null){//判断当偶数库位为空奇数有库位时
                    SerialNumber++;
                    num++;
                    continue frist;
                }
                String 任务编号 = makeTaskNo();
                String 起始站点 = 偶数s.get(0).get库位编号();
                //发布出库物流任务
                insertOutTask(单据编号, 库存查询表s, arr[index], 任务编号, 起始站点);
                //预约出库
                updateBinStatus(起始站点, "O");
                //目的站点初始下标
                index++;
                if (index == arr.length) //当index的值到达小数组长度时，让小数组下标从零开始
                {
                    index = 0;
                }
            }
        }
    }

    @Transactional
    @Override
    public Result<List<物流任务表>> search任务(物流任务表 物流任务表) {
        Result<List<物流任务表>> res = new Result<>();
        try{
            List<物流任务表> data = 物流任务表Dao.search任务(物流任务表);
            if(data.size() == 0 || data == null){
                res.setFlag(false);
                res.setMessage("没有任务");
            }
            List<物流任务表> list = new ArrayList<>();
            for(int i = 0;i<data.size();i++){
                list.add(data.get(i));
            }
            res.setFlag(true);
            res.setData(list);
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
    public Result<List<物流任务表>> 获取任务信息(List<String> list) {
        Result<List<物流任务表>> res = new Result<>();
        try{
            System.out.println(list.get(0));
            物流任务表 wl = new 物流任务表();
            wl.set任务编号(list.get(0));
            List<物流任务表> data = 物流任务表Dao.异常AGV(wl);
            if(data == null || data.size() == 0){
                res.setFlag(false);
                res.setMessage("未查询到任务");
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
    public Result<物流任务表> 强制执行(List<String> list) {
        Result<物流任务表> res = new Result<>();
        try{
            String 任务编号 = list.get(0);
            System.out.println(任务编号);
            //修改为强制完成
            物流任务表 wlrw = new 物流任务表();
            wlrw.set任务编号(任务编号);
            wlrw.set任务状态("4");
            物流任务表Dao.强制执行(wlrw);

            res.setFlag(true);
            res.setData(wlrw);
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
    public Result<物流任务表> 强制取消(List<String> list) {
        Result<物流任务表> res = new Result<>();
        try{
            String 任务编号 = list.get(0);
            System.out.println(任务编号);
            //修改为强制取消
            物流任务表 wlrw = new 物流任务表();
            wlrw.set任务编号(任务编号);
            wlrw.set任务状态("3");
            物流任务表Dao.强制取消(wlrw);

            res.setFlag(true);
            res.setData(wlrw);
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
    public Result<物流任务表> 调拨(ERP单据明细表 ERP单据明细表) {
        Result<物流任务表> res = new Result<>();
        try {
            System.out.println(ERP单据明细表.get起始站点()+"--"+ERP单据明细表.get目的站点());
            ERP单据明细表 erp = new ERP单据明细表();
            erp.set起始站点(ERP单据明细表.get起始站点());
            erp.set目的站点(ERP单据明细表.get目的站点());
            List<ERP单据明细表> data = ERP单据明细表Dao.selectBySelective(erp);
            if(data.size() == 0 || data == null){
                res.setFlag(false);
                res.setMessage("单据错误");
            }
            if (ERP单据明细表.get起始站点().equals(data.get(0).get起始站点()) && ERP单据明细表.get目的站点().equals(data.get(0).get目的站点())) {
                //发布调拨任务
                insertAllocationTask(data);
                //预约出库
                updateBinStatus(data.get(0).get起始站点(), "O");
                //预约入库
                updateBinStatus(data.get(0).get目的站点(), "I");
            }else{
                res.setFlag(false);
                res.setMessage("站点错误");
            }
            res.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    //发布调拨任务
    public void insertAllocationTask(List<ERP单据明细表> data) {
        物流任务表 wl = new 物流任务表();
        String 任务编号 = makeTaskNo();
        wl.set任务编号(任务编号);
        wl.set单据编号(data.get(0).get单据编号());
        wl.set任务类型("E");
        wl.set任务状态("0");
        wl.set任务优先级("0");
        wl.set物料编号(data.get(0).get物料编号());
        wl.set物料名称(data.get(0).get物料名称());
        wl.set类型代码(data.get(0).get类型代码());
        wl.set类型名称(data.get(0).get类型名称());
        wl.set物料规格(data.get(0).get物料规格());
        wl.set起始站点(data.get(0).get起始站点());
        wl.set目的站点(data.get(0).get目的站点());
        wl.set批次(data.get(0).get批次());
        wl.set数量(data.get(0).get数量());
        wl.set备注("调拨");
        物流任务表Dao.insert(wl);
    }

    //入库任务
    @Transactional
    public void stockIn(){
        // 查询已完成的任务
        List<物流任务表> 物流任务表s = 物流任务表Dao.search完成();
        if(物流任务表s == null || 物流任务表s.size() == 0){
            return;
        }
        for(int i =0;i < 物流任务表s.size();i++){
            //判断任务状态
            if(物流任务表s.get(i).get任务状态().equals("2") || 物流任务表s.get(i).get任务状态().equals("4")){
                //根据条件查询单据
                ERP单据明细表 search = new ERP单据明细表();
                search.set单据编号(物流任务表s.get(i).get单据编号());
                search.set物料名称(物流任务表s.get(i).get物料名称());
                List<ERP单据明细表> data = ERP单据明细表Dao.selectBySelective(search);
                if(data == null || data.size() == 0){
                    return;
                }else {
                    if (data.get(0).get单据类型().equals("DJ1")) {
                        //修改库位信息
                        updateStockIn(物流任务表s.get(i), "1002");
                        //添加到历史表和删除任务
                        delectAndAddTask(物流任务表s.get(i));
                    } else if (data.get(0).get单据类型().equals("DJ7")) {
                        //修改库位信息
                        updateStockIn(物流任务表s.get(i), "1004");
                        //添加到历史表和删除任务
                        delectAndAddTask(物流任务表s.get(i));
                    }
                    //当任务全部完成时修改单据标识
                    updateFalg(物流任务表s.get(i), data.get(0));
                }
            }else if (物流任务表s.get(i).get任务状态().equals("3")) {
                //修改库存状态
                updateBinStatus(物流任务表s.get(i).get目的站点(), "_");
                //添加到历史表和删除任务
                delectAndAddTask(物流任务表s.get(i));
            }
        }
    }

    //出库任务
    @Transactional
    public void productOut(){
        //查询已完成的任务
        List<物流任务表> 物流任务表s = 物流任务表Dao.search完成();
        if(物流任务表s ==null || 物流任务表s.size() == 0){
            return;
        }
        for(int i =0;i < 物流任务表s.size();i++) {
            //判断任务状态
            if (物流任务表s.get(i).get任务状态().equals("2") || 物流任务表s.get(i).get任务状态().equals("4")) {
                //根据条件查询单据
                ERP单据明细表 search = new ERP单据明细表();
                search.set单据编号(物流任务表s.get(i).get单据编号());
                search.set物料名称(物流任务表s.get(i).get物料名称());
                List<ERP单据明细表> data = ERP单据明细表Dao.selectBySelective(search);
                if(data == null || data.size() == 0){
                    return;
                }else {
                    if (data.get(0).get单据类型().equals("DJ3")) {//判断单据类型
                        //添加到历史表和删除任务
                        delectAndAddTask(物流任务表s.get(i));
                    } else if (data.get(0).get单据类型().equals("DJ5") || data.get(0).get单据类型().equals("DJ6")) {
                        库存查询表 kc = new 库存查询表();
                        kc.set库位编号(物流任务表s.get(i).get起始站点());
                        库存查询表Dao.清空库位(kc);
                        //添加到历史表和删除任务
                        delectAndAddTask(物流任务表s.get(i));
                    }
                    //当任务全部完成后修改单据标识
                    updateFalg(物流任务表s.get(i), data.get(0));
                }
            } else if (物流任务表s.get(i).get任务状态().equals("3")) {
                //修改库存状态
                updateBinStatus(物流任务表s.get(i).get起始站点(), "$");
                //添加到历史表和删除任务
                delectAndAddTask(物流任务表s.get(i));
            }
        }
    }

    //调拨任务
    @Transactional
    public void allocation(){
        //查询已完成的任务
        List<物流任务表> 物流任务表s = 物流任务表Dao.search完成();
        if(物流任务表s ==null || 物流任务表s.size() == 0){
            return;
        }
        for(int i =0;i < 物流任务表s.size();i++) {
            //判断任务状态
            if (物流任务表s.get(i).get任务状态().equals("2") || 物流任务表s.get(i).get任务状态().equals("4")) {
                //根据条件查询单据
                ERP单据明细表 search = new ERP单据明细表();
                search.set单据编号(物流任务表s.get(i).get单据编号());
                search.set物料名称(物流任务表s.get(i).get物料名称());
                List<ERP单据明细表> data = ERP单据明细表Dao.selectBySelective(search);
                if(data == null || data.size() == 0){
                    return;
                }
                库存查询表 kc = new 库存查询表();
                kc.set库位编号(物流任务表s.get(i).get起始站点());
                List<库存查询表> barcode = 库存查询表Dao.selectByList(kc);
                if(barcode == null || barcode.size() == 0){
                    return;
                }
                if (data.get(0).get单据类型().equals("DJ4")) {//判断单据类型
                    //更改目的站点库存信息
                    allocationUpdateBin(物流任务表s.get(i), barcode.get(0));
                    //请空库位信息
                    kc.set库位编号(物流任务表s.get(i).get起始站点());
                    库存查询表Dao.清空库位(kc);
                    //添加到历史表和删除任务
                    delectAndAddTask(物流任务表s.get(i));
                    //当任务全部完成后修改单据标识
                    updateFalg(物流任务表s.get(i), data.get(0));
                }
            } else if (物流任务表s.get(i).get任务状态().equals("3")) {
                //修改库存状态
                updateBinStatus(物流任务表s.get(i).get起始站点(), "$");
                //修改库存状态
                updateBinStatus(物流任务表s.get(i).get目的站点(), "_");
                //添加到历史表和删除任务
                delectAndAddTask(物流任务表s.get(i));
            }
        }
    }

    //更改目的站点库存信息
    public 库存查询表 allocationUpdateBin(物流任务表 物流任务表, 库存查询表 barcode) {
        库存查询表 kc = new 库存查询表();
        kc.set物料代码(物流任务表.get物料编号());
        kc.set物料名称(物流任务表.get物料名称());
        kc.set类型代码(物流任务表.get类型代码());
        kc.set类型名称(物流任务表.get类型名称());
        kc.set库位编号(物流任务表.get目的站点());
        kc.set条码编号(barcode.get条码编号());
        kc.set库位状态(barcode.get库位状态());
        kc.set库位禁用(null);
        kc.set生产批次(物流任务表.get批次());
        kc.set物料规格(物流任务表.get物料规格());
        kc.set物料重量(物流任务表.get数量());
        库存查询表Dao.入库任务更改库位信息(kc);
        return kc;
    }

    //发布入库物流任务
    public void insertInTask(ERP单据明细表 ERP单据明细表, String 起始站点, String 任务编号, String 目的站点, String 类型代码) {
        物流任务表 wl = new 物流任务表();
        wl.set任务编号(任务编号);
        wl.set单据编号(ERP单据明细表.get单据编号());
        wl.set任务类型("T");
        wl.set任务状态("0");
        wl.set任务优先级("0");
        wl.set物料编号(ERP单据明细表.get物料编号());
        wl.set物料名称(ERP单据明细表.get物料名称());
        wl.set类型代码(类型代码);
        wl.set类型名称(ERP单据明细表.get类型名称());
        wl.set批次(ERP单据明细表.get批次());
        wl.set物料规格(ERP单据明细表.get物料规格());
        wl.set起始站点(起始站点);
        wl.set目的站点(目的站点);
        wl.set数量(ERP单据明细表.get数量());
        物流任务表Dao.insert(wl);
    }

    //发布出库物流任务
    public void insertOutTask(String 单据编号, List<库存查询表> 库存查询表s, String 目的站点, String 任务编号, String 起始站点) {
        物流任务表 wl = new 物流任务表();
        wl.set任务编号(任务编号);
        wl.set单据编号(单据编号);
        wl.set任务类型("O");
        wl.set任务状态("0");
        wl.set任务优先级("0");
        wl.set物料编号(库存查询表s.get(0).get物料代码());
        wl.set物料名称(库存查询表s.get(0).get物料名称());
        wl.set类型代码(库存查询表s.get(0).get类型代码());
        wl.set类型名称(库存查询表s.get(0).get类型名称());
        wl.set物料规格(库存查询表s.get(0).get物料规格());
        wl.set批次(库存查询表s.get(0).get生产批次());
        wl.set起始站点(起始站点);
        wl.set目的站点(目的站点);
        wl.set数量(库存查询表s.get(0).get物料重量());
        物流任务表Dao.insert(wl);
    }

    //修改库存状态
    public void updateBinStatus(String 目的站点, String 库位状态) {
        库存查询表 kc = new 库存查询表();
        kc.set库位编号(目的站点);
        kc.set库位状态(库位状态);
        库存查询表Dao.改为占用状态(kc);
    }

    //添加到历史表和删除任务
    public void delectAndAddTask(物流任务表 物流任务表) {
        物流任务表 wl = new 物流任务表();
        wl.set任务编号(物流任务表.get任务编号());
        物流任务表Dao.添加到历史表(wl);
        物流任务表Dao.删除任务(wl);
    }

    //入库任务更改库位信息
    public void updateStockIn(物流任务表 物流任务表, String 类型代码) {
        库存查询表 kc = new 库存查询表();
        kc.set物料代码(物流任务表.get物料编号());
        kc.set物料名称(物流任务表.get物料名称());
        kc.set类型代码(类型代码);
        kc.set类型名称(物流任务表.get类型名称());
        kc.set生产批次(物流任务表.get批次());
        kc.set库位编号(物流任务表.get目的站点());
        kc.set库位状态("Q");
        kc.set库位禁用(null);
        kc.set物料规格(物流任务表.get物料规格());
        kc.set物料重量(物流任务表.get数量());
        库存查询表Dao.入库任务更改库位信息(kc);
    }

    //修改单据标识
    public void updateFalg(物流任务表 物流任务表, ERP单据明细表 data) {
        物流任务表 wl = new 物流任务表();
        wl.set单据编号(物流任务表.get单据编号());
        List<物流任务表> 查询任务s = 物流任务表Dao.search单据编号(wl);
        if (查询任务s.size() == 0 || 查询任务s == null) {
            ERP单据明细表 update = new ERP单据明细表();
            update.set单据编号(物流任务表.get单据编号());
            update.set单据类型(data.get单据类型());
            update.set物料名称(物流任务表.get物料名称());
            ERP单据明细表Dao.修改单据标识(update);
        }
    }

    //任务编号自增时间加最后三位流水号的方法
    private String makeTaskNo()
    {
        if (SerialNumber < 9999) { //补0
            maxNum = String.format("%0" + 4 + "d", SerialNumber++);
        }
        return "TH"+new SimpleDateFormat("yyMMdd").format(new Date())+maxNum;
    }

}
