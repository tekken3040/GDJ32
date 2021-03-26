<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.RequestDispatcher" %>
<%@ page import="serverImplTest.ActionServlet" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Result JSP</title>
</head>
<body>
	- 아이디 : <%= request.getAttribute("memberId") %><br>
	- 패쓰워드 : <%= request.getAttribute("memberPw") %><br>
	- 이름 : <%= request.getAttribute("memberName") %><br>
	- 주소 : <%= request.getAttribute("memberAddress") %><br>
</body>
</html>