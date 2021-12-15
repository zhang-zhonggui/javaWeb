package com.zzg.day03.dao.Impl;

import com.zzg.day03.dao.LogBookDAO;
import com.zzg.day03.entity.Log;
import com.zzg.day03.util.DAOUtil;

import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class LogBookDAOImpl implements LogBookDAO {
    @Override
    public int add(Log log) {
        String sql = "insert into t_log VALUES(?,?,?,?,?,?)";
        return DAOUtil.update(sql,null,log.getName(),log.getDate(),log.getWay(),log.getIp(),log.getWayId());
    }

    @Override
    public List<Map<String, Object>> list() {
        String sql = "select * from t_log";
        return DAOUtil.request(sql);
    }
}
