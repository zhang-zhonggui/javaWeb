package com.zzg.day03.dao;

import java.util.Map;

public interface AdminDAO {

    Map<String, Object> login(String username, String password);

    int update(String newpassword_one, String oldpassword);
}
