<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生选课系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="/optCourse/css/style.css" rel="stylesheet" type="text/css" />
	<script src="/optCourse/js/cloud.js" type="text/javascript"></script>
	<script language="JavaScript" src="/optCourse/js/jquery.js"></script>
<script language="javascript">
$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    });

	$("#code").click(function(){
			//浏览器带有缓存功能,不会多次请求相同数据
			$("img").attr("src","ValidCode?date="+new Date());
			return false;
	});
	

	if(${stu.login=='not_the_student'}){
		alert("该用户不存在！");
	}else if(${stu.login=='name_pwd_match'}){
		alert("用户名与密码不匹配！");
	}else if(${stu.login=='code_match'}){
		alert("验证码不正确！");
	}
	<%
	    session.removeAttribute("stu");
	%>
});  
	
</script> 

</head>
<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  
    <div class="logintop">    
     <span>欢迎登录学生选课界面平台</span> 
        
    </div>
    
    <div class="loginbody">
    
<!-- 	    <span class="systemlogo"></span>  -->
          <span  class="systemlogo">学生选课系统</span>
	     <br />
    
	    <div class="loginbox loginbox3">
 		    <form action="stu" method="post"> 
	        <input type="hidden" name="oper" value="login">
		    <ul>
		    <li><input name="stuname" type="text" class="loginuser" vaues="" placeholder="admin" onclick="JavaScript:this.value=''"/></li>
		    <li><input name="stupwd" type="password" class="loginpwd" placeholder="密码" onclick="JavaScript:this.value=''"/></li>
		    <li class="yzm">
		    <span><input name="code" type="text"  placeholder="验证码" onclick="JavaScript:this.value=''"/></span><cite id="code"><img src="ValidCode" width="114" height="46"/></cite>
		    </li>
		    <li><input name="" type="submit" class="loginbtn" value="登录"  onclick="javascript:window.location='main.html'"  />
		    <label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="course/Reg.jsp" style="font-size:16px;">注册</a></label></li>
		    </ul>
		  </form>
	    </div>
    
    </div>
    
    
    <div class="loginbm">仅供学习交流，勿用于任何商业用途</div>
	
    
</body>

</html>


  
