package com.zzg.day03.test;

import com.zzg.day03.util.DAOUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: zzg
 * @Description: 添加数据
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/addStu")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //根据传入数据获取，同时设置编码格式，以防乱码。
        req.setCharacterEncoding("utf-8");
        //获取前台传入的数据
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        //书写需要执行的sql语句
        String sql = "insert  into student values (null ,?,?,?)";
        //定义i活跃语句执行BAOUtil时的是否成功
        int i = DAOUtil.update(sql, name, age, address);
        //返回数据用于判断是否添加成功同时对文件进行重定向
        req.setAttribute("code", i);
        req.getRequestDispatcher("addstu.jsp").forward(req, resp);


    }
}
