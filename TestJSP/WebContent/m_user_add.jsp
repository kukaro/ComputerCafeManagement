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
	$('#user_submit').click(function(){
		$('#list').load('AddUser',{v_m_user_id:$('#v_m_user_id').val(),
			v_m_user_pass:$('#v_m_user_pass').val(),
			v_m_user_name:$('#v_m_user_name').val(),
			v_m_user_phone:$('#v_m_user_phone').val(),
			v_m_user_birth:$('#v_m_user_birth').val()});
		return false;
	});
});
</script>
<body>
	<table>
	<tr>
	<td>ID</td><td><input id='v_m_user_id'/></td>
	</tr>
	<tr>
	<td>�н�����</td><td><input id='v_m_user_pass'/></td>
	</tr>
	<tr>
	<td>�̸�</td><td><input id='v_m_user_name'/></td>
	</tr>
	<tr>
	<td>�޴���ȭ��ȣ</td><td><input id='v_m_user_phone'/></td>
	</tr>
	<tr>
	<td>����</td><td><input id='v_m_user_birth'/></td>
	</tr>
	</table>
	<button id='user_submit'>���</button>
</body>
</html>