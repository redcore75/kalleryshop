<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
%>
<body>
<script>
	alert('<spring:message code="common.st.포인트구매가실패하였습니다" />');
	window.location = "${pageContext.request.contextPath}/front/member/point_order/pointList.do";
</script>
</body>