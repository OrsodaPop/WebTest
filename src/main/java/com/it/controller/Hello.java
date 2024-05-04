package com.it.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/hello")
public class Hello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String name = req.getParameter("name");
        PrintWriter out = resp.getWriter();
        out.write("cnm");
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<head>Hello</head>");
        out.print("</head>");
        out.print("<body>");
        out.printf("<h1> Hello! %s!%n</h1>",name);
        out.print("</body");
        out.print("/html");

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String name = req.getParameter("name");
        PrintWriter out = resp.getWriter();
        out.write("cnm");
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<head>Hello</head>");
        out.print("</head>");
        out.print("<body>");
        out.printf("<h1> Hello! %s!%n</h1>",name);
        out.print("</body");
        out.print("/html");
    }
}
