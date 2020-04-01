package com.service;
/**
 * Created by zzr on 2019/06/11
 * 用户表service
 */

import com.bean.Cylinder;
import com.bean.Result;
import com.bean.User;

import java.util.List;

public interface ICylinderService {

	public Result<Cylinder> create(Cylinder cylinder, User operator);

	public Result<Cylinder> delete(String cylinderId, User operator);

	public Result<Cylinder> deleteAll(List<String> idList, User operator);

	public Result<Cylinder> update(Cylinder cylinder, User operator);

	public Result<Cylinder> getById(String objectId);

	public Result<List<Cylinder>> getAll();

	public Result<List<Cylinder>> search(Cylinder cylinder);

	public Result<Long> searchResultsCount(Cylinder cylinder);

	public Result<Cylinder> selsectByKey(Cylinder cylinder);
}
