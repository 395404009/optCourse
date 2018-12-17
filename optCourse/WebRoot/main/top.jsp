<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected");
		$(this).addClass("selected");
	});
	//退出功能
	$("#out").click(function(){
		var flag=window.confirm("你真的要退出吗?");
		if(flag){
			window.top.location.href="Course?oper=out";
		}
	});
	
	
});	
</script>

  </head>
  
  <body style="background:url(images/topbg.gif) repeat-x;">
  <div class="topleft">
    <a href="main/main.jsp" target="_parent"><img src="images/logo.png" title="系统首页"  style="width:80px;"/></a>
         <div style="font-size:26px;color:#fff;position:absolute; top:35px;left:100px;">学生选课系统</div>
    </div>
         
    <div class="topright">   
             <div style="position:absolute; top:65px;left:1200px;">当前在线人数:${applicationScope.count}</div>
	    <ul>
	    
	    <li><a  href="javascript:void(0)" id="out">退出</a></li>
	    </ul>
	     
	    <div class="user">
	    <span>${stu.stuname}欢迎登录</span>
	   
	    </div>    
	    
    </div>
    
        
  </body>
</html>
