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
	pstmt=conn.prepareStatement("select * from (select * from sell inner join m_user on buy_user_indx=user_indx) inner join obj on sell_obj_indx=obj_indx");
	rs=pstmt.executeQuery();
	out.println("<table border=\"1\">");
	out.println("<tr>");
	out.println("<th>"+"구매자"+"</th>");
    out.println("<th>"+"물품 이름"+"</th>");
    out.println("<th>"+"물품 가격"+"</th>");
    out.println("</tr>");
	while(rs.next()){
		out.println("<tr>");
		out.println("<td>"+rs.getString("user_name")+"</td>");
        out.println("<td>"+rs.getString("obj_name")+"</td>");
        out.println("<td>"+rs.getString("obj_price")+"</td>");
        out.println("</tr>");
	}
	out.println("</table>");
	pstmt.close();
	stmt.close();
	conn.close();
%>
</body>
</html>