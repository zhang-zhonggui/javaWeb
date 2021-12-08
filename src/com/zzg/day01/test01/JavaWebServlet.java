package com.zzg.day01.test01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class JavaWebServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter w = resp.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "1012");
            PreparedStatement ps = conn.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            List<Map> list = new ArrayList<>();
            while (rs.next()) {
                Map map = new HashMap();
                for (int i = 0; i < md.getColumnCount(); i++) {
                    map.put(md.getColumnName(i + 1), rs.getObject(i + 1));
                }
                list.add(map);
            }
            conn.close();

            w.write("<table border='1'>");
            for (Map<String, Object> map : list) {
                w.write("<tr>");
                w.write("<td>" + map.get("id") + "</td>");
                w.write("<td>" + map.get("sname") + "</td>");
                w.write("<td>" + map.get("sage") + "</td>");
                w.write("<td>" + map.get("saddress") + "</td>");
                w.write("</tr>");
            }
            w.write("</table>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
