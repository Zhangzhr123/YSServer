package com.service;
/**
 * Created by zzr on 2019/06/11
 * 仓库单据明细表service
 */
import com.bean.Result;
import com.bean.User;
import com.bean.仓库单据明细表;

import java.util.List;

public interface I仓库单据明细表Service {

    public Result<仓库单据明细表> create(仓库单据明细表 仓库单据明细表, User operator);

    public Result<仓库单据明细表> delete(String userId, User operator);

    public Result<仓库单据明细表> deleteAll(List<String> idList, User operator);

    public Result<仓库单据明细表> update(仓库单据明细表 仓库单据明细表, User operator);

    public Result<仓库单据明细表> updateSelective(仓库单据明细表 仓库单据明细表, User operator);

    public Result<仓库单据明细表> getById(String objectId);

    public Result<List<仓库单据明细表>> getAll(String operator);

    public Result<List<仓库单据明细表>> search(仓库单据明细表 仓库单据明细表);

    public Result<Long> searchResultsCount(仓库单据明细表 仓库单据明细表);

    public Result<List<仓库单据明细表>> searchWithPage(仓库单据明细表 仓库单据明细表);

    public Result<List<仓库单据明细表>> search物料编号(仓库单据明细表 仓库单据明细表);

    public Result<List<仓库单据明细表>> searchAll(仓库单据明细表 仓库单据明细表);
}
