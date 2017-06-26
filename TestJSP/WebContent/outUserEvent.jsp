<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>outuserEvent.jsp</title>
</head>
<script>
$(document).ready(function(){
	$('#outUser_submit').click(function(){
		$('#list').load('OutUser',{outUser_name:$('#outUser_name').val()});
		return false;
	});
});
</script>
<body>
	<table>
	<tr>
	<td>이름</td><td><input id='outUser_name'/></td>
	</tr>
	</table>
	<button id='outUser_submit'>등록</button>
	</body>
</body>
</html>