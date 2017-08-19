<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
String cate_mst_seq = (String) request.getParameter("cate_mst_seq");

CategoryService categoryService = (CategoryService) wac.getBean(CategoryService.class);
Tbl_cate_mst tbl_cate_mst = categoryService.getTbl_cate_mstByCate_mst_seq(Long.parseLong(cate_mst_seq));

ProductService productService = (ProductService) wac.getBean(ProductService.class);
List prdList = productService.getVw_prd_mstLastListByCate_mst_seq(Long.parseLong(cate_mst_seq));

logger.debug(">>>>>>>>>> prdList.size() : " + prdList.size());
logger.debug(">>>>>>>>>> loop size() : " + (((prdList.size() / 4) < 1) ? 1 : (prdList.size() / 4)));

int loopSize = (((prdList.size() / 4) < 1) ? 1 : (prdList.size() / 4));
%>

<div class="box-header with-border">	
	<h3 class="box-title"><span><%=tbl_cate_mst.getCate_name() %></span></h3>
</div>

<%
for(int i = 1, z = 0; i <= loopSize; i++) {
%>
<div class="box-in-body">
	<%
	for(int j = 0; j < 4; j++, z++) {
		if(z >= prdList.size()) break;
		Vw_prd_mst vw_prd_mst = (Vw_prd_mst)prdList.get(z);
	%>
	
		<div class="col-md-3 box_out_line"><div class="box_in_line">
			<div class="box-body">
				<img class="card-img-top" src="${pageContext.request.contextPath}/upload/<%=vw_prd_mst.getImg_main_path()%>" style="width:100%;">
			</div>
		   	<div class="box-body">
		       	<h4><%=vw_prd_mst.getPrd_name() %></h4>
				<p><%=vw_prd_mst.getPrd_summary().substring(0, 50) %>
				</p>
		   	</div>
			<div class="box-body">
				<a href="#" class="btn btn-block btn-default btn-flat">구입</a>
			</div>
		</div></div>
	<%
	}
	%>
</div>
<%
}
%>