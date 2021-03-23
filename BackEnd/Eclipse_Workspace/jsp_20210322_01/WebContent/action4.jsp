<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>action4</title>
    </head>
    <body>
        <%
            Enumeration<String> keys = request.getParameterNames();
        	while(keys.hasMoreElements())
        	{
        		String key = keys.nextElement();
        		if(key.equals("hobby"))
        		{
        			out.println("hobby = ");
        			for(String s : request.getParameterValues("hobby"))
        			{
        				out.print(s + " ");
        			}
        			out.println("<br>");
        		}
        		else
        		{
        			out.println(key + " = " + request.getParameter(key) + "<br>");
        		}
        	}
        %>
    </body>
</html>