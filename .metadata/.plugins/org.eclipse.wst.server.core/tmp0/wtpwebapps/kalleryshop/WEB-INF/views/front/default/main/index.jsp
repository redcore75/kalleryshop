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
		<div class="row">
			<div class="col-md-12">
				<c:import url="/WEB-INF/views/front/default/module/banner.jsp">
					<c:param name="banner_mgr_seq" value="1" />
				</c:import>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<c:import url="/WEB-INF/views/front/default/module/mainPrdList.jsp">
					<c:param name="cate_mst_seq" value="9" />
				</c:import>
			</div>
        </div>
	</div>	
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<c:import url="/WEB-INF/views/front/default/module/mainPrdList.jsp">
					<c:param name="cate_mst_seq" value="21" />
				</c:import>
			</div>
        </div>
	</div>
</body>