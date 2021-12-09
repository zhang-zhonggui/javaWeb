package com.zzg.day03.test;

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
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/getStu")
public class GetStuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String sql = "select * from student where id =?";
        List<Map> list = DAOUtil.request(sql, id);
        req.setAttribute("stu", list.get(0));
        req.getRequestDispatcher("updata.jsp").forward(req, resp);

    }
}
