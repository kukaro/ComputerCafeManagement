<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page language="java" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>obj.jsp</title>
</head>
<script>
$(document).ready(function(){
	$('#toObj_submit').click(function(){
		$('#list').load('InputToObj');
		return false;
	});
});
</script>
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
	pstmt=conn.prepareStatement("select * from obj inner join m_input on obj.OBJ_INDX=m_input.INPUT_OBJ_INDX");
	rs=pstmt.executeQuery();
	out.println("<table border=\"1\">");
	out.println("<tr>");
    out.println("<th>"+"물품 이름"+"</th>");
    out.println("<th>"+"물품 가격"+"</th>");
    out.println("<th>"+"물품 수량"+"</th>");
    out.println("</tr>");
	while(rs.next()){
		out.println("<tr>");
        out.println("<td>"+rs.getString("obj_name")+"</td>");
        out.println("<td>"+rs.getString("obj_price")+"</td>");
        out.println("<td>"+rs.getString("input_count")+"</td>");
        out.println("</tr>");
	}
	out.println("</table>");
	pstmt.close();
	stmt.close();
	conn.close();
%>
<br>
<button id='toObj_submit'>재고품으로 넘기기</button>
</body>
</html>