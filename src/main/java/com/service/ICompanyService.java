package com.service;
/**
 * Created by zzr on 2019/06/11
 * 用户表service
 */

import com.bean.Company;
import com.bean.Result;
import com.bean.User;

import java.util.List;

public interface ICompanyService {

	public Result<Company> create(Company company, User operator);

	public Result<Company> delete(String companyId, User operator);

	public Result<Company> deleteAll(List<String> idList, User operator);

	public Result<Company> update(Company company, User operator);

	public Result<Company> getById(String objectId);

	public Result<List<Company>> getAll();

	public Result<List<Company>> search(Company company);

	public Result<Long> searchResultsCount(Company company);

}
