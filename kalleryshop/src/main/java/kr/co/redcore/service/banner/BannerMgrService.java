package kr.co.redcore.service.banner;

import kr.co.redcore.GlobalConstants;
import kr.co.redcore.domain.Tbl_banner_mgr;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.exception.Member_id_dupException;
import kr.co.redcore.exception.Member_id_not_existException;
import kr.co.redcore.mapper.Tbl_banner_mgrMapper;
import kr.co.redcore.mapper.Tbl_memberMapper;
import kr.co.redcore.service.PageObject;
import kr.co.redcore.util.PageHelper;
import kr.co.redcore.util.ParamMap;
import kr.co.redcore.util.UserRand;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BannerMgrService extends PageObject {
	private static final Logger logger = LoggerFactory.getLogger(BannerMgrService.class);
	
//	@Autowired
//	private EmailService emailService;
	
	@Autowired
	private Tbl_banner_mgrMapper tbl_banner_mgrMapper;
		
	public Tbl_banner_mgr getTbl_banner_mgrByBanner_mgr_seq(long banner_mgr_seq) throws Exception {
		return tbl_banner_mgrMapper.getTbl_banner_mgrByBanner_mgr_seq(banner_mgr_seq);
	}
	
	public List getTbl_banner_mgrListByBanner_name(String banner_name) throws Exception {
		return tbl_banner_mgrMapper.getTbl_banner_mgrListByBanner_name(banner_name);
	}
	
	public PageHelper getPageHelperByParamEtc(ParamMap paramMap, PageHelper pageHelper) throws Exception {
		pageHelper.setTotalRows(tbl_banner_mgrMapper.getPageHelperCntByParamMap(paramMap));
		pageHelper.setList(tbl_banner_mgrMapper.getPageHelperListByParamMapEtc(pageHelper.getStartRow() - 1, pageHelper.getPageSize(), paramMap));

		return pageHelper;
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int insertTbl_banner_mgr(Tbl_banner_mgr tbl_banner_mgr) throws Exception {
		return tbl_banner_mgrMapper.insertTbl_banner_mgr(tbl_banner_mgr);
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int updateTbl_banner_mgr(Tbl_banner_mgr tbl_banner_mgr) throws Exception {
		return tbl_banner_mgrMapper.updateTbl_banner_mgr(tbl_banner_mgr);
	}
}
