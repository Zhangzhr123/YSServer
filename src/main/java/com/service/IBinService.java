package com.service;
/**
 * Created by zzr on 2019/07/09
 * BinService
 */

import com.bean.Bin;
import com.bean.Result;
import com.bean.User;

import java.util.List;

public interface IBinService {

    public Result<Bin> updateNull(String barCode);

    public Result<List<Bin>> selectAll();

}
