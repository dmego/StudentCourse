<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>查看学生信息</title>    
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/css/bootstrap.css"/>
  </head>
  
  <body>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <h3 align="center">查询结果</h3>
            </div>
        </div>
        <div class="row-fluid">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <table class="table table-striped">
                    <tr>
                        <td>学号</td>
                        <td>姓名</td>
                        <td>性别</td>
                        <td>年龄</td>
                        <td>院系</td>
                    </tr>
                    <tr>
                        <td>${student.getSno()}</td>
                        <td>${student.getSname()}</td>
                        <td>${student.getSsex()}</td>
                        <td>${student.getSage()}</td>
                        <td>${student.getSdept()}</td>
                    </tr>
                </table>
            </div>    
       </div>
    </div>
  </body>
</html>