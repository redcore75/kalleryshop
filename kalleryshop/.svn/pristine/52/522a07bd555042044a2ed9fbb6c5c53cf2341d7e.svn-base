<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
String banner_mgr_seq = (String) request.getParameter("banner_mgr_seq");

BannerService bannerService = (BannerService) wac.getBean(BannerService.class);
List bannerList = bannerService.getVw_bannerListByBanner_mgr_seq(Long.parseLong(banner_mgr_seq));
request.setAttribute("bannerList", bannerList);
%>
<div class="swiper-viewport">
	<div id="slideshow" class="swiper-container">
		<div class="swiper-wrapper">
			<c:forEach items="${bannerList}" var="list">
				<div class="swiper-slide">
					<div class="sw_img"><img src="${pageContext.request.contextPath}/upload/${list.img_path}" class="img-responsive"/></div>
				</div>
			</c:forEach>
		</div>		
		<div class="swiper-pager">
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
		</div>
	</div>
	<div class="swiper-pagination slideshow0"></div>
</div>
	
<script type="text/javascript">
	$('#slideshow').swiper({
		mode: 'horizontal',
		slidesPerView: 1,
		pagination: '.slideshow0',
		paginationClickable: true,
		nextButton: '.swiper-button-next',
	    prevButton: '.swiper-button-prev',
	    spaceBetween: 30,
		autoplay: 2500,
	    autoplayDisableOnInteraction: true,
		loop: true
	});
</script>