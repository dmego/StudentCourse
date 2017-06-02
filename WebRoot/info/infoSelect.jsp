<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>信息查询</title>
<meta http-equiv="Content-Type" content="text\html;charset=utf-8">
<meta http-equiv="viewport"
    content="width=device-width,initial-scale=1.0">
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css" />

</head>
<body>
    <div class="container">
        <h3 align="center">信息查询</h3>
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <form role="form" class="form-horizontal"
                action="${pageContext.request.contextPath }/info/infoServlet?method=select"
                method="post">
               <div class="form-group">
                    <label class="col-md-3 control-label">选择查询类别</label>
                    <div class="col-md-9">
		                <select name="selectInfo" class="form-control">
		                    <option value='0'>-- 请选择 --</option>
		                    <option value='1'>查询学生个人信息(Sno)</option>
		                    <option value='2'>查询学生学习情况(Sno)</option>
		                    <option value='3'>查询课程信息(Cno)</option>
		                    <option value='4'>查询课程选修情况(Cno)</option>
		                </select>
                 </div>
               </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">学号或课程号</label>
                    <div class="col-md-9">
                        <input class="form-control" name="SnoOrCno" type="text" id="SnoOrCno"
                            placeholder="Sno OR Cno" />
                    </div>
                </div>
                <div class="form-group"></div>
                <div class="form-group">
                    <div class="col-md-offset-3 col-md-9">
                        <button type="submit" class="btn btn-primary btn-block">查询</button>
                    </div>
                </div>
                <c:if test="${param.status.equals('1')}">
                    <div class="alert alert-danger" role="alert">未选择查询类别</div>
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
