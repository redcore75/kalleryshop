<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
%>
<head>
  	<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
  	<script>tinymce.init({ selector:'textarea#prd_content' });</script>
	<script type="text/javascript">
		var objChangeCate = null;
		
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
			});
			
			$("#addCategory").click(function(){
				if(objChangeCate != null) {
					var i, j;
					for(i = 0, j = objChangeCate.selected.length; i < j; i++) {
						console.log(objChangeCate.instance.get_node(objChangeCate.selected[i]).id + ' ' + objChangeCate.instance.get_node(objChangeCate.selected[i]).text);
						
						var dupCheck = false;
						$("#cateListSeq:checkbox").each(function() {
							if($(this).val() === objChangeCate.instance.get_node(objChangeCate.selected[i]).id) {
								dupCheck = true;
							}
						});
						
						if(!dupCheck) {
							var obj = new Object();
							obj['cate_name'] = objChangeCate.instance.get_node(objChangeCate.selected[i]).text;
							obj['cate_mst_seq'] = objChangeCate.instance.get_node(objChangeCate.selected[i]).id;
							obj['cate_mst_seq_up'] = objChangeCate.instance.get_node(objChangeCate.selected[i]).parent;					
							$('#cateListData').tmpl(obj).appendTo("#cateList");
						}
					}
				}
			});
			
			$("#delCategory").click(function(){
				$("#cateListSeq:checked").each(function() {
					$(this).closest("tr").remove();
				});
			});
			
			$("#popBtnMemberId").click(function(){
				var schMemberId = $("#schMemberId").val();				
				$.ajax({
					url:"${pageContext.request.contextPath}/api/external/getMemberSeq.do?member_id=" + schMemberId,
					type:"GET",
					data: {},
					dataType:"json",
					cache:false,
					success:function(data){
						if(data.result_code == 0000) {
							$("#member_id").val(data.result_data.member_id);
							$("#member_seq").val(data.result_data.member_seq);
							$('#popSchMemberId').modal("hide");
						} else {
							alert('<spring:message code="common.st.아이디가존재하지않습니다" />');
						}
					},
					error : function(request, status, error) {
						alert("code : " + request.status + "\r\nmessage : " + request.responseText + "\r\nerror : " + error);
					}
				});
			});
			
			$("input[name='is_opt_use']:radio").change(function(){				
				if(this.value == 'Y') {					
					$("#optionListArea").show();				
					
					var obj = new Object();
					obj['prd_opt_id'] = randomString(10);
					$('#optionListData').tmpl(obj).appendTo("#optionList");
				} else {
					$("#optionList").html("");
				}
			});				
			
			$(document).on("click", "#addOptionList", function(){
				var obj = new Object();
				obj['prd_opt_id'] = randomString(10);
				$('#optionListData').tmpl(obj).appendTo("#optionList");					   
			});
			
			$(document).on("click", "#delOptionList", function(){
				$(this).closest("tr").remove();
			});
			
			$("#btnSubmit").click(function(){
				$("#btnSubmit").attr("disabled", true);
				$("#updateForm").submit();
			});
		});
	</script>
	
	<script id="cateListData" type="text/x-jquery-tmpl">
		<tr>
			<td><input type="checkbox" id="cateListSeq" value="{{= cate_mst_seq}}"/></td>
			<td>{{= cate_name}}</td>
			<td><input type="hidden" name="cateList" value="{{= cate_mst_seq}}"/>{{= cate_mst_seq}}</td>
			<td>{{= cate_mst_seq_up}}</td>
		</tr>
	</script>
	
	<script id="optionListData" type="text/x-jquery-tmpl">
		<tr>
			<td>
				<select name="opt_group_idList" style="width: 100%;" class="form-control">
					<c:forEach var="tbl_opt_group" items="${tbl_opt_groupList}" varStatus="status">
						<option value="${tbl_opt_group.opt_group_id}" ${status.first eq true ? 'selected' : ''}>${tbl_opt_group.opt_group_name}</option>
					</c:forEach>
				</select>
			</td>
			<td><input type="text" name="prd_opt_idList" value="{{= prd_opt_id}}" maxlength="10" style="width: 100%;" class="form-control"/></td>
			<td><input type="text" name="prd_opt_nameList" maxlength="100" style="width: 100%;" class="form-control"/></td>
			<td><input type="text" name="prd_opt_in_priceList" value="0.0" maxlength="11" style="width: 100%;" class="form-control"/></td>
			<td><input type="text" name="prd_opt_sl_priceList" value="0.0" maxlength="11" style="width: 100%;" class="form-control"/></td>
			<td><input type="text" name="orderbyList" value="1" maxlength="1" style="width: 100%;" class="form-control"/></td>			
			<td><button id="addOptionList" type="button" class="btn  btn-flat">+</button></td>
			<td><button id="delOptionList" type="button" class="btn  btn-flat">-</button></td>
		</tr>
	</script>
