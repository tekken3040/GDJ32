<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>action</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

    String id = request.getParameter("id") == null ? "없음" : request.getParameter("id");
    String pw = request.getParameter("pw") == null ? "없음" : request.getParameter("pw");
    String name = request.getParameter("name") == null ? "없음" : request.getParameter("name");
    String address = request.getParameter("address") == null ? "없음" : request.getParameter("address");
    
    out.println("id : " + id + "<br>");
    out.println("pw : " + pw + "<br>");
    out.println("name : " + name + "<br>");
    out.println("address : " + address + "<br>");
%>
<%-- 표현식(expression) 활용 --%>
<%-- 
    id : <%=id %><br>
    pw : <%=pw %><br>
    name : <%=name %><br>
    address : <%=address %>
--%>
 
<!-- EL(Expressional Language) 기본 객체(param) 활용 -->
    id : ${param.id}<br>
    pw : ${param.pw}<br>
    name : ${param.name}<br>
    address : ${param.address}<br>
</body>
</html>