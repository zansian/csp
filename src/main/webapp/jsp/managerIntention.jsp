<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.njust.bean.*, cn.edu.njust.dao.*"%>
<jsp:include page="isAdmin.jsp"></jsp:include>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Admin admin = new Admin();
admin = (Admin) session.getAttribute("user");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'managerOpen.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

  <body>
  <%if(admin.getAdminGrade().equals("0000")) { %>
  	<center>
	    <form action="servlet/IntentionServelt" method="post" >
	    <table border="1">
	    	<tr>
	    		<td>学号</td>
	    		<td>姓名</td>
	    		<td>团报途径</td>
	    	</tr>
	    	<%
	    	IntentionDao dao = new IntentionDao();
	    	List<Intention> list = dao.getAllintention();
	    	for(int i=0; i<list.size(); i++) {
	    		Intention in = list.get(i);
	    	%>
	    	<tr>
	    		<td><input type="checkbox"name="stuID"value=<%=in.getStuID() %>><%=in.getStuID() %></td>
	    		<td><%=in.getName() %></td>
	    		<td><%=in.getIntention()%></td>
	    	</tr>
	    	<%} %>
	    	<tr><td><input type="submit" value="确认团报"></td></tr>
	    </table>
	    </form>
    </center>
    <% } else { %>
    	<center><a href="jsp/login.jsp">您并无此权限,请点此返回登录</a></center>
    <%} %>
    <button type="button" onclick="window.location.href='/CSP/jsp/managerMain.jsp';">返回</button>
    
  </body>
</html>