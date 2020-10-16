package com.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bean.*;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.service.IUserService;
import com.taobao.api.ApiException;
import com.utils.PathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private com.dao.UserDao UserDao;
    @Autowired
    private com.dao.DepartmentDao departmentDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * creatby zhangzhr
     * createdDate 2020/08/11
     * <p>
     * 同步BPM的人员到钉钉
     * 分别查询BPM和钉钉的部门并且展示部门全称，并添加到集合中
     * 根据部门全称查询BPM所在部门下的人员，如果存在人员则对应查询钉钉部门下的人员
     * 将BPM和钉钉对应部门中的人员获取并添加到集合中，根据姓名判断BPM中的人员是否在钉钉中，如果不存在则增加
     * 如果钉钉对应部门中存在BPM对应部门中不存在的人员则删除此人员
     * 如果钉钉中的部门在BPM中不存在则删除此部门下的人员及部门
     */
    @Override
    public Result<Map<String, String>> updateUserList() {
        Result<Map<String, String>> res = new Result<>();
        try {
            String accessToken = getAccessToken();
            //查询BPM所有部门
            List<Depart> data = departmentDao.selectDepartment();
            //判断BPM是否存在部门
            if (data != null || data.size() > 0) {
                //查询钉钉所有部门
                DingTalkClient client = new DefaultDingTalkClient(PathUtil.GetDepartmentList);
                OapiDepartmentListRequest request = new OapiDepartmentListRequest();
//                request.setId("305277311");
                request.setHttpMethod("GET");
                OapiDepartmentListResponse response = client.execute(request, accessToken);
                JSONObject json = (JSONObject) JSONObject.toJSON(response);
                GetDepartList getDepartList = JSONObject.toJavaObject(json, GetDepartList.class);
                System.out.println(getDepartList);
                //判断钉钉是否存在部门
                if (getDepartList.getDepartment() != null && getDepartList.getDepartment().size() > 0) {
                    //添加钉钉的id和部门名称
                    Map<String, String> departmentMap = new HashMap<String, String>();
                    //添加钉钉的部门ID
                    List<String> idList = new ArrayList<>();
                    //循环添加钉钉的部门ID和部门全称
                    for (int i = 0; i < getDepartList.getDepartment().size(); i++) {
                        String departName = getDepartAllName(getDepartList.getDepartment().get(i).getId());
                        departmentMap.put(getDepartList.getDepartment().get(i).getId(), departName);
                        idList.add(getDepartList.getDepartment().get(i).getId());
                    }
//                    departmentMap.put("305277311", "信息部");
//                    idList.add("305277311");
                    System.out.println(departmentMap);
                    System.out.println(idList);

                    //循环遍历查询部门并查询部门下的人员列表
                    for (int j = 0; j < idList.size(); j++) {
                        //判断是否是信息部外协供应商
                        if (!(departmentMap.get(idList.get(j))).contains("信息部/外协供应商")) {
                            //BPM部门下的人员列表
                            List<User> userListByName = UserDao.selectUserByDepartName(departmentMap.get(idList.get(j)));
                            System.out.println(userListByName);
                            //判断BPM对应钉钉部门是否存在人员
                            if (userListByName != null && userListByName.size() > 0) {
                                //钉钉对应BPM部门下的人员列表
                                DingTalkClient client3 = new DefaultDingTalkClient(PathUtil.GetByDepartmentIdForSimpleList);
                                OapiUserSimplelistRequest request3 = new OapiUserSimplelistRequest();
                                request3.setDepartmentId(Long.valueOf(idList.get(j)));
                                request3.setHttpMethod("GET");
                                OapiUserSimplelistResponse response3 = client3.execute(request3, accessToken);
                                System.out.println(response3.getBody());
                                JSONObject json3 = (JSONObject) JSONObject.toJSON(response3);
                                EmployeeListResult employeeListResult = JSONObject.toJavaObject(json3, EmployeeListResult.class);
                                System.out.println(employeeListResult);
                                //循环添加钉钉部门人员姓名
                                List<String> ddUsetName = new ArrayList<>();
                                for (int i = 0; i < employeeListResult.getUserlist().size(); i++) {
                                    ddUsetName.add(employeeListResult.getUserlist().get(i).getName());
                                }
                                System.out.println(ddUsetName);
                                //循环添加BPM部门人员姓名
                                List<String> bpmUsetName = new ArrayList<>();
                                for (int i = 0; i < userListByName.size(); i++) {
                                    bpmUsetName.add(userListByName.get(i).getName());
                                }
                                System.out.println(bpmUsetName);
                                //如果BPM中的人员不存在钉钉中则增加此人员
                                for (int i = 0; i < userListByName.size(); i++) {
                                    String usetName = userListByName.get(i).getName();
                                    if (!ddUsetName.contains(usetName)) {
                                        //调用接口创建人员
                                        DingTalkClient dd = new DefaultDingTalkClient(PathUtil.CreateEmployee);
                                        OapiUserCreateRequest oc = new OapiUserCreateRequest();
                                        oc.setMobile(userListByName.get(i).getMobile());
                                        oc.setName(userListByName.get(i).getName());
                                        oc.setEmail(userListByName.get(i).getEmail());
                                        oc.setJobnumber(userListByName.get(i).getEmployeeNumber());
                                        //部门ID 需要用字符串， "[100,200]" 这种格式
                                        List<Long> departments = new ArrayList<Long>();
                                        departments.add(Long.valueOf(idList.get(j)));
                                        oc.setDepartment(JSON.toJSONString(departments));
                                        //调用接口
                                        OapiUserCreateResponse resp = dd.execute(oc, accessToken);
                                        JSONObject deJson = (JSONObject) JSONObject.toJSON(resp);
                                        EmployeeResult employeeResult = JSONObject.toJavaObject(deJson, EmployeeResult.class);
                                        System.out.println(employeeResult);
                                        //判断人员是否存在，如果存在则调整所在部门
                                        if (employeeResult.getErrcode().contains("60104") && employeeResult.getUserid() != null) {
                                            DingTalkClient clientup = new DefaultDingTalkClient(PathUtil.UpdateEmployee);
                                            OapiUserUpdateRequest requestup = new OapiUserUpdateRequest();
                                            requestup.setUserid(employeeResult.getUserid());
                                            List<Long> updepart = new ArrayList<Long>();
                                            updepart.add(Long.valueOf(idList.get(j)));
                                            requestup.setDepartment(updepart);
                                            OapiUserUpdateResponse responseup = clientup.execute(requestup, accessToken);
                                            JSONObject upJson = (JSONObject) JSONObject.toJSON(responseup);
                                            ErrorResult errorResult = JSONObject.toJavaObject(upJson, ErrorResult.class);
                                            System.out.println(errorResult);
                                        }
                                    }
                                }
                                //判断钉钉中是否包含BPM的人员，如果不包含则删除
//                                for (int i = 0; i < ddUsetName.size(); i++) {
//                                    if (!bpmUsetName.contains(ddUsetName.get(i))) {
//                                        //判断次人员是否在BPM组织中
//                                        List<User> usernameData = UserDao.selectUserByUserName(ddUsetName.get(i));
//                                        if (usernameData == null || usernameData.size() <= 0) {
//                                            for (int k = 0; k < employeeListResult.getUserlist().size(); k++) {
//                                                if ((employeeListResult.getUserlist().get(k).getName()).equals(ddUsetName.get(i))) {
//                                                    DingTalkClient dtcDE = new DefaultDingTalkClient(PathUtil.DeleteEmployee);
//                                                    OapiUserDeleteRequest deRequest = new OapiUserDeleteRequest();
//                                                    deRequest.setUserid(employeeListResult.getUserlist().get(k).getUserid());
//                                                    deRequest.setHttpMethod("GET");
//                                                    OapiUserDeleteResponse deResponse = dtcDE.execute(deRequest, accessToken);
//                                                    JSONObject deJson = (JSONObject) JSONObject.toJSON(deResponse);
//                                                    ErrorResult errorResult = JSONObject.toJavaObject(deJson, ErrorResult.class);
//                                                    System.out.println(errorResult);
//                                                }
//                                            }
//                                        }
//
//                                    }
//                                }

                            }
                            System.out.println(userListByName);
                        }
                        System.out.println(departmentMap.get(idList.get(j)));
                    }

                    res.setFlag(true);
                    res.setData(departmentMap);
                    res.setMessage("Success");

                } else {
                    res.setFlag(false);
                    res.setMessage("钉钉部门为空");
                    return res;
                }

            } else {
                res.setFlag(false);
                res.setMessage("BPM部门为空");
                return res;
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    /**
     * creatby zhangzhr
     * createdDate 2020/08/11
     * <p>
     * 同步BPM根目录下的人员到钉钉
     * 分别查询BPM和钉钉根目录下的人员，获取ID和姓名判断
     * 如果钉钉中存在BPM没有的人员进行删除，如果BPM中存在钉钉没有的人员进行增加
     */
    @Override
    public Result<List<User>> updateBPMGMLUser() {
        Result<List<User>> res = new Result<>();
        try {
            String accessToken = getAccessToken();
            //获取BPM软控根部录下的人员
            List<User> userList = UserDao.selectRKGMLUser();
            //判断BPM根目录下是否存在人员
            if (userList != null && userList.size() > 0) {
                //获取钉钉根部门的人员信息
                DingTalkClient client4 = new DefaultDingTalkClient(PathUtil.GetByDepartmentIdForSimpleList);
                OapiUserSimplelistRequest request4 = new OapiUserSimplelistRequest();
                request4.setDepartmentId(Long.valueOf(1));
                request4.setHttpMethod("GET");
                OapiUserSimplelistResponse response4 = client4.execute(request4, accessToken);
                System.out.println(response4.getBody());
                JSONObject json4 = (JSONObject) JSONObject.toJSON(response4);
                EmployeeListResult employeeListResult = JSONObject.toJavaObject(json4, EmployeeListResult.class);
                System.out.println(employeeListResult);
                //获取bpm用户姓名
                List<String> bpmNameList = new ArrayList<>();
                for (int i = 0; i < userList.size(); i++) {
                    bpmNameList.add(userList.get(i).getName());
                }
                //获取钉钉用户姓名
                List<String> ddNameList = new ArrayList<>();
                if (employeeListResult.getUserlist() != null && employeeListResult.getUserlist().size() > 0) {
                    for (int i = 0; i < employeeListResult.getUserlist().size(); i++) {
                        ddNameList.add(employeeListResult.getUserlist().get(i).getName());
                    }

                    //判断bpm是否不含钉钉用户，如果不含则增加
                    for (int j = 0; j < bpmNameList.size(); j++) {
                        if (!ddNameList.contains(bpmNameList.get(j))) {
                            for (int k = 0; k < userList.size(); k++) {
                                if ((userList.get(k).getName()).equals(bpmNameList.get(j))) {
                                    //调用接口创建人员
                                    DingTalkClient dd = new DefaultDingTalkClient(PathUtil.CreateEmployee);
                                    OapiUserCreateRequest oc = new OapiUserCreateRequest();
                                    oc.setMobile(userList.get(k).getMobile());
                                    oc.setName(userList.get(k).getName());
                                    oc.setEmail(userList.get(k).getEmail());
                                    oc.setJobnumber(userList.get(k).getEmployeeNumber());
                                    List<Long> departments = new ArrayList<Long>();
                                    departments.add(Long.valueOf("1"));
                                    oc.setDepartment(JSON.toJSONString(departments));
                                    //调用接口
                                    OapiUserCreateResponse resp = dd.execute(oc, accessToken);
                                    JSONObject deJson = (JSONObject) JSONObject.toJSON(resp);
                                    EmployeeResult employeeResult = JSONObject.toJavaObject(deJson, EmployeeResult.class);
                                    System.out.println(employeeResult);
                                    //判断人员是否存在，如果存在则调整所在部门
                                    if (employeeResult.getErrcode().contains("60104") && employeeResult.getUserid() != null) {
                                        DingTalkClient clientup = new DefaultDingTalkClient(PathUtil.UpdateEmployee);
                                        OapiUserUpdateRequest requestup = new OapiUserUpdateRequest();
                                        requestup.setUserid(employeeResult.getUserid());
                                        List<Long> updepart = new ArrayList<Long>();
                                        updepart.add(Long.valueOf("1"));
                                        requestup.setDepartment(updepart);
                                        OapiUserUpdateResponse responseup = clientup.execute(requestup, accessToken);
                                        JSONObject upJson = (JSONObject) JSONObject.toJSON(responseup);
                                        ErrorResult errorResult = JSONObject.toJavaObject(upJson, ErrorResult.class);
                                        System.out.println(errorResult);
                                    }
                                }
                            }
                        }
                    }

                    //判断钉钉中是否包含BPM的人员，如果不包含则删除
//                for (int i = 0; i < ddNameList.size(); i++) {
//                    if (!bpmNameList.contains(ddNameList.get(i))) {
//                        //判断人员是否在BPM组织中
//                        List<User> usernameData = UserDao.selectUserByUserName(ddNameList.get(i));
//                        if (usernameData == null || usernameData.size() <= 0) {
//                            for (int k = 0; k < employeeListResult.getUserlist().size(); k++) {
//                                if ((employeeListResult.getUserlist().get(k).getName()).equals(ddNameList.get(i))) {
//                                    DingTalkClient dtcDE = new DefaultDingTalkClient(PathUtil.DeleteEmployee);
//                                    OapiUserDeleteRequest deRequest = new OapiUserDeleteRequest();
//                                    deRequest.setUserid(employeeListResult.getUserlist().get(k).getUserid());
//                                    deRequest.setHttpMethod("GET");
//                                    OapiUserDeleteResponse deResponse = dtcDE.execute(deRequest, accessToken);
//                                    JSONObject deJson = (JSONObject) JSONObject.toJSON(deResponse);
//                                    ErrorResult errorResult = JSONObject.toJavaObject(deJson, ErrorResult.class);
//                                    System.out.println(errorResult);
//                                }
//                            }
//                        }
//
//                    }
//                }


                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    /**
     * creatby zhangzhr
     * createdDate 2020/08/11
     * <p>
     * 删除钉钉人员
     * 分别查询BPM和钉钉的部门并且展示部门全称，并添加到集合中
     * 根据部门全称查询BPM所在部门下的人员
     * 将BPM和钉钉对应部门中的人员获取并添加到集合中，根据姓名判断BPM中的人员是否在钉钉中
     * 如果钉钉对应部门中存在BPM对应部门中不存在的人员则删除此人员
     */
    @Override
    public Result<Map<String, String>> deleteUserList() {
        Result<Map<String, String>> res = new Result<>();
        try {
            String accessToken = getAccessToken();
            //查询BPM所有部门
            List<Depart> data = departmentDao.selectDepartment();
            //判断BPM是否存在部门
            if (data != null || data.size() > 0) {
                //查询钉钉所有部门
                DingTalkClient client = new DefaultDingTalkClient(PathUtil.GetDepartmentList);
                OapiDepartmentListRequest request = new OapiDepartmentListRequest();
//                request.setId("305277311");
                request.setHttpMethod("GET");
                OapiDepartmentListResponse response = client.execute(request, accessToken);
                JSONObject json = (JSONObject) JSONObject.toJSON(response);
                GetDepartList getDepartList = JSONObject.toJavaObject(json, GetDepartList.class);
                System.out.println(getDepartList);
                //判断钉钉是否存在部门
                if (getDepartList.getDepartment() != null && getDepartList.getDepartment().size() > 0) {
                    //添加钉钉的id和部门名称
                    Map<String, String> departmentMap = new HashMap<String, String>();
                    //添加钉钉的部门ID
                    List<String> idList = new ArrayList<>();
                    //循环添加钉钉的部门ID和部门全称
                    for (int i = 0; i < getDepartList.getDepartment().size(); i++) {
                        String departName = getDepartAllName(getDepartList.getDepartment().get(i).getId());
                        departmentMap.put(getDepartList.getDepartment().get(i).getId(), departName);
                        idList.add(getDepartList.getDepartment().get(i).getId());
                    }
//                    departmentMap.put("305277311", "信息部");
//                    idList.add("305277311");
                    System.out.println(departmentMap);
                    System.out.println(idList);

                    //循环遍历查询部门并查询部门下的人员列表
                    for (int j = 0; j < idList.size(); j++) {
                        System.out.println(departmentMap.get(idList.get(j)));
                        //判断是否是信息部外协供应商
                        if (!(departmentMap.get(idList.get(j))).contains("信息部/外协供应商")) {
                            //BPM部门下的人员列表
                            List<User> userListByName = UserDao.selectUserByDepartName(departmentMap.get(idList.get(j)));
                            System.out.println(userListByName);
                            //判断BPM对应钉钉部门是否存在人员
                            if (userListByName != null && userListByName.size() > 0) {
                                //钉钉对应BPM部门下的人员列表
                                DingTalkClient client3 = new DefaultDingTalkClient(PathUtil.GetByDepartmentIdForSimpleList);
                                OapiUserSimplelistRequest request3 = new OapiUserSimplelistRequest();
                                request3.setDepartmentId(Long.valueOf(idList.get(j)));
                                request3.setHttpMethod("GET");
                                OapiUserSimplelistResponse response3 = client3.execute(request3, accessToken);
                                System.out.println(response3.getBody());
                                JSONObject json3 = (JSONObject) JSONObject.toJSON(response3);
                                EmployeeListResult employeeListResult = JSONObject.toJavaObject(json3, EmployeeListResult.class);
                                System.out.println(employeeListResult);
                                //循环添加钉钉部门人员姓名
                                List<String> ddUsetName = new ArrayList<>();
                                for (int i = 0; i < employeeListResult.getUserlist().size(); i++) {
                                    ddUsetName.add(employeeListResult.getUserlist().get(i).getName());
                                }
                                System.out.println(ddUsetName);
                                //循环添加BPM部门人员姓名
                                List<String> bpmUsetName = new ArrayList<>();
                                for (int i = 0; i < userListByName.size(); i++) {
                                    bpmUsetName.add(userListByName.get(i).getName());
                                }
                                System.out.println(bpmUsetName);
                                //判断钉钉中是否包含BPM的人员，如果不包含则删除
                                for (int i = 0; i < ddUsetName.size(); i++) {
                                    if (!bpmUsetName.contains(ddUsetName.get(i))) {
                                        //判断次人员是否在BPM组织中
                                        List<User> usernameData = UserDao.selectUserByUserName(ddUsetName.get(i));
                                        System.out.println(usernameData);
                                        if (usernameData == null || usernameData.size() <= 0) {
                                            for (int k = 0; k < employeeListResult.getUserlist().size(); k++) {
                                                if ((employeeListResult.getUserlist().get(k).getName()).equals(ddUsetName.get(i))) {
                                                    System.out.println(employeeListResult.getUserlist().get(k));
                                                    DingTalkClient dtcDE = new DefaultDingTalkClient(PathUtil.DeleteEmployee);
                                                    OapiUserDeleteRequest deRequest = new OapiUserDeleteRequest();
                                                    deRequest.setUserid(employeeListResult.getUserlist().get(k).getUserid());
                                                    deRequest.setHttpMethod("GET");
                                                    OapiUserDeleteResponse deResponse = dtcDE.execute(deRequest, accessToken);
                                                    JSONObject deJson = (JSONObject) JSONObject.toJSON(deResponse);
                                                    ErrorResult errorResult = JSONObject.toJavaObject(deJson, ErrorResult.class);
                                                    System.out.println(errorResult);
                                                }
                                            }
                                        }

                                    }
                                }

                            }
                            System.out.println(userListByName);
                        }
                        System.out.println(departmentMap.get(idList.get(j)));
                    }

                    res.setFlag(true);
                    res.setData(departmentMap);
                    res.setMessage("Success");

                } else {
                    res.setFlag(false);
                    res.setMessage("钉钉部门为空");
                    return res;
                }

            } else {
                res.setFlag(false);
                res.setMessage("BPM部门为空");
                return res;
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    //获取钉钉部门全称
    public String getDepartAllName(String id) {
        String accessToken = getAccessToken();
        String departAllName = "";
        if (id != null) {
            try {
                DingTalkClient client = new DefaultDingTalkClient(PathUtil.GetDepaetmentIDByID);
                OapiDepartmentListParentDeptsByDeptRequest request = new OapiDepartmentListParentDeptsByDeptRequest();
                request.setId(id);
                request.setHttpMethod("GET");
                OapiDepartmentListParentDeptsByDeptResponse response = client.execute(request, accessToken);
                JSONObject json = (JSONObject) JSONObject.toJSON(response);
                ParentIDListResult parentIDListResult = JSONObject.toJavaObject(json, ParentIDListResult.class);
                System.out.println(parentIDListResult);

                if (parentIDListResult.getParentIds() != null && parentIDListResult.getParentIds().length > 0) {
                    if (parentIDListResult.getParentIds().length > 1) {
                        for (int i = parentIDListResult.getParentIds().length - 2; i >= 0; i--) {
                            //获取部门信息
                            DingTalkClient client2 = new DefaultDingTalkClient(PathUtil.GetDepartment);
                            OapiDepartmentGetRequest request2 = new OapiDepartmentGetRequest();
                            request2.setId(parentIDListResult.getParentIds()[i]);
                            request2.setHttpMethod("GET");
                            OapiDepartmentGetResponse response2 = client2.execute(request2, accessToken);
                            JSONObject json2 = (JSONObject) JSONObject.toJSON(response2);
                            DepartmentEntity departmentEntity = JSONObject.toJavaObject(json2, DepartmentEntity.class);
                            System.out.println(departmentEntity);
                            if (parentIDListResult.getParentIds().length == 1) {
                                departAllName = departmentEntity.getName();
                            } else {
                                if (i == 0) {
                                    departAllName += departmentEntity.getName();
                                } else {
                                    departAllName += departmentEntity.getName() + "/";
                                }
                            }
                        }
                    } else {
                        for (int i = parentIDListResult.getParentIds().length - 1; i >= 0; i--) {
                            //获取部门信息
                            DingTalkClient client2 = new DefaultDingTalkClient(PathUtil.GetDepartment);
                            OapiDepartmentGetRequest request2 = new OapiDepartmentGetRequest();
                            request2.setId(parentIDListResult.getParentIds()[i]);
                            request2.setHttpMethod("GET");
                            OapiDepartmentGetResponse response2 = client2.execute(request2, accessToken);
                            JSONObject json2 = (JSONObject) JSONObject.toJSON(response2);
                            DepartmentEntity departmentEntity = JSONObject.toJavaObject(json2, DepartmentEntity.class);
                            System.out.println(departmentEntity);
                            if (parentIDListResult.getParentIds().length == 1) {
                                departAllName = departmentEntity.getName();
                            } else {
                                if (i == 0) {
                                    departAllName += departmentEntity.getName();
                                } else {
                                    departAllName += departmentEntity.getName() + "-";
                                }
                            }
                        }
                    }
                }

            } catch (ApiException e) {
                e.printStackTrace();
            }
        }

        return departAllName;
    }

    //调用接口获取token
    public String getAccessToken() {
        String accessToken = "";
        try {
            //获取token
            DefaultDingTalkClient client = new DefaultDingTalkClient(PathUtil.TokenUrl);
            OapiGettokenRequest request = new OapiGettokenRequest();
            request.setAppkey(PathUtil.AppKey);
            request.setAppsecret(PathUtil.AppSecret);
            request.setHttpMethod("GET");
            OapiGettokenResponse response = client.execute(request);
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(response);
            AccessTokenResult token = JSONObject.toJavaObject(jsonObject, AccessTokenResult.class);
            accessToken = token.getAccessToken();
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return accessToken;
    }


}
