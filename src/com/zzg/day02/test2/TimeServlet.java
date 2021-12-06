package com.zzg.day02.test2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: zzg
 * @Description: servlet 生命周期的测试
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/test2")
public class TimeServlet extends HttpServlet {
    public  TimeServlet(){
        System.out.println("函数被构造时");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("servlet初始化函数");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet的执行代码");
    }

    @Override
    public void destroy() {
        System.out.println("servlet被销毁");
    }
}
