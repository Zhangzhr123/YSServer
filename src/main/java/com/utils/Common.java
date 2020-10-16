package com.utils;

import com.bean.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Common {
    public static String UP_LOAD_PATH = "";
    public static String PROJECT_PATH = "";
    public static String BASE_URL = "";
    //正式微信id
    public static String corpId = "";
    public static String secret = "";
    public static int agentid = 0;
    //公众号
    public static String gzcorpId = "";
    public static String gzsecret = "";
    public static int gzagentid = 0;
    //服务器域名
    public static String SERVER ="";
    //部门树形结构
    //public static List<Depart> departmentTree = new ArrayList<>();

    //当前登陆用户
    private static Map<String, User> USERS = new HashMap<>();
    public static User getUserById(String userId){
        User u = USERS.get(userId);
        return u;
    }
//    public static void setUser(User user){
//        USERS.put(user.getObjectId(), user);
//    }
//
//    public static boolean isAdmin(User user){
//        if(user.getRoleList() != null && user.getRoleList().size() > 0){
//            for(Role role : user.getRoleList()){
//                if(role.getCode().equals("admin")){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    public static boolean isKSZR(User user){
//        if(user.getRoleList() != null && user.getRoleList().size() > 0){
//            for(Role role : user.getRoleList()){
//                if(role.getCode().equals("ZNKSZR")){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    public static boolean isRole(User user, String roleCode){
//        if(user.getRoleList() != null && user.getRoleList().size() > 0){
//            for(Role role : user.getRoleList()){
//                if(role.getCode().equals(roleCode)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
