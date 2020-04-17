<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<!-- 네이버 로그인을 사용하기 위해 선언 -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>

</head>
<body>
	<h1>Login Form</h1>
	<hr>
	<br>
		<c:choose>
			<c:when test="${sessionId != null}">
				<h2>SNS 아이디 로그인 성공하셨습니다!!</h2>
				<h3>'${sessionId}' 님 환영합니다!</h3>
				<h3>
					<a href="logout">로그아웃</a>
				</h3>
			</c:when>
			<c:otherwise>
				<form action="login.userdo" method="post" name="frm"
					style="width: 470px;">
					<h2>로그인</h2>
					<input type="text" name="id" id="id" class="w3-input w3-border"
						placeholder="아이디" value="${id}"> <br> <input
						type="password" id="pwd" name="pwd" class="w3-input w3-border"
						placeholder="비밀번호"> <br> <input type="submit" value="로그인" onclick=""><br>
				</form>
				<br>
				<span id="naver_id_login"></span>
				<br>
				<a id="kakao-login-btn"></a>
				<a href="http://developers.kakao.com/logout"></a>
				</c:otherwise>
		</c:choose>
	<script>
	    // 사용할 앱의 JavaScript 키 설정
	    Kakao.init('e279f4719a19c18fde6278302eaeb6d8');
	    
	    // 카카오 로그인 버튼을 생성합니다.
	    Kakao.Auth.createLoginButton({
	      container: '#kakao-login-btn',
	      success : function(authObj) {
	    	  Kakao.API.request({
		    	  url:'/v2/user/me', 
		    	  // res = Kakao에서 유저정보를 Json 형태로 응답
		    	  success:function(res){
		    		  $.ajax({
		    			  type : "POST",
		    		  	  url : "kakaoLogin",
		    		  	  data : {
		    		  		  //kakao에서 응답한 Json 값의 정보중 nickname을 가져옴
		    		  		  KAKAO_NICKNAME : res.properties.nickname
		    		  	  },
		    		  	  success : function(){
		    		  		  alert('성공');
		    					close();
		    					window.location.reload();
		    		  	  },
		    		  	  error : function(){
		    		  		  alert('에러');
		    		  	  }
		    		  }) 
		    	  }
	    	  });
	      }
	    });
	    
	    
	    // naver api 클라이언트 key 및 콜백 key 등록
	    // 콜백키는 localhost가 포함되어있는 경로로 입력
		var naver_id_login = new naver_id_login("7xxpQ0KD8vGFVRvuMlc9",
		"http://localhost:8181/sociallogin/callback.jsp");
		
		console.log(state) 
		
		// 버튼 디자인
		naver_id_login.setButton("green", 3, 40);
		// 팝업 set 
		naver_id_login.setPopup();
		// 이건모름
		naver_id_login.init_naver_id_login();
	    
</script>

</body>
</html>