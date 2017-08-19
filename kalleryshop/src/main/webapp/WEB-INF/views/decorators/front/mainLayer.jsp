<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
response.setContentType("text/html; charset=UTF-8"); 
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

String theme_id = configProp.getProperty("theme_id");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport" />
	<meta http-equiv="Cache-Control" content="No-Cache"/>

<%
if(configProp.getProperty("layer_type").equals("default")) {
	pageContext.include("/WEB-INF/views/decorators/front/" + theme_id + "/headPage.jsp");
} else {
	%><!-- layer_type is wrong --><%
}
%>

	<script type="text/javascript">
		$(document).ready(function(){
			// readonly 에서 백스페이스 무시.
			$("input[readonly]").keydown(function(event) {
				if ( event.keyCode === 8 ) {
					return false;
				}
			});
			
			$(".datepicker").datepicker({
				language: "kr",
				format: "yyyymmdd",
				autoclose: true
			});			
		});
	</script>

<decorator:head />
</head>
<body>

<%
if(configProp.getProperty("layer_type").equals("default")) {
%>
	<!-- START:TOP Area -->
	<% pageContext.include("/WEB-INF/views/decorators/front/" + theme_id + "/topPage.jsp"); %>
	<!-- END:TOP Area -->
	
	<!-- START:MAIN Area -->
	<decorator:body />
	<!-- END:MAIN Area -->
	
	<!-- START:BOTTOM Area -->
	<% pageContext.include("/WEB-INF/views/decorators/front/" + theme_id + "/bottomPage.jsp"); %>
	<!-- END:BOTTOM Area -->
<%
} else {
	%><!-- layer_type is wrong --><%
}
%>

</body>
</html>