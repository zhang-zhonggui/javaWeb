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
 * @Description: 修改学生材料
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/updateStu")
public class UpdateStuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //修改编码格式获取前端传来的数据
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        String id = req.getParameter("id");
        //书写sql语句
        String sql = "update student set sname=?,sage=?,saddress=? where id=?";
        //执行sql语句并重定向的查询中，重新进行展示
        DAOUtil.update(sql, name, age, address, id);
        resp.sendRedirect("/javaWeb/s");

    }
}
