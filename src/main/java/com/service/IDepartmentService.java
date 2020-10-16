package com.service;
/**
 * Created by zzr on 2019/06/11
 * 用户表service
 */

import com.bean.Depart;
import com.bean.DepartmentEntity;
import com.bean.GetDepartList;
import com.bean.Result;

import java.util.List;
import java.util.Map;

public interface IDepartmentService {

	public Result<List<Depart>> updateGBMDepartmentList();

	public Result<List<DepartmentEntity>> updateDepartmentList();

	public Result<List<Depart>> deleteDepartmentList();

}
