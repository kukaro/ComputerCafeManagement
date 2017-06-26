<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>newBadEvent.jsp</title>
</head>
<script>
$(document).ready(function(){
	$('#newBad_submit').click(function(){
		$('#list').load('NewBad',{newBad_name:$('#newBad_name').val(),
			newBad_count:$('#newBad_count').val()});
		return false;
	});
});
</script>
<body>
	<table>
	<tr>
	<td>물품 이름</td><td><input id='newBad_name'/></td>
	</tr>
	<tr>
	<td>물품 수량</td><td><input id='newBad_count'/></td>
	</tr>
	</table>
	<button id='newBad_submit'>등록</button>
	</body>
</html>