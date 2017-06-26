<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page language="java" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>PC방 관리 페이지</title>
</head>
<body>
<div style="background: blue; text-align: center; padding: 10px  10px  10px  10px ; ">
<%@ include file = "top2.jsp" %>
</div>
<div style="background: black; text-align: center; padding: 10px  10px  10px  10px ; ">
<%@ include file = "top.jsp" %>
</div>
<div id ="list">
<%@ include file = "bottom.jsp" %>
</div>
<script>
$(document).ready(function(){
	$('#outUserEvent').click(function(){
		$('#list').load('outUserEvent.jsp');
		return false;
	});
});
$(document).ready(function(){
	$('#inUserEvent').click(function(){
		$('#list').load('inUserEvent.jsp');
		return false;
	});
});
$(document).ready(function(){
	$('#userBuyEvent').click(function(){
		$('#list').load('userBuyEvent.jsp');
		return false;
	});
});
$(document).ready(function(){
	$('#newBadEvent').click(function(){
		$('#list').load('newBadEvent.jsp');
		return false;
	});
});
$(document).ready(function(){
	$('#newInputEvent').click(function(){
		$('#list').load('newInputEvent.jsp');
		return false;
	});
});
$(document).ready(function(){
	$('#pcUsedList').click(function(){
		$('#list').load('pc_use.jsp');
		return false;
	});
});
$(document).ready(function(){
	$('#badList').click(function(){
		$('#list').load('bad.jsp');
		return false;
	});
});
$(document).ready(function(){
	$('#userList').click(function(){
		$('#list').load('m_user.jsp');
		return false;
	});
});
$(document).ready(function(){
	$('#inputList').click(function(){
		$('#list').load('input.jsp');
		return false;
	});
});
$(document).ready(function(){
	$('#sellList').click(function(){
		$('#list').load('sell.jsp');
		return false;
	});
});
$(document).ready(function(){
	$('#objList').click(function(){
		$('#list').load('obj.jsp');
		return false;
	});
});
$(document).ready(function(){
	$('#userAdd').click(function(){
		$('#list').load('m_user_add.jsp');
		return false;
	});
});
$(document).ready(function(){
	$('#pcStat').click(function(){
		$('#list').load('pcstat.jsp');
		return false;
	});
});
$(document).ready(function(){
	$('#pcAdd').click(function(){
		$('#list').load('pcAdd.jsp');
		return false;
	});
});
</script>
</body>
</html>