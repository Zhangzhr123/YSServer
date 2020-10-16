package com.utils;

public interface PathUtil {

    //钉钉AgentId 正式
    public static final String AgentId = "763436042";
    //钉钉AppKey  正式
    public static final String AppKey = "dingxigqmxvneops7uce";
    //钉钉AppSecret  正式
    public static final String AppSecret = "8oFKGdkjk850jKtp1UmNwObfot-9F74_LNQ5e2Onkem88RiVRdA7iv4l_OXqQ_5U";
    //云枢AppKey  测试
//    public static final String AppKey = "dingf9opadn3615tjbdy";
    //云枢AppSecret  测试
//    public static final String AppSecret = "uKW-Z9Ogls-ILWS8pZVzHTb2PCYf--CEIUFQYZPq8CNavK_XekZbvPXgJ1G5XnQ_";
    //获取token
    public static final String TokenUrl = "https://oapi.dingtalk.com/gettoken";
    //获取所有部门List
    public static final String GetDepartmentList = "https://oapi.dingtalk.com/department/list";
    //根据部门ID获取所有子部门
    public static final String GetDepartmentListByID = "https://oapi.dingtalk.com/department/list_ids";
    //获取部门所有上级部门包括本部门
    public static final String GetDepaetmentIDByID = "https://oapi.dingtalk.com/department/list_parent_depts_by_dept";
    //获取部门
    public static final String GetDepartment = "https://oapi.dingtalk.com/department/get";
    //创建部门
    public static final String CreateDepartment = "https://oapi.dingtalk.com/department/create";
    //修改部门
    public static final String UpdateDepartment = "https://oapi.dingtalk.com/department/update";
    //删除部门
    public static final String DeleteDepartment = "https://oapi.dingtalk.com/department/delete";
    //根据工号获取用户id
    public static final String GetUseridByUnionid = "https://oapi.dingtalk.com/user/getUseridByUnionid";
    //获取用户
    public static final String GetEmployee = "https://oapi.dingtalk.com/user/get";
    //创建用户
    public static final String CreateEmployee = "https://oapi.dingtalk.com/user/create";
    //修改用户
    public static final String UpdateEmployee = "https://oapi.dingtalk.com/user/update";
    //删除用户
    public static final String DeleteEmployee = "https://oapi.dingtalk.com/user/delete";
    //批量删除用户
    public static final String BatchDeleteEmployee = "https://oapi.dingtalk.com/user/batchdelete";
    //根据部门id获取用户
    public static final String GetByDepartmentIdForSimpleList = "https://oapi.dingtalk.com/user/simplelist";
    //根据部门id批量获取用户
    public static final String GetByDepartmentIdForUserInfoList = "https://oapi.dingtalk.com/user/list";
    //根据部门id获取admin
    public static final String GetByDepartmentIdForAdmin = "https://oapi.dingtalk.com/user/get_admin";

}
