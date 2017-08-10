<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
%>
<head>	 				
	<script type="text/javascript"> 
		var objChangeCate = null;
		var objCurrPrdsHm = {}; // 상품검색결과 변수
		
		$(document).ready(function(){
			$("#jstree_demo_div").jstree({
				"core" : {
					"multiple" : false,
					"themes" : {
						"variant" : "large"
					},
					"data": {
						"url": "${pageContext.request.contextPath}/api/external/getCategoryList.do",
						"dataType": "json",
					},
				},
				"checkbox" : {
					"keep_selected_style" : false
				},
			});
			
			$("#jstree_demo_div").on("changed.jstree", function(e, data){
				objChangeCate = data;
				$("#catePrdList").html("");
				
		    	//console.log(data.instance.get_node(data.selected[0]).id + ' ' + data.instance.get_node(data.selected[0]).text);
				$.ajax({
					url:"${pageContext.request.contextPath}/api/external/getProductList.do?cate_mst_seq=" + data.instance.get_node(data.selected[0]).id,
					type:"GET",
					data: {},
					dataType:"json",
					cache:false,
					success:function(data){
						if(data.result_code == 0000) {
							for(i = 0; i < data.result_data.length; i++) {
								var obj = new Object();
								//obj['cate_mst_seq'] = data.result_data[i].cate_mst_seq;
								obj['prd_mst_seq'] = data.result_data[i].prd_mst_seq;
								obj['prd_name'] = data.result_data[i].prd_name;
								obj['prd_in_price'] = data.result_data[i].prd_in_price;
								obj['prd_sl_price'] = data.result_data[i].prd_sl_price;
								obj['prd_mk_price'] = data.result_data[i].prd_mk_price;
								$('#catePrdListData').tmpl(obj).appendTo("#catePrdList");
							}
						} else {
							alert('<spring:message code="common.st.카테고리가존재하지않습니다" />');
						}
					},
					error : function(request, status, error) {
						alert("code : " + request.status + "\r\nmessage : " + request.responseText + "\r\nerror : " + error);
					}
				});
			});
			
			$("#popBtnPrdName").click(function(){
				if(objChangeCate != null) {
					var schPrdName = $("#schPrdName").val();
					$.ajax({
						url:"${pageContext.request.contextPath}/api/external/getProductList.do?cate_mst_seq=" + objChangeCate.instance.get_node(objChangeCate.selected[0]).id + "&prd_name=" + schPrdName,
						type:"GET",
						data: {},
						dataType:"json",
						cache:false,
						success:function(data){
							if(data.result_code == 0000) {
								for(i = 0; i < data.result_data.length; i++) {
									var obj = new Object();
									obj['prd_mst_seq'] = data.result_data[i].prd_mst_seq;
									obj['prd_name'] = data.result_data[i].prd_name;
									obj['prd_in_price'] = data.result_data[i].prd_in_price;
									obj['prd_sl_price'] = data.result_data[i].prd_sl_price;
									obj['prd_mk_price'] = data.result_data[i].prd_mk_price;
									$('#popPrdListData').tmpl(obj).appendTo("#popPrdList");
									
									// 상품검색결과 변수에 저장
									objCurrPrdsHm[data.result_data[i].prd_mst_seq] = obj;
								}
							} else {
								alert('<spring:message code="common.st.상품명이존재하지않습니다" />');
							}
						},
						error : function(request, status, error) {
							alert("code : " + request.status + "\r\nmessage : " + request.responseText + "\r\nerror : " + error);
						}
					});
				} else {
					alert('<spring:message code="common.st.카테고리를선택하세요" />');
				}
			});
			
			$("#popBtnAddCatePrds").click(function(){
				$("#popPrdListSeq:checked").each(function() {
					var objDes = new Object();
					var objSrc = objCurrPrdsHm[$(this).val()]; // 상품검색결과 변수에서 선택한 데이타 추출
					if(isSamePrd(objSrc['prd_mst_seq']) == false) {
						// 이미 catePrdList에 추가된 상품은 제거하고, 추가한다.
						//objDes['cate_mst_seq'] = objChangeCate.instance.get_node(objChangeCate.selected[0]).id;
						objDes['prd_mst_seq'] = objSrc['prd_mst_seq'];
						objDes['prd_name'] = objSrc['prd_name'];
						objDes['prd_in_price'] = objSrc['prd_in_price'];
						objDes['prd_sl_price'] = objSrc['prd_sl_price'];
						objDes['prd_mk_price'] = objSrc['prd_mk_price'];
						$('#catePrdListData').tmpl(objDes).appendTo("#catePrdList");
					}
				});
			});
			
			$(document).on("click", "#delCatePrdList", function(){
				$(this).closest("tr").remove();
			});
			
			$("#btnUpdate").click(function(){				
				var postData = new StringBuffer();
				
				var totalSize = $("input[name='prd_mst_seq'").length;
				postData.append("{\"cate_mst_seq\" : \"" + objChangeCate.instance.get_node(objChangeCate.selected[0]).id + "\",");
				postData.append("\"prdList\" : [");				
				$("input[name='prd_mst_seq'").each(function(index) {
					if(index === totalSize - 1) {
						// last index
						postData.append("{\"prd_mst_seq\" : \"" + $(this).val() + "\"}");
					} else {
						postData.append("{\"prd_mst_seq\" : \"" + $(this).val() + "\"},");
					}					
				});
				postData.append("]}");
				
				$.ajax({
					url:"${pageContext.request.contextPath}/api/internal/uptCatePrd.do",
					type:"POST",
					data: postData.toString(),
					dataType:"json",
					contentType: 'application/json',
					cache:false,
					success:function(data){
						if(data.result_code == 0000) {
							alert('<spring:message code="common.st.카테고리수정을성공했습니다" />');
						} else {
							alert('<spring:message code="common.st.카테고리수정을실패했습니다" />');
						}
					},
					error : function(request, status, error) {
						alert("code : " + request.status + "\r\nmessage : " + request.responseText + "\r\nerror : " + error);
					}
				});
			});
		});
		
		function showPopSchProduct() {
			$("#popPrdList").html(""); // 상품검색결과 초기화
			objCurrPrdsHm = {}; // 상품검색결과 변수 초기화
			if(objChangeCate != null) {
				$($("#popSchProduct").attr("data-target", "#popSchProduct")).modal("show");
			} else {
				alert('<spring:message code="common.st.카테고리를선택하세요" />');
			}
		}
		
		// 기존 catePrdList에있는 상품리스트 확인
		function isSamePrd(prd_mst_seq) {
			var isReturn = false;
			
			$("input[name='prd_mst_seq'").each(function() {
				if($(this).val() == prd_mst_seq) {
					isReturn = true;
				}
			});
			
			return isReturn;
		}
	</script>
	
	<script id="catePrdListData" type="text/x-jquery-tmpl">
		<tr>
			<input type="hidden" name="prd_mst_seq" value="{{= prd_mst_seq}}"/>
			<td>{{= prd_mst_seq}}</td>
			<td>{{= prd_name}}</td>
			<td>{{= prd_in_price}}</td>
			<td>{{= prd_sl_price}}</td>
			<td>{{= prd_mk_price}}</td>
			<td><button id="delCatePrdList" type="button" class="btn  btn-flat">-</button></td>
		</tr>
	</script>
	
	<script id="popPrdListData" type="text/x-jquery-tmpl">
		<tr>
			<td><input type="checkbox" id="popPrdListSeq" value="{{= prd_mst_seq}}"/></td>
			<td>{{= prd_mst_seq}}</td>
			<td>{{= prd_name}}</td>
			<td>{{= prd_in_price}}</td>
			<td>{{= prd_sl_price}}</td>
			<td>{{= prd_mk_price}}</td>
		</tr>
	</script>
