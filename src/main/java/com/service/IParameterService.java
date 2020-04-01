package com.service;
/**
 * Created by zzr on 2019/06/11
 * 用户表service
 */

import com.bean.Result;
import com.bean.Parameter;
import com.bean.User;

import java.util.List;

public interface IParameterService {

	public Result<Parameter> create(Parameter parameter, User operator);
	
	public Result<Parameter> delete(String parameterId, User operator);

	public Result<Parameter> deleteAll(List<String> idList, User operator);
	
	public Result<Parameter> update(Parameter parameter, User operator);

	public Result<Parameter> getById(String objectId);

	public Result<List<Parameter>> getAll();

	public Result<List<Parameter>> search(Parameter parameter);

}
