package com.zzg.day03.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String contextPath = req.getContextPath();
        String uri = req.getRequestURI();

        String path = uri.replace(contextPath, "");
        String[] pass = {"/", "/index.jsp", "/admin/login"};
        List<String> passList = Arrays.asList(pass);
        if (!passList.contains(path)) {
            Object admin = req.getSession().getAttribute("stu");
            if (admin == null) {
                resp.sendRedirect("/javaWeb");
                return;
            }
        }
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