</head>
<body>

	<div class="content">
   		<div class="box box-default">
      		<div class="box-header with-border">
       			<h3 class="box-title"><spring:message code="common.wd.카테고리관리" /> > <spring:message code="common.wd.카테고리상품리스트" /></h3>
      		</div>
      		<!-- /.box-header -->
      		<div class="box-body">
       			<div class="row">
          			<div class="col-md-3">
						<div id="jstree_demo_div">
						</div>
           			</div>
           			<!-- /.col -->
           			<div class="col-md-9">
							<div class="box-body no-padding">
								<table class="table">
									<tbody>
										<tr>
											<th width="10%">상품번호</th>
											<th width="30%">상품명</th>
											<th>상품매입가</th>
											<th>상품판매가</th>
											<th>상품시장가</th>
											<th>삭제</th>
										</tr>
										<tbody id="catePrdList"></tbody>
									</tbody>
								</table>
							</div>						
					</div>
            		<!-- /.col -->
				</div>
			</div>
        	<!-- /.box-body -->
      	</div>
      	<!-- /.box -->
      	
		<div class="row">
			<div class="col-md-12">
				<div align="right">
					<button type="button" class="btn btn-default btn-flat" data-toggle="modal" onclick="showPopSchProduct()"><spring:message code="common.wd.검색하기" /></button>					
					<button type="button" id="btnUpdate" class="btn btn-default btn-flat"><spring:message code="common.wd.저장하기" /></button></a>
				</div>
			</div>
		</div>
	</div>
	<!-- /.content -->

	<div class="modal" id="popSchProduct" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"><spring:message code="common.wd.상품검색" /></h4>
				</div>
				<div class="modal-body">
          			<div class="row">
						<div class="col-md-2"><label><spring:message code="common.wd.상품명" /></label></div>
						<div class="col-md-8">										
							<input id="schPrdName" type="text" class="form-control" maxlength="100" style="width: 100%;"/>
						</div>
						<div class="col-md-2"><button id="popBtnPrdName" class="btn btn-default btn-flat" style="width: 100%;"><spring:message code="common.wd.찾기" /></button></div>						
					</div>
          			<div class="row">
						<div class="col-md-12"><hr/></div>						
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="box-body no-padding">
								<table class="table">
									<tbody>
										<tr>
											<th style="width: 10px">#</th>			
											<th width="10%">상품번호</th>
											<th width="30%">상품명</th>
											<th>상품매입가</th>
											<th>상품판매가</th>
											<th>상품시장가</th>
										</tr>
										<tbody id="popPrdList"></tbody>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
					<div class="modal-footer">
					<button type="button" id="popBtnAddCatePrds" class="btn btn-default" data-dismiss="modal"><spring:message code="common.wd.선택하기" /></button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
  	</div>

</body>