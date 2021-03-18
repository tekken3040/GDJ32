<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- xml/html 주석 -->
<%-- JSP 주석 --%>
<%!
    // 선언문(declaration)
    // 주의) JSE(O), JEE(X)
    // out.println("JSP"); // JSP(X) : JSP 사용 불가
    String name = "jsp";
    public void print(String str)
    {
        System.out.println("print : " + str);
        // System.out.println("print : " + str); // JSP사용불가
    }
%>
<%
    // 스크립트릿(SCriptlet)
    // JEE(O)
    // out.println("JSP");
%>

<html lang="ko">
    <head>
        <title>VS CODE에서 JSP 동작시키기</title>
    </head>
    <body>
        <h1> test.jsp 페이지입니다.</h1>
        <%
            out.println("JSP<br>");
            out.println("Servlet");
        %>
        <hr>
        <%@ include file="Includer.jsp" %>
        <hr>
    </body>
</html>