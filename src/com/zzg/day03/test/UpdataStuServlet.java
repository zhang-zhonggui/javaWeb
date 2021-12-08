package com.zzg.day03.test;

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
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/updataStu")
public class UpdataStuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        String id = req.getParameter("id");
        String sql = "update student set sname=?,sage=?,saddress=? where id=?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe", "root", "1012");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, name);
            ps.setObject(2,age);
            ps.setObject(3,address);
            ps.setObject(4,id);
            int  i = ps.executeUpdate();
            resp.sendRedirect("/javaWeb/s");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
