<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
%>
<head>	 				
	<script type="text/javascript">		
		$(document).ready(function(){
			$("#emailAuthForm").validate({
				rules: {
					auth_num: {
						required: true, 		
					},
				},
				messages: {
					auth_num: { 
						required: '<spring:message code="common.st.인증번호를입력하세요" />', 
					},
				},
				submitHandler: function (form) {
					form.submit();
				}
			});
		});
	</script>
</head>
<body>

	<div class="content">
  		<form:form modelAttribute="tbl_member" class="form-signin" id="emailAuthForm" name="emailAuthForm" method="post" action="passUpdateForm.do">
  			<cf:token/>
  			<form:input path="email_addr" type="hidden"/>
      		<div class="box box-default">
        		<div class="box-header with-border">
          			<h3 class="box-title"><spring:message code="common.wd.비밀번호찾기" /></h3>
        		</div>
        		<!-- /.box-header -->
        		<div class="box-body">
        			<div class="row">
        				<div class="col-md-12">
        					<form:errors path="common_error" cssClass="text-red" element="div"/>
        				</div>
        			</div>
          			<div class="row">
            			<div class="col-md-2">
            				<spring:message code="common.wd.인증번호" />
            			</div>
            			<div class="col-md-10">			        			
							<form:errors path="auth_num" cssClass="text-red" element="div"/>
							<form:input path="auth_num" type="text" class="form-control" maxlength="30" style="width: 100%;"/>
            			</div>
            			<!-- /.col -->
					</div>
				</div>
        		<!-- /.box-body -->
      		</div>
      		<!-- /.box -->

			<div class="row">
				<div class="col-md-6">
					<a href="${pageContext.request.contextPath}/front/member/pass_search/emailInputForm.do"><button type="button" class="btn btn-block btn-info" style="width: 100%;"><spring:message code="common.wd.이메일재입력" /></button></a>
				</div>			
				<div class="col-md-6">
					<button type="submit" id="btnSubmit" class="btn btn-block btn-info" style="width: 100%;"><spring:message code="common.wd.인증번호확인" /></button>
				</div>
			</div>
		</form:form>
	</div>
	<!-- /.content -->
	
</body>