package com.zzg.day03.servlet;

import com.zzg.day03.dao.Impl.LogBookDAOImpl;
import com.zzg.day03.dao.LogBookDAO;

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
 * @Description: 日志
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/log")
public class LogServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LogBookDAO log=new LogBookDAOImpl();
        List<Map<String, Object>> list = log.list();
        req.setAttribute("log",list);
        req.getRequestDispatcher("/log.jsp").forward(req, resp);
    }
}
