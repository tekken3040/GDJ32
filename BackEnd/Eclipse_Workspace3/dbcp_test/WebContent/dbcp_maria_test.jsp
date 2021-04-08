<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
    String id = "";
	
	Connection con =null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try {
		Context initContext = new InitialContext();
		
		// 참고) http://tomcat.apache.org/tomcat-9.0-doc/jndi-resources-howto.html
		// mariaDB Connector/J 사용법 
		// : https://mariadb.com/kb/en/about-mariadb-connector-j/#using-drivermanager

		// howto-1)
		// Context envCtx = (Context)initContext.lookup("java:comp/env");
		// DataSource ds = (DataSource)envCtx.lookup("jdbc/xe");
	
		// howto-2)
		DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/bigdb");
		
		con=ds.getConnection();
		
		String sql ="SELECT empno FROM emp";
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {						
			id = rs.getString(1);		
			out.println(id+" ");
		}
				
	} catch(Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	} finally {
		rs.close();
		pstmt.close();
		con.close();
	}
%>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>DBCP testing</title>
</head>
<body>
</body>
</html>