package com.service;

import com.bean.Result;
import com.bean.User;
import com.bean.ERP单据明细表;
import java.util.List;

public interface IERP单据明细表Service {

    public Result<ERP单据明细表> create(ERP单据明细表 ERP单据明细表, User operator);

    public Result<ERP单据明细表> delete(String userId, User operator);

    public Result<ERP单据明细表> deleteAll(List<String> idList, User operator);

    public Result<ERP单据明细表> update(ERP单据明细表 ERP单据明细表, User operator);

    public Result<ERP单据明细表> updateSelective(ERP单据明细表 ERP单据明细表, User operator);

    public Result<ERP单据明细表> getById(String objectId);

    public Result<List<ERP单据明细表>> getAll();

    public Result<List<ERP单据明细表>> search(ERP单据明细表 ERP单据明细表);

    public Result<Long> searchResultsCount(ERP单据明细表 ERP单据明细表);

    public Result<List<ERP单据明细表>> searchWithPage(ERP单据明细表 ERP单据明细表);

    public Result<List<ERP单据明细表>> searchLikeString(String userLikeString);

    public Result<List<ERP单据明细表>> 查询调拨单(ERP单据明细表 ERP单据明细表);

    public Result<List<ERP单据明细表>> 查询入库单据(ERP单据明细表 ERP单据明细表);

    public Result<List<ERP单据明细表>> 查询出库单据(ERP单据明细表 ERP单据明细表);

    public Result<ERP单据明细表> 修改单据标识(List<String> list);

    public Result<List<ERP单据明细表>> 展示单据(ERP单据明细表 ERP单据明细表);

    public Result<List<ERP单据明细表>> 完成入库(ERP单据明细表 ERP单据明细表);
}
