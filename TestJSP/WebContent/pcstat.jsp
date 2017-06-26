<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page language="java" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>obj.jsp</title>
</head>
<body>
<%
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "qwerty";
	String pass = "qwerty";
	Connection conn;
	Statement  stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url, user, pass);
	stmt = conn.createStatement();
	pstmt=conn.prepareStatement("select * from pc");
	rs=pstmt.executeQuery();
	out.println("<table border=\"1\">");
	out.println("<tr>");
    out.println("<th>"+"PC번호"+"</th>");
    out.println("<th>"+"그래픽카드상태"+"</th>");
    out.println("<th>"+"하드디스크상태"+"</th>");
    out.println("<th>"+"메모리상태"+"</th>");
    out.println("</tr>");
	while(rs.next()){
		out.println("<tr>");
        out.println("<td>"+rs.getString("pc_indx")+"</td>");
        out.println("<td>"+rs.getString("pc_g")+"</td>");
        out.println("<td>"+rs.getString("pc_h")+"</td>");
        out.println("<td>"+rs.getString("pc_m")+"</td>");
        out.println("</tr>");
	}
	out.println("</table>");
	pstmt.close();
	stmt.close();
	conn.close();
%>
</body>
</html>