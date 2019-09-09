package com.service;
/**
 * Created by zzr on 2019/06/11
 * 库存查询表service
 */
import com.bean.Result;
import com.bean.User;
import com.bean.库存查询表;

import java.util.List;

public interface I库存查询表Service {

    public Result<库存查询表> create(库存查询表 库存查询表, User operator);

    public Result<库存查询表> delete(String userId, User operator);

    public Result<库存查询表> deleteAll(List<String> idList, User operator);

    public Result<库存查询表> update(库存查询表 库存查询表, User operator);

    public Result<库存查询表> updateSelective(库存查询表 库存查询表, User operator);

    public Result<库存查询表> getById(String objectId);

    public Result<List<库存查询表>> getAll();

    public Result<List<库存查询表>> search(库存查询表 库存查询表);

    public Result<Long> searchResultsCount(库存查询表 库存查询表);

    public Result<List<库存查询表>> searchWithPage(库存查询表 库存查询表);

    public Result<List<库存查询表>> searchAll(库存查询表 库存查询表);

    public Result<库存查询表> 修改库存状态(库存查询表 库存查询表);
}
