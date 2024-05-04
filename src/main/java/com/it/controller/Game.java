package com.it.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/game")
public class Game extends HttpServlet {
    private int times = 5;
     Random r = new Random();
     int randNum = r.nextInt(100) + 1;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println(randNum);

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(" <html> <body>");
        out.println("<p>请你猜一个数字从1-100之间，有5次机会</p>");
        out.println("<form action=\"game\" method=\"post\">");
        out.println("<input placeholder=\"请输入\" type=\"text\" name=\"number\">");
        out.println("<button>确认</button>");
        out.println("<br>");
        PrintWriter writer = response.getWriter();
        String number = request.getParameter("number");
        int num = Integer.parseInt(number);
        if (times>0&&num>randNum){
            writer.write("大了");
            times--;

        }
        if (times>0&&num<randNum) {
            writer.write("小了");
            times--;
        }
        if (num==randNum) {
            writer.write("您猜对了,游戏结束.新一轮开始");
            times = 5;
            randNum = r.nextInt(100) + 1;
        }
        if (times==0) {
            times = 5;
            randNum = r.nextInt(100) + 1;
            writer.write("游戏结束了，您失败了，新一轮开始");
        }
        out.println("<p>剩余");
        out.println(times);
        out.println("次机会</p>");
        out.println(" </form>");
        out.println(" </body> </html>");
    }
}
