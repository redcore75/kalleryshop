<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
%>
<head>	 				
	<script type="text/javascript"> 
		$(document).ready(function(){
            $("input[name='sch_date_type']:radio").change(function(){
                //라디오 버튼 값을 가져온다.
                var serviceType = this.value;
                if(serviceType == "T") {
                	var today = new Date();
                    $("#sch_start_date" ).val(today.format("yyyyMMdd"));
                    $("#sch_end_date" ).val(today.format("yyyyMMdd"));
                } else if(serviceType == "W") {
                	var today = new Date();
                	var week = new Date(Date.parse(new Date()) - 7 * 1000 * 60 * 60 * 24);
                    $("#sch_start_date" ).val(week.format("yyyyMMdd"));
                    $("#sch_end_date" ).val(today.format("yyyyMMdd"));
                } else if(serviceType == "M") {
                	var today = new Date();
                	var month = new Date(Date.parse(new Date()) - 30 * 1000 * 60 * 60 * 24);
                    $("#sch_start_date" ).val(month.format("yyyyMMdd"));
                    $("#sch_end_date" ).val(today.format("yyyyMMdd"));                	
                }
            });
		});
	</script>
</head>
<body>

	<div class="content">
  		<form class="form-signin" id="searchList" name="searchList" method="post" action="searchList.do">
      		<div class="box box-default">
      			<!-- <spring:message code="error.send_email" />  -->
        		<div class="box-header with-border">
          			<h3 class="box-title"><spring:message code="common.wd.배너관리" /> > <spring:message code="common.wd.배너상세리스트" /></h3>
        		</div>
        		<!-- /.box-header -->
        		<div class="box-body">
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.배너관리번호" /></label></div>
									<div class="col-md-10"><input type="text" id="sch_banner_mgr_seq" name="sch_banner_mgr_seq" class="form-control" style="width: 100%;" value="${paramMap.sch_banner_mgr_seq}"/></div>
								</div>
              				</div>
            			</div>          			
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.배너명" /></label></div>
									<div class="col-md-10"><input type="text" id="sch_banner_name" name="sch_banner_name" class="form-control" style="width: 100%;" value="${paramMap.sch_banner_name}"/></div>
								</div>
              				</div>
            			</div>
					</div>
					<!-- /.row -->
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.검색기간" /></label></div>
									<div class="col-md-10">
          								<div class="row">
          									<div class="col-md-3">
          										<div class="input-group date">
													<div class="input-group-addon"><i class="fa fa-calendar"></i></div>
													<input type="text" id="sch_start_date" name="sch_start_date" class="form-control datepicker" style="width: 100%;" value="${paramMap.sch_start_date}" readonly/>
												</div>
											</div>
											<div class="col-md-1" align="center">
												~
											</div>
											<div class="col-md-3">
          										<div class="input-group date">
													<div class="input-group-addon"><i class="fa fa-calendar"></i></div>
													<input type="text" id="sch_end_date" name="sch_end_date" class="form-control datepicker" style="width: 100%;" value="${paramMap.sch_end_date}" readonly/>
												</div>
											</div>
											<div class="col-md-5">
								                <label>
								                  <input type="radio" id="sch_date_type" name="sch_date_type" class="minimal-red" value="T"><spring:message code="common.wd.일별" />
								                </label>
								                <label>
								                  <input type="radio" id="sch_date_type" name="sch_date_type" class="minimal-red" value="W"><spring:message code="common.wd.주별" />
								                </label>
								                <label>
								                  <input type="radio" id="sch_date_type" name="sch_date_type" class="minimal-red" value="M"><spring:message code="common.wd.월별" />
								                </label>
                							</div>
										</div>
									</div>
              					</div>
            				</div>
						</div>
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
								</div>
	              			</div>
            			</div>
					</div>
					<!-- /.row -->
				</div>
				
        		<!-- /.box-body -->
        		<div class="box-footer pull-right">
					<button type="submit" class="btn btn-info"><spring:message code="common.wd.검색하기" /></button>
        		</div>
      		</div>
      		<!-- /.box -->
		</form>

      	<div class="row">
        	<div class="col-md-12">
          		<div class="box">
            		<div class="box-header">
              			<h3 class="box-title"><spring:message code="common.wd.총" /> ${pageHelper.totalRows} <spring:message code="common.wd.건" /></h3>
            		</div>
            		<!-- /.box-header -->
            		<div class="box-body">
              			<table id="example2" class="table table-bordered table-hover">
                			<thead>
                				<tr>
                					<th width="10%"><spring:message code="common.wd.배너상세번호" /></th>
                  					<th width="10%"><spring:message code="common.wd.배너관리번호" /></th>
                  					<th width="10%"><spring:message code="common.wd.배너명" /></th>
                  					<th width="10%"><spring:message code="common.wd.URL경로" /></th>
                  					<th width="10%"><spring:message code="common.wd.상태" /></th>
                  					<th width="10%"><spring:message code="common.wd.등록일" /></th>
                  					<th width="10%"><spring:message code="common.wd.수정일" /></th>
                				</tr>
                			</thead>
                			<tbody>
                				<c:forEach items="${pageHelper.list}" var="list">
	                				<tr>
	                					<td>${list.banner_seq}</td>
	                  					<td>${list.banner_mgr_seq}</td>
										<td><a href="updateForm.do?curr_page=${pageHelper.currPage}&banner_seq=${list.banner_seq}">${list.banner_name}</a></td>
	                  					<td>${list.url_addr}</td>
	                  					<td><cf:common_code_name code_group_id="IS_VALID" code_id="${list.is_valid}" /></td>
	                  					<td>${list.regdate}</td>
	                  					<td>${list.uptdate}</td>
	                				</tr>
                				</c:forEach>
                			</tbody>
              			</table>
            		</div>
            		<!-- /.box-body -->
          		</div>
          		<!-- /.box -->
        	</div>
        	<!-- /.col -->
      	</div>
      	<!-- /.row -->
    				
		<div class="row">
			<div class="col-md-6">
				<div align="center">
					<!--// Paging start -->
					<c:import url="/WEB-INF/views/common/paging.jsp">
						<c:param name="pageLink" value="searchList.do"></c:param>
						<c:param name="pageName" value="curr_page"></c:param>
						<c:param name="pageValue" value="<%=paramMap.remParam(\"curr_page\").remParam(\"start\").remParam(\"size\").getQueryString()%>"></c:param>
					</c:import>
					<!--// Paging end -->
				</div>
			</div>
			<div class="col-md-6">
				<div align="right">
					<a href="registForm.do"><button type="botton" class="btn btn-default btn-flat"><spring:message code="common.wd.등록하기" /></button></a>
					<button type="botton" class="btn btn-default btn-flat"><spring:message code="common.wd.엑셀파일" /></button>
				</div>
			</div>
		</div>	
	</div>
	<!-- /.content -->

</body>