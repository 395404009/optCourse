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
    
    <title>My JSP 'optCou.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});

/* $(function(){
	
// 	var optflag=${optflag};
// 	alert(optflag);
	
	$(".optCou").click(function(){
		  var tr = $(this).closest("tr");
		  var data=tr.find("td.eq(2)").text();
		  alert("tr="+data);

		  alert($(this).attr("couid"));
		  alert("Value: " + $(".optCou").text()+$(".couid").text());
		  //var couid=1010;
		  window.location.href = "Course?oper=optCou&couid="+couid;
		  return false;
	});
	
}); */

function onclickOptCou(index){
	//console.info(index);
	
	var couid = $(index).attr("varid");
	var optCou = $(index).attr("varopt");
	if(optCou=="OPT"){
		alert("不能重复选择该课程！");
	}else{
		var flag=window.confirm("是否选择课程?");
		if(flag){
			window.location.href = "Course?oper=optCou&couid="+couid;
		}
		
	}
	
    return false;
}
</script>

</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">选课信息</a></li>
    <li><a href="#">查看选课信息</a></li>
    </ul>
    </div>
    <div class="rightform">
        <form action="Course?oper=allcou" method="post">
		        <input type="text" name="couname" placeholder="课程名称"/>
		        <input type="text" name="teacher" placeholder="任教老师"/>
		        <input type="submit" value="查询" style="width:50px;margin-left:20px;background-color:#ebb683"/>
	    </form>
	</div>
    <div class="rightinfo">
	    
	    <table class="tablelist" >
	    	<thead>
	    	<tr>
	        <th>课程编号</th>
	        <th>名称名称</th>
	        <th>任教老师</th>
	        <th>课程描述</th>
	        <th>课程学分</th>
	        <th>选课</th>
	        </tr>
	        </thead>
	        <tbody>
	        <c:forEach items="${pageinfo.list}" var="pList">
	        
	        <tr>
	         <td class="couid">${pList.couid}</td>
	         <td>${pList.couname}</td>
	         <td>${pList.teacher}</td>
	         <td>${pList.couexp}</td>
	         <td>${pList.credit}</td>
	         <td class="optCou" varid="${pList.couid}" varopt="${pList.optCou}"  onclick="onclickOptCou(this)"><p >${pList.optCou=="OPT"?"已选":"未选"}<p></td>
	        </tr>
	        </c:forEach>
	        </tbody>
	    </table>
    </div>
    <div class="pinfo">
                当前为第${pageinfo.pageNumber}页,共${pageinfo.total}页
    </div>
    <div class="pagesy">
       <a href="Course?pageNumber=1&pageSize=${pageinfo.pageSize}&oper=allcou">首页</a>
       <a href="Course?pageNumber=${pageinfo.pageNumber-1}&pageSize=${pageinfo.pageSize}&oper=allcou" <c:if test="${pageinfo.pageNumber<=1 }">  onclick="javascript:return false;" </c:if>">[上一页]</a>
       <a href="Course?pageNumber=${pageinfo.pageNumber+1}&pageSize=${pageinfo.pageSize}&oper=allcou" <c:if test="${pageinfo.pageNumber>=pageinfo.total}">  onclick="javascript:return false;" </c:if>">[下一页]</a>
       <a href="Course?pageNumber=${pageinfo.total }&pageSize=${pageinfo.pageSize}&oper=allcou">末页</a>
    </div>
</body>
</html>
