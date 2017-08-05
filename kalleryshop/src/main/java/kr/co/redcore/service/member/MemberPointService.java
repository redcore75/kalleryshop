package kr.co.redcore.service.member;

import java.util.Properties;

import kr.co.redcore.GlobalConstants;
import kr.co.redcore.domain.Tbl_auth_num;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.domain.Tbl_member_access_log;
import kr.co.redcore.domain.Tbl_member_point;
import kr.co.redcore.mapper.Tbl_auth_numMapper;
import kr.co.redcore.mapper.Tbl_memberMapper;
import kr.co.redcore.mapper.Tbl_member_access_logMapper;
import kr.co.redcore.mapper.Tbl_member_pointMapper;
import kr.co.redcore.util.UserRand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberPointService {
	private static final Logger logger = LoggerFactory.getLogger(MemberPointService.class);
	
	@Autowired
	private Tbl_memberMapper tbl_memberMapper;		
	
	@Autowired
	private Tbl_member_pointMapper tbl_member_pointMapper;	
	
	@Autowired
	private Properties configProp;	
	
//	public boolean checkAuthNum(String auth_type, String auth_key, String auth_num) throws Exception {
//		Tbl_auth_num tbl_auth_num = tbl_auth_numMapper.getTbl_auth_numMaxByAuth_keyEtc(auth_key, auth_type);
//		if(tbl_auth_num.getAuth_num().equals(auth_num)) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
//	public String getAuthNum(String auth_type, String auth_key) throws Exception {
//		String auth_num = UserRand.randString(6, 32);
//		
//		Tbl_auth_num tbl_auth_num = new Tbl_auth_num();
//		tbl_auth_num.setAuth_type(auth_type);
//		tbl_auth_num.setAuth_key(auth_key);
//		tbl_auth_num.setAuth_num(auth_num);
//		tbl_auth_num.setRegby(auth_key);
//		tbl_auth_numMapper.insertTbl_auth_num(tbl_auth_num);
//		
//		return auth_num;
//	}
	
	@Transactional(rollbackFor = {Exception.class})
	public void buyOrderMemberPoint(String member_id, long buy_point) throws Exception {
		Tbl_member tbl_member = tbl_memberMapper.getTbl_memberByMember_id(member_id);
		
		long curr_point = tbl_member.getCurr_point() + buy_point;
		tbl_memberMapper.updateTbl_memberForCurr_point(member_id, curr_point);
		
		Tbl_member_point tbl_member_point = new Tbl_member_point();
		tbl_member_point.setMember_seq(tbl_member.getMember_seq());
		tbl_member_point.setUse_type(GlobalConstants.POINT_BUY);
		tbl_member_point.setPrev_point(tbl_member.getCurr_point());
		tbl_member_point.setUse_point(buy_point);
		tbl_member_point.setCurr_point(curr_point);				
		tbl_member_pointMapper.insertTbl_member_point(tbl_member_point);
	}
}
