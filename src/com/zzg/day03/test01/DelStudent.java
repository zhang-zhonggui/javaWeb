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
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/del")
public class DelStudent extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hehe", "root", "1012");
            PreparedStatement ps = conn.prepareStatement("delete from student where id=?");
            ps.setString(1, id);
            int i = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/javaWeb/student");
    }
}
