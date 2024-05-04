package com.it.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/*")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String URI = request.getRequestURI();
        if(URI.contains("Login.jsp")){
            chain.doFilter(request,response);
            return;
        }
        if("caterpillar".equals(name)&&"123456".equals(password)&&URI.contains("hello")){
            chain.doFilter(request,response);
            return;
        }
        response.sendRedirect("Login.jsp");
        //用重定向的原因是：使用请求转发的该次请求已经被连接无法在将该请求跳转到指定页面，所以用重定向更好
    }



    @Override
    public void destroy() {

    }
}
