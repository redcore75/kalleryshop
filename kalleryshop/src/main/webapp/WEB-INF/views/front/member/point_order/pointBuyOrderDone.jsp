<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
Tbl_member tbl_member = (Tbl_member) session.getAttribute(GlobalConstants.FRONT_LOGININFO_KEY);
%>
<head>	 				
	<script type="text/javascript">	
		$(document).ready(function(){
		});
	</script>
</head>
<body>

	<div class="content">
      	<div class="box box-default">
        	<div class="box-header with-border">
        		<h3 class="box-title"><spring:message code="common.wd.포인트구매" /></h3>
        	</div>
        	<!-- /.box-header -->
        	<div class="box-body">
        		<div class="row">
        			<div class="col-md-12" align="center">
        				<%=tbl_member.getMember_id()%>님의</br>
        				<font color="red">${buy_point}</font> <spring:message code="common.st.포인트가구매완료되었습니다" />
                	</div>
        		</div>
			</div>
        	<!-- /.box-body -->
      	</div>
      	<!-- /.box -->
      	
		<div class="row">
			<div class="col-md-12">
				<a href="${pageContext.request.contextPath}/front/main/index.do"><button type="button" class="btn btn-block btn-info"><spring:message code="common.wd.메인으로" /></button></a>
			</div>
		</div>      	
	</div>
	<!-- /.content -->
	
</body>