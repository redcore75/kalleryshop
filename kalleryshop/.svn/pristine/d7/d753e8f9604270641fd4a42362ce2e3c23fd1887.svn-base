<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
%>
<head>	 				
	<script type="text/javascript">
		$(document).ready(function(){
			$("#btnSubmit").click(function(){
				$("#btnSubmit").attr("disabled", true);
				$("#updateForm").submit();
			});
		});
	</script>
</head>
<body>

	<div class="content">
		<form:form modelAttribute="tbl_banner_mgr" class="form-signin" id="updateForm" name="updateForm" method="post" action="update.do">
  			<cf:token/>
      		<div class="box box-default">
        		<div class="box-header with-border">
          			<h3 class="box-title"><spring:message code="common.wd.배너관리" /> > <spring:message code="common.wd.배너수정" /></h3>
        		</div>
        		<!-- /.box-header -->
        		<div class="box-body">
          			
					<!-- /.row -->
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.배너명" /></label></div>
									<div class="col-md-10">
										<form:errors path="banner_name" cssClass="text-red" element="div"/>
										<form:input path="banner_name" type="text" class="form-control" maxlength="200" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.배너타입" /></label></div>
									<div class="col-md-10">
										<form:errors path="banner_type" cssClass="text-red" element="div"/>
										<cf:common_code_radio code_group_id="BANNER_TYPE" tag_name="banner_type" tag_id="banner_type" tag_value="${tbl_banner_mgr.banner_type}"></cf:common_code_radio>
									</div>
								</div>
	              			</div>
            			</div>
            			<!-- /.col -->
					</div>
					<!-- /.row -->
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.노출시간" /></label></div>
									<div class="col-md-10">
										<form:errors path="disp_time" cssClass="text-red" element="div"/>
										<form:input path="disp_time" type="text" class="form-control" maxlength="20" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.사용여부" /></label></div>
									<div class="col-md-10">
										<form:errors path="is_valid" cssClass="text-red" element="div"/>
										<cf:common_code_radio code_group_id="IS_VALID" tag_name="is_valid" tag_id="is_valid" tag_value="${tbl_banner_mgr.is_valid}"></cf:common_code_radio>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
					</div>
				</div>
        		<!-- /.box-body -->
      		</div>
      		<!-- /.box -->
		</form:form>
		
		<div class="row">
			<div class="col-md-12">
				<div align="right">
					<button type="submit" id="btnSubmit" class="btn btn-default btn-flat"><spring:message code="common.wd.수정하기" /></button>
					<a href="searchList.do"><button type="button" class="btn btn-default btn-flat"><spring:message code="common.wd.목록으로" /></button></a>
				</div>
			</div>
		</div>
	</div>
	<!-- /.content -->
	
</body>