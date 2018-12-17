<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="/optCourse/js/cloud.js" type="text/javascript"></script>
    <link href="/optCourse/css/reg.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="/optCourse/js/jquery.js"></script>
<script language="javascript">
$(function(){
	var username = false;
	var password = false;
	var passwordSure = false;
	
	//学号的验证
	$(":text:eq(0)").blur(function(){
		if($(this).val()==""){
			$(this).next().css("color","red").html("*");
			username = false;
		}else{
			$(this).next().css("color","green").html("*");
			username = true;
		}
	});
	//姓名的验证
	$(":text:eq(1)").blur(function(){
		if($(this).val()==""){
			$(this).next().css("color","red").html("*");
			username = false;
		}else{
			$(this).next().css("color","green").html("*");
			username = true;
		}
	});
	//密码的验证
	$(":password:eq(0)").blur(function(){
		//在js中要求正则两侧//
		if(!$(this).val().match(/^\w{3,6}$/)){
			$(this).next().css("color","red").html("*");
			password= false;
		}else{
			$(this).next().css("color","green").html("*");
			password = true;
		}
	});
	//确认密码
	$(":password:eq(1)").blur(function(){
		if($(this).val()==""||$(this).val()!=$(":password:eq(0)").val()){
			$(this).next().css("color","red").html("*");
			passwordSure = false;
		}else{
			$(this).next().css("color","green").html("*");
			passwordSure = true;
		}
	});
	
	
	$(":submit").click(function(){
		if(username==false||password==false||passwordSure==false||$(":file").val()==""){
			alert("请添加完整信息");
			return false;
		}
	});
	 
	 //判断注册
	 if(${reg=="success"}){
		 alert("注册成功！");
	 }else if(${reg=="flase"}){
		 alert("注册失败！");
	 }else if(${reg=="exist"}){
		 alert("该用户已存在！");
	 }
	 <%
	      session.removeAttribute("reg");
	 %>
});

</script>
  </head>
  
  <body >
     <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
     </div>  
   
      <div class="regtop" style="background:url(images/topbg.gif) repeat-x;">
         <div class="regleft" >
          <a href="login.jsp" target="_parent"><img src="images/logo.png" title="系统首页"  style="width:80px;"/></a>
           <div style="font-size:26px;color:#fff;position:absolute; top:35px;left:100px;">学生选课系统</div>
         </div>
         
              
    <div class="regright">   
       
	    <a href="login.jsp">登录</a>
    </div>
      </div>
      <div class="reg" >
         <form action="stu?oper=reg" method="post">
           <div class="thm"><span>学生注册</span></div>
            <table >
             <tr><th>学号:</th><td><input type="text" placeholder="001" name="stuid" /><span></span></td></tr>
             <tr><th>姓名:</th><td><input type="text" name="stuname"/><span></span></td></tr>
             <tr><th>密码:</th><td><input type="password" name="pwd"/><span></span></td></tr>
             <tr><th>确认密码:</th><td><input type="password" name="pwdTo"/><span></span></td></tr>
             <tr><th>性别</th><td>	
                                           男: <input type="radio" name="sex" value="1" checked="checked"/>
					女: <input type="radio" name="sex" value="0"/></td></tr>
             <tr><th>学院</th><td>
                  <select name="stuinstitute">
                     <option selected >--请选择学院--</option>
                     <option >信息工程学院</option>
                     <option >材料科学与工程学院</option>
                     <option >机械电子工程学院</option>
                     <option >管理与经济学院</option>
                  </select>
                 </td></tr> 
             <tr><td align="center" colspan="2"><input type="submit" id="stureg" value="提交注册">
                <input type="reset" value="重新填写">
              </td></tr>         
            </table>
          </form>
      </div>
      
  </body>
</html>
