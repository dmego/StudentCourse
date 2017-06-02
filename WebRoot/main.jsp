<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>订餐管理系统主界面</title>
   </head>
   <%
   session = request.getSession();
   String username = (String)session.getAttribute("username");
    %>
   <body>
    <div >
     <br/><br/><br/><br/><br/><br/><p><center><font size="+2" color="red">学生—课程管理系统</font></center></p>
   </div>
    </body>
</html>
