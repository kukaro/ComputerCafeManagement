<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>inUserEvent</title>
</head>
<script>
$(document).ready(function(){
	$('#inUser_submit').click(function(){
		$('#list').load('InUser',{inUser_name:$('#inUser_name').val(),
			inUser_pc:$('#inUser_pc').val()});
		return false;
	});
});
</script>
<body>
	<table>
	<tr>
	<td>이름</td><td><input id='inUser_name'/></td>
	</tr>
	<tr>
	<td>컴퓨터 번호</td><td><input id='inUser_pc'/></td>
	</tr>
	</table>
	<button id='inUser_submit'>등록</button>
	</body>
</html>