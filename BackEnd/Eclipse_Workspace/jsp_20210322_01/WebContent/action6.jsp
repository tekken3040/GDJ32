<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.MemberDto" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>action6</title>
</head>
<body>
	<%--
		MemberDto dto = new MemberDto();
		dto.setId("java");
		out.println("id : " + dto.getId());
	--%>
	<jsp:useBean id="dto2" class="bean.MemberDto" scope="page">
		<%--<jsp:setProperty name="dto2" property="id" value=""/> --%>
		<jsp:setProperty name="dto2" property="*"/>
	</jsp:useBean>
	id : <jsp:getProperty property="id" name="dto2"/>
	pw : <jsp:getProperty property="pw" name="dto2"/>
	name : <jsp:getProperty property="name" name="dto2"/>
	address : <jsp:getProperty property="address" name="dto2"/>
	hobby : <%--<jsp:getProperty property="hobby" name="dto2"/> --%>
	<%
		for(String s : dto2.getHobby())
		{
	%>
		<%=
			s + " "
		%>
	<%
		}
	%>
</body>
</html>