package com.service;
/**
 * Created by zzr on 2019/07/08
 * I条码物料表Service
 */
import com.bean.Result;
import com.bean.User;
import com.bean.条码物料表;

import java.util.List;

public interface I条码物料表Service {


    public Result<条码物料表> create(条码物料表 条码物料表, User operator);

    public Result<条码物料表> delete(String userId, User operator);

    public Result<条码物料表> deleteAll(List<String> idList, User operator);

    public Result<条码物料表> update(条码物料表 条码物料表, User operator);

    public Result<条码物料表> updateSelective(条码物料表 条码物料表, User operator);

    public Result<条码物料表> getById(String objectId);

    public Result<List<条码物料表>> getAll();

    public Result<List<条码物料表>> search(条码物料表 条码物料表);

    public Result<Long> searchResultsCount(条码物料表 条码物料表);

    public Result<List<条码物料表>> searchWithPage(条码物料表 条码物料表);

    public Result<List<条码物料表>> searchLikeString(String userLikeString);

}
