<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script>
$(document).ready(function(){
	$('#pc_submit').click(function(){
		$('#list').load('AddPc',{pc_g:$('#pc_g').val(),
			pc_h:$('#pc_h').val(),
			pc_m:$('#pc_m').val()});
		return false;
	});
});
</script>
<body>
	<table>
	<tr>
	<td>�׷���ī�� ����</td><td><input id='pc_g'/></td>
	</tr>
	<tr>
	<td>�ϵ��ũ ����</td><td><input id='pc_h'/></td>
	</tr>
	<tr>
	<td>�޸�ī�� ����</td><td><input id='pc_m'/></td>
	</tr>
	</table>
	<button id='pc_submit'>���</button>
</body>
</html>