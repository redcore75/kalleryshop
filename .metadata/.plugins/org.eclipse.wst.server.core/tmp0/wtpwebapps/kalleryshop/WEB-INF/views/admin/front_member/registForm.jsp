<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
%>
<head>	 				
	<script type="text/javascript">
		var checkMemberIdDupYn = false;
		var checkMemberNickNameDupYn = false;
		
		$(document).ready(function(){
			$("#checkMemberIdDup").click(function(){
				var member_id = $("#member_id").val();
				if(member_id == "") {
					alert('<spring:message code="common.st.아이디를입력하세요" />');
				} else {
					$.ajax({
						url:"${pageContext.request.contextPath}/api/external/checkMemberId.do?member_id=" + member_id,
						type:"GET",
						data: {},
						dataType:"json",
						cache:false,
						success:function(data){
							if(data.result_code == 0000) {
								$("#member_id").val("");
								alert('<spring:message code="common.st.사용중인아이디입니다" />');
								checkMemberIdDupYn = false;
							} else {
								alert('<spring:message code="common.st.사용가능한아이디입니다" />');
								checkMemberIdDupYn = true;
							}
						},
						error : function(request, status, error) {
							alert("code : " + request.status + "\r\nmessage : " + request.responseText + "\r\nerror : " + error);
						}
					});
				}
			});
			
			$("#checkMemberNickNameDup").click(function(){
				var member_nick_name = $("#member_nick_name").val();
				if(member_nick_name == "") {
					alert('<spring:message code="common.st.닉네임을입력하세요" />');
				} else {
					$.ajax({
						url:"${pageContext.request.contextPath}/api/external/checkMemberNickName.do?member_nick_name=" + member_nick_name,
						type:"GET",
						data: {},
						dataType:"json",
						cache:false,
						success:function(data){
							if(data.result_code == 0000) {
								$("#member_nick_name").val("");
								alert('<spring:message code="common.st.사용중인닉네임입니다" />');								
								checkMemberNickNameDupYn = false;
							} else {
								alert('<spring:message code="common.st.사용가능한닉네임입니다" />');
								checkMemberNickNameDupYn = true;
							}
						},
						error : function(request, status, error) {
							alert("code : " + request.status + "\r\nmessage : " + request.responseText + "\r\nerror : " + error);
						}
					});
				}
			});
			
			$("#btnSubmit").click(function(){
				if(checkMemberIdDupYn) {
					if(checkMemberNickNameDupYn) {
						$("#btnSubmit").attr("disabled", true);
						$("#registForm").submit();
					} else {
						alert('<spring:message code="common.st.닉네임을중복체크하세요" />');
					}
				} else {
					alert('<spring:message code="common.st.아이디를중복체크하세요" />');
				}
			});
		});
	</script>
</head>
<body>

	<div class="content">
  		<form:form modelAttribute="tbl_member" class="form-signin" id="registForm" name="registForm" method="post" action="regist.do">
  			<cf:token/>
  			<form:input path="member_type" type="hidden" value="F"/>
      		<div class="box box-default">
        		<div class="box-header with-border">
          			<h3 class="box-title"><spring:message code="common.wd.회원관리" /> > <spring:message code="common.wd.회원등록" /></h3>
        		</div>
        		<!-- /.box-header -->
        		<div class="box-body">
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.회원아이디" /></label></div>
									<div class="col-md-10">
										<form:errors path="member_id" cssClass="text-red" element="div"/>
										<div class="row">
											<div class="col-md-6">
												<form:input path="member_id" type="text" class="form-control" maxlength="30" style="width: 100%;"/>
											</div>
											<div class="col-md-2">
												<button id="checkMemberIdDup" type="button" class="btn btn-info btn-flat"><spring:message code="common.wd.중복체크" /></button>
											</div>
											<div class="col-md-4">
												(<spring:message code="common.wd.이메일형식" />)
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
									<div class="col-md-2"><label><spring:message code="common.wd.비밀번호" /></label></div>
									<div class="col-md-10">
										<form:errors path="password" cssClass="text-red" element="div"/>
										<form:input path="password" type="password" class="form-control" maxlength="100" style="width: 100%;"/>
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
									<div class="col-md-2"><label><spring:message code="common.wd.회원명" /></label></div>
									<div class="col-md-10">
										<form:errors path="member_name" cssClass="text-red" element="div"/>
										<form:input path="member_name" type="text" class="form-control" maxlength="50" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.이메일" /></label></div>
									<div class="col-md-10">
										<form:errors path="email_addr" cssClass="text-red" element="div"/>
										<form:input path="email_addr" type="text" class="form-control" maxlength="30" style="width: 100%;"/>
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
									<div class="col-md-2"><label><spring:message code="common.wd.닉네임" /></label></div>
									<div class="col-md-10">
										<form:errors path="member_nick_name" cssClass="text-red" element="div"/>
            							<div class="row">
            								<div class="col-md-6">
												<form:input path="member_nick_name" type="text" class="form-control" maxlength="50" style="width: 100%;"/>
            								</div>
            								<div class="col-md-6">
	            								<button id="checkMemberNickNameDup" type="button" class="btn btn-info btn-flat"><spring:message code="common.wd.중복체크" /></button>
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
									<div class="col-md-2"><label><spring:message code="common.wd.생년월일" /></label></div>
									<div class="col-md-10">										
			            				<form:errors path="birthday" cssClass="text-red" element="div"/>
			            				<div class="input-group date">
			            					<div class="input-group-addon"><i class="fa fa-calendar"></i></div>
			            					<form:input path="birthday" type="text" class="form-control datepicker input-lg" maxlength="8" data-date-start-view="decade" data-date-format="yyyymmdd" data-date="19990101" placeholder="YYYYMMDD" style="width: 100%;" readonly="true"/>            					
			            				</div>										
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
									<div class="col-md-2"><label><spring:message code="common.wd.회원레벨" /></label></div>
									<div class="col-md-10">
										<form:errors path="member_level_seq" cssClass="text-red" element="div"/>
										<form:select path="member_level_seq" class="form-control" style="width: 100%;">
											<form:option value="0">---<spring:message code="common.st.선택하세요" />---</form:option>
											<form:option value="11"><spring:message code="common.wd.회원" /> (<spring:message code="common.wd.정상" />)</form:option>
										</form:select>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.전화번호" /></label></div>
									<div class="col-md-10">
										<form:errors path="mobile_num" cssClass="text-red" element="div"/>
										<form:input path="mobile_num" type="text" class="form-control" maxlength="12" style="width: 100%;"/>
									</div>
								</div>
	              			</div>
            			</div>
            			<!-- /.col -->
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
					<button type="submit" id="btnSubmit" class="btn btn-default btn-flat"><spring:message code="common.wd.등록하기" /></button>
					<a href="searchList.do"><button type="button" class="btn btn-default btn-flat"><spring:message code="common.wd.목록으로" /></button></a>
				</div>
			</div>
		</div>		
	</div>
	<!-- /.content -->
	
</body>