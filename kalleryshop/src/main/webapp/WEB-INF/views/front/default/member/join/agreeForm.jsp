<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
%>
<head>	 				
	<script type="text/javascript">		
		$(document).ready(function(){
		});
	</script>
</head>
<body>

	<div class="content">
  		<form:form modelAttribute="tbl_member" class="form-signin" id="agreeForm" name="agreeForm" method="post" action="emailInputForm.do">
  			<cf:token/>
  			<form:input path="term_agree1" type="hidden" value="Y"/>
  			<form:input path="term_agree2" type="hidden" value="Y"/>
  			<form:input path="term_agree3" type="hidden" value="Y"/>
      		<div class="box box-default">
        		<div class="box-header with-border">
          			<h3 class="box-title"><spring:message code="common.wd.회원가입" /></h3>
        		</div>
        		<!-- /.box-header -->
        		<div class="box-body">
          			<div class="row">
            			<div class="col-md-12">
					        <div class="box box-info">
								<h3 class="box-title"><spring:message code="common.wd.약관동의" /></h3>
								<textarea class="textarea" placeholder="Message" readonly style="width: 100%; height: 125px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">
어쩌구 저쩌구..
동의합니다.				          		
								</textarea>
            				</div>								
            			</div>
            			<!-- /.col -->
					</div>
				</div>			
        		<!-- /.box-body -->
      		</div>
      		<!-- /.box -->     		
		
			<div class="row">	
				<div class="col-md-6">
					<div align="center">
						<button type="submit" id="btnSubmit" class="btn btn-block btn-info"><spring:message code="common.wd.동의" /></button>					
					</div>
				</div>
				<div class="col-md-6">
					<div align="center">					
						<a href="${pageContext.request.contextPath}/front/main/index.do"><button type="button" class="btn btn-block btn-info"><spring:message code="common.wd.비동의" /></button></a>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<!-- /.content -->
	
</body>