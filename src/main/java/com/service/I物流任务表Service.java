package com.service;
/**
 * Created by zzr on 2019/06/11
 * 物流任务表service
 */
import com.bean.ERP单据明细表;
import com.bean.Result;
import com.bean.User;
import com.bean.物流任务表;

import java.util.List;

public interface I物流任务表Service {

    public Result<物流任务表> create(物流任务表 物流任务表, User operator);

    public Result<物流任务表> delete(String userId, User operator);

    public Result<物流任务表> deleteAll(List<String> idList, User operator);

    public Result<物流任务表> update(物流任务表 物流任务表, User operator);

    public Result<物流任务表> updateSelective(物流任务表 物流任务表, User operator);

    public Result<物流任务表> getById(String objectId);

    public Result<List<物流任务表>> getAll();

    public Result<List<物流任务表>> search(物流任务表 物流任务表);

    public Result<Long> searchResultsCount(物流任务表 物流任务表);

    public Result<List<物流任务表>> searchWithPage(物流任务表 物流任务表);

    public Result<List<物流任务表>> searchLikeString(String userLikeString);

    public Result<物流任务表> 原料发布入库任务(ERP单据明细表 ERP单据明细表);

    public Result<物流任务表> 发布出库任务(ERP单据明细表 ERP单据明细表);

    public Result<List<物流任务表>> search任务(物流任务表 物流任务表);

    public Result<List<物流任务表>> 获取任务信息(List<String> list);

    public Result<物流任务表> 强制执行(List<String> list);

    public Result<物流任务表> 强制取消(List<String> list);

    public Result<物流任务表> 调拨(ERP单据明细表 ERP单据明细表);

    public void stockIn();

    public void productOut();

    public void allocation();

}
