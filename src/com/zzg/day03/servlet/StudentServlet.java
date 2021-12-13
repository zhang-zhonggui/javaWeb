package com.zzg.day03.servlet;

import com.zzg.day03.util.DAOUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: 我的第一次小测试
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/s")
public class StudentServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //书写sql语句
        String sql = "select * from student";
        //通过sql与将数据查询出来并展示到stu.jsp中
        List<Map<String, Object>> list = DAOUtil.request(sql);
        req.setAttribute("stu", list);
        req.getRequestDispatcher("stu.jsp").forward(req, resp);

    }
}