</head>
<body>

	<div class="content">
  		<form:form modelAttribute="vw_prd_mst" class="form-signin" id="updateForm" name="updateForm" method="post" action="update.do" enctype="multipart/form-data">
  			<cf:token/>
      		<div class="box box-default">
        		<div class="box-header with-border">
          			<h3 class="box-title"><spring:message code="common.wd.상품관리" /> > <spring:message code="common.wd.상품수정" /></h3>
        		</div>
        		<!-- /.box-header -->
        		<div class="box-body">
          			<div class="row">
            			<div class="col-md-5">
							<div id="jstree_demo_div">
							</div>
            			</div>
            			<div class="col-md-2" style="vertical-align:middle;">
            				<div class="row">
            					<div class="col-md-12">
            						<div align="center"><button id="addCategory" type="button" class="btn  btn-flat"><spring:message code="common.wd.추가" /></button></div>
            					</div>
            				</div>
            				<div class="row">
            					<div class="col-md-12">            						
            					</div>
            				</div>
							<div class="row">
								<div class="col-md-12">
									<div align="center"><button id="delCategory" type="button" class="btn  btn-flat"><spring:message code="common.wd.삭제" /></button></div>
								</div>
							</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-5">
            				<div class="row">
            					<div class="col-md-12">
									<div class="box-header with-border">
	          							<h3 class="box-title"><spring:message code="common.wd.카테고리리스트" /> </h3>
	        						</div>
        						</div>
            				</div>
            				<div class="row">
								<div class="col-md-12">								
									<div class="box-body no-padding">
						              	<table class="table">
						                	<tbody>
							                	<tr>
							                  		<th style="width: 10px">#</th>
							                  		<th>카테고리명</th>
							                  		<th>현재카테고리번호</th>
							                  		<th>상위카테고리번호</th>
							                	</tr>
												<tbody id="cateList">
													<c:forEach var="vw_cate_mst" items="${vw_cate_mstList}" varStatus="status">
														<tr>
															<td><input type="checkbox" id="cateListSeq" value="${vw_cate_mst.cate_mst_seq}"/></td>
															<td>${vw_cate_mst.cate_name}</td>
															<td><input type="hidden" name="cateList" value="${vw_cate_mst.cate_mst_seq}"/>${vw_cate_mst.cate_mst_seq}</td>
															<td>${vw_cate_mst.cate_mst_seq_up}</td>
														</tr>														
													</c:forEach>
												</tbody>
						              		</tbody>
										</table>
						            </div>
								</div>
            				</div>
            			</div>
            			<!-- /.col -->
					</div>
					<div class="row">
            			<div class="col-md-12"><hr/></div>
					</div>
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.회원아이디" /></label></div>
									<div class="col-md-10">
										<form:errors path="member_id" cssClass="text-red" element="div"/>
										<div class="row">
											<div class="col-md-6">
												<form:input path="member_id" type="text" class="form-control" maxlength="30" style="width: 100%;" readonly="true"/>
											</div>
											<div class="col-md-6">
												<button type="button" class="btn btn-info btn-flat" data-toggle="modal" data-target="#popSchMemberId"><spring:message code="common.wd.찾기" /></button>
											</div>
										</div>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.회원번호" /></label></div>
									<div class="col-md-10">
										<form:errors path="member_seq" cssClass="text-red" element="div"/>
										<form:input path="member_seq" type="text" class="form-control" maxlength="20" style="width: 100%;" readonly="true"/>
									</div>
								</div>
	              			</div>
            			</div>
            			<!-- /.col -->
					</div>
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.상품명" /></label></div>
									<div class="col-md-10">
										<form:errors path="prd_name" cssClass="text-red" element="div"/>
										<form:input path="prd_name" type="text" class="form-control" maxlength="200" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.입고가" /></label></div>
									<div class="col-md-10">
										<form:errors path="prd_in_price" cssClass="text-red" element="div"/>
										<form:input path="prd_in_price" type="text" class="form-control" maxlength="20" style="width: 100%;"/>
									</div>
								</div>
	              			</div>
            			</div>
            			<!-- /.col -->
					</div>
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.판매가" /></label></div>
									<div class="col-md-10">
										<form:errors path="prd_sl_price" cssClass="text-red" element="div"/>
										<form:input path="prd_sl_price" type="text" class="form-control" maxlength="20" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.시장가" /></label></div>
									<div class="col-md-10">
										<form:errors path="prd_mk_price" cssClass="text-red" element="div"/>
										<form:input path="prd_mk_price" type="text" class="form-control" maxlength="20" style="width: 100%;"/>
									</div>
								</div>
	              			</div>
            			</div>
            			<!-- /.col -->
					</div>
          			<div class="row">
            			<div class="col-md-12">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-1"><label><spring:message code="common.wd.태그명" /></label></div>
									<div class="col-md-10">
										<form:errors path="tag_name" cssClass="text-red" element="div"/>
										<form:input path="tag_name" type="text" class="form-control" maxlength="200" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
					</div>            		
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.메인이미지" /></label></div>
									<div class="col-md-10">
										<form:errors path="img_main_file" cssClass="text-red" element="div"/>									
										<form:input path="img_main_file" type="file" class="form-control" maxlength="200" style="width: 100%;" data-show-preview="false"/>
										<c:if test="${(vw_prd_mst.img_main_path != null) && (vw_prd_mst.img_main_path != '')}">
											<img src="${pageContext.request.contextPath}/upload/${vw_prd_mst.img_main_path}" width="100" height="100"/>
										</c:if>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.썸네일이미지" /></label></div>
									<div class="col-md-10">
										<form:errors path="img_thum_file" cssClass="text-red" element="div"/>
										<form:input path="img_thum_file" type="file" class="form-control" maxlength="200" style="width: 100%;" data-show-preview="false"/>
										<c:if test="${(vw_prd_mst.img_thum_path != null) && (vw_prd_mst.img_thum_path != '')}">
											<img src="${pageContext.request.contextPath}/upload/${vw_prd_mst.img_thum_path}" width="100" height="100"/>
										</c:if>
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
									<div class="col-md-2"><label><spring:message code="common.wd.서브1이미지" /></label></div>
									<div class="col-md-10">
										<form:errors path="img_sub1_file" cssClass="text-red" element="div"/>									
										<form:input path="img_sub1_file" type="file" class="form-control" maxlength="200" style="width: 100%;" data-show-preview="false"/>
										<c:if test="${(vw_prd_mst.img_sub1_path != null) && (vw_prd_mst.img_sub1_path != '')}">
											<img src="${pageContext.request.contextPath}/upload/${vw_prd_mst.img_sub1_path}" width="100" height="100"/>
										</c:if>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.서브2이미지" /></label></div>
									<div class="col-md-10">
										<form:errors path="img_sub2_file" cssClass="text-red" element="div"/>
										<form:input path="img_sub2_file" type="file" class="form-control" maxlength="200" style="width: 100%;" data-show-preview="false"/>
										<c:if test="${(vw_prd_mst.img_sub2_path != null) && (vw_prd_mst.img_sub2_path != '')}">
											<img src="${pageContext.request.contextPath}/upload/${vw_prd_mst.img_sub2_path}" width="100" height="100"/>
										</c:if>
									</div>
								</div>
	              			</div>
            			</div>
            			<!-- /.col -->
					</div>
					<div class="row">
            			<div class="col-md-12">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-1"><label><spring:message code="common.wd.상품상태" /></label></div>
									<div class="col-md-10">
										<form:errors path="prd_status" cssClass="text-red" element="div"/>
										<cf:common_code_radio code_group_id="PRD_STATUS" tag_name="prd_status" tag_id="prd_status" tag_value="${vw_prd_mst.prd_status}"></cf:common_code_radio>
									</div>
								</div>
              				</div>
            			</div>
            		</div>					
					<div class="row">
            			<div class="col-md-12">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-1"><label><spring:message code="common.wd.옵션사용여부" /></label></div>
									<div class="col-md-10">
										<form:errors path="is_opt_use" cssClass="text-red" element="div"/>
										<cf:common_code_radio code_group_id="IS_OPT_USE" tag_name="is_opt_use" tag_id="is_opt_use" tag_value="${vw_prd_mst.is_opt_use}"></cf:common_code_radio>
									</div>
								</div>
              				</div>
            			</div>
            		</div>
					<div class="row" id="optionListArea">
            			<div class="col-md-12">
							<div class="box-body no-padding">
								<table class="table">
									<tbody>
										<tr>
											<th width="10%">옵션그룹</th>
											<th>옵션아이디</th>
											<th width="30%">옵션명</th>
											<th>매입가</th>
											<th>판매가</th>
											<th>정열순서</th>
											<th>추가</th>
											<th>삭제</th>
										</tr>
										<tbody id="optionList">
											<c:forEach var="tbl_prd_opt" items="${tbl_prd_optList}" varStatus="status">
												<tr>
													<td>
														<select name="opt_group_idList" style="width: 100%;" class="form-control">
															<c:forEach var="tbl_opt_group" items="${tbl_opt_groupList}" varStatus="status">
																<option value="${tbl_opt_group.opt_group_id}" ${tbl_opt_group.opt_group_id eq tbl_prd_opt.opt_group_id ? 'selected' : ''}>${tbl_opt_group.opt_group_name}</option>
															</c:forEach>
														</select>
													</td>
													<td><input type="text" name="prd_opt_idList" value="${tbl_prd_opt.prd_opt_id}" maxlength="10" style="width: 100%;" class="form-control"/></td>
													<td><input type="text" name="prd_opt_nameList" value="${tbl_prd_opt.prd_opt_name}" maxlength="100" style="width: 100%;" class="form-control"/></td>
													<td><input type="text" name="prd_opt_in_priceList" value="${tbl_prd_opt.prd_opt_in_price}" maxlength="11" style="width: 100%;" class="form-control"/></td>
													<td><input type="text" name="prd_opt_sl_priceList" value="${tbl_prd_opt.prd_opt_sl_price}" maxlength="11" style="width: 100%;" class="form-control"/></td>
													<td><input type="text" name="orderbyList" value="${tbl_prd_opt.orderby}" maxlength="1" style="width: 100%;" class="form-control"/></td>			
													<td><button id="addOptionList" type="button" class="btn  btn-flat">+</button></td>
													<td><button id="delOptionList" type="button" class="btn  btn-flat">-</button></td>
												</tr>
											</c:forEach>
										</tbody>
									</tbody>
								</table>
							</div>
            			</div>
            		</div>					
					<!-- /.row -->
          			<div class="row">
            			<div class="col-md-12">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-1"><label><spring:message code="common.wd.상품요약" /></label></div>
									<div class="col-md-11">
										<form:errors path="prd_summary" cssClass="text-red" element="div"/>
										<form:textarea path="prd_summary" rows="2" class="form-control" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
					</div>
					<!-- /.row -->
          			<div class="row">
            			<div class="col-md-12"> 
              				<div class="form-group">
								<div class="row">
									<div class="col-md-12"><label><spring:message code="common.wd.상품설명" /></label></div>
									<div class="col-md-12">
										<form:errors path="prd_content" cssClass="text-red" element="div"/>
										<form:textarea path="prd_content" rows="10" class="form-control" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
					</div>
					<!-- /.row -->
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
	
	<div class="modal" id="popSchMemberId" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"><spring:message code="common.wd.회원아이디검색" /></h4>
				</div>
				<div class="modal-body">
          			<div class="row">
						<div class="col-md-2"><label><spring:message code="common.wd.회원아이디" /></label></div>
						<div class="col-md-8">										
							<input id="schMemberId" type="text" class="form-control" maxlength="100" style="width: 100%;"/>
						</div>
						<div class="col-md-2"><button id="popBtnMemberId" class="btn btn-default btn-flat" style="width: 100%;"><spring:message code="common.wd.찾기" /></button></div>
					</div>
				</div>
					<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
  	</div>
</body>