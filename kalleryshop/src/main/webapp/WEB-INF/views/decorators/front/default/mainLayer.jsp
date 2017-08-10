<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
response.setContentType("text/html; charset=UTF-8"); 
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport" />
<meta http-equiv=Cache-Control content=No-Cache>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/front/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/front/css/AdminLTE.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/front/css/skins/_all-skins.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/front/plugins/datepicker/datepicker3.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/front/css/common.css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>   
<script src="https://cdn.rawgit.com/niftylettuce/bootstrap-datepicker-mobile/9999ca720ebf89600bda1659c96a291dc447ff39/bootstrap-datepicker-mobile.js"></script>
<script src="${pageContext.request.contextPath}/resources/front/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/front/js/bigSlide.js"></script>
<script src="${pageContext.request.contextPath}/resources/front/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/front/plugins/datepicker/locales/bootstrap-datepicker.kr.js"></script>
<script src="${pageContext.request.contextPath}/resources/front/js/common.js"></script>

<script type="text/javascript">
	var menu_open_flag = false;
	
	$(document).ready(function(){
		$('.menu-link').bigSlide({
			'side': 'left',
			'speed': '550',
			'menuWidth': '50%'
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
<body class="hold-transition skin-blue">
	<div class="content-wrapper">
	<!-- START:TOP Area -->
	<page:applyDecorator name="front_top" />
	<!-- END:TOP Area -->

	<!-- START:MAIN Area -->	
	<decorator:body />
	<!-- END:MAIN Area -->
		
	<!-- START:BOTTOM Area -->
	<page:applyDecorator name="front_bottom" />
	<!-- END:BOTTOM Area -->
	</div>
</body>
</html>