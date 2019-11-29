package com.service;
/**
 * Created by zzr on 2019/07/09
 * RecordsService
 */
import com.bean.Result;
import com.bean.User;
import com.bean.Records;

import java.util.List;

public interface IRecordsService {

    public Result<Records> create(Records Records, User operator);

    public Result<Records> delete(String userId, User operator);

    public Result<Records> deleteAll(List<String> idList, User operator);

    public Result<Records> update(Records Records, User operator);

    public Result<Records> updateSelective(Records Records, User operator);

    public Result<Records> getById(String objectId);

    public Result<List<Records>> getAll();

    public Result<List<Records>> search(Records Records);

    public Result<Long> searchResultsCount(Records Records);

    public Result<List<Records>> searchWithPage(Records Records);

    public Result<List<Records>> searchLikeString(String userLikeString);

    public Result<Records> updateType(String barCode);

    public Result<List<Records>> getList(String barCode);

}
