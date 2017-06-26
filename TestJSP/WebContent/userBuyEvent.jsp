<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>userBuyEvent.jsp</title>
</head>
<script>
$(document).ready(function(){
	$('#userBuy_submit').click(function(){
		$('#list').load('UserBuy',{userBuy_userName:$('#userBuy_userName').val(),
			userBuy_objName:$('#userBuy_objName').val()});
		return false;
	});
});
</script>
<body>
	<table>
	<tr>
	<td>고객 이름</td><td><input id='userBuy_userName'/></td>
	</tr>
	<tr>
	<td>물품 이름</td><td><input id='userBuy_objName'/></td>
	</tr>
	</table>
	<button id='userBuy_submit'>등록</button>
	</body>
</html>