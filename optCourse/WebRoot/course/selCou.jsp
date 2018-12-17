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
    
    <title>My JSP 'selCou.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    
   <script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
// $(function(){
 	
// });
$(function(){
	if(${delIndex}){
		alert("已删除该课程！");
		<%
		    session.removeAttribute("delIndex");
		%>
	}
	
// 	$("#delete").click(function(){
// 		var couid = $(".couid").html();
//  		alert("你确定删除该课程！="+couid);
//          return false;
//  	});
});
</script>
  </head>
  
  <body>
     <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">个人信息</a></li>
    <li><a href="#">查看我的选课</a></li>
    </ul>
    </div>
    <c:if test="${optcou==1}">
      <div class="rightinfo">
	    
	    <table class="tablelist" >
	    	<thead>
	    	<tr>
	        <th>课程编号</th>
	        <th>名称名称</th>
	        <th>任教老师</th>
	        <th>课程描述</th>
	        <th>课程学分</th>
	        <th>取消选课</th>
	        </tr>
	        </thead>
	        <tbody>
	        <c:forEach items="${courses}" var="cou">
	        
	        <tr>
	         <td class='couid'>${cou.couid}</td>
	         <td>${cou.couname}</td>
	         <td>${cou.teacher}</td>
	         <td>${cou.couexp}</td>
	         <td>${cou.credit}</td>
	         <td ><a href="selCou?oper=delete&couid=${cou.couid}">删除</a></td>
	        </tr>
	        </c:forEach>
	        </tbody>
	    </table>
    </div>
    
    </c:if>
    <c:if test="${optcou==0}">
        <div style="font-size:18px;text-align:center;margin:60px;">目前没有选课信息</div>
    </c:if>

  </body>
</html>
