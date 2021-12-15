package com.zzg.day03.servlet;

import com.zzg.day03.dao.Impl.LogBookDAOImpl;
import com.zzg.day03.dao.Impl.StudentDAOImpl;
import com.zzg.day03.dao.LogBookDAO;
import com.zzg.day03.dao.StudentDAO;
import com.zzg.day03.entity.Log;
import com.zzg.day03.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: 我的第一次小测试
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/s/*")
public class StudentServlet extends HttpServlet {
    StudentDAO student = new StudentDAOImpl();
    LogBookDAO log = new LogBookDAOImpl();
    Date date = new Date();

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String uri = req.getRequestURI();
        String[] split = uri.split("/");
        String s = split[split.length - 1];

        if (s.equals("inquireStu")) {
            inquireStu(req, resp);
        } else if (s.equals("delStu")) {
            delStu(req, resp);
        } else if (s.equals("addStu")) {
            addStu(req, resp);
        } else if (s.equals("getStu")) {
            getStu(req, resp);
        } else if (s.equals("updateStu")) {
            updateStu(req, resp);
        }
    }

    protected void inquireStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Map<String, Object>> list = student.inquireStu();


        req.setAttribute("stu", list);
        req.getRequestDispatcher("/stu.jsp").forward(req, resp);
    }

    protected void delStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        //获取修改人的信息
        Object stu = req.getSession().getAttribute("stu");
        Map<String, Object> map = (Map<String, Object>) stu;
        Object name = map.get("nickname");
        //获取修改日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        String da = sdf.format(date);
        //获取ip地址
        String ip = req.getRemoteAddr();
        //存放在data对象中
        Log data = new Log(0, name.toString(), da, "delStu", ip, Integer.parseInt(id));
        log.add(data);
        student.deleteStu(id);
        resp.sendRedirect("/javaWeb/s/inquireStu");
    }

    protected void addStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前台传入的数据
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        Student stu = new Student(0, name, Integer.parseInt(age), address);

        int i = student.addStu(stu);
        req.setAttribute("code", i);
        req.getRequestDispatcher("/addstu.jsp").forward(req, resp);
    }

    protected void getStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<Map<String, Object>> stu = student.getStu(id);
        req.setAttribute("stu", stu.get(0));
        req.getRequestDispatcher("/updata.jsp").forward(req, resp);
    }

    protected void updateStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        String id = req.getParameter("id");
        int i = student.updateStu(new Student(Integer.parseInt(id), name, Integer.parseInt(age), address));
        req.getRequestDispatcher("/updata.jsp").forward(req, resp);
    }
}
