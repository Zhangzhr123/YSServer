package com.service;
/**
 * Created by zzr on 2019/06/11
 * 仓库单据表service
 */
import com.bean.Result;
import com.bean.User;
import com.bean.仓库单据表;

import java.util.List;

public interface I仓库单据表Service {

    public Result<仓库单据表> create(仓库单据表 仓库单据表, User operator);

    public Result<仓库单据表> delete(String userId, User operator);

    public Result<仓库单据表> deleteAll(List<String> idList, User operator);

    public Result<仓库单据表> update(仓库单据表 仓库单据表, User operator);

    public Result<仓库单据表> updateSelective(仓库单据表 仓库单据表, User operator);

    public Result<仓库单据表> getById(String objectId);

    public Result<List<仓库单据表>> getAll();

    public Result<List<仓库单据表>> search(仓库单据表 仓库单据表);

    public Result<Long> searchResultsCount(仓库单据表 仓库单据表);

    public Result<List<仓库单据表>> searchWithPage(仓库单据表 仓库单据表);

    public Result<List<仓库单据表>> searchLikeString(String userLikeString);
}
