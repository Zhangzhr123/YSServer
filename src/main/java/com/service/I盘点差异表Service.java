package com.service;
/**
 * Created by zzr on 2019/06/11
 * 盘点差异表service
 */
import com.bean.Result;
import com.bean.User;
import com.bean.盘点差异表;

import java.util.List;

public interface I盘点差异表Service {
    public Result<盘点差异表> create(盘点差异表 盘点差异表, User operator);

    public Result<盘点差异表> delete(String userId, User operator);

    public Result<盘点差异表> deleteAll(List<String> idList, User operator);

    public Result<盘点差异表> update(盘点差异表 盘点差异表, User operator);

    public Result<盘点差异表> updateSelective(盘点差异表 盘点差异表, User operator);

    public Result<盘点差异表> getById(String objectId);

    public Result<List<盘点差异表>> getAll();

    public Result<List<盘点差异表>> search(盘点差异表 盘点差异表);

    public Result<Long> searchResultsCount(盘点差异表 盘点差异表);

    public Result<List<盘点差异表>> searchWithPage(盘点差异表 盘点差异表);

    public Result<List<盘点差异表>> searchLikeString(String userLikeString);
}
