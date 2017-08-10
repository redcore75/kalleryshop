package kr.co.redcore.service.banner;

import kr.co.redcore.domain.Tbl_banner;
import kr.co.redcore.domain.view.Vw_banner;
import kr.co.redcore.mapper.Tbl_bannerMapper;
import kr.co.redcore.service.PageObject;
import kr.co.redcore.util.PageHelper;
import kr.co.redcore.util.ParamMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BannerService extends PageObject {
	private static final Logger logger = LoggerFactory.getLogger(BannerService.class);
	
//	@Autowired
//	private EmailService emailService;
	
	@Autowired
	private Tbl_bannerMapper tbl_bannerMapper;
	
	public Vw_banner getVw_bannerByBanner_seq(long banner_seq) throws Exception {
		return tbl_bannerMapper.getVw_bannerByBanner_seq(banner_seq);
	}
	
	public PageHelper getPageHelperByParamEtc(ParamMap paramMap, PageHelper pageHelper) throws Exception {
		pageHelper.setTotalRows(tbl_bannerMapper.getPageHelperCntByParamMap(paramMap));
		pageHelper.setList(tbl_bannerMapper.getPageHelperListByParamMapEtc(pageHelper.getStartRow() - 1, pageHelper.getPageSize(), paramMap));

		return pageHelper;
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int insertTbl_banner(Tbl_banner tbl_banner) throws Exception {
		return tbl_bannerMapper.insertTbl_banner(tbl_banner);
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int updateTbl_banner(Tbl_banner tbl_banner) throws Exception {
		return tbl_bannerMapper.updateTbl_banner(tbl_banner);
	}
}
