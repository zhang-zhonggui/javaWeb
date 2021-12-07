package com.zzg.day03.test01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: 查询数据库中的内容同时转发到index.jsp中
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询数据
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe", "root", "1012");
            PreparedStatement ps = conn.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            List<Map> list=new ArrayList<>();
            while (rs.next()) {
                Map map = new HashMap();
                for (int i=0; i<md.getColumnCount(); i++) {
                    map.put(md.getColumnName(i + 1), rs.getObject(i + 1));
                }
                list.add(map);
            }
            conn.close();
            //将数据存储起来
            req.setAttribute("students",list);
            //将数据转发出去
            req.getRequestDispatcher("student.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}