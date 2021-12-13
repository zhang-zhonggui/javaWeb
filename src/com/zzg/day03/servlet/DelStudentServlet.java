package com.zzg.day03.servlet;

import com.zzg.day03.util.DAOUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: zzg
 * @Description: 根据索引删除指定的数据
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/delStu")
public class DelStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //或许学生的id
        String id = req.getParameter("id");
        //书写删除的sql语句
        String sql = "delete  from student where id=?";
        //通过DAOTil工具类删除数据库中的内容
        DAOUtil.update(sql, id);
        //重定向的查询语句
        resp.sendRedirect("/javaWeb/s");
    }
}
