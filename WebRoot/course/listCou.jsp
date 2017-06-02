<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>查看课程信息</title>    
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/css/bootstrap.css"/>
  </head>
  
  <body>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <h3 align="center">课程信息列表</h3>
            </div>
        </div>
        <div class="row-fluid">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <table class="table table-striped">
                    <tr>
                        <td>课程号</td>
                        <td>课程名</td>
                        <td>学分</td>
                        <td>学期</td>
                        <td align="center" colspan="2">操作</td>
                    </tr>
                    <!-- forEach 遍历出couBeans -->
                    <c:forEach items="${courses }" var="item" varStatus="status">
                        <tr>
                            <td>${item.getCno()}</td>
                            <td>${item.getCname()}</td>
                            <td>${item.getCcredit()}</td>
                            <td>${item.getSemester()}</td>
                            <td><a href="${pageContext.request.contextPath}/course/couServlet?method=update&Cno=${item.getCno() }">修改 </a></td>  
                            <td><a href="${pageContext.request.contextPath}/course/couServlet?method=delete&Cno=${item.getCno() }">删除 </a></td> 
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
