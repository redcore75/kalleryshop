<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
%>
<head>	 				
	<script type="text/javascript">
		var checkMemberNickNameDupYn = false;
		
		$(document).ready(function(){
			$("#passUpdateForm").validate({
				rules: {					
					password: {
						required: true, 		
					},
					passrchk: {
						equalTo: "#password",
					},
				},
				messages: {					
					password: { 
						required: '<spring:message code="common.st.비밀번호를입력하세요" />', 
					},
					passrchk: {
						equalTo: '<spring:message code="common.st.비밀번호가일치하지않습니다" />', 
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
  		<form:form modelAttribute="tbl_member" class="form-signin" id="passUpdateForm" name="passUpdateForm" method="post" action="passUpdate.do">
  			<cf:token/>
  			<form:input path="member_id" type="hidden"/>
  			<form:input path="email_addr" type="hidden"/>
  			<form:input path="auth_num" type="hidden"/>
      		<div class="box box-default">
        		<div class="box-header with-border">
          			<h3 class="box-title"><spring:message code="common.wd.비밀번호찾기" /></h3>
        		</div>
        		<!-- /.box-header -->
        		<div class="box-body">
        			<div class="row">
        				<div class="col-md-12">
        					<h4><spring:message code="common.st.변경할비밀번호를입력해주세요" /></h4>        					
        				</div>
        			</div>
        			<div class="row">
        				<div class="col-md-12">
        					<form:errors path="common_error" cssClass="text-red" element="div"/>
        					<form:errors path="auth_num" cssClass="text-red" element="div"/>
        				</div>
        			</div>
          			<div class="row">
            			<div class="col-md-2">
            				<spring:message code="common.wd.비밀번호" />
            			</div>
            			<div class="col-md-10">			        			
							<form:errors path="password" cssClass="text-red" element="div"/>
							<form:input path="password" type="password" class="form-control" maxlength="100" style="width: 100%;"/>
            			</div>
            			<!-- /.col -->
					</div>
          			<div class="row">
            			<div class="col-md-2">
            			</div>
            			<div class="col-md-10">			        			
							<form:errors path="passrchk" cssClass="text-red" element="div"/>
							<form:input path="passrchk" type="password" class="form-control" maxlength="100" style="width: 100%;"/>
            			</div>
            			<!-- /.col -->
					</div>          			
				</div>
        		<!-- /.box-body -->
      		</div>
      		<!-- /.box -->

			<div class="row">
				<div class="col-md-12">
					<button type="submit" id="btnSubmit" class="btn btn-block btn-info" style="width: 100%;"><spring:message code="common.wd.변경하기" /></button>
				</div>
			</div>
		</form:form>
	</div>
	<!-- /.content -->
	
</body>