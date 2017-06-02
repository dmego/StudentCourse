<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>添加学生</title>
<meta http-equiv="Content-Type" content="text\html;charset=utf-8">
<meta http-equiv="viewport"
    content="width=device-width,initial-scale=1.0">
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css" />

</head>
<body>
    <div class="container" >
        <h3 align="center">添加学生</h3>
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <form role="form" class="form-horizontal"
                action="${pageContext.request.contextPath }/student/stuServlet?method=addStu&updateSno=${student.getSno()}"
                method="post" >
                <div class="form-group">
                    <label class="col-md-3 control-label">学号</label>
                    <div class="col-md-9">
                        <input class="form-control" name="Sno" type="text"
                            id="Sno" placeholder="Sno"
                            value="${student.getSno()}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">姓名</label>
                    <div class="col-md-9">
                        <input class="form-control" name="Sname" type="text"
                            id="Sname" placeholder="Sname"
                            value="${student.getSname()}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">性别</label>
                    <div class="col-md-9">
                        <input class="form-control" name="Ssex" type="text"
                            id="Ssex" placeholder="Ssex"
                            value="${student.getSsex()}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">年龄</label>
                    <div class="col-md-9">
                        <input class="form-control" name="Sage" type="text"
                            id="Sage" placeholder="Sage"
                            value="${student.getSage()}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">院系</label>
                    <div class="col-md-9">
                        <input class="form-control" name="Sdept" type="text"
                            id="Sdept" placeholder="Sdept"
                            value="${student.getSdept()}" />
                    </div>
                </div>                
                
                <div class="form-group"></div>
                <div class="form-group">
                    <div class="col-md-offset-3 col-md-9">
                        <button type="submit" class="btn btn-primary btn-block">提交</button>
                    </div>
                </div>
                <c:if test="${param.status.equals('1')}">
                    <div class="alert alert-danger" role="alert">添加成功</div>
                </c:if>
                 <c:if test="${param.status.equals('2')}">
                    <div class="alert alert-danger" role="alert">该同学已存在</div>
                </c:if>
            </form>
        </div>
    </div>
    <div class="col-md-3"></div>
        <script
            src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js"
            type="text/javascript"></script>
        <script
            src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.js"
            type="text/javascript"></script>
        <script
            src="${pageContext.request.contextPath}/static/js/jquery.validate.js"
            type="text/javascript"></script>
        <script
            src="${pageContext.request.contextPath}/static/js/myValidate.js"
            type="text/javascript"></script>
</body>
</html>
