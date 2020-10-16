package com.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bean.*;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.service.IDepartmentService;
import com.taobao.api.ApiException;
import com.utils.PathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private com.dao.DepartmentDao departmentDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * createdby zhangzhr
     * createdDate 2020-08-12
     * 同步根部门
     * 如果BPM根部门中不存在钉钉的根部门则删除钉钉的根部门，如果钉钉不存在BPM的根部门则增加钉钉的根部门
     */
    @Override
    public Result<List<Depart>> updateGBMDepartmentList() {
        Result<List<Depart>> res = new Result<>();
        try {
            //获取token
            String accessToken = getAccessToken();
            //查询BPM根目录部门
            List<Depart> gmlDepart = departmentDao.selectGMLDepartment();
            //判断BPM根目录下是否存在部门
            if (gmlDepart != null && gmlDepart.size() > 0) {
                //遍历获取BPM部门名称
                List<String> bpmName = new ArrayList<>();
                for (int i = 0; i < gmlDepart.size(); i++) {
                    bpmName.add(gmlDepart.get(i).getDesName());
                }
                //查询钉钉根目录下的部门
                DingTalkClient dtc = new DefaultDingTalkClient(PathUtil.GetDepartmentListByID);
                OapiDepartmentListIdsRequest request1 = new OapiDepartmentListIdsRequest();
                request1.setId("1");
                request1.setHttpMethod("GET");
                OapiDepartmentListIdsResponse response1 = dtc.execute(request1, accessToken);
                JSONObject jsonObject1 = (JSONObject) JSONObject.toJSON(response1);
                String body1 = jsonObject1.getString("body");
                JSONObject bodyjson1 = (JSONObject) JSONObject.parseObject(body1);
                DepartmentListResult departmentListResult = JSONObject.toJavaObject(bodyjson1, DepartmentListResult.class);

                //判断钉钉根目录下是否存在部门
                if (departmentListResult.getSub_dept_id_list() != null && departmentListResult.getSub_dept_id_list().length > 0) {
                    int number = departmentListResult.getSub_dept_id_list().length;
                    Map<String, String> ddDepartMap = new HashMap<>();
                    List<String> ddNameList = new ArrayList<>();
                    //遍历数组获取当前部门的部门信息
                    for (int i = 0; i < number; i++) {
                        //获取部门信息
                        DingTalkClient client2 = new DefaultDingTalkClient(PathUtil.GetDepartment);
                        OapiDepartmentGetRequest request2 = new OapiDepartmentGetRequest();
                        request2.setId(departmentListResult.getSub_dept_id_list()[i]);
                        request2.setHttpMethod("GET");
                        OapiDepartmentGetResponse response2 = client2.execute(request2, accessToken);
                        JSONObject json2 = (JSONObject) JSONObject.toJSON(response2);
                        DepartmentEntity departmentEntity = JSONObject.toJavaObject(json2, DepartmentEntity.class);
                        System.out.println(departmentEntity);
                        //将部门信息添加到集合中
                        String ddname = getDepartAllName(departmentEntity.getId());
                        ddDepartMap.put(ddname, departmentEntity.getId());
                        ddNameList.add(ddname);
                    }
                    System.out.println(ddDepartMap);
                    //如果钉钉部门不存在BPM中的部门则创建此部门
                    for (int i = 0; i < bpmName.size(); i++) {
                        if (!ddNameList.contains(bpmName.get(i))) {
                            DingTalkClient client = new DefaultDingTalkClient(PathUtil.CreateDepartment);
                            OapiDepartmentCreateRequest request = new OapiDepartmentCreateRequest();
                            request.setParentid("1");
                            request.setName(bpmName.get(i));
                            OapiDepartmentCreateResponse response = client.execute(request, accessToken);
                            JSONObject json = (JSONObject) JSONObject.toJSON(response);
                            DepartmentResult departmentResult = JSONObject.toJavaObject(json, DepartmentResult.class);
                            System.out.println(departmentResult);
                        }
                    }
                    //如果BPM部门不存在钉钉中的部门则删除此部门
//                    for (int i = 0; i < ddNameList.size(); i++) {
//                        if (!bpmName.contains(ddNameList.get(i))) {
//                            for (String key : ddDepartMap.keySet()) {
//                                if (key.equals(ddNameList.get(i))) {
//                                    //根据钉钉部门ID删除此部门的子部门及其成员
//                                    deleteDepartAndUser(ddDepartMap.get(ddNameList.get(i)));
//                                    //根据部门ID删除此部门
//                                    deleteDepart(ddDepartMap.get(ddNameList.get(i)));
//                                }
//                            }
//                        }
//                    }

                    res.setFlag(true);
                    res.setData(gmlDepart);
                    res.setMessage("Success");

                } else {
                    res.setFlag(false);
                    res.setMessage("钉钉根目录下没有组织");
                }

            } else {
                res.setFlag(false);
                res.setMessage("BPM根目录下没有组织");
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
     * createdby zhangzhr
     * createdDate 2020-08-12
     * 同步根部门下的所有子部门
     */
    @Override
    public Result<List<DepartmentEntity>> updateDepartmentList() {
        Result<List<DepartmentEntity>> res = new Result<>();
        try {
            //获取token
            String accessToken = getAccessToken();
            //查询BPM所有部门
            List<Depart> data = departmentDao.selectDepartment();
            //判断BPM是否存在部门
            if (data != null || data.size() > 0) {
                //查询钉钉根目录下的部门
                DingTalkClient dtc = new DefaultDingTalkClient(PathUtil.GetDepartmentListByID);
                OapiDepartmentListIdsRequest request1 = new OapiDepartmentListIdsRequest();
                request1.setId("1");
                request1.setHttpMethod("GET");
                OapiDepartmentListIdsResponse response1 = dtc.execute(request1, accessToken);
                JSONObject jsonObject1 = (JSONObject) JSONObject.toJSON(response1);
                String body1 = jsonObject1.getString("body");
                JSONObject bodyjson1 = (JSONObject) JSONObject.parseObject(body1);
                DepartmentListResult departmentListResult = JSONObject.toJavaObject(bodyjson1, DepartmentListResult.class);
                System.out.println(departmentListResult);
                //判断钉钉根部门是否为空
                if (departmentListResult.getSub_dept_id_list() != null && departmentListResult.getSub_dept_id_list().length > 0) {
                    //根部门数量
                    int number = departmentListResult.getSub_dept_id_list().length;
                    List<DepartmentEntity> ddNameList = new ArrayList<DepartmentEntity>();
                    //遍历数组获取当前部门的部门信息
                    for (int i = 0; i < number; i++) {
                        //获取钉钉根部门信息
                        DingTalkClient client2 = new DefaultDingTalkClient(PathUtil.GetDepartment);
                        OapiDepartmentGetRequest request2 = new OapiDepartmentGetRequest();
                        request2.setId(departmentListResult.getSub_dept_id_list()[i]);
                        request2.setHttpMethod("GET");
                        OapiDepartmentGetResponse response2 = client2.execute(request2, accessToken);
                        JSONObject json2 = (JSONObject) JSONObject.toJSON(response2);
                        DepartmentEntity departmentEntity = JSONObject.toJavaObject(json2, DepartmentEntity.class);
                        System.out.println(departmentEntity);
                        //将钉钉根部门信息添加到集合中
                        String ddname = getDepartAllName(departmentEntity.getId());
                        //添加钉钉根部门全称
                        departmentEntity.setExt(ddname);
                        //根据钉钉部门全称查询BPM中对应的部门
                        List<Depart> bpmID = departmentDao.selectDepartByName(ddname);
                        //判断BPM对应部门是否存在
                        if (bpmID != null && bpmID.size() > 0) {
                            //添加bpm对应部门的ID
                            departmentEntity.setSourceIdentifier(bpmID.get(0).getObjectID());
                            ddNameList.add(departmentEntity);
                        } else {
                            //根据钉钉部门ID删除此部门的子部门及其成员
//                            deleteDepartAndUser(departmentEntity.getId());
//                            //删除此部门及部门成员
//                            deleteDepart(departmentEntity.getId());
//                            res.setFlag(false);
//                            res.setMessage("此部门不存在在BPM根部门中");
                        }
                    }
                    System.out.println(ddNameList);
                    //遍历查询钉钉根部门下是否存在子部门，如果存在则创建
                    for (int i = 0; i < ddNameList.size(); i++) {
                        getDepart(ddNameList.get(i));
                    }

                    res.setFlag(true);
                    res.setData(ddNameList);
                    res.setMessage("Success");
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
     * createdby zhangzhr
     * createdDate 2020-08-12
     * 删除钉钉中BPM不存在的钉钉部门
     */
    @Override
    public Result<List<Depart>> deleteDepartmentList() {
        Result<List<Depart>> res = new Result<>();
        try {
            String accessToken = getAccessToken();
            //查询BPM所有部门
            List<Depart> data = departmentDao.selectDepartment();
            //判断BPM是否存在部门
            if (data != null || data.size() > 0) {
                //查询钉钉所有部门
                DingTalkClient client = new DefaultDingTalkClient(PathUtil.GetDepartmentList);
                OapiDepartmentListRequest request = new OapiDepartmentListRequest();
                request.setId("1");
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
                        departmentMap.put(departName, getDepartList.getDepartment().get(i).getId());
                        idList.add(departName);
                    }
                    System.out.println(departmentMap);

                    List<String> bpmList = new ArrayList<>();
                    for (int i = 0; i < data.size(); i++) {
                        bpmList.add(data.get(i).getDesName());
                    }

                    //循环查询BPM中是否存在钉钉的部门如果不存在则删除钉钉的部门
                    for (int j = 0; j < idList.size(); j++) {
                        if(!idList.get(j).contains("信息部/外协供应商")){
                            System.out.println(idList.get(j));
                            if (!bpmList.contains(idList.get(j))) {
                                System.out.println(idList.get(j));
                                for (String key : departmentMap.keySet()) {
                                    if (key.equals(idList.get(j))) {
                                        System.out.println(idList.get(j));
                                        //根据钉钉部门ID删除此部门的子部门及其成员
                                        deleteDepartAndUser(departmentMap.get(idList.get(j)));
                                        //删除此部门及部门成员
                                        deleteDepart(departmentMap.get(idList.get(j)));
                                    }
                                }
                            }
                        }

                    }

                    res.setFlag(true);
                    res.setData(data);
                    res.setMessage("Success");

                } else {
                    res.setFlag(false);
                    res.setMessage("钉钉部门为空");
                }

            } else {
                res.setFlag(false);
                res.setMessage("BPM部门为空");
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            res.setFlag(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }


    //根据部门ID删除此部门和部门下的人员
    public void deleteDepart(String departID) {
        String accessToken = getAccessToken();
        if (departID != null) {
            try {
                //此子部门下的人员列表
                DingTalkClient client3 = new DefaultDingTalkClient(PathUtil.GetByDepartmentIdForSimpleList);
                OapiUserSimplelistRequest request3 = new OapiUserSimplelistRequest();
                request3.setDepartmentId(Long.valueOf(departID));
                request3.setHttpMethod("GET");
                OapiUserSimplelistResponse response3 = client3.execute(request3, accessToken);
                System.out.println(response3.getBody());
                JSONObject json3 = (JSONObject) JSONObject.toJSON(response3);
                EmployeeListResult employeeListResult = JSONObject.toJavaObject(json3, EmployeeListResult.class);
                System.out.println(employeeListResult);
                //判断部门下是否存在人员
                if (employeeListResult.getUserlist() != null && employeeListResult.getUserlist().size() > 0) {
                    //存在则循环删除人员
                    for (int i = 0; i < employeeListResult.getUserlist().size(); i++) {
                        DingTalkClient dtcDE = new DefaultDingTalkClient(PathUtil.DeleteEmployee);
                        OapiUserDeleteRequest deRequest = new OapiUserDeleteRequest();
                        deRequest.setUserid(employeeListResult.getUserlist().get(i).getUserid());
                        deRequest.setHttpMethod("GET");
                        OapiUserDeleteResponse deResponse = dtcDE.execute(deRequest, accessToken);
                        JSONObject deJson = (JSONObject) JSONObject.toJSON(deResponse);
                        ErrorResult errorResult = JSONObject.toJavaObject(deJson, ErrorResult.class);
                        System.out.println(errorResult);
                    }
                    //删除此部门
                    DingTalkClient client2 = new DefaultDingTalkClient(PathUtil.DeleteDepartment);
                    OapiDepartmentDeleteRequest request2 = new OapiDepartmentDeleteRequest();
                    request2.setId(departID);
                    request2.setHttpMethod("GET");
                    OapiDepartmentDeleteResponse response2 = client2.execute(request2, accessToken);
                    JSONObject json2 = (JSONObject) JSONObject.toJSON(response2);
                    ErrorResult errorResult = JSONObject.toJavaObject(json2, ErrorResult.class);
                    System.out.println(errorResult);
                }
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }

    }

    //根据部门ID删除此部门的子部门及子部门下的人员
    public void deleteDepartAndUser(String departID) {
        String accessToken = getAccessToken();
        if (departID != null) {
            try {
                //查看此部门是否存在子部门
                DingTalkClient client = new DefaultDingTalkClient(PathUtil.GetDepartmentListByID);
                OapiDepartmentListRequest request = new OapiDepartmentListRequest();
                request.setId(departID);
                request.setHttpMethod("GET");
                OapiDepartmentListResponse response = client.execute(request, accessToken);
                JSONObject jsonObject1 = (JSONObject) JSONObject.toJSON(response);
                String body1 = jsonObject1.getString("body");
                JSONObject bodyjson1 = (JSONObject) JSONObject.parseObject(body1);
                DepartmentListResult departmentListResult = JSONObject.toJavaObject(bodyjson1, DepartmentListResult.class);
                System.out.println(departmentListResult);
                List<String> idList = new ArrayList<>();
                //判断此部门是否存在子部门
                if (departmentListResult.getSub_dept_id_list() != null && departmentListResult.getSub_dept_id_list().length > 0) {
                    //将所有子部门id方到集合中
                    for (int i = 0; i < departmentListResult.getSub_dept_id_list().length; i++) {
                        idList.add(departmentListResult.getSub_dept_id_list()[i]);
                    }
                    System.out.println(idList);
                    //循环判断部门下是否存在人员
                    for (int j = 0; j < idList.size(); j++) {
                        //此子部门下的人员列表
                        DingTalkClient client3 = new DefaultDingTalkClient(PathUtil.GetByDepartmentIdForSimpleList);
                        OapiUserSimplelistRequest request3 = new OapiUserSimplelistRequest();
                        request3.setDepartmentId(Long.valueOf(idList.get(j)));
                        request3.setHttpMethod("GET");
                        OapiUserSimplelistResponse response3 = client3.execute(request3, accessToken);
                        System.out.println(response3.getBody());
                        JSONObject json3 = (JSONObject) JSONObject.toJSON(response3);
                        EmployeeListResult employeeListResult = JSONObject.toJavaObject(json3, EmployeeListResult.class);
                        System.out.println(employeeListResult);
                        //判断部门下是否存在人员
                        if (employeeListResult.getUserlist() != null && employeeListResult.getUserlist().size() > 0) {
                            //存在则循环删除人员
                            for (int i = 0; i < employeeListResult.getUserlist().size(); i++) {
                                DingTalkClient dtcDE = new DefaultDingTalkClient(PathUtil.DeleteEmployee);
                                OapiUserDeleteRequest deRequest = new OapiUserDeleteRequest();
                                deRequest.setUserid(employeeListResult.getUserlist().get(i).getUserid());
                                deRequest.setHttpMethod("GET");
                                OapiUserDeleteResponse deResponse = dtcDE.execute(deRequest, accessToken);
                                JSONObject deJson = (JSONObject) JSONObject.toJSON(deResponse);
                                ErrorResult errorResult = JSONObject.toJavaObject(deJson, ErrorResult.class);
                                System.out.println(errorResult);
                            }
                            //删除此部门
                            DingTalkClient client2 = new DefaultDingTalkClient(PathUtil.DeleteDepartment);
                            OapiDepartmentDeleteRequest request2 = new OapiDepartmentDeleteRequest();
                            request2.setId(idList.get(j));
                            request2.setHttpMethod("GET");
                            OapiDepartmentDeleteResponse response2 = client2.execute(request2, accessToken);
                            JSONObject json2 = (JSONObject) JSONObject.toJSON(response2);
                            ErrorResult errorResult = JSONObject.toJavaObject(json2, ErrorResult.class);
                            System.out.println(errorResult);
                            //判断是否删除成功
                            if (!errorResult.getErrcode().equals("ok")) {
                                deleteDepartAndUser(idList.get(j));
                            }
                            //不存在人员则删除此部门
                        } else {
                            //删除此部门
                            DingTalkClient client2 = new DefaultDingTalkClient(PathUtil.DeleteDepartment);
                            OapiDepartmentDeleteRequest request2 = new OapiDepartmentDeleteRequest();
                            request2.setId(idList.get(j));
                            request2.setHttpMethod("GET");
                            OapiDepartmentDeleteResponse response2 = client2.execute(request2, accessToken);
                            JSONObject json2 = (JSONObject) JSONObject.toJSON(response2);
                            ErrorResult errorResult = JSONObject.toJavaObject(json2, ErrorResult.class);
                            System.out.println(errorResult);
                            //判断是否删除成功
                            if (!errorResult.getErrcode().equals("ok")) {
                                deleteDepartAndUser(idList.get(j));
                            }
                        }
                    }

                    //不存在子部门的则删除此部门及其下的人员
                } else {
                    if (departID != null) {
                        //此部门下的人员列表
                        DingTalkClient client3 = new DefaultDingTalkClient(PathUtil.GetByDepartmentIdForSimpleList);
                        OapiUserSimplelistRequest request3 = new OapiUserSimplelistRequest();
                        request3.setDepartmentId(Long.valueOf(departID));
                        request3.setHttpMethod("GET");
                        OapiUserSimplelistResponse response3 = client3.execute(request3, accessToken);
                        System.out.println(response3.getBody());
                        JSONObject json3 = (JSONObject) JSONObject.toJSON(response3);
                        EmployeeListResult employeeListResult = JSONObject.toJavaObject(json3, EmployeeListResult.class);
                        System.out.println(employeeListResult);
                        //判断部门下是否存在人员
                        if (employeeListResult.getUserlist() != null && employeeListResult.getUserlist().size() > 0) {
                            //存在则循环删除人员
                            for (int i = 0; i < employeeListResult.getUserlist().size(); i++) {
                                DingTalkClient dtcDE = new DefaultDingTalkClient(PathUtil.DeleteEmployee);
                                OapiUserDeleteRequest deRequest = new OapiUserDeleteRequest();
                                deRequest.setUserid(employeeListResult.getUserlist().get(i).getUserid());
                                deRequest.setHttpMethod("GET");
                                OapiUserDeleteResponse deResponse = dtcDE.execute(deRequest, accessToken);
                                JSONObject deJson = (JSONObject) JSONObject.toJSON(deResponse);
                                ErrorResult errorResult = JSONObject.toJavaObject(deJson, ErrorResult.class);
                                System.out.println(errorResult);
                            }
                        }
                        //删除此部门
                        DingTalkClient client2 = new DefaultDingTalkClient(PathUtil.DeleteDepartment);
                        OapiDepartmentDeleteRequest request2 = new OapiDepartmentDeleteRequest();
                        request2.setId(departID);
                        request2.setHttpMethod("GET");
                        OapiDepartmentDeleteResponse response2 = client2.execute(request2, accessToken);
                        JSONObject json2 = (JSONObject) JSONObject.toJSON(response2);
                        ErrorResult errorResult = JSONObject.toJavaObject(json2, ErrorResult.class);
                        System.out.println(errorResult);
                    }

                }

            } catch (ApiException e) {
                e.printStackTrace();
            }
        }

    }

    //根据钉钉部门id和添加的BPM部门ObjectID查询钉钉中是否存在BPM的部门，如果不存在则增加
    public void getDepart(DepartmentEntity departID) {
        String accessToken = getAccessToken();
        if (departID != null) {
            try {
                //钉钉根据部门id获取子部门id
                DingTalkClient dtc = new DefaultDingTalkClient(PathUtil.GetDepartmentListByID);
                OapiDepartmentListIdsRequest request1 = new OapiDepartmentListIdsRequest();
                request1.setId(departID.getId());
                request1.setHttpMethod("GET");
                OapiDepartmentListIdsResponse response1 = dtc.execute(request1, accessToken);
                JSONObject jsonObject1 = (JSONObject) JSONObject.toJSON(response1);
                String body1 = jsonObject1.getString("body");
                JSONObject bodyjson1 = (JSONObject) JSONObject.parseObject(body1);
                DepartmentListResult departmentListResult = JSONObject.toJavaObject(bodyjson1, DepartmentListResult.class);
                System.out.println(departmentListResult);
                //判断钉钉子部门是否为空
                if (departmentListResult.getSub_dept_id_list() != null && departmentListResult.getSub_dept_id_list().length > 0) {
                    //子部门数量
                    int number = departmentListResult.getSub_dept_id_list().length;
                    //添加钉钉子部门信息到集合中
                    List<DepartmentEntity> ddDepartList = new ArrayList<DepartmentEntity>();
                    List<String> ddNameList = new ArrayList<>();
                    //遍历数组获取子部门的部门信息
                    for (int i = 0; i < number; i++) {
                        //获取部门信息
                        DingTalkClient client2 = new DefaultDingTalkClient(PathUtil.GetDepartment);
                        OapiDepartmentGetRequest request2 = new OapiDepartmentGetRequest();
                        request2.setId(departmentListResult.getSub_dept_id_list()[i]);
                        request2.setHttpMethod("GET");
                        OapiDepartmentGetResponse response2 = client2.execute(request2, accessToken);
                        JSONObject json2 = (JSONObject) JSONObject.toJSON(response2);
                        DepartmentEntity departmentEntity = JSONObject.toJavaObject(json2, DepartmentEntity.class);
                        System.out.println(departmentEntity);
                        //将部门信息添加到集合中
                        String ddname = getDepartAllName(departmentEntity.getId());
                        //添加部门全称
                        departmentEntity.setExt(ddname);
                        ddDepartList.add(departmentEntity);
                        ddNameList.add(ddname);
                    }
                    System.out.println(ddDepartList);
                    List<String> bpmname = new ArrayList<>();
                    //查询对应的BPM部门的子部门
                    List<Depart> bpmID = departmentDao.selectDepartByParentID(departID.getSourceIdentifier());
                    if (departID.getName().equals("信息部")) {
                        Depart de = new Depart();
                        de.setDesName("信息部/外协供应商");
                        bpmID.add(de);
                    }
                    //判断BPM对应部门是否存在子部门
                    if (bpmID != null && bpmID.size() > 0) {
                        for (int j = 0; j < bpmID.size(); j++) {
                            //钉钉子部门中不存在对应BPM部门的子部门则增加
                            if (!ddNameList.contains(bpmID.get(j).getDesName())) {
                                DingTalkClient client = new DefaultDingTalkClient(PathUtil.CreateDepartment);
                                OapiDepartmentCreateRequest request = new OapiDepartmentCreateRequest();
                                request.setParentid(departID.getId());
                                request.setName(bpmID.get(j).getName());
                                OapiDepartmentCreateResponse response = client.execute(request, accessToken);
                                JSONObject json = (JSONObject) JSONObject.toJSON(response);
                                DepartmentResult departmentResult = JSONObject.toJavaObject(json, DepartmentResult.class);
                                System.out.println(departmentResult);
                            }
                            //添加BPM部门名称
                            bpmname.add(bpmID.get(j).getDesName());
                        }
                        //钉钉子部门中存在BPM部门没有的子部门则删除
//                        for (int j = 0; j < ddDepartList.size(); j++) {
//                            if (!bpmname.contains(ddDepartList.get(j).getExt())) {
//                                //根据钉钉部门ID删除此部门的子部门及其成员
//                                deleteDepartAndUser(ddDepartList.get(j).getId());
//                                //删除此部门及部门成员
//                                deleteDepart(ddDepartList.get(j).getId());
//                            }
//                        }
                        //如果不存在子部门则删除钉钉对应此部门的子部门及子部门成员
                    } else {
                        //根据钉钉部门ID删除此部门的子部门及其成员
//                        deleteDepartAndUser(departID.getId());
                    }
                    System.out.println(bpmID);
                    //钉钉根据部门id获取子部门id  执行递归查询子部门下是否还存在部门，如果存在继续创建
                    DingTalkClient dtc2 = new DefaultDingTalkClient(PathUtil.GetDepartmentListByID);
                    OapiDepartmentListIdsRequest request2 = new OapiDepartmentListIdsRequest();
                    request2.setId(departID.getId());
                    request2.setHttpMethod("GET");
                    OapiDepartmentListIdsResponse response2 = dtc2.execute(request2, accessToken);
                    JSONObject jsonObject2 = (JSONObject) JSONObject.toJSON(response2);
                    String body2 = jsonObject2.getString("body");
                    JSONObject bodyjson2 = (JSONObject) JSONObject.parseObject(body2);
                    DepartmentListResult departmentListResult2 = JSONObject.toJavaObject(bodyjson2, DepartmentListResult.class);
                    System.out.println(departmentListResult2);
                    //判断钉钉子部门是否为空
                    if (departmentListResult.getSub_dept_id_list() != null && departmentListResult.getSub_dept_id_list().length > 0) {
                        //添加钉钉子部门信息到集合中
                        List<DepartmentEntity> ddDepartList2 = new ArrayList<DepartmentEntity>();
                        //遍历数组获取子部门的部门信息
                        for (int i = 0; i < departmentListResult.getSub_dept_id_list().length; i++) {
                            //获取部门信息
                            DingTalkClient client3 = new DefaultDingTalkClient(PathUtil.GetDepartment);
                            OapiDepartmentGetRequest request3 = new OapiDepartmentGetRequest();
                            request3.setId(departmentListResult.getSub_dept_id_list()[i]);
                            request3.setHttpMethod("GET");
                            OapiDepartmentGetResponse response3 = client3.execute(request3, accessToken);
                            JSONObject json3 = (JSONObject) JSONObject.toJSON(response3);
                            DepartmentEntity departmentEntity = JSONObject.toJavaObject(json3, DepartmentEntity.class);
                            System.out.println(departmentEntity);
                            //将部门信息添加到集合中
                            String ddname = getDepartAllName(departmentEntity.getId());
                            //添加部门全称
                            departmentEntity.setExt(ddname);
                            //根据钉钉部门全称查询BPM中对应的部门
                            List<Depart> bpmIDList = departmentDao.selectDepartByName(ddname);
                            //判断BPM对应部门是否存在
                            if (bpmIDList != null && bpmIDList.size() > 0) {
                                //添加bpm对应部门的ID
                                departmentEntity.setSourceIdentifier(bpmIDList.get(0).getObjectID());
                                ddDepartList2.add(departmentEntity);
                            } else {
//                                if(!(departmentEntity.getExt()).equals("信息部/外协供应商")){
//                                    //根据钉钉部门ID删除此部门的子部门及其成员
//                                    deleteDepartAndUser(departmentEntity.getId());
//                                    //删除此部门及部门成员
//                                    deleteDepart(departmentEntity.getId());
//                                }
                            }
                        }
                        System.out.println(ddDepartList2);
                        //递归调用创建子部门
                        for (int i = 0; i < ddDepartList2.size(); i++) {
                            getDepart(ddDepartList2.get(i));
                        }

                    }

                    //钉钉此部门不存在子部门
                } else {
                    //查询对应的BPM部门子部门
                    List<Depart> bpmID = departmentDao.selectDepartByParentID(departID.getSourceIdentifier());
                    System.out.println(bpmID);
                    //判断BPM对应钉钉的部门是否存在子部门
                    if (bpmID != null && bpmID.size() > 0) {
                        //循环添加子部门
                        for (int j = 0; j < bpmID.size(); j++) {
                            DingTalkClient client = new DefaultDingTalkClient(PathUtil.CreateDepartment);
                            OapiDepartmentCreateRequest request = new OapiDepartmentCreateRequest();
                            request.setParentid(departID.getId());
                            request.setName(bpmID.get(j).getName());
                            OapiDepartmentCreateResponse response = client.execute(request, accessToken);
                            JSONObject json = (JSONObject) JSONObject.toJSON(response);
                            DepartmentResult departmentResult = JSONObject.toJavaObject(json, DepartmentResult.class);
                            System.out.println(departmentResult);
                        }
                        //创建子部门
                        getDepart(departID);
                    }
                }

            } catch (ApiException e) {
                e.printStackTrace();
            }
        }

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
                //判断是否存在父部门ID
                if (parentIDListResult.getParentIds() != null) {
                    //如果存在遍历父部门获取全称
                    if (parentIDListResult.getParentIds().length > 0) {
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
