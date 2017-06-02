<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
    <title>首页</title>
     <!--引入的外部CSS样式s文件-->  
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <!--引入的外部JS脚本文件-->  
    <script type="text/javascript" src="js/script.js"></script>
    <script type="text/javascript" src="js/jump.js"></script>   
</head>  
   
<body>  
<h1 align="center">学生—课程管理系统</h1><br><hr>
<div id="nav" class="nav">
      <ul style="position: absolute;">    
          <li onmouseover="showsub(this)" onmouseout="hidesub(this)"><a href="#">学生管理</a>  
              <ul>  
                  <li><a id="stuadd" onclick="test()">添加学生</a></li>  
                  <li><a id="stumanager" onclick="test()">管理学生</a></li>  
              </ul>  
          </li>  
          <li  onmouseover="showsub(this)" onmouseout="hidesub(this)"><a href="#">课程管理</a>  
              <ul  >  
                  <li><a id="couradd" onclick="test()">添加课程</a></li>  
                  <li><a id="coumanager" onclick="test()">管理课程</a></li>  
              </ul>  
          </li> 
          <li  onmouseover="showsub(this)" onmouseout="hidesub(this)"><a href="#">选课管理</a>  
              <ul  >  
                  <li><a id="scadd" onclick="test()">选课</a></li>  
                  <li><a id="scmanager" onclick="test()">提交成绩</a></li>  
              </ul>  
          </li>
         <li><a id="infoSelect" onclick="test()">信息查询</a></li> 
     </ul>  
</div>
<div align="center">
<iframe id="iframe" src="main.jsp" width="1200" height="500"></iframe>
</div>
</body>  
</html>  
