<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<script>
	alert('<spring:message code="common.st.로그인에성공했습니다" />');
	window.location = "${pageContext.request.contextPath}/front/main/index.do";
</script>
</body>