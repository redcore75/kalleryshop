<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
%>
<head>
  	<script src="http://cdn.tinymce.com/4/tinymce.min.js"></script>
  	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
  	<script>tinymce.init({ selector:'textarea#prd_content' });</script>
	<script type="text/javascript">		
		$(document).ready(function(){						
			$("#btnSubmit").click(function(){
				$("#btnSubmit").attr("disabled", true);
				$("#updateForm").submit();
			});
		});
		
	    function execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var fullAddr = ""; // 최종 주소 변수
	                var extraAddr = ""; // 조합형 주소 변수

	                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === "R") { // 사용자가 도로명 주소를 선택했을 경우
	                    fullAddr = data.roadAddress;	
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    fullAddr = data.jibunAddress;
	                }
	
	                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
	                if(data.userSelectedType === "R"){
	                    //법정동명이 있을 경우 추가한다.
	                    if(data.bname !== ""){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있을 경우 추가한다.
	                    if(data.buildingName !== ""){
							extraAddr += (extraAddr !== "" ? ", " + data.buildingName : data.buildingName);
	                    }
	                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
	                    fullAddr += (extraAddr !== "" ? " (" + extraAddr + ")" : "");
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                $("#cp_zipcode").val(data.zonecode); //5자리 새우편번호 사용
	                $("#cp_address1").val(fullAddr);
	
	                // 커서를 상세주소 필드로 이동한다.
	                $("#cp_address2").focus();
	            }
	        }).open();
	    }
	</script>
