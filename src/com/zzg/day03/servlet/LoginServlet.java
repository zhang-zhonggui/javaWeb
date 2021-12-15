package com.zzg.day03.servlet;

import com.zzg.day03.dao.AdminDAO;
import com.zzg.day03.dao.Impl.AdminDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/admin/*")
public class LoginServlet extends HttpServlet {
    AdminDAO admin = new AdminDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String uri = req.getRequestURI();
        String[] split = uri.split("/");
        String s = split[split.length - 1];
        if (s.equals("login")) {
            login(req, resp);
        }else if (s.equals("updatePassword")){
            updatePassword(req, resp);
        }else if (s.equals("logout")){
            logout(req, resp);
        }else if (s.equals("update")){
            update(req, resp);
        }else if (s.equals("updatename")){
            updatename(req, resp);
        }
    }


    protected void updatename(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        int i = admin.updateName(id, name);
        resp.sendRedirect("/javaWeb");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("id",id);
        req.getRequestDispatcher("/updatename.jsp").forward(req, resp);
    }

    protected void updatePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String p1 = req.getParameter("oldpassword");
        String p2 = req.getParameter("newpassword_one");
        int update = admin.update(p2, p1);
        req.setAttribute("code",update);
        req.getRequestDispatcher("/wd.jsp").forward(req, resp);

    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Map<String, Object> stu = admin.login(username, password);
        if (stu != null) {
            HttpSession session = req.getSession();
            session.setAttribute("stu", stu);
            resp.sendRedirect("/javaWeb/main.jsp");
        } else {
            req.setAttribute("msg", "对不起账号或者密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/javaWeb");
    }
}
