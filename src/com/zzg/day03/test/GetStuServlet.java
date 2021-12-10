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
 * @Description: 将要修改的数据展示出来
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/getStu")
public class GetStuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前台传入的id
        String id = req.getParameter("id");
        //书写查询的语句
        String sql = "select * from student where id =?";
        //通过sql语句与id获取查询的数据
        List<Map<String, Object>> list = DAOUtil.request(sql, id);
        //将数据转发到update.jsp中
        req.setAttribute("stu", list.get(0));
        req.getRequestDispatcher("updata.jsp").forward(req, resp);

    }
}
