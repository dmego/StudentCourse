<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>提交成绩</title>
<meta http-equiv="Content-Type" content="text\html;charset=utf-8">
<meta http-equiv="viewport"
    content="width=device-width,initial-scale=1.0">
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css" />

</head>
<body>
    <div class="container">
        <h3 align="center">提交成绩</h3>
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <form role="form" class="form-horizontal"
                action="${pageContext.request.contextPath }/sc/scServlet?method=update"
                method="post">
                <div class="form-group">
                    <label class="col-md-3 control-label">学号</label>
                    <div class="col-md-9">
                        <input class="form-control" name="Sno" type="text" id="Sno"
                            value="${sc.getSno() }" readonly="readonly"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">课程号</label>
                    <div class="col-md-9">
                        <input class="form-control" name="Cno" type="text" id="Cno"
                            value="${sc.getCno() }" readonly="readonly"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">成绩</label>
                    <div class="col-md-9">
                        <input class="form-control" name="Grade" type="text" id="Grade"
                            placeholder="Grade" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">选课类别</label>
                    <div class="col-md-9">
                        <input class="form-control" name="XKLB" type="text" id="XKLB"
                            value="${sc.getXKLB() }" readonly="readonly"/>
                    </div>
                </div>

                <div class="form-group"></div>
                <div class="form-group">
                    <div class="col-md-offset-3 col-md-9">
                        <button type="submit" class="btn btn-primary btn-block">提交成绩</button>
                    </div>
                </div>
                <c:if test="${param.status.equals('1')}">
                    <div class="alert alert-danger" role="alert">提交成功</div>
                </c:if>
                <c:if test="${param.status.equals('2')}">
                    <div class="alert alert-danger" role="alert">提交失败</div>
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
