package com.zzg.day06;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class Test {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hehe", "root", "1012");
            String sql = "SELECT * FROM md";
            conn.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
