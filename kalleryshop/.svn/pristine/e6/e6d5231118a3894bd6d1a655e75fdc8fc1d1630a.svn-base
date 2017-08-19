<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<head>	 				
	<script type="text/javascript">
		$(document).ready(function(){
			if($.cookie("member_id") != null) {
				//alert("get cookies " +  $.cookie("member_id"));
				$("#member_id").val( $.cookie("member_id"));
			}
			
			$("#loginForm").validate({
				rules: {
					member_id: { required: true },
					password: { required: true },
				},
				messages: {
					member_id: { required: "이메일 주소를 입력하세요." },
					password: { required: "비밀번호를 입력하세요." },
				},
				submitHandler: function (form) {
					form.submit();
				}
			});
			
			$("#remember").click(function(){
				//alert("member_id " + $("#member_id").val());
				 $.cookie("member_id", $("#member_id").val(), {expires:365});
			});
		});
	</script>
</head>
<body>

	<div class="login-box">
  		<div class="login-logo">
    		로그인
  		</div>
  		<!-- /.login-logo -->
  		<div class="login-box-body">
    		<form class="form-signin" id="loginForm" name="loginForm" method="post" action="login.do">
      			<div class="form-group has-feedback">
					<input type="text" id="member_id" name="member_id" class="form-control" placeholder="이메일 주소를 입력하세요." autofocus/>
        			<span class="glyphicon glyphicon-user form-control-feedback"></span>
      			</div>
      			<div class="form-group has-feedback">
        			<input type="password" id="password" name="password" class="form-control" placeholder="비밀번호를 입력하세요."/>
        			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
      			</div>
      			<div class="row">
	        		<div class="col-md-6" align="right">
	          			<div class="checkbox icheck">
	            			<label><input type="checkbox" id="remember"/> 아이디저장</label>
	          			</div>
	        		</div>
	        		<div class="col-md-6" align="right">
	          			<button type="submit" class="btn btn-default">로그인</button>
	        		</div>
      			</div>
      			<div class="row">
					<div class="col-md-12" align="right">
						<div class="checkbox icheck">
							<a href="${pageContext.request.contextPath}/front/member/pass_search/emailInputForm.do"/>비밀번호찾기</a> | <a href="${pageContext.request.contextPath}/front/member/join/agreeForm.do"/>회원가입</a>
						</div>
					</div>
				</div>
    		</form>
		</div>
	</div>

</body>