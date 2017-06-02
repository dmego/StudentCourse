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
                <h3 align="center">学生信息列表</h3>
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
                        <td align="center" colspan="2">操作</td>
                    </tr>
                    <c:forEach items="${students}" var="item" varStatus="status">
                        <tr>
                            <td>${item.getSno()}</td>
                            <td>${item.getSname()}</td>
                            <td>${item.getSsex()}</td>
                            <td>${item.getSage()}</td>
                            <td>${item.getSdept()}</td>
                            <td><a href="${pageContext.request.contextPath}/student/stuServlet?method=update&Sno=${item.getSno() }">修改 </a></td>  
                            <td><a href="${pageContext.request.contextPath}/student/stuServlet?method=delete&Sno=${item.getSno() }">删除 </a></td> 
                        </tr>
                    </c:forEach>
                </table>
                <c:if test="${param.status.equals('2') }">
                    <div class="alert alert-success" role="alert">修改成功</div>
                </c:if>
                <c:if test="${param.status.equals('3') }">
                    <div class="alert alert-success" role="alert">删除成功</div>
                </c:if>
            </div>    
       </div>
    </div>
  </body>
</html>
