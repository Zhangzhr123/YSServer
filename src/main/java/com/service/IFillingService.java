package com.service;
/**
 * Created by zzr on 2019/06/11
 * 用户表service
 */

import com.bean.Company;
import com.bean.Filling;
import com.bean.Result;
import com.bean.User;

import java.util.List;

public interface IFillingService {

	public Result<Filling> create(Filling filling, User operator);

	public Result<Filling> delete(String fillingId, User operator);

	public Result<Filling> deleteAll(List<String> idList, User operator);

	public Result<Filling> update(Filling filling, User operator);

	public Result<Filling> getById(String objectId);

	public Result<List<Filling>> getAll();

	public Result<List<Filling>> search(Filling filling);

	public Result<Long> searchResultsCount(Filling filling);

	public Result<List<Filling>> setListData(List<Filling> listFilling);

}
