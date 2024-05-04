package com.it.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

@WebServlet("/test2/welcome")
public class WelcomeYou extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String WelcomeInfo = "Welcome You"+user+"同学!";
        resp.setContentType("text/html;charset=GB2312");
//        String ipAddress = getIpAddress(req,resp);
        String remortIP = getRemortIP(req);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = dateFormat.format(date);
        System.out.println(formatDate);
        System.out.println("========================");
//        System.out.println(ipAddress);
//        System.out.println(remortIP);
        System.out.println("==============================");
        PrintWriter out = resp.getWriter();
        out.println("<HTML>");
        out.println("   <head><title>Title</title></head>");
        out.println(" <body>");
        out.println(WelcomeInfo);
        out.println(formatDate);
        out.println(remortIP);
        out.println("   </body");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
    public static String getIpAddress(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String ip = null;

        //X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");
        System.out.println("====ipAddresses:"+ipAddresses);
        Enumeration<String> headerNames = request.getHeaderNames();
        int time = 1;
        while (headerNames.hasMoreElements()) {
            //打印所有头信息
            String s = headerNames.nextElement();
            String header = request.getHeader(s);
            if(time>=1){
                response.getWriter().write(header);
                time--;
            }
            System.out.println(s+"::::"+header);
        }
//        System.out.println("headerNames:"+JSON.toJSONString(headerNames));
        System.out.println("RemoteHost:"+request.getRemoteHost());
        System.out.println("RemoteAddr:"+request.getRemoteAddr());

        String unknown = "unknown";
        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }

        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }

        //还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    public String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            System.out.println("nima");
            return request.getRemoteAddr();
        }
        return request.getHeader("Host");
    }
}