</head>
<body>

	<div class="content">
  		<form:form modelAttribute="tbl_shop_env" class="form-signin" id="updateForm" name="updateForm" method="post" action="update.do">
  			<cf:token/>
      		<div class="box box-default">
        		<div class="box-header with-border">
          			<h3 class="box-title"><spring:message code="common.wd.기본설정" /> > <spring:message code="common.wd.기본정보" /></h3>
        		</div>
        		<!-- /.box-header -->
        		<div class="box-body">
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.쇼핑몰ID" /></label></div>
									<div class="col-md-10">
										<form:errors path="shop_id" cssClass="text-red" element="div"/>
										<div class="row">
											<div class="col-md-6">
												<form:input path="shop_id" type="text" class="form-control" maxlength="20" style="width: 100%;" readonly="true"/>
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
									<div class="col-md-2"><label><spring:message code="common.wd.쇼핑몰명" /></label></div>
									<div class="col-md-10">
										<form:errors path="shop_name" cssClass="text-red" element="div"/>
										<form:input path="shop_name" type="text" class="form-control" maxlength="100" style="width: 100%;"/>
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
									<div class="col-md-2"><label><spring:message code="common.wd.쇼핑몰제목" /></label></div>
									<div class="col-md-10">
										<form:errors path="shop_title" cssClass="text-red" element="div"/>
										<form:input path="shop_title" type="text" class="form-control" maxlength="200" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.통신판매신고번호" /></label></div>
									<div class="col-md-10">
										<form:errors path="shop_lic_num" cssClass="text-red" element="div"/>
										<form:input path="shop_lic_num" type="text" class="form-control" maxlength="20" style="width: 100%;"/>
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
									<div class="col-md-2"><label><spring:message code="common.wd.회사명" /></label></div>
									<div class="col-md-10">
										<form:errors path="cp_name" cssClass="text-red" element="div"/>
										<form:input path="cp_name" type="text" class="form-control" maxlength="100" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.사업자번호" /></label></div>
									<div class="col-md-10">
										<form:errors path="cp_biz_num" cssClass="text-red" element="div"/>
										<form:input path="cp_biz_num" type="text" class="form-control" maxlength="10" style="width: 100%;"/>
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
									<div class="col-md-2"><label><spring:message code="common.wd.대표자명" /></label></div>
									<div class="col-md-10">
										<form:errors path="cp_ceo_name" cssClass="text-red" element="div"/>
										<form:input path="cp_ceo_name" type="text" class="form-control" maxlength="100" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.대표자이메일" /></label></div>
									<div class="col-md-10">
										<form:errors path="cp_ceo_email_addr" cssClass="text-red" element="div"/>
										<form:input path="cp_ceo_email_addr" type="text" class="form-control" maxlength="30" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
					</div>
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.업태" /></label></div>
									<div class="col-md-10">
										<form:errors path="cp_biz_type" cssClass="text-red" element="div"/>									
										<form:input path="cp_biz_type" type="text" class="form-control" maxlength="50" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.종목" /></label></div>
									<div class="col-md-10">
										<form:errors path="cp_biz_part" cssClass="text-red" element="div"/>
										<form:input path="cp_biz_part" type="text" class="form-control" maxlength="50" style="width: 100%;"/>
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
									<div class="col-md-2"><label><spring:message code="common.wd.우편번호" /></label></div>
									<div class="col-md-10">
										<form:errors path="cp_zipcode" cssClass="text-red" element="div"/>
										<div class="row">																			
											<div class="col-md-6">
												<form:input path="cp_zipcode" type="text" class="form-control" maxlength="5" style="width: 100%;"/>
											</div>
											<div class="col-md-6">
												<button type="button" class="btn btn-info btn-flat" onclick="execDaumPostcode()"><spring:message code="common.wd.찾기" /></button>
											</div>
										</div>
									</div>
								</div>
              				</div>
            			</div>
            		</div>
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.주소1" /></label></div>
									<div class="col-md-10">
										<form:errors path="cp_address1" cssClass="text-red" element="div"/>									
										<form:input path="cp_address1" type="text" class="form-control" maxlength="200" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.주소2" /></label></div>
									<div class="col-md-10">
										<form:errors path="cp_address2" cssClass="text-red" element="div"/>									
										<form:input path="cp_address2" type="text" class="form-control" maxlength="200" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>            			
            		</div>
            		
            		<div class="row">
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.대표전화" /></label></div>
									<div class="col-md-10">
										<form:errors path="cp_phone_num" cssClass="text-red" element="div"/>
										<form:input path="cp_phone_num" type="text" class="form-control" maxlength="12" style="width: 100%;"/>
									</div>
								</div>
	              			</div>
            			</div>
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.팩스번호" /></label></div>
									<div class="col-md-10">
										<form:errors path="cp_fax_num" cssClass="text-red" element="div"/>
										<form:input path="cp_fax_num" type="text" class="form-control" maxlength="12" style="width: 100%;"/>
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
									<div class="col-md-1"><label><spring:message code="common.wd.회사소개" /></label></div>
									<div class="col-md-11">
										<form:errors path="cp_intro_txt" cssClass="text-red" element="div"/>
										<form:textarea path="cp_intro_txt" rows="5" class="form-control" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
            		</div>
					<div class="row">
            			<div class="col-md-12"><hr/></div>
					</div>
					<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.고객센터전화번호" /></label></div>
									<div class="col-md-10">
										<form:errors path="cs_phone_num" cssClass="text-red" element="div"/>
										<form:input path="cs_phone_num" type="text" class="form-control" maxlength="12" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label><spring:message code="common.wd.고객센터팩스번호" /></label></div>
									<div class="col-md-10">
										<form:errors path="cs_fax_num" cssClass="text-red" element="div"/>
										<form:input path="cs_fax_num" type="text" class="form-control" maxlength="12" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>            			
            		</div>
					<div class="row">
            			<div class="col-md-12">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-1"><label><spring:message code="common.wd.고객센터이메일" /></label></div>
									<div class="col-md-11">
										<form:errors path="cs_email_addr" cssClass="text-red" element="div"/>
										<form:input path="cs_email_addr" type="text" class="form-control" maxlength="30" style="width: 100%;"/>
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
									<div class="col-md-1"><label><spring:message code="common.wd.고객센터운영시간" /></label></div>
									<div class="col-md-11">
										<form:errors path="cs_oper_dtime" cssClass="text-red" element="div"/>
										<form:textarea path="cs_oper_dtime" rows="2" class="form-control" style="width: 100%;"/>
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
				</div>
			</div>
		</div>
	</div>
	<!-- /.content -->
</body>