package com.zzg.day03.servlet;

import com.zzg.day03.dao.Impl.StuClassDAOImpl;
import com.zzg.day03.dao.StuClassDAO;
import com.zzg.day03.entity.Student;

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
@WebServlet("/c/*")
public class StuClassServlet extends HttpServlet {
    StuClassDAO classDAO = new StuClassDAOImpl();

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String uri = req.getRequestURI();
        String[] split = uri.split("/");
        String s = split[split.length - 1];

        if (s.equals("inquireClass")) {
            inquireClass(req, resp);
        } else if (s.equals("delStuClass")) {
            delStuClass(req, resp);
        } else if (s.equals("addClass")) {
            addClass(req, resp);
        } else if (s.equals("getClass")) {
            getClass(req, resp);
        } else if (s.equals("updateClass")) {
            updateClass(req, resp);
        }
    }

    protected void inquireClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Map<String, Object>> list = classDAO.inquireStu();
        req.setAttribute("stuClass", list);
        req.getRequestDispatcher("/class.jsp").forward(req, resp);
    }

    protected void delStuClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = classDAO.deleteClass(id);
        System.out.println(i);
        resp.sendRedirect("/javaWeb/c/inquireClass");
    }

    protected void addClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int i = classDAO.addClass(name);
        req.setAttribute("code", i);
        req.getRequestDispatcher("/addClass.jsp").forward(req, resp);
    }

    protected void getClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<Map<String, Object>> list = classDAO.getClass(id);
        req.setAttribute("stu", list.get(0));
        req.getRequestDispatcher("/updateClass.jsp").forward(req, resp);
    }

    protected void updateClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String id = req.getParameter("id");
        int i = classDAO.updateStu(id,name);
        req.getRequestDispatcher("/c/inquireClass").forward(req, resp);
    }
}
