<%--
  Created by IntelliJ IDEA.
  User: 张泽隆
  Date: 2024/3/2
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType= "text/html;charset=utf-8%>
<HTML> <BODY bgcolor=Cyan><Font size=8><a href="index.jsp'>回到首页</a>
<% request.setCharacterEncoding("utf-8"); // String yourName=new String((request.getParameter("name")).getBytes("iso-8859-String yourName=request.getParameter("name");String yourSex=request.getParameter("R");//获取radio提交的值
String secretMess=request.getParameter("secret");//获取hidden提交的值
String personName[]=request.getParameterValues("superstar");//获取checkbox提交的值
out.println("<P> 您的姓名:"+yourName+"</P>");
out.println("<P>您的性别:"+yourSex+"</P>");
out.println("<P>您喜欢的歌手:");
if(personName==null)
{out.print("一个都不喜欢");}
else {
for(int k=0;k<personName.length;k++) {out.println(" "+personName[k]);}}
out.println("<P>hidden提交的值:"+secretlMess);%>
<p>姓名：$(param.name)</FONT></BODY></HTML>
