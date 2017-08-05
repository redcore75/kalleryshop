<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
%>
<head>	 				
	<script type="text/javascript">	
		var checkEmailAddrDupYn = false;
		
		$(document).ready(function(){
			$("#emailInputForm").validate({
				rules: {
					email_addr: {
						required: true, 
						email : true		
					},
				},
				messages: {
					email_addr: { 
						required: '<spring:message code="common.st.이메일주소를입력하세요" />', 
						email : '<spring:message code="common.st.이메일주소를올바르게입력하세요" />'
					},
				},
				submitHandler: function (form) {
					if(checkEmailAddrDupYn) {
						$("#btnSubmit").attr("disabled", true);
						form.submit();					
					} else {
						alert('<spring:message code="common.st.이메일주소의사용여부를체크하세요" />');
					}
				}
			});
			
			$("#checkEmailAddrDup").click(function(){
				var email_addr = $("#email_addr").val();
				if(email_addr == "") {
					alert('<spring:message code="common.st.이메일주소를입력하세요" />');
				} else {
					$.ajax({
						url:"${pageContext.request.contextPath}/api/external/checkMemberId.do?member_id=" + email_addr,
						type:"GET",
						data: {},
						dataType:"json",
						cache:false,
						success:function(data){
							if(data.result_code == 0000) {
								alert('<spring:message code="common.st.사용중인이메일주소입니다" />');
								checkEmailAddrDupYn = true;
							} else {
								$("#email_addr").val("");
								alert('<spring:message code="common.st.이메일주소가존재하지않습니다" />');
								checkEmailAddrDupYn = false;
							}
						},
						error : function(request, status, error) {
							alert("code : " + request.status + "\r\nmessage : " + request.responseText + "\r\nerror : " + error);
						}
					});
				}
			});			
		});
	</script>
</head>
<body>

	<div class="content">
  		<form:form modelAttribute="tbl_member" class="form-signin" id="emailInputForm" name="emailInputForm" method="post" action="emailAuthForm.do">
  			<cf:token/>
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
            				<spring:message code="common.wd.이메일" />
            			</div>
            			<div class="col-md-10">
							<form:errors path="email_addr" cssClass="text-red" element="div"/>
							<div class="row">
								<div class="col-md-10">
									<form:input path="email_addr" type="text" class="form-control" maxlength="30" style="width: 100%;"/>
								</div>
								<div class="col-md-2">
									<button id="checkEmailAddrDup" type="button" class="btn btn-default"><spring:message code="common.wd.사용여부" /></button>
								</div>
							</div>
            			</div>
            			<!-- /.col -->
					</div>
				</div>
        		<!-- /.box-body -->
      		</div>
      		<!-- /.box -->
		
			<div class="row">
				<div class="col-md-12">
					<button type="submit" id="btnSubmit" class="btn btn-block btn-info" style="width: 100%;"><spring:message code="common.wd.인증번호발송" /></button>
				</div>
			</div>
		</form:form>
	</div>
	<!-- /.content -->
	
</body>