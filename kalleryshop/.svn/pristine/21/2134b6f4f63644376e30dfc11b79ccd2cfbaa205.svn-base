package kr.co.redcore.service.member;

import kr.co.redcore.GlobalConstants;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.exception.Member_id_dupException;
import kr.co.redcore.exception.Member_id_not_existException;
import kr.co.redcore.mapper.Tbl_memberMapper;
import kr.co.redcore.service.PageObject;
import kr.co.redcore.util.PageHelper;
import kr.co.redcore.util.ParamMap;
import kr.co.redcore.util.UserRand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService extends PageObject {
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
//	@Autowired
//	private EmailService emailService;
	
	@Autowired
	private Tbl_memberMapper tbl_memberMapper;
	
	public long getTbl_memberCntByMember_id(String member_id) throws Exception {
		return tbl_memberMapper.getTbl_memberCntByMember_id(member_id);
	}
	
	public long getTbl_memberCntByMember_nick_name(String member_nick_name) throws Exception {
		return tbl_memberMapper.getTbl_memberCntByMember_nick_name(member_nick_name);
	}
	
	public Tbl_member getTbl_memberByMember_id(String member_id) throws Exception {
		return tbl_memberMapper.getTbl_memberByMember_id(member_id);
	}
	
	public Tbl_member getTbl_memberByMember_idEtc(String member_id, String password) throws Exception {
		return tbl_memberMapper.getTbl_memberByMember_idEtc(member_id, password);		
	}
	
	public PageHelper getPageHelperByParamEtc(ParamMap paramMap, PageHelper pageHelper) throws Exception {
		pageHelper.setTotalRows(tbl_memberMapper.getPageHelperCntByParamMap(paramMap));
		pageHelper.setList(tbl_memberMapper.getPageHelperListByParamMapEtc(pageHelper.getStartRow() - 1, pageHelper.getPageSize(), paramMap));

		return pageHelper;
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int insertTbl_member(Tbl_member tbl_member) throws Exception {
		long memberCount = tbl_memberMapper.getTbl_memberCntByMember_id(tbl_member.getMember_id());
		if(memberCount > 0) {
			// 중복된 아이디가 있을경우 에러발생
			throw new Member_id_dupException(tbl_member.getMember_id());
		} else {			
			return tbl_memberMapper.insertTbl_member(tbl_member);
		}
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int updateTbl_member(Tbl_member tbl_member) throws Exception {		
		return tbl_memberMapper.updateTbl_member(tbl_member);
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int updateTbl_memberForInfo(Tbl_member tbl_member) throws Exception {		
		return tbl_memberMapper.updateTbl_memberForInfo(tbl_member);
	}	
	
	@Transactional(rollbackFor = {Exception.class})
	public int updateTbl_memberForPassword(String member_id, String password) throws Exception {
		return tbl_memberMapper.updateTbl_memberForPassword(member_id, password);
	}
}
