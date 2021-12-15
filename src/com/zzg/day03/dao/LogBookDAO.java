package com.zzg.day03.dao;

import com.zzg.day03.entity.Log;

import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public interface LogBookDAO {
    int add(Log log);
    List<Map<String, Object>> list();
}
