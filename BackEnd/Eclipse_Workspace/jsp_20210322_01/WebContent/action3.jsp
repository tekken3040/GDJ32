<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--@ page import="java.util.Map, java.util.Set" --%>
<%--@ page import="java.util.*" --%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>action3</title>
</head>
<body>
<%
    Map<String, String[]> map = request.getParameterMap();
    Set<String> keys = map.keySet();
    Iterator<String> it = keys.iterator();

    while(it.hasNext())
    {
        String key = it.next();
        String values[] = map.get(key);

        if(values.length == 1)
        {
            out.println(key + "=" + values[0] + "<br>");
        }
        else
        {
            out.println(key + "=");
            for(String s : values)
            {
                out.println(s + " ");
            }
            out.println("<br>");
        }
    }
%>
</body>
</html>
