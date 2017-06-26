<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>newInputEvent.jsp</title>
</head>
<script>
$(document).ready(function(){
	$('#newInput_submit').click(function(){
		$('#list').load('NewInput',{newInput_name:$('#newInput_name').val(),
			newInput_count:$('#newInput_count').val()});
		return false;
	});
});
</script>
<body>
	<table>
	<tr>
	<td>물품 이름</td><td><input id='newInput_name'/></td>
	</tr>
	<tr>
	<td>물품 수량</td><td><input id='newInput_count'/></td>
	</tr>
	</table>
	<button id='newInput_submit'>등록</button>
</body>
</html>