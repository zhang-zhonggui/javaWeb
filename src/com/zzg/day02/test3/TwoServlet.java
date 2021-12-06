package com.zzg.day02.test3;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: zzg
 * @Description: 底层代码中 Selvet的写法课后的练习
 * @DateTime: 2021/11/27 9:58
 */
public class TwoServlet extends OneServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        service(req, resp);
    }

    public void service(HttpServletRequest servletRequest, HttpServletResponse servlet) {

    }
}
