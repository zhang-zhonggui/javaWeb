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
 * @Description: 添加事件
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/addstu")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //根据传入数据获取，同时设置编码格式，以防乱码。
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        //书写需要执行的sql语句
        String sql = "insert  into student values (null ,?,?,?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe", "root", "1012");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, name);
            ps.setObject(2,age);
            ps.setObject(3,address);
           int  i = ps.executeUpdate();
            //返回数据用于判断是否添加成功同时对文件进行重定向
            req.setAttribute("code",i);
            req.getRequestDispatcher("addstu.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
