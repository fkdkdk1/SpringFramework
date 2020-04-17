<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN HOME</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
	body {
		background: #F5F5F5;
	}
</style>
<!-- END :: CSS -->
<script>
$function(){
	
	$("#loginchk").hide();
});
</script>
<script>
function login(){
	var memberid = $("#memberid").val().trim();
	var memberpw = $("#memberpw").val().trim();
	console.log(memberid + "/" + memberpw);
	
	if(memberid == null || memberid == "" || memberpw == null || memberpw == "") {
		alert("아이디 또는 패스키를 입력하지 않았습니다");
	} else {
		var loginVal = {
				"memberid" : memberid,
				"memberpw" : memberpw
		}
		
		$.ajax({
			type: "post",
			url: "ajaxlogin.do",
			data: JSON.stringify(loginVal),
			contentType: "application/json",
			dataType: "json",
			success: function(msg){
				if (msg.check == true) {
					location.href="kakaopay.do";
				} else {
					$("#loginchk").show();
					$("#loginchk").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;아이디 또는 패스키가 잘못되었습니다").css("color","red");
				}
			},
			error: function(){
				alert("통신 실패");
			}
		});
	}
}
</script>
</head>
<body>
	<table>
		<tr>
			<td colspan="2" align="center" id="loginchk"></td>
		</tr>
	</table>
 <div class="col-auto">
      <label class="sr-only" for="inlineFormInputGroup">아이디</label>
      <div class="input-group mb-1">
        <div class="input-group-prepend">
          <div class="input-group-text">👓</div>
        </div>
        <input type="text" class="form-control" id="memberid" placeholder="아이디를 입력해주세요">
        <label class="sr-only" for="inlineFormInputGroup">패스키</label>
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text">🎃</div>
        </div>
        <input type="password" class="form-control" id="memberpw" placeholder="패스키를 입력해주세요">
      </div>
</div>
</div>
<BR>


    <div class="col-auto">
      <button type="submit" class="btn btn-outline-primary mb-2 btn-block" title="admin/1234" onclick="login();">LOGIN</button>
    </div>
</body>
</html>