<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- START :: include header -->
<!-- END :: include header -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도로명주소 API</title>
<!-- START :: JAVASCRIPT -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">

function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분 🎈

            // 각 주소의 노출 규칙에 따라 주소를 조합한다 🎈
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로 이를 참고하여 분기 한다 🎈
            var addr = ''; // 주소 변수 🎈
            var extraAddr = ''; // 참고항목 변수 🎈

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다 🎈
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우 🎈
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다 🎈
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다 (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다 🎈
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고 공동주택일 경우 추가한다 🎈
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우 괄호까지 추가한 최종 문자열을 만든다 🎈
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다 🎈
                document.getElementById("CLEAN_DETAIL_ADDRESS").value = extraAddr.replace(/^\s*/, "") +" ";
            
            } else {
                document.getElementById("CLEAN_DETAIL_ADDRESS").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다 🎈
            document.getElementById('CLEAN_POSTCODE').value = data.zonecode;
            document.getElementById("CLEAN_ADDRESS").value = addr;
            // 커서를 상세주소 필드로 이동한다 🎈	
            document.getElementById("CLEAN_DETAIL_ADDRESS").focus();
        }
    }).open();
}
	
	function formSubmit(){
		if($("#CLEAN_POSTCODE").val()=="" || $("#CLEAN_ADDRESS").val()=="" || $("#CLEAN_DETAIL_ADDRESS").val() == ""){
			alert("주소를 입력해주세요"); 
			execDaumPostcode();
		}else{
			$("#reserv_form").submit();
		}
		window.close();
        opener.parent.formSubmit();
	}
	
</script>
<!-- END :: JAVASCRIPT -->
</head>
<body>
	
	<div class="container">
		<!-- TEXT AREA / BUTTON AREA-->
		<div class="address">
		<BR>
			<h2>POSTCODE API 📬</h2> <BR> 
			
			<!-- 주소입력 후 이동하는 페이지 🎈 -->
			<!-- 우편번호, 주소, 상세주소 순으로 이동하는 home.do의 다음주소값으로 붙음 🎈 -->
			<!-- 예제 : 판교역로 235 -->
			
			<form id="reserv_form" method="get" action="home.do">
			
			    <input class="btn btn-light" type="button" onclick="execDaumPostcode()" value="주소찾기"><br>
				<BR>
				<input class="form-control" type="text" id="CLEAN_POSTCODE" name="CLEAN_POSTCODE" placeholder="우편번호" style="width:400px;" value="${clean_info.CLEAN_POSTCODE }" onclick="execDaumPostcode()">
				<BR>
				<input class="form-control" type="text" id="CLEAN_ADDRESS" name="CLEAN_ADDRESS" placeholder="주소" style="width:400px;" value="${clean_info.CLEAN_ADDRESS }" onclick="execDaumPostcode()"><br>
				<!-- <input type="text" id="extraAddress" placeholder="참고항목"> -->
				<input class="form-control" type="text" id="CLEAN_DETAIL_ADDRESS" name="CLEAN_DETAIL_ADDRESS" placeholder="상세주소 및 성함" style="width:400px;" value="${clean_info.CLEAN_DETAIL_ADDRESS }">
				<BR>
				<input class="btn btn-light" type="button" value="확인" onclick="formSubmit()">
				<input class="btn btn-light" type="reset"  value="초기화"> 
			</form>
		</div>
		
	</div>
	
<!-- START :: include footer -->
<!-- END :: include footer -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>