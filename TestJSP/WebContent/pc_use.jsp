<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page language="java" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>pc_use.jsp</title>
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
	pstmt=conn.prepareStatement("select * from m_user inner join pc on m_user.user_used_pc_indx=pc.PC_INDX");
	rs=pstmt.executeQuery();
	out.println("<table border=\"1\">");
	out.println("<tr>");
    out.println("<th>"+"사용자 이름"+"</th>");
    out.println("<th>"+"사용자 ID"+"</th>");
    out.println("<th>"+"사용 PC"+"</th>");
    out.println("<th>"+"현재 PC이용 시간"+"</th>");
    out.println("<th>"+"현재 PC이용 금액"+"</th>");
    out.println("</tr>");
	while(rs.next()){
		out.println("<tr>");
        out.println("<td>"+rs.getString("user_name")+"</td>");
        out.println("<td>"+rs.getString("user_ID")+"</td>");
        out.println("<td>"+rs.getString("user_used_pc_indx")+"</td>");
        out.println("<td>"+rs.getString("user_time")+"</td>");
        out.println("<td>"+rs.getString("user_coast")+"</td>");
        out.println("</tr>");
	}
	out.println("</table>");
	pstmt.close();
	stmt.close();
	conn.close();
%>
</body>
</html>