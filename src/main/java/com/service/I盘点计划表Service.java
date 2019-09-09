package com.service;
/**
 * Created by zzr on 2019/06/11
 * 盘点计划表service
 */
import com.bean.Result;
import com.bean.User;
import com.bean.盘点计划表;

import java.util.List;

public interface I盘点计划表Service {

    public Result<盘点计划表> create(盘点计划表 盘点计划表, User operator);

    public Result<盘点计划表> delete(String userId, User operator);

    public Result<盘点计划表> deleteAll(List<String> idList, User operator);

    public Result<盘点计划表> update(盘点计划表 盘点计划表, User operator);

    public Result<盘点计划表> updateSelective(盘点计划表 盘点计划表, User operator);

    public Result<盘点计划表> getById(String objectId);

    public Result<List<盘点计划表>> getAll();

    public Result<List<盘点计划表>> search(盘点计划表 盘点计划表);

    public Result<Long> searchResultsCount(盘点计划表 盘点计划表);

    public Result<List<盘点计划表>> searchWithPage(盘点计划表 盘点计划表);

    public Result<List<盘点计划表>> searchAll(盘点计划表 盘点计划表);

    public Result<List<盘点计划表>> search计划编号(盘点计划表 盘点计划表);

    public Result<盘点计划表> 修改完成程度(盘点计划表 盘点计划表);

    public Result<盘点计划表> 已完成(盘点计划表 盘点计划表);
}
