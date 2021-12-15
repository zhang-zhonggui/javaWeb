package com.zzg.day03.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: zzg
 * @Description: filter过滤器，用于设置字符码格式，防止乱码
 * @DateTime: 2021/11/27 9:58
 */

public class CharsetFilter implements Filter {
   private String charset=null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        charset=filterConfig.getInitParameter("charset");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设置字符格式
        servletRequest.setCharacterEncoding(charset);
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void destroy() {


    }
}
