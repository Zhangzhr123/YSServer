package com.service;
/**
 * Created by zzr on 2019/07/09
 * 物流任务历史表Service
 */
import com.bean.Result;
import com.bean.User;
import com.bean.物流任务历史表;

import java.util.List;

public interface I物流任务历史表Service {

    public Result<物流任务历史表> create(物流任务历史表 物流任务历史表, User operator);

    public Result<物流任务历史表> delete(String userId, User operator);

    public Result<物流任务历史表> deleteAll(List<String> idList, User operator);

    public Result<物流任务历史表> update(物流任务历史表 物流任务历史表, User operator);

    public Result<物流任务历史表> updateSelective(物流任务历史表 物流任务历史表, User operator);

    public Result<物流任务历史表> getById(String objectId);

    public Result<List<物流任务历史表>> getAll();

    public Result<List<物流任务历史表>> search(物流任务历史表 物流任务历史表);

    public Result<Long> searchResultsCount(物流任务历史表 物流任务历史表);

    public Result<List<物流任务历史表>> searchWithPage(物流任务历史表 物流任务历史表);

    public Result<List<物流任务历史表>> searchLikeString(String userLikeString);

    public Result<List<物流任务历史表>> 抽检返架(物流任务历史表 物流任务历史表);

}
