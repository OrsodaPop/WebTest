/*package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;*/
package com.it.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringJoiner;

@WebServlet("/courseTest")
public class CourseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("hello git-01");
        if("张三".equals(name)&&"123".equals(password)){
            req.setAttribute("name",name);
            req.setAttribute("password",password);
            String[] hobby = req.getParameterValues("course");
            StringJoiner joiner = new StringJoiner(",","[","]");

            for (String s : hobby) {
                joiner.add(s);
            }

            req.setAttribute("hobby",joiner.toString());
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }else {
            req.getSession().setAttribute("name",name);
            resp.sendRedirect("fail.jsp");
        }

    }
}
