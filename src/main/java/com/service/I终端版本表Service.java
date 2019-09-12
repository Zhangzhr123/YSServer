package com.service;

import com.bean.Result;
import com.bean.User;
import com.bean.终端版本表;

import java.util.List;

public interface I终端版本表Service {

    public Result<终端版本表> create(终端版本表 终端版本表, User operator);

    public Result<终端版本表> delete(String 终端版本表Id, User operator);

    public Result<终端版本表> deleteAll(List<String> idList, User operator);

    public Result<终端版本表> update(终端版本表 终端版本表, User operator);

    public Result<终端版本表> updateSelective(终端版本表 终端版本表, User operator);

    public Result<终端版本表> getById(String objectId);

    public Result<List<终端版本表>> getAll();

    public Result<List<终端版本表>> search(终端版本表 终端版本表);

    public Result<Long> searchResultsCount(终端版本表 终端版本表);

    public Result<List<终端版本表>> searchWithPage(终端版本表 终端版本表);

    public Result<终端版本表> 获取最新版本();
}
