<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
%>
<head>	 				
	<script type="text/javascript">
		var objCurrBnrMgrHm = {}; // 배너관리번호검색결과 변수
	
		$(document).ready(function(){
			$("#popBtnBnrName").click(function(){
				var schBannerName = $("#schBannerName").val();				
				$.ajax({
					url:"${pageContext.request.contextPath}/api/external/getBannerMgrList.do?banner_name=" + schBannerName,
					type:"GET",
					data: {},
					dataType:"json",
					cache:false,
					success:function(data){
						if(data.result_code == 0000) {
							for(i = 0; i < data.result_data.length; i++) {
								var obj = new Object();
								obj['banner_mgr_seq'] = data.result_data[i].banner_mgr_seq;
								obj['banner_name'] = data.result_data[i].banner_name;
								$('#bnrMgrListData').tmpl(obj).appendTo("#popBnrMgrList");
								
								objCurrBnrMgrHm[data.result_data[i].banner_mgr_seq] = obj;
							}
						} else {
							alert('<spring:message code="common.st.배너관리번호가존재하지않습니다" />');
						}
					},
					error : function(request, status, error) {
						alert("code : " + request.status + "\r\nmessage : " + request.responseText + "\r\nerror : " + error);
					}
				});
			});
			
			$("#popBtnSltBnrMgr").click(function(){
				$("#bnrMgrListSeq:checked").each(function() {
					var obj = objCurrBnrMgrHm[$(this).val()]; // 배너관리번호결과 변수에서 선택한 데이타 추출					
					$("#banner_mgr_seq").val(obj['banner_mgr_seq']);
					$("#banner_name").val(obj['banner_name']);
				});
			});			
			
			$("#btnSubmit").click(function(){
				$("#btnSubmit").attr("disabled", true);
				$("#registForm").submit();
			});
		});
		
		function showPopSchBnrMgr() {
			$("#popBnrMgrList").html(""); // 배너관리번호검색결과 초기화
			objCurrPrdsHm = {}; // 배너관리번호 변수 초기화
			$($("#popSchBnrMgr").attr("data-target", "#popSchBnrMgr")).modal("show");
		}		
	</script>
	
	<script id="bnrMgrListData" type="text/x-jquery-tmpl">
		<tr>
			<td><input type="radio" id="bnrMgrListSeq" value="{{= banner_mgr_seq}}"/></td>
			<td>{{= banner_mgr_seq}}</td>
			<td>{{= banner_name}}</td>
		</tr>
	</script>
</head>
<body>

	<div class="content">
  		<form:form modelAttribute="vw_banner" class="form-signin" id="registForm" name="registForm" method="post" action="regist.do" enctype="multipart/form-data">
  			<cf:token/>
      		<div class="box box-default">
        		<div class="box-header with-border">
          			<h3 class="box-title"><spring:message code="common.wd.배너관리" /> > <spring:message code="common.wd.배너상세등록" /></h3>
        		</div>
        		<!-- /.box-header -->
        		<div class="box-body">
          			
					<!-- /.row -->
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.배너관리번호" /></label></div>
									<div class="col-md-10">
										<form:errors path="banner_mgr_seq" cssClass="text-red" element="div"/>
										<div class="row">
											<div class="col-md-6">
												<form:input path="banner_mgr_seq" type="text" class="form-control" maxlength="20" style="width: 100%;" readonly="true"/>
											</div>
											<div class="col-md-6">
												<button type="button" class="btn btn-info btn-flat" data-toggle="modal" onclick="showPopSchBnrMgr()"><spring:message code="common.wd.찾기" /></button>
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
									<div class="col-md-2"><label><spring:message code="common.wd.배너명" /></label></div>
									<div class="col-md-10">
										<form:errors path="banner_name" cssClass="text-red" element="div"/>
										<form:input path="banner_name" type="text" class="form-control" maxlength="100" style="width: 100%;" readonly="true"/>
									</div>
								</div>
	              			</div>
            			</div>
            			<!-- /.col -->
					</div>
					<!-- /.row -->
          			<div class="row">
            			<div class="col-md-12">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-1"><label><spring:message code="common.wd.URL경로" /></label></div>
									<div class="col-md-11">
										<form:errors path="url_addr" cssClass="text-red" element="div"/>
										<form:input path="url_addr" type="text" class="form-control" maxlength="500" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
					</div>
					<!-- /.row -->
          			<div class="row">
            			<div class="col-md-12">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-1"><label><spring:message code="common.wd.배너내용" /></label></div>
									<div class="col-md-11">
										<form:errors path="text_data" cssClass="text-red" element="div"/>
										<form:textarea path="text_data" rows="2" class="form-control" style="width: 100%;"/>
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
									<div class="col-md-1"><label><spring:message code="common.wd.배너이미지" /></label></div>
									<div class="col-md-11">
										<form:errors path="img_file" cssClass="text-red" element="div"/>
										<form:input path="img_file" type="file" class="form-control" maxlength="200" style="width: 100%;" data-show-preview="false"/>
									</div>
								</div>
              				</div>
            			</div>
					</div>
				</div>
        		<!-- /.box-body -->
      		</div>
      		<!-- /.box -->
		</form:form>
		
		<div class="row">
			<div class="col-md-12">
				<div align="right">
					<button type="submit" id="btnSubmit" class="btn btn-default btn-flat"><spring:message code="common.wd.등록하기" /></button>
					<a href="searchList.do"><button type="button" class="btn btn-default btn-flat"><spring:message code="common.wd.목록으로" /></button></a>
				</div>
			</div>
		</div>
	</div>
	<!-- /.content -->
	
	<div class="modal" id="popSchBnrMgr" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"><spring:message code="common.wd.배너관리번호검색" /></h4>
				</div>
				<div class="modal-body">
          			<div class="row">
						<div class="col-md-2"><label><spring:message code="common.wd.배너명" /></label></div>
						<div class="col-md-8">
							<input id="schBannerName" type="text" class="form-control" maxlength="100" style="width: 100%;"/>
						</div>
						<div class="col-md-2"><button id="popBtnBnrName" class="btn btn-default btn-flat" style="width: 100%;"><spring:message code="common.wd.찾기" /></button></div>						
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
											<th width="30%">베너관리번호</th>
											<th>배너명</th>
										</tr>
										<tbody id="popBnrMgrList"></tbody>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
					<div class="modal-footer">
					<button type="button" id="popBtnSltBnrMgr" class="btn btn-default" data-dismiss="modal"><spring:message code="common.wd.선택하기" /></button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
  	</div>
	
</body>