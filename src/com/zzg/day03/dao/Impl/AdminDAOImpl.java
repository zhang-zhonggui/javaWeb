package com.zzg.day03.dao.Impl;

import com.zzg.day03.dao.AdminDAO;
import com.zzg.day03.util.DAOUtil;

import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class AdminDAOImpl implements AdminDAO {
    @Override
    public Map<String, Object> login(String username, String password) {
        String sql = "select * from t_login where username=? and password =?";
        List<Map<String, Object>> request = DAOUtil.request(sql, username, password);
        if (request.size() > 0) {
            return request.get(0);
        }
        return null;
    }

    @Override
    public int update(String newpassword_one, String oldpassword) {
        String sql = "update t_login set password=? where password =?";
        return   DAOUtil.update(sql,newpassword_one,oldpassword);
    }

    @Override
    public int updateName(String id, String name) {
        String sql = "update t_login set nickname=? where id=?";
        return DAOUtil.update(sql,name,id);
    }
}
