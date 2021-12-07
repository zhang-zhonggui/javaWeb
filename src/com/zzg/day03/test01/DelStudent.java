package com.zzg.day03.test01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @Author: zzg
 * @Description: 删除指定的是数据
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/del")
public class DelStudent extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端数据转发过的数据
        String id = req.getParameter("id");
        //根据前端转过来的数据删除数据库转过来的数据
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hehe", "root", "1012");
            PreparedStatement ps = conn.prepareStatement("delete from student where id=?");
            ps.setString(1, id);
            int i = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //重定向到查询的页面
        resp.sendRedirect("/javaWeb/student");
    }
}
