<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
	Logger logger = LoggerFactory.getLogger(getClass());
	ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
%>
<head>
	<script type="text/javascript">
		$(document).ready(function() {
		});
	</script>
</head>
<body>

	<div class="container">
   		<div class="box box-default">
      		<div class="box-header with-border">
       			<h3 class="box-title"><spring:message code="common.wd.개인정보처리방침" /></h3>
       		</div>
      		<!-- /.box-header -->
       		<div class="box-body">
       			<div class="row">
           			<div class="col-md-12">
						<textarea class="textarea" placeholder="Message" readonly style="width: 100%; height: 125px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">
							${tbl_shop_env.sv_privateitem}         		
						</textarea>			          		
           			</div>
           			<!-- /.col -->
				</div>
			</div>
       		<!-- /.box-body -->
   		</div>
   		<!-- /.box -->
	</div>
	<!-- /.content -->
</body>